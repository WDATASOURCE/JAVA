package engine;

import frame.Drawing;

public abstract class Driving implements Runnable{
	protected int[] unsort;
	protected Drawing drawing;
	protected int sleepTime;
	protected boolean flag;

	public abstract void run();
	
	public void setArray(int[] unsort){
		this.unsort=unsort;
	}
	
	public void setDrawing(Drawing drawing){
		this.drawing=drawing;
	}
	
	public void setSleepTime(int sleepTime){
		this.sleepTime=sleepTime;
	}
	
	public int getSleepTime(){
		return sleepTime;
	}
	
	public void setFlag(boolean flag){
		this.flag = flag;
	}
	
	public boolean getFlag(){
		return flag;
	}
	
	public int Sleep(){
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			if(e instanceof InterruptedException)
				return 1;
			e.printStackTrace();
		}
		return 0;
	}
}
