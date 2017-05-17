package www.lounger;

import java.util.Collection;
import java.util.Iterator;

public class ReportCreator {
	
	public String name; 
	
	public ReportCreator(String name){
		this.name = (name.isEmpty()) ?  "Report_" + Math.random() : name; 	
	}
	
	public void writeCollection(Collection<Object> collection){
		
		Object [][]result = null;
		int i = 0;
		
		for (Object oj : collection) {
			result[i++] = ((Collection)oj).toArray();
		}
		
		writeCollection(result);
	}
	
	public void writeCollection(Object collection [][] ){
		
		String row = null;
		
		for (Object []oj : collection) {
			for (Object ojj : oj){
				row += oj.toString() + ";";
			}
			System.out.println(row);
			row = "";
		}
	}

	public void writeRow(String row){
		
	}
	
	public void close(){
		
	}
}
