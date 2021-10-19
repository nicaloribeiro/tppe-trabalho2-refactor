package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Parser;

public class Tests {
	
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
}
