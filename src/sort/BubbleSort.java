package sort;

import engine.Driving;

public class BubbleSort extends Driving {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		bubbleSort();
	}

	public void bubbleSort(){
		for(int i=0;i<unsort.length;i++){
			for(int j=0;j<unsort.length-i-1;j++){
				
				while(flag){
					drawing.highlight(j,  j+1);
					drawing.draw(unsort);
					if(Sleep() == 1) return;
					
				}
				
				if(unsort[j]>unsort[j+1]){
					int temp=unsort[j];
					unsort[j]=unsort[j+1];
					unsort[j+1]=temp;
					drawing.highlight(j, j+1);
					drawing.draw(unsort);
					if(Sleep() == 1) return;
				}else{
					drawing.highlight(j, j+1);
					drawing.draw(unsort);
					if(Sleep() == 1) return;
				}
			}
		}
	}
}
