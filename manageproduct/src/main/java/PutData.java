

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


@WebServlet("/PutData")
public class PutData extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public PutData() {
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
		int prodid = Integer.parseInt(request.getParameter("prodid"));
		int prodrate = Integer.parseInt(request.getParameter("prodrate"));
		int prodqty = Integer.parseInt(request.getParameter("prodqty"));
		int productvalue=prodrate*prodqty;
		PrintWriter out=response.getWriter();
		
		out.println(prodid);
		out.println(prodrate);
		out.println(prodqty);
		out.println(productvalue);
    /*		
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
			if(conn != null) {
				out.println("Connection Sucessful");
			}
			PreparedStatement stm = conn.prepareStatement("insert into Order_Master (OrderDate,ProductID,ProductRate,OrderQty,OrderValue) values (now(),?,?,?,?)");
			stm.setInt(1,prodid);
			stm.setInt(2,prodrate);
			stm.setInt(3,prodqty);
			stm.setInt(4,productvalue);
			int i = stm.executeUpdate();
			out.println( i+"  Record Inserted.");
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		} 
	*/
	} 

}
