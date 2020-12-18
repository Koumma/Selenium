package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;

public class Profil {

	private String nomducompte;
	private String pseudo;
	private String biographie;
	private String localisation;
	private Date datenaiss;
	private Date dateinscription;
	private int nbAbonnements;
	private int nbAbonnes;

	public Profil(String n, String p, String b, String l, Date dateNaiss2, Date dateInscription2, int nAm, int nA) {
		nomducompte = n;
		pseudo = p;
		biographie = b;
		localisation = l;
		datenaiss = dateNaiss2;
		dateinscription = dateInscription2;
		nbAbonnements = nAm;
		nbAbonnes = nA;
	}
	
	
	public void save() {
		if (findByNomDuCompte(this.nomducompte).isEmpty()) {
			this.saveNew();
		} else {
			this.update();
		}
	}

	private void saveNew() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "INSERT INTO Profil (nomducompte, pseudo, biographie, localisation, datenaiss, dateinscription, nbAbonnements, nbAbonnes) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nomducompte);
			ps.setString(2, this.pseudo);
			ps.setString(3, this.biographie);
			ps.setString(4, this.localisation);
			ps.setDate(5, this.datenaiss);
			ps.setDate(6, this.dateinscription);
			ps.setInt(7, this.nbAbonnements);
			ps.setInt(8, this.nbAbonnes);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "UPDATE Profil SET pseudo = ?, biographie = ?, localisation = ?, datenaiss=?, dateinscription=?, nbAbonnements=?, nbAbonnes=? WHERE nomducompte = ?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.pseudo);
			ps.setString(2, this.biographie);
			ps.setString(3, this.localisation);
			ps.setDate(4, this.datenaiss);
			ps.setDate(5, this.dateinscription);
			ps.setInt(6, this.nbAbonnements);
			ps.setInt(7, this.nbAbonnes);
			ps.setString(8, this.nomducompte);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Profil WHERE nomducompte=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.nomducompte);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String c) {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Profil WHERE nomducompte=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Profil> findAll() {
		ArrayList<Profil> res = new ArrayList<Profil>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Profil";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nc = rs.getString("nomducompte");
				String p = rs.getString("pseudo");
				String b = rs.getString("biographie");
				String l = rs.getString("localisation");
				Date dn = rs.getDate("datenaiss");
				Date di = rs.getDate("dateinscription");
				int nAm = rs.getInt("nbAbonnements");
				int nA = rs.getInt("nbAbonnes");

				res.add(new Profil(nc, p, b, l, dn, di, nAm, nA));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static ArrayList<Profil> findByNomDuCompte(String nomCompte) {
		ArrayList<Profil> res = new ArrayList<Profil>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Profil WHERE nomducompte LIKE ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			String nomc='%'+nomCompte+'%';
			ps.setString(1, nomc);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nc = rs.getString("nomducompte");
				String p = rs.getString("pseudo");
				String b = rs.getString("biographie");
				String l = rs.getString("localisation");
				Date dn = rs.getDate("datenaiss");
				Date di = rs.getDate("dateinscription");
				int nAm = rs.getInt("nbAbonnements");
				int nA = rs.getInt("nbAbonnes");

				res.add(new Profil(nc, p, b, l, dn, di, nAm, nA));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Profil> findByPseudo(String pseudo) {
		ArrayList<Profil> res = new ArrayList<Profil>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Profil WHERE pseudo = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, pseudo);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nc = rs.getString("nomducompte");
				String p = rs.getString("pseudo");
				String b = rs.getString("biographie");
				String l = rs.getString("localisation");
				Date dn = rs.getDate("datenaiss");
				Date di = rs.getDate("dateinscription");
				int nAm = rs.getInt("nbAbonnements");
				int nA = rs.getInt("nbAbonnes");

				res.add(new Profil(nc, p, b, l, dn, di, nAm, nA));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Profil> findByBiographie(String bio) {
		ArrayList<Profil> res = new ArrayList<Profil>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Profil WHERE biographie = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, bio);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nc = rs.getString("nomducompte");
				String p = rs.getString("pseudo");
				String b = rs.getString("biographie");
				String l = rs.getString("localisation");
				Date dn = rs.getDate("datenaiss");
				Date di = rs.getDate("dateinscription");
				int nAm = rs.getInt("nbAbonnements");
				int nA = rs.getInt("nbAbonnes");

				res.add(new Profil(nc, p, b, l, dn, di, nAm, nA));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Profil> findByLocalisation(String loca) {
		ArrayList<Profil> res = new ArrayList<Profil>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Profil WHERE localisation = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, loca);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nc = rs.getString("nomducompte");
				String p = rs.getString("pseudo");
				String b = rs.getString("biographie");
				String l = rs.getString("localisation");
				Date dn = rs.getDate("datenaiss");
				Date di = rs.getDate("dateinscription");
				int nAm = rs.getInt("nbAbonnements");
				int nA = rs.getInt("nbAbonnes");

				res.add(new Profil(nc, p, b, l, dn, di, nAm, nA));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Profil> findByStringNaiss(String dNaiss) {
		ArrayList<Profil> res = new ArrayList<Profil>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Profil WHERE datenaiss = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, dNaiss);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nc = rs.getString("nomducompte");
				String p = rs.getString("pseudo");
				String b = rs.getString("biographie");
				String l = rs.getString("localisation");
				Date dn = rs.getDate("datenaiss");
				Date di = rs.getDate("dateinscription");
				int nAm = rs.getInt("nbAbonnements");
				int nA = rs.getInt("nbAbonnes");

				res.add(new Profil(nc, p, b, l, dn, di, nAm, nA));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Profil> findByStringInsc(String dInsc) {
		ArrayList<Profil> res = new ArrayList<Profil>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Profil WHERE dateinscription = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, dInsc);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String nc = rs.getString("nomducompte");
				String p = rs.getString("pseudo");
				String b = rs.getString("biographie");
				String l = rs.getString("localisation");
				Date dn = rs.getDate("datenaiss");
				Date di = rs.getDate("dateinscription");
				int nAm = rs.getInt("nbAbonnements");
				int nA = rs.getInt("nbAbonnes");

				res.add(new Profil(nc, p, b, l, dn, di, nAm, nA));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public String toString() {
		return(this.nomducompte + ',' + this.pseudo + ',' + this.biographie+ ',' + this.localisation+ ',' + this.datenaiss+ ',' + this.dateinscription+ ',' + this.nbAbonnements + ',' + this.nbAbonnes);
	}
}
