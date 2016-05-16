package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;

import kr.ac.kaist.swrc.jhannanum.comm.Eojeol;
import kr.ac.kaist.swrc.jhannanum.comm.Sentence;
import kr.ac.kaist.swrc.jhannanum.hannanum.Workflow;
import kr.ac.kaist.swrc.jhannanum.hannanum.WorkflowFactory;

import org.xml.sax.SAXException;

public class WorkflowNounExtractor2 {

	public static void main(String[] args) throws SAXException, IOException,
			ParserConfigurationException {

		/* 각 형태소들이 순서대로 들어있는 배열 */

		ArrayList<String> morpheme_Array = new ArrayList<String>();

		/* 중복을 제거한 형태소들이 들어있는 배열 */

		ArrayList<String> itemList = new ArrayList<String>();

		/* 형태소들의 갯수가 들어있는 배열 */

		ArrayList<Integer> cntList = new ArrayList<Integer>();

		Naver_Extract_print use_parameter = new Naver_Extract_print();

		// TSearch2 use_parameter2 = new TSearch2();

		Workflow workflow = WorkflowFactory

		.getPredefinedWorkflow(WorkflowFactory.WORKFLOW_NOUN_EXTRACTOR);

		System.out.println("시작 중입니다......");

		String document2 = use_parameter.target_page(); // 네이버 크롤러

		// String document3 = use_parameter2.target_page2(); //다음 크롤러

		try {

			workflow.activateWorkflow(true);

			workflow.analyze(document2); // 네이버 크롤러

			// workflow.analyze(document3); //다음 크롤러

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

			/* 오름차순으로 변경 */

			for (int sourceIndex = 0; sourceIndex < cntList.size() - 1; sourceIndex++) {

				for (int targetIndex = sourceIndex + 1; targetIndex < cntList
						.size(); targetIndex++) {

					if (cntList.get(sourceIndex) < cntList.get(targetIndex)) {

						int moveItem = 0;

						String moveItem2 = "";

						// cntList 위치 변경

						moveItem = cntList.get(targetIndex);

						cntList.set(targetIndex, cntList.get(sourceIndex));

						cntList.set(sourceIndex, moveItem);

						// itemList 위치 변경

						moveItem2 = itemList.get(targetIndex);

						itemList.set(targetIndex, itemList.get(sourceIndex));

						itemList.set(sourceIndex, moveItem2);

					}

				}

			}

			/* 출력 부분 */

			for (int i = 0; i < cntList.size(); i++) {

				System.out.println(itemList.get(i) + ":" + cntList.get(i));

			}

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