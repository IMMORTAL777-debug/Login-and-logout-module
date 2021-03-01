package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdtPwd
 */
@WebServlet("/UpdtPwd")
public class UpdtPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdtPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail=request.getParameter("mail");
		String pwd=request.getParameter("pwd");
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");

		     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "cseb");
		     PreparedStatement ps = con.prepareStatement("update userdetails set password= ? where email= ?");
		     ps.setString(1, pwd);
		     ps.setString(2,mail);
		     ps.executeUpdate();
		 }
		 catch(Exception e) {
			 out.println(e);
		 }
	}

}
