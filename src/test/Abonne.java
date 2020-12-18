package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Abonne {

	private String nomducompteA;
	private String nomducompteB;

	public Abonne(String nA, String nB) {
		nomducompteA = nA;
		nomducompteB = nB;
	}
	
	public void save() {
		if (findByNomDesComptes(nomducompteA, nomducompteB).isEmpty()) {
			this.saveNew();
		} 
	}

	private void saveNew() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "INSERT INTO abonne (nomducompteA, nomducompteC) VALUES (?,?)";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nomducompteA);
			ps.setString(2, this.nomducompteB);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "UPDATE abonne SET nomducompteC = ? WHERE nomducompteA = ?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nomducompteA);
			ps.setString(2, this.nomducompteB);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM abonne WHERE nomducompteA=? AND nomducompteC=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nomducompteA);
			ps.setString(2, this.nomducompteB);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String c, String cB) {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM abonne WHERE nomducompteA=? AND nomducompteC=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c);
			ps.setString(2, cB);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Abonne> findByNomDesComptes(String nomCompteA, String nomCompteB) {
		ArrayList<Abonne> res = new ArrayList<Abonne>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM abonne WHERE nomducompteA = ? AND nomducompteC = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nomCompteA);
			ps.setString(2, nomCompteB);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {

				res.add(new Abonne(nomCompteA, nomCompteB));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Abonne> findByNomDuCompteA(String nomCompte) {
		ArrayList<Abonne> res = new ArrayList<Abonne>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM abonne WHERE nomducompteA = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nomCompte);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nA = rs.getString("nomducompteA");
				String nB = rs.getString("nomducompteC");

				res.add(new Abonne(nA, nB));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Abonne> findByNomDuCompteB(String nomCompte) {
		ArrayList<Abonne> res = new ArrayList<Abonne>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM abonne WHERE nomducompteC = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nomCompte);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nA = rs.getString("nomducompteA");
				String nB = rs.getString("nomducompteC");

				res.add(new Abonne(nA, nB));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
