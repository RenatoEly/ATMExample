package teste;

import org.junit.*;

public class TestInitATM {

	// Partição de Equivalência
	@Test
	public void testePartEqui(){
		
		try{
			emulador.init(1);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
		
		try{
			emulador.init(0);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
		
		try{
			emulador.init(-1);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Quantidade de notas invalida", e.getMessage());
		}
	}
	
	//  Tabela de decisão
	@Test
	public void testeTabDecisao(){
			
		try{
			emulador.init(10);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
			
		try{
			emulador.init(-10);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Quantidade de notas invalida", e.getMessage());
		}
	}	
}
