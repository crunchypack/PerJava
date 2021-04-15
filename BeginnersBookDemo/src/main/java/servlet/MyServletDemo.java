package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServletDemo
 */
@WebServlet("/MyServletDemo")
public class MyServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String mymsg;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		mymsg = "Hello World";
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>" + mymsg + "</h1>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String u  ="haseeb";
		String p = "123";
		String username = request.getParameter("myname");
		String password = request.getParameter("password");
		
		if(u.equals(username) || p.equals(password)) {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			request.setAttribute("username", username);
			request.setAttribute("password", username);
			
			RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			
			RequestDispatcher rd = request.getRequestDispatcher("/fail.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
