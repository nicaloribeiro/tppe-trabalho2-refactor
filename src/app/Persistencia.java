package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Persistencia {
	
	private String nomeArquivo;
	private File arquivo;
	private File arquivoSaida;
		
	public void leituraArquivo(String nomeArquivo) throws ArquivoNaoEncontradoException {
		setNomeArquivo(nomeArquivo);
		File arquivo = aberturaArquivo(nomeArquivo);

		if (!arquivo.exists()) {
			throw new ArquivoNaoEncontradoException(nomeArquivo + " nao encontrado.");
		} else {
			setArquivo(arquivo);
		}
	}
	
	public BufferedWriter escritaLinha(File arquivo) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo));
		return bw;
	}
	
	public BufferedReader leituraLinha(File arquivo) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		return br;
	}
	
	public File aberturaArquivo(String nomeArquivo) {
		File arquivo = new File(nomeArquivo);
		return arquivo;
	}
	
	public void escreveTextoSaida(Vector<String> textoFormatado ) throws IOException, EscritaNaoPermitidaException {
		BufferedWriter bw = escritaLinha(getArquivoSaida());
		for (String linha : textoFormatado) {
			bw.write(linha);
			bw.write("\n");
		}
		bw.close();
	}
	
	public void criaArquivoSaida() throws EscritaNaoPermitidaException, IOException {
		String nomeArquivoSaida = getNomeArquivo().replace(".", "Tab.");
		File arquivo = aberturaArquivo(nomeArquivoSaida);
		arquivo.createNewFile();

		if (!arquivo.canWrite()) {
			throw new EscritaNaoPermitidaException("Escrita nao permitida.");
		} else {
			setArquivoSaida(arquivo);
		}
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public File getArquivo() {
		return arquivo;
	}

	public void setArquivo(File arquivo) {
		this.arquivo = arquivo;
	}

	public File getArquivoSaida() {
		return arquivoSaida;
	}

	public void setArquivoSaida(File arquivoSaida) {
		this.arquivoSaida = arquivoSaida;
	}
}
