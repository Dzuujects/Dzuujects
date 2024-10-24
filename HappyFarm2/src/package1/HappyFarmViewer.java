package package1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class HappyFarmViewer
{
	static ArrayList<Animal> animals1 = new ArrayList<Animal>();
	
	public static void main(String[] args)
	{
        AnimalActions o1 = new AnimalActions();
		
		JFrame frame = new JFrame();
        frame.setTitle("HappyU Farm");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton animalsButton = new JButton("Animals");
        animalsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                SecondFrame tester = new SecondFrame();
                tester.display();
            }
        });
        
        frame.addMouseMotionListener(o1);
        
       class timer implements ActionListener
       {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				for(int i=0;i<animals1.size();i++)
				{
					animals1.get(i).move();
					o1.repaint();
				}
			}
		}
       
		timer t = new timer();
		Timer t1 = new Timer(10,t);
		t1.start();
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        o1.update(animals1);
        
        panel.add(o1, BorderLayout.CENTER);
        panel.add(animalsButton, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
		}
}
