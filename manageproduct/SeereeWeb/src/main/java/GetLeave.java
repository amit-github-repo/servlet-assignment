

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


@WebServlet("/GetLeave")
public class GetLeave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetLeave() {
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
		String emp_id=request.getParameter("emp_id");
		PrintWriter out=response.getWriter();
			//out.print(emp_id);
		try{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college2","root","");
			Statement stmt = conn.createStatement();
			String sql="SELECT lm.leave_id,lm.leave_name,v1.no_of_leave FROM leave_master as lm, (select emp_id,leave_id,no_of_leave from leave_emp_assign WHERE emp_id='"+emp_id+"') as v1 WHERE lm.leave_id=v1.leave_id;";
			ResultSet rs = stmt.executeQuery(sql);
			
			JSONArray json = new JSONArray();
			ResultSetMetaData rsmd = rs.getMetaData();
						
			while(rs.next()){
				int numColumns = rsmd.getColumnCount();
				JSONObject obj = new JSONObject();
				for (int i=1; i<=numColumns; i++) {
					String column_name = rsmd.getColumnName(i);
					obj.put(column_name,rs.getObject(column_name));
				}
				json.put(obj);
			}
			out.print(json);
			conn.close();	
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} 
	}

}
