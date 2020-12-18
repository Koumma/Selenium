package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Media {

	private String url;
	private String contenutextuel;
	private String type;

	public Media(String url, String contenuTextuel, String type) {
		this.url = url;
		this.contenutextuel = contenuTextuel;
		this.type = type;
	}
	
	public void save() {
		if (findByContenuTextuelEtURL(this.contenutextuel, this.url).isEmpty()) {
			this.saveNew();
		} else {
			this.update();
		}
	}

	private void saveNew() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "INSERT INTO Media (url, contenutextuel, type) VALUES (?,?,?)";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.url);
			ps.setString(2, this.contenutextuel);
			ps.setString(3, this.type);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void update() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "UPDATE Media SET contenutextuel = ?, type=?  WHERE url = ?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.contenutextuel);
			ps.setString(2, this.type);
			ps.setString(3, this.url);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Media WHERE url=? AND contenutextuel=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, this.url);
			ps.setString(2, this.contenutextuel);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(String u, String ct) {
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "DELETE FROM Media WHERE url=? AND contenutextuel=?";
			PreparedStatement ps = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, u);
			ps.setString(2, ct);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Media> findByContenuTextuelEtURL(String ct, String url) {
		ArrayList<Media> res = new ArrayList<Media>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Media WHERE contenutextuel = ? AND url = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, ct);
			ps.setString(2, url);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String u = rs.getString("url");
				String c = rs.getString("contenutextuel");
				String t = rs.getString("type");
				res.add(new Media(u, c, t));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Media> findByUrl(String lien) {
		ArrayList<Media> res = new ArrayList<Media>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Media WHERE url = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, lien);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String u = rs.getString("url");
				String c = rs.getString("contenutextuel");
				String t = rs.getString("type");
				res.add(new Media(u, c, t));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Media> findByContenuTextuel(String ct) {
		ArrayList<Media> res = new ArrayList<Media>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Media WHERE contenutextuel = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, ct);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String u = rs.getString("url");
				String c = rs.getString("contenutextuel");
				String t = rs.getString("type");
				res.add(new Media(u, c, t));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public static ArrayList<Media> findByType(String ty) {
		ArrayList<Media> res = new ArrayList<Media>();
		try {
			Connection connect = DBConnexion.getConnexion();
			String sql = "SELECT * FROM Media WHERE type = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setString(1, ty);
			ps.execute();
			ResultSet rs = ps.getResultSet();
			while (rs.next()) {
				String u = rs.getString("url");
				String c = rs.getString("contenutextuel");
				String t = rs.getString("type");
				res.add(new Media(u, c, t));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
