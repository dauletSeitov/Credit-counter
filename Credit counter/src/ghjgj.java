import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import www.lounger.Toast;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class ghjgj {

	private JFrame frame;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ghjgj window = new ghjgj();
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
	public ghjgj() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		final JDialog dialog = new JDialog();
		
		dialog.setTitle(frame.getTitle());
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLocation(frame.getLocationOnScreen());


		JPanel panel = new JPanel();
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][]", "[][][][][][][][][][][]"));
		
		JLabel label = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		panel.add(label, "cell 0 0, flowx, alignx trailing");
		
		final JTextField textField = new JTextField();
		panel.add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u0412\u0440\u0435\u043C\u044F/\u043C\u0435\u0441\u044F\u0446");
		panel.add(label_1, "cell 0 1,flowx, alignx trailing");
		
		final JTextField textField_1 = new JTextField();
		panel.add(textField_1, "cell 2 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u041F\u0440\u043E\u0446\u0435\u043D\u0442");
		panel.add(lblNewLabel, "cell 0 2, flowx, alignx trailing");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 2 2,growx");
		textField_2.setColumns(10);
		
		//
		MaskFormatter mr = null;
		try {
			mr = new MaskFormatter("##.##");
		} catch (ParseException e1) {
			//Default
			e1.printStackTrace();
		}
		
		JFormattedTextField field = new JFormattedTextField(mr);
				
		
		//field.setBounds(219, 65, 145, 20);
		field.setValue("00.00");
		frame.getContentPane().add(field);
		//
		panel.add(field, "cell 2 3,growx");
		
		JButton btnNewButton_2 = new JButton("Сохранить");
		panel.add(btnNewButton_2, "flowx,cell 2 10,alignx right");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fio = textField.getText().trim();
				String iin = textField_1.getText().trim();		
				
				if (fio.isEmpty() || iin.isEmpty()) {
					Toast.showMessage(frame.getTitle(), "Одно из значении пусто");
					return;
				}
				
				
			//	try {
			//		dbConnection.insertKontragent(fio, iin);
					Toast.showMessage(frame.getTitle(), "Добавлен " + fio + " " + iin);
					dialog.dispose();
			//	} catch (SQLException e) {
					Toast.showMessage(frame.getTitle(), "Ключь не уникален " + fio + " " + iin);
			//	}
			
			}
		});
		
		JButton btnNewButton_3 = new JButton("Отмена");
		panel.add(btnNewButton_3, "cell 2 10,alignx right");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
			}
		});
		
		
		dialog.getContentPane().add(panel);
			
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		dialog.pack();

		dialog.setVisible(true);	
	}

}
