package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.ArquivoNaoEncontradoException;
import app.Parser;

public class TestArquivoSaida {

private Parser parser;
	
	@Before
	public void setup() throws ArquivoNaoEncontradoException {
		parser = new Parser();
		parser.leArquivo("analysisTime.out");
	}
	
	@Test
	public void testArquivoSaida() {
		Boolean status = true;
		
		try {
			parser.criaArquivoSaida();
		} catch (Exception e) {
			status = false;
		}
		
		assertEquals(status, true);
	}
	
	@Test
	public void testArquivoSaida2() {
		Boolean status = true;
		
		try {
			parser.criaArquivoSaida();
		} catch (Exception e) {
			status = false;
		}
		
		assertEquals(status, true);
	}
	
}