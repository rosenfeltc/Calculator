/*This is the Calculator.java class that handles the GUI of the calculator. All the calculator buttons have action listeners
 * for which most of them interact with the Stack.java class in order to do the user's desired operations.
 * Coded by Christopher Rosenfelt for CSI 213
 */
package calculator;

// Importing the necessary Libraries/Packages
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

public class Calculator extends JFrame
{
	// Fields
	private String display; // Will be used as the calculator's display screen
	private boolean isPI, isE, isResult, isCenter, isDot; // booleans that will help the proper resetting of the calculator's
													// display
	// screen
	private JPanel buttonPanel, calculatorDisplayPanel, stackDisplayPanel; // The necessary panels that will be placed
																			// on the JFrame to make the GUI Calculator
	private JButton lnx, logx, ce, pop, backspace, squared, powerOf, sine, cosine, tangent, squareRoot, one, two, three,
			plus, ex, four, five, six, minus, e, seven, eight, nine, times, pi, dot, zero, push, divide; // All the
																											// calculator
																											// buttons
	private JTextArea stackDisplay; // The display for the stack
	private JTextField calculatorDisplay; // Used with the display String as the calculator's display screen
	private JScrollPane theScrollPane; // Used with the stackDisplay to make the stack display a scroll pane

	// Method that resets the calculator's display screen
	private void clearDisplay()
	{
		display = "";
		calculatorDisplay.setText(display);

	}

	// Method that adds the passed in string to the current display String and
	// updates the calculator's display screen accordingly
	private void addDisplay(String arg)
	{
		display += arg;
		calculatorDisplay.setText(display);
	}

	// Method that replaces the display String with the passed in String and
	// updates the calculator's display screen accordingly
	private void setDisplay(String arg)
	{
		display = arg;
		calculatorDisplay.setText(display);
	}

	// Method that acts like the back space button on the display screen, meaning
	// it removes the last inserted character inputted. If the screen is blank or
	// if the screen is showing a calculatted result, then backspace doesn't do
	// anything
	private void backspaceDisplay()
	{
		// Screen is already empty or showing a calculated result or an error
		if (calculatorDisplay.getText().isEmpty() || isResult || calculatorDisplay.getText().contains("ERROR"))
		{
			// Do nothing
		}
		// Remove the last character inserted
		else
		{
			setDisplay(display.substring(0, display.length() - 1));
		}
	}

	// Constructor taking the Stack reference as a parameter
	public Calculator(Stack theStack)
	{
		// Set the booleans initially to false as they haven't been activated yet
		isPI = false;
		isE = false;
		isResult = false;
		isCenter = false;
		isDot = false;
		// Instantiating the buttons and adding them to the corresponding Panel
		buttonPanel = new JPanel(new GridLayout(6, 5)); // 30 total buttons - 6 rows and 5 columns

		// The Buttons on the Panel - self explanatory variable names
		lnx = new JButton("ln(x)");
		lnx.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(lnx);

		logx = new JButton("log(x)");
		logx.setFont(new Font("Arial", 0, 25));
		buttonPanel.add(logx);

		ce = new JButton("CE");
		ce.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(ce);

		pop = new JButton("POP");
		pop.setFont(new Font("Arial", 1, 30));
		buttonPanel.add(pop);

		backspace = new JButton("\u2190"); // unicode for the left pointing arrow
		backspace.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(backspace);

		squared = new JButton("x\u00B2"); // unicode for the superscript "2"
		squared.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(squared);

		powerOf = new JButton("x\u02B8"); // unicode for the superscript "y"
		powerOf.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(powerOf);

		sine = new JButton("sin(x)");
		sine.setFont(new Font("Arial", 0, 24));
		buttonPanel.add(sine);

		cosine = new JButton("cos(x)");
		cosine.setFont(new Font("Arial", 0, 24));
		buttonPanel.add(cosine);

		tangent = new JButton("tan(x)");
		tangent.setFont(new Font("Arial", 0, 24));
		buttonPanel.add(tangent);

		squareRoot = new JButton("\u221A"); // unicode for the square root symbol
		squareRoot.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(squareRoot);

		one = new JButton("1");
		one.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(one);

		two = new JButton("2");
		two.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(two);

		three = new JButton("3");
		three.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(three);

		plus = new JButton("+");
		plus.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(plus);

		ex = new JButton("e\u02E3"); // unicode for the superscript "x"
		ex.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(ex);

		four = new JButton("4");
		four.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(four);

		five = new JButton("5");
		five.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(five);

		six = new JButton("6");
		six.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(six);

		minus = new JButton("-");
		minus.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(minus);

		e = new JButton("e");
		e.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(e);

		seven = new JButton("7");
		seven.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(seven);

		eight = new JButton("8");
		eight.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(eight);

		nine = new JButton("9");
		nine.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(nine);

		times = new JButton("x");
		times.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(times);

		pi = new JButton("\u03C0"); // unicode for the lower case pi symbol
		pi.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(pi);

		dot = new JButton(".");
		dot.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(dot);

		zero = new JButton("0");
		zero.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(zero);

		push = new JButton("PUSH");
		push.setFont(new Font("Arial", 1, 22));
		buttonPanel.add(push);

		divide = new JButton("\u00F7"); // unicode for the division symbol
		divide.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(divide);

		// The Stack display on ScrollPane on Panel
		stackDisplayPanel = new JPanel();
		stackDisplay = new JTextArea();
		stackDisplay.setText(theStack.print()); // uses the print method from Stack.java to obtain a String with the
												// contents of the stack
		stackDisplay.setFont(new Font("Arial", 1, 18));
		stackDisplay.setAlignmentX(SwingConstants.LEFT);
		stackDisplay.setEditable(false); // can't be edited
		// Force the scroll pane to not scroll automatically - allows for the proper
		// showing of the stack
		DefaultCaret caret = (DefaultCaret) stackDisplay.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		// Create the scroll pane and adjust it to only show the scrollbars when they
		// become necessary
		theScrollPane = new JScrollPane(stackDisplay);
		theScrollPane.setPreferredSize(new Dimension(158, 490));
		theScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		theScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		stackDisplayPanel.add(theScrollPane);

		// The calculator display on the panel
		display = new String();
		calculatorDisplayPanel = new JPanel();
		calculatorDisplay = new JTextField(display);
		calculatorDisplay.setEditable(false); // can't be edited
		calculatorDisplay.setBackground(Color.WHITE);
		calculatorDisplay.setOpaque(true);
		calculatorDisplay.setForeground(Color.BLACK);
		calculatorDisplay.setFont(new Font("Arial", 1, 28));
		calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		calculatorDisplay.setPreferredSize(new Dimension(600, 50));
		calculatorDisplayPanel.add(calculatorDisplay);

		// -------------------------//
		// The Button Listeners: //
		// -------------------------//

		// Natural log of X button
		lnx.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(8);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// Log base 10 of X button
		logx.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(9);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// Clear Entry button
		ce.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the display and ensure all the booleans (except for isCenter) are set
				// to false
				clearDisplay();
				isPI = false;
				isE = false;
				isResult = false;
				isDot = false;
			}
		});

		// POP button
		pop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Pop the stack, display it as a result and update the stack display
					double result = theStack.pop();
					isResult = true;
					isDot = false; // Allow the dot operator to be used again

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// Backspace button
		backspace.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// call the backspace method
				backspaceDisplay();
			}
		});

		// Square of X button
		squared.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(13);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// X to the power of Y button
		powerOf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(12);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// Sine of X button
		sine.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(5);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// Cosine of X button
		cosine.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(6);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// Tangent of X button
		tangent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(7);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// Square Root of X button
		squareRoot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(10);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// 1 button
		one.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 1 to the calculator display screen
				addDisplay(Integer.toString(1));
			}
		});

		// 2 button
		two.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 2 to the calculator display screen
				addDisplay(Integer.toString(2));
			}
		});

		// 3 button
		three.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 3 to the calculator display screen
				addDisplay(Integer.toString(3));
			}
		});

		// Add button
		plus.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(1);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// e to the power of X button
		ex.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(11);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// 4 button
		four.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 4 to the calculator display screen
				addDisplay(Integer.toString(4));
			}
		});

		// 5 button
		five.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 5 to the calculator display screen
				addDisplay(Integer.toString(5));
			}
		});

		// 6 button
		six.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 6 to the calculator display screen
				addDisplay(Integer.toString(6));
			}
		});

		// Subtract button
		minus.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(2);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// e button
		e.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen if it contains any contents and set the other booleans to
				// false
				if (!calculatorDisplay.getText().isEmpty())
				{
					clearDisplay();
					isPI = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add e value to the screen and update the isE boolean to true
				isE = true;
				addDisplay(Double.toString(Math.E));
				isDot = false; // Allow the dot operator to be used again
			}
		});

		// 7 button
		seven.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 7 to the calculator display screen
				addDisplay(Integer.toString(7));
			}
		});

		// 8 button
		eight.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 8 to the calculator display screen
				addDisplay(Integer.toString(8));
			}
		});

		// 9 button
		nine.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 9 to the calculator display screen
				addDisplay(Integer.toString(9));
			}
		});

		// Multiplication button
		times.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(3);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
				}
			}
		});

		// PI button
		pi.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen if it contains any contents and set the other booleans to
				// false
				if (!calculatorDisplay.getText().isEmpty())
				{
					clearDisplay();
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add pi to the display and set isPI to true
				isPI = true;
				addDisplay(Double.toString(Math.PI));
				isDot = false; // Allow the dot operator to be used again
			}
		});

		// Decimal point button
		dot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// If screen is empty then make sure to add 0 before the decimal point
				if (calculatorDisplay.getText().isEmpty())
				{
					addDisplay(Integer.toString(0));
				}
				
				// The dot operator hasn't been used yet, then use it but update boolean so that only one dot
				// per input can be used
				if(!isDot)
				{
					// Add the decimal point
					addDisplay(".");
					isDot = true;
				}
			}
		});

		// 0 button
		zero.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Clear the screen and reset the booleans if either PI, E, Result are activated
				// or if display screen is showing any errors
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				// If display is currently centered then set right to left and update boolean
				if (isCenter)
				{
					calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
					isCenter = false;
				}

				// Add 0 to the calculator display
				addDisplay(Integer.toString(0));
			}
		});

		// PUSH button
		push.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Error handling - can't push an empty screen or a screen showing an error
				if (calculatorDisplay.getText().isEmpty() || calculatorDisplay.getText().contains("ERROR"))
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay("ERROR! Not enough arguments! Resetting!");
				}
				// Push the appropriate double from the screen onto the stack, update the stack
				// display
				// and reset the calculator display screen
				else
				{
					theStack.push(Double.parseDouble(calculatorDisplay.getText()));
					stackDisplay.setText(theStack.print());
					clearDisplay();
					isDot = false; // argument has been pushed so we can use the dot operator again
				}
			}
		});

		// Division button
		divide.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// May return a stack calculator exception
				try
				{
					// Obtain the appropriate result from the operation method
					// display it, push it back to the stack, update the stack
					// and adjust the isResult boolean
					double result = theStack.operation(4);
					isResult = true;
					theStack.push(result);

					// If display is currently centered then set right to left and update boolean
					if (isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
						isCenter = false;
					}

					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					// If display is currently not centered then center it and update boolean
					if (!isCenter)
					{
						calculatorDisplay.setHorizontalAlignment(SwingConstants.CENTER);
						isCenter = true;
					}

					// Display the error
					setDisplay(problem.getError());
					isDot = false; // Allow the dot operator to be used again
					// Update the stack display in case of division by zero
					// error to show zero out of the stack
					stackDisplay.setText(theStack.print());
				}
			}
		});

		// Window Settings
		setSize(700, 600);
		setLocationRelativeTo(null); // Sets the location to the center of the computer screen
		setTitle("Stack Calculator");
		add(buttonPanel, BorderLayout.CENTER);
		add(stackDisplayPanel, BorderLayout.LINE_START);
		add(calculatorDisplayPanel, BorderLayout.PAGE_START);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
