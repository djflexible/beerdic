package kr.ac.kaist.swrc.jhannanum.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class storeData1 {

	public static void main(String[] args) throws SAXException, IOException,
			ParserConfigurationException {

		// ExtractorFinal final_data = new ExtractorFinal();
		// final_data.extractorfinal();

		System.out.println("///////////");
		System.out.println("시작");

		try {

			Connection con = null;
			con = DriverManager.getConnection("jdbc:mysql://localhost", "root",
					"apmsetup"); // DB연결

			java.sql.Statement st = null;
			st = con.createStatement();

			ResultSet rs1 = st.executeQuery("USE beerfinal"); // 쿼리문 rs1 선언,DB
																// 선택
			ResultSet rs2 = st.executeQuery("SELECT * FROM beer_info1"); // 쿼리문
																			// rs2
																			// 선언,
																			// 테이블
																			// 보여주기

			// 변수
			StringBuffer sql_1 = new StringBuffer(); // sql문, 맥주 정보 저장 쿼리

			ExtractorFinal final_data = new ExtractorFinal();
			final_data.extractorfinal();

			System.out.println("체크1");
			// 필드 45개
			sql_1.append("INSERT INTO beer_info1 (sweet, sour, bitter, burn, coffee, caramel, chocolate, mint,"
					+ "apple, orange, lemon, strawberry, grape, blueberry, pineapple, raspberry, cranberry,"
					+ "banana, mango, cherry, kiwi, coconut, peach, grapefruit, lime,"
					+ "clean, fresh, soft, rough, bland, nut,"
					+ "chicken, pizza, cheese, salad, firefish, frenchfries, steak, sausage,"
					+ "acid, bubble,"
					+ "spring, summer, fall, winter) "
					+ "VALUES (?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?,"
					+ "?,?,?,?,?,?,?,?,?,?," + "?,?)"); // 매개변수 값을 변수에 넣음, 테이블
														// 이름 바꾸기 조심
			PreparedStatement g1 = con.prepareStatement(sql_1.toString());

			System.out.println("체크2");

			System.out.println("체크3");

			/*
			 * g1.setInt(1, sweet); g1.setInt(2, sour); g1.setInt(3, bitter);
			 * g1.setInt(4, burn); g1.setInt(5, coffee); g1.setInt(6, caramel);
			 * g1.setInt(7, chocolate); g1.setInt(8, mint);
			 * 
			 * g1.setInt(9, apple); g1.setInt(10, orange); g1.setInt(11, lemon);
			 * g1.setInt(12, strawberry); g1.setInt(13, grape); g1.setInt(14,
			 * blueberry); g1.setInt(15, pineapple); g1.setInt(16, raspberry);
			 * g1.setInt(17, cranberry); g1.setInt(18, banana); g1.setInt(19,
			 * mango); g1.setInt(20, cherry); g1.setInt(21, kiwi); g1.setInt(22,
			 * coconut); g1.setInt(23, peach); g1.setInt(24, grapefruit);
			 * g1.setInt(25, lime);
			 * 
			 * g1.setInt(26, clean); g1.setInt(27, fresh); g1.setInt(28, soft);
			 * g1.setInt(29, rough); g1.setInt(30, bland); g1.setInt(31, nut);
			 * 
			 * g1.setInt(32, chicken); g1.setInt(33, pizza); g1.setInt(34,
			 * cheese); g1.setInt(35, salad); g1.setInt(36, firefish);
			 * g1.setInt(37, frenchfries); g1.setInt(38, steak); g1.setInt(39,
			 * sausage);
			 * 
			 * g1.setInt(40, acid); g1.setInt(41, bubble);
			 * 
			 * g1.setInt(42, spring); g1.setInt(43, summer); g1.setInt(44,
			 * fall); g1.setInt(45, winter);
			 */

			g1.setInt(1, final_data.sweet);
			g1.setInt(2, final_data.sour);
			g1.setInt(3, final_data.bitter);
			g1.setInt(4, final_data.burn);
			g1.setInt(5, final_data.coffee);
			g1.setInt(6, final_data.caramel);
			g1.setInt(7, final_data.chocolate);
			g1.setInt(8, final_data.mint);

			g1.setInt(9, final_data.apple);
			g1.setInt(10, final_data.orange);
			g1.setInt(11, final_data.lemon);
			g1.setInt(12, final_data.strawberry);
			g1.setInt(13, final_data.grape);
			g1.setInt(14, final_data.blueberry);
			g1.setInt(15, final_data.pineapple);
			g1.setInt(16, final_data.raspberry);
			g1.setInt(17, final_data.cranberry);
			g1.setInt(18, final_data.banana);
			g1.setInt(19, final_data.mango);
			g1.setInt(20, final_data.cherry);
			g1.setInt(21, final_data.kiwi);
			g1.setInt(22, final_data.coconut);
			g1.setInt(23, final_data.peach);
			g1.setInt(24, final_data.grapefruit);
			g1.setInt(25, final_data.lime);

			g1.setInt(26, final_data.clean);
			g1.setInt(27, final_data.fresh);
			g1.setInt(28, final_data.soft);
			g1.setInt(29, final_data.rough);
			g1.setInt(30, final_data.bland);
			g1.setInt(31, final_data.nut);

			g1.setInt(32, final_data.chicken);
			g1.setInt(33, final_data.pizza);
			g1.setInt(34, final_data.cheese);
			g1.setInt(35, final_data.salad);
			g1.setInt(36, final_data.firefish);
			g1.setInt(37, final_data.frenchfries);
			g1.setInt(38, final_data.steak);
			g1.setInt(39, final_data.sausage);

			g1.setInt(40, final_data.acid);
			g1.setInt(41, final_data.bubble);

			g1.setInt(42, final_data.spring);
			g1.setInt(43, final_data.summer);
			g1.setInt(44, final_data.fall);
			g1.setInt(45, final_data.winter);
			g1.executeUpdate();
			// /////////

			if (st.execute("SELECT * FROM beer_info1")) {
				rs2 = st.getResultSet();
			}
			System.out.println("체크4");
			/*
			 * while (rs2.next()) {
			 * 
			 * String str1 = rs2.getNString(1); String str2 = rs2.getNString(2);
			 * String str3 = rs2.getNString(3); String str4 = rs2.getNString(4);
			 * String str5 = rs2.getNString(5);
			 * 
			 * System.out.println(str1);
			 * 
			 * str2.trim(); System.out.println(str2);
			 * 
			 * str3.trim(); System.out.println(str3);
			 * 
			 * str4.trim(); System.out.println(str4);
			 * 
			 * str5.trim(); System.out.println(str5);
			 * 
			 * 
			 * }
			 */
			System.out.println("///////////");
			System.out.println("실행 완료");

		} catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}

	}

}