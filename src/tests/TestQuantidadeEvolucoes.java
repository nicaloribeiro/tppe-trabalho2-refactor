package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import app.ArquivoNaoEncontradoException;
import app.Parser;

public class TestQuantidadeEvolucoes {
	
	private Parser parser;
	private Vector<Integer> result;
	private Vector<Vector<String>> arrayLido;
	
	@Before
	public void setup() {
		parser = new Parser();
	}
	
	@Test
	public void testQuantidadeEvolucoes1() throws IOException {
		parser.leArquivo("analysisTest.out");
		parser.converteLinha();
		result = new Vector<Integer>(Arrays.asList(10,10,8));
		assertEquals(result,parser.analiseEvolucoes());
	}
}
