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

	// ��������ϵĸ���Ԫ��
	private JCheckBox jcbSelection=new JCheckBox("ѡ������");
	private JCheckBox jcbInsertion=new JCheckBox("��������");
	private JCheckBox jcbBubble=new JCheckBox("ð������");
	private JCheckBox jcbQuick=new JCheckBox("��������");
	private JCheckBox jcbHeap=new JCheckBox("������");
	private JCheckBox jcbShell=new JCheckBox("ϣ������");
	private JLabel jlbAlgorithm=new JLabel("�����㷨:");
	private String algorithmSelectedStatus="";
	private JPanel jpAlgorithm=new JPanel();
	
	private JLabel jlbCount=new JLabel("Ԫ����Ŀ(1, 200]):");
	private JTextField jtfCount=new JTextField("50");
	private JPanel jpCount=new JPanel();
	
	private JPanel jpRun=new JPanel();
	
	//private Color colorStart=Color.YELLOW;	//
	private Color colorStart = new Color(0xcccc00);
	private Color colorEnd=Color.BLUE;	//
	private Color colorHighlight=Color.RED;	//

	/* ��� ��ʼ  ���� DemoFrame */
	private JButton jbtStart=new JButton("��ʼ");
	private DemoFrame demoFrame=null;
	private SettingFrame settingFrame=this;	
	
	// 
	public SettingFrame(){
		constructRunPanel();
		constructSettingFrame();
		
		addListeners();
	}
	
	// ���� �㷨��� 
	private void constructRunPanel(){		
		jcbSelection.setSelected(true);
		jcbInsertion.setSelected(true);
		jcbBubble.setSelected(true);
		jcbQuick.setSelected(true);
		jcbHeap.setSelected(true);
		jcbShell.setSelected(true);
		
		// ���ѡ��ť
		jpAlgorithm.setLayout(new GridLayout(1,7));
		jpAlgorithm.add(jlbAlgorithm);
		jpAlgorithm.add(jcbSelection);
		jpAlgorithm.add(jcbInsertion);
		jpAlgorithm.add(jcbBubble);
		jpAlgorithm.add(jcbQuick);
		jpAlgorithm.add(jcbHeap);
		jpAlgorithm.add(jcbShell);
		
		// ����Ԫ����Ŀ
		jpCount.setLayout(new GridLayout(1,2));
		jpCount.add(jlbCount);
		jpCount.add(jtfCount);
		
		jpRun.setLayout(new GridLayout(2,1));
		jpRun.add(jpAlgorithm, BorderLayout.BEFORE_LINE_BEGINS);
		jpRun.add(jpCount, BorderLayout.NORTH);
		jpRun.setBorder(new TitledBorder("�㷨"));
	}
	
	private void constructSettingFrame(){
		setLayout(new BorderLayout());
		add(jpRun,BorderLayout.CENTER);
		add(jbtStart,BorderLayout.PAGE_END);
	}
	
	// ��׽�¼��� �������ʼʱ������ DemoFrame
	private void addListeners(){
		jbtStart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int count;
				try{
					count=Integer.parseInt(jtfCount.getText());
					if(count<=1 || count > 200){
						JOptionPane.showMessageDialog(settingFrame, "���ݹ�ģӦ������1С�ڵ���200", "�Ƿ�����", JOptionPane.ERROR_MESSAGE);
						return;
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(settingFrame, "���������Ӧ����һ������", "�Ƿ�����", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				demoFrame=new DemoFrame(colorStart,colorEnd,colorHighlight, getAlgorithmSelectedStatus(),count);
				
				demoFrame.setTitle("������ʾ");
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
