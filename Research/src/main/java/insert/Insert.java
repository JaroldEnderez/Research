
package insert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class Insert extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String un=request.getParameter("username");	
            String n=request.getParameter("name");
            String ad_name=request.getParameter("adviser_name");
            String gen=request.getParameter("gender");
            String dob=request.getParameter("dob");
            String section=request.getParameter("section");
		    String pw=request.getParameter("password"); 
		
		// Connect to mysql and verify username password
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // load driver
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/evoting", "root", "kitchennightmares"); // gets a new connection
 
		PreparedStatement ps = c.prepareStatement("insert into login(username,name,adviser_name,gender,dob,Grade_and_Section,password) values(?,?,?,?,?,?,?)");
				ps.setString(1, un);
                ps.setString(2, n);
                ps.setString(3, ad_name);
                ps.setString(4, gen);
                ps.setString(5, dob);
                ps.setString(6, section);
                ps.setString(7, pw);
 
		int result = ps.executeUpdate();
			
			if(result == 1){
				response.sendRedirect("suc.html");
			}
			else{
				response.sendRedirect("fail.html");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}