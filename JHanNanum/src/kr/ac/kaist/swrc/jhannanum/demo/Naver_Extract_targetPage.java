package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

//블로거 아이디, 페이지 고유 logNo 값은 불러와
//http://blog.naver.com/PostView.nhn?blogId=블로거ID&logNo=로그값&beginTime=0&jumpingVid=&from=search&redirect=Log&widgetTypeCall=true
//형식으로 만든다
public class Naver_Extract_targetPage {

	ArrayList<String> mainArray = new ArrayList<String>();

	public void extract_targetPage() throws SAXException, IOException,
			ParserConfigurationException {
		Naver_Extract_logNo logNo = new Naver_Extract_logNo();
		logNo.extract_logNo();
		// Extract_blogID use_blogID = new Extract_blogID(); // 객체 생성
		// Extract_logNo use_logNo = new Extract_logNo();

		// String[] extractURL = new String[1000];

		for (int i = 0; i <= logNo.ID.size() - 1; i++) {

			// use_blogID.extract_blodID_array();
			// System.out.println(use_blogID.blogger_arry[i]);

			// Extract_logNo.extract_logNo();
			// System.out.println(use_logNo.logNo[i]);
			String ID = logNo.ID.get(i);
			String NUM = logNo.logNo_array2.get(i);

			/* logNo가있는 배열에서 null값이 없는 경우만 주소를 만듬 */
			if (NUM != null) {
				String FinalAdress = "http://blog.naver.com/PostView.nhn?"
						+ "blogId="
						+ ID
						+ "&logNo="
						+ NUM
						+ "&beginTime=0&jumpingVid=&from=search&redirect=Log&widgetTypeCall=true";

				// System.out.println(FinalAdress);
				mainArray.add(FinalAdress);
			}
		}
		// System.out.println(mainArray.size());
		// System.out.println(mainArray);

	}

}