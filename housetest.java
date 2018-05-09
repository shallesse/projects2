import java.awt.*;
import javax.swing.*;

public class housetest extends JPanel
{
	public void paint(Graphics g)
	{
		
int x []={30,150,260};
int y []={155,50,155};

g.setColor(Color.red);
g.fillPolygon(x,y,3);
//rectangle
g.setColor(Color.green);
g.fillRect(55,155,180,190);
//doors
g.setColor(Color.blue);
g.fillRect(160,260,50,83);
//window
g.setColor(Color.orange);
g.fillRect(80,208,55,55);
//TV arial
g.drawLine(230,127,230,65);
g.drawLine(210,70,252,70);
g.drawLine(220,80,246,80);
//welcome mat

g.setColor(Color.gray);
int x4 [] ={160,234,225,150};
int y4 [] ={345,345,365,365};

g.fillPolygon(x4,y4,4);


//second house triangle

int x2 [] = {280,380,497};
int y2 []= {155,50,155};
g.setColor(Color.red);
g.fillPolygon(x2,y2,3);
//rectangle
g.setColor(Color.green);
g.fillRect(295,155,180,190);
//door
g.setColor(Color.blue);
g.fillRect(310,260,50,83);

//window
g.setColor(Color.orange);
g.fillRect(410,208,55,55);

//sun
g.setColor(Color.yellow);
g.fillOval(265,20,50,50);

		
		
		
		
	}
	
	public static void main(String[]args)
	{
	JFrame frame = new JFrame();
	frame.getContentPane().add(new housetest());
	frame.setSize(800,600);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Our Houses");
	
		
	}
	
	
}