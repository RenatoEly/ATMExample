package teste;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import emulador.EmuladorATM;

public class TestWithdraw {

	
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
	
	//Teste por tabela de decisão
	@Test
	public void saqueValido() {
		try{
			emulador.withdraw(1,Checking,100);
		}catch(Exception e){
			fail("Não esperava exceção");
		}
	}
	
	@Test
	public void saqueMaiorSaldo(){
		try{
			emulador.withdraw(1,Checking,200);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Valor de saque maior que o saldo disponível", e.getMessage());
		}
	}
	
	@Test
	public void saqueMaiorDisponivel(){
		emulador.getCartao(1).getConta(Checking).setSaldo(500);
		
		try{
			emulador.withdraw(1,Checking,220);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Valor de saque maior que o disponível na atm", e.getMessage());
		}
	}
	
	@Test
	public void saqueMaiorDiario(){
		emulador.init(50);
		emulador.getCartao(1).getContaChecking().setSaldo(500);
		
		try{
			emulador.withdraw(1,Checking,340);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Valor de saque maior que o limite diário", e.getMessage());
		}
	}
	
	@Test
	public void saqueMaiorDisponivelESaldo(){
		try{
			emulador.withdraw(1,Checking,240);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Valor de saque maior que o disponível na atm", e.getMessage());
		}
	}
	
	@Test
	public void saqueMaiorDiarioESaldo(){
		emulador.init(50);
		
		try{
			emulador.withdraw(1,Checking,340);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Valor de saque maior que o limite diário", e.getMessage());
		}
	}
	
	@Test
	public void saqueMaiorDiarioEDisponivel(){
		emulador.getCartao(1).getConta(Checking).setSaldo(500);
		
		try{
			emulador.withdraw(1,Checking,340);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Valor de saque maior que o limite diário", e.getMessage());
		}
	}
	
	@Test
	public void saqueMaiorDiarioEDisponivelESaldo(){
		try{
			emulador.withdraw(1,Checking,340);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Valor de saque maior que o limite diário", e.getMessage());
		}
	}
	
	@Test
	public void saqueContaNaoAssociada(){
		try{
			emulador.withdraw(1,Money_Market,100);
			fail("Esperava exceção");
		}catch(Exception e){
			Assert.assertEquals("Conta não associada ao cartãoo", e.getMessage());
		}
	}
}
