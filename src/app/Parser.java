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
	
	public void definirDelimitador(String delimitador) throws DelimitadorInvalidoException {
		if(delimitador.length() > 1) {
			throw new DelimitadorInvalidoException("O delimitador � inv�lido.");
		} else {
			this.delimitador = delimitador;
		}
	}

	public void criaArquivoSaida() {
		return;
	}
}
