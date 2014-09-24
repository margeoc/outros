package br.com.wic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControleTempo {

	EnderecoDAO ed = new EnderecoDAO();
	static PreparedStatement pstmt = null;
	static Connection con = null;
	public static Boolean ativa = true;
	
	
	public static void main(String[] args) {
		insereData("asesfseedf");
	}
	
	public static void insereData(String url){
		String sql = "insert into historico(url, data, hora) values(?,?, ?)";
		con = new ConnectionFactory().getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, url);
			pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			pstmt.setTime(3, new java.sql.Time(System.currentTimeMillis()));
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}

