package com.stefanini.project.handler;

public class ErrorDetail {
	
	private String mensagem;
    private String campo;
    private Object parametroInserido;
    
	public ErrorDetail(String mensagem, String campo, Object parametroInserido) {
		this.mensagem = mensagem;
		this.campo = campo;
		this.parametroInserido = parametroInserido;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public Object getParametroInserido() {
		return parametroInserido;
	}
	public void setParametroInserido(Object parametroInserido) {
		this.parametroInserido = parametroInserido;
	}
    
    
    
}
