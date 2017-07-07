package teste;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TesteInserirCartao {

	//  Análise de Valor Limite
	@Test
	public void testeValorLim(){
		try{
			emulador.inserirCartao(0);
		}catch (Exception e) {
			Assert.assertEquals("Cartao invalido", e.getMessage());
		}
		
		try{
			emulador.inserirCartao(1);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
		
		try{
			emulador.inserirCartao(2);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
		
		try{
			emulador.inserirCartao(3);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
				
	}
	
	//  Tabela de decisão
	@Test
	public void testeTabDecisao() {
		try{
			emulador.inserirCartao(0);
		}catch (Exception e) {
			Assert.assertEquals("Cartao invalido", e.getMessage());
		}
			
		try{
			emulador.inserirCartao(5);
		}catch (Exception e) {
			Assert.assertEquals("Cartao inexistente", e.getMessage());
		}
			
		try{
			emulador.inserirCartao(1);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
	}	
}
