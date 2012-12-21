package servlets;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import beans.*;


public class ImageServlet extends HttpServlet {
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	InitialContext ctx = null;
	DataSource ds = null;
	Connection conn = null;
	PreparedStatement ps = null;
	Statement stmt = null;
	ResultSet rs = null;
	  
	String sql = "SELECT email FROM registeredusers WHERE email=?";
	  
	/*public void init () throws ServletException {
		
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
		    conn = ds.getConnection();
		    stmt = conn.createStatement();
		    ps = conn.prepareStatement(sql);
		}
		catch (SQLException se) {
			System.out.println("SQLException: "+se.getMessage());
		}
		catch (NamingException ne) {
			System.out.println("NamingException: "+ne.getMessage());  
		}  
	}
*/
	
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


	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		
		try {
			String email = req.getParameter("email"); 
			String password = req.getParameter("password");
			      
			resp.setContentType("text/html");
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body>");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (!rs.next()){
				writer.println("<p>Hello from servlet doGet()</p>");
				writer.println("<p>Email non risulta registrata!</p>");
				writer.println("<p>*mettere bottone REGISTRATI..*</p>");
			}
			else {
				writer.println("<p>sto nella parte dell'else..</p>");
				writer.println("<p>Login effettuato!</p>");
			}
			writer.println("</body></html>");
			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}  
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//Solo address, perchè id_image è autoincrementante
		String address = request.getParameter("address");
        
		//SessionFactory sf =  new Configuration().configure().buildSessionFactory(); 
        SessionFactory sf = configureSessionFactory();
		Session s = sf.openSession();
      
        Image img = new Image();
        img.setAddress(address);
        s.beginTransaction();
        s.save(img);
        s.getTransaction().commit();
        s.close();
        sf.close();
        out.println( "<h3>[" + address + "] has been registrated successfully!</h3>");
		/*String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>Follow Me Web</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1>Login effettuato con successo!</H1>\n" +
                "</BODY></HTML>");*/
	
	}
	
	private static SessionFactory configureSessionFactory() throws HibernateException {
	    Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	    return sessionFactory;
	}

}