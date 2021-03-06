package sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.tool.Action;

/**
 * Servlet implementation class PersonController
 */
@WebServlet("*.action")
public class PersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonController() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String path = request.getServletPath().substring(1);
			String name = path.replace(".a", "A").replace("/", ".");
			Action action=(Action)Class.forName("sample."+name).getConstructor().newInstance();
			action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("/list");
	}

}
