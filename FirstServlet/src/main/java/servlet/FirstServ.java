	package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServ
 */
@WebServlet("/FirstServ")
public class FirstServ extends HttpServlet {
	private int count = 0;

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServ() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet Initialized.... Value of count is: " + count);
	}
    /**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Servlet removed from service.....Total visitor count is " + count);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		out.print("<html><head>");
		out.print("<title>My first test</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1> This is my voice from java </h1>");
		out.print("<p> Request Number : " + count + " is received </p>");
		out.print("</body>");
		
		count ++;
	}


}
