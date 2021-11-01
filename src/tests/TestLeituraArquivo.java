package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.ArquivoNaoEncontradoException;
import app.Parser;

public class TestLeituraArquivo {
	
	private Parser parser;
	
	@Before
	public void setup() {
		parser = new Parser();
	}

	@Test
	public void testLeituraArquivo() {
		Boolean status = true;
		
		try {
			parser.leArquivo("analysisTime.out");
		} catch (Exception e) {
			status = false;
		}
		
		assertEquals(status, true);
	}
	
	@Test
	public void testLeituraArquivo2() {
		Boolean status = true;
		
		try {
			parser.leArquivo("analysisMemory.out");
		} catch (Exception e) {
			status = false;
		}
		
		assertEquals(status, true);
	}
	
	@Test
	public void testLeituraArquivo3() {
		Boolean status = true;
		
		try {
			parser.leArquivo("analysisTime.out");
			parser.leArquivo("analysisMemory.out");
			parser.leArquivo("analysisTest.out");
		} catch (Exception e) {
			status = false;
		}
		
		assertEquals(status, true);
	}

	@Test
	public void testArquivoNaoEncontrado() {
		String message = "";
		
		try {
			parser.leArquivo("chambioá.out");
		} catch (ArquivoNaoEncontradoException e) {
			message = e.getMessage();
		}
		
		assertEquals(message, "chambioá.out nao encontrado.");
	}
}
