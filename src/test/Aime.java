package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Aime {

	private String nomducompte;
	private String contenutextuel;

	public Aime(String n, String c) {
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
			String sql = "INSERT INTO Aime (nomducompte, contenutextuel) VALUES (?,?)";
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
			String sql = "UPDATE Aime SET contenutextuel = ? WHERE nomducompte = ?";
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
			String sql = "DELETE FROM Aime WHERE nomducompte=? AND contenutextuel=?";
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
			String sql = "DELETE FROM Aime WHERE nomducompte=? AND contenutextuel=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c);
			ps.setString(2, cb);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Aime> findByNomDuCompte(String nomCompte) {
		ArrayList<Aime> res = new ArrayList<Aime>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Aime WHERE nomducompte = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nomCompte);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String n = rs.getString("nomducompte");
				String c = rs.getString("contenutextuel");

				res.add(new Aime(n, c));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Aime> findByContenuTextuel(String ct) {
		ArrayList<Aime> res = new ArrayList<Aime>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Aime WHERE contenutextuel = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, ct);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String n = rs.getString("nomducompte");
				String c = rs.getString("contenutextuel");

				res.add(new Aime(n, c));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
