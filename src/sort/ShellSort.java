package sort;

import engine.Driving;

public class ShellSort extends Driving {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		shellSort();
	}
	
	private void shellSort(){
		int len = unsort.length;
		for(int i = len / 2; i > 0; i /= 2)
			for(int j = i; j < len; j++)
				for(int k = j - i; k >= 0 && unsort[k] > unsort[k + i]; k -= i){
					
					drawing.highlight(k, k + i);
					drawing.draw(unsort);
					
					while(flag){

						drawing.highlight(k, k + i);
						drawing.draw(unsort);
						
						if(Sleep() == 1) return;
					}
					
					if(Sleep() == 1) return;
					
					int temp = unsort[k];
					unsort[k] = unsort[k + i];
					unsort[k + i] = temp;
					
					drawing.highlight(k, k + i);
					drawing.draw(unsort);
					if(Sleep() == 1) return;
				}
	}
}
