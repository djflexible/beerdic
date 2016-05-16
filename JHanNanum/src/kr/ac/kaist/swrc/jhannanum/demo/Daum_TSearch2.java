package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.SAXException;

public class Daum_TSearch2 {
	// public static void main(String[] args) throws Exception {

	public String target_page2() throws SAXException, IOException,
			ParserConfigurationException {
		ArrayList<String> T_array2 = new ArrayList<String>();

		Daum_TSearch Tstory = new Daum_TSearch();
		Tstory.TConnect();

		int count = 0;

		T_array2 = Tstory.T_array;
		Document doc = null;
		String Daum_MAIN = "티스토리 결과";
		// System.out.println(T_array2);
		// System.out.println(T_array2.size());
		for (int i = 0; i < T_array2.size(); i++) {

			/* 해당 사이트 url생성 */
			String url = T_array2.get(i);
			/* URL연결 및 예외처리 */
			try {
				doc = Jsoup
						.connect(url)
						.userAgent(
								"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
						.referrer("http://www.google.com").get();
			} catch (NullPointerException e) {
				// e.printStackTrace();
			} catch (HttpStatusException e) {
				// e.printStackTrace();
			} catch (IOException e) {
				// e.printStackTrace();
			}

			/* 예외처리에서 null값이 아니면 실행 */
			if (doc != null) {
				// count++;
				Elements titles = doc.select(".article p");
				for (Element e : titles) {

					Daum_MAIN += e.text();
				}
			}
		}
		// System.out.println(count);
		// System.out.println(Daum_MAIN);
		return Daum_MAIN;

	}
}