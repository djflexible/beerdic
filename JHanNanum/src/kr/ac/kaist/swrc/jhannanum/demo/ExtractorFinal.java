package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;

public class ExtractorFinal {

	int beer_code = 12;
	String eng_name = "null";
	String kor_name = "null";
	String degree = "0";
	String original = "null";
	String price = "null";
	String content = "null";

	int spring = 0; // 봄
	int summer = 0; // 여름
	int fall = 0; // 가을
	int winter = 0; // 겨울

	int chicken = 0; // 치킨
	int pizza = 0; // 피자
	int cheese = 0; // 치즈
	int salad = 0; // 샐러드
	int firefish = 0; // 쥐포,오징어
	int frenchfries = 0; // 감자튀김
	int steak = 0; // 스테이크
	int sausage = 0; // 소세지

	/* 과일맛 */
	int apple = 0;// 사과
	String str사과1 = "사과";
	String str사과2 = "apple";
	String str사과3 = "애플";

	int orange = 0;// 오렌지
	String str오렌지1 = "오렌지";
	String str오렌지4 = "오랜지";
	String str오렌지2 = "orange";
	String str오렌지3 = "귤";

	int lemon = 0;// 레몬
	String str레몬1 = "레몬";
	String str레몬2 = "래몬";
	String str레몬3 = "lemon";
	String str레몬4 = "remon";
	String str레몬5 = "귤";
	String str레몬6 = "citrus";
	String str레몬7 = "시트러스";

	int strawberry = 0;// 딸기
	String str딸기1 = "딸기";
	String str딸기2 = "strawberry";
	String str딸기3 = "스트로베리";
	String str딸기4 = "스트로배리";

	int grape = 0; // 포도
	String str포도1 = "포도";
	String str포도2 = "grape";
	String str포도3 = "그레이프";
	String str포도4 = "그래이프";

	int blueberry = 0; // 블루베리
	String str블루베리1 = "블루베리";
	String str블루베리2 = "blueberry";
	String str블루베리3 = "블루배리";

	int pineapple = 0; // 파인애플
	String str파인애플1 = "파인애플";
	String str파인애플2 = "pineapple";

	int raspberry = 0; // 라즈베리
	String str라즈베리1 = "raspberry";
	String str라즈베리2 = "라즈베리";

	int cranberry = 0; // 크렌베리
	String str크랜베리1 = "크랜베리";
	String str크랜베리2 = "cranberry";
	String str크랜베리3 = "크랜배리";

	int banana = 0; // 바나나
	String str바나나1 = "바나나";
	String str바나나2 = "banana";

	int mango = 0; // 망고
	String str망고1 = "망고";
	String str망고2 = "mango";

	int cherry = 0; // 체리
	String str체리1 = "체리";
	String str체리2 = "cherry";
	String str체리3 = "앵두";
	String str체리4 = "채리";

	int kiwi = 0; // 키위
	String str키위1 = "키위";
	String str키위2 = "kiwi";

	int coconut = 0; // 코코넛
	String str코코넛1 = "코코넛";
	String str코코넛2 = "coconet";
	String str코코넛3 = "야자";

	int peach = 0; // 복숭아
	String str복숭아1 = "복숭아";
	String str복숭아2 = "peach";

	int grapefruit = 0; // 자몽
	String str자몽1 = "자몽";
	String str자몽2 = "grapefruit";

	int lime = 0; // 라임
	String str라임1 = "라임";
	String str라임2 = "lime";

	int sweet = 0; // 단맛
	String str단1 = "달콤";
	String str단2 = "단맛";
	String str단3 = "달짝";
	String str단4 = "달쩍";
	String str단5 = "감미";
	String str단6 = "꿀";
	String str단7 = "다달";
	String str단8 = "다디달";
	String str단9 = "달곰쌉쌀";
	String str단10 = "달곰";
	String str단11 = "달디달";
	String str단12 = "달짜";
	String str단13 = "달착";
	String str단14 = "달큼";

	int sour = 0; // 신맛
	String str신1 = "신 맛";
	String str신2 = "산미";
	String str신3 = "시다";
	String str신4 = "신맛";
	String str신5 = "시큼";

	int bitter = 0; // 쓴맛
	String str쓴1 = "쓴";
	String str쓴2 = "쌉싸";
	String str쓴3 = "씁쓸";
	String str쓴4 = "쓴맛";
	String str쓴5 = "쓰디쓰";
	String str쓴6 = "씁쓰름";
	String str쓴7 = "쓰다";

	int burn = 0; // 탄맛
	String str탄1 = "탄맛";
	String str탄2 = "탄 맛";
	String str탄3 = "burn";

	int coffee = 0; // 커피맛
	String str커피1 = "커피";
	String str커피2 = "에스프레소";
	String str커피3 = "coffee";
	String str커피4 = "카페인";

	int caramel = 0; // 카라멜맛
	String str카라멜1 = "카라멜";
	String str카라멜2 = "케러멜";
	String str카라멜3 = "캐러멜";
	String str카라멜4 = "케러맬";
	String str카라멜5 = "캐러맬";
	String str카라멜6 = "몰츠";
	String str카라멜7 = "멜츠";
	String str카라멜8 = "caramel";

	int chocolate = 0; // 초콜릿맛
	String str초코1 = "초코";
	String str초코2 = "쵸코";
	String str초코3 = "초콜";
	String str초코4 = "초컬";
	String str초코5 = "chocolate";
	String str초코6 = "코코아";

	int mint = 0; // 민트맛
	String str민트1 = "민트";
	String str민트2 = "mint";
	String str민트3 = "박하";

	/* 느낌 */
	int clean = 0; // 깔끔한
	String str깔끔1 = "깔끔";
	String str깔끔2 = "상쾌";
	String str깔끔3 = "깨끗";
	String str깔끔4 = "산뜻";
	String str깔끔5 = "개운";
	String str깔끔6 = "clean";
	String str깔끔7 = "시원한맛";
	String str깔끔8 = "시원한 맛";

	int fresh = 0; // 상큼한
	String str상큼1 = "상큼";
	String str상큼2 = "fresh";
	String str상큼3 = "프레쉬";
	String str상큼4 = "후레쉬";

	int soft = 0; // 부드러운
	String str부드1 = "부드";
	String str부드2 = "말랑";
	String str부드3 = "은은";
	String str부드4 = "은근";
	String str부드5 = "부들";
	String str부드6 = "살살녹는";
	String str부드7 = "보드라운";
	String str부드8 = "보드러운";
	String str부드9 = "크림";
	String str부드10 = "cream";
	String str부드11 = "말캉";
	String str부드12 = "soft";
	String str부드13 = "소프트";

	int rough = 0; // 거친
	String str거친1 = "거칠";
	String str거친2 = "거친";
	String str거친3 = "rough";
	String str거친4 = "러프";
	String str거친5 = "wild";
	String str거친6 = "와일드";
	String str거친7 = "텁텁";
	String str거친8 = "떫";
	String str거친9 = "찝찝";
	String str거친10 = "떨떠름";
	String str거친11 = "걸쭉";

	int bland = 0; // 맹맹한
	String str맹맹1 = "맹맹";
	String str맹맹2 = "밋밋";
	String str맹맹3 = "싱거";
	String str맹맹4 = "순한";
	String str맹맹5 = "싱겁";
	String str맹맹6 = "삼삼한";
	String str맹맹7 = "삼삼하다";
	String str맹맹8 = "밍밍";
	String str맹맹9 = "블랜드";
	String str맹맹10 = "블렌드";
	String str맹맹11 = "bland";

	int nut = 0; // 구수한
	String str구수1 = "구수";
	String str구수2 = "고소";

	/* 탄산 &거품 */

	int acid = 0; // 탄산
	String str탄산1 = "탄산";
	String str탄산2 = "톡쏘는";
	String str탄산3 = "톡 쏘는";

	int bubble = 0; //
	String str거품1 = "거품";
	String str거품2 = "bubble";

	// public static void main(String[] args) throws SAXException, IOException,
	// ParserConfigurationException {

	public void extractorfinal() throws SAXException, IOException,
			ParserConfigurationException {

		/* 각 형태소들이 순서대로 들어있는 배열 */

		ArrayList<String> morpheme_Array = new ArrayList<String>();

		/* 중복을 제거한 형태소들이 들어있는 배열 */

		ArrayList<String> itemList = new ArrayList<String>();

		/* 형태소들의 갯수가 들어있는 배열 */

		ArrayList<Integer> cntList = new ArrayList<Integer>();

		Naver_Extract_print Naver_parameter = new Naver_Extract_print();
		Daum_TSearch2 Daum_parameter = new Daum_TSearch2();

		Workflow workflow = WorkflowFactory
				.getPredefinedWorkflow(WorkflowFactory.WORKFLOW_NOUN_EXTRACTOR);

		System.out.println("시작 중입니다......");

		String Naver_document = Naver_parameter.target_page(); // 네이버 크롤러
		String Daum_document = Daum_parameter.target_page2();
		String Main_document = Naver_document + Daum_document;

		try {

			workflow.activateWorkflow(true);

			workflow.analyze(Main_document); // 네이버 크롤러

			LinkedList<Sentence> resultList = workflow
					.getResultOfDocument(new Sentence(0, 0, false));

			for (Sentence s : resultList) {

				Eojeol[] eojeolArray = s.getEojeols();

				for (int i = 0; i < eojeolArray.length; i++) {

					if (eojeolArray[i].length > 0) {

						String[] morphemes = eojeolArray[i].getMorphemes();

						for (int j = 0; j < morphemes.length; j++) {

							/* 형태소 배열에 차례로 집어넣음 */

							morpheme_Array.add(morphemes[j]);

						}
					}
				}

			}
			// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			/* 맛 향 알고리즘 부분 */

			// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			for (int j = 0; j < morpheme_Array.size(); j++) {

				boolean contains = morpheme_Array.get(j).contains(str단1)
						|| morpheme_Array.get(j).contains(str단2)
						|| morpheme_Array.get(j).contains(str단3)
						|| morpheme_Array.get(j).contains(str단4)
						|| morpheme_Array.get(j).contains(str단5)
						|| morpheme_Array.get(j).contains(str단6)
						|| morpheme_Array.get(j).contains(str단7)
						|| morpheme_Array.get(j).contains(str단8)
						|| morpheme_Array.get(j).contains(str단9)
						|| morpheme_Array.get(j).contains(str단10)
						|| morpheme_Array.get(j).contains(str단11)
						|| morpheme_Array.get(j).contains(str단12)
						|| morpheme_Array.get(j).contains(str단13)
						|| morpheme_Array.get(j).contains(str단14);
				if (contains == true) {
					sweet++;
				}

				contains = morpheme_Array.get(j).contains(str신1)
						|| morpheme_Array.get(j).contains(str신2)
						|| morpheme_Array.get(j).contains(str신3)
						|| morpheme_Array.get(j).contains(str신4)
						|| morpheme_Array.get(j).contains(str신5);
				if (contains == true) {
					sour++;
				}

				contains = morpheme_Array.get(j).contains(str쓴1)
						|| morpheme_Array.get(j).contains(str쓴2)
						|| morpheme_Array.get(j).contains(str쓴3)
						|| morpheme_Array.get(j).contains(str쓴4)
						|| morpheme_Array.get(j).contains(str쓴5)
						|| morpheme_Array.get(j).contains(str쓴6)
						|| morpheme_Array.get(j).contains(str쓴7);
				if (contains == true) {
					bitter++;
				}

				contains = morpheme_Array.get(j).contains(str탄1)
						|| morpheme_Array.get(j).contains(str탄2)
						|| morpheme_Array.get(j).contains(str탄3);
				if (contains == true) {
					burn++;
				}

				contains = morpheme_Array.get(j).contains(str커피1)
						|| morpheme_Array.get(j).contains(str커피2)
						|| morpheme_Array.get(j).contains(str커피3)
						|| morpheme_Array.get(j).contains(str커피4);
				if (contains == true) {
					coffee++;
				}

				contains = morpheme_Array.get(j).contains(str카라멜1)
						|| morpheme_Array.get(j).contains(str카라멜2)
						|| morpheme_Array.get(j).contains(str카라멜3)
						|| morpheme_Array.get(j).contains(str카라멜4)
						|| morpheme_Array.get(j).contains(str카라멜5)
						|| morpheme_Array.get(j).contains(str카라멜6)
						|| morpheme_Array.get(j).contains(str카라멜7)
						|| morpheme_Array.get(j).contains(str카라멜8);

				if (contains == true) {
					caramel++;
				}

				contains = morpheme_Array.get(j).contains(str초코1)
						|| morpheme_Array.get(j).contains(str초코2)
						|| morpheme_Array.get(j).contains(str초코3)
						|| morpheme_Array.get(j).contains(str초코4)
						|| morpheme_Array.get(j).contains(str초코5)
						|| morpheme_Array.get(j).contains(str초코6);

				if (contains == true) {
					chocolate++;
				}

				contains = morpheme_Array.get(j).contains(str민트1)
						|| morpheme_Array.get(j).contains(str민트2)
						|| morpheme_Array.get(j).contains(str민트3);

				if (contains == true) {
					mint++;
				}

				contains = morpheme_Array.get(j).contains(str깔끔1)
						|| morpheme_Array.get(j).contains(str깔끔2)
						|| morpheme_Array.get(j).contains(str깔끔3)
						|| morpheme_Array.get(j).contains(str깔끔4)
						|| morpheme_Array.get(j).contains(str깔끔5)
						|| morpheme_Array.get(j).contains(str깔끔6)
						|| morpheme_Array.get(j).contains(str깔끔7)
						|| morpheme_Array.get(j).contains(str깔끔8);
				if (contains == true) {
					clean++;
				}

				contains = morpheme_Array.get(j).contains(str상큼1)
						|| morpheme_Array.get(j).contains(str상큼2)
						|| morpheme_Array.get(j).contains(str상큼3)
						|| morpheme_Array.get(j).contains(str상큼4);
				if (contains == true) {
					fresh++;
				}

				contains = morpheme_Array.get(j).contains(str부드1)
						|| morpheme_Array.get(j).contains(str부드2)
						|| morpheme_Array.get(j).contains(str부드3)
						|| morpheme_Array.get(j).contains(str부드4)
						|| morpheme_Array.get(j).contains(str부드5)
						|| morpheme_Array.get(j).contains(str부드6)
						|| morpheme_Array.get(j).contains(str부드7)
						|| morpheme_Array.get(j).contains(str부드8)
						|| morpheme_Array.get(j).contains(str부드9)
						|| morpheme_Array.get(j).contains(str부드10)
						|| morpheme_Array.get(j).contains(str부드11)
						|| morpheme_Array.get(j).contains(str부드12)
						|| morpheme_Array.get(j).contains(str부드13);
				if (contains == true) {
					soft++;
				}

				contains = morpheme_Array.get(j).contains(str거친1)
						|| morpheme_Array.get(j).contains(str거친2)
						|| morpheme_Array.get(j).contains(str거친3)
						|| morpheme_Array.get(j).contains(str거친4)
						|| morpheme_Array.get(j).contains(str거친5)
						|| morpheme_Array.get(j).contains(str거친6)
						|| morpheme_Array.get(j).contains(str거친7)
						|| morpheme_Array.get(j).contains(str거친8)
						|| morpheme_Array.get(j).contains(str거친9)
						|| morpheme_Array.get(j).contains(str거친10)
						|| morpheme_Array.get(j).contains(str거친11);

				if (contains == true) {
					rough++;
				}

				contains = morpheme_Array.get(j).contains(str맹맹1)
						|| morpheme_Array.get(j).contains(str맹맹2)
						|| morpheme_Array.get(j).contains(str맹맹3)
						|| morpheme_Array.get(j).contains(str맹맹4)
						|| morpheme_Array.get(j).contains(str맹맹5)
						|| morpheme_Array.get(j).contains(str맹맹6)
						|| morpheme_Array.get(j).contains(str맹맹7)
						|| morpheme_Array.get(j).contains(str맹맹8)
						|| morpheme_Array.get(j).contains(str맹맹9)
						|| morpheme_Array.get(j).contains(str맹맹10)
						|| morpheme_Array.get(j).contains(str맹맹11);

				if (contains == true) {
					bland++;
				}

				contains = morpheme_Array.get(j).contains(str구수1)
						|| morpheme_Array.get(j).contains(str구수2);

				if (contains == true) {
					nut++;
				}

				contains = morpheme_Array.get(j).contains(str탄산1)
						|| morpheme_Array.get(j).contains(str탄산2)
						|| morpheme_Array.get(j).contains(str탄산3);

				if (contains == true) {
					acid++;
				}

				contains = morpheme_Array.get(j).contains(str거품1)
						|| morpheme_Array.get(j).contains(str거품2);

				if (contains == true) {
					bubble++;
				}

				contains = morpheme_Array.get(j).contains(str사과1)
						|| morpheme_Array.get(j).contains(str사과2)
						|| morpheme_Array.get(j).contains(str사과3);

				if (contains == true) {
					apple++;
				}

				contains = morpheme_Array.get(j).contains(str오렌지1)
						|| morpheme_Array.get(j).contains(str오렌지2)
						|| morpheme_Array.get(j).contains(str오렌지3)
						|| morpheme_Array.get(j).contains(str오렌지4);

				if (contains == true) {
					orange++;
				}

				contains = morpheme_Array.get(j).contains(str레몬1)
						|| morpheme_Array.get(j).contains(str레몬2)
						|| morpheme_Array.get(j).contains(str레몬3)
						|| morpheme_Array.get(j).contains(str레몬4)
						|| morpheme_Array.get(j).contains(str레몬5)
						|| morpheme_Array.get(j).contains(str레몬6)
						|| morpheme_Array.get(j).contains(str레몬7);

				if (contains == true) {
					lemon++;
				}

				contains = morpheme_Array.get(j).contains(str딸기1)
						|| morpheme_Array.get(j).contains(str딸기2)
						|| morpheme_Array.get(j).contains(str딸기3)
						|| morpheme_Array.get(j).contains(str딸기4);

				if (contains == true) {
					strawberry++;
				}

				contains = morpheme_Array.get(j).contains(str포도1)
						|| morpheme_Array.get(j).contains(str포도2)
						|| morpheme_Array.get(j).contains(str포도3)
						|| morpheme_Array.get(j).contains(str포도4);

				if (contains == true) {
					grape++;
				}

				contains = morpheme_Array.get(j).contains(str블루베리1)
						|| morpheme_Array.get(j).contains(str블루베리2)
						|| morpheme_Array.get(j).contains(str블루베리3);

				if (contains == true) {
					blueberry++;
				}

				contains = morpheme_Array.get(j).contains(str파인애플1)
						|| morpheme_Array.get(j).contains(str파인애플2);

				if (contains == true) {
					pineapple++;
				}

				contains = morpheme_Array.get(j).contains(str라즈베리1)
						|| morpheme_Array.get(j).contains(str라즈베리2);

				if (contains == true) {
					raspberry++;
				}

				contains = morpheme_Array.get(j).contains(str크랜베리1)
						|| morpheme_Array.get(j).contains(str크랜베리2)
						|| morpheme_Array.get(j).contains(str크랜베리3);

				if (contains == true) {
					cranberry++;
				}

				contains = morpheme_Array.get(j).contains(str바나나1)
						|| morpheme_Array.get(j).contains(str바나나2);

				if (contains == true) {
					banana++;
				}

				contains = morpheme_Array.get(j).contains(str체리1)
						|| morpheme_Array.get(j).contains(str체리2)
						|| morpheme_Array.get(j).contains(str체리3)
						|| morpheme_Array.get(j).contains(str체리4);

				if (contains == true) {
					cherry++;
				}

				contains = morpheme_Array.get(j).contains(str키위1)
						|| morpheme_Array.get(j).contains(str키위2);

				if (contains == true) {
					kiwi++;
				}

				contains = morpheme_Array.get(j).contains(str코코넛1)
						|| morpheme_Array.get(j).contains(str코코넛2)
						|| morpheme_Array.get(j).contains(str코코넛3);

				if (contains == true) {
					coconut++;
				}

				contains = morpheme_Array.get(j).contains(str자몽1)
						|| morpheme_Array.get(j).contains(str자몽2);

				if (contains == true) {
					grapefruit++;
				}

				contains = morpheme_Array.get(j).contains(str라임1)
						|| morpheme_Array.get(j).contains(str라임2);

				if (contains == true) {
					lime++;
				}
			}

			// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			/* 중복 제거 부분 */

			// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/* 형태소 갯수 구하기 */

			for (int index = 0; index < morpheme_Array.size(); index++) {

				/* 아이템리스트에 있는지를 확인 */

				if (!itemList.contains(morpheme_Array.get(index))) {

					/* 배열안에 없다면 배열에 추가 */

					itemList.add(morpheme_Array.get(index));

					/* 배열안의 요소들이 몇번 나오는지 체크 */

					int cnt = 0;

					for (int searchIndex = index; searchIndex < morpheme_Array
							.size(); searchIndex++) {

						if (morpheme_Array.get(index).equals(
								morpheme_Array.get(searchIndex)) == true) {
							cnt++;
						}

					}

					/* 체크한 값을 카운트리스트에 저장함 */
					cntList.add(cnt);

				} else {

					continue;
				}
			}

			// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			/* 계절 알고리즘 */

			// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			for (int i = 0; i < cntList.size(); i++) {
				/* 계절 */
				if (itemList.get(i).contains("봄")
						|| itemList.get(i).contains("spring")
						|| itemList.get(i).contains("SPRING")) {
					spring += cntList.get(i);
				}
				if (itemList.get(i).contains("여름")
						|| itemList.get(i).contains("summer")
						|| itemList.get(i).contains("SUMMER")) {
					summer += cntList.get(i);
				}
				if (itemList.get(i).contains("가을")
						|| itemList.get(i).contains("fall")
						|| itemList.get(i).contains("FALL")) {
					fall += cntList.get(i);
				}
				if (itemList.get(i).contains("겨울")
						|| itemList.get(i).contains("winter")
						|| itemList.get(i).contains("WINTER")) {
					winter += cntList.get(i);
				}
				// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				/* 안주 알고리즘 */

				// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				if (itemList.get(i).contains("치킨")
						|| itemList.get(i).contains("chicken")
						|| itemList.get(i).contains("CHICKEN")) {
					chicken += cntList.get(i);
				}
				if (itemList.get(i).contains("피자")
						|| itemList.get(i).contains("pizza")
						|| itemList.get(i).contains("PIZZA")) {
					pizza += cntList.get(i);
				}
				if (itemList.get(i).contains("치즈")
						|| itemList.get(i).contains("cheese")
						|| itemList.get(i).contains("CHEESE")) {
					cheese += cntList.get(i);
				}
				if (itemList.get(i).contains("샐러드")
						|| itemList.get(i).contains("salad")
						|| itemList.get(i).contains("SALAD")) {
					salad += cntList.get(i);
				}
				if (itemList.get(i).contains("오징어")
						|| itemList.get(i).contains("쥐포")
						|| itemList.get(i).contains("firefish")
						|| itemList.get(i).contains("FIREFISH")) {
					firefish += cntList.get(i);
				}
				if (itemList.get(i).contains("감튀")
						|| itemList.get(i).contains("감자튀김")
						|| itemList.get(i).contains("frenchfries")
						|| itemList.get(i).contains("chips")
						|| itemList.get(i).contains("potato")
						|| itemList.get(i).contains("fries")) {
					frenchfries += cntList.get(i);
				}
				if (itemList.get(i).contains("스테이크")
						|| itemList.get(i).contains("steak")
						|| itemList.get(i).contains("STEAK")) {
					steak += cntList.get(i);
				}
				if (itemList.get(i).contains("소세지")
						|| itemList.get(i).contains("소시지")
						|| itemList.get(i).contains("sausage")
						|| itemList.get(i).contains("SAUSAGE")) {
					sausage += cntList.get(i);
				}

			}

			workflow.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);

		}

		/* Shutdown the work flow */

		workflow.close();

		System.out
				.println("///////////////////////////////////////////////////////////");
		System.out.println("단맛 : " + sweet);
		System.out.println("신맛 : " + sour);
		System.out.println("쓴맛 : " + bitter);
		System.out.println("탄맛 : " + burn);
		System.out.println("커피맛 : " + coffee);
		System.out.println("캐러맬맛 : " + caramel);
		System.out.println("초코맛 : " + chocolate);
		System.out.println("민트맛 : " + mint);
		System.out
				.println("///////////////////////////////////////////////////////////");
		System.out.println("사과 : " + apple);
		System.out.println("오렌지 : " + orange);
		System.out.println("레몬 : " + lemon);
		System.out.println("딸기 : " + strawberry);
		System.out.println("포도 : " + grape);
		System.out.println("블루베리 : " + blueberry);
		System.out.println("파인애플 : " + pineapple);
		System.out.println("라즈베리 : " + raspberry);
		System.out.println("크렌베리 : " + cranberry);
		System.out.println("바나나 : " + banana);
		System.out.println("망고 : " + mango);
		System.out.println("체리 : " + cherry);
		System.out.println("키위 : " + kiwi);
		System.out.println("코코넛 : " + coconut);
		System.out.println("복숭아 : " + peach);
		System.out.println("자몽 : " + grapefruit);
		System.out.println("라임 : " + lime);
		System.out
				.println("///////////////////////////////////////////////////////////");
		System.out.println("깔끔한 : " + clean);
		System.out.println("상큼한 : " + fresh);
		System.out.println("부드러운 : " + soft);
		System.out.println("거친 : " + rough);
		System.out.println("맹맹한 : " + bland);
		System.out.println("고소한 : " + nut);
		System.out
				.println("///////////////////////////////////////////////////////////");
		System.out.println("치킨 : " + chicken);
		System.out.println("피자 : " + pizza);
		System.out.println("치즈 : " + cheese);
		System.out.println("샐러드 : " + salad);
		System.out.println("쥐포,오징어 : " + firefish);
		System.out.println("감자튀김 : " + frenchfries);
		System.out.println("스테이크 : " + steak);
		System.out.println("소세지 : " + sausage);
		System.out
				.println("///////////////////////////////////////////////////////////");
		System.out.println("탄산 : " + acid);
		System.out.println("거품 : " + bubble);
		System.out
				.println("///////////////////////////////////////////////////////////");
		System.out.println("봄 : " + spring);
		System.out.println("여름 : " + summer);
		System.out.println("가을 : " + fall);
		System.out.println("겨울 : " + winter);
		System.out
				.println("///////////////////////////////////////////////////////////");

		System.out.println("종료합니다......");

	}

}