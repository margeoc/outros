import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;



public class Teste {
	static String site = "http://localhost";
	
	public static void main(String[] args)  throws IOException {
		URL url = null;
		try {
			url = new URL(site);
			if(url.openConnection() != null){
				System.out.println("Conectado");
			}
			else{
				System.out.println("indisponivel");
			}
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
}
