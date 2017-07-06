package emulador;

import java.awt.List;

public class EmuladorATM {
	
	private int qtd_notas;
	private int num_cartao;
	
	
	public void init(int qtd_notas) throws Exception{
		if(qtd_notas < 0) throw new Exception();
		this.qtd_notas = qtd_notas;
	}
	
	public void inserirCartao(int cartao){
		
		this.num_cartao = cartao;
	}
	
}
