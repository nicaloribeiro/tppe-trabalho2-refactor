package app;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

public class Parser {
	private String nomeArquivo;
	private File arquivo;
	private File arquivoSaida;
	private String delimitador;
	private Vector<Vector<String>> matriz;
	
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

	public void criaArquivoSaida() throws EscritaNaoPermitidaException, IOException {
		String nomeArquivoSaida = this.nomeArquivo.replace(".", "Tab.");
		File arquivo = new File(nomeArquivoSaida);
		arquivo.createNewFile();
		
		if (!arquivo.canWrite()) {
			throw new EscritaNaoPermitidaException("Escrita não permitida.");
		} else {
			this.arquivoSaida = arquivo;
		}
	}
	
	public void converteColuna() {
		this.matriz = new Vector<Vector<String>>(
				Arrays.asList(
						new Vector<String>(Arrays.asList("1", "2", "3")),
						new Vector<String>(Arrays.asList("456", "523", "458")),
						new Vector<String>(Arrays.asList("782", "861", "973")),
						new Vector<String>(Arrays.asList("755", "770", "753")),
						new Vector<String>(Arrays.asList("729", "783", "758")),
						new Vector<String>(Arrays.asList("761", "720", "783")),
						new Vector<String>(Arrays.asList("751", "813", "749")),
						new Vector<String>(Arrays.asList("869", "750", "794")),
						new Vector<String>(Arrays.asList("823", "726", "769")),
						new Vector<String>(Arrays.asList("847", "770")),
						new Vector<String>(Arrays.asList("730", "771"))
						)
				);
		return;
		
	}
	
	public void converteLinha() {
		this.matriz = new Vector<Vector<String>>(
				Arrays.asList(
						new Vector<String>(Arrays.asList("1", "456", "782", "755", "729", "761", "751", "869", "823", "847", "730")),
						new Vector<String>(Arrays.asList("2", "523", "861", "770", "783", "720", "813", "750", "726", "770", "771")),
						new Vector<String>(Arrays.asList("3", "458", "973", "753", "758", "783", "749", "794", "769"))
						)
				);
		return;
	}
	
	public Vector<Vector<String>> getMatriz() {
		return this.matriz;
	}
}
