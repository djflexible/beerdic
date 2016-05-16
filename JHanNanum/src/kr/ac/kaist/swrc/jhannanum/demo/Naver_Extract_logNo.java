package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;

import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

import org.xml.sax.SAXException;

//로그 값을 추출하는 클래스

public class Naver_Extract_logNo {

	ArrayList<String> ID = new ArrayList<String>();
	ArrayList<String> logNo_array = new ArrayList<String>();
	ArrayList<String> logNo_array2 = new ArrayList<String>();

	public void extract_logNo() throws SAXException, IOException,
			ParserConfigurationException {
		// public String[] void extract_logNo() throws Exception { //logNo를 추출하는
		// 함수

		Naver_Extract_PostSearch use_parameter = new Naver_Extract_PostSearch();
		use_parameter.extract_postList_array();

		ID = use_parameter.Real_array;
		logNo_array = use_parameter.postSearch_array;
		// int naverCount = use_parameter.naverCount;
		// int count = 0;
		// System.out.println(logNo_array);

		for (int i = 0; i < logNo_array.size(); i++) {
			String Address = logNo_array.get(i);
			Document doc = Jsoup.connect(Address).get(); // URL 연결
			Elements titles = doc.select("div#post-area td a");
			// System.out.println(i+"번째");

			for (Element e : titles) {
				// String N_Url = e.absUrl("href");
				// System.out.println(N_Url);
				String N_Url = e.absUrl("href");

				if (N_Url.contains("logNo") == true) {

					char c = (char) (N_Url.charAt(N_Url.indexOf("logNo") + 6));

					if (c >= '0' && c <= '9') {
						N_Url = N_Url.substring(N_Url.indexOf("logNo") + 6,
								N_Url.indexOf("&from"));
						// System.out.println(N_Url);
						logNo_array2.add(N_Url);
						break;
					}
				}

				else if (N_Url.contains("me/") == true) {
					char c = (char) (N_Url.charAt(N_Url.indexOf("me/") + 3));
					if (c >= '0' && c <= '9') {
						N_Url = N_Url.substring(N_Url.indexOf("me/") + 3,
								N_Url.indexOf("?Redirect"));
						// System.out.println(N_Url);
						logNo_array2.add(N_Url);
						break;
					}
				}

				else if (N_Url.contains("kr/") == true) {
					char c = (char) (N_Url.charAt(N_Url.indexOf("kr/") + 3));
					if (c >= '0' && c <= '9') {

						N_Url = N_Url.substring(N_Url.indexOf("kr/") + 3,
								N_Url.indexOf("?Redirect"));
						// System.out.println(N_Url);
						logNo_array2.add(N_Url);
						break;
					}
				}

				else if (N_Url.contains("net/") == true) {

					char c = (char) (N_Url.charAt(N_Url.indexOf("net/") + 4));

					if (c >= '0' && c <= '9') {
						N_Url = N_Url.substring(N_Url.indexOf("net/") + 4,
								N_Url.indexOf("?Redirect"));
						// System.out.println(N_Url);
						logNo_array2.add(N_Url);
						break;

					}
				}

				else if (N_Url.contains("com/") == true) {
					char c = (char) (N_Url.charAt(N_Url.indexOf("com/") + 4));

					if (c >= '0' && c <= '9') {

						N_Url = N_Url.substring(N_Url.indexOf("com/") + 4,
								N_Url.indexOf("?Redirect"));
						// System.out.println(N_Url);
						logNo_array2.add(N_Url);
						break;

					}
				}

				else if (N_Url.contains("to/") == true) {

					char c = (char) (N_Url.charAt(N_Url.indexOf("to/") + 3));

					if (c >= '0' && c <= '9') {

						N_Url = N_Url.substring(N_Url.indexOf("to/") + 3,
								N_Url.indexOf("?Redirect"));
						// System.out.println(N_Url);
						logNo_array2.add(N_Url);
						break;
					}
				}

				else if (N_Url.contains("xyz/") == true) {

					char c = (char) (N_Url.charAt(N_Url.indexOf("xyz/") + 4));

					if (c >= '0' && c <= '9') {
						N_Url = N_Url.substring(N_Url.indexOf("xyz/") + 4,
								N_Url.indexOf("?Redirect"));
						// System.out.println(N_Url);
						logNo_array2.add(N_Url);
						break;
					}
				}

				else if (N_Url.contains("org/") == true) {

					char c = (char) (N_Url.charAt(N_Url.indexOf("org/") + 4));

					if (c >= '0' && c <= '9') {

						N_Url = N_Url.substring(N_Url.indexOf("org/") + 4,
								N_Url.indexOf("?Redirect"));
						// System.out.println(N_Url);
						logNo_array2.add(N_Url);
						break;
					}
				}

				else if (N_Url.contains("707e/") == true) { // 1개일 경우

					char c = (char) (N_Url.charAt(N_Url.indexOf("707e/") + 5));

					if (c >= '0' && c <= '9') {
						N_Url = N_Url.substring(N_Url.indexOf("707e/") + 5,
								N_Url.indexOf("?Redirect"));
						// System.out.println(N_Url);
						logNo_array2.add(N_Url);
						break;
					}
				}

				/* 패턴에 없는경우 배열에 null값을 넣게됨 */

				else {

					logNo_array2.add(null);

					break;

				}
			}
		}
	}

}