package calculator;

import java.util.EmptyStackException;

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
		if(isEmpty())
		{
			throw new StackCalculatorException(1);
		}
		
		// Get the data from top of the stack
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
		if(isEmpty())
		{
			throw new StackCalculatorException(1);
		}
		
		return getTop().getNumber();
	}
	
	// Operation Method
	public double operation(int operand) throws StackCalculatorException
	{
		if(getSize() == 0)
		{
			throw new StackCalculatorException(1);
		}
		
		double arg1, arg2;
		switch(operand)
		{
			case 1:
				if(getSize() < 2)
				{
					throw new StackCalculatorException(2);
				}
				
				return pop() + pop();
			case 2:
				if(getSize() < 2)
				{
					throw new StackCalculatorException(2);
				}
				
				arg2 = pop();
				arg1 = pop();
				return arg1 - arg2;
			case 3:
				if(getSize() < 2)
				{
					throw new StackCalculatorException(2);
				}
				
				return pop() * pop();
			case 4:
				if(getSize() < 2)
				{
					throw new StackCalculatorException(2);
				}
				
				arg2 = pop();
				
				if(arg2 == 0.0)
				{
					throw new StackCalculatorException(3);
				}
				
				arg1 = pop();
				
				return arg1 / arg2;
			case 5:
				return Math.sin(pop());
			case 6:
				return Math.cos(pop());
			case 7:
				return Math.tan(pop());
			case 8:
				return Math.log(pop());
			case 9:
				return Math.log10(pop());
			case 10:
				return Math.sqrt(pop());
			case 11:
				return Math.pow(Math.E, pop());
			case 12:
				if(getSize() < 2)
				{
					throw new StackCalculatorException(2);
				}
				
				arg2 = pop();
				arg1 = pop();
				
				return Math.pow(arg1, arg2);
			case 13:
				return Math.pow(pop(), 2);
		}
		
		// Will never reach this but eclipse forces me to put a return
		return 0.0;
	}
	
	// Print method
	public String print()
	{
		String content = "Stack Contents:\n---------------------------------\n";
		
		if(isEmpty())
		{
			content += "Stack is Empty.";
		}
		else
		{
			Node traverse = getTop();
			
			content+= "---> " + traverse.getNumber();
			traverse = traverse.getNext();
			
			while(traverse != null)
			{
				content += "\n       " + traverse.getNumber();
				traverse = traverse.getNext();
			}
		}
		
		return content;
	}
	
	private class Node
	{
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
		
		// Number Setter
		private void setNumber(double number)
		{
			this.number = number;
		}
		
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
	}
}
