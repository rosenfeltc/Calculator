/*This is the Main.java class that simply contains the main method that allows for the execution of the GUI Calculator
 * Coded by Christopher Rosenfelt for CSI 213
 */
package calculator;

public class Main
{
	public static void main(String[] args)
	{
		// Create the Stack reference and point it to the newly instantiated Stack
		Stack theStack = new Stack();
		
		// Create the calculator reference and point it to the newly instantiated
		// Calculator with the Stack passed in as a parameter
		Calculator theCalculator = new Calculator(theStack);
	}
}
