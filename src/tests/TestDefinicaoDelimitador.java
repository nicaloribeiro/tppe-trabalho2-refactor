package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.ArquivoNaoEncontradoException;
import app.DelimitadorInvalidoException;
import app.Parser;

public class TestDefinicaoDelimitador {

private Parser parser;
	
	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testeDefinicaoDelimitador() {
		Boolean status = true;
		try {
			parser.definirDelimitador(";");
		} catch (Exception e) {
			status = false;
		}	
		assertEquals(status, true);
	}
	
	@Test
	public void testeDefinicaoDelimitador2() {
		Boolean status = true;
		try {
			parser.definirDelimitador("\n");
		} catch (Exception e) {
			status = false;
		}	
		assertEquals(status, true);
	}
	
	@Test
	public void testeDefinicaoDelimitador3() {
		Boolean status = true;
		
		try {
			parser.definirDelimitador("\n");
			parser.definirDelimitador(";");
			parser.definirDelimitador(",");
		} catch (Exception e) {
			status = false;
		}
		
		assertEquals(status, true);
	}
	
	@Test
	public void testDelimitadorInvalido() throws DelimitadorInvalidoException  {
		String message = "";
		
		try {
			parser.definirDelimitador("delimitador");
		} catch (DelimitadorInvalidoException e) {
			message = e.getMessage();
		}
		
		assertEquals(message, "O delimitador e invalido.");
	}
	

}
