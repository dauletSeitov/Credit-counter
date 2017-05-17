package www.lounger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Log {
	
	private File 			file = null; 
	private FileWriter 		fw = null;
	private PrintWriter 	bw = null;
		
	Log(){
		
		String path = "c:/temp/log.txt" /*getLogFilePath()*/;
	
		
		file = new File(path);
		
		if (!file.exists()){// if not exist
			try {
				file.createNewFile();
			} catch (IOException e) {
				file = new File("log.txt");
				try {
					file.createNewFile();
					fw = new FileWriter(file);
					bw = new PrintWriter(fw);
					
				} catch (IOException e1) {
					file = null;
					fw = null;
					bw = null;
				}
			}
		}
	}
	
	private void writeLogFile(String content){  
 
		
				bw.println("sdfsdf");
	
			

		
	
			//bw.close();
	}
	
	private void writeLogWindow(String content){
	}
	
	private void writeLog(String content){
		writeLogWindow(content);
	//	if (null != )writeLogFile(content);
	}

}
