package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String user = "student", pass = "student";

	@Override
	public Film getFilmById(int filmId) {
		String sql = "SELECT f.title, f.release_year, f.rating, f.description, l.name, f.id FROM film f JOIN language l ON f.language_id = l.id WHERE f.id = ?";
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			int count = 0;
			OUTERLOOP: while (count == 0) {
				while (rs.next()) {
					String title = rs.getString(1);
					Date releaseYear = rs.getDate(2);
					String rating = rs.getString(3);
					String description = rs.getString(4);
					String language = rs.getString(5);
					int id = rs.getInt(6);

					List<Actor> cast = getActorsByFilmId(id);
					film = new Film(title, releaseYear, rating, cast, language, description);
					count++;

				}
				rs.close();
				stmt.close();
				conn.close();

				if (film == null) {
					System.out.println("\t*****No films found matching Film ID:" + " \"" + filmId + "\""
							+ ", please search again.*****");
					film = new Film();
					break OUTERLOOP;
				}

			}

		} catch (SQLException sqlex) {
			System.err.println("Error retrieving film id " + filmId);
			sqlex.printStackTrace();
		}

		return film;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Unable to load DB driver. Exiting");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public Actor getActorById(int actorId) {
		Connection conn;
		String sql;
		PreparedStatement stmt;
		ResultSet rs;
		Actor actor = null;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);

				actor = new Actor(id, fName, lName);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqlex) {
			System.err.println("Error retrieving ACTOR ID." + actorId);
			sqlex.printStackTrace();
		}

		return actor;
	}

	@Override
	public List<Actor> getActorsByFilmId(int filmId) {
		List<Actor> cast = new ArrayList<>();
		Connection conn;
		String sql = "SELECT id, first_name, last_name FROM actor JOIN film_actor ON actor.id = film_actor.actor_id WHERE film_actor.film_id = ?";
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String fName = rs.getString(2);
				String lName = rs.getString(3);
				Actor actor = new Actor(id, fName, lName);
				cast.add(actor);

			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException sqlex) {
			System.err.println("Error retrieving actors for film " + filmId);
			sqlex.printStackTrace();
		}

		return cast;
	}

	@Override
	public Film getFilmByKeyword(String keyword) {
		String sql = "SELECT f.title, f.release_year, f.rating, f.description, l.name, f.id FROM film f JOIN language l ON f.language_id = l.id WHERE title like ? OR description like ?";
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String title = rs.getString(1);
				Date releaseYear = rs.getDate(2);
				String rating = rs.getString(3);
				String description = rs.getString(4);
				String language = rs.getString(5);
				int id = rs.getInt(6);

				List<Actor> cast = getActorsByFilmId(id);
				film = new Film(title, releaseYear, rating, cast, language, description);
			}

			if (film == null) {
				System.out.println("\t*****No films found matching" + " \"" + keyword.toUpperCase() + "\""
						+ ", please search again.*****");
				film = new Film();
			}
			rs.close();
			stmt.close();
			conn.close();
		}

		catch (SQLException sqlex) {
			System.err.println("Error retrieving film keyword " + keyword.toUpperCase());
			sqlex.printStackTrace();
		}

		return film;
	}

}
