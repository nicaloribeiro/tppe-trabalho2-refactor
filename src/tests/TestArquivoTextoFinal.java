package tests;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import app.ArquivoNaoEncontradoException;
import app.DelimitadorInvalidoException;
import app.Parser;

public class TestArquivoTextoFinal {
	private Parser parser;
	@Before
	public void setup() throws DelimitadorInvalidoException, ArquivoNaoEncontradoException {
		parser = new Parser();			
	}
	
	@Test
	public void testTextoComDelimitador(){
		try {
			parser.leArquivo("analysisTest.out");
			parser.definirDelimitador(";");
			parser.converteLinha();
			parser.formataTextoComDelimitador();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Vector<String> linha = new Vector<String>(Arrays.asList("1;456;782;755;729;761;751;869;823;847;730", "2;523;861;770;783;720;813;750;726;770;771", "3;458;973;753;758;783;749;794;769"));
		assertEquals(linha, parser.getTextoFormatado());
	}
	
	@Test
	public void testTextoComDelimitador2(){
		try {
			parser.leArquivo("analysisTest.out");
			parser.definirDelimitador(",");
			parser.converteLinha();
			parser.formataTextoComDelimitador();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Vector<String> linha = new Vector<String>(Arrays.asList("1,456,782,755,729,761,751,869,823,847,730", "2,523,861,770,783,720,813,750,726,770,771", "3,458,973,753,758,783,749,794,769"));
		assertEquals(linha, parser.getTextoFormatado());
	}

}
