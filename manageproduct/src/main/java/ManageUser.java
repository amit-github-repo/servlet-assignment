

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


@WebServlet("/ManageUser")
public class ManageUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ManageUser() {
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
		String btn = request.getParameter("btn");
		
		if (btn.equals("Delete")) {
			//out.println("delete "+user_id);
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}			
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college2","root","");
				String sql = "DELETE FROM user_master WHERE user_id=?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1,user_id);				
				pstm.execute();	
				conn.close();
				
				response.sendRedirect("admin.jsp");
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
	              
	        }
		}
		if (btn.equals("Edit")) {
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}			
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college2","root","");
				String sql = "SELECT * FROM user_master WHERE user_id=?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1,user_id);				
				ResultSet rs = pstm.executeQuery();				
				if(rs.next()) {
					response.sendRedirect("edit.jsp?user_id="+rs.getString("user_id")+"&user_name="+rs.getString("user_name")+"&password="+rs.getString("password")+"&role_name="+rs.getString("role_name")+"&status="+rs.getInt("status") );
				}
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
						
	        }
		}
		
	}

}
