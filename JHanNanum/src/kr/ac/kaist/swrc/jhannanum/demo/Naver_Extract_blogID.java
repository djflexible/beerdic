package kr.ac.kaist.swrc.jhannanum.demo;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// 배열 1개를  만들어 블로거 아이디와 검색어를 매칭하여 http://blog.naver.com/PostSearchList.nhn?SearchText=%C7%CF%C0%CC%B3%D7%C4%CB+%B8%C0&blogId=rdfyyh98 형식으로 만든다 
//http://blog.naver.com/PostView.nhn?blogId=egssopi&logNo=90088524098&categoryNo=54&viewDate=&currentPage=1&listtype=0 참고
//postList와 blogger name을 추출하는 클래스

public class Naver_Extract_blogID {

	ArrayList<String> blogger_array = new ArrayList<String>();// 블로거 아이디가 저장될 배열
	
	Input_keword InputKeword = new Input_keword();
	
	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}


	String searchQuery = InputKeword.keword;//검색어
	int page = InputKeword.page;
	int display = 10; // display 값은 최대 100
	int count = 0;

	// public static void main(String[] args) throws SAXException, IOException,
	// ParserConfigurationException{
	
	/* 네이버 검색 */
	public void extract_blodID_array() throws SAXException, IOException,ParserConfigurationException {
	
		String apiKey = "***";

		String[] targets = { "rank", "kin", "image", "doc", "book", "movie",
				"movieman", "local", "shop", "car", "encyc", "blog", "cafe",
				"cafearticle", "webkr", "news", "recmd", "adult", "errata",
				"shortcut" };

		String uri = "";
		int start = 1; // 페이지 시작 값 최대 1000, //1,11,21,31,41....i=1,2,3,4...

		for (int i = 0; i < page; i++) {//페이지 30개를 검색

			/* 해당 검색어로 만들어진 검색URL생성 */
			uri = "http://openapi.naver.com/search?key=" + apiKey + "&target="
					+ targets[11] + "&query="
					+ URLEncoder.encode(searchQuery, "UTF-8") + "&display="
					+ display + "&start=";

			extract_blodID(uri + start);

			start = start + 10; // 1,11,21,31,41......, 이론상 100,000개 추출 가능, 1일
								// 쿼리 갯수 유의 한도 25,000번
		}

	}

	public String getContent(Element element, String tagName) {
		NodeList list = element.getElementsByTagName(tagName);
		Element cElement = (Element) list.item(0);

		if (cElement.getFirstChild() != null) {
			return cElement.getFirstChild().getNodeValue();
		} else {
			return "";
		}
	}


	/* 블로그 아이디 추출 메소드 */
	public ArrayList<String> extract_blodID(String uri) throws SAXException,IOException, ParserConfigurationException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = dbf.newDocumentBuilder();
		Document doc = builder.parse(uri);
		Element root = doc.getDocumentElement();
		NodeList list = root.getElementsByTagName("item");

		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);
			// http://developer.naver.com/wiki/pages/Blog 변수 설명

			// 블로거 이름 출력
			String blogID = getContent(element, "bloggerlink");
			String naver_blogger = "http://blog.naver.com/";

			// System.out.print((i+1)+"회 "+ "원래 URL : " + bloggerName);

			boolean contains = blogID.contains(naver_blogger);
			// System.out.println("==> 네이버 블로그 형식?: " + contains);

			if (contains == true) { // 만약 bloggerName이
									// http://blog.naver.com/ji0kyun91 형태가 아니라면
									// 배열에 저장하지 않음

				String f_first = "com/";
				int loc_first = 0;
				loc_first = blogID.indexOf(f_first);

				blogID = blogID.substring(loc_first + 4); // 블로거 1,2,3....n개씩 저장

				blogger_array.add(blogID);

			}

		}
		return blogger_array;

	}

}