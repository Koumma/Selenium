package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Retweet {

	private String nomducompte;
	private String contenutextuel;

	public Retweet(String n, String c) {
		nomducompte = n;
		contenutextuel = c;
	}
	
	
	public void save() {
		if (findByContenuTextuel(this.contenutextuel).isEmpty()) {
			this.saveNew();
		} else {
			this.update();
		}
	}
	

	private void saveNew() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "INSERT INTO Retweet (nomducompte, contenutextuel) VALUES (?,?)";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nomducompte);
			ps.setString(2, this.contenutextuel);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "UPDATE Retweet SET contenutextuel = ? WHERE nomducompte = ?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nomducompte);
			ps.setString(2, this.contenutextuel);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Retweet WHERE nomducompte=? AND contenutextuel=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nomducompte);
			ps.setString(2, this.contenutextuel);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String c, String cb) {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Retweet WHERE nomducompte=? AND contenutextuel=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c);
			ps.setString(2, cb);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Retweet> findByNomDuCompte(String nomCompte) {
		ArrayList<Retweet> res = new ArrayList<Retweet>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Retweet WHERE nomducompte = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nomCompte);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String n = rs.getString("nomducompte");
				String c = rs.getString("contenutextuel");

				res.add(new Retweet(n, c));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Retweet> findByContenuTextuel(String ct) {
		ArrayList<Retweet> res = new ArrayList<Retweet>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Retweet WHERE contenutextuel = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, ct);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String n = rs.getString("nomducompte");
				String c = rs.getString("contenutextuel");

				res.add(new Retweet(n, c));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
