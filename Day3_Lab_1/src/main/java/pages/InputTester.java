package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/inputtesterlink")
public class InputTester extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try (PrintWriter pst = response.getWriter()) {
		
			pst.print("<h2>Hello,"+request.getParameter("f1")+"</h2>");
			pst.print("<h2>Choosen Colour : "+(Arrays.toString(request.getParameterValues("clr"))+"</h2>"));
			pst.print("<h2>Favorite Browser :"+request.getParameter("browser")+"</h2>");
			pst.print("<h2>Native city :"+request.getParameter("myselect")+"</h2>");
			pst.print("<h2>About : "+request.getParameter("info")+"</h2>");
		}
	}
}
