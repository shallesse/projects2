import java.awt.*;
import javax.swing.*;

public class pictures extends JPanel
{
	public void paint(Graphics g)
	{
	g.setColor(Color.yellow);
	
	int x[] = {0,100,100};
	int y[]={150,100,200};
	g.fillPolygon(x,y,3);
	
	int x2 [] = {100,150,200};
	int y2[] = {100,0,100};
	
	g.fillPolygon(x2,y2,3);
	
	int x3 [] = {200,300,200};
	int y3[] = {100,150,200};
			g.fillPolygon(x3,y3,3);
		
		int x4 []={100,200,150};
		int y4 [] = {200,200,300};
		
		g.fillPolygon(x4,y4,3);
		
		g.fillOval(100,100,100,100);
		
		
		g.setColor(Color.green);
			
		int x5 []={400,500,600};
		int y5 [] = {150,50,150};
		g.fillPolygon(x5,y5,3);
		
			g.setColor(Color.orange);
			
			g.fillRect(450,150,100,100);
			
			
		g.setColor(Color.blue);
		g.drawLine(450,200,550,200);
		g.drawLine(500,150,500,250);
		
		g.setColor(Color.cyan);
		int a [] = {50,200,550,450};
		int b [] = {450,350,350,450};
		
g.fillPolygon(a,b,4);

g.setColor(Color.black);
g.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,45));
g.drawString("Pool",250,410);


		
	
		
		
		
	} 
	
public static void main(String[]args)
{
JFrame frame = new JFrame();
frame.getContentPane().add(new pictures());
frame.setSize(650,550);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setTitle("Summer");
	
	
	
	
}	
	}