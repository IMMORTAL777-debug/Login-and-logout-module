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
 * Servlet implementation class Updt
 */
@WebServlet("/Updt")
public class Updt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");

	    String pass = request.getParameter("pwd");
	    String country=request.getParameter("country");
	    String mail=request.getParameter("mail");
	    String phnnum=request.getParameter("phnnum");
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	    try {

	        Class.forName("oracle.jdbc.driver.OracleDriver");

	        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "cseb");

	        PreparedStatement ps = con.prepareStatement("insert into  userdetails values(?,?,?,?,?)");

	        ps.setString(1, name);
	        ps.setString(2, pass);
	        ps.setString(3, phnnum);
	        ps.setString(4, mail);
	        ps.setString(5, country);
	        ps.executeUpdate();
	    }
	    catch(Exception e) {
	    	out.println(e);
	    }
	}

}
