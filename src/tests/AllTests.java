  
package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestArquivoSaida.class,
	TestArquivoTextoFinal.class,
	TestConversor.class,
	TestDefinicaoDelimitador.class,
	TestLeituraArquivo.class,
	TestQuantidadeEvolucoes.class})
public class AllTests {

}