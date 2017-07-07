package teste;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestDeposit {

	// Partição de Equivalência
	@Test
	public void testePartEqui(){
		
		try{
			emulador.deposit(1,Checking,0);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Valor de deposito invalido", e.getMessage());
		}
		
		try{
			emulador.deposit(1,Checking,0.01);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}	
		
		try{
			emulador.deposit(1,Checking,0.02);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}	
		
		try{
			emulador.deposit(1,Money_Market,0);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Conta não associada ao cartão", e.getMessage());
		}
		
		try{
			emulador.deposit(1,Money_Market,0.01);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Conta não associada ao cartão", e.getMessage());
		}
		
		try{
			emulador.deposit(1,Money_Market,0.02);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Conta não associada ao cartão", e.getMessage());
		}
	}
	
	//  Tabela de decisão
	@Test
	public void testeTabDecisao {
		
		try{
			emulador.deposit(1,Checking,100);
		}catch (Exception e) {
			Assert.fail("Não esperava exceção");
		}	
		
		try{
			emulador.deposit(1,Checking,1000);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Valor de deposito invalido", e.getMessage());
		}
		
		try{
			emulador.deposit(1,Money_Market,0.99);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Conta não associada ao cartão", e.getMessage());
		}
		
		try{
			emulador.deposit(1,Money_Market,0);
			Assert.fail("Esperava exceção");
		}catch (Exception e) {
			Assert.assertEquals("Conta não associada ao cartão", e.getMessage());
		}
	}
}
