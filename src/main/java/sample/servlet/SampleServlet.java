package sample.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.dao.PersonDAO;
import sample.model.Person;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/list")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> persons = null;
		try {
			persons = PersonDAO.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("persons", persons);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index.jsp");
		dispatcher.forward(request, response);
	}

	

}
