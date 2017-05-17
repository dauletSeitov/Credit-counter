package www;

import java.util.ArrayList;

public class Convertor {
	
	public static Object[][] toArray(ArrayList<ArrayList<Object>> list) {
	    
		if (!(list != null )) return null;
		
		Object[][] r = new Object[list.size()][];
	    int i = 0;
	    for (ArrayList<Object> next : list) {
	       r[i++] = next.toArray();
	    }
	    return r;
	}
}
