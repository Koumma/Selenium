package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Tweet {

	public String contenutextuel;
	public String nomducompte;
	public int nbRep;
	public int nbRT;
	public int nbLike;

	public Tweet(String c, String n, int rep, int rt, int like) {
		contenutextuel = c;
		nomducompte = n;
		nbRep = rep;
		nbRT = rt;
		nbLike = like;
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
			String sql = "INSERT INTO Tweet (contenutextuel, nomducompte, nbRep, nbRT, nbLike) VALUES (?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.contenutextuel);
			ps.setString(2, this.nomducompte);
			ps.setInt(3, this.nbRep);
			ps.setInt(4, this.nbRT);
			ps.setInt(5, this.nbLike);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "UPDATE Tweet SET nbRep = ?, nbRT = ?, nbLike = ? WHERE contenutextuel = ?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, this.nbRep);
			ps.setInt(2, this.nbRT);
			ps.setInt(3, this.nbLike);
			ps.setString(4, this.contenutextuel);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Tweet WHERE contenutextuel=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.contenutextuel);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String c) {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Tweet WHERE contenutextuel=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, c);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Tweet> findByNomDuCompte(String nomCompte) {
		ArrayList<Tweet> res = new ArrayList<Tweet>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Tweet WHERE nomducompte LIKE ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			String nomc='%'+nomCompte+'%';
			ps.setString(1, nomc);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String ct = rs.getString("contenutextuel");
				String nc = rs.getString("nomducompte");
				int rep = rs.getInt("nbRep");
				int rt = rs.getInt("nbRT");
				int like = rs.getInt("nbLike");
				res.add(new Tweet(ct, nc, rep, rt, like));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public String toString() {
		return "Tweet [contenutextuel=" + contenutextuel + ", nomducompte=" + nomducompte + ", nbRep=" + nbRep
				+ ", nbRT=" + nbRT + ", nbLike=" + nbLike + "]";
	}

	public static ArrayList<Tweet> findByContenuTextuel(String text) {
		ArrayList<Tweet> res = new ArrayList<Tweet>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Tweet WHERE contenutextuel = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, text);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String ct = rs.getString("contenutextuel");
				String nc = rs.getString("nomducompte");
				int rep = rs.getInt("nbRep");
				int rt = rs.getInt("nbRT");
				int like = rs.getInt("nbLike");
				res.add(new Tweet(ct, nc, rep, rt, like));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public String getNomducompte() {
		return nomducompte;
	}
	
	/*public String get(String at) {
		String res;
		
		return res;
	}*/
	
}
