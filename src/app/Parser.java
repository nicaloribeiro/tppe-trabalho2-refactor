package app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.sound.sampled.Line;

public class Parser {
	private String nomeArquivo;
	private File arquivo;
	private File arquivoSaida;
	private String delimitador;
	private Vector<Vector<String>> matriz;
	private Vector<String> textoFormatado;

	public void leArquivo(String nomeArquivo) throws ArquivoNaoEncontradoException {
		this.nomeArquivo = nomeArquivo;
		File arquivo = aberturaArquivo(nomeArquivo);

		if (!arquivo.exists()) {
			throw new ArquivoNaoEncontradoException(nomeArquivo + " não encontrado.");
		} else {
			this.arquivo = arquivo;
		}
	}


	public void definirDelimitador(String delimitador) throws DelimitadorInvalidoException {
		if (delimitador.length() > 1) {
			throw new DelimitadorInvalidoException("O delimitador � inv�lido.");
		} else {
			this.delimitador = delimitador;
		}
	}

	public void criaArquivoSaida() throws EscritaNaoPermitidaException, IOException {
		String nomeArquivoSaida = this.nomeArquivo.replace(".", "Tab.");
		File arquivo = aberturaArquivo(nomeArquivoSaida);
		arquivo.createNewFile();

		if (!arquivo.canWrite()) {
			throw new EscritaNaoPermitidaException("Escrita não permitida.");
		} else {
			this.arquivoSaida = arquivo;
		}
	}

	public void converteColuna() throws IOException {
		converteLinha();
		Vector<Vector<String>> novaMatriz = new Vector<Vector<String>>();
		int i, msc = 0;
		
		for (Vector<String> arr : matriz) {
			msc = Math.max(msc, arr.size());
		}
		
		for (Vector<String> arr : matriz) {
			i = 0;		

			for (String str : arr) {
				if (novaMatriz.size() < i + 1)
					novaMatriz.add(new Vector<String>());
				novaMatriz.elementAt(i).add(str);
				i++;
			}
			
			for (; i < msc; i++) {
				if (novaMatriz.size() < i + 1)
					novaMatriz.add(new Vector<String>());
				novaMatriz.elementAt(i).add("");
			}
		}
		
		this.matriz = novaMatriz;
	}

	public void converteLinha() throws IOException {
		String linha;
		matriz = new Vector<Vector<String>>();
		BufferedReader br = leituraLinha();
		Vector<String> evolucao = new Vector<String>();

		while ((linha = br.readLine()) != null) {
			if (linha.charAt(0) == '-') {
				if (!evolucao.isEmpty()) {
					matriz.add(evolucao);
				}
				evolucao = new Vector<String>();
				evolucao.add(linha.replaceAll("[^0-9]", ""));
			} else {
				evolucao.add(linha);
			}
		}

		if (!evolucao.isEmpty()) {
			matriz.add(evolucao);
		}

		br.close();
	}

	public Vector<Vector<String>> getMatriz() {
		return this.matriz;
	}

	public Vector<Integer> analiseEvolucoes() throws IOException {
		Vector<Integer> result = new Vector<Integer>();
		int qtdEvolucoes = -1;
		String linha = "";
		BufferedReader br = leituraLinha();

		do {
			linha = br.readLine();
			if (linha == null) {
				if (qtdEvolucoes >= 0) {
					result.add(qtdEvolucoes);
				}
			}
			if (linha != null) {

				if (linha.toLowerCase().contains("evolution")) {
					if (qtdEvolucoes >= 0) {
						result.add(qtdEvolucoes);
					}
					qtdEvolucoes = 0;
				} else {
					qtdEvolucoes++;
				}
			}

		} while (linha != null);
		br.close();

		return result;

	}

	public void formataTextoComDelimitador() {
		this.textoFormatado = new Vector<String>();
		for (Vector<String> arr : this.matriz) {
			String result = "";
			for (String str : arr) {
				result += str;
				result += this.delimitador;
			}
			this.textoFormatado.add(result.substring(0, result.length() - 1));
		}
	}

	public Vector<String> getTextoFormatado() {
		return this.textoFormatado;
	}

	public void escreveTextoSaida() throws IOException, EscritaNaoPermitidaException {
		BufferedWriter bw = escritaLinha();
		for (String linha : this.textoFormatado) {
			bw.write(linha);
			bw.write("\n");
		}
		bw.close();
	}

	private BufferedWriter escritaLinha() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(this.arquivoSaida));
		return bw;
	}
	
	private BufferedReader leituraLinha() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(this.arquivo));
		return br;
	}
	
	private File aberturaArquivo(String nomeArquivo) {
		File arquivo = new File(nomeArquivo);
		return arquivo;
	}
	
}
