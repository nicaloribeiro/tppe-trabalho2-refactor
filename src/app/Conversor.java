package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Conversor {

	public Vector<Vector<String>> converteColuna(Persistencia persistencia) throws IOException {
		Vector<Vector<String>> matriz = this.converteLinha(persistencia);
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
		
		return novaMatriz;
	}

	public Vector<Vector<String>> converteLinha(Persistencia persistencia) throws IOException {
		String linha;
		Vector<Vector<String>> matriz = new Vector<Vector<String>>();
		File arq = persistencia.getArquivo();
		BufferedReader br = persistencia.leituraLinha(arq);
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
		
		return matriz;
	}

}
