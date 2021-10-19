package app;

import java.io.File;

public class Parser {
	private File arquivo;

	public void leArquivo(String nomeArquivo) throws Exception {
		File arquivo = new File(nomeArquivo);
		
		if (!arquivo.exists()) {
			throw new Exception();
		} else {
			this.arquivo = arquivo;
		}
	}
}
