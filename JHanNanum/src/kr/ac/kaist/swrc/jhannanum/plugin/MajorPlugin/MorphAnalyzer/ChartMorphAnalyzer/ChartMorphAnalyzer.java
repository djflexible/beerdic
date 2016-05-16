/*  Copyright 2010, 2011 Semantic Web Research Center, KAIST

This file is part of JHanNanum.

JHanNanum is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

JHanNanum is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with JHanNanum.  If not, see <http://www.gnu.org/licenses/>   */

package kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.MorphAnalyzer.ChartMorphAnalyzer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.PlainSentence;
import kr.ac.kaist.swrc.jhannanum.comm.SetOfSentences;
import kr.ac.kaist.swrc.jhannanum.plugin.MajorPlugin.MorphAnalyzer.MorphAnalyzer;
import kr.ac.kaist.swrc.jhannanum.share.JSONReader;
import kr.ac.kaist.swrc.jhannanum.share.TagSet;

/**
 * Chart-based Morphological Analyzer.
 * 
 * It is a morphological analyzer plug-in which is a major plug-in of phase 2 in HanNanum work flow.
 * This uses the lattice-style chart as a internal data structure, which makes it possible to
 * do morphological analysis without back tracking.
 * 
 * @author Sangwon Park (hudoni@world.kaist.ac.kr), CILab, SWRC, KAIST
 */
public class ChartMorphAnalyzer implements MorphAnalyzer {
	/** Name of this plug-in. */
	final static private String PLUG_IN_NAME = "MorphAnalyzer";

	/** Pre-analyzed dictionary. */
	private AnalyzedDic analyzedDic = null;
	
	/** Default morpheme dictionary. */
	private Trie systemDic = null;
	
	/** Additional morpheme dictionary that users can modify for their own purpose. */
	private Trie userDic = null;
	
	/** Number dictionary, which is actually a automata. */
	private NumberDic numDic = null;
	
	/** Morpheme tag set */
	private TagSet tagSet = null;
	
	/** Connection rules between morphemes. */
	private Connection connection = null;
	
	/** Impossible connection rules. */
	private ConnectionNot connectionNot = null;

	/** Lattice-style morpheme chart. */
	private MorphemeChart chart = null;
	
	/** SIMTI structure for reverse segment position. */
	private Simti simti = null;

	/** The file path for the impossible connection rules. */
	private String fileConnectionsNot = "";

	/** The file path for the connection rules. */
	private String fileConnections = "";

	/** The file path for the pre-analyzed dictionary. */
	private String fileDicAnalyzed = "";

	/** The file path for the default morpheme dictionary. */
	private String fileDicSystem = "";

	/** The file path for the user morpheme dictionary. */
	private String fileDicUser = "";

	/** The file path for the tag set. */
	private String fileTagSet = "";
	
	/** Eojeol list */
	private LinkedList<Eojeol> eojeolList = null;
	
	/** Post-processor to deal with some exceptions */
	private PostProcessor postProc = null;
	
	/**
	 * Returns the name of the morphological analysis plug-in.
	 * @return the name of the morphological analysis plug-in.
	 */
	public String getName() {
		return PLUG_IN_NAME;
	}
	
	/**
	 * It processes the input plain eojeol by analyzing it or searching the pre-analyzed dictionary.
	 * @param plainEojeol - plain eojeol to analyze
	 * @return the morphologically analyzed eojeol list
	 */
	private Eojeol[] processEojeol(String plainEojeol) {
		String analysis = analyzedDic.get(plainEojeol);

		eojeolList.clear();
		
		if (analysis != null) {
			// the eojeol was registered in the pre-analyzed dictionary
			StringTokenizer st = new StringTokenizer(analysis, "^");
			while (st.hasMoreTokens()) {
				String analyzed = st.nextToken();
				String[] tokens = analyzed.split("\\+|/");
				
				String[] morphemes = new String[tokens.length / 2];
				String[] tags = new String[tokens.length / 2];
				
				for (int i = 0, j = 0; i < morphemes.length; i++) {
					morphemes[i] = tokens[j++];
					tags[i] = tokens[j++];
				}
				Eojeol eojeol = new Eojeol(morphemes, tags);
				eojeolList.add(eojeol);
			}
		} else {
			// analyze the input plain eojeol
			chart.init(plainEojeol);
			chart.analyze();
			chart.getResult();
		}
		
		return eojeolList.toArray(new Eojeol[0]);
	}

	/**
	 * Analyzes the specified plain sentence, and returns all the possible analysis results.
	 * @return all the possible morphological analysis results
	 */
	@Override
	public SetOfSentences morphAnalyze(PlainSentence ps) {
		StringTokenizer st = new StringTokenizer(ps.getSentence(), " \t");
		
		String plainEojeol = null;
		int eojeolNum = st.countTokens();
		
		ArrayList<String> plainEojeolArray = new ArrayList<String>(eojeolNum);
		ArrayList<Eojeol[]> eojeolSetArray = new ArrayList<Eojeol[]>(eojeolNum);
				
		while (st.hasMoreTokens()) {
			plainEojeol = st.nextToken();
			
			plainEojeolArray.add(plainEojeol);
			eojeolSetArray.add(processEojeol(plainEojeol));
		}
		
		SetOfSentences sos = new SetOfSentences(ps.getDocumentID(), ps.getSentenceID(),
				ps.isEndOfDocument(), plainEojeolArray, eojeolSetArray);

		sos = postProc.doPostProcessing(sos);

		return sos;
	}

	/**
	 * Initializes the Chart-based Morphological Analyzer plug-in.
	 * @param baseDir - the path for base directory, which should have the 'conf' and 'data' directory
	 * @param configFile - the path for the configuration file (relative path to the base directory)
	 */
	@Override
	public void initialize(String baseDir, String configFile) throws Exception {
		JSONReader json = new JSONReader(configFile);
		
		fileDicSystem = baseDir + "/" + json.getValue("dic_system");
		fileDicUser = baseDir + "/" + json.getValue("dic_user");
		fileConnections = baseDir + "/" + json.getValue("connections");
		fileConnectionsNot = baseDir + "/" + json.getValue("connections_not");
		fileDicAnalyzed = baseDir + "/" + json.getValue("dic_analyzed");
		fileTagSet = baseDir + "/" + json.getValue("tagset");

		tagSet = new TagSet();
		tagSet.init(fileTagSet, TagSet.TAG_SET_KAIST);

		connection = new Connection();
		connection.init(fileConnections, tagSet.getTagCount(), tagSet);

		connectionNot = new ConnectionNot();
		connectionNot.init(fileConnectionsNot, tagSet);

		analyzedDic = new AnalyzedDic();
		analyzedDic.readDic(fileDicAnalyzed);

		systemDic = new Trie(Trie.DEFAULT_TRIE_BUF_SIZE_SYS);
		systemDic.read_dic(fileDicSystem, tagSet);

		userDic = new Trie(Trie.DEFAULT_TRIE_BUF_SIZE_USER);
		userDic.read_dic(fileDicUser, tagSet);

		numDic = new NumberDic();
		simti = new Simti();
		simti.init();
		eojeolList = new LinkedList<Eojeol>();
		
		chart = new MorphemeChart(tagSet, connection, systemDic, userDic, numDic, simti, eojeolList);
		
		postProc = new PostProcessor();
	}

	/**
	 * It is called right before the work flow ends.
	 */
	@Override
	public void shutdown() {
	}
}
