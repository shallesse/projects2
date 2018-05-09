//VehiclPrice1 - Multiple Panels
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VehiclePrice1 extends JFrame implements ActionListener
{
 
  JLabel makeL = new JLabel ("Make :");
  JLabel priceL = new JLabel ("Orig Price:");
  JLabel extrasL = new JLabel ("Extras Price:");
  
  String [] cars = {"None", "Audi", "BMW", "Merc"};
  double [] price = {0, 330000.75, 345000.56, 475000.50};
  
  JComboBox makeC = new JComboBox(cars);
  
  JTextField priceT = new JTextField("", 7);
  JTextField extrasT = new JTextField("", 7);
  
  JButton calcB = new JButton("Calc");
  JButton resetB = new JButton("Reset");

  JTextArea ta = new JTextArea("Vehicle Prices\n\n",5,12);
    
  JPanel pane1 = new JPanel(new GridLayout(3,2));
  JPanel pane2 = new JPanel(new GridLayout(1,2));
  JPanel paneM = new JPanel(new BorderLayout());
    
  public VehiclePrice1()
  {
    super("Vehicle Price Quote");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    pane1.add(makeL);	
    pane1.add(makeC);
              
    pane1.add(priceL);	
    pane1.add(priceT);	
    
    pane1.add(extrasL);	
    pane1.add(extrasT);	
   
    pane2.add(calcB);  
    pane2.add(resetB);
       
    makeC.addActionListener(this);
    calcB.addActionListener(this);
	resetB.addActionListener(this);
	
	paneM.add("North",pane1);
	paneM.add("Center",ta);
	paneM.add("South",pane2);
		
    setContentPane(paneM);     
  }

   
    public static void main(String[] args)
    {
      VehiclePrice1 aFrame = new VehiclePrice1();
      aFrame.setSize(220,250);
      aFrame.setVisible(true);
      aFrame.setResizable(false);
    }

    public void actionPerformed(ActionEvent e)
	{
	  
	  Object source = e.getSource();

      if (source == makeC) 
	    {
	      int pos = makeC.getSelectedIndex();
	      priceT.setText(""+ price[pos]);
	    } 
	    
	    
	  else if (source == calcB)
	   {
         
	     double newprice = Double.parseDouble(priceT.getText()) + Double.parseDouble(extrasT.getText());
	     String make = "" + makeC.getSelectedItem();
	     ta.append("Make: "+make+"\nPrice: R "+ newprice+ "\n");
	   } 
	    
	  else if (source == resetB)
	   {	
	  	 priceT.setText("");
		 extrasT.setText("");
		 ta.setText("Vehicle Prices\n\n");
		 makeC.requestFocus();
	   } 
	   
    }
}
