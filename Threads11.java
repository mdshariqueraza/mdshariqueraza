package com.q1;


class Runner implements Runnable  
{
 int x=0;
 public void run() {
 int current = 0;

 for(int i=0;i<4;i++){
 current = x;
 System.out.print(current + ",");
 x = current + 2;
 }
 }
}

public class Threads11 {
		public static void main (String[] args){
		 {
		 new Threads11().go();
		 }
	}
		
		  public void go()
			 {
			 Runnable r1 = new Runner();
			 new Thread(r1).start();
			 new Thread(r1 ).start();
			}
}
 