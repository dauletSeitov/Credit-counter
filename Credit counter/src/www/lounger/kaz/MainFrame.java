package www.lounger.kaz;
/* 	default report path
 *  default log file path
 * 
 * 
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.Window.Type;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import www.Convertor;
import www.lounger.DBHelper;
import www.lounger.Toast;

import javax.swing.JEditorPane;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import java.awt.Font;
import www.lounger.LittleFrameCreator;
import net.miginfocom.swing.MigLayout;

public class MainFrame {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JInternalFrame kontragent;
	private JInternalFrame nastroika;
	private JInternalFrame krediti;
	private JInternalFrame registr;
	private DBHelper	dbConnection;
	private JTextField txtOc;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		action();
		initialize();
		
	}



	private void action() {
	
		try {
				dbConnection = new DBHelper();
		} catch (Exception e) {
			Toast.showMessage("Error", "Не удалось установить связь с бд");
		}
			
	}

	private void initialize() {
			
		frame = new JFrame();
		frame.setTitle("\u0420\u0430\u0434\u0438\u043E\u0430\u043A\u0442\u0438\u0432\u043D\u044B\u0439 \u043A\u043E\u0442");
		frame.setBackground(Color.WHITE);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    final JDesktopPane desktop = new JDesktopPane();
	    desktop.setBackground(new Color(211, 211, 211));
	    frame.getContentPane().add(desktop, BorderLayout.CENTER);
	    
	    frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				dbConnection.close();
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	    desktop.setLayout(null);
	    //-------------------------------------------------------
	    lblNewLabel = new JLabel("\u041A\u043E\u043D\u0442\u0440\u0430\u0433\u0435\u043D\u0442");
	    lblNewLabel.setBounds(10, 66, 86, 20);
	    lblNewLabel.setForeground(Color.blue);
	    lblNewLabel.addMouseListener(new KontragentListener(lblNewLabel, kontragent, dbConnection, desktop));
	    desktop.add(lblNewLabel/*, "cell 0 2,alignx left,aligny top"*/);
	    
	    JLabel label = new JLabel("\u041A\u0440\u0435\u0434\u0438\u0442\u044B");
	    label.setBounds(10, 97, 118, 20);
	    label.setForeground(Color.BLUE);
	    label.addMouseListener(new KreditiListener(label, krediti, dbConnection, desktop));
	    desktop.add(label);
	    
	    JLabel label_1 = new JLabel("\u0420\u0435\u0433\u0438\u0441\u0442\u0440");
	    label_1.setBounds(10, 128, 101, 20);
	    label_1.setForeground(Color.BLUE);
	    label_1.addMouseListener(new RegistrListener(label_1, registr, dbConnection, desktop));
	    desktop.add(label_1);
	    
	    JLabel lblNewLabel_1 = new JLabel("\u041D\u0430\u0441\u0442\u0440\u043E\u0439\u043A\u0438");
	    lblNewLabel_1.setBounds(10, 35, 86, 20);
	    lblNewLabel_1.setForeground(Color.BLUE);
	    lblNewLabel_1.addMouseListener(new NastroikaListener(lblNewLabel_1, nastroika, dbConnection, desktop));
	    desktop.add(lblNewLabel_1);
	    
	    JLabel label_2 = new JLabel("\u0414\u043E\u043A\u0443\u043C\u0435\u043D\u0442\u044B");
	    label_2.setBounds(109, 10, 87, 20);
	    label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
	    desktop.add(label_2);
	    
	    JLabel label_3 = new JLabel("\u041D\u043E\u0432\u044B\u0439 \u043A\u0440\u0435\u0434\u0438\u0442");
	    label_3.setBounds(106, 35, 90, 20);
	    label_3.setForeground(Color.BLUE);
	    
	    label_3.addMouseListener(new DokumentSozdatListener(label_3, nastroika, dbConnection, desktop)); 
	    desktop.add(label_3);
	    
	    JLabel label_4 = new JLabel("\u041F\u043E\u0433\u0430\u0448\u0435\u043D\u0438\u0435 \u0434\u043E\u043B\u0433\u0430");
	    label_4.setBounds(106, 97, 104, 20);
	    label_4.setForeground(Color.BLUE);
	    label_4.addMouseListener(new DokumentPlatezhListener(label_4, nastroika, dbConnection, desktop));
	    
	    desktop.add(label_4);
	    
	    JLabel label_5 = new JLabel("\u041E\u0442\u0447\u0435\u0442\u044B");
	    label_5.setBounds(230, 10, 93, 20);
	    label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
	    desktop.add(label_5);
	    
	    JLabel label_6 = new JLabel("\u041F\u043E \u043A\u043B\u0438\u0435\u043D\u0442\u0430\u043C");
	    label_6.setBounds(230, 66, 104, 20);
	    desktop.add(label_6);
	    
	    JLabel label_7 = new JLabel("\u041F\u043E \u043F\u0440\u043E\u0441\u0440\u043E\u0447\u043A\u0430\u043C");
	    label_7.setBounds(230, 128, 93, 20);
	    desktop.add(label_7);
	    
	    JLabel label_8 = new JLabel("\u041E\u0421 \u0438 \u0411\u0430\u043B\u0430\u043D\u0441");
	    label_8.setBounds(230, 35, 86, 20);
	    desktop.add(label_8);
	    
	    JLabel label_9 = new JLabel("\u0427\u0435\u0440\u043D\u044B\u0439 \u0441\u043F\u0438\u0441\u043E\u043A");
	    label_9.setBounds(230, 97, 93, 20);
	    desktop.add(label_9);
	    
	    JButton btnNewButton = new JButton("New button");
	    btnNewButton.setBounds(168, 290, 132, 20);
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		Toast.showMessage("Документ","Проводка dfgdfg dgf dfg df g df gdfg df g dfg");
	    		
	    	}
	    });
	    desktop.add(btnNewButton);
	    
	    JTextArea txtrHrhtth = new JTextArea();
	    txtrHrhtth.setBounds(433, 12, 145, 350);
	    txtrHrhtth.setColumns(20);
	    txtrHrhtth.setBackground(Color.WHITE);
	    txtrHrhtth.setBorder(UIManager.getBorder("TextField.border"));
	    txtrHrhtth.setText("События");
	    desktop.add(txtrHrhtth);
	   	    
	    JLabel label_11 = new JLabel("\u0421\u043F\u0440\u0430\u0432\u043E\u0447\u043D\u0438\u043A\u0438");
	    label_11.setBounds(10, 10, 83, 20);
	    label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
	    desktop.add(label_11);
	    
	    JLabel label_10 = new JLabel("\u0417\u0430\u043A\u0440\u044B\u0442\u0438\u0435 \u043A\u0440\u0435\u0434\u0438\u0442\u0430");
	    label_10.setBounds(106, 66, 107, 20);
	    label_10.setForeground(Color.BLUE);
	    label_10.addMouseListener(new DokumentZakritListener(label_10, nastroika, dbConnection, desktop));
	    desktop.add(label_10);
	    
	    JButton btnNewButton_1 = new JButton("New button");
	    btnNewButton_1.setBounds(166, 321, 76, 20);
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		
	    	}
	    });
	    desktop.add(btnNewButton_1);
	    
	    txtOc = new JTextField();
	    txtOc.setText("oc");
	    txtOc.setBounds(344, 35, 86, 20);
	    desktop.add(txtOc);
	    txtOc.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("Time");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
	    lblNewLabel_2.setBounds(344, 13, 46, 14);
	    desktop.add(lblNewLabel_2);
	    
	   
	    
	    //-----------------------
	    
	    frame.setSize(604, 411);
	    frame.setVisible(true);
	    
	    
	   
	}
}


class KontragentListener implements MouseListener {
	
	private JLabel lblNewLabel;
	private JInternalFrame kontragent;
	private DBHelper dbConnection;
	private JDesktopPane desktop;
	private JTable jt;
	
	KontragentListener(JLabel lblNewLabel, JInternalFrame kontragent, DBHelper dbConnection,JDesktopPane desktop){
		this.lblNewLabel = lblNewLabel;
		this.kontragent = kontragent;
		this.dbConnection = dbConnection;
		this.desktop = desktop;
		
		//init(this.kontragent);
		
	}
	
	private void init() {
		
		JToolBar toolbar = new JToolBar();
	    toolbar.setRollover(true);
	    
		JButton button = new JButton("Создать");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				LittleFrameCreator.kontragentSozdat(kontragent, dbConnection);
				
				System.out.println("button Создать clicked!!!");
				
			}
		});
	    toolbar.add(button);
	    toolbar.addSeparator();
	    
	    JButton button_1 = new JButton("Обновить");
	    button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel)jt.getModel();
				 
				model.setDataVector(Convertor.toArray(dbConnection.getAllKontragents()), new String []{"ID","ФИО","ИИН"});
								
				System.out.println("button Обновить clicked!!!");
				
			}
		});
	    toolbar.add(button_1);
	    toolbar.addSeparator();
	    
	    JButton button_2 = new JButton("Удалить");
	    button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					dbConnection.deleteKontragent((int)jt.getValueAt(jt.getSelectedRow(), 0));
				} catch (Exception e) {
					return;
				}
				
				System.out.println("button Удалить clicked!!!");
				
			}
		});
	    toolbar.add(button_2);
	    toolbar.addSeparator();
	    
	    JButton button_3 = new JButton("Изменить");
	    button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					
					int id = 		(int)jt.getValueAt(jt.getSelectedRow(), 0);
					String fio =  	(String)jt.getValueAt(jt.getSelectedRow(), 1);
					String iin =  (String)jt.getValueAt(jt.getSelectedRow(), 2);
				
					LittleFrameCreator.kontragentUpdate(kontragent, dbConnection, id, fio, iin);
				} catch (Exception e) {
					return;
				}

				System.out.println("button Изменить clicked!!!");
				
			}
		});
	    toolbar.add(button_3);
	    toolbar.addSeparator();
	    
	    
	    kontragent.add(toolbar,BorderLayout.NORTH);
		
	}
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		
		
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.blue);
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.red);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if ((kontragent != null)){
				try {
					//kontragent.setBounds(frame.getBounds());
					kontragent.setMaximum(true);
					kontragent.setVisible(true);
					kontragent.toFront();
					kontragent.setEnabled(true);
				} catch (PropertyVetoException e1) {

					e1.printStackTrace();
				}
		 return;
		 }
			
		kontragent = new JInternalFrame("Конрагент", true, true, true, true);
		
		init();
		 		 

		DefaultTableModel dm = new DefaultTableModel();
		dm.setDataVector(Convertor.toArray(dbConnection.getAllKontragents()), new String []{"ID","ФИО","ИИН"});    
			
		jt = new JTable(dm); 
		 
  
		 jt.setBounds(kontragent.getBounds());          
		 JScrollPane sp = new JScrollPane(jt);   
		
		 kontragent.getContentPane().add(sp);

		
		kontragent.addInternalFrameListener(new InternalFrameAdapter(){
            public void internalFrameClosing(InternalFrameEvent e) {
               System.out.println("kontragent clicked X");
               kontragent = null;
            }
        });
	    desktop.add(kontragent, "cell 0 0,alignx left,aligny top");

	    kontragent.setVisible(true);
	    
	  //  kontragent.setBounds(frame.getBounds());
	    
	 //   try {
	//		kontragent.setMaximum(true);
	//	} catch (PropertyVetoException e1) {

	//		e1.printStackTrace();
	//	}
		
	}
}

class NastroikaListener implements MouseListener {
	
	private JLabel lblNewLabel;
	private JInternalFrame nastroika;
	private DBHelper dbConnection;
	private JDesktopPane desktop;
	private JTable jt;
	private JScrollPane sp;
	
	NastroikaListener(JLabel lblNewLabel, JInternalFrame nastroika, DBHelper dbConnection,JDesktopPane desktop){
		this.lblNewLabel = lblNewLabel;
		this.nastroika = nastroika;
		this.dbConnection = dbConnection;
		this.desktop = desktop;
	}
	
private void init() {
		
		JToolBar toolbar = new JToolBar();
	    toolbar.setRollover(true);
	    
		JButton button = new JButton("Создать");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Создать clicked!!!");
				
				LittleFrameCreator.nastroikiSozdat(nastroika, dbConnection);

			}
		});
	    toolbar.add(button);
	    toolbar.addSeparator();
	    
	    JButton button_1 = new JButton("Обновить");
	    button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 
				DefaultTableModel model = (DefaultTableModel)jt.getModel();
				 
				model.setDataVector(Convertor.toArray(dbConnection.getAllNastroika()), new String []{"ID","Ключь","Значение"});
				 
				System.out.println("button Обновить clicked!!!");
				
			}
		});
	    toolbar.add(button_1);
	    toolbar.addSeparator();
	    
	    JButton button_2 = new JButton("Удалить");
	    button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					dbConnection.deleteNastroika((int)jt.getValueAt(jt.getSelectedRow(), 0));
				} catch (Exception e) {
					return;
				}
				
				//System.out.println(jt.getSelectedRow());
				//System.out.println(jt.getValueAt(jt.getSelectedRow(), 0));
				System.out.println("button Удалить clicked!!!");
				
			}
		});
	    toolbar.add(button_2);
	    toolbar.addSeparator();
	    
	    JButton button_3 = new JButton("Изменить");
	    button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
									
					int id = 		(int)jt.getValueAt(jt.getSelectedRow(), 0);
					String key =  	(String)jt.getValueAt(jt.getSelectedRow(), 1);
					String value =  (String)jt.getValueAt(jt.getSelectedRow(), 2);
				
					LittleFrameCreator.nastroikiUpdate(nastroika, dbConnection, id, key, value);
				} catch (Exception e) {
					return;
				}
				System.out.println("button Изменить clicked!!!");
				
			}
		});
	    toolbar.add(button_3);
	    toolbar.addSeparator();
	    
	    
	    nastroika.add(toolbar,BorderLayout.NORTH);
		
	}


	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if ((nastroika != null)){
			try {
				//kontragent.setBounds(frame.getBounds());
				nastroika.setMaximum(true);
				nastroika.setVisible(true);
				nastroika.toFront();
				nastroika.setEnabled(true);
			} catch (PropertyVetoException e1) {

				e1.printStackTrace();
			}
	 return;
	 }
		
		nastroika = new JInternalFrame("Настройка", true, true, true, true);
		init();
 
		DefaultTableModel dm = new DefaultTableModel();
		dm.setDataVector(Convertor.toArray(dbConnection.getAllNastroika()), new String []{"ID","Ключь","Значение"});    
		
		jt = new JTable(dm); 
		jt.setBounds(nastroika.getBounds());          
		
		sp = new JScrollPane(jt);   
		
		nastroika.getContentPane().add(sp);

	
	 nastroika.addInternalFrameListener(new InternalFrameAdapter(){
        public void internalFrameClosing(InternalFrameEvent e) {
           System.out.println("kontragent clicked X");
           nastroika = null;
        }
    });
    desktop.add(nastroika);
    nastroika.setVisible(true);
    
  //  kontragent.setBounds(frame.getBounds());
    
    try {
    	nastroika.setMaximum(true);
	} catch (PropertyVetoException e1) {

		e1.printStackTrace();
	}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.red);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.blue);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

class KreditiListener implements MouseListener {
	
	private JLabel lblNewLabel;
	private JInternalFrame krediti;
	private DBHelper dbConnection;
	private JDesktopPane desktop;
	private JTable jt;
	
	KreditiListener(JLabel lblNewLabel, JInternalFrame krediti, DBHelper dbConnection,JDesktopPane desktop){
		this.lblNewLabel = lblNewLabel;
		this.krediti = krediti;
		this.dbConnection = dbConnection;
		this.desktop = desktop;
	}
	
	private void init() {
		
		JToolBar toolbar = new JToolBar();
	    toolbar.setRollover(true);
	    
		JButton button = new JButton("Создать");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				LittleFrameCreator.KreditSozdat(krediti, dbConnection);
				System.out.println("button Создать clicked!!!");
				
			}
		});
	    toolbar.add(button);
	    toolbar.addSeparator();
	    
	    JButton button_1 = new JButton("Обновить");
	    button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel)jt.getModel();
				 
				model.setDataVector(Convertor.toArray(dbConnection.getAllKrediti()), new String []{"ID","Название", "Время/месяц","Процент"});
				
				System.out.println("button Обновить clicked!!!");
				
			}
		});
	    toolbar.add(button_1);
	    toolbar.addSeparator();
	    
	    JButton button_2 = new JButton("Удалить");
	    button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					dbConnection.deleteKredit((int)jt.getValueAt(jt.getSelectedRow(), 0));
				} catch (Exception e) {
					//e.printStackTrace();
					return;
				}
				System.out.println("button Удалить clicked!!!");
				
			}
		});
	    toolbar.add(button_2);
	    toolbar.addSeparator();
	    
	    JButton button_3 = new JButton("Изменить");
	    button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					int id = 			(int)jt.getValueAt(jt.getSelectedRow(), 0);
					String name =  		(String)jt.getValueAt(jt.getSelectedRow(), 1);
					int time =			(int)jt.getValueAt(jt.getSelectedRow(), 2);
					float procent =	(float)jt.getValueAt(jt.getSelectedRow(), 3);
				
					LittleFrameCreator.KreditUpdate(krediti, dbConnection, id, name, procent, time);
				} catch (Exception e) {
					//e.printStackTrace();
					return;
				}
				
				System.out.println("button Изменить clicked!!!");
				
			}
		});
	    toolbar.add(button_3);
	    toolbar.addSeparator();
	    
	    
	    krediti.add(toolbar,BorderLayout.NORTH);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if ((krediti != null)){
			try {
				//kontragent.setBounds(frame.getBounds());
				krediti.setMaximum(true);
				krediti.setVisible(true);
				krediti.toFront();
				krediti.setEnabled(true);
			} catch (PropertyVetoException e1) {

				e1.printStackTrace();
			}
	 return;
	 }
		
		krediti = new JInternalFrame("Кредиты", true, true, true, true);
		init();

	 
		DefaultTableModel dm = new DefaultTableModel();
		dm.setDataVector(Convertor.toArray(dbConnection.getAllKrediti()), new String []{"ID","Название", "Время/месяц","Процент"});    
		
		jt = new JTable(dm); 
		
		jt.setBounds(krediti.getBounds());   
		
		
         
	 JScrollPane sp = new JScrollPane(jt);   
	
	 krediti.getContentPane().add(sp);

	
	 krediti.addInternalFrameListener(new InternalFrameAdapter(){
        public void internalFrameClosing(InternalFrameEvent e) {
           System.out.println("kontragent clicked X");
           krediti = null;
        }
    });
    desktop.add(krediti);
    krediti.setVisible(true);
    
  //  kontragent.setBounds(frame.getBounds());
    
    try {
    	krediti.setMaximum(true);
	} catch (PropertyVetoException e1) {

		e1.printStackTrace();
	}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.red);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.blue);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

class RegistrListener implements MouseListener {
	
	private JLabel lblNewLabel;
	private JInternalFrame registr;
	private DBHelper dbConnection;
	private JDesktopPane desktop;
	
	RegistrListener(JLabel lblNewLabel, JInternalFrame registr, DBHelper dbConnection,JDesktopPane desktop){
		this.lblNewLabel = lblNewLabel;
		this.registr = registr;
		this.dbConnection = dbConnection;
		this.desktop = desktop;
	}
	
private void init() {
		
		JToolBar toolbar = new JToolBar();
	    toolbar.setRollover(true);
	    
		JButton button = new JButton("Создать");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Создать clicked!!!");
				
			}
		});
	    toolbar.add(button);
	    toolbar.addSeparator();
	    
	    JButton button_1 = new JButton("Обновить");
	    button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Обновить clicked!!!");
				
			}
		});
	    toolbar.add(button_1);
	    toolbar.addSeparator();
	    
	    JButton button_2 = new JButton("Удалить");
	    button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Удалить clicked!!!");
				
			}
		});
	    toolbar.add(button_2);
	    toolbar.addSeparator();
	    
	    JButton button_3 = new JButton("Изменить");
	    button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Изменить clicked!!!");
				
			}
		});
	    toolbar.add(button_3);
	    toolbar.addSeparator();
	    
	    
	    registr.add(toolbar,BorderLayout.NORTH);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if ((registr != null)){
			try {
				//kontragent.setBounds(frame.getBounds());
				registr.setMaximum(true);
				registr.setVisible(true);
				registr.toFront();
				registr.setEnabled(true);
			} catch (PropertyVetoException e1) {

				e1.printStackTrace();
			}
	 return;
	 }
		
		registr = new JInternalFrame("Конрагент", true, true, true, true);
		init();

	 String column[]={"ID","Договор", "Документ","сумма", "Дата платежа", "Дата платежа по расписанию"}; 
	 		 
	 
	 
	 JTable jt = new JTable(Convertor.toArray(dbConnection.getAllRegistr()), column);    
	 jt.setBounds(registr.getBounds());          
	 JScrollPane sp = new JScrollPane(jt);   
	
	 registr.getContentPane().add(sp);

	
	 registr.addInternalFrameListener(new InternalFrameAdapter(){
        public void internalFrameClosing(InternalFrameEvent e) {
           System.out.println("kontragent clicked X");
           registr = null;
        }
    });
    desktop.add(registr);
    registr.setVisible(true);
    
  //  kontragent.setBounds(frame.getBounds());
    
    try {
    	registr.setMaximum(true);
	} catch (PropertyVetoException e1) {

		e1.printStackTrace();
	}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.red);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.blue);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}


class DokumentSozdatListener implements MouseListener {
	
	private JLabel lblNewLabel;
	private JInternalFrame internalFrame;
	private DBHelper dbConnection;
	private JDesktopPane desktop;
	
	DokumentSozdatListener(JLabel lblNewLabel, JInternalFrame internalFrame, DBHelper dbConnection,JDesktopPane desktop){
		this.lblNewLabel = lblNewLabel;
		this.internalFrame = internalFrame;
		this.dbConnection = dbConnection;
		this.desktop = desktop;
	}
	
	
private void init() {
		
		JToolBar toolbar = new JToolBar();
	    toolbar.setRollover(true);
	    
		JButton button = new JButton("Создать");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Создать clicked!!!");
				
			}
		});
	    toolbar.add(button);
	    toolbar.addSeparator();
	    
	    JButton button_1 = new JButton("Обновить");
	    button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Обновить clicked!!!");
				
			}
		});
	    toolbar.add(button_1);
	    toolbar.addSeparator();
	    
	    JButton button_2 = new JButton("Удалить");
	    button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Удалить clicked!!!");
				
			}
		});
	    toolbar.add(button_2);
	    toolbar.addSeparator();
	    
	    JButton button_3 = new JButton("Изменить");
	    button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Изменить clicked!!!");
				
			}
		});
	    toolbar.add(button_3);
	    toolbar.addSeparator();
	    
	    
	    internalFrame.add(toolbar,BorderLayout.NORTH);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if ((internalFrame != null)){
			try {
				//kontragent.setBounds(frame.getBounds());
				internalFrame.setMaximum(true);
				internalFrame.setVisible(true);
				internalFrame.toFront();
				internalFrame.setEnabled(true);
			} catch (PropertyVetoException e1) {

				e1.printStackTrace();
			}
	 return;
	 }
		
		internalFrame = new JInternalFrame("Конрагент", true, true, true, true);
		init();

	 String column[]={"ID","Вид кредита", "Договор","Документ", "Сумма", "Дата проводки", "Дата начала", "Дата окончания", "Состояние"}; 
	 		 
	 
	 
	 JTable jt = new JTable(Convertor.toArray(dbConnection.getAllDokumentSozdat()), column);    
	 jt.setBounds(internalFrame.getBounds());          
	 JScrollPane sp = new JScrollPane(jt);   
	
	 internalFrame.getContentPane().add(sp);

	
	 internalFrame.addInternalFrameListener(new InternalFrameAdapter(){
        public void internalFrameClosing(InternalFrameEvent e) {
           System.out.println("kontragent clicked X");
           internalFrame = null;
        }
    });
    desktop.add(internalFrame);
    internalFrame.setVisible(true);
    
  //  kontragent.setBounds(frame.getBounds());
    
    try {
    	internalFrame.setMaximum(true);
	} catch (PropertyVetoException e1) {

		e1.printStackTrace();
	}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.red);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.blue);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

class DokumentZakritListener implements MouseListener {
	
	private JLabel lblNewLabel;
	private JInternalFrame internalFrame;
	private DBHelper dbConnection;
	private JDesktopPane desktop;
	
	DokumentZakritListener(JLabel lblNewLabel, JInternalFrame internalFrame, DBHelper dbConnection,JDesktopPane desktop){
		this.lblNewLabel = lblNewLabel;
		this.internalFrame = internalFrame;
		this.dbConnection = dbConnection;
		this.desktop = desktop;
	}
	
	
private void init() {
		
		JToolBar toolbar = new JToolBar();
	    toolbar.setRollover(true);
	    
		JButton button = new JButton("Создать");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Создать clicked!!!");
				
			}
		});
	    toolbar.add(button);
	    toolbar.addSeparator();
	    
	    JButton button_1 = new JButton("Обновить");
	    button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Обновить clicked!!!");
				
			}
		});
	    toolbar.add(button_1);
	    toolbar.addSeparator();
	    
	    JButton button_2 = new JButton("Удалить");
	    button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Удалить clicked!!!");
				
			}
		});
	    toolbar.add(button_2);
	    toolbar.addSeparator();
	    
	    JButton button_3 = new JButton("Изменить");
	    button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Изменить clicked!!!");
				
			}
		});
	    toolbar.add(button_3);
	    toolbar.addSeparator();
	    
	    
	    internalFrame.add(toolbar,BorderLayout.NORTH);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if ((internalFrame != null)){
			try {
				//kontragent.setBounds(frame.getBounds());
				internalFrame.setMaximum(true);
				internalFrame.setVisible(true);
				internalFrame.toFront();
				internalFrame.setEnabled(true);
			} catch (PropertyVetoException e1) {

				e1.printStackTrace();
			}
	 return;
	 }
		
		internalFrame = new JInternalFrame("Конрагент", true, true, true, true);
		init();

	 String column[]={"ID","Документ", "Дата проводки","Договор", "Вид кредита", "Дата начала", "Дата окончания", "Состояние"}; 
	 		 
	 
	 
	 JTable jt = new JTable(Convertor.toArray(dbConnection.getAllDokumentZakrit()), column);    
	 jt.setBounds(internalFrame.getBounds());          
	 JScrollPane sp = new JScrollPane(jt);   
	
	 internalFrame.getContentPane().add(sp);

	
	 internalFrame.addInternalFrameListener(new InternalFrameAdapter(){
        public void internalFrameClosing(InternalFrameEvent e) {
           System.out.println("kontragent clicked X");
           internalFrame = null;
        }
    });
    desktop.add(internalFrame);
    internalFrame.setVisible(true);
    
  //  kontragent.setBounds(frame.getBounds());
    
    try {
    	internalFrame.setMaximum(true);
	} catch (PropertyVetoException e1) {

		e1.printStackTrace();
	}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.red);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.blue);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}


class DokumentPlatezhListener implements MouseListener {
	
	private JLabel lblNewLabel;
	private JInternalFrame internalFrame;
	private DBHelper dbConnection;
	private JDesktopPane desktop;
	
	DokumentPlatezhListener(JLabel lblNewLabel, JInternalFrame internalFrame, DBHelper dbConnection,JDesktopPane desktop){
		this.lblNewLabel = lblNewLabel;
		this.internalFrame = internalFrame;
		this.dbConnection = dbConnection;
		this.desktop = desktop;
	}
	
private void init() {
		
		JToolBar toolbar = new JToolBar();
	    toolbar.setRollover(true);
	    
		JButton button = new JButton("Создать");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Создать clicked!!!");
				
			}
		});
	    toolbar.add(button);
	    toolbar.addSeparator();
	    
	    JButton button_1 = new JButton("Обновить");
	    button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Обновить clicked!!!");
				
			}
		});
	    toolbar.add(button_1);
	    toolbar.addSeparator();
	    
	    JButton button_2 = new JButton("Удалить");
	    button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Удалить clicked!!!");
				
			}
		});
	    toolbar.add(button_2);
	    toolbar.addSeparator();
	    
	    JButton button_3 = new JButton("Изменить");
	    button_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("button Изменить clicked!!!");
				
			}
		});
	    toolbar.add(button_3);
	    toolbar.addSeparator();
	    
	    
	    internalFrame.add(toolbar,BorderLayout.NORTH);
	    
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if ((internalFrame != null)){
			try {
				//kontragent.setBounds(frame.getBounds());
				internalFrame.setMaximum(true);
				internalFrame.setVisible(true);
				internalFrame.toFront();
				internalFrame.setEnabled(true);
			} catch (PropertyVetoException e1) {

				e1.printStackTrace();
			}
	 return;
	 }
		
		internalFrame = new JInternalFrame("Конрагент", true, true, true, true);
		init();

	 String column[]={"ID","Договор", "Документ","Сумма", "Дата проводки", "Состояние"}; 
	 		 
	 
	 
	 JTable jt = new JTable(Convertor.toArray(dbConnection.getAllDokumentPlatezh()), column);    
	 jt.setBounds(internalFrame.getBounds());          
	 JScrollPane sp = new JScrollPane(jt);   
	
	 internalFrame.getContentPane().add(sp);

	
	 internalFrame.addInternalFrameListener(new InternalFrameAdapter(){
        public void internalFrameClosing(InternalFrameEvent e) {
           System.out.println("kontragent clicked X");
           internalFrame = null;
        }
    });
    desktop.add(internalFrame);
    internalFrame.setVisible(true);
    
  //  kontragent.setBounds(frame.getBounds());
    
    try {
    	internalFrame.setMaximum(true);
	} catch (PropertyVetoException e1) {

		e1.printStackTrace();
	}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.red);
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		lblNewLabel.setForeground(Color.blue);
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
