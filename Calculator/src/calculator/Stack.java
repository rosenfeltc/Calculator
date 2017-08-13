/*This is the Stack.java class that handles all the necessary stack operations to make the GUI Calculator work
 * Coded by Christopher Rosenfelt for CSI 213
 */
package calculator;

public class Stack
{
	private Node top; // Top of the Stack
	private int size; // How many arguments are in the Stack
	
	// Constructor
	public Stack()
	{
		top = null;
		size = 0;
	}
	
	// Top Getter
	private Node getTop()
	{
		return top;
	}
	
	// Top Setter
	private void setTop(Node top)
	{
		this.top = top;
	}
	
	// Size Getter
	public int getSize()
	{
		return size;
	}
	
	// Size Incrementer
	private void incrementSize()
	{
		size++;
	}
	
	// Size Decrementer
	private void decrementSize()
	{
		size--;
	}
	
	//Is Empty method
	private boolean isEmpty()
	{
		return getTop() == null;
	}
	
	// Push Method
	public void push(Double number)
	{
		// Create the new Node with the passed in Double
		Node newNode = new Node(number);
		
		// List is not empty so new Node should point to what used to be
		// the beginning of the stack
		if(!isEmpty())
		{
			newNode.setNext(getTop());
		}
		
		// New Node is now the top of the stack
		setTop(newNode);
		
		// Increment the size counter
		incrementSize();
	}
	
	// Pop Method
	public double pop() throws StackCalculatorException
	{
		// Nothing in the stack so nothing to pop
		if(isEmpty())
		{
			// Empty stack exception
			throw new StackCalculatorException(1);
		}
		
		// Get the data from top of the stack and store in temp Double variable
		double temp = getTop().getNumber();
		
		// Remove data from the top of the stack
		setTop(getTop().getNext());
		
		// Decrement size counter
		decrementSize();
		
		return temp;
	}
	
	// Peek Method
	public double peek() throws StackCalculatorException
	{
		// Nothing in the stack so nothing to peek at
		if(isEmpty())
		{
			// Empty stack exception
			throw new StackCalculatorException(1);
		}
		
		return getTop().getNumber();
	}
	
	// Operation Method
	public double operation(int operand) throws StackCalculatorException
	{
		// The stack is empty
		if(getSize() == 0)
		{
			// Empty Stack exception
			throw new StackCalculatorException(1);
		}
		
		// Variables that will be used for any necessary calculations
		double arg1, arg2;
		
		// Perform the appropriate calculation based on passed in operand parameter
		switch(operand)
		{
			case 1: // Addition
				// Not enough arguments to do addition
				if(getSize() < 2)
				{
					// Not enough arguments exception
					throw new StackCalculatorException(2);
				}
				
				return pop() + pop();
				
			case 2: // Subtraction
				// Not enough arguments to do subtraction
				if(getSize() < 2)
				{
					// Not enough arguments exception
					throw new StackCalculatorException(2);
				}
				
				arg2 = pop();
				arg1 = pop();
				return arg1 - arg2;
				
			case 3: // Multiplication
				// Not enough arguments to do multiplication
				if(getSize() < 2)
				{
					// Not enough arguments exception
					throw new StackCalculatorException(2);
				}
				
				return pop() * pop();
				
			case 4: // Division
				// Not enough arguments to do division
				if(getSize() < 2)
				{
					// Not enough arguments exception
					throw new StackCalculatorException(2);
				}
				
				arg2 = pop();
				
				// Can't divide by 0
				if(arg2 == 0.0)
				{
					// Division by zero exception
					throw new StackCalculatorException(3);
				}
				
				arg1 = pop();
				
				return arg1 / arg2;
				
			case 5: // Sine
				return Math.sin(pop());
				
			case 6: // Cosine
				return Math.cos(pop());
				
			case 7: // Tangent
				return Math.tan(pop());
				
			case 8: // Natural logarithm
				return Math.log(pop());
				
			case 9: // Base-10 logarithm
				return Math.log10(pop());
				
			case 10: // Square-root
				return Math.sqrt(pop());
				
			case 11: // e to the power of x
				return Math.pow(Math.E, pop());
				
			case 12: // x to the power of y
				// Not enough arguments
				if(getSize() < 2)
				{
					// Not enough arguments exception
					throw new StackCalculatorException(2);
				}
				
				arg2 = pop();
				arg1 = pop();
				
				return Math.pow(arg1, arg2);
				
			case 13: // Squared
				return Math.pow(pop(), 2);
		}
		
		// Will never reach this but eclipse forces me to put a return outside of the switch statement
		return 0.0;
	}
	
	// Print method
	public String print()
	{
		// Initial String that will always be part of the Calculator's Stack display
		String content = "Stack Contents:\n---------------------------------------\n";
		
		// Stack is empty
		if(isEmpty())
		{
			content += "Stack is Empty.";
		}
		// Add stack contents to the String
		else
		{
			// Node reference to traverse the stack
			Node traverse = getTop();
			
			// The top of the stack has its own special pointer
			content+= "---> " + traverse.getNumber();
			traverse = traverse.getNext();
			
			// While the stack is not empty, traverse stack and add arguments to the String
			while(traverse != null)
			{
				// The spaces are to align with the top of the stack that has an arrow
				content += "\n       " + traverse.getNumber();
				traverse = traverse.getNext();
			}
		}
		
		// Return the String to be displayed in the Calculator's Stack display
		return content;
	}
	
	// Private Node class that allows the Stack to be created in a reference based list
	private class Node
	{
		// Fields
		private double number;
		private Node next;
		
		// Constructor
		private Node(double number)
		{
			this.number = number;
			next = null;
		}
		
		// Number Getter
		private double getNumber()
		{
			return number;
		}
		
		// Number Setter isn't necessary for calculator operation
		
		// Next Getter
		private Node getNext()
		{
			return next;
		}
		
		// Next Setter
		private void setNext(Node next)
		{
			this.next = next;
		}
	}// End private Node class
}
