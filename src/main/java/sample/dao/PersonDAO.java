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
		PreparedStatement pstmt = con.prepareStatement("SELECT id, name, email, password FROM person");
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
	public static int insert(Person person) throws ClassNotFoundException, SQLException {
		Connection con = DBConector.getConnect();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO person (name, email, password ) VALUES(?, ?, ?)");
		pstmt.setString(1, person.getName());
		pstmt.setString(2, person.getEmail());
		pstmt.setString(3, person.getPassword());
		return pstmt.executeUpdate();
	}
	public static int delete(Person person) throws ClassNotFoundException, SQLException {
		Connection con = DBConector.getConnect();
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM person WHERE id = ?");
		pstmt.setInt(1, person.getId());
		return pstmt.executeUpdate();
	}
}
