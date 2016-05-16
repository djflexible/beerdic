package kr.ac.kaist.swrc.jhannanum.demo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Naver_Extract_PostSearch {
	ArrayList<String> Real_array = new ArrayList<String>();//아이디값이 저장되 있는 배열
	ArrayList<String> postSearch_array = new ArrayList<String>();//블로거의 포스트 검색 URL이 저장 되어 있는 배열
	
		public void extract_postList_array() throws SAXException, IOException, ParserConfigurationException{		
			//postSearch_arry 리턴

		Naver_Extract_blogID use_parameter = new Naver_Extract_blogID();
		use_parameter.extract_blodID_array();
		
		/* 중복ID제거 */
		HashSet<String> hash = new HashSet<String>(use_parameter.blogger_array);
		Real_array = new ArrayList<String>(hash);
		
		String search_name = URLEncoder.encode(use_parameter.searchQuery, "EUC-KR");	//블로거 아이디와 매칭될 euc-kr로 표현된 검색어 ==> 조심, 1클래스에서만 쓰임
		
   		for (int naverCount=0 ; naverCount<Real_array.size(); naverCount++){
	
   		String Address = "http://blog.naver.com/PostSearchList.nhn?"+ "SearchText="+search_name + "&blogId="+Real_array.get(naverCount);
		postSearch_array.add(Address);
						
		}
   		//System.out.println(postSearch_array);
	}

}