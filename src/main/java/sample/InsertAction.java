package sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.dao.PersonDAO;
import sample.model.Person;
import sample.tool.Action;

public class InsertAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Person person = new Person();
		person.setName(request.getParameter("name"));
		person.setEmail(request.getParameter("email"));
		person.setPassword(request.getParameter("password"));
		PersonDAO.insert(person);
		return "WEB-INF/index.jsp";
	}

}
