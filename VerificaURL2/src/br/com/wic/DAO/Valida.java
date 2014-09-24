package br.com.wic.DAO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class Valida {
//	public static int idHist;

	private static final String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) {
		ArrayList<Endereco> lista = (ArrayList<Endereco>) statusServicos();
		for (Endereco endereco : lista) {
			System.out.println(endereco.getUrl());
		}
	}

	/**************************************************************************/
	/* MÉTODO QUE GERA UMA LISTA DE ENDEREÇOS SETANDO A URL E O STATUS. USA    /
	/* O MÉTODO retornoUrl() PARA OBTER TODO O CÓDIGO DE UMA PÁGINA, PASSANDO  /
	/* UMA URL COMO PARÂMETRO, OBTIDA ATRAVÉS DE UMA LISTA VINDA DE UM BD      /
	/**************************************************************************/	
	public static List statusServicos() {
		ArrayList<Endereco> e = new ArrayList<Endereco>();
		ArrayList<Endereco> e2 = new ArrayList<Endereco>();

		// OBTÊM UMA LISTA DE ENDEREÇOS DE UM BD
		e = enderecos();
		for (Endereco end : e) {
			String _url = end.getUrl();
			String _arg = end.getParametro();
			String _argEnt = end.getArgumentoBusca();
			String _metodo = end.getMethod();
			// acrescentar mais um parametro METODO
			// acrescentar argumento parametrosx1	
			String compara = null;					
			Endereco endereco = new Endereco();		
			try {
				// OBTEM O CÓDIGO DA PÁGINA

				//compara = retornoUrl(_url);

				compara = pesquisa(_url, _arg, _metodo);
				System.out.println("\nurl: "+_url+" codigo do site: "+compara);
				endereco.setUrl(_url);

				if (compara.contains(_arg)) {
					endereco.setStatus("ONLINE");
					e2.add(endereco);

				} else {
					endereco.setStatus("OFFLINE");
					e2.add(endereco);
					// System.out.println("insere no historico");
					// insereHist(_url);
					// insereHist(_url);
					//teste();
				}
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}

		}

		return e2;
	}

	private static void insereHist(String _url) {
		HistoricoDAO hd = new HistoricoDAO();
		// if(testeId()){
		// System.out.println("id atual: "+idHist);
		// hd.insere(_url);
		// }
		// return;
	}

	private static boolean teste() {
		ArrayList<Historico> hist = historico();
		int id;
		// System.out.println("valor do id hist inicial: "+idHist);
		for (Historico h : hist) {
			id = h.getId();
			if (testeId(id)) {
				System.out.println("nenhuma ocorrencia");
			}

		}
	//	idHist = getLast();
		System.out.println("retornando true");
		return true;
	}

	public static boolean testeId(int _id) {
		int id = getLast();
		for (int i = 0; i <= id; i++) {
			if (_id == i)
				// System.out.println("id foi igual a algum na lista, retorna falso");
				return false;
		}
		// System.out.println("id nao foi localizado na busca, pode ser inserido");
		return true;
	}

	/******************************************************************/
	/* MÉTODO QUE GERA PEGA O ÚLTIMO VALOR DE REGISTRO NO HISTORICO    /
	/******************************************************************/
	public static int getLast() {
		int id = 0;
		ArrayList<Historico> hist = historico();
		for (Historico h : hist) {
			id = h.getId();

		}
		return id;
	}

	
	/******************************************************************/
	/* MÉTODO QUE GERA UMA LISTA DE HISTÓRICOS A PARTIR DO BD          /
	/******************************************************************/
	public static ArrayList<Historico> historico() {
		HistoricoDAO hd = new HistoricoDAO();
		ArrayList<Historico> histList = hd.getHistList();
		return histList;
	}

	
	/******************************************************************/
	/* MÉTODO QUE GERA UMA LISTA DE ENDEREÇOS A PARTIR DO BD           /
	/******************************************************************/
	public static ArrayList<Endereco> enderecos() {
		EnderecoDAO ed = new EnderecoDAO();
		ArrayList<Endereco> lista = ed.lista();
		return lista;
	}

	/************************************************************************/	
	/* MÉTODO QUE RECEBE UM ENDEREÇO URL COMO PARÂMETRO E RETORNA O CÓDIGO   /
	/* FONTE EM UMA STRING                                                   /
	/************************************************************************/	
	static String retornoUrl(String _url) throws IOException { URL url =
	null; URLConnection uc;
	
	StringBuilder parsedContentFromUrl = new StringBuilder(); 
		String urlString = _url; 
		try { 
			url = new URL(urlString); 
		} 
		catch (MalformedURLException e) { 
			System.out.println(e.getMessage()); 
		} 
		uc = url.openConnection(); 
		uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)"); 
		uc.connect();
		uc.getInputStream(); 
		BufferedInputStream in = new BufferedInputStream(uc.getInputStream()); 
		int ch; 
		while ((ch = in.read())	!= -1) { 
			parsedContentFromUrl.append((char) ch); 
		}
		 
		return parsedContentFromUrl.toString();
	
	}
	 

	public static String pesquisa(String _url, String parameters, String method) {
		String retorno = "Erro:problemas na conexao com:" + _url;
		if (method.toUpperCase().equals("GET")) {
			retorno = sendGet(_url, parameters);
		}
		if (method.toUpperCase().equals("POST")) {
			retorno = sendPost(_url, parameters);
		}
		return retorno;
	}

	// HTTP GET request
	private static String sendGet(String url, String parameters) {
		
		StringBuffer response = new StringBuffer();
		try {
			// String url = "http://www.google.com/search?q=mkyong";

			URL obj = new URL(url + parameters);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// add request header
			con.setRequestProperty("User-Agent", USER_AGENT);

			con.addRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			response.append("ERRO:problema na conexao:" + e.getMessage());
		}
		// print result
		return response.toString();

	}

	// HTTP POST request
	private static String sendPost(String url, String parameters) {
		
		StringBuffer response = new StringBuffer();
		try {
			String urlParameters = parameters;

			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "pt-BR,br;q=0.5");
			
			
			con.addRequestProperty("User-Agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			// System.out.println("\nSending 'POST' request to URL : " + url);
			// System.out.println("Post parameters : " + urlParameters);
			// System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result

		} catch (Exception e) {
			response.append("ERRO:" + e.getMessage());
		}
		return response.toString();
	}

}
