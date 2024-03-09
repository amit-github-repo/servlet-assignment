

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ValidUser")
public class ValidUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public ValidUser() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		PrintWriter out=response.getWriter();
		String user_id = request.getParameter("user_id");		
		String password = request.getParameter("password");
	/*	
		out.println(user_id);
		out.println(password);
	*/
		try{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college2","root","");
			String sql = "select * from user_master where user_id=? and password=?";
			PreparedStatement stm = conn.prepareStatement(sql);
			stm.setString(1,user_id);
			stm.setString(2,password);
			ResultSet rs = stm.executeQuery();
				//alert(rs);
			while (rs.next()) {
				int status = rs.getInt("status");
				String user_name = rs.getString("user_name");
				String role_name = rs.getString("role_name");
					//out.println(user_name+" "+role_name+" "+status);	
				if (status == 1) {
					
					HttpSession session = request.getSession();
					session.setAttribute("user_name", user_name);
					session.setAttribute("user_id", user_id);
					
					if("student".equals(role_name)) {
						response.sendRedirect("student.jsp");
					}else if ("teacher".equals(role_name)) {
						response.sendRedirect("teacher.jsp");
					}else if ("admin".equals(role_name)) {
						response.sendRedirect("admin.jsp");
					}
					
				}else out.println("You are not a Active User.");
			}
			
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
