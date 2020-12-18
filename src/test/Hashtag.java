package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Hashtag {

	private String nom;
	private String contenutextuel;

	public Hashtag(String n, String c) {
		nom = n;
		contenutextuel = c;
	}

	private void saveNew() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "INSERT INTO Hashtag (nom, contenutextuel) VALUES (?,?)";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nom);
			ps.setString(2, this.contenutextuel);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "UPDATE Hashtag SET contenutextuel = ? WHERE nom = ?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nom);
			ps.setString(2, this.contenutextuel);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Hashtag WHERE nom=? AND contenutextuel=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nom);
			ps.setString(2, this.contenutextuel);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String c, String cb) {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Hashtag WHERE nom=? AND contenutextuel=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c);
			ps.setString(2, cb);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Hashtag> findBynom(String nom) {
		ArrayList<Hashtag> res = new ArrayList<Hashtag>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Hashtag WHERE nom = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nom);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String n = rs.getString("nom");
				String c = rs.getString("contenutextuel");

				res.add(new Hashtag(n, c));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Hashtag> findByContenuTextuel(String ct) {
		ArrayList<Hashtag> res = new ArrayList<Hashtag>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Hashtag WHERE contenutextuel = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, ct);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String n = rs.getString("nom");
				String c = rs.getString("contenutextuel");

				res.add(new Hashtag(n, c));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
