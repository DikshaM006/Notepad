package com.Alpha.Notepad.dao;

import com.Alpha.Notepad.dto.Notepad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NotepadDao {
	private String url = "jdbc:postgresql://localhost:5432/eca_jdbc";
	private String username = "postgres";
	private String password = "root";

	public Notepad saveNotepad(Notepad notepad) {
		try {
			Class.forName("org.postgresql.Driver");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				
				String sql="INSERT INTO notepad VALUES (?, ?, ?)";
				PreparedStatement psmt = con.prepareStatement(sql);

				psmt.setInt(1, notepad.getNotepadId());
				psmt.setString(2, notepad.getNotepadTitle());
				psmt.setString(3, notepad.getNotepadContent());

				int res = psmt.executeUpdate();
				if (res > 0) {
					System.out.println("Data inserted successfully!!");
				} else {
					System.out.println("Data not inserted");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return notepad;
	}

	public Notepad updateNotepad(Notepad notepad) {

		try {
			// step 1
			Class.forName("org.postgresql.Driver");

			// step 2
			try (Connection con = DriverManager.getConnection(url, username, password)) {

				String sql = "UPDATE  notepad SET notepadtitle=?,notepadcontent=? WHERE notepadid=?";
                
				// step 3
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setString(1, notepad.getNotepadTitle());
				psmt.setString(2, notepad.getNotepadContent());
				psmt.setInt(3, notepad.getNotepadId());

				// step 4
				psmt.execute();
				System.out.println("upadted succesfull");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return notepad;
	}

	public Notepad findNotepadById(int notepadId) {
		Notepad note=null;
		try {
			Class.forName("org.postgresql.Driver");

			try (Connection con = DriverManager.getConnection(url, username, password)) {

				String sql = "SELECT * FROM notepad WHERE notepadid=?";
				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setInt(1, notepadId);

				ResultSet rs = psmt.executeQuery(); // Use executeUpdate() for UPDATE
				if (rs.next()) {
					 note= new Notepad(rs.getInt(1), rs.getString(2), rs.getString(3));

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return note;
	}

	public List<Notepad> displayAll() {
		List<Notepad> list = new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");

			Connection con = DriverManager.getConnection(url, username, password);

			Statement smt = con.createStatement();
			String sql = "SELECT * FROM notepad";
			ResultSet rs = smt.executeQuery(sql);
			while (rs.next()) {
				list.add(new Notepad(rs.getInt(1), rs.getString(2), rs.getString(3)));

			}
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean deleteById(int notepadId) {
		try {
			Class.forName("org.postgresql.Driver");

			try (Connection con = DriverManager.getConnection(url, username, password)) {
				String sql = "DELETE FROM notepad WHERE notepadid=?";

				PreparedStatement psmt = con.prepareStatement(sql);
				psmt.setInt(1, notepadId);
				psmt.executeUpdate();
				System.out.println("Deleted Sucessfuly!");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
}
