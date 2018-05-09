import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class subscription extends JFrame implements ActionListener,ItemListener
{
 JLabel lblname= new JLabel("Name:");
 	JLabel lblref = new JLabel("Reference:");
 JLabel lblpackage = new JLabel("Package:");
 JLabel lblfee = new JLabel("Fee:");
 JLabel lbldish = new JLabel("Dish Type:");
 JLabel lblextra = new JLabel("Extras:");
 
 JTextField txtname = new JTextField("",10);
 
 JTextField txtref = new JTextField("",10);

 JTextField txtfee= new JTextField("",10);	
 
 String [] packages = {"Complete","Selected","Budgeted"};
 double [] fees = {400,250,150};
 
 
 JComboBox cmbtype = new JComboBox(packages);
 
 JRadioButton radmild = new JRadioButton("Mild",true);
 
JRadioButton radalu = new JRadioButton("Aluminium",false);
 JRadioButton radstain = new JRadioButton("Stainless Stel",false);
 
 ButtonGroup bg = new ButtonGroup();
 
 
 JCheckBox chkIndian = new JCheckBox("ASTV Indian",false);
 
 JCheckBox chkPortu = new JCheckBox("Portugese",false);
 
 
 JTextArea area = new JTextArea("",5,10);
 JScrollPane scroll = new JScrollPane(area,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                           ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                                           
 JToolBar bar = new JToolBar();
 
 JButton btnReset = new JButton("Reset");
 
 JButton btnDisplay = new JButton("Display");
 JButton btnexit = new JButton("Exit");
 
 
 DecimalFormat d = new DecimalFormat("R0.00");
 
 JPanel grid1 = new JPanel(new GridLayout());
 
 JPanel grid2 = new JPanel(new GridLayout());
 
 JPanel grid3 = new JPanel(new GridLayout());
 
 JPanel grid4 = new JPanel(new GridLayout());
 
 JPanel border = new JPanel(new BorderLayout());
 
 double tot = 0;
 
 public subscription()
 {
  super("Subscription");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  
  grid1.add(lblname);
 	
  grid1.add(txtname);
  
  grid1.add(lblref);
  
  grid1.add(txtref);
  
  grid1.add(lblpackage);
  
  grid1.add(cmbtype);

  grid1.add(lblfee);
  
  grid1.add(txtfee);
  
  
  
  grid2.add(lbldish);
  grid2.add(radmild);
  grid2.add(radalu);
  grid2.add(radstain); 
  	
  	bg.add(radmild);
  bg.add(radalu);
  bg.add(radstain);
  
  
  grid3.add(lblextra);
  grid3.add(chkIndian);
  grid3.add(chkPortu);
   
   
  	grid4.add(scroll);
  	area.setEditable(false);
  	grid4.add(bar);
  	
  	chkIndian.addItemListener(this);
  	chkPortu.addItemListener(this);
  	
  	cmbtype.addActionListener(this);
  	radmild.addActionListener(this);
  	radalu.addActionListener(this);
  	radstain.addActionListener(this);
  	
  	btnDisplay.addActionListener(this);
  	btnReset.addActionListener(this);
  	btnexit.addActionListener(this);
  	
  	border.add("North",grid1);
border.add("West",grid2);
border.add("East",grid3);
border.add("South",grid4);
  	
    setContentPane(border);
  	
  	
  	
  	
  	
 }
 	
public void itemStateChanged(ItemEvent ie)
{
Object item = ie.getItem();
int state= ie.getStateChange();

if(item==chkIndian)
{
if(state==ItemEvent.SELECTED)
{
	tot+=150;
	
}	
else 
{
tot-=150;	
}
}
else 
{
if(state==ItemEvent.SELECTED)
{
tot+=120;	

}	

else
{
tot-=120;	
	
}
}
}	
public void actionPerformed(ActionEvent ae)
{
Object source = ae.getSource();
int index = cmbtype.getSelectedIndex();
String dtype ="";
double ftot = fees[index] + tot;

if(source==cmbtype)
{
txtfee.setText(""+d.format(fees[index]));	
	
}	
else if (source==btnDisplay)
{
	if(radmild.isSelected())
	{
	dtype =radmild.getText();	
		
	}
	else if(radalu.isSelected())
	{
	dtype=radalu.getText();	
	}
	else if(radstain.isSelected())
	{
	dtype= radstain.getText();	
		
	}
area.append("/n"+"Name"+txtname.getText());
area.append("/n"+"Reference"+txtref.getText());

area.append("/n"+"Package"+cmbtype.getSelectedItem());
area.append("/n"+"Dish Type"+dtype);
area.append("/n"+"Package Cost"+d.format(fees[index]));
area.append("/n"+"Extras"+d.format(tot));
area.append("/n"+"Total cost"+d.format(ftot));





}
	else if(source == btnReset)
	{
	txtname.setText("");
	txtref.setText("");
	
	cmbtype.setSelectedIndex(0);
txtfee.setText("");
area.setText("");

chkIndian.setSelected(false);

chkPortu.setSelected(false);
radmild.setSelected(false);
radalu.setSelected(false);
radstain.setSelected(false);
txtname.requestFocus();


	}
	
else if(source==btnexit)
{
	
System.exit(0);	
	
	
	
}


}	

public static void main (String[]args)
{
	
JFrame frame = new subscription();
frame.setSize(270,450);
frame.setVisible(true);
frame.setResizable(false);	
	
	
	
	
	
}
	
	
}	
	
