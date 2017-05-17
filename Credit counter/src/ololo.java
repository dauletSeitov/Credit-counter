import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;

public class ololo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ololo window = new ololo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ololo() {
		try {
			initialize();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ParseException 
	 */
	private void initialize() throws ParseException {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0438 \u0421\u043E\u0437\u0434\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("begin");
			//	LittleFrameCreator.nastroiki(frame);
				System.out.println("end");			
			}
		});
		btnNewButton.setBounds(10, 11, 145, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
			}
			
			
			
			
		});
		btnNewButton_1.setBounds(10, 45, 145, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(10, 79, 145, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(10, 113, 145, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(10, 147, 145, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		
		
		

		
		JFormattedTextField field = new JFormattedTextField(new MaskFormatter("##.##"));
		field.setBounds(219, 65, 145, 20);
		field.setValue("00.00");
		frame.getContentPane().add(field);
		
		
		MaskFormatter mk = new MaskFormatter("##/##/####");
		JFormattedTextField formattedTextField = new JFormattedTextField(mk);
		formattedTextField.setBounds(219, 94, 145, 20);
		formattedTextField.setValue(new SimpleDateFormat("DD/MM/YYYY").format(new Date()));
		frame.getContentPane().add(formattedTextField);
		
		
		
		
	    
	}
}


