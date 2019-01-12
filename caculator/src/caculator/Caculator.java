package caculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Caculator implements ActionListener{

	boolean flag = false;
	double number=0;
	double ans = 0;
	JFrame frame = new JFrame("Caculator");
	/*JButton btn[]=new JButton[10];
	JButton btn_jia = new JButton("+");
	JButton btn_jian = new JButton("-");
	JButton btn_cheng = new JButton("*");
	JButton btn_chu = new JButton("/");
	JButton btn_dian = new JButton(".");
	JButton btn_equal = new JButton("=");
	JButton btn_c = new JButton("C");*/
	JTextField tf = new JTextField("0",20); //下面的
	JTextField tf2 = new JTextField(20); //null 上面的
	/*private String[] str = {"+","-","*","/"};
	private String[] name = {"C","=",".","1","2","3","4","5","6","7","8","9","0"};
	*/
	JButton btn_c = new JButton("C");
	JButton btn[]=new JButton[16];
	private String[] name = {"7","8","9","/",
							"4","5","6","*",
							"1","2","3","-",
							"0","=",".","+"};
	private String[] str = {"+","-","*","/"};
	
	
public Caculator()
{
	tf.setHorizontalAlignment(tf.RIGHT);
	tf2.setHorizontalAlignment(tf2.RIGHT);
	JPanel pan1 = new JPanel();
	pan1.setLayout(new GridLayout(4,4));
	pan1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));//???干啥用的
for(int i=0;i<16;i++)

	{	
		btn[i]=new JButton(name[i]+"");
		btn[i].addActionListener(this);
		pan1.add(btn[i]);
	}
	
	/*pan1.add(btn[7]);
	pan1.add(btn[8]);
	pan1.add(btn[9]);
	pan1.add(btn_chu);
	pan1.add(btn[4]);
	pan1.add(btn[5]);
	pan1.add(btn[6]);
	pan1.add(btn_cheng);
	pan1.add(btn[1]);
	pan1.add(btn[2]);
	pan1.add(btn[3]);
	pan1.add(btn_jian);
	pan1.add(btn[0]);
	pan1.add(btn_dian);
	pan1.add(btn_equal);
	pan1.add(btn_jia);
	
	btn_jia.addActionListener(this);
	btn_jian.addActionListener(this);
	btn_cheng.addActionListener(this);
	btn_chu.addActionListener(this);
	btn_equal.addActionListener(this);
	btn_c.addActionListener(this);
	btn_dian.addActionListener(this);*/
	
	JPanel pan2 = new JPanel();
	pan2.setLayout(new BorderLayout());
	pan2.add(tf, BorderLayout.WEST);
	pan2.add(btn_c, BorderLayout.CENTER);
	pan2.add(tf2, BorderLayout.NORTH);
	btn_c.addActionListener(this);
	
	frame.getContentPane().setLayout(new BorderLayout());
	frame.setSize(300, 200);
	frame.setLocation(200, 300);
	frame.setResizable(false);
	frame.setVisible(true);
	frame.add(pan1, BorderLayout.CENTER);
	frame.add(pan2, BorderLayout.NORTH);
	
}

//计算函数
	protected void caculate()
	{
		char ch = ' ';
		number = Double.valueOf(tf.getText());
		ans=ans+number;
		if (tf2.getText().length()==0)
			ans=number;
		else
		{
			ch=tf.getText().charAt(tf.getText().length()-1); //charAt查看最后一个字符
			if(ch == '+')
				ans+=Double.valueOf(tf2.getText());
			else if(ch == '-')
				ans-=Double.valueOf(tf2.getText());
			else if(ch == '*')
				ans*=Double.valueOf(tf2.getText());
			else if(ch == '/')
				ans/=Double.valueOf(tf2.getText());
		}
		
	}
	
	//监听
	public void actionPerformed(ActionEvent e)
	{
	//	System.out.println(e.getActionCommand());
		for(int i=0;i<4;i++) //四种符号
		{
			if(e.getActionCommand().equals(str[i]))
			{	caculate();
			
			tf2.setText(ans+str[i]);
			tf.setText(null);
			}
		}
		 if(e.getActionCommand().equals("C"))
		{
			ans = 0;
			tf.setText("0");
			tf2.setText(null);
		}
		 else if (e.getActionCommand().equals("."))
		 {
			if(tf.getText().indexOf(".") == -1) // indexOf 标识第一次出现  不是第一次就没反应
			
			 {
				 tf.setText(tf.getText()+".");
			 }
		 }
		 else if(e.getActionCommand().equals("="))
		 {
			 char ch = ' ';
			 if(tf2.getText().length()>0)
			 {
				 ch = tf2.getText().charAt(tf2.getText().length()-1);
				 if(ch == '+')
						ans+=Double.valueOf(tf.getText());
					else if(ch == '-')
						ans-=Double.valueOf(tf.getText());
					else if(ch == '*')
						ans*=Double.valueOf(tf.getText());
					else if(ch == '/')
						ans/=Double.valueOf(tf.getText());
			 }
			 else
				 ans = Double.valueOf(tf.getText());
			 tf2.setText(null);
			 tf.setText(""+ans);
			 
		 }
		 else {
			 
			 if(flag == true)
			 {
				 tf.setText(null);
				 flag = false;
			 }
			// System.out.println(e.getActionCommand());
			 for(int i=0;i<10;i++)
			 {
				 if(e.getActionCommand().equals(""+i))
				 {
					 if(tf.getText().equals("0"))
						 tf.setText(""+i);
					 else
						 tf.setText(tf.getText()+i);
				 }
			 }
		 }
	
}



public static void main(String args[])
{
	Caculator cac = new Caculator();
}
}

