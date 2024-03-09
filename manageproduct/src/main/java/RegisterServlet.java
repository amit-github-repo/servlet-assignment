

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String url="jdbc:mysql://localhost:3306/college";
			String username= "root";
			String pass = "";
			Connection conn = DriverManager.getConnection(url,username,pass);
			PrintWriter out=response.getWriter();
			if(conn != null) {
				out.println("<h3>Connection Sucessful</h3>");
			}
			Statement stm = conn.createStatement();
			String sql="select * from Employee";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				out.println(rs.getInt(1)+" | "+rs.getString(2)+" | "+rs.getInt(3)+" | "+rs.getString(4));
				out.println();
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
