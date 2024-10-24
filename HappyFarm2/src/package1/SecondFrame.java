package package1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SecondFrame extends JFrame implements ActionListener{
    
    private JFrame newFrame;
    
    public SecondFrame() {
        newFrame = new JFrame("Animal Selector");
        newFrame.setSize(300,300);
        JButton button1 = new JButton("Sheep");
        JButton button2 = new JButton("Cow");
        JButton button3 = new JButton("Pig");
        JButton button4 = new JButton("Chicken");
        JButton button5 = new JButton("Horse");
        JButton button6 = new JButton("Fish");
        JButton button7 = new JButton("Bird");
        button1.addActionListener(new ActionListener(){  
              public void actionPerformed(ActionEvent e){  
                          AnimalSelectionFrame test = new AnimalSelectionFrame();
                          test.FrameOne();
                          dispose();
                      }  
                  });
        button2.addActionListener(new ActionListener(){  
              public void actionPerformed(ActionEvent e){  
                          AnimalSelectionFrame test = new AnimalSelectionFrame();
                          test.FrameTwo();
                          dispose();
                      }  
                  });
        button3.addActionListener(new ActionListener(){  
              public void actionPerformed(ActionEvent e){  
                          AnimalSelectionFrame test = new AnimalSelectionFrame();
                          test.Frame3();
                          dispose();
                      }  
                  });
        button4.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        AnimalSelectionFrame test = new AnimalSelectionFrame();
                        test.Frame4();
                        dispose();
                    }  
                });
      button5.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        AnimalSelectionFrame test = new AnimalSelectionFrame();
                        test.Frame5();
                        dispose();
                    }  
                });
      button6.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        AnimalSelectionFrame test = new AnimalSelectionFrame();
                        test.Frame6();
                        dispose();
                    }  
                });
      
      button7.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                        AnimalSelectionFrame test = new AnimalSelectionFrame();
                        test.Frame7();
                        dispose();
            			}
                    });  
      
            JPanel panel1 = new JPanel();
            panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
            panel1.add(button1);
            panel1.add(button2);
            panel1.add(button3);
            panel1.add(button4);
            panel1.add(button5);
            panel1.add(button6);
            panel1.add(button7);
            Dimension buttonSize = new Dimension(100, 50);
            button1.setPreferredSize(buttonSize);
            button2.setPreferredSize(buttonSize);
            button3.setPreferredSize(buttonSize);
            button4.setPreferredSize(buttonSize);
            button5.setPreferredSize(buttonSize);
            button6.setPreferredSize(buttonSize);
            button7.setPreferredSize(buttonSize);
            newFrame.add(panel1);
            
        }
        
        public void display() {
            newFrame.setVisible(true);
        }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }

    }