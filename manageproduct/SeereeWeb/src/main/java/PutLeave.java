

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


@WebServlet("/PutLeave")
public class PutLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PutLeave() {
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
		PrintWriter out=response.getWriter();
		int emp_id = Integer.parseInt(request.getParameter("emp_name"));
		int leave_id = Integer.parseInt(request.getParameter("leave_name"));
		int no_of_leave = Integer.parseInt(request.getParameter("no_of_leave"));
		
	/*	out.println(emp_id);
		out.println(leave_id);
		out.println(no_of_leave);	*/
		try{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college2","root","");
	
			PreparedStatement stm = conn.prepareStatement("INSERT INTO `leave_apply` (`emp_id`, `leave_id`, `no_of_leave`) VALUES (?,?,?);");
			stm.setInt(1,emp_id);
			stm.setInt(2,leave_id);
			stm.setInt(3,no_of_leave);
			int i = stm.executeUpdate();
			out.println( i+"  Record Inserted.");
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		} 
	}

}
