package frame;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.*;

@SuppressWarnings("serial")
public class SettingFrame extends JFrame {

	// 设置面板上的各种元素
	private JCheckBox jcbSelection=new JCheckBox("选择排序");
	private JCheckBox jcbInsertion=new JCheckBox("插入排序");
	private JCheckBox jcbBubble=new JCheckBox("冒泡排序");
	private JCheckBox jcbQuick=new JCheckBox("快速排序");
	private JCheckBox jcbHeap=new JCheckBox("堆排序");
	private JCheckBox jcbShell=new JCheckBox("希尔排序");
	private JLabel jlbAlgorithm=new JLabel("排序算法:");
	private String algorithmSelectedStatus="";
	private JPanel jpAlgorithm=new JPanel();
	
	private JLabel jlbCount=new JLabel("元素数目(1, 200]):");
	private JTextField jtfCount=new JTextField("50");
	private JPanel jpCount=new JPanel();
	
	private JPanel jpRun=new JPanel();
	
	//private Color colorStart=Color.YELLOW;	//
	private Color colorStart = new Color(0xcccc00);
	private Color colorEnd=Color.BLUE;	//
	private Color colorHighlight=Color.RED;	//

	/* 点击 开始  调用 DemoFrame */
	private JButton jbtStart=new JButton("开始");
	private DemoFrame demoFrame=null;
	private SettingFrame settingFrame=this;	
	
	// 
	public SettingFrame(){
		constructRunPanel();
		constructSettingFrame();
		
		addListeners();
	}
	
	// 设置 算法面板 
	private void constructRunPanel(){		
		jcbSelection.setSelected(true);
		jcbInsertion.setSelected(true);
		jcbBubble.setSelected(true);
		jcbQuick.setSelected(true);
		jcbHeap.setSelected(true);
		jcbShell.setSelected(true);
		
		// 添加选择按钮
		jpAlgorithm.setLayout(new GridLayout(1,7));
		jpAlgorithm.add(jlbAlgorithm);
		jpAlgorithm.add(jcbSelection);
		jpAlgorithm.add(jcbInsertion);
		jpAlgorithm.add(jcbBubble);
		jpAlgorithm.add(jcbQuick);
		jpAlgorithm.add(jcbHeap);
		jpAlgorithm.add(jcbShell);
		
		// 设置元素数目
		jpCount.setLayout(new GridLayout(1,2));
		jpCount.add(jlbCount);
		jpCount.add(jtfCount);
		
		jpRun.setLayout(new GridLayout(2,1));
		jpRun.add(jpAlgorithm, BorderLayout.BEFORE_LINE_BEGINS);
		jpRun.add(jpCount, BorderLayout.NORTH);
		jpRun.setBorder(new TitledBorder("算法"));
	}
	
	private void constructSettingFrame(){
		setLayout(new BorderLayout());
		add(jpRun,BorderLayout.CENTER);
		add(jbtStart,BorderLayout.PAGE_END);
	}
	
	// 捕捉事件， 当点击开始时，调用 DemoFrame
	private void addListeners(){
		jbtStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int count;
				try{
					count=Integer.parseInt(jtfCount.getText());
					if(count<=1 || count > 200){
						JOptionPane.showMessageDialog(settingFrame, "数据规模应当大于1小于等于200", "非法输入", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(settingFrame, "输入的数据应当是一个整数", "非法输入", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				demoFrame=new DemoFrame(colorStart,colorEnd,colorHighlight, getAlgorithmSelectedStatus(),count);
				
				demoFrame.setTitle("排序演示");
				demoFrame.setSize(750,550);
				demoFrame.setLocation(250,150);
				demoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				demoFrame.setVisible(true);
				
				demoFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
			}
		});
	}
	
	private String getAlgorithmSelectedStatus(){
		algorithmSelectedStatus="";
		
		if(jcbSelection.isSelected())
			algorithmSelectedStatus+="1";
		else
			algorithmSelectedStatus+="0";
		
		if(jcbInsertion.isSelected())
			algorithmSelectedStatus+="1";
		else
			algorithmSelectedStatus+="0";
		
		if(jcbBubble.isSelected())
			algorithmSelectedStatus+="1";
		else
			algorithmSelectedStatus+="0";
		
		if(jcbQuick.isSelected())
			algorithmSelectedStatus+="1";
		else
			algorithmSelectedStatus+="0";
		
		if(jcbHeap.isSelected())
			algorithmSelectedStatus+="1";
		else
			algorithmSelectedStatus+="0";
		
		if(jcbShell.isSelected())
			algorithmSelectedStatus+="1";
		else
			algorithmSelectedStatus+="0";
		
		return algorithmSelectedStatus;
	}
}
