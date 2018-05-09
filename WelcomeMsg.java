import java.awt.*;
import javax.swing.*;

public class WelcomeMsg extends JPanel
{
	
	public void paint(Graphics g)
	{
		
	
		
		Color cusCol = new Color(205,133,63);
		g.setColor(cusCol);
	    int x [] = {200,452,320,90};
		int y [] = {140,140,250,250};
		g.fillPolygon(x,y,4);
		
		g.setColor(Color.black);
		Font f1 =new Font("Tandelle",Font.BOLD,50);
		g.setFont(f1);
		g.drawString("WELCOME",175,200);
		
		
		
		g.setColor(Color.black);
		Font f2 = new Font("Tandelle",Font.BOLD,50);
		g.setFont(f2);
		g.drawString("TO",520,200);
		
		
		
		int x2 [] = {660,720,660};
		int y2 [] = {80,140,140};
		
		int x3 [] = {720,780,720};
		int y3 [] = {80,140,140};
		
		
		int x4 [] = {780,840,780};
		int y4 [] = {80,140,140};
		
		int x5 [] = {720,780,720};
		int y5 [] = {140,200,200};
		
		int x6 [] = {780,840,780};
		int y6 [] = {140,200,200};
		
		int x7 [] = {780,840,780};
		int y7 [] = {200,250,250};
		
		
	
	g.fillPolygon(x2,y2,3);
	g.fillPolygon(x3,y3,3);
	g.fillPolygon(x4,y4,3);
	g.fillPolygon(x5,y5,3);
	g.fillPolygon(x6,y6,3);
	g.fillPolygon(x7,y7,3);	
	
	
	g.setColor(Color.black);
	Font f3 = new Font("Tandelle",Font.BOLD,150);
	g.setFont(f3);
	g.drawString("DUT",840,230);
	
	g.drawRect(250,300,700,300);
	
	g.setColor(Color.blue);
	Font f = new Font("Tandelle",Font.BOLD,200);
	g.setFont(f);
	g.drawString("2",350,580);
	g.fillOval(500,430,150,150);
	g.drawLine(520,420,460,390);
	g.drawLine(460,390,620,390);
	
	
	g.setColor(Color.white);
	g.fillOval(550,450,20,25);
	g.fillOval(575,450,20,25);
	g.fillArc(550,500,50,30,180,180);
	
	g.setColor(Color.black);
	g.fillOval(555,460,10,10);
	g.fillOval(580,460,10,10);
	
	g.setColor(Color.blue);
	Font f4 = new Font("Tandelle",Font.BOLD,50);
	g.drawString("15",650,580);
	
	
	
		
	}
	
	public static void main (String[]args)
	{
	 JFrame frame = new JFrame();
	 frame.getContentPane().add(new WelcomeMsg());
	 frame.setSize(850,550);
	 frame.setVisible(true);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.setTitle("Welcome");	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}