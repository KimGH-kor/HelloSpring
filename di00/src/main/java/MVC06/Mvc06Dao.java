package MVC06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Mvc06Dao implements IMvc06Dao{

   Connection con;
   PreparedStatement pstmt;
   ResultSet rs;

   public Mvc06Dao() {
      dbConnect();
   }
   @Override
   public void dbConnect() {
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:XE";
      String user = "dev";
      String password = "123456";

      try {
         Class.forName(driver);
         System.out.println("Driver Loading Sucess!");

         con = DriverManager.getConnection(url, user, password);
         System.out.println("DB Connected...");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   @Override
   public ArrayList<Customer> sltMulti(int code) {
      ArrayList<Customer> custList = new ArrayList<Customer>();

      try {
         String sql = "SELECT * FROM CUSTOMER WHERE CODE >= ? ORDER BY CODE";
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, code);
         rs = pstmt.executeQuery();

         while (rs.next()) {
            Customer cust = new Customer();

            cust.setCode(rs.getInt("CODE"));
            cust.setName(rs.getString("NAME"));
            cust.setEmail(rs.getString("EMAIL"));
            cust.setTel(rs.getString("TEL"));
            cust.setWeight(rs.getDouble("WEIGHT"));

            custList.add(cust);
         }

         rs.close();
         pstmt.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return custList;

   }
   @Override
   public Customer sltOne(int code) {
      Customer c = null;
      try {
         String sql = "SELECT * FROM CUSTOMER WHERE CODE = ?";
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, code);
         rs = pstmt.executeQuery();

         if (rs.next()) {
            c = new Customer();

            c.setCode(rs.getInt("CODE"));
            c.setName(rs.getString("NAME"));
            c.setEmail(rs.getString("EMAIL"));
            c.setTel(rs.getString("TEL"));
            c.setWeight(rs.getDouble("WEIGHT"));

         }

         rs.close();
         pstmt.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return c;
   }
   @Override
   public int insertCst(Customer cst) {
      int cnt = 0;
      try {

         String sql = "INSERT INTO CUSTOMER VALUES(?, ?, ?, ?, ?)";
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, cst.getCode());
         pstmt.setString(2, cst.getName());
         pstmt.setString(3, cst.getEmail());
         pstmt.setString(4, cst.getTel());
         pstmt.setDouble(5, cst.getWeight());

         cnt = pstmt.executeUpdate();

         rs.close();
         pstmt.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return cnt;
   }
   @Override
   public int updateCst(Customer cst) {
      int cnt = 0;
      try {

         String sql = "UPDATE CUSTOMER SET name = ?, email = ?, tel = ?, weight = ? WHERE code = ?";
         pstmt = con.prepareStatement(sql);
         pstmt.setString(1, cst.getName());
         pstmt.setString(2, cst.getEmail());
         pstmt.setString(3, cst.getTel());
         pstmt.setDouble(4, cst.getWeight());
         pstmt.setInt(5, cst.getCode());

         cnt = pstmt.executeUpdate();

         rs.close();
         pstmt.close();
      } catch (Exception e) {
         e.printStackTrace();
      }

      return cnt;
   }
   @Override
   public int deleteCst(int code) {
      int cnt = 0;
      try {

         String sql = "DELETE FROM CUSTOMER WHERE CODE = ?";
         pstmt = con.prepareStatement(sql);
         pstmt.setInt(1, code);

         cnt = pstmt.executeUpdate();

         rs.close();
         pstmt.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return cnt;
   }
   @Override
   public void conClose() {
      try {
         if (!con.isClosed()) {
            con.close();
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

}