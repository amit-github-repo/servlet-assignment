

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetProduct")
public class GetProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
    public GetProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String prodname=request.getParameter("prodname");
		
//		PrintWriter out=response.getWriter();
//		out.println(prodname);
		
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
//			if(conn != null) {
//				out.println("Connection Sucessful");
//				out.println();
//			}
			Statement stm = conn.createStatement();
			String sql="select * from Product_Master where ProductName='"+prodname+"'";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				out.println("{\"prodid\":"+rs.getInt(1)+",\"prodrate\":"+rs.getInt(3)+",\"prodqty\":"+rs.getInt(4)+"}");
			}
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
