package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Calculator extends JFrame
{
	//Fields
	String display = new String();
	
	// Constructor
	public Calculator(Stack theStack)
	{
		// The Buttons on the Panel
		JPanel buttonPanel = new JPanel(new GridLayout(6,5));
		
		// The Buttons on the Panel
		JButton lnx = new JButton("ln(x)");
		buttonPanel.add(lnx);

		JButton logx = new JButton("log(x)");
		buttonPanel.add(logx);

		JButton ce = new JButton("CE");
		buttonPanel.add(ce);

		JButton pop = new JButton("POP");
		buttonPanel.add(pop);

		JButton backspace = new JButton("\u2190");
		buttonPanel.add(backspace);

		JButton squared = new JButton("x\u00B2");
		buttonPanel.add(squared);

		JButton powerOf = new JButton("x\u02B8");
		buttonPanel.add(powerOf);

		JButton sine = new JButton("sin(x)");
		buttonPanel.add(sine);

		JButton cosine = new JButton("cos(x)");
		buttonPanel.add(cosine);

		JButton tangent = new JButton("tan(x)");
		buttonPanel.add(tangent);

		JButton squareRoot = new JButton("\u221A");
		buttonPanel.add(squareRoot);

		JButton one = new JButton("1");
		buttonPanel.add(one);

		JButton two = new JButton("2");
		buttonPanel.add(two);

		JButton three = new JButton("3");
		buttonPanel.add(three);

		JButton plus = new JButton("+");
		buttonPanel.add(plus);

		JButton ex = new JButton("e\u02E3");
		buttonPanel.add(ex);

		JButton four = new JButton("4");
		buttonPanel.add(four);

		JButton five = new JButton("5");
		buttonPanel.add(five);

		JButton six = new JButton("6");
		buttonPanel.add(six);

		JButton minus = new JButton("-");
		buttonPanel.add(minus);

		JButton e = new JButton("e");
		buttonPanel.add(e);

		JButton seven = new JButton("7");
		buttonPanel.add(seven);

		JButton eight = new JButton("8");
		buttonPanel.add(eight);

		JButton nine = new JButton("9");
		buttonPanel.add(nine);

		JButton times = new JButton("x");
		buttonPanel.add(times);

		JButton pi = new JButton("\u03A0");
		buttonPanel.add(pi);

		JButton decimal = new JButton(".");
		buttonPanel.add(decimal);

		JButton zero = new JButton("zero");
		buttonPanel.add(zero);

		JButton push = new JButton("PUSH");
		buttonPanel.add(push);

		JButton divide = new JButton("\u00F7");
		buttonPanel.add(divide);

		// The Stack display on ScrollPane on Panel
		JTextArea stackDisplay = new JTextArea();
		stackDisplay.setText(theStack.print());
		stackDisplay.setPreferredSize(new Dimension(100, 500));
		stackDisplay.setEditable(false);
		JScrollPane theScrollPane = new JScrollPane(stackDisplay);
		
		// The calculator display
		JPanel calculatorDisplay = new JPanel();
		JTextField textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.WHITE);
		textField.setOpaque(true);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Comic Sans MS", 1, 20));
		textField.setPreferredSize(new Dimension(500, 50));
		calculatorDisplay.add(textField);
		
		// Window Settings
		setSize(600, 600);
		setLocation(500, 500);
		setTitle("Stack Calculator");
		add(buttonPanel, BorderLayout.CENTER);
		add(theScrollPane, BorderLayout.LINE_START);
		add(calculatorDisplay, BorderLayout.PAGE_START);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
