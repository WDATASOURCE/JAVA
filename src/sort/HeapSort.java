package sort;

import engine.Driving;

public class HeapSort extends Driving {

	@Override
	public void run() {
		
		heapSort();
	}

	private void heapSort(){
		int count=unsort.length;
		BuildMaxHeap(unsort,count);
		for(int i=count-1;i>0;i--){
			int temp=unsort[0];
			unsort[0]=unsort[i];
			unsort[i]=temp;
			drawing.highlight(0, i);
			drawing.draw(unsort);
			
			if(Sleep() == 1) return;
			
			while(flag){
				drawing.highlight(0, i);
				drawing.draw(unsort);
				if(Sleep() == 1) return;
			}
			
			count--;
			int t = MaxHeapify(unsort,0,count-1);
			if(t == -1) return;
		}
	}
	
	private int MaxHeapify(int unsort[],int i,int count){
		int l=2*i+1; 
		int r=2*i+2;
		int largest;
		drawing.highlight(l, i, r);
		drawing.draw(unsort);
		if((l<=count)&&(unsort[l]>unsort[i])) largest=l;
		else largest=i;
		if((r<=count)&&(unsort[r]>unsort[largest])) largest=r;
		if(largest!=i){
			int temp=unsort[i];
			unsort[i]=unsort[largest];
			unsort[largest]=temp;
			
			drawing.highlight(r, largest);
			drawing.draw(unsort);

			while(flag){
				drawing.highlight(r, largest);
				drawing.draw(unsort);
				if(Sleep() == 1) return -1;
			}
			
			if(Sleep() == 1) return -1;
			int t = MaxHeapify(unsort,largest,count-1);
			if(t == -1) return -1;
			else return 0;
		}
		return 0;
	}

	private void BuildMaxHeap(int unsort[],int count){
		for(int i=count/2+1;i>=0;i--){
			int t = MaxHeapify(unsort,i,count-1);
			if(t == -1) return;
		}
	}
}
