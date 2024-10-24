package package1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Create extends JFrame implements ActionListener
{
	public Create(Animal animal)
	{
		AnimalActions o2 = new AnimalActions();
		
		this.setTitle("Create" );
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(300, 400);
		 
		 JPanel panel1 = new JPanel();
		 panel1.setLayout(new BorderLayout());
		 
		 JButton createButton = new JButton("Create");
		 createButton.addActionListener(new ActionListener()
		 {
	            public void actionPerformed(ActionEvent e)
	            {
	            	HappyFarmViewer h = new HappyFarmViewer();
	            	h.animals1.add(animal);
	            }
	        });
		 
		 panel1.add(createButton, BorderLayout.SOUTH);
		 
		 this.add(panel1);
		 this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
