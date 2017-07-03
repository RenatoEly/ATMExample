package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.CardReader;
import atm.physical.CustomerConsole;
import atm.physical.OperatorPanel;
import simulation.GUI;
import simulation.Simulation;

public class TesteCriacaoATM {
	
	@Test
	public void teste(){
		ATM theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null /* We're not really talking to a bank! */);
		Simulation simulation = new Simulation(theATM);
		new Thread(theATM).start();
		
		
	}

}
