package User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import extractIdproj.ScrapReg;
import extractIdproj.ScraperJava;

import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Page6 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Page6 frame = new Page6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public class CustomOutputStream extends OutputStream {
	    private JTextArea textArea;
	     
	    public CustomOutputStream(JTextArea textArea) {
	        this.textArea = textArea;
	    }
	     
	    @Override
	    public void write(int b) throws IOException {
	        // redirects data to the text area
	        textArea.append(String.valueOf((char)b));
	        // scrolls the text area to the end of data
	        textArea.setCaretPosition(textArea.getDocument().getLength());
	    }
	}
	public Page6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Scraping regression");
		setBounds(100, 100, 780, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 345, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 746, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);
		
		JOptionPane.showMessageDialog(null, "Loading Scrapper", "Waiting", 1);

		ScrapReg.startscrapingreg();
			
		JButton btnNewButton = new JButton("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 1, SpringLayout.SOUTH, scrollPane);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Page4().setVisible(true);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -690, SpringLayout.EAST, contentPane);
		btnNewButton.setIcon(new ImageIcon("..\\extractIdproj\\img\\backward.png"));
		contentPane.add(btnNewButton);

	

	}
	
}
