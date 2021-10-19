package app;

import java.io.File;

public class Parser {
	private File arquivo;
	private String delimitador;
	
	public void leArquivo(String nomeArquivo) throws ArquivoNaoEncontradoException {
		File arquivo = new File(nomeArquivo);
		
		if (!arquivo.exists()) {
			throw new ArquivoNaoEncontradoException(nomeArquivo + " não encontrado.");
		} else {
			this.arquivo = arquivo;
		}
	}
	
	public void definirDelimitador(String delimitador) throws Exception {
		if(delimitador.length() > 1) {
			throw new Exception();
		} else {
			this.delimitador = delimitador;
		}
	}
}
