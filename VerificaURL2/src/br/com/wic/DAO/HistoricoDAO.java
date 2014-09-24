package br.com.wic.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HistoricoDAO {
	public static int total;
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public HistoricoDAO(){
		this.conn = new ConnectionFactory().getConnection();
	}
	
	
	
	/*********************************************************************/
	/*		MÉTODO QUE GERA UMA LISTA DE HISTÓRICOS A PARTIR DO BD        /
	/ ********************************************************************/ 
	public ArrayList<Historico> getHistList(){
		ArrayList<Historico> hist = new ArrayList<Historico>();
		String sql = "select * from historico";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){				
				hist.add(criaHistorico(rs.getInt(1), rs.getString(2)));				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		finally {			
			try {pstmt.close();} catch (Exception e) {}			
			try {conn.close();} catch (Exception e) {}
			try {rs.close();} catch (Exception e) {}
		}
		
		return hist; 
		
	}
	
	
	/************************************************************************/
	/*	MÉTODO QUE INSERE UM NOVO REGISTRO NO HISTORICO DO BANCO             /
	/ ***********************************************************************/ 
	public void insere(String _url){
		String sql = "insert into historico(url) values(?)";
		try {
			int colIndex = 1;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, _url);
			//pstmt.setString(++colIndex, arg);
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		finally {			
			try {pstmt.close();} catch (Exception e) {}			
			try {conn.close();} catch (Exception e) {}
			try {rs.close();} catch (Exception e) {}
		}
	}
	
	
	
	
	
	/*********************************************************/
	/*	MÉTODO QUE CRIA UM HISTORICO                          /
	/ ********************************************************/ 	
	private static Historico criaHistorico(int id, String url){
		Historico h = new Historico();
		h.setId(id);
		h.setUrl(url);				
		return h;
	}
	
}
