package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.Parser;

public class TestArquivoSaida {

private Parser parser;
	
	@Before
	public void setup() {
		parser = new Parser();
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
	
}