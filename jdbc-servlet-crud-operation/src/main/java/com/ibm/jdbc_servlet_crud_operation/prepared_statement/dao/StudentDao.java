package com.ibm.jdbc_servlet_crud_operation.prepared_statement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ibm.jdbc_servlet_crud_operation.prepared_Connection.JdbcConnection;
import com.ibm.jdbc_servlet_crud_operation.prepared_statement.dto.Student;

public class StudentDao {

	Connection connection = JdbcConnection.getConnection();

	// CREATE
	public int saveStudentDao(Student student) {

		String insertStudentQuery =
				"insert into student(id,name,email,phone,password,address,dob) values(?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(insertStudentQuery);

			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getEmail());
			ps.setLong(4, student.getPhone());
			ps.setString(5, student.getPassword());
			ps.setString(6, student.getAddress());
			ps.setObject(7, student.getDob());

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// READ
	public List<Student> getAllStudentDao() {

		PreparedStatement ps = null;
		List<Student> students = new ArrayList<>();

		try {
			String displayStudentQuery = "SELECT * FROM student";
			ps = connection.prepareStatement(displayStudentQuery);
			ResultSet set = ps.executeQuery();

			while (set.next()) {

				Student student = new Student();

				student.setId(set.getInt("id"));
				student.setName(set.getString("name"));
				student.setEmail(set.getString("email"));
				student.setPassword(set.getString("password"));
				student.setPhone(set.getLong("phone"));
				student.setAddress(set.getString("address"));

				LocalDate dob = set.getDate("dob").toLocalDate();
				student.setDob(dob);

				students.add(student);
			}

			return students;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// DELETE
	public boolean deleteStudentByIdDao(int studentId) {

		PreparedStatement ps = null;
		String deleteStudentByIdQuery = "delete from student where id=?";

		try {
			ps = connection.prepareStatement(deleteStudentByIdQuery);
			ps.setInt(1, studentId);

			int a = ps.executeUpdate();
			return a != 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// UPDATE
	public int updateStudentNameDao(int studentId, String newName) {

		PreparedStatement ps = null;
		String updateStudentNameQuery = "update student set name=? where id=?";

		try {
			ps = connection.prepareStatement(updateStudentNameQuery);

			ps.setString(1, newName);
			ps.setInt(2, studentId);

			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// READ BY EMAIL
	public Student getStudentByEmailDao(String email) {

		PreparedStatement ps = null;

		try {
			String getStudentByEmailQuery =
					"SELECT * FROM student where email=?";

			ps = connection.prepareStatement(getStudentByEmailQuery);
			ps.setString(1, email);

			ResultSet set = ps.executeQuery();

			if (set.next()) {

				Student student = new Student();

				student.setEmail(set.getString("email"));      // ✅ fixed
				student.setPassword(set.getString("password"));

				return student;
			}

			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (ps != null)
					ps.close();
				// ❌ connection.close() REMOVED
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public Student getStudentByIdDao(int studentid) {
		PreparedStatement ps = null;
		try {
			String displayStudentQuery = "SELECT * FROM STUDENT where id=?";
			
			ps = connection.prepareStatement(displayStudentQuery);

			ps.setInt(1, studentid);
			
			ResultSet set = ps.executeQuery();

			if (set.next()) {

				int id = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				String password = set.getString("password");
				long phone = set.getLong("phone");
				String address = set.getString("address");
				LocalDate dob = set.getDate("dob").toLocalDate();

				Student student = new Student();

				student.setId(id);
				student.setName(name);
				student.setEmail(email);
				student.setPassword(password);
				student.setPhone(phone);
				student.setAddress(address);
				student.setDob(dob);
				return student;
			}

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public int updateStudentDao(Student student) {
		
		String updateStudentQuery = "update student set name=?,email=?,phone=?,password=?,address=?,dob=? where id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(updateStudentQuery);
			
			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());
			ps.setLong(3, student.getPhone());
			ps.setString(4, student.getPassword());
			ps.setString(5, student.getAddress());
			ps.setObject(6, student.getDob());
			ps.setInt(7, student.getId());
			
			int a = ps.executeUpdate();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
	
	

