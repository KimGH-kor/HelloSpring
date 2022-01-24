package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CstTcpSend {
	
	public static void main(String[] args) throws Exception {
		
		String driver   = "oracle.jdbc.driver.OracleDriver";
		String url      = "jdbc:oracle:thin:@localhost:1521:XE";
		String user     = "dev";
		String password = "123456";
		
		String sql;
		PreparedStatement pstmt; 
		ResultSet rs;

        Socket s = new Socket("localhost", 8200);
        
        BufferedReader input = 
	        	new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
		
		int code;
		String name, email, tel;
		double weight;

		int cnt = 0;
		
		Class.forName(driver);
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		sql = "SELECT * FROM CUSTOMER ORDER BY CODE";
		pstmt = con.prepareStatement(sql);  
		
		rs = pstmt.executeQuery();
		
		while (rs.next())
		{
			code   = rs.getInt   ("code"  );
			name   = rs.getString("name"  );
			email  = rs.getString("email" );
			tel    = rs.getString("tel"   );
			weight = rs.getDouble("weight");
			
			out.printf("C,%s,%s,%s,%s,%s", String.valueOf(code), name, email, tel, String.valueOf(weight));
			out.println();
			cnt++;
		}

		out.printf("E,,,,,");
		out.println();

		System.out.println(cnt + "건 처리 되었습니다.");
		
		rs.close();
		pstmt.close();
		con.close();
		out.close();
		input.close();
		s.close();
	}

}