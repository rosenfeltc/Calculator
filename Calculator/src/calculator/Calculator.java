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
	private boolean isPI, isE, isResult; // booleans that will help the proper resetting of the calculator's display screen
	private JPanel buttonPanel, calculatorDisplayPanel, stackDisplayPanel; // The necessary panels that will be used on the JFrame to make the GUI Calculator
	private JButton lnx, logx, ce, pop, backspace, squared, powerOf, sine, cosine, tangent, squareRoot, one, two, three,
			plus, ex, four, five, six, minus, e, seven, eight, nine, times, pi, decimal, zero, push, divide; // All the calculator buttons
	private JTextArea stackDisplay; // The display for the stack
	private JTextField calculatorDisplay; // Used with the display String as the calculator's display screen
	private JScrollPane theScrollPane; // Used with the stackDisplay to make the stack display a scroll pane

	private void clearDisplay()
	{
		display = "";
		calculatorDisplay.setText(display);

	}

	private void addDisplay(String arg)
	{
		display += arg;
		calculatorDisplay.setText(display);
	}

	private void setDisplay(String arg)
	{
		display = arg;
		calculatorDisplay.setText(display);
	}

	private void backspaceDisplay()
	{
		if(calculatorDisplay.getText().isEmpty())
		{
			// Do nothing
		}
		else
		{
			display = display.substring(0, display.length() - 1);
			calculatorDisplay.setText(display);
		}
	}

	// Constructor
	public Calculator(Stack theStack)
	{
		// Set the booleans initially to false
		isPI = false;
		isE = false;
		isResult = false;
		
		// The Buttons on the Panel
		buttonPanel = new JPanel(new GridLayout(6, 5));

		// The Buttons on the Panel
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

		backspace = new JButton("\u2190");
		backspace.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(backspace);

		squared = new JButton("x\u00B2");
		squared.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(squared);

		powerOf = new JButton("x\u02B8");
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

		squareRoot = new JButton("\u221A");
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

		ex = new JButton("e\u02E3");
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

		pi = new JButton("\u03A0");
		pi.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(pi);

		decimal = new JButton(".");
		decimal.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(decimal);

		zero = new JButton("0");
		zero.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(zero);

		push = new JButton("PUSH");
		push.setFont(new Font("Arial", 1, 22));
		buttonPanel.add(push);

		divide = new JButton("\u00F7");
		divide.setFont(new Font("Arial", 0, 30));
		buttonPanel.add(divide);

		// The Stack display on ScrollPane on Panel
		stackDisplayPanel = new JPanel();
		stackDisplay = new JTextArea();
		stackDisplay.setText(theStack.print());
		stackDisplay.setFont(new Font("Arial", 1, 18));
		stackDisplay.setAlignmentX(SwingConstants.LEFT);
		stackDisplay.setEditable(false);
		DefaultCaret caret = (DefaultCaret) stackDisplay.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		theScrollPane = new JScrollPane(stackDisplay);
		theScrollPane.setPreferredSize(new Dimension(158, 490));
		theScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		theScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		stackDisplayPanel.add(theScrollPane);

		// The calculator display
		display = new String();
		calculatorDisplayPanel = new JPanel();
		calculatorDisplay = new JTextField(display);
		calculatorDisplay.setEditable(false);
		calculatorDisplay.setBackground(Color.WHITE);
		calculatorDisplay.setOpaque(true);
		calculatorDisplay.setForeground(Color.BLACK);
		calculatorDisplay.setFont(new Font("Arial", 1, 28));
		calculatorDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		calculatorDisplay.setPreferredSize(new Dimension(600, 50));
		calculatorDisplayPanel.add(calculatorDisplay);

		// The Button Listeners:
		//--------------------------
		
		// Natural log of X button
		lnx.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(8);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});

		// Log base 10 of X button
		logx.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(9);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});

		// Clear Entry button
		ce.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				clearDisplay();
				isPI = false;
				isE = false;
				isResult = false;
			}
		});

		// POP button
		pop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.pop();
					isResult = true;
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});

		// Backspace button
		backspace.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				backspaceDisplay();
			}
		});

		// Square of X button
		squared.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(13);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});

		// X to the power of Y button
		powerOf.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(12);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});

		// Sine of X button
		sine.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(5);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});

		// Cosine of X button
		cosine.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(6);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});

		// Tangent of X button
		tangent.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(7);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});

		// Square Root of X button
		squareRoot.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(10);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});

		// 1 button
		one.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult || calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(1));
			}
		});

		// 2 button
		two.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(2));
			}
		});

		// 3 button
		three.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(3));
			}
		});

		// Add button
		plus.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(1);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});
		
		// e to the power of X button
		ex.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(11);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});
		
		// 4 button
		four.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(4));
			}
		});

		// 5 button
		five.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(5));
			}
		});

		// 6 button
		six.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(6));
			}
		});

		// Subtract button
		minus.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(2);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});
		
		// e button
		e.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || !calculatorDisplay.getText().isEmpty() || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isResult = false;
				}
				
				isE = true;
				addDisplay(Double.toString(Math.E));
			}
		});
		
		// 7 button
		seven.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(7));
			}
		});

		// 8 button
		eight.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(8));
			}
		});

		// 9 button
		nine.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(9));
			}
		});
		
		// Multiplication button
		times.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(3);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
				}
			}
		});		

		// PI button
		pi.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isE || !calculatorDisplay.getText().isEmpty() || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isE = false;
					isResult = false;
				}
					
				isPI = true;
				addDisplay(Double.toString(Math.PI));
			}
		});
		
		// Decimal point button
		decimal.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult)
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}
				
				if(calculatorDisplay.getText().isEmpty())
				{
					addDisplay(Integer.toString(0));
				}

				addDisplay(".");
			}
		});
		
		// 0 button
		zero.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (isPI || isE || isResult ||  calculatorDisplay.getText().contains("ERROR"))
				{
					clearDisplay();
					isPI = false;
					isE = false;
					isResult = false;
				}

				addDisplay(Integer.toString(0));
			}
		});
		
		// PUSH button
		push.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(calculatorDisplay.getText().isEmpty() || calculatorDisplay.getText().contains("ERROR"))
				{
					setDisplay("ERROR! Not enough arguments! Resetting!");
				}
				else
				{
					theStack.push(Double.parseDouble(calculatorDisplay.getText()));
					stackDisplay.setText(theStack.print());
					clearDisplay();
				}
			}
		});
		
		// Division button
		divide.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					double result = theStack.operation(4);
					isResult = true;
					theStack.push(result);
					setDisplay(Double.toString(result));
					stackDisplay.setText(theStack.print());
				}
				catch (StackCalculatorException problem)
				{
					setDisplay(problem.getError());
					stackDisplay.setText(theStack.print());
				}
			}
		});

		// Window Settings
		setSize(700, 600);
		setLocationRelativeTo(null);
		setTitle("Stack Calculator");
		add(buttonPanel, BorderLayout.CENTER);
		add(stackDisplayPanel, BorderLayout.LINE_START);
		add(calculatorDisplayPanel, BorderLayout.PAGE_START);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
