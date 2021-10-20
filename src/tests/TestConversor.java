package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import app.ArquivoNaoEncontradoException;
import app.DelimitadorInvalidoException;
import app.Parser;

public class TestConversor {
	private Parser parser;
	Vector<Vector<String>> linha;
	Vector<Vector<String>> coluna;
	
	@Before
	public void setup() throws DelimitadorInvalidoException, ArquivoNaoEncontradoException {
		parser = new Parser();
		parser.leArquivo("analysisTest.out");
		parser.definirDelimitador(";");
		linha = new Vector<Vector<String>>(
				Arrays.asList(
						new Vector<String>(Arrays.asList("1", "456", "782", "755", "729", "761", "751", "869", "823", "847", "730")),
						new Vector<String>(Arrays.asList("2", "523", "861", "770", "783", "720", "813", "750", "726", "770", "771")),
						new Vector<String>(Arrays.asList("3", "458", "973", "753", "758", "783", "749", "794", "769"))
						)
				);
		
		coluna = new Vector<Vector<String>>(
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
				
	}
	
	@Test
	public void testConverteLinha() {
		parser.converteLinha();	
		assertEquals(linha, parser.getMatriz());
	}
	
	@Test
	public void testConverteColuna() {
		parser.converteColuna();	
		assertEquals(coluna, parser.getMatriz());
	}
}
