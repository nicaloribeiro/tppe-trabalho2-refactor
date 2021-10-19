package app;

import java.io.File;

public class Parser {
	private File arquivo;

	public void leArquivo(String nomeArquivo) throws ArquivoNaoEncontradoException {
		File arquivo = new File(nomeArquivo);
		
		if (!arquivo.exists()) {
			throw new ArquivoNaoEncontradoException(nomeArquivo + " não encontrado.");
		} else {
			this.arquivo = arquivo;
		}
	}
	
	public void definirDelimitador(String delimitador) {
		return;
	}
}
