package teste;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteVerificarSenha {

	//  Tabela de decisão
	@Test
	public void testeTabDecisao {
		try{
			emulador.verificarSenha(0,12);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Cartao invalido", e.getMessage());
		}
		
		try{
			emulador.verificarSenha(5,666);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Cartao invalido", e.getMessage());
		}
		
		try{
			emulador.verificarSenha(2,666);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Cartao invalido", e.getMessage());
		}
			
		try{
			emulador.inserirCartao(2,1234);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}					
	}	
}
