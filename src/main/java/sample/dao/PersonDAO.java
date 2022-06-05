package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sample.model.Person;
import sample.util.DBConector;

public class PersonDAO {
	public static List<Person> findAll() throws ClassNotFoundException, SQLException{
		List<Person> persons = new ArrayList<>();
		Connection con = DBConector.getConnect();
		PreparedStatement pstmt = con.prepareStatement("SELECT id, name, email, password FROM sample");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setEmail(rs.getString("email"));
			person.setPassword(rs.getString("password"));
			persons.add(person);
		}
		return persons;
	}
}
