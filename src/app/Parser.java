package app;

import java.io.File;

public class Parser {

	public void leArquivo(String nomeArquivo) throws Exception {
		File arquivo = new File(nomeArquivo);
		
		if (!arquivo.exists()) {
			throw new Exception();
		}
	}
}
