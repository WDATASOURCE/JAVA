package frame;

import engine.Driving;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sort.BubbleSort;
import sort.HeapSort;
import sort.InsertionSort;
import sort.QuickSort;
import sort.SelectionSort;
import sort.ShellSort;

@SuppressWarnings("serial")
public class DemoFrame extends JFrame {
	private ExecutorService executor=Executors.newCachedThreadPool();
	private Drawing drawing0;
	private Drawing drawing1;
	private Drawing drawing2;
	private Drawing drawing3;
	private Drawing drawing4;
	private Drawing drawing5;
	private int[] numberGroup;
	//private int count;
	@SuppressWarnings("unused")
	private int demoNumber;
	//private String algorithmSelectedStatus;
	private LinkedList<Driving> drivingList=new LinkedList<Driving>();
	private LinkedList<JPanel> jpSubDemoList=new LinkedList<JPanel>();
	
	private JPanel jpDemo=new JPanel();
	
	private JLabel jlbComparisonTime=new JLabel("基本操作：");
	
	private JButton jbtStartOrSuspend=new JButton("开始");
	//private JButton jbtRestart=new JButton("重置");
	//private JButton jbtStepForward=new JButton("上一步");
	//private JButton jbtStepBackward=new JButton("下一步");
	private JPanel jpControlButtons=new JPanel();
	
	private JSlider jslSpeed=new JSlider(JSlider.HORIZONTAL);      // 定义滑块
	private JLabel jlbSpeed=new JLabel("速度");
	private JLabel jlbShowSpeed=new JLabel("50");
	private JPanel jpSpeed=new JPanel();
	
	private JPanel jpControl=new JPanel();
	
	public DemoFrame(Color colorStart,Color colorEnd,Color colorHighlight, String algorithmSelectedStatus,int count){
		demoNumber = 0;
		//this.algorithmSelectedStatus = algorithmSelectedStatus;
		initDrawing(colorStart,colorEnd,colorHighlight);
		initDriving(algorithmSelectedStatus,count);	
		constructDemoFrame();
		addListeners();
	}	
	
	private void initDrawing(Color colorStart,Color colorEnd,Color colorHighlight){
		drawing0=new Column();
		drawing1=new Column();
		drawing2=new Column();
		drawing3=new Column();
		drawing4=new Column();
		drawing5=new Column();
		
		drawing0.setColor(colorStart,colorEnd,colorHighlight);
		drawing1.setColor(colorStart,colorEnd,colorHighlight);
		drawing2.setColor(colorStart,colorEnd,colorHighlight);
		drawing3.setColor(colorStart,colorEnd,colorHighlight);
		drawing4.setColor(colorStart,colorEnd,colorHighlight);
		drawing5.setColor(colorStart,colorEnd,colorHighlight);
	}
	
	private void initDriving(String algorithmSelectedStatus,int count){
		//this.count=count;
		
		numberGroup=UnsortGenerator(count);
		if(algorithmSelectedStatus.charAt(0)=='1'){
			demoNumber++;
			Driving driving0=new SelectionSort();
			
			driving0.setFlag(false);
			driving0.setDrawing(drawing0);
			driving0.setSleepTime((100-jslSpeed.getValue())*10);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing0.draw(unsort);
			driving0.setArray(unsort);
			drivingList.add(driving0);
			
			JPanel jpSubDemo0=new JPanel();
			jpSubDemo0.setBorder(new TitledBorder("选择排序"));
			jpSubDemo0.setLayout(new BorderLayout());
			jpSubDemo0.add(drawing0,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo0);
		}
		
		if(algorithmSelectedStatus.charAt(1)=='1'){
			demoNumber++;
			Driving driving1=new InsertionSort();
			
			driving1.setFlag(false);
			driving1.setDrawing(drawing1);
			driving1.setSleepTime((100-jslSpeed.getValue())*10);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing1.draw(unsort);
			driving1.setArray(unsort);
			drivingList.add(driving1);
			
			JPanel jpSubDemo1=new JPanel();
			jpSubDemo1.setBorder(new TitledBorder("插入排序"));
			jpSubDemo1.setLayout(new BorderLayout());
			jpSubDemo1.add(drawing1,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo1);
		}
		
		if(algorithmSelectedStatus.charAt(2)=='1'){
			demoNumber++;
			Driving driving2=new BubbleSort();
			
			driving2.setFlag(false);
			driving2.setDrawing(drawing2);
			driving2.setSleepTime((100-jslSpeed.getValue())*10);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing2.draw(unsort);
			driving2.setArray(unsort);
			drivingList.add(driving2);
			
			JPanel jpSubDemo2=new JPanel();
			jpSubDemo2.setBorder(new TitledBorder("冒泡排序"));
			jpSubDemo2.setLayout(new BorderLayout());
			jpSubDemo2.add(drawing2,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo2);
	}
		
		if(algorithmSelectedStatus.charAt(3)=='1'){
			demoNumber++;
			Driving driving3=new QuickSort();
			
			driving3.setFlag(false);
			driving3.setDrawing(drawing3);
			driving3.setSleepTime((100-jslSpeed.getValue())*10);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing3.draw(unsort);
			driving3.setArray(unsort);
			drivingList.add(driving3);
			
			JPanel jpSubDemo3=new JPanel();
			jpSubDemo3.setBorder(new TitledBorder("快速排序"));
			jpSubDemo3.setLayout(new BorderLayout());
			jpSubDemo3.add(drawing3,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo3);
		}
		
		if(algorithmSelectedStatus.charAt(4)=='1'){
			demoNumber++;
			Driving driving4=new HeapSort();
			
			driving4.setFlag(false);
			driving4.setDrawing(drawing4);
			driving4.setSleepTime((100-jslSpeed.getValue())*10);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing4.draw(unsort);
			driving4.setArray(unsort);
			drivingList.add(driving4);
			
			JPanel jpSubDemo4=new JPanel();
			jpSubDemo4.setBorder(new TitledBorder("堆排序"));
			jpSubDemo4.setLayout(new BorderLayout());
			jpSubDemo4.add(drawing4,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo4);
		}
		
		if(algorithmSelectedStatus.charAt(5)=='1'){
			demoNumber++;
			Driving driving5=new ShellSort();
			
			driving5.setFlag(false);
			driving5.setDrawing(drawing5);
			driving5.setSleepTime((100-jslSpeed.getValue())*10);
			
			int[] unsort=new int[count];
			System.arraycopy(numberGroup, 0, unsort, 0, count);
			drawing5.draw(unsort);
			driving5.setArray(unsort);
			drivingList.add(driving5);
			
			JPanel jpSubDemo5=new JPanel();
			jpSubDemo5.setBorder(new TitledBorder("希尔排序"));
			jpSubDemo5.setLayout(new BorderLayout());
			jpSubDemo5.add(drawing5,BorderLayout.CENTER);
			jpSubDemoList.add(jpSubDemo5);
		}
	}
	
	private void constructDemoFrame(){
		if(jpSubDemoList.size()==1){
			jpDemo.setLayout(new BorderLayout());
			jpDemo.add(jpSubDemoList.removeFirst(),BorderLayout.CENTER);
		}else{
			jpDemo.setLayout(new GridLayout(2,3));
			while(jpSubDemoList.size()!=0){
				jpDemo.add(jpSubDemoList.removeFirst());
			}
		}
		
		jpControlButtons.setLayout(new FlowLayout());
		jpControlButtons.add(jlbComparisonTime);
		jpControlButtons.add(jbtStartOrSuspend);
		/*jpControlButtons.add(jbtRestart);
		if(drivingList.size() == 1){
			jpControlButtons.add(jbtStepForward);
			jpControlButtons.add(jbtStepBackward);
		}*/
		
		jpSpeed.setLayout(new FlowLayout());
		jpSpeed.add(jlbSpeed);
		jpSpeed.add(jslSpeed);
		jpSpeed.add(jlbShowSpeed);
		
		jpControl.setLayout(new GridLayout(2,1));
		jpControl.add(jpControlButtons);
		jpControl.add(jpSpeed);
		
		setLayout(new BorderLayout());
		add(jpDemo,BorderLayout.CENTER);
		add(jpControl,BorderLayout.SOUTH);
	}
	
	private void addListeners(){
		jbtStartOrSuspend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(jbtStartOrSuspend.getText().equals("开始")){
					if(drivingList.get(0).getFlag()){
						for(int i = 0; i < drivingList.size(); i++)
							drivingList.get(i).setFlag(false);
					}else{
						for(int i=0;i<drivingList.size();i++)
							executor.execute(drivingList.get(i));
					}
					jbtStartOrSuspend.setText("暂停");
				}else{
					for(int i = 0; i < drivingList.size(); i++)
						drivingList.get(i).setFlag(true	);
					jbtStartOrSuspend.setText("开始");
				}
			}
		});
		
		/*
		jbtRestart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				executor.shutdownNow();
				executor = Executors.newCachedThreadPool();
				drivingList.clear();
				initDriving(algorithmSelectedStatus, count);
				//constructDemoFrame();
				jbtStartOrSuspend.setText("开始");
			}
		});
		*/
		
		jslSpeed.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				jlbShowSpeed.setText(String.valueOf(jslSpeed.getValue()));
				for(int i=0;i<drivingList.size();i++)
					drivingList.get(i).setSleepTime((100-jslSpeed.getValue())*10);
			}
		});
	}
	
	// 初始化数组
	private int[] UnsortGenerator(int count){		
		int[] tempArray=new int[count];	
		
		for(int i=0;i<count;i++){
			tempArray[i]=i+1;
		}
		for(int j=0;j<count;j++){
			int index=(int)(Math.random()*count);

			int temp=tempArray[j];
			tempArray[j]=tempArray[index];
			tempArray[index]=temp;
		}
		return tempArray;
	}
}
