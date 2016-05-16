package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;

import org.xml.sax.SAXException;

public class WorkflowNounExtractor {

	public static void main(String[] args) throws SAXException, IOException,
			ParserConfigurationException {

		Naver_Extract_print use_parameter = new Naver_Extract_print();
		// TSearch2 use_parameter2 = new TSearch2();

		Workflow workflow = WorkflowFactory
				.getPredefinedWorkflow(WorkflowFactory.WORKFLOW_NOUN_EXTRACTOR);

		System.out.println("시작 중입니다......");
		String document2 = use_parameter.target_page(); // 네이버 크롤러

		// String document3 = use_parameter2.target_page2(); //다음 크롤러

		// System.out.println(document2);
		try {
			workflow.activateWorkflow(true);

			workflow.analyze(document2); // 네이버 크롤러
			// workflow.analyze(document3); //다음 크롤러

			LinkedList<Sentence> resultList = workflow
					.getResultOfDocument(new Sentence(0, 0, false));

			// Analyzer test = new Analyzer();
			// ///////////
			// / 명사,동사,형용사 추출
			// / 맛,탄산&거품,향 분류
			// / 특정 단어 count
			// ///////////

			// // 맛&&&향
			int countSweet = 0; // 단맛 count 1
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

			int countBitterness = 0; // 쓴맛 count 2
			String str쓴1 = "쓴";
			String str쓴2 = "쌉싸";
			String str쓴3 = "씁쓸";
			String str쓴4 = "쓴맛";
			String str쓴5 = "쓰디쓰";
			String str쓴6 = "씁쓰름";
			String str쓴7 = "쓰다";

			int countFruits = 0; // 과일맛 count 3
			String str과일1 = "과일";
			String str과일2 = "레몬";
			String str과일3 = "복숭아";
			String str과일4 = "망고";
			String str과일5 = "포도";
			String str과일6 = "자몽";
			String str과일7 = "베리";
			String str과일8 = "시트러스";
			String str과일9 = "귤";
			String str과일10 = "쥬스";
			String str과일11 = "주스";
			String str과일12 = "사과";
			String str과일13 = "오렌지";
			String str과일14 = "바나나";
			String str과일15 = "체리";
			String str과일16 = "키위";
			String str과일17 = "딸기";
			String str과일18 = "애플";

			int countSoft = 0; // 부드러운맛 count 4
			String str부드1 = "부드";
			String str부드2 = "말랑";
			String str부드3 = "은은";
			String str부드4 = "은근";
			String str부드5 = "부들";
			String str부드6 = "살살녹는";

			int countCoffee = 0; // 커피맛 count 5
			String str커피1 = "커피";
			String str커피2 = "에스프레소";
			String str커피3 = "offee";
			String str커피4 = "카페인";

			int countFresh = 0; // 깔끔한맛, 상쾌한맛count 6
			String str깔끔1 = "깔끔";
			String str깔끔2 = "상쾌";
			String str깔끔3 = "깨끗";
			String str깔끔4 = "산뜻";
			String str깔끔5 = "개운";
			String str깔끔6 = "상큼";

			int countBurn = 0; // 탄맛 count 7
			String str탄1 = "탄";

			int count텁텁 = 0; // 텁텁한맛 count 8
			String str텁텁1 = "텁텁";
			String str텁텁2 = "떫";
			String str텁텁3 = "찝찝";
			String str텁텁4 = "떨떠름";

			int count맹맹 = 0; // 맹한맛 count 9
			String str맹맹1 = "맹";
			String str맹맹2 = "밋밋";
			String str맹맹3 = "싱거";
			String str맹맹4 = "순한";

			int count초콜릿 = 0; // 초콜릿맛 count 10
			String str초코1 = "초코";
			String str초코2 = "쵸코";
			String str초코3 = "초콜";
			String str초코4 = "초컬";
			String str초코5 = "hocolate";
			String str초코6 = "코코아";

			int count신 = 0; // 신맛 count 11
			String str신1 = "신";
			String str신2 = "산미";
			String str신3 = "시다";
			String str신4 = "신맛";

			int count카라멜 = 0; // 카라멜맛count 12
			String str카라멜1 = "카라멜";
			String str카라멜2 = "케러멜";
			String str카라멜3 = "몰츠";
			String str카라멜4 = "멜츠";

			int count구수 = 0; // 구수함 count 13
			String str구수1 = "구수";
			String str구수2 = "고소";

			int count쌀 = 0;
			String str쌀1 = "쌀";

			int count꽃 = 0; // 꽃향 count 14
			String str꽃1 = "꽃";

			int count향긋 = 0; // 향긋 count 15
			String str향긋1 = "풋풋";
			String str향긋2 = "향긋";

			int count구린 = 0; // 16
			String str구린1 = "구린";
			String str구린2 = "고약";
			String str구린3 = "고린";

			int countPlain = 0; // 17
			String strPlain1 = "담백";
			String strPlain2 = "정갈";

			int countCrunchy = 0; // 18
			String strCrunchy1 = "오돌오돌";

			int countCool = 0; // 19
			String strCool1 = "시원";
			String strCool2 = "서늘";
			String strCool3 = "차가운";

			int countSticky = 0; // 20
			String strSticky1 = "쫄깃";
			String strSticky2 = "차진";
			String strSticky3 = "찐덕";

			int countAbundant = 0; // 21
			String strAbundant1 = "푸짐";

			int countTender = 0; // 22
			String strTender1 = "말랑";
			String strTender2 = "말캉";

			int countTick = 0; // 23
			String strTick1 = "걸쭉";

			int countHard = 0; // 24
			String strHard1 = "단단";
			String strHard2 = "딱딱";
			String strHard3 = "꼬들";

			int countSpicy = 0; // 25
			String strSpicy1 = "매운";
			String strSpicy2 = "매캐";
			String strSpicy3 = "매콤";
			String strSpicy4 = "매큼";
			String strSpicy5 = "맵싸";

			int countPeppery = 0; // 26
			String strPeppery1 = "얼큼";
			String strPeppery2 = "칼칼";

			// // 목넘김
			int countSwallowGood = 0;
			String str목넘김좋아1 = "좋";
			String str목넘김좋아2 = "부드";
			String str목넘김좋아3 = "꿀떡";
			String str목넘김좋아4 = "순";
			String str목넘김좋아5 = "목넘김도수월";
			String str목넘김좋아6 = "수월";
			String str목넘김좋아7 = "가벼";

			int countSwallowTough = 0;
			String str목넘김거칠1 = "거칠";
			String str목넘김거칠2 = "거친";

			// // 탄산 &거품

			int count탄산다 = 0; // 탄산 多
			String str탄산많1 = "강한";
			String str탄산많2 = "풍부";
			String str탄산많3 = "많은";

			int count탄산소 = 0; // 탄산 少
			String str탄산적1 = "적은";
			String str탄산적2 = "약한";
			String str탄산적3 = "보통";
			String str탄산적4 = "평이";

			int count거품다 = 0; // 거품 多
			String str거품많1 = "상당";
			String str거품많2 = "풍부";
			String str거품많3 = "수북";
			String str거품많4 = "풍성";
			String str거품많5 = "두텁";

			int count거품소 = 0; // 거품 少
			String str거품소1 = "적은";
			String str거품소2 = "약한";
			String str거품소3 = "조밀";

			// //////////////
			// 부정어//////
			// ////////

			String str부정1 = "않";
			// ///////////////
			// /// 퍼센트
			// ///////////////

			// total~ ; %로 빈도수 도출
			int total = 0; // count들의 합
			int totalSweet = 0;
			int totalBitterness = 0;
			int totalFruits = 0;
			int totalSoft = 0;
			int totalCoffee = 0;
			int totalFresh = 0;
			int totalBurn = 0;
			int total텁텁 = 0;
			int total맹맹 = 0;
			int total초콜릿 = 0;
			int total신 = 0;
			int total카라멜 = 0;
			int total구수 = 0;
			int total쌀 = 0;
			int total꽃 = 0;
			int total향긋 = 0;
			int total구린 = 0;
			int totalPlain = 0;
			int totalCrunchy = 0;
			int totalCool = 0;
			int totalSticky = 0;
			int totalAbundant = 0;
			int totalTender = 0;
			int totalTick = 0;
			int totalHard = 0;
			int totalSpicy = 0;
			int totalPeppery = 0;

			for (Sentence s : resultList) {

				Eojeol[] eojeolArray = s.getEojeols();
				for (int i = 0; i < eojeolArray.length; i++) {

					if (eojeolArray[i].length > 0) {

						String[] morphemes = eojeolArray[i].getMorphemes();

						for (int j = 0; j < morphemes.length; j++) {
							System.out.print(morphemes[j] + ",");

							boolean contains = morphemes[j].contains(str단1)
									|| morphemes[j].contains(str단2)
									|| morphemes[j].contains(str단3)
									|| morphemes[j].contains(str단4)
									|| morphemes[j].contains(str단5)
									|| morphemes[j].contains(str단6)
									|| morphemes[j].contains(str단7)
									|| morphemes[j].contains(str단8)
									|| morphemes[j].contains(str단9)
									|| morphemes[j].contains(str단10)
									|| morphemes[j].contains(str단11)
									|| morphemes[j].contains(str단12)
									|| morphemes[j].contains(str단13)
									|| morphemes[j].contains(str단14);
							if (contains == true) {
								countSweet++;
							}

							if (morphemes[j].equals(str단6)) {
								countSweet++;
							}

							contains = morphemes[j].contains(str쓴2)
									|| morphemes[j].contains(str쓴3)
									|| morphemes[j].contains(str쓴4)
									|| morphemes[j].contains(str쓴5)
									|| morphemes[j].contains(str쓴6)
									|| morphemes[j].contains(str쓴7);
							if (contains == true) {
								countBitterness++;
							}

							if (morphemes[j].equals(str쓴1)) {
								countBitterness++;
							}

							contains = morphemes[j].contains(str과일1)
									|| morphemes[j].contains(str과일2)
									|| morphemes[j].contains(str과일3)
									|| morphemes[j].contains(str과일4)
									|| morphemes[j].contains(str과일5)
									|| morphemes[j].contains(str과일6)
									|| morphemes[j].contains(str과일7)
									|| morphemes[j].contains(str과일8)
									|| morphemes[j].contains(str과일9)
									|| morphemes[j].contains(str과일10)
									|| morphemes[j].contains(str과일11)
									|| morphemes[j].contains(str과일12)
									|| morphemes[j].contains(str과일13)
									|| morphemes[j].contains(str과일14)
									|| morphemes[j].contains(str과일15)
									|| morphemes[j].contains(str과일16)
									|| morphemes[j].contains(str과일17)
									|| morphemes[j].contains(str과일18);
							if (contains == true) {
								countFruits++;

							}

							contains = morphemes[j].contains(str부드1)
									|| morphemes[j].contains(str부드2)
									|| morphemes[j].contains(str부드3)
									|| morphemes[j].contains(str부드4)
									|| morphemes[j].contains(str부드5)
									|| morphemes[j].contains(str부드6);
							if (contains == true) {
								countSoft++;
							}

							contains = morphemes[j].contains(str커피1)
									|| morphemes[j].contains(str커피2)
									|| morphemes[j].contains(str커피3)
									|| morphemes[j].contains(str커피4);
							if (contains == true) {
								countCoffee++;
							}

							contains = morphemes[j].contains(str깔끔1)
									|| morphemes[j].contains(str깔끔2)
									|| morphemes[j].contains(str깔끔3)
									|| morphemes[j].contains(str깔끔4)
									|| morphemes[j].contains(str깔끔5)
									|| morphemes[j].contains(str깔끔6);
							if (contains == true) {
								countFresh++;
							}

							contains = morphemes[j].contains(str탄1);
							if (morphemes[j].equals(str탄1)) {
								countBurn++;
							}
							contains = morphemes[j].contains(str텁텁1)
									|| morphemes[j].contains(str텁텁2)
									|| morphemes[j].contains(str텁텁3)
									|| morphemes[j].contains(str텁텁4);
							if (contains == true) {
								count텁텁++;
							}

							contains = morphemes[j].contains(str맹맹2)
									|| morphemes[j].contains(str맹맹3)
									|| morphemes[j].contains(str맹맹4);
							if (contains == true) {
								count맹맹++;
							}

							if (morphemes[j].equals(str맹맹1)) {
								count맹맹++;
							}

							contains = morphemes[j].contains(str초코1)
									|| morphemes[j].contains(str초코2)
									|| morphemes[j].contains(str초코3)
									|| morphemes[j].contains(str초코4)
									|| morphemes[j].contains(str초코5)
									|| morphemes[j].contains(str초코6);
							if (contains == true) {
								count초콜릿++;
							}

							contains = morphemes[j].contains(str신2)
									|| morphemes[j].contains(str신3)
									|| morphemes[j].contains(str신4);
							if (contains == true) {
								count신++;
							}

							if (morphemes[j].equals(str신1)) {
								count신++;
							}
							contains = morphemes[j].contains(str카라멜1)
									|| morphemes[j].contains(str카라멜2)
									|| morphemes[j].contains(str카라멜3)
									|| morphemes[j].contains(str카라멜4);
							if (contains == true) {
								count카라멜++;
							}

							contains = morphemes[j].contains(str구수1)
									|| morphemes[j].contains(str구수2);
							if (contains == true) {
								count구수++;
							}

							contains = morphemes[j].contains(str쌀1);
							if (contains == true) {
								count쌀++;
							}
							contains = morphemes[j].contains(str꽃1);
							if (contains == true) {
								count꽃++;
							}

							contains = morphemes[j].contains(str향긋1)
									|| morphemes[j].contains(str향긋2);
							if (contains == true) {
								count향긋++;
							}

							contains = morphemes[j].contains(str구린1)
									|| morphemes[j].contains(str구린2)
									|| morphemes[j].contains(str구린3);
							if (contains == true) {
								count구린++;
							}

							contains = morphemes[j].contains(strPlain1)
									|| morphemes[j].contains(strPlain2);
							if (contains == true) {
								countPlain++;
							}

							contains = morphemes[j].contains(strCrunchy1);
							if (contains == true) {
								countCrunchy++;
							}

							contains = morphemes[j].contains(strSticky1)
									|| morphemes[j].contains(strSticky2)
									|| morphemes[j].contains(strSticky3);
							if (contains == true) {
								countSticky++;
							}

							contains = morphemes[j].contains(strAbundant1);
							if (contains == true) {
								countAbundant++;
							}

							contains = morphemes[j].contains(strTender1)
									|| morphemes[j].contains(strTender2);
							if (contains == true) {
								countTender++;
							}

							contains = morphemes[j].contains(strTick1);
							if (contains == true) {
								countTick++;
							}

							contains = morphemes[j].contains(strHard1)
									|| morphemes[j].contains(strHard2)
									|| morphemes[j].contains(strHard3);
							if (contains == true) {
								countHard++;
							}

							contains = morphemes[j].contains(strSpicy1)
									|| morphemes[j].contains(strSpicy2)
									|| morphemes[j].contains(strSpicy3)
									|| morphemes[j].contains(strSpicy4)
									|| morphemes[j].contains(strSpicy5);
							if (contains == true) {
								countSpicy++;
							}

							contains = morphemes[j].contains(strPeppery1)
									|| morphemes[j].contains(strPeppery2);
							if (contains == true) {
								countPeppery++;
							}

							contains = morphemes[j].contains(str목넘김좋아2)
									|| morphemes[j].contains(str목넘김좋아3)
									|| morphemes[j].contains(str목넘김좋아5)
									|| morphemes[j].contains(str목넘김좋아6)
									|| morphemes[j].contains(str목넘김좋아7);
							if (contains == true) {
								countSwallowGood++;
							}

							if (morphemes[j].equals(str목넘김좋아1)
									|| morphemes[j].equals(str목넘김좋아4)) {
								countSwallowGood++;
							}
							contains = morphemes[j].contains(str목넘김거칠1)
									|| morphemes[j].contains(str목넘김거칠2);
							if (contains == true) {
								countSwallowTough++;
							}

							contains = morphemes[j].contains(str탄산많1)
									|| morphemes[j].contains(str탄산많2)
									|| morphemes[j].contains(str탄산많3);
							if (contains == true) {
								count탄산다++;
							}

							contains = morphemes[j].contains(str탄산적1)
									|| morphemes[j].contains(str탄산적2)
									|| morphemes[j].contains(str탄산적3)
									|| morphemes[j].contains(str탄산적4);
							if (contains == true) {
								count탄산소++;
							}

							contains = morphemes[j].contains(str거품많1)
									|| morphemes[j].contains(str거품많2)
									|| morphemes[j].contains(str거품많3)
									|| morphemes[j].contains(str거품많4)
									|| morphemes[j].contains(str거품많5);
							if (contains == true) {
								count거품다++;
							}
							contains = morphemes[j].contains(str거품소1)
									|| morphemes[j].contains(str거품소2)
									|| morphemes[j].contains(str거품소3);
							if (contains == true) {
								count거품소++;
							}

						}

					}

				}
			}
			// test.Percent();
			System.out.println();
			total = countSweet + countBitterness + countFruits + countSoft
					+ countCoffee + countFresh + countBurn + count텁텁 + count맹맹
					+ count초콜릿 + count신 + count카라멜 + count구수 + count쌀 + count꽃
					+ count향긋 + countPlain + countCrunchy + countCool
					+ countSticky + countCool + countSticky + countTender
					+ countTick + countHard + countSpicy + countPeppery;

			totalSweet = 100 * countSweet / total;
			totalBitterness = 100 * countBitterness / total;
			totalFruits = 100 * countFruits / total;
			totalSoft = 100 * countSoft / total;
			totalCoffee = 100 * countCoffee / total;
			totalFresh = 100 * countFresh / total;
			totalBurn = 100 * countBurn / total;
			total텁텁 = 100 * count텁텁 / total;
			total맹맹 = 100 * count맹맹 / total;
			total초콜릿 = 100 * count초콜릿 / total;
			total신 = 100 * count신 / total;
			total카라멜 = 100 * count카라멜 / total;
			total구수 = 100 * count구수 / total;
			total쌀 = 100 * count쌀 / total;
			total꽃 = 100 * count꽃 / total;
			total향긋 = 100 * count향긋 / total;
			total구린 = 100 * count구린 / total;
			totalPlain = 100 * countPlain / total;
			totalCrunchy = 100 * countCrunchy / total;
			totalCool = 100 * countCool / total;
			totalSticky = 100 * countSticky / total;
			totalAbundant = 100 * countAbundant / total;
			totalTender = 100 * countTender / total;
			totalTick = 100 * countTick / total;
			totalHard = 100 * countHard / total;
			totalSpicy = 100 * countSpicy / total;
			totalPeppery = 100 * countPeppery / total;
			// ///////////////////// // 출력
			// /////////////////////

			// System.out.println(total);
			System.out.println("*** 맛 & 향 ***");

			System.out.println("Sweet: " + countSweet + "번,Bitterness : "
					+ countBitterness + "번, 과일맛: " + countFruits + "번 , 부드러움: "
					+ countSoft + "번, 커피맛: " + countCoffee + "번, Fresh: "
					+ countFresh + "번");
			System.out.println("Burn: " + countBurn + "번, 텁텁함: " + count텁텁
					+ "번, 맹맹함: " + count맹맹 + "번, 초콜릿향/맛: " + count초콜릿
					+ "번, 신맛: " + count신 + "번, 카라멜맛: " + count카라멜 + "번, 구수함: "
					+ count구수 + "번, 꽃향: " + count꽃 + "번, 향긋: " + count향긋
					+ "번, 구린: " + count구린 + "번, Plain: " + countPlain
					+ "번, 바삭바삭: " + countCrunchy + "번, Cool: " + countCool
					+ "번, Sticky:" + countSticky + "번, Abundant: "
					+ countAbundant);

			System.out.println("Tender: " + countTender + "번, Tick: "
					+ countTick + "번, Hard: " + countHard + "번, Spicy: "
					+ countSpicy + "번, Peppery: " + countPeppery + "번");
			System.out.println();

			System.out.println("단맛	: " + totalSweet + "%");
			System.out.println("쓴맛	: " + totalBitterness + "%");
			System.out.println("과일맛/향	: " + totalFruits + "%");
			System.out.println("부드러움	: " + totalSoft + "%");
			System.out.println("커피맛/향	: " + totalCoffee + "%");
			System.out.println("상큼/깔끔함: " + totalFresh + "%");
			System.out.println("탄맛	: " + totalBurn + "%");
			System.out.println("텁텁함	: " + total텁텁 + "%");
			System.out.println("맹맹함	: " + total맹맹 + "%");
			System.out.println("초콜릿맛/향: " + total초콜릿 + "%");
			System.out.println("신맛	: " + total신 + "%");
			System.out.println("카라멜맛	: " + total카라멜 + "%");
			System.out.println("구수함	: " + total구수 + "%");
			System.out.println("쌀	: " + total쌀 + "%");
			System.out.println("꽃향	: " + total꽃 + "%");
			System.out.println("향긋	: " + total향긋 + "%");
			System.out.println("구린	: " + total구린 + "%");
			System.out.println("Plain	: " + totalPlain + "%");
			System.out.println("Crunchy	: " + totalCrunchy + "%");
			System.out.println("Cool	: " + totalCool + "%");
			System.out.println("Sticky	: " + totalSticky + "%");
			System.out.println("Abundant: " + totalAbundant + "%");
			System.out.println("Tender	: " + totalTender + "%");
			System.out.println("Tick	: " + totalTick + "%");
			System.out.println("Hard	: " + totalHard + "%");
			System.out.println("Spicy	: " + totalSpicy + "%");
			System.out.println("Peppery	: " + totalPeppery + "%");
			System.out.println();

			System.out.println("*** 목넘김***");
			System.out.println("좋아요!	: " + countSwallowGood + " 번");
			System.out.println("거칠어요!	: " + countSwallowTough + " 번");
			System.out.println();

			System.out.println("*** 탄산 & 거품***");
			System.out.println("탄산:		많아요! : " + count탄산다 + " 번");
			System.out.println("탄산:		적어요! : " + count탄산소 + " 번");
			System.out.println("거품:		많아요! : " + count거품다 + " 번");
			System.out.println("거품:		적어요! : " + count거품소 + " 번");
			System.out.println();

			System.out.println();

			workflow.close();

		} catch (

		Exception e)

		{
			e.printStackTrace();
			System.exit(0);
		}

		/* Shutdown the work flow */
		workflow.close();
		System.out.println("종료합니다......");

	}

}