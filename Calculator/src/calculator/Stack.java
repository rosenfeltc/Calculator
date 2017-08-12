package calculator;

import java.util.EmptyStackException;

public class Stack
{
	private Node top;
	
	// Constructor
	public Stack()
	{
		top = null;
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
	
	//Is Empty method
	private boolean isEmpty()
	{
		return getTop() == null;
	}
	
	// Push Method
	public void push(Double number)
	{
		Node newNode = new Node(number);
		
		// List is empty so only need to add to beginning of stack
		if(isEmpty())
		{
			setTop(newNode);
			return;
		}
		
		// List is not empty so add new node to beginning of stack but
		// also have newNode point to Node that used to be the beginning
		newNode.setNext(getTop());
		setTop(newNode);
	}
	
	// Pop Method
	public double pop() throws EmptyStackException
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		// Get the data from top of the stack
		double temp = getTop().getNumber();
		
		// Remove data from the top of the stack
		setTop(getTop().getNext());
		
		return temp;
	}
	
	// Peek Method
	public double peek() throws EmptyStackException
	{
		if(isEmpty())
		{
			throw new EmptyStackException();
		}
		
		return getTop().getNumber();
	}
	
	// Operation Method
	public double operation(int operand)
	{
		switch(operand)
		{
			case 1:
				return pop() + pop();
			case 2:
				return pop() - pop();
			case 3:
				return pop() * pop();
			case 4:
				return pop() / pop();
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
				return Math.pow(pop(), pop());
			case 13:
				return Math.pow(pop(), 2);
		}
		
		// Will never reach this but eclipse forces me to put a return
		return 0.0;
	}
	
	// Print method
	public String print()
	{
		String content = "Stack Contents:\n-----------------------------------\n";
		
		if(isEmpty())
		{
			content += "Stack is Empty.";
		}
		else
		{
			Node traverse = getTop();
			
			content+= "--> " + traverse.getNumber();
			traverse = traverse.getNext();
			
			while(traverse != null)
			{
				content += "\n    " + traverse.getNumber();
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
