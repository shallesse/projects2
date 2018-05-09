import java.awt.event.*;//buttons you will click 
import javax.swing.*;
import java.text.DecimalFormat;

public class Purchase extends JFrame implements ActionListener
{
	
	JLabel productL = new JLabel("Product");
	JLabel priceL= new JLabel("Price");
	JLabel quantityL = new JLabel("Quantity");
	JLabel codeL = new JLabel("Code");
	JLabel totalL= new JLabel("Total");

	
	
	JTextField productT = new JTextField("",15);
	JTextField priceT = new JTextField("",7);
	JTextField quantityT = new JTextField("",3);
	JTextField codeT = new JTextField("",7);
	JTextField totalT= new JTextField("",7);
	
	JButton btncalc = new JButton("Calc");
	JButton btnreset = new JButton("Reset");
	JButton btnexit = new JButton("Exit");
	
	JPanel pane = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	DecimalFormat twodec = new DecimalFormat("0.00");
	
	public Purchase()//add objects to constructor
	{
		super("Purchase");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pane.add(productL);
		pane.add(priceL);
		pane.add(quantityL);
		pane.add(codeL);
		pane.add(totalL);
		pane.add(productT);
		pane.add(priceT);
		pane.add(quantityT);
		pane.add(codeT);
	    pane.add(totalL);
	    totalT.setEditable(false);
		pane.add(btncalc);
		pane.add(btnreset);
		pane.add(btnexit);
		
		calc.addActionListener(this);
		reset.addActionListner(this);
		exit.addActionListener(this);
	;
		setContentPane(pane);
		
		
	}
	
	public static void main(String[]args)
	{
	Purchase aFrame = new Purchase();
	aFrame.setSize(300,150);
	aFrame.setVisible(true);
	aFrame.setResizable(false);	
		
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source ==btnexit)
			System.exit(0);
	    
		
			  else if(source == btnreset)
			  {
			 productT.setText("");
			  price.setText("");
			  quantityT.setText("");
			  codeT.setText("");
			  totalT.setText("");
			 
			  	
			  	
			  	
			  }
		   else if(source == btncalc)
		{
			double tot,L;
			char code;
			
			tot= Double.parseDouble(priceT.getText());
			
		    *Double.parseDouble(quantityT.getText());
		    
		   
		   code=codeT.getText().charAt(0);
		    
		    switch(codeT)
		    
		    {
		    	
		    	case 'P':case :'p':L=tot*0.08;
		    	break;
		    
		        case 'N': case 'p':L=tot*0.02;
		        break;
		        
		        default : L = tot *0.01;
		        break;
		    	
		    	
		  }
		  tot+=L;
		  
		  totalT.setText("R"+twodec.formal(tot));
		  
		  
		
		
		}
	