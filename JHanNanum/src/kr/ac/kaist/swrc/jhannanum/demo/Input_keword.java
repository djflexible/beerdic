package kr.ac.kaist.swrc.jhannanum.demo;

public class Input_keword {
	String keword ="크로넨버그"; //맥주 이름
	int page = 5;
}
/*
 * 1. Input_keword에서 검색하려는 맥주의 이름과 검색횟수를 지정해준다
 * (예: keyword = 호가든맥주 page = 20 -> 호가든맥주 200개를 검색)
 * 
 * 2. Daum_Crawler와 Naver_Crawler을 통해 해당 키워드를 검색 텍스트마이닝을 진행한다
 * 
 * 3. Daum_Crawler의 진행순서는 Daum_TSearh -> Daum_TSearch2
 * 
 * 4. Naver_Crawler의 진행순서는 Naver_blogID -> Naver_PostSearch -> Naver_logNo -> Naver_targerPage -> Naver_Print
 * 
 * 5. WorkflowNounExtractor은 해당 맛의 키워드를 표현한 클래스 이며 다른 Extractor의 부모클래스이며 각 Crawler에서의 정보를 분석하여 결론을 도출한다
 * 
 * 6. Extractor2는 모든 형태소에 관한 카운트를 세어내는 클래스이다
 * 
 * 7. ExtractorFinal은 맛의표현과 안주,계절 등의 전반적인 데이터를 수집하는 클래스이다. 각 변수들은 데이터베이스에 저장할 수 있도록
 * 	개별로 지정되있으며 모든 Extractor의 기능을 수행 가능하다
 * 
 * */