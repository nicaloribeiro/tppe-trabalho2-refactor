package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import app.ArquivoNaoEncontradoException;
import app.EscritaNaoPermitidaException;
import app.Parser;

public class TestArquivoSaida {

private Parser parser;
	
	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testArquivoSaida() throws ArquivoNaoEncontradoException {
		parser.leArquivo("analysisTime.out");
		Boolean status = true;
		
		try {
			parser.criaArquivoSaida();
		} catch (Exception e) {
			status = false;
		}
		
		assertEquals(status, true);
	}
	
	@Test
	public void testArquivoSaida2() throws ArquivoNaoEncontradoException {
		parser.leArquivo("analysisMemory.out");
		Boolean status = true;
		
		try {
			parser.criaArquivoSaida();
		} catch (Exception e) {
			status = false;
		}
		
		assertEquals(status, true);
	}
	
	@Test
	public void testArquivoSaida3() throws ArquivoNaoEncontradoException {
		parser.leArquivo("analysisTest.out");
		Boolean status = true;
		
		try {
			parser.criaArquivoSaida();
		} catch (Exception e) {
			status = false;
		}
		
		assertEquals(status, true);
	}
	
	@Test
	public void testEscritaNaoPermitida () throws EscritaNaoPermitidaException, IOException {
		parser.leArquivo("analysisTest.out");
		String message = "";
		
		// Emulando arquivo com escrita não permitida
		File arquivo = new File("analysisTestTab.out");
		arquivo.createNewFile();
		arquivo.setWritable(false);
		
		try {
			parser.criaArquivoSaida();
		} catch (EscritaNaoPermitidaException e) {
			message = e.getMessage();
			arquivo.setWritable(true);
		}
		
		assertEquals(message, "Escrita não permitida.");
	}
}