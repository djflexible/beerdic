package kr.ac.kaist.swrc.jhannanum.plugin.SupplementPlugin.PosProcessor.NounExtractor;

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



import java.util.LinkedList;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.plugin.SupplementPlugin.PosProcessor.PosProcessor;

/**
 * This plug-in extracts the morphemes recognized as a verb after Part Of Speech tagging was done.
 * 
 * It is a POS Processor plug-in which is a supplement plug-in of phase 3 in HanNanum work flow.
 * 
 * @author Sangwon Park (hudoni@world.kaist.ac.kr), CILab, SWRC, KAIST
 */
public class VerbExtractor implements PosProcessor {//동사 형용사 추출
	/** the buffer for verb morphemes */
	private LinkedList<String> verbMorphemes = null;
	
	/** the buffer for tags of the morphemes */
	private LinkedList<String> verbTags = null;
	

	@Override
	public void initialize(String baseDir, String configFile) throws Exception {
		verbMorphemes = new LinkedList<String>();
		verbTags = new LinkedList<String>();
	}

	@Override
	public void shutdown() {
		
	}

	/**
	 * It extracts the morphemes which were recognized as verb after POS tagging.
	 * @param st - the POS tagged sentence
	 * @return the sentence in which only verbs were remained
	 */
	@Override
	public Sentence doProcess(Sentence st) {
		Eojeol[] eojeols = st.getEojeols();
		
		for (int i = 0; i < eojeols.length; i++) {
			String[] morphemes = eojeols[i].getMorphemes();
			String[] tags = eojeols[i].getTags();
			verbMorphemes.clear();
			verbTags.clear();
			
			for (int j = 0; j < tags.length; j++) {
			//	String ch = tags[j].substring(0, );
				char c = tags[j].charAt(0);
				if (c == 'p') {
					verbMorphemes.add(morphemes[j]);
					verbTags.add(tags[j]);
				} 
				else if (c == 'm') {
					verbMorphemes.add(morphemes[j]);
					verbTags.add("어미");
				}
			}
			
			eojeols[i].setMorphemes(verbMorphemes.toArray(new String[0]));
			eojeols[i].setTags(verbTags.toArray(new String[0]));
		}
		
		st.setEojeols(eojeols);
		
		return st;
	}
}
