package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Abonnement {

	private String nomducompteA;
	private String nomducompteB;

	public Abonnement(String nA, String nB) {
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
			String sql = "INSERT INTO abonnement (nomducompteA, nomducompteC) VALUES (?,?)";
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
			String sql = "UPDATE abonnement SET nomducompteC = ? WHERE nomducompteA = ?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nomducompteB);
			ps.setString(2, this.nomducompteA);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM abonnement WHERE nomducompteA=? AND nomducompteC=?";
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
			String sql = "DELETE FROM abonnement WHERE nomducompteA=? AND nomducompteC=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c);
			ps.setString(2, cB);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Abonnement> findByNomDesComptes(String nomCompteA, String nomCompteB) {
		ArrayList<Abonnement> res = new ArrayList<Abonnement>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM abonnement WHERE nomducompteA = ? AND nomducompteC = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nomCompteA);
			ps.setString(2, nomCompteB);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {

				res.add(new Abonnement(nomCompteA, nomCompteB));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Abonnement> findByNomDuCompteA(String nomCompte) {
		ArrayList<Abonnement> res = new ArrayList<Abonnement>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM abonnement WHERE nomducompteA = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nomCompte);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nA = rs.getString("nomducompteA");
				String nB = rs.getString("nomducompteC");

				res.add(new Abonnement(nA, nB));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Abonnement> findByNomDuCompteB(String nomCompte) {
		ArrayList<Abonnement> res = new ArrayList<Abonnement>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM abonnement WHERE nomducompteC = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, nomCompte);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nA = rs.getString("nomducompteA");
				String nB = rs.getString("nomducompteC");

				res.add(new Abonnement(nA, nB));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
