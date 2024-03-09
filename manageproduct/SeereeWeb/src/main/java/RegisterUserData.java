

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterUserData")
public class RegisterUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
    public RegisterUserData() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		String userid = request.getParameter("user_id");
		String username = request.getParameter("user_name");		
		String password = request.getParameter("password");
		String role_name = request.getParameter("role");
		
	/*	out.println(userid);
		out.println(username);
		out.println(password);
		out.println(role_name);
	*/		
		try{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college2","root","");
			PreparedStatement stm = conn.prepareStatement("INSERT INTO `user_master` (`user_id`, `user_name`, `password`, `role_name`, `status`) VALUES (?,?,?,?,?);");
			stm.setString(1,userid);
			stm.setString(2,username);
			stm.setString(3,password);
			stm.setString(4,role_name);
			stm.setInt(5,1);
			int i = stm.executeUpdate();
			
			out.println("<h1 align=\"center\">"+i+"  Record Inserted.</h1>");
			
		/*	String htmlRespone = "<html> <h1>"+ i +"Row Inserted </h1><html>";
	  	    out.println(htmlRespone);	*/
	  	    
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

}
