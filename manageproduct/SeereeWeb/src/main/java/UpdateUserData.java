

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


@WebServlet("/UpdateUserData")
public class UpdateUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateUserData() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		//PrintWriter out=response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String role_name = request.getParameter("role_name");
		int status = Integer.parseInt(request.getParameter("status"));
		
	/*	out.println(user_id);
		out.println(user_name);
		out.println(password);
		out.println(role_name);
		out.println(status);	
	*/	
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college2","root","");
			String sql = "UPDATE user_master SET user_name=?,password=?,role_name=?,status=? WHERE user_id=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1,user_name);
			pstm.setString(2,password);
			pstm.setString(3,role_name);
			pstm.setInt(4,status);
			pstm.setString(5,user_id.trim());
			pstm.executeUpdate();	
			conn.close();
			
			response.sendRedirect("admin.jsp");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
              
        }	
	}

}
