package sort;

import engine.Driving;

public class QuickSort extends Driving {

	@Override
	public void run() {
		
		quickSort(unsort,0,unsort.length-1);
		//quickSort(unsort, 0, unsort.length);
	}
	
	private void quickSort(int unsort[],int p,int r){
		if(p<r){
			int q=Partition(unsort,p,r);
			if(q == -2) return;
			quickSort(unsort,p,q-1);
			quickSort(unsort,q+1,r);
		}
	}
	
	private int Partition(int unsort[],int p, int r){
		int x=unsort[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++){
			if(unsort[j]<=x){
				++i;
				if(Sleep() == 1) return -2;
				drawing.highlight(j, r, i);
				drawing.draw(unsort);
				
				int temp=unsort[i];
				unsort[i]=unsort[j];
				unsort[j]=temp;
				
				drawing.highlight(j, r, i);
				drawing.draw(unsort);

				while(flag){
					drawing.highlight(j, i, r);
					drawing.draw(unsort);
					if(Sleep() == 1) return -2;
				}
				
				//if(Sleep() == 1) return -2;
			}
		}
		drawing.highlight(i + 1, r);
		drawing.draw(unsort);
		int temp=unsort[i+1];
		unsort[i+1]=unsort[r];
		unsort[r]=temp;
		drawing.highlight(i + 1, r);
		drawing.draw(unsort);

		return i+1;
	}
}
