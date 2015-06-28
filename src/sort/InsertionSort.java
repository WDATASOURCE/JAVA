package sort;

import engine.Driving;

public class InsertionSort extends Driving {

	@Override
	public void run() {
		
		insertionSort();
	}

	private void insertionSort(){
		for(int j=1;j<unsort.length;j++){
			int key=unsort[j];
			int i=j-1;
			while((i>=0)&&(unsort[i]>key)){	
				unsort[i+1]=unsort[i];
				i=i-1;
				drawing.highlight(i,j);
				drawing.draw(unsort);
				
				while(flag){
					drawing.highlight(i, j);
					drawing.draw(unsort);
					if(Sleep() == 1) return;
				}
			
				unsort[i+1]=key;
				drawing.draw(unsort);
				if(Sleep() == 1) return;
			}
		}
	}
}
