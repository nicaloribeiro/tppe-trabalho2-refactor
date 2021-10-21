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
	
	@Test
	public void testTextoComDelimitador3(){
		try {
			parser.leArquivo("analysisTest.out");
			parser.definirDelimitador("\n");
			parser.converteLinha();
			parser.formataTextoComDelimitador();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Vector<String> linha = new Vector<String>(Arrays.asList("1\n456\n782\n755\n729\n761\n751\n869\n823\n847\n730","2\n523\n861\n770\n783\n720\n813\n750\n726\n770\n771", "3\n458\n973\n753\n758\n783\n749\n794\n769"));
		assertEquals(linha, parser.getTextoFormatado());
		try {
			parser.leArquivo("analysisTest.out");
			parser.definirDelimitador(";");
			parser.converteColuna();
			parser.formataTextoComDelimitador();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Vector<String> coluna = new Vector<String>(Arrays.asList("1;2;3","456;523;458", "782;861;973","755;770;753","729;783;758","761;720;783","751;813;749","869;750;794","823;726;769","847;770;","730;771;"));
		assertEquals(coluna, parser.getTextoFormatado());
	}
	
	@Test
	public void testEscreveArquivoFinal() {
		Boolean status = true;
		try {
			parser.leArquivo("analysisTest.out");
			parser.definirDelimitador(";");
			parser.criaArquivoSaida();
			parser.converteLinha();
			parser.formataTextoComDelimitador();
			parser.escreveTextoSaida();
		} catch (Exception e) {
			status = false;
		}
		assertEquals(true,status);
	}
	
	@Test
	public void testEscreveArquivoFinal2() {
		Boolean status = true;
		try {
			parser.leArquivo("analysisTest.out");
			parser.definirDelimitador(";");
			parser.criaArquivoSaida();
			parser.converteColuna();
			parser.formataTextoComDelimitador();
			parser.escreveTextoSaida();
		} catch (Exception e) {
			status = false;
		}
		assertEquals(true,status);
	}

}
