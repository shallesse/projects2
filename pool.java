import java.awt.*;
import javax.swing.*;

public class pool extends JPanel
{
	public void paint(Graphics g)
	{
		//triangles
		int x [] = {8,110,110};
		int y [] = {151,108,200};
		
	    int x2 [] = {110,160,215};
	    int y2 [] = {108,5,110};
	    
	    int x3 [] = {215,308,215};
	    int y3 [] = {108,151,200};
	    
	    int x4 [] = {215,160,110};
	    int y4 [] = {205,290,205};
	    
	    g.setColor(Color.yellow);
	    g.fillPolygon(x,y,3);
	    g.fillPolygon(x2,y2,3);
	    g.fillPolygon(x3,y3,3);
	    g.fillPolygon(x4,y4,3);
	    
	    //circle
	    g.setColor(Color.yellow);
	    g.fillOval(110,108,100,100);
	    
	    
	    //roof for house
	    
	     int x5 [] = {420,520,615};
	     int y5 [] = {150,50,150};
	     
	     g.setColor(Color.green);
	     g.fillPolygon(x5,y5,3);
	     
	     //walls
	     
	     g.setColor(Color.orange);
	     g.fillRect(460,150,100,100);
	     
	     
	     //lines
	     g.setColor(Color.blue);
	     g.drawLine(460,200,560,200);
	      g.drawLine(510,150,510,250);
	     
	     
	     //pool
	     
	     
	     int x6 [] = {560,465,60,210};
	     int y6 []= {345,445,445,345};

	     g.setColor(Color.cyan);
	     g.fillPolygon(x6,y6,4);
	    
	    g.setColor(Color.black);
	    Font f1 = new Font("Arial",Font.BOLD,25);
	    g.setFont(f1);
	    g.drawString("POOL",260,405);
	    
	    
		
		
		}
	
	
	public static void main(String[]args)
	{
		
	JFrame frame = new JFrame();
	frame.getContentPane().add(new pool());
	frame.setSize(650,550);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Summer");	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}