package main;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Elevator extends Thread {
	int floor = 1;
	int aim_floor = 1;
	int find = 0;
	JLabel[] texts = new JLabel[20];
    JButton[] buttons = new JButton[20];
   

	int[] user_floor = new int[20];//小心这个地方数组的index和floor的整形数并不对应
	
	private int number;
	int direction;
	Elevator(int n){              //This is the constructor for elevator
		this.floor = 1;
		this.number = n;
		for( int s = 0; s < 20; s++)
		{
			this.buttons[s] = new JButton(String.valueOf(s + 1));
			this.buttons[s].setPreferredSize(new Dimension(42,17));
			this.buttons[s].setBackground(Color.white);
			this.buttons[s].setActionCommand(String.valueOf(s));
			this.buttons[s].addActionListener(new ChangeListener());

		}
	}
	
	void Acceptfloor(int i){
		this.aim_floor = i;
	}
	

	void AcceptUserfloor(int i){ //这个是电梯里的楼层按钮
		this.user_floor[i - 1] = 1;
        
		
	}
	

    void decision()
    {
    	if(this.direction == 1)
    	{	
	    	for (int flag = this.aim_floor ; flag <= 20; flag ++)
	    	{
	    		if(this.user_floor[flag-1] == 1)
	    		{
	    			this.aim_floor = flag;
	    		}
	    	}
	    }
    	else if (this.direction == 2)
    	{
    		for (int flag = this.aim_floor ; flag >=1 ; flag --)
    		{
    			if (this.user_floor[flag -1] == 1)
    			{
    				this.aim_floor = flag;
    			}
    		}
    	}
    	else if (this.direction == 0)
    	{
    		for (int flag  =  1; flag <= 20 ; flag++)
    		{
    			if (this.user_floor[flag - 1] == 1)
    			{
    				this.aim_floor = flag;
    			}
    		}
    	}
    }
	
	void InputFloor(){
		System.out.println("Please input the number of the floor you go to");
		Scanner input = new Scanner(System.in);
		this.user_floor[input.nextInt() - 1] = 1;
		
		
	}
	

	
	void Move(){
		if (this.user_floor[this.floor - 1] == 1)
		{
			buttons[this.floor - 1].setText("Opened");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.user_floor[this.floor - 1] = 0;
			this.buttons[this.floor - 1].setBackground(Color.white);
			System.out.println("The elevator wait until user goes out");
			buttons[this.floor - 1].setText(String.valueOf(this.floor));
			
		}
		
		else if (this.aim_floor > this.floor) 
		{
			buttons[this.floor - 1].setBackground(Color.white);
			this.floor++;   //向上升
			this.direction = 1;
			
		}				
		else if (this.aim_floor < this.floor)
		{
			buttons[this.floor - 1].setBackground(Color.white);
			this.floor--;
			this.direction = 2;
	
		}
		
		
		else if (this.aim_floor == this.floor)
		{
			//这里decision必须判断在前！不然就不知道方向了！！！
			decision();
			this.direction = 0;
		
		}
		
	}
	
	void Showfloor(){      //for debug
		System.out.println("The Elevator " + this.number + " is on " + this.floor + "th floor");
		buttons[this.floor - 1].setBackground(new Color(98,2,168));
	}
	
	public void run(){
		
		
		
		for( ; ; )
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			Move();
			Showfloor();

			
//			Eleframe.textField_1.setText(String.valueOf(this.floor));
			
		}
	}
	class ChangeListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			for(int ox = 0; ox < 20; ox ++)
			{
				if (String.valueOf(ox).equals(e.getActionCommand()))
				{
					user_floor[ox] = 1;
					
					buttons[ox].setBackground(Color.red);
				}
				
			}
		
		}
	}

}