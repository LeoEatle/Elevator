package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JMenu;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

import javax.swing.SwingConstants;

import java.awt.SystemColor;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.Scanner;
import java.awt.Color;

import javax.swing.UIManager;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;

import java.awt.Component;

public class Eleframe extends JFrame {

	private JPanel contentPane;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JTextField textField_5;
	
	static Elevator e1 = new Elevator(1);
	static Elevator e2 = new Elevator(2);
	static Elevator e3 = new Elevator(3);
	static Elevator e4 = new Elevator(4);
	static Elevator e5 = new Elevator(5);
	

	static Elevator e_array[] = {e1,e2,e3,e4,e5};
	
	
	int time = 0;
	private JTextField textField;
	
	
	public static User newuser(){
		System.out.println("Hello new user where are you?(input a number)");
		Scanner input = new Scanner(System.in);
		int f = input.nextInt();
		User u = new User(f);
		u.InputDirection();
//		input.close(); 为什么input总是不能关闭，出现Exception in thread "main" java.util.NoSuchElementException错误
		return u;
	}
	
	public static int findelevator(User u, Elevator[] e_array){
     //int difference = Math.abs(e_array[0].floor - u.floor);
     int selected = 0;
     int difference = 20;
	 for(int n = 0; n < 5 ; n++){  //这里是为了找出方向相同或者停止的电梯,然后再找出这些电梯最近的那个
				 if(u.floor > e_array[n].floor && e_array[n].direction == 1 && u.direction == 1)
				 {
				    	if(difference > Math.abs(e_array[n].floor - u.floor)){
				    		difference = Math.abs(e_array[n].floor - u.floor);
				    		selected = n;
				    		
				    	}
				 }
				 
				 else if(u.floor < e_array[n].floor && e_array[n].direction == 2 && u.direction == 2)
				 {
					 if(difference > Math.abs(e_array[n].floor - u.floor)){
				    		difference = Math.abs(e_array[n].floor - u.floor);
				    		selected = n;
				    		
				    	}
				 }
				 else if(e_array[n].direction == 0)
				 {
					 if(difference > Math.abs(e_array[n].floor - u.floor)){
				    		difference = Math.abs(e_array[n].floor - u.floor);
				    		selected = n;
				    		
				    	}
				 }
	    }
	return selected;
	}
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		
		EventQueue.invokeLater(new Runnable() {
		public void run() {
				
				try {
					Eleframe frame = new Eleframe();
					frame.setVisible(true);
					Eleframe3 frame_f = new Eleframe3(e_array);
					frame_f.setVisible(true);
					e1.start();
					e2.start();
					e3.start();
					e4.start();
					e5.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		});
		
		
		
		
		new Thread(new Runnable() {    //新线程为了更新textfield里的楼层数据

			@Override
			public void run() {
			for( ; ;){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				textField_1.setText(String.valueOf(e1.floor));
				textField_2.setText(String.valueOf(e2.floor));
				textField_3.setText(String.valueOf(e3.floor));
				textField_4.setText(String.valueOf(e4.floor));
				textField_5.setText(String.valueOf(e5.floor));
				

			}
			}
			}).start();

	    User u = newuser();
	    int selected = findelevator(u,e_array);   //选出要运行的电梯
	    System.out.println("selected: "+selected);
//	    e_array[selected].AcceptUserfloor(u.floor,u.direction);  //先存储用户在的那一楼以及方向
	    e_array[selected].Acceptfloor(u.floor);
	    System.out.println("Please wait until the elevator reach your floor...");
	    
	    
	   
	
	}



	/**
	 * Create the frame.
	 */
	public Eleframe() {
		setTitle("LeoEatle's Elevator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("You are at the ");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JSeparator separator = new JSeparator();
		
		JPanel panel = new JPanel();
		
		JLabel lblYouWannaGo = new JLabel("You wanna go  ");
		lblYouWannaGo.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("th Floor");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		
		JButton btnNewButton_2 = new JButton("Submit!");
		btnNewButton_2.setFont(new Font("Arial Black", Font.PLAIN, 27));
		btnNewButton_2.setForeground(Color.DARK_GRAY);
		btnNewButton_2.setBackground(UIManager.getColor("Button.background"));
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UP", "DOWN"}));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblYouWannaGo, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_2)
							.addGap(18))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(414, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblYouWannaGo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		
//		JFrame frame_f =new Eleframe3();
//		frame_f.setSize(200,200);
//        frame_f.setVisible(true);
//        JPanel panel_c = new JPanel();
//		frame_f.add(panel_c);
//		panel_c.setLayout(new GridLayout(0, 5, 0, 0));
//		
//		JPanel panel_3[] = new JPanel[5];
//		
//		
//		for( int t = 0; t < 5; t++)
//		{
//			panel_2.add(panel_3[t]);
//			for( int s = 0; s < 20; s++)
//			{
//				e_array[t].buttons[s] = new JButton(String.valueOf(s));
//				e_array[t].buttons[s].setPreferredSize(new Dimension(42,17));
//				panel_3[t].add(e_array[t].buttons[s]);
//			}
//		}
		
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String f1 = textField.getText();
				System.out.println(f1);
				User u = new User(Integer.parseInt(f1));
				String value = (String) comboBox.getSelectedItem();
				if (value.equals("UP")){
					u.direction = 1;
					System.out.println("your direction is " + 1);
				}
				if (value.equals("DOWN")){
					u.direction = 2;
					System.out.println("your direction is " + 2);
				}
				int selected = findelevator(u,e_array);   //选出要运行的电梯
			    System.out.println("selected: "+selected);
//			    e_array[selected].AcceptUserfloor(u.floor,u.direction);  //先存储用户在的那一楼以及方向
			    e_array[selected].Acceptfloor(u.floor);
			    System.out.println("Please wait until the elevator reach your floor...");
				
			}
		});
		panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 81, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
	
		
		JLabel lblElevator = new JLabel("1# Elevator");
		lblElevator.setBounds(10, 48, 69, 23);
		panel.add(lblElevator);
		
		JLabel lblElevator_1 = new JLabel("2# Elevator");
		lblElevator_1.setBounds(89, 48, 69, 23);
		panel.add(lblElevator_1);
		
		JLabel lblElevator_2 = new JLabel("3# Elevator");
		lblElevator_2.setBounds(168, 48, 69, 23);
		panel.add(lblElevator_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(86, 81, 66, 21);
		panel.add(textField_2);
		
		JLabel lblElevator_3 = new JLabel("4# Elevator");
		lblElevator_3.setBounds(247, 48, 69, 23);
		panel.add(lblElevator_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(168, 81, 66, 21);
		panel.add(textField_3);
		
		JLabel lblElevator_4 = new JLabel("5# Elevator");
		lblElevator_4.setBounds(326, 48, 69, 23);
		panel.add(lblElevator_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(250, 81, 66, 21);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(326, 81, 66, 21);
		panel.add(textField_5);
		
		JLabel lblThisIsWhich = new JLabel("This is which floor every elevator stays");
		lblThisIsWhich.setForeground(SystemColor.textHighlight);
		lblThisIsWhich.setFont(new Font("Adobe Garamond Pro Bold", Font.BOLD, 28));
		lblThisIsWhich.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisIsWhich.setBounds(11, 10, 450, 28);
		panel.add(lblThisIsWhich);
		contentPane.setLayout(gl_contentPane);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
