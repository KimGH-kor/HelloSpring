package jUnit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public DAO() {
		dbConnect();
	}

	public void dbConnect() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "dev";
		String password = "123456";

		try {
			Class.forName(driver);
			System.out.println("Driver Loading Sucess");

			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB Connected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public ArrayList<DTO> sltAll() throws Exception {
		ArrayList<DTO> dtoList = new ArrayList<DTO>();

		String sql = "SELECT * FROM SCORE ORDER BY CLSS, SEQ";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			DTO dto = new DTO();

			dto.setClss(rs.getString("CLSS"));
			dto.setSeq(rs.getString("SEQ"));
			dto.setKor(rs.getInt("KOR"));
			dto.setEng(rs.getInt("ENG"));
			dto.setMat(rs.getInt("MAT"));

			dtoList.add(dto);
		}

		rs.close();
		pstmt.close();

		return dtoList;

	}

	public DTO sltOne(String clss, String seq) throws Exception {
		DTO dto = null;
		String sql = "SELECT * FROM SCORE WHERE CLSS = ? AND SEQ = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, clss);
		pstmt.setString(2, seq);
		rs = pstmt.executeQuery();

		if (rs.next()) {
			dto = new DTO();
			dto.setClss(rs.getString("CLSS"));
			dto.setSeq(rs.getString("SEQ"));
			dto.setKor(rs.getInt("KOR"));
			dto.setEng(rs.getInt("ENG"));
			dto.setMat(rs.getInt("MAT"));
		}

		rs.close();
		pstmt.close();

		return dto;
	}

	public int insert(DTO dto) throws Exception {
		int cnt = 0;
		String sql = "INSERT INTO SCORE VALUES(?, ?, ?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, dto.getClss());
		pstmt.setString(2, dto.getSeq());
		pstmt.setInt(3, dto.getKor());
		pstmt.setInt(4, dto.getEng());
		pstmt.setInt(5, dto.getMat());

		cnt = pstmt.executeUpdate();

		pstmt.close();

		return cnt;
	}

	public int update(DTO dto) throws Exception {
		int cnt = 0;
		String sql = "UPDATE SCORE SET KOR = ?, ENG = ?, MAT = ? WHERE CLSS = ? AND SEQ = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, dto.getKor());
		pstmt.setInt(2, dto.getEng());
		pstmt.setInt(3, dto.getMat());
		pstmt.setString(4, dto.getClss());
		pstmt.setString(5, dto.getSeq());

		cnt = pstmt.executeUpdate();

		return cnt;
	}

	public int delete(String clss, String seq) throws Exception {
		int cnt = 0;
		String sql = "DELETE FROM SCORE WHERE CLSS = ? AND SEQ = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, clss);
		pstmt.setString(2, seq);

		cnt = pstmt.executeUpdate();

		pstmt.close();
		return cnt;
	}

	public void conClosed() {
		try {
			if (!con.isClosed()) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}