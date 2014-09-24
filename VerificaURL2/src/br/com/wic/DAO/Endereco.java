package br.com.wic.DAO;

public class Endereco {
	private String url;
	private String argumentoBusca;
	private String status;
	private String parametro;
	private String method;
	

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getArgumentoBusca() {
		return argumentoBusca;
	}

	public void setArgumentoBusca(String argumentoBusca) {
		this.argumentoBusca = argumentoBusca;
	}

	
}
