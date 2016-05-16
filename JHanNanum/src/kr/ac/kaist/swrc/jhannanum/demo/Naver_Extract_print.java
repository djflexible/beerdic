package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

public class Naver_Extract_print {

	public String target_page() throws SAXException, IOException,
			ParserConfigurationException {
		String Naver_MAIN = "";

		Naver_Extract_targetPage test = new Naver_Extract_targetPage();
		test.extract_targetPage();

		for (int i = 0; i < test.mainArray.size(); i++) {
			Document doc = Jsoup.connect(test.mainArray.get(i)).get();
			Elements titles2 = doc.select(".post-view p");
			for (Element f : titles2) {
				Naver_MAIN += f.text().replace("⊙", " ").replace("~", " ")
						.replace("ㅎ", " ").replace("ㅋ", " ").replace("♬", " ")
						.replace("^", " ").replace("ㅠ", " ").replace("ㅜ", " ")
						.replace(">", " ").replace("<", " ").replace("_", " ")
						.replace("(", " ").replace(")", " ").replace("♡", " ")
						.replace("+", " ").replace("ㅡ", " ")
						+ " ";
			}

		}
		return Naver_MAIN;

		// System.out.println(MAIN);

	}

}