package tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
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
	}

	@Test
	public void testConverteLinha() throws IOException {
		parser.leArquivo("analysisTest.out");
		linha = new Vector<Vector<String>>(
				Arrays.asList(
						new Vector<String>(Arrays.asList("1", "456", "782", "755", "729", "761", "751", "869", "823", "847", "730")),
						new Vector<String>(Arrays.asList("2", "523", "861", "770", "783", "720", "813", "750", "726", "770", "771")),
						new Vector<String>(Arrays.asList("3", "458", "973", "753", "758", "783", "749", "794", "769"))
						)
				);
		parser.converteLinha();
		assertEquals(linha, parser.getMatriz());
	}
	
	@Test
	public void testConverteLinha2() throws IOException {
		parser.leArquivo("analysisTime.out");
		linha = new Vector<Vector<String>>(
				Arrays.asList(
						new Vector<String>(Arrays.asList("0", "1110", "3200", "934", "2310", "3178", "4009", "737", "3121", "1976", "2573", "6291")),
						new Vector<String>(Arrays.asList("1", "413", "577", "410", "584", "866", "1075", "400", "701", "506", "720", "539")),
						new Vector<String>(Arrays.asList("2", "455", "690", "500", "456", "668", "726", "435", "580", "864", "444", "692")),
						new Vector<String>(Arrays.asList("3", "420", "561", "429", "564", "601", "627", "410", "496", "604", "750", "739")),
						new Vector<String>(Arrays.asList("4", "431", "619", "487", "682", "607", "702", "413", "779", "456", "505", "537")),
						new Vector<String>(Arrays.asList("5", "430", "475", "473", "857", "606", "848", "437", "490", "479", "671", "674")),
						new Vector<String>(Arrays.asList("6", "476", "647", "504", "556", "535", "722", "480", "529", "475", "643", "688")),
						new Vector<String>(Arrays.asList("7", "497", "475", "609", "578", "971", "496", "471", "708", "490", "618", "498")),
						new Vector<String>(Arrays.asList("8", "535", "542", "491", "638", "481", "765", "481", "487", "535", "1015", "652")),
						new Vector<String>(Arrays.asList("9", "558", "584", "563", "577", "645", "1061", "513", "523", "540", "612", "571")),
						new Vector<String>(Arrays.asList("10", "656", "705", "627", "943", "662", "728", "652", "628", "639", "660", "634")),
						new Vector<String>(Arrays.asList("11", "886", "1175", "844", "893", "1096", "1292", "854", "1014", "884", "1024", "862")),
						new Vector<String>(Arrays.asList("12", "2461", "2524", "2364", "2518", "2420", "2394", "2435", "2403", "2386", "2673", "2497")),
						new Vector<String>(Arrays.asList("13", "2291", "2280", "2272", "2379", "2281", "2258", "2305", "2308", "2320", "2275", "2305")),
						new Vector<String>(Arrays.asList("14", "4418", "4528", "4370", "4366", "4379", "4435", "4497", "4765", "4295", "4523", "4515")),
						new Vector<String>(Arrays.asList("15", "8717", "8814", "8604", "8670", "8799", "8472", "8742", "8687", "8792", "8865", "8581")),
						new Vector<String>(Arrays.asList("16", "18237", "17831", "17772", "17577", "18187", "17387", "17879", "17701", "18384", "17701", "18394")),
						new Vector<String>(Arrays.asList("17", "39222", "39442", "40082", "40192", "39168", "39137", "40017", "38000", "39967", "39049", "38238")),
						new Vector<String>(Arrays.asList("18", "120085", "118258", "119943", "116758", "119649", "121215", "113909", "114644", "115771", "107854", "115332")),
						new Vector<String>(Arrays.asList("19", "425823", "421734", "420526", "411620", "414876", "412099", "423135", "421929", "408435", "426251", "412203")),
						new Vector<String>(Arrays.asList("20", "892820", "850745", "878276", "877227", "876456", "866763", "858800", "860945", "868931", "883683", "867026"))
						)
				);
		
		parser.converteLinha();
		assertEquals(linha, parser.getMatriz());
	}
	
	@Test
	public void testConverteColuna() throws IOException {
		parser.leArquivo("analysisTest.out");
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
		parser.converteColuna();
		assertEquals(coluna, parser.getMatriz());
	}
	
	
	@Test
	public void testConverteColuna2() throws IOException {
		parser.leArquivo("analysisTime.out");
		coluna = new Vector<Vector<String>>(
				Arrays.asList(
						new Vector<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20")),
						new Vector<String>(Arrays.asList("1110", "413", "455", "420", "431", "430", "476", "497", "535", "558", "656", "886", "2461", "2291", "4418", "8717", "18237", "39222", "120085", "425823", "892820")),
						new Vector<String>(Arrays.asList("3200", "577", "690", "561", "619", "475", "647", "475", "542", "584", "705", "1175", "2524", "2280", "4528", "8814", "17831", "39442", "118258", "421734", "850745")),
						new Vector<String>(Arrays.asList("934", "410", "500", "429", "487", "473", "504", "609", "491", "563", "627", "844", "2364", "2272", "4370", "8604", "17772", "40082", "119943", "420526", "878276")),
						new Vector<String>(Arrays.asList("2310", "584", "456", "564", "682", "857", "556", "578", "638", "577", "943", "893", "2518", "2379", "4366", "8670", "17577", "40192", "116758", "411620", "877227")),
						new Vector<String>(Arrays.asList("3178", "866", "668", "601", "607", "606", "535", "971", "481", "645", "662", "1096", "2420", "2281", "4379", "8799", "18187", "39168", "119649", "414876", "876456")),
						new Vector<String>(Arrays.asList("4009", "1075", "726", "627", "702", "848", "722", "496", "765", "1061", "728", "1292", "2394", "2258", "4435", "8472", "17387", "39137", "121215", "412099", "866763")),
						new Vector<String>(Arrays.asList("737", "400", "435", "410", "413", "437", "480", "471", "481", "513", "652", "854", "2435", "2305", "4497", "8742", "17879", "40017", "113909", "423135", "858800")),
						new Vector<String>(Arrays.asList("3121", "701", "580", "496", "779", "490", "529", "708", "487", "523", "628", "1014", "2403", "2308", "4765", "8687", "17701", "38000", "114644", "421929", "860945")),
						new Vector<String>(Arrays.asList("1976", "506", "864", "604", "456", "479", "475", "490", "535", "540", "639", "884", "2386", "2320", "4295", "8792", "18384", "39967", "115771", "408435", "868931")),
						new Vector<String>(Arrays.asList("2573", "720", "444", "750", "505", "671", "643", "618", "1015", "612", "660", "1024", "2673", "2275", "4523", "8865", "17701", "39049", "107854", "426251", "883683")),
						new Vector<String>(Arrays.asList("6291", "539", "692", "739", "537", "674", "688", "498", "652", "571", "634", "862", "2497", "2305", "4515", "8581", "18394", "38238", "115332", "412203", "867026"))

						)
				);
		parser.converteColuna();
		assertEquals(coluna, parser.getMatriz());
	}
	
	@Test
	public void testConverteLinha3() throws IOException {
		parser.leArquivo("analysisMemory.out");
		linha = new Vector<Vector<String>>(
				Arrays.asList(
						new Vector<String>(Arrays.asList("0", "34.63005828857422", "34.62224578857422", "34.62224578857422", "34.62224578857422", "34.62224578857422", "34.62224578857422", "34.62224578857422", "34.62224578857422", "34.62224578857422", "34.62224578857422", "34.62224578857422")),
						new Vector<String>(Arrays.asList("1", "35.59007263183594", "35.59007263183594", "35.59007263183594", "35.59007263183594", "35.59007263183594", "35.59007263183594", "35.59007263183594", "35.59007263183594", "35.59007263183594", "35.59007263183594", "35.59007263183594")),
						new Vector<String>(Arrays.asList("2", "35.59031677246094", "35.59031677246094", "35.55113220214844", "35.537513732910156", "35.55113220214844", "35.55113220214844", "35.53749084472656", "35.59031677246094", "35.59031677246094", "35.55113220214844", "35.553192138671875")),
						new Vector<String>(Arrays.asList("3", "36.65733337402344", "36.65733337402344", "36.65733337402344", "36.65733337402344", "36.65733337402344", "36.65733337402344", "36.65733337402344", "36.65733337402344", "36.65733337402344", "36.65733337402344", "36.65733337402344")),
						new Vector<String>(Arrays.asList("4", "37.63884735107422", "37.63884735107422", "37.63884735107422", "37.63884735107422", "37.63884735107422", "37.63884735107422", "37.63884735107422", "37.63884735107422", "37.63884735107422", "37.63884735107422", "37.63884735107422")),
						new Vector<String>(Arrays.asList("5", "39.574554443359375", "39.574554443359375", "39.537864685058594", "39.574554443359375", "39.574554443359375", "39.574554443359375", "39.574554443359375", "39.574554443359375", "39.574554443359375", "39.574554443359375", "39.574554443359375")),
						new Vector<String>(Arrays.asList("6", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875")),
						new Vector<String>(Arrays.asList("7", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875")),
						new Vector<String>(Arrays.asList("8", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875", "41.617401123046875")),
						new Vector<String>(Arrays.asList("9", "44.65733337402344", "44.65733337402344", "44.65733337402344", "44.65733337402344", "44.65733337402344", "44.65733337402344", "44.65733337402344", "44.65733337402344", "44.65733337402344", "44.65733337402344", "44.65733337402344")),
						new Vector<String>(Arrays.asList("10", "49.617401123046875", "49.617401123046875", "49.617401123046875", "49.617401123046875", "49.617401123046875", "49.617401123046875", "49.617401123046875", "49.617401123046875", "49.617401123046875", "49.617401123046875", "49.617401123046875")),
						new Vector<String>(Arrays.asList("11", "27.553634643554688", "27.553665161132812", "27.553207397460938", "27.553665161132812", "27.55321502685547", "27.55315399169922", "27.553268432617188", "27.553207397460938", "27.55127716064453", "27.553184509277344", "27.553665161132812")),
						new Vector<String>(Arrays.asList("12", "27.53746795654297", "27.537437438964844", "27.53839111328125", "27.537437438964844", "27.537437438964844", "27.53746795654297", "27.53746795654297", "27.53839111328125", "27.537460327148438", "27.53746795654297", "27.537460327148438")),
						new Vector<String>(Arrays.asList("13", "46.99834442138672", "47.094459533691406", "47.07793426513672", "46.91382598876953", "47.08573913574219", "47.082122802734375", "47.079925537109375", "47.071144104003906", "46.99921417236328", "47.090492248535156", "46.910987854003906")),
						new Vector<String>(Arrays.asList("14", "85.93535614013672", "86.41481018066406", "87.74950408935547", "86.42205810546875", "88.19488525390625", "86.57553100585938", "85.738037109375", "86.074951171875", "86.42327880859375", "86.7900390625", "85.97779083251953")),
						new Vector<String>(Arrays.asList("15", "265.6123046875", "275.25634765625", "273.25341796875", "273.697265625", "265.091796875", "266.962890625", "271.42724609375", "265.06201171875", "265.19482421875", "267.552734375", "275.07666015625")),
						new Vector<String>(Arrays.asList("16", "619.75732421875", "585.64697265625", "597.697265625", "617.611328125", "611.6953125", "609.8193359375", "588.79931640625", "617.62646484375", "617.7587890625", "613.75927734375", "609.697265625")),
						new Vector<String>(Arrays.asList("17", "292.1605224609375", "298.0877914428711", "259.40924072265625", "296.4632568359375", "294.85009765625", "306.47003173828125", "294.8548583984375", "311.5275344848633", "301.19384765625", "294.99249267578125", "288.36924743652344")),
						new Vector<String>(Arrays.asList("18", "789.6953125", "1037.697265625", "1525.6953125", "1293.697265625", "1441.6005859375", "805.6953125", "1487.6953125", "1605.6953125", "1397.697265625", "647.6953125", "1433.10009765625")),
						new Vector<String>(Arrays.asList("19", "2545.6953125", "2563.697265625", "2507.6953125", "2415.6953125", "2637.697265625", "2477.697265625", "2579.6953125", "2359.697265625", "2575.697265625", "2065.697265625", "2437.6953125")),
						new Vector<String>(Arrays.asList("20", "4891.6953125", "4865.6953125", "4861.6953125", "4573.6953125", "4837.6953125", "4523.6953125", "4865.6953125", "4855.6953125", "4559.697265625", "4829.697265625", "4421.6953125"))

						)
				);
		
		parser.converteLinha();
		assertEquals(linha, parser.getMatriz());
	}
	
	
	@Test
	public void testConverteColuna3() throws IOException {
		parser.leArquivo("analysisMemory.out");
		coluna = new Vector<Vector<String>>(
				Arrays.asList(
						new Vector<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20")),
						new Vector<String>(Arrays.asList("34.63005828857422", "35.59007263183594", "35.59031677246094", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.553634643554688", "27.53746795654297", "46.99834442138672", "85.93535614013672", "265.6123046875", "619.75732421875", "292.1605224609375", "789.6953125", "2545.6953125", "4891.6953125")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.59031677246094", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.553665161132812", "27.537437438964844", "47.094459533691406", "86.41481018066406", "275.25634765625", "585.64697265625", "298.0877914428711", "1037.697265625", "2563.697265625", "4865.6953125")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.55113220214844", "36.65733337402344", "37.63884735107422", "39.537864685058594", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.553207397460938", "27.53839111328125", "47.07793426513672", "87.74950408935547", "273.25341796875", "597.697265625", "259.40924072265625", "1525.6953125", "2507.6953125", "4861.6953125")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.537513732910156", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.553665161132812", "27.537437438964844", "46.91382598876953", "86.42205810546875", "273.697265625", "617.611328125", "296.4632568359375", "1293.697265625", "2415.6953125", "4573.6953125")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.55113220214844", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.55321502685547", "27.537437438964844", "47.08573913574219", "88.19488525390625", "265.091796875", "611.6953125", "294.85009765625", "1441.6005859375", "2637.697265625", "4837.6953125")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.55113220214844", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.55315399169922", "27.53746795654297", "47.082122802734375", "86.57553100585938", "266.962890625", "609.8193359375", "306.47003173828125", "805.6953125", "2477.697265625", "4523.6953125")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.53749084472656", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.553268432617188", "27.53746795654297", "47.079925537109375", "85.738037109375", "271.42724609375", "588.79931640625", "294.8548583984375", "1487.6953125", "2579.6953125", "4865.6953125")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.59031677246094", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.553207397460938", "27.53839111328125", "47.071144104003906", "86.074951171875", "265.06201171875", "617.62646484375", "311.5275344848633", "1605.6953125", "2359.697265625", "4855.6953125")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.59031677246094", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.55127716064453", "27.537460327148438", "46.99921417236328", "86.42327880859375", "265.19482421875", "617.7587890625", "301.19384765625", "1397.697265625", "2575.697265625", "4559.697265625")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.55113220214844", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.553184509277344", "27.53746795654297", "47.090492248535156", "86.7900390625", "267.552734375", "613.75927734375", "294.99249267578125", "647.6953125", "2065.697265625", "4829.697265625")),
						new Vector<String>(Arrays.asList("34.62224578857422", "35.59007263183594", "35.553192138671875", "36.65733337402344", "37.63884735107422", "39.574554443359375", "41.617401123046875", "41.617401123046875", "41.617401123046875", "44.65733337402344", "49.617401123046875", "27.553665161132812", "27.537460327148438", "46.910987854003906", "85.97779083251953", "275.07666015625", "609.697265625", "288.36924743652344", "1433.10009765625", "2437.6953125", "4421.6953125"))

						)
				);
		parser.converteColuna();
		assertEquals(coluna, parser.getMatriz());
	}
}