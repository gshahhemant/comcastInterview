package com.helloworld.threadDeadLock;

public class TestDeadlock {

	public	String strignOne = "StrignOne";
	public  String stringtwo = "Stringtwo";
	public String outPut="noResult";

	public String getOutPut() {
		return outPut;
	}

	public void setOutPut(String outPut) {
		this.outPut = outPut;
	}

	public Thread trd1 = new Thread("My Thread 1"){
		public void run(){
			while(true){
				synchronized(strignOne){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(stringtwo){
						setOutPut(strignOne+stringtwo);
					}
				}
			}
		}
	};

	public Thread trd2 = new Thread("My Thread 2"){
		public void run(){
			while(true){
				synchronized(stringtwo){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(strignOne){
						setOutPut(stringtwo+strignOne);
					}
				}
			}
		}
	};

}
