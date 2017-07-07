package teste;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import emulador.EmuladorATM;

public class TestTransfer {
	private EmuladorATM emulador;
	
	//Inicia a atm com os valores que serão utilizados nos testes
	@Before
	public void before(){
		emulador = new EmuladorATM();
		
		//Valor inicial da atm é 200
		emulador.init(10);
		
		//Saldo da conta checking do cartão 1 é 150
		emulador.getCartao(1).getConta(Checking).setSaldo(150);
	}
	
	
	//Testes Partição de equivalência
	@Test
	public void transfPossuiContasDiferentes() {
		try{
			emulador.transfer(1,Checking,Saving,0);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("O valor da transferência deve ser maior que zero", e.getMessage());
		}
		
		try{
			emulador.transfer(1,Checking,Saving,0.1);
		}catch(Exception e){
			fail("Não esperava exceção");
		}
		
		try{
			emulador.transfer(1,Checking,Saving,0.2);
		}catch(Exception e){
			fail("Não esperava exceção");
		}
	}
	
	@Test
	public void transfNaoPossuiConta() {
		try{
			emulador.transfer(1,Checking,Money_Market,0);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Você deve possuir os dois tipos de conta", e.getMessage());
		}
		
		try{
			emulador.transfer(1,Checking,Money_Market,0.1);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Você deve possuir os dois tipos de conta", e.getMessage());
		}
		
		try{
			emulador.transfer(1,Checking,Money_Market,0.2);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Você deve possuir os dois tipos de conta", e.getMessage());
		}
	}
	
	@Test
	public void transfMesmaConta() {
		try{
			emulador.transfer(1,Checking,Checking,0);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
		
		try{
			emulador.transfer(1,Checking,Checking,0.1);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
		
		try{
			emulador.transfer(1,Checking,Checking,0.2);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
	}
	
	@Test
	public void transfMesmaContaSemPossuir() {
		try{
			emulador.transfer(1,Money_Market,Money_Market,0);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
		
		try{
			emulador.transfer(1,Money_Market,Money_Market,0.1);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
		
		try{
			emulador.transfer(1,Money_Market,Money_Market,0.2);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
	}
	
	
	//Teste tabela de decisão
	public void transfValida() {
		try{
			emulador.transfer(1,Checking,Saving,10);
		}catch(Exception e){
			fail("Não esperava exceção");
		}
	}
	
	@Test
	public void transfValorInvalido() {
		try{
			emulador.transfer(1,Checking,Saving,-10);
		}catch(Exception e){
			fail("O valor da transferência deve ser maior que zero");
		}
	}
	
	@Test
	public void transfNaoPossuiConta() {
		try{
			emulador.transfer(1,Checking,Money_Market,10);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Você deve possuir os dois tipos de conta", e.getMessage());
		}
	}
	
	@Test
	public void transfNaoPossuiContaValorInvalido() {
		try{
			emulador.transfer(1,Checking,Money_Market,-10);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Você deve possuir os dois tipos de conta", e.getMessage());
		}
	}
	
	@Test
	public void transfMesmaConta() {
		try{
			emulador.transfer(1,Checking,Checking,10);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
	}
	
	@Test
	public void transfMesmaContaValorInvalido() {
		try{
			emulador.transfer(1,Checking,Checking,-10);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
	}
	
	@Test
	public void transfMesmaContaSemPossuir() {
		try{
			emulador.transfer(1,Money_Market,Money_Market,10);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
	}
	
	@Test
	public void transfMesmaContaSemPossuirValorInvalido() {
		try{
			emulador.transfer(1,Money_Market,Money_Market,-10);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Não é possível realizar tranferência para a mesma conta", e.getMessage());
		}
	}
}
