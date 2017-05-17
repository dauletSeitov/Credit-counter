package www.lounger;

import java.awt.BorderLayout;
import java.awt.Point;
//import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import net.miginfocom.swing.MigLayout;

public class  LittleFrameCreator{
	//nastroika
	public static void nastroikiSozdat(final JInternalFrame frame, final DBHelper dbConnection){
			
		
		final JDialog dialog = new JDialog();
		
		dialog.setTitle(frame.getTitle());
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLocation(frame.getLocationOnScreen());


		JPanel panel = new JPanel();
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][]", "[][][][][][][][][]"));
		
		JLabel label = new JLabel("\u041A\u043B\u044E\u0447\u044C");
		panel.add(label, "cell 0 0, flowx, alignx trailing");
		
		final JTextField textField = new JTextField();
		panel.add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0430");
		panel.add(label_1, "cell 0 1,flowx, alignx trailing");
		
		final JTextField textField_1 = new JTextField();
		panel.add(textField_1, "cell 2 1,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Сохранить");
		panel.add(btnNewButton_2, "flowx,cell 2 8,alignx right");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String key = textField.getText().trim();
				String value = textField_1.getText().trim();		
				
				if (key.isEmpty() || value.isEmpty()) {
					Toast.showMessage("Настройка", "Одно из значении пусто");
					return;
				}
				
				
				try {
					dbConnection.insertNastroika(key, value);
					Toast.showMessage("Настройка", "Добавлен " + key + " " + value);
					dialog.dispose();
				} catch (SQLException e) {
					Toast.showMessage("Настройка", "Ключь не уникален " + key + " " + value);
				}
			
			}
		});
		
		JButton btnNewButton_3 = new JButton("Отмена");
		panel.add(btnNewButton_3, "cell 2 8,alignx right");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
			}
		});
		
		
		dialog.getContentPane().add(panel);
			
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		dialog.pack();

		dialog.setVisible(true);
		System.out.println("end");
		

	} 
	
	public static void nastroikiUpdate(final JInternalFrame frame, final DBHelper dbConnection, final int id, String key, String value){
			
		
		final JDialog dialog = new JDialog();
		
		dialog.setTitle(frame.getTitle());
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLocation(frame.getLocationOnScreen());


		JPanel panel = new JPanel();
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][]", "[][][][][][][][][]"));
		
		JLabel label = new JLabel("\u041A\u043B\u044E\u0447\u044C");
		panel.add(label, "cell 0 0, flowx, alignx trailing");
		
		final JTextField textField = new JTextField(key);
		panel.add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0430");
		panel.add(label_1, "cell 0 1,flowx, alignx trailing");
		
		final JTextField textField_1 = new JTextField(value);
		panel.add(textField_1, "cell 2 1,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Сохранить");
		panel.add(btnNewButton_2, "flowx,cell 2 8,alignx right");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String key = textField.getText().trim();
				String value = textField_1.getText().trim();		
				
				if (key.isEmpty() || value.isEmpty()) {
					Toast.showMessage("Настройка", "Одно из значении пусто");
					return;
				}
				
				
				try {
					dbConnection.updateNastroika(id, key, value);
					Toast.showMessage("Настройка", "Изменен "+ id + key + " " + value);
					dialog.dispose();
				} catch (SQLException e) {
					Toast.showMessage("Настройка", "Ключь не уникален " + id + key + " " + value);
				}
			
			}
		});
		
		JButton btnNewButton_3 = new JButton("Отмена");
		panel.add(btnNewButton_3, "cell 2 8,alignx right");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog.dispose();
			}
		});
		
		
		dialog.getContentPane().add(panel);
			
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		dialog.pack();

		dialog.setVisible(true);
		System.out.println("end");
		

	} 
	//nastroika
	
	//Kontragent
	public static void kontragentSozdat(final JInternalFrame frame, final DBHelper dbConnection){
		
		final JDialog dialog = new JDialog();
		
		dialog.setTitle(frame.getTitle());
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLocation(frame.getLocationOnScreen());


		JPanel panel = new JPanel();
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][]", "[][][][][][][][][]"));
		
		JLabel label = new JLabel("\u0424\u0418\u041E");
		panel.add(label, "cell 0 0, flowx, alignx trailing");
		
		final JTextField textField = new JTextField();
		panel.add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u0418\u0418\u041D");
		panel.add(label_1, "cell 0 1,flowx, alignx trailing");
		
		final JTextField textField_1 = new JTextField();
		panel.add(textField_1, "cell 2 1,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Сохранить");
		panel.add(btnNewButton_2, "flowx,cell 2 8,alignx right");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fio = textField.getText().trim();
				String iin = textField_1.getText().trim();		
				
				if (fio.isEmpty() || iin.isEmpty()) {
					Toast.showMessage(frame.getTitle(), "Одно из значении пусто");
					return;
				}
				
				
				try {
					dbConnection.insertKontragent(fio, iin);
					Toast.showMessage(frame.getTitle(), "Добавлен " + fio + " " + iin);
					dialog.dispose();
				} catch (SQLException e) {
					Toast.showMessage(frame.getTitle(), "Ключь не уникален " + fio + " " + iin);
				}
			
			}
		});
		
		JButton btnNewButton_3 = new JButton("Отмена");
		panel.add(btnNewButton_3, "cell 2 8,alignx right");
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

	public static void kontragentUpdate(final JInternalFrame frame, final DBHelper dbConnection, final int id, String fio, String iin){
		
		final JDialog dialog = new JDialog();
		
		dialog.setTitle(frame.getTitle());
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLocation(frame.getLocationOnScreen());


		JPanel panel = new JPanel();
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][]", "[][][][][][][][][]"));
		
		JLabel label = new JLabel("\u0424\u0418\u041E");
		panel.add(label, "cell 0 0, flowx, alignx trailing");
		
		final JTextField textField = new JTextField(fio);
		panel.add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u0418\u0418\u041D");
		panel.add(label_1, "cell 0 1,flowx, alignx trailing");
		
		final JTextField textField_1 = new JTextField(iin);
		panel.add(textField_1, "cell 2 1,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Сохранить");
		panel.add(btnNewButton_2, "flowx,cell 2 8,alignx right");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fio = textField.getText().trim();
				String iin = textField_1.getText().trim();		
				
				if (fio.isEmpty() || iin.isEmpty()) {
					Toast.showMessage(frame.getTitle(), "Одно из значении пусто");
					return;
				}
				
				
				try {
					dbConnection.updateKontragent(id, fio, iin);
					Toast.showMessage(frame.getTitle(), "Изменен " + fio + " " + iin);
					dialog.dispose();
				} catch (SQLException e) {
					Toast.showMessage(frame.getTitle(), "Ключь не уникален " + fio + " " + iin);
				}
			
			}
		});
		
		JButton btnNewButton_3 = new JButton("Отмена");
		panel.add(btnNewButton_3, "cell 2 8,alignx right");
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
	//Kontragent

	//Kredit
	public static void KreditSozdat(final JInternalFrame frame, final DBHelper dbConnection){
		
		final JDialog dialog = new JDialog();
		
		dialog.setTitle(frame.getTitle());
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLocation(frame.getLocationOnScreen());


		JPanel panel = new JPanel();
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][]", "[][][][][][][][][][]"));
		
		JLabel label = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		panel.add(label, "cell 0 0, flowx, alignx trailing");
		
		final JTextField textField = new JTextField();
		panel.add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u0412\u0440\u0435\u043C\u044F/\u043C\u0435\u0441\u044F\u0446");
		panel.add(label_1, "cell 0 1,flowx, alignx trailing");
		
		
		//----month
		MaskFormatter mrInt = null;
		try {
			mrInt = new MaskFormatter("####");
		} catch (ParseException e1) {
			System.out.println("Cant create Mask");
		}

		final JFormattedTextField fieldInt = new JFormattedTextField(mrInt);
		fieldInt.setColumns(10);
		fieldInt.setValue("0000");
		panel.add(fieldInt, "cell 2 1,growx");
		
		//----month
		
		
		JLabel lblNewLabel = new JLabel("Процент");
		panel.add(lblNewLabel, "cell 0 2, flowx, alignx trailing");
		

		//----procent
		MaskFormatter mr = null;
		try {
			mr = new MaskFormatter("##.##");
		} catch (ParseException e1) {
			System.out.println("Cant create Mask");
		}
		
		final JFormattedTextField field = new JFormattedTextField(mr);
		field.setColumns(10);
		field.setValue("00.00");
		panel.add(field, "cell 2 2,growx");
		//----procent
		
		JButton btnNewButton_2 = new JButton("Сохранить");
		panel.add(btnNewButton_2, "flowx,cell 2 9,alignx right");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText().trim();
				String time = fieldInt.getText().trim();
				String procent = field.getText().trim();
				
				System.out.println("+++++ " + time);
				
				if (name.isEmpty()){
					Toast.showMessage(frame.getTitle(), "Название не может быть пустым");
					return;
				}
				
				if(time.isEmpty()){ 
					Toast.showMessage(frame.getTitle(), "Время не может быть пустым");
					return;
				}
				
				if(procent.isEmpty()){
					Toast.showMessage(frame.getTitle(), "Процент не может быть пустым");
					return;
				}
					
				
				try {
					dbConnection.insertKredit(name, Integer.valueOf(time), Float.valueOf(procent));
					Toast.showMessage(frame.getTitle(), "Добавлен " + name + " " + time + " " + procent);
					dialog.dispose();
				} catch (SQLException e) {
					Toast.showMessage(frame.getTitle(), "Ключь не уникален " + name + " " + time + " " + procent);
				}
			
			}
		});
		
		JButton btnNewButton_3 = new JButton("Отмена");
		panel.add(btnNewButton_3, "cell 2 9,alignx right");
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

	public static void KreditUpdate(final JInternalFrame frame, final DBHelper dbConnection, final int id, String name, float procent, int time){
		
		final JDialog dialog = new JDialog();
		
		dialog.setTitle(frame.getTitle());
		dialog.setModalityType(JDialog.DEFAULT_MODALITY_TYPE);
		dialog.setLocation(frame.getLocationOnScreen());


		JPanel panel = new JPanel();
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow][]", "[][][][][][][][][][]"));
		
		JLabel label = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435");
		panel.add(label, "cell 0 0, flowx, alignx trailing");
		
		final JTextField textField = new JTextField(name);
		panel.add(textField, "cell 2 0,growx");
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u0412\u0440\u0435\u043C\u044F/\u043C\u0435\u0441\u044F\u0446");
		panel.add(label_1, "cell 0 1,flowx, alignx trailing");
		
		
		//----month
		MaskFormatter mrInt = null;
		try {
			mrInt = new MaskFormatter("####");
		} catch (ParseException e1) {
			System.out.println("Cant create Mask");
		}

		final JFormattedTextField fieldInt = new JFormattedTextField(mrInt);
		fieldInt.setColumns(10);
		fieldInt.setValue(time);
		panel.add(fieldInt, "cell 2 1,growx");
		
		//----month
		
		
		JLabel lblNewLabel = new JLabel("Процент");
		panel.add(lblNewLabel, "cell 0 2, flowx, alignx trailing");
		

		//----procent
		MaskFormatter mr = null;
		try {
			mr = new MaskFormatter("##.##");
		} catch (ParseException e1) {
			System.out.println("Cant create Mask");
		}
		
		final JFormattedTextField field = new JFormattedTextField(mr);
		field.setColumns(10);
		field.setValue(procent);
		panel.add(field, "cell 2 2,growx");
		//----procent
		
		JButton btnNewButton_2 = new JButton("Сохранить");
		panel.add(btnNewButton_2, "flowx,cell 2 9,alignx right");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField.getText().trim();
				String time = fieldInt.getText().trim();
				String procent = field.getText().trim();
				
				System.out.println("+++++ " + time);
				
				if (name.isEmpty()){
					Toast.showMessage(frame.getTitle(), "Название не может быть пустым");
					return;
				}
				
				if(time.isEmpty()){ 
					Toast.showMessage(frame.getTitle(), "Время не может быть пустым");
					return;
				}
				
				if(procent.isEmpty()){
					Toast.showMessage(frame.getTitle(), "Процент не может быть пустым");
					return;
				}
					
				
				try {
					dbConnection.updateKredit(id, name, Integer.valueOf(time), Float.valueOf(procent));
					Toast.showMessage(frame.getTitle(), "Добавлен " + name + " " + time + " " + procent);
					dialog.dispose();
				} catch (SQLException e) {
					Toast.showMessage(frame.getTitle(), "Ключь не уникален " + name + " " + time + " " + procent);
					//e.printStackTrace();
				}
			
			}
		});
		
		JButton btnNewButton_3 = new JButton("Отмена");
		panel.add(btnNewButton_3, "cell 2 9,alignx right");
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
	//Kredit
	
	
	
	
	
}


