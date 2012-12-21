package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class RegisterServlet extends HttpServlet {

	InitialContext ctx = null;
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement ps = null;
	Statement stmt = null;
	ResultSet rs, resultSet= null;
	  
	//String sql = "SELECT * from registeredusers";
	String sql = "SELECT email FROM registeredusers WHERE email=?";

	public void init () throws ServletException {
		
		try {
			ctx = new InitialContext();
			//ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQLDataSource");
			ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
			conn = ds.getConnection();
			stmt = conn.createStatement();
			ps = conn.prepareStatement(sql);
			//ps1 = conn.prepareStatement(sql1);
	    }
	    catch (SQLException se) {
	    	System.out.println("SQLException: "+se.getMessage());
	    }
	    catch (NamingException ne) {
	    	System.out.println("NamingException: "+ne.getMessage());  
	    }  
	}

	
	public void destroy () {
	
		try {
	    	if (rs != null)
	    		rs.close();
	    	if (ps != null)
	    		ps.close();
	    	if (conn != null)
	    		conn.close();
	    	if (ctx != null)
	    		ctx.close();
		}     
	    catch (SQLException se) {
	    	System.out.println("SQLException: "+se.getMessage());
	    }
	    catch (NamingException ne) {
	    	System.out.println("NamingException: "+ne.getMessage());  
	    }  
	}


	public void doPost(HttpServletRequest req, HttpServletResponse resp){

		try {
			String email = req.getParameter("email"); 
		    String password = req.getParameter("password");
		    String name = req.getParameter("name");
		    String surname = req.getParameter("surname");
		    String dob = req.getParameter("dob");
		      
		    resp.setContentType("text/html");
		    PrintWriter out = resp.getWriter();
		    String docType =
		    		    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
		    		    "Transitional//EN\">\n";
		    		    out.println(docType + "<HTML>\n");
		    
		    ps.setString(1, email);
		    rs = ps.executeQuery();
		    if (!rs.next()){
		    	out.print("<p>ABBSto dentro il primo if.. Data = " + dob + "</p>");
		    	//metto i dati raccolti nel db 
			    stmt.executeUpdate("INSERT into registeredusers(email, password, name, surname, dob) values ('"+ email + "', '"+ password+"', '" + name + "', '"+ surname + "', '20000101')");
			    String title = "Registrazione avvenuta. Questi sono i dati forniti";
			    resultSet = stmt.executeQuery("SELECT * from registeredusers where email= '"+ email +"'");
			    out.print("<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	                "<H1 ALIGN=CENTER>" + title + "</H1>\n" +
	                "<TABLE BORDER=1>");

			    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			    int columnCount = resultSetMetaData.getColumnCount();
	            // Column index starts at 1 (a la SQL), not 0 (a la Java).
	            while(resultSet.next()) {
	            	for(int i=1; i <= columnCount; i++) {
	            		out.println("<TR>" +
	                				"<TD>" + resultSetMetaData.getColumnName(i) + "</TD>" +
	                				"<TD>" + resultSet.getString(i) +"</TD>" +
	                				"</TR>");
	            	}
	            }

	            out.println("</TABLE>");
	            conn.close();
		    }
		    else {
		    	out.println("<p>sto nella parte dell'else..</p>");
		    	rs.beforeFirst();
		        while(rs.next()) {
		        	out.println("<p>L'email è già registrata idiotaaaa!!</p>");
		        }
		    }
		    out.println("</body></html>");
		      
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
	
		try {    
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			rs = stmt.executeQuery("SELECT * FROM registeredusers");   		  
			writer.println("<html><body>");
			writer.println("<p>Hello from servlet doGet()</p>");
			//rs.beforeFirst();
			while (rs.next()) {
				writer.print("<p>" + rs.getString("email") + "</p>");	
			}
			writer.println("</body></html>");
			writer.close(); 
		}
	    catch (Exception e) {
	    	e.printStackTrace();
	    }  
	}
	
}