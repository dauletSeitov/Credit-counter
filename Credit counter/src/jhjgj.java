

import java.util.Arrays;
import java.util.Comparator;

import javax.imageio.ImageIO;


public class jhjgj {

	public static void main(String[] args) throws Exception {
	
		String myString = "";
		Thread asd= new Thread(new TestObj(myString));
		Thread asd_= new Thread(new TestObjNew(myString));
		
		
		asd_.setPriority(10);
		asd.setPriority(1);
		
		asd_.start();
		asd.start();
		
		
		
		
	}

}




class TestObj implements Runnable{

	String myString;
	
	TestObj(String myString){
		this.myString = myString;
	}
	
	
	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getId());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			try {
				
				synchronized(myString){
				myString.wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	
}




class TestObjNew implements Runnable{

	String myString;
	
	TestObjNew(String myString){
		this.myString = myString;
	}
	
	
	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getId());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			synchronized(myString){
			myString.notifyAll();
			}
		
		
		}
		
		
	}

	
}
