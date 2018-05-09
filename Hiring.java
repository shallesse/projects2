import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class Hiring extends JFrame implements ActionListener,ItemListener
{
	JLabel lblVenue = new JLabel("Venue");
	JLabel lblVenueCost = new JLabel("Venue Cost");
	JLabel lblReq = new JLabel("EXTRA REQUIREMENTS");
	JLabel lblVenueHire = new JLabel("DAY OF VENUE HIRE");
	
	String [] venues = {"None","Town Hall","Exam Hall","Small Hall","Seaside Hall"};
	int [] vcost = {0,7500,8400,2300,9600};
	
	JComboBox cmbVenue = new JComboBox(venues);
	
	ButtonGroup bg = new ButtonGroup();
	 
	
	JCheckBox chkDecor = new JCheckBox("Decor");
	JCheckBox chkSound = new JCheckBox("Sound System");
	
	
	JRadioButton radWeekend = new JRadioButton("Weekend", true);
	JRadioButton radWeekday = new JRadioButton("Weekday", false);
	
	JButton btnProcess = new JButton("Process");
	JButton btnClear = new JButton("Clear");
	
	JTextField txtVenueCost = new JTextField("",6);
	
	JTextArea area = new JTextArea("",5,14);
	JScrollPane scroll = new JScrollPane(area,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	                                          ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	
	JPanel pane = new JPanel(new FlowLayout(FlowLayout.LEFT));
	
	DecimalFormat d= new DecimalFormat("R0.00");
	
	double extratot = 0;
	
	public Hiring()
	{
		super("Hire Cost");
		
		pane.add(lblVenue);
		pane.add(cmbVenue);
		pane.add(lblVenueCost);
		pane.add(txtVenueCost);
		txtVenueCost.setEditable(false);
		pane.add(lblReq);
		pane.add(chkDecor);
		pane.add(chkSound);
		pane.add(lblVenueHire);
		
		pane.add(radWeekend);
		pane.add(radWeekday);
		
		bg.add(radWeekend);
		bg.add(radWeekday);
		
		pane.add(scroll);
		
		pane.add(btnProcess);
		pane.add(btnClear);
		
		chkDecor.addItemListener(this);
		chkSound.addItemListener(this);
		
		radWeekend.addActionListener(this);
		radWeekday.addActionListener(this);
		
		btnProcess.addActionListener(this);
		btnClear.addActionListener(this);
		
		cmbVenue.addActionListener(this);
		
		setContentPane(pane);
	}
	
	public  static void main(String [] args)
	{
		JFrame aFrame = new Hiring();
		aFrame.setSize(185,330);
		aFrame.setVisible(true);
		aFrame.setResizable(false);
	}
	
	
	public void itemStateChanged(ItemEvent ie)
	{
		Object item = ie.getItem();
		int state = ie.getStateChange();
		
		
	    if(item == chkDecor)
		{
			if(state == ItemEvent.SELECTED )
			{
			   extratot += 900;	
			}
			
			else
			{
				extratot -= 900;
			}
		}
		
		else if(item == chkSound)
		{
			if(state == ItemEvent.SELECTED)
			{
			   extratot += 1200;
			}
			
			else
			{
				extratot -= 1200;
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Object source = ae.getSource();
		int index = cmbVenue.getSelectedIndex();
		double day = 0;
		
	
		
		if(source == cmbVenue)
		{
		  
		  txtVenueCost.setText(d.format(vcost[index]) + ""); 
		 
		}
		
		else if(source == btnProcess)
		{
			
		 if(radWeekend.isSelected() )
		{
			day += 400;
		}
		
		else if(radWeekday.isSelected()) 
		{
			day += 200;
		}
		
		
		  double finaltot = (vcost[index] + extratot + day); 	
		  	
		  area.append("Venue: " + cmbVenue.getSelectedItem());
		  area.append("\n" + "Venue Cost: " + d.format(vcost[index]));
		  area.append("\n" + "Extras Cost: " + d.format(extratot) );
		  area.append("\n" + "Day Cost: " + d.format(day));
		  area.append("\n" + "Final Hire Cost: " + d.format(finaltot));
		}
		
		else if(source == btnClear)
		{
			cmbVenue.setSelectedIndex(0);
			txtVenueCost.setText("");
		    radWeekend.setSelected(false);
		    radWeekday.setSelected(false);
			chkDecor.setSelected (false);
			chkSound.setSelected(false);
			area.setText("");
		}
	}
	
	
	
	
}
