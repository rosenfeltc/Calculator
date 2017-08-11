package calculator;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JFrame
{
	// Constructor
	public Calculator(Stack theStack)
	{
		// The necessary Panels
		JPanel centerPanel = new JPanel();
		JPanel stackPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(6, 5));
		
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
		
	}
}
