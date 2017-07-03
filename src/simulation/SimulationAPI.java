package simulation;

import atm.ATM;
import banking.Balances;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Status;

public class SimulationAPI {
	/** The one and only instance of this class
     */
    private static Simulation theInstance;
    
    /** The ATM object for the ATM being simulated
     */
    private ATM atm;
    
    private Money initialCash;
    private Card card;
    
    /** Simulated bank
     */
    private SimulatedBank simulatedBank;
    
	public SimulationAPI(ATM atm)
    {
        this.atm = atm;
        
        simulatedBank = new SimulatedBank();
        
        theInstance = null;
    }
    
    /** Accessor for the one and only instance of this class
     *
     *  @return the instance of this class
     */
    public static Simulation getInstance()
    {
        return theInstance;
    }
    
    /** Simulated getting initial amount of cash from operator
     *
     *  @return value of initial cash entered
     */
    public Money getInitialCash()
    {
        return initialCash;
    }
    
    /** Simulate reading of a card
     *
     *
     *  @return Card object representing information on the card if read
     *          successfully, null if not read successfully
     */
    public Card readCard()
    {
        return card;
    }
    
    /** Simulate ejecting a card 
     */
    public void ejectCard()
    {
        card = null;
    }
    
    /** Simulate retaining a card
     */
    public void retainCard()
    {
        
    }
    
    /** Clear the simulated display
     */
    public void clearDisplay()
    {
        
    }
    
    /** Write one or more lines to the display - beginning just after the
     *  last line written
     *
     *  @param text the text to display
     */
    public void display(String text)
    {
        System.out.println(text);
    }
     
    /** Simulate reading input from the keyboard
     *
     *  @param mode the input mode to use - one of the constants defined below.
     *  @param maxValue the maximum acceptable value (used in MENU_MODE only)
     *  @return the line that was entered - null if user pressed CANCEL.
     */
    public String readInput(int mode, int maxValue)
    {
    	//Não entendi
        return keyboard.readInput(mode, maxValue);
    }
    
    /** Simulate dispensing cash to a customer
     *
     *  @param amount the amount of cash to dispense
     *
     *  Precondition: amount is <= cash on hand
     */
    public void dispenseCash(Money amount)
    {
        System.out.println("Você sacou "+amount.toString());
    }

    /** Simulate accepting an envelope from customer.
     *
     *  return true if an envelope was received within the prescribed time,
     *         else false
     */
    public boolean acceptEnvelope()
    {
    	return true;
        //return envelopeAcceptor.acceptEnvelope();
    }

    /** Simulate printing one line of a receipt
     *
     *  @param text the line to print
     */
    public void printReceiptLine(String text)
    {
        System.out.println(text);
    }
    
    /** Simulate printing a line to the log
     *
     *  @param text the line to print
     */
    public void printLogLine(String text)
    {
        System.out.println(text);
    }
    
    /** Simulate sending a message to bank
     *
     *  @param message the message to send
     *  @param balances (out) balances in customer's account as reported
     *         by bank
     *  @return status code returned by bank
     */
    public Status sendMessage(Message message, Balances balances)
    {
        // Simulate time taken to send message over network
        
        try
        {
            Thread.sleep(2 * 1000);
        }
        catch(InterruptedException e)
        { }
        
        return simulatedBank.handleMessage(message, balances);
    }

    /** Notify the ATM that the state of the on-off switch has been changed
     *
     *  @param on true if state is now "on", false if it is "off"
     */
    void switchChanged(boolean on)
    {
        // The card reader is only enabled when the switch is on
        
        
        
        if (on)
            atm.switchOn();
        else
            atm.switchOff();
    }
    
    /** Notify ATM that a card has been inserted
     */
    void cardInserted()
    {
        atm.cardInserted();
    }
    
    /** Accessor for GUI Panel that simulates the ATM
     *
     *  @return the GUI Panel
     */
    public GUI getGUI()
    {
    	return null;
        //return gui;
    }
    
    /** Accessor for simulated bank
     *
     *  @return simulated bank
     */
    public SimulatedBank getSimulatedBank()
    {
        return simulatedBank;
    }
}
