import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;



public class Teste2 {
	public static void main(String[] args) throws Exception {
		// Pagina de login no site wicash
		String siteA = "http://wicash.com.br/wicash/login.jsp" +
				"";
		//String siteA = "http://200.221.2.45";
		//String siteA = "http://177.12.169.252";
		
		
        System.out.println(siteA+":"+retornoUrl(siteA).contains("Autentique")); 
        
	}	
	public static String mapaDeServicos(){
		String siteA = "http://wicash.com.br/wicash/login.jsp" +
				"";
		//String siteA = "http://200.221.2.45";	
		//String siteA = "http://177.12.169.252";
		
		
        try {
			return siteA+":"+retornoUrl(siteA).contains("Autentique");
		} catch (IOException e) {
			return siteA+":"+e.getMessage();
		}
	}
	public static String retornoUrl(String _url) throws IOException{
		URL site = null;
		try {
			site = new URL(_url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputStreamReader isr = new InputStreamReader(site.openStream());
		BufferedReader in = new BufferedReader(isr);   
		String inputLine;
		StringBuilder resultado=new StringBuilder();
	    while ((inputLine = in.readLine()) != null){
	    
	    	resultado.append(inputLine);
	    } 
	    in.close();	
	    return resultado.toString();
	   
	}
}