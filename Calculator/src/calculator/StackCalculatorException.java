package calculator;

public class StackCalculatorException extends Exception
{
	private String error;
	
	// Constructor
	public StackCalculatorException(int code)
	{
		switch(code)
		{
			case 1:
				error = "ERROR! Empty Stack! Resetting!";
				break;
			case 2:
				error = "ERROR! Not enough arguments! Resetting!";
				break;
			case 3:
				error = "ERROR! Division by Zero! Resetting!";
				break;
		}
	}
	
	// Error Getter
	public String getError()
	{
		return error;
	}
}
