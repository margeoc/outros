package br.com.wic.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.ConnectionFactory;

public class EnderecoDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	
	/************************************************************************/
	/*	CRIA UMA NOVA CONEXÃO AO SER INSTANCIADO                             /
	/ ***********************************************************************/ 
	public  EnderecoDAO(){		
		conn = new ConnectionFactory().getConnection();
	}
	
	
	
	
	/************************************************************************/
	/*	MÉTODO QUE INSERE UM NOVO SERVIÇO NO BANCO PARA SER MONITORADO       /
	/ ***********************************************************************/ 
	public void insere(String url, String parametro, String argBusca, String method){
		String sql = "insert into servicos(url, param, argumentoBusca, method) values(?,?,?,?)";
		try {
			int colIndex = 0;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(++colIndex, url);
			pstmt.setString(++colIndex, parametro);
			pstmt.setString(++colIndex, argBusca);
			pstmt.setString(++colIndex, method);
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
	
	
	/*********************************************************************/
	/*		MÉTODO QUE GERA UMA LISTA DE ENDEREÇOS A PARTIR DO BD         /
	/ ********************************************************************/ 
	public ArrayList<Endereco> lista(){
		ArrayList<Endereco> ende = new ArrayList<Endereco>();
		String sql = "select url, param, method from servicos";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){				
				ende.add(criaEndereco(
					rs.getString(1), 
					rs.getString(2), 
					rs.getString(3), 
					rs.getString(3)));				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		finally {			
			try {pstmt.close();} catch (Exception e) {}			
			try {conn.close();} catch (Exception e) {}
			try {rs.close();} catch (Exception e) {}
		}
		return ende;
	}
	
	
	/*********************************************************************/
	/*	MÉTODO QUE CRIA UM ENDEREÇO, SERÁ USADO NO MÉTODO lista()         /
	/ ********************************************************************/ 	
	private static Endereco criaEndereco(String url, String parametro, String argumentoBusca, String method){
		Endereco e = new Endereco();
		e.setParametro(parametro);
		e.setUrl(url);
		e.setArgumentoBusca(argumentoBusca);
		e.setMethod(method);		
		return e;
	}
	

}
