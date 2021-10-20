package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		File arquivo = new File(nomeArquivo);

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
		File arquivo = new File(nomeArquivoSaida);
		arquivo.createNewFile();

		if (!arquivo.canWrite()) {
			throw new EscritaNaoPermitidaException("Escrita não permitida.");
		} else {
			this.arquivoSaida = arquivo;
		}
	}

	public void converteColuna() throws IOException {
		String linha;
		matriz = new Vector<Vector<String>>();
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
		matriz.add(new Vector<String>());
		int i = 0;

		while ((linha = br.readLine()) != null) {
			if (linha.charAt(0) == '-') {
				i = 0;
				matriz.elementAt(i).add(linha.replaceAll("[^0-9]", ""));
			} else {
				if (matriz.size() < i + 1)
					matriz.add(new Vector<String>());
				matriz.elementAt(i).add(linha);
			}
			i++;
		}

		br.close();
	}

	public void converteLinha() throws IOException {
		String linha;
		matriz = new Vector<Vector<String>>();
		BufferedReader br = new BufferedReader(new FileReader(arquivo));
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
		BufferedReader br = new BufferedReader(new FileReader(this.arquivo));

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
		if(this.delimitador.equals(";")) {
			for (Vector<String> arr : this.matriz) {
				String result = "";
				for(String str : arr) {
					result += str;
					result += ";";
				}
				this.textoFormatado.add(result.replaceFirst(".$",""));				
			}
		}
		if(this.delimitador.equals(",")) {
			for (Vector<String> arr : this.matriz) {
				String result = "";
				for(String str : arr) {
					result += str;
					result += ",";
				}
				this.textoFormatado.add(result.replaceFirst(".$",""));				
			}
		}
	}
	
	public Vector<String> getTextoFormatado(){
			return this.textoFormatado;
	}
}
