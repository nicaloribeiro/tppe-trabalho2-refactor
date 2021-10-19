package app;

import java.io.File;

public class Parser {
	private String nomeArquivo;
	private File arquivo;
	private File arquivoSaida;
	private String delimitador;
	
	public void leArquivo(String nomeArquivo) throws ArquivoNaoEncontradoException {
		this.nomeArquivo = nomeArquivo;
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

	public void criaArquivoSaida() throws Exception {
		String nomeArquivoSaida = this.nomeArquivo.replace(".", "Tab.");
		File arquivo = new File(nomeArquivoSaida);
		arquivo.createNewFile();
		
		if (!arquivo.canWrite()) {
			throw new Exception();
		} else {
			this.arquivoSaida = arquivo;
		}
	}
}
