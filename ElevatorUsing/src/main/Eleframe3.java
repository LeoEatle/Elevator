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

public class Eleframe3 extends JFrame {
	
	public Eleframe3(Elevator[] e_array)
	{
		this.setTitle("Elevator");
		this.setSize(400,700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
        JPanel panel_c = new JPanel();
		add(panel_c);
		panel_c.setLayout(new GridLayout(1, 5, 1, 1));
		
		JPanel panel_3[] = new JPanel[5];
		
		
		for( int t = 0; t < 5; t++)
		{
			panel_3[t] = new JPanel(new GridLayout(20,1,1,1));
			panel_c.add(panel_3[t]);
			for( int s = 0; s < 20; s++)
			{
				
				
				panel_3[t].add(e_array[t].buttons[s]);

			}
		}
		
	}
	
	
	
	
	


}
