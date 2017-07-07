package teste;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestBalanceInquiry {
	
	// Partição de Equivalência
	@Test
	public void testePartEqui(){
		try{
			emulador.balanceInquiry(1,Checking).equals(true);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
		
		try{
			emulador.balanceInquiry(1,Savings).equals(true);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
		
		try{
			emulador.balanceInquiry(2,Money_Market).equals(true);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
		
		try{
			emulador.balanceInquiry(1 ,Money_Market).equals(true);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Operação invalida para este tipo de conta", e.getMessage());
		}	
		
		try{
			emulador.balanceInquiry(2,Savings).equals(true);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Operação invalida para este tipo de conta", e.getMessage());
		}	
	}		
	
	//  Tabela de decisão
	@Test
	public void testeTabDecisao {
		try{
			emulador.balanceInquiry(1,Checking).equals(true);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
		
		try{
			emulador.balanceInquiry(1,Savings).equals(true);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
		
		try{
			emulador.balanceInquiry(2,Money_Market).equals(true);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}
	}
}
