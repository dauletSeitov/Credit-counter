package www.lounger;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Toast {
	
		 public static void showMessage(String title, String message){
				
			 if (title.isEmpty()) title = "Title";
			 if (message.isEmpty()) message = "Message";
			
			 final JFrame frame1 = new JFrame();
			 frame1.setBackground(Color.WHITE);
			 frame1.setType(Type.UTILITY);
			 frame1.setTitle(title);
			 
			 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // get displays size

			 frame1.setBounds((int)screenSize.getWidth() - 250, (int)screenSize.getHeight() - 150, 250, 100);
			 frame1.setVisible(true);
			
			 JLabel label = new JLabel(message, SwingConstants.CENTER);
			 label.setHorizontalAlignment(JLabel.CENTER);
			 frame1.getContentPane().add(label);
				
			 Timer autoHideTimer = new Timer(3000, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					frame1.dispose();
					
				}
			});
			 
			 autoHideTimer.start();	
		}
		 
		 
		
}
