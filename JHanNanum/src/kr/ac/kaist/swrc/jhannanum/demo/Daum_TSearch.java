package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Daum_TSearch {
	// public static void main(String[] args) throws Exception {

	ArrayList<String> T_array = new ArrayList<String>();
	Document doc = null;

	Input_keword InputKeword = new Input_keword();

	public void TConnect() throws IOException {
		String search = InputKeword.keword;// 검색키워드
		int page = InputKeword.page;

		/* page가 페이지를 나타냄 100개 검색하고 싶을시에 page < 10으로 설정 */
		for (int i = 1; i <= page; i++) {
			/* 검색URL생성 */
			String url = "http://search.daum.net/search?w=blog&f=section&SA=tistory&lpp=10&nil_src=tistory&q="
					+ URLEncoder.encode(search, "UTF-8")
					+ "&page="
					+ i
					+ "&m=board&DA=PGD";

			doc = Jsoup
					.connect(url)
					.userAgent(
							"Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
					.referrer("http://www.google.com").timeout(1000 * 5).get();

			Elements titles = doc.select("div#blogColl div.wrap_cont a");

			for (Element e : titles) {

				if (e.toString().contains("f_link_bu")) {
					String T_Url = e.absUrl("href");
					// System.out.println(T_Url);
					T_array.add(T_Url);

				}
			}
		}
	}
}
