package sort;

import engine.Driving;

public class SelectionSort extends Driving{
	public void run(){
		selectionSort();
	}
	
	private void selectionSort(){		
		int key=0;
		int count=0;
		while(count<unsort.length-1){
			for(int i=key+1;i<unsort.length;i++){	
				
				while(flag){
					drawing.highlight(i, key);
					drawing.draw(unsort);
					if(Sleep() == 1) return;
				}
				
				if(unsort[key]>unsort[i])	
					key=i;
				drawing.highlight(i,key);
				drawing.draw(unsort);
				if(Sleep() == 1) return;
			}	
			int temp=unsort[count];		
			unsort[count]=unsort[key];
			unsort[key]=temp;
			
			count++;
			key=count;

			drawing.draw(unsort);
			
		}
	}
}
