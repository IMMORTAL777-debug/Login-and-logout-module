package project;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 * Servlet implementation class Pros
 */
@WebServlet("/Pros")
public class Pros extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pros() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String name = request.getParameter("uname");

	    String pass = request.getParameter("pwd");
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();

	    try {

	        Class.forName("oracle.jdbc.driver.OracleDriver");

	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "cseb");

	        PreparedStatement ps = con.prepareStatement("select * from userdetails where name=? and password=?");

	        ps.setString(1, name);

	        ps.setString(2, pass);

	        ResultSet rs = ps.executeQuery();

	        int x = 0;

	        while (rs.next()) {

	            if (rs.getString(1).equals(name) && rs.getString(2).equals(pass)) {

	                x = 1;

	            } else {

	                x = 2;

	            }

	        }

	        if (x == 1) {

	             HttpSession s = request.getSession();

	    out.println("<center><h1>Welcome: " + name + "</h1>");

	    out.println("<br/><b>You are successfully login........ ");

	} 
	  else {

	    out.println("<center>" + "<b>Either You Enter Wrong UserName or Password</b>");

	    } 
	    }catch (Exception ex) {

	        out.println(ex);

	    } 


}
}


