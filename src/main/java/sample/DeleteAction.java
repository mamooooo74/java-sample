package sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.dao.PersonDAO;
import sample.model.Person;
import sample.tool.Action;

public class DeleteAction extends Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Person person = new Person();
		person.setId(Integer.parseInt(request.getParameter("id")));
		PersonDAO.delete(person);
	}

}
