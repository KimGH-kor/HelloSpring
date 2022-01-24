package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CstTcpRcv {

	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(8200);
		
		System.out.println("CstTcpRcv Server Start.");
		System.out.println("======================");

		Socket socket = server.accept();
		
        BufferedReader input = 
        	new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		
		String driver   = "oracle.jdbc.driver.OracleDriver";
		String url      = "jdbc:oracle:thin:@localhost:1521:XE";
		String user     = "dev";
		String password = "123456";
		
		String sql;
		PreparedStatement pstmt; 

		int cnt = 0;
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);
		
		sql = "INSERT INTO CUSTOMER2(code, name, email, tel, weight) " +
			  "VALUES(?, ?, ?, ?, ?)";
		pstmt = con.prepareStatement(sql);  
		
		while( true )
		{
            String rl = input.readLine();
            
			String[] col = rl.split(",",-1);

			if( "E".equals(col[0]) ) break;
			
			pstmt.setInt    (1, Integer.parseInt  (col[1]));      
			pstmt.setString (2,                    col[2] );
			pstmt.setString (3,                    col[3] );
			pstmt.setString (4,                    col[4] ); 
			pstmt.setDouble (5, Double.parseDouble(col[5]));

			pstmt.executeUpdate();
   
			cnt++; 
		}

		System.out.println(cnt + "건 처리 되었습니다.");
		
		pstmt.close();
		con.close();
		input.close();
		out.close();
		
		socket.close();
		server.close();
	}

}
