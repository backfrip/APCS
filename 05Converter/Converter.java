import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Converter extends JFrame implements ActionListener {
    private Container pane;
    private JButton ftoc, ctof;
    private JLabel f, c;
    private JTextField far, cel;
    private Container faren, celsi, buttons;

    public Converter() {
	this.setTitle("Temperature Converter");
	this.setSize(350, 150);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(3, 1));

	far = new JTextField(20);
	cel = new JTextField(20);
	f = new JLabel("\u00b0F");
	c = new JLabel("\u00b0C");
	ftoc = new JButton("\u00b0F to \u00b0C");
	ctof = new JButton("\u00b0C to \u00b0F");

	ftoc.setActionCommand("ftoc");
	ftoc.addActionListener(this);
	ctof.setActionCommand("ctof");
	ctof.addActionListener(this);

	faren = new Container();
	faren.setLayout(new FlowLayout());
	faren.add(far);
	faren.add(f);

	celsi = new Container();
	celsi.setLayout(new FlowLayout());
	celsi.add(cel);
	celsi.add(c);

	buttons = new Container();
	buttons.setLayout(new FlowLayout());
	buttons.add(ftoc);
	buttons.add(ctof);

	pane.add(faren);
	pane.add(celsi);
	pane.add(buttons);
    }

    public void actionPerformed(ActionEvent e) {
	String s = e.getActionCommand();
	if (s.equals("ftoc")) {
	    try {
		double t = Double.parseDouble(far.getText());
		far.setText(Double.toString(t));
		t = (t - 32) * (5.0 / 9);
		cel.setText(Double.toString(t));
	    } catch (NumberFormatException n) {
		far.setText("");
		cel.setText("");
	    };
	}
	if (s.equals("ctof")) {
	    try {
		double t = Double.parseDouble(cel.getText());
		cel.setText(Double.toString(t));
		t = t * (9.0 / 5) + 32;
		far.setText(Double.toString(t));
	    } catch (NumberFormatException n) {
		cel.setText("");
		far.setText("");
	    }
	}
    }

    public static void main(String[] args) {
	Converter c = new Converter();
	c.setVisible(true);
    }
}