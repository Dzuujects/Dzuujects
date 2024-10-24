package package1;

import javax.swing.JFrame;

public class AnimalSelectionFrame extends JFrame {
	
    public void FrameOne() {
          JFrame frame1 = new JFrame();
          Create frame = new Create(new Sheep(50, 100));//Change the values to what u want sheepx and sheepy to be
    }

    public void FrameTwo() {
          JFrame frame1 = new JFrame();
          Create frame = new Create(new Cow(50, 50));
    }
    public void Frame3() {
          JFrame frame1 = new JFrame();
          frame1.setSize(300, 400);
          frame1.setTitle("3");
          frame1.setVisible(true);
    }

    public void Frame4()
    {
    	JFrame frame1 = new JFrame();
        Create frame = new Create(new Chicken(50, 100));
    }
    public void Frame5() {
    	JFrame frame1 = new JFrame();
        Create frame = new Create(new Horse(300, 50));
    }

    public void Frame6() {
          JFrame frame1 = new JFrame();
          frame1.setSize(300, 400);
          frame1.setTitle("6");
          frame1.setVisible(true);
    }
    public void Frame7() {
          JFrame frame1 = new JFrame();
          frame1.setSize(300, 400);
          frame1.setTitle("7");
          frame1.setVisible(true);
    }
}
