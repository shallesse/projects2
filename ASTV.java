import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;


public class ASTV extends JFrame implements ActionListener,ItemListener
{
JLabel Namel = new JLabel("Name:");
JLabel Referencel = new JLabel("Reference:");
JLabel Packagel = new JLabel("Package:");
JLabel Feel = new JLabel("Fee:");
JLabel DishTypel = new JLabel("Dish Type:");
JLabel ExtrasL = new JLabel("Extras");


JTextField txtName =  new JTextField("",15);

JTextField txtRef =  new JTextField("",15);

JTextField txtFee =  new JTextField("",15);	


JRadioButton radmild = new JRadioButton("Mild Steel",true);

JRadioButton radAlu = new JRadioButton("Aluminium",false);
JRadioButton radStain = new JRadioButton("Stainless",false);

ButtonGroup bg = new ButtonGroup();

JCheckBox chkIndian = new JCheckBox("Astv South Indian",false);

JCheckBox chkPortu = new JCheckBox("Astv Portugese",false);

JTextArea area = new JTextArea("",5,10);
JScrollPane scroll = new JScrollPane(area,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                                          ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
                                          
String [] packages = {"Complete","Selected","Budget"};
double [] fees = {400,120,150};


JComboBox cmbType = new JComboBox(packages);


JToolBar tb = new JToolBar();

JButton btnReset = new JButton("Reset");

JButton btnDisplay = new JButton("Display Info");

JButton btnExit= new JButton("Exit");

DecimalFormat twodec = new DecimalFormat("R0.00");

JPanel grid1= new JPanel(new GridLayout(4,2));
JPanel grid2= new JPanel(new GridLayout(4,1));
JPanel grid3= new JPanel(new GridLayout(3,1));	
JPanel grid4= new JPanel(new GridLayout(2,1));

JPanel border = new JPanel(new BorderLayout());

double tot = 0;

	


public ASTV ()
{
	
	
super("ASTV Subscription Quotation");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

grid1.add(Namel);
grid1.add(txtName);
grid1.add(Referencel);
grid1.add(txtRef);
grid1.add(Packagel);
grid1.add(cmbType);
grid1.add(Feel);
grid1.add(txtFee);
txtFee.setEditable(false);

grid2.add(DishTypel);
grid2.add(radmild);
grid2.add(radAlu);
grid2.add(radStain);

bg.add(radmild);
bg.add(radAlu);
bg.add(radStain);

grid3.add(ExtrasL);
grid3.add(chkIndian);
grid3.add(chkPortu);

tb.add(btnDisplay);
tb.add(btnReset);
tb.add(btnExit);


grid4.add(scroll);
area.setEditable(false);
grid4.add(tb);

chkIndian.addItemListener(this);
chkPortu.addItemListener(this);

cmbType.addActionListener(this);


radmild.addActionListener(this);
radAlu.addActionListener(this);
radStain.addActionListener(this);

btnDisplay.addActionListener(this);
btnReset.addActionListener(this);
btnExit.addActionListener(this);

border.add("North",grid1);
border.add("West",grid2);
border.add("East",grid3);
border.add("South",grid4);

setContentPane(border);

	
}

public void itemStateChanged(ItemEvent ie)
{
	
Object item = ie.getItem();
 int state =ie.getStateChange();
 
 if(item == chkIndian)
 	if(state == ItemEvent.SELECTED)
 	  tot +=150;
    else 
      tot-=150;	
 	
 	
 

 
 {
 if(state == ItemEvent.SELECTED)
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
		int index= cmbType.getSelectedIndex();
		String dType ="";
		double ftot = fees[index] + tot;
		
		if(source == cmbType)
		{
			
			txtFee.setText(""+ twodec.format(fees[index]));
			
			
			}
		
	else if (source == btnDisplay)
	{
		if(radmild.isSelected())
		{
		dType =radmild.getText();	
		}
		else if(radAlu.isSelected())
		{
			
		dType = radAlu.getText();	
		}
		else if(radStain.isSelected())
		{
			dType=radStain.getText();
		}
		area.append("/n"+"Name:"+txtName.getText());//  \n
		area.append("/n"+"Reference:"+txtRef.getText());
		area.append("/n"+"Package:"+cmbType.getSelectedItem());
		area.append("/n"+"Dish Type:"+dType);
		area.append("/n"+"Package Cost:"+twodec.format(fees[index]));
		area.append("/n"+"Extras Cost:"+twodec.format(tot));
		area.append("/n"+ "Total Cost:"+twodec.format(ftot));
		
		
		
		
		
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
radmild.setSelected(false);
radAlu.setSelected(false);
radStain.setSelected(false);
txtName.requestFocus();
	
	
}
else if(source== btnExit)
{
System.exit(0);	
	
}
	}
	
public static void main(String[]args)
{
JFrame aframe = new ASTV();
aframe.setSize(270,450);
aframe.setVisible(true);
aframe.setResizable(false);	
	
	
}
	
	
	
	

	
}