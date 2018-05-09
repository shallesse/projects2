import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Satallite extends JFrame implements ActionListener,ItemListener
{
	
	JLabel lblName = new JLabel ("Name");
	JLabel lblRef = new JLabel ("Reference No.");
	JLabel lblPackage = new JLabel ("Package Type");
	JLabel lblFee = new JLabel ("Fee");
	JLabel lblDishType = new JLabel ("Dish Type");
	JLabel lblExtras = new JLabel ("Extras");
	
	JTextField txtName = new JTextField("",5);
	JTextField txtRef = new JTextField("",5);
	JTextField txtFee = new JTextField("",5);
	
	JRadioButton radSteel = new JRadioButton("Mild Steel",true);
	JRadioButton radAlu = new JRadioButton("Aluminium",false);
	JRadioButton radStain = new JRadioButton("Stainless Steel",false); 
	
	ButtonGroup bg = new ButtonGroup();
	
	JCheckBox chkIndian = new JCheckBox("ASTv South Indian",false);
	JCheckBox chkPortu = new JCheckBox("ASTv Portuguese",false);
	
	JTextArea area = new JTextArea("",5,10);
	JScrollPane scroll = new JScrollPane(area, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	                                           ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String [] packages = {"Complete","Selected","Budget"};
	double [] fees = {400,120,150};
	
	JComboBox cmbType = new JComboBox(packages);
	
	JToolBar bar = new JToolBar();
	
	
	JButton btnDisplay = new JButton("Display Info");
	JButton btnReset = new JButton("Reset Fields");
	JButton btnExit = new JButton("Exit");
	
	DecimalFormat d = new DecimalFormat("R0.00");
	
	JPanel grid1 = new JPanel(new GridLayout(4,2));
	JPanel grid2 = new JPanel(new GridLayout(4,1));
	JPanel grid3 = new JPanel(new GridLayout(3,1));
	JPanel grid4 = new JPanel(new GridLayout(2,1));
	JPanel border = new JPanel (new BorderLayout());
	
	double tot = 0; 
	
     public Satallite ()
     {
	    super("Astv Subscription Quotation");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    grid1.add(lblName);
	    grid1.add(txtName);
	    grid1.add(lblRef);
	    grid1.add(txtRef);
	    grid1.add(lblPackage);
	    grid1.add(cmbType);
	    grid1.add(lblFee);
	    grid1.add(txtFee);
	    txtFee.setEditable(false);
	    
	    grid2.add(lblDishType);
	    grid2.add(radSteel);
	    grid2.add(radAlu);
	    grid2.add(radStain);
	    
	    
	    bg.add(radSteel);
	    bg.add(radAlu);
	    bg.add(radStain);
	    
	    grid3.add(lblExtras);
	    grid3.add(chkIndian);
	    grid3.add(chkPortu);
	    
	    
	    bar.add(btnDisplay);
	    bar.add(btnReset);
	    bar.add(btnExit);
	    
	    
	    
	    grid4.add(scroll);
	    area.setEditable(false);
	    grid4.add(bar);
	    
	    
	    chkIndian.addItemListener(this);
	    chkPortu.addItemListener(this);
	    
	    cmbType.addActionListener(this);
	    
	    radSteel.addActionListener(this);
	    radAlu.addActionListener(this);
	    radStain.addActionListener(this);
	    
	 	btnDisplay.addActionListener(this);
	    btnReset.addActionListener(this);
	    btnExit.addActionListener(this);
	   
	    border.add("North",grid1);
	    border.add("West",grid2);
	    border.add("East",grid3);
	    border.add("South",grid4);
	    //border.add("South",scroll);
	    //border.add("South",bar);
	    
	    setContentPane(border);
	    
	    
     }
	
	
	public void itemStateChanged(ItemEvent ie)
	{
		Object item = ie.getItem();
		
		int state = ie.getStateChange();
		
		if(item == chkIndian)
		{
			if(state == ItemEvent.SELECTED)
			{
				tot += 150;
			}
			
			else
			{
				tot -= 150;
			}
		}
		
		else
		{
			if(state == ItemEvent.SELECTED)
			{
				tot += 120;
			}
			
			else
			{
			    tot -= 120;	
			}
		}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		int index = cmbType.getSelectedIndex();
		String dType = "";
		double fTot = fees[index] + tot;
		
		if(source == cmbType)
		{
			
			txtFee.setText(""+ d.format(fees[index]));
			
		}
		
		 
		  
		  else if(source == btnDisplay)
		  {
			if(radSteel.isSelected())
		    {
		      dType = radSteel.getText();
		    }
		
		    else if(radAlu.isSelected())
		    {
			  dType = radAlu.getText();
		    }
		 
		    else if(radStain.isSelected())
		    {
			  dType = radStain.getText();
		    }
			
			
			area.append("\n"+"Name:" + txtName.getText());
			area.append("\n"+"Reference No: " + txtRef.getText());
			area.append("\n"+"Package Type: " + cmbType.getSelectedItem());
			area.append("\n"+"Dish Type: " + dType);
			area.append("\n"+"Package Cost: " + d.format(fees[index]));
			area.append("\n"+"Extras Cost: " + d.format(tot));
			area.append("\n"+"Total Cost: " + d.format(fTot));
		}
		
		else if (source == btnReset)
		{
			txtName.setText("");
			txtRef.setText("");
			
			cmbType.setSelectedIndex(0);
			txtFee.setText("");
			area.setText("");
			chkIndian.setSelected(false);
			chkPortu.setSelected(false);
			radSteel.setSelected(true);
			radAlu.setSelected(false);
			radStain.setSelected(false);
			txtName.requestFocus();
			
			
			
		}
		
		else if(source == btnExit)
		{
			System.exit(0);
		}
		
	}
	
	
	
	public static void main(String[] args)
	{
	   JFrame aframe = new Satallite();
	   aframe.setSize(270,450);
	   aframe.setVisible(true);
	   aframe.setResizable(false);
	}
}