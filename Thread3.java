package com.q1;

public class Thread3 implements Runnable {
	
	 public void run(){
		
	 System.out.print("running");

		 } 
		public static void main(String[] args) 
		{
		 Thread t = new Thread(new Thread3());
		 t.run();
		 t.run();
		 t.start();
		
}
}
