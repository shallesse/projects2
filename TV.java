import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;

public class TV extends JFrame implements ActionListener,ItemListener
{
 JLabel quoteL = new JLabel("Quote#:");	
	
 JTextField quoteT = new JTextField("",8);
 JLabel sizeL = new JLabel("Size:");
 String [] size = {"Select one","32 inch","42 inch","46 inch","55 inch"};
 double [] price = {0,3899.95,9600,12999,19995};
 
 JComboBox tvcmb = new JComboBox(size);
 
JLabel priceL = new JLabel("Price:");
JTextField priceT = new JTextField("",8);	
	

	JLabel empty1 = new JLabel("");
	JLabel empty2 = new JLabel("");
	
	
	
	JLabel type = new JLabel("Type:");
	JLabel extras =new JLabel("Extras:");
	
	JRadioButton radhd = new JRadioButton("HD Ready",true);
	
	JRadioButton radfull = new JRadioButton("Full HD",false);
	
	JRadioButton rad3d = new JRadioButton("3D",false);
	
	JCheckBox chkwarranty = new JCheckBox("Extended warranty",false);
	
	JCheckBox chkdelivery = new JCheckBox("Delivery",false);
	JCheckBox chk3d = new JCheckBox("3D Glasses",false);
	
	
	JTextArea area = new JTextArea("",6,10);
	JScrollPane scroll = new JScrollPane(area,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
	ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	Font f = new Font("TimesRoman",Font.BOLD,14);
	
	JToolBar bar = new JToolBar();
	
	JButton display = new JButton("Display");
	JButton reset = new JButton("Reset");
	JButton exit = new JButton("Exit");
	 ButtonGroup bg = new ButtonGroup();
	 
	 JPanel pane1 = new JPanel(new GridLayout(8,2));
	 JPanel paneM = new JPanel(new BorderLayout());
	 
	 double tot = 0;
	 double newp=0;
	 
	double extrasp = 0;
	int num = 1;
	 String  type1 ="";
	
	 
	 public TV()
	 {
	 
	 super("aL Gee TV");
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 pane1.add(quoteL);	
	 	
	 pane1.add(quoteT);
	 pane1.add(sizeL);
	 pane1.add(tvcmb);
	 pane1.add(priceL);
	 
	 pane1.add(priceT);
	 priceT.setEditable(false);
	 
	 pane1.add(empty1);
	 
	 pane1.add(empty2);
	 
	 
	 pane1.add(type);
	 
	 pane1.add(extras);
	 pane1.add(radhd);
	 
	 pane1.add(chkwarranty);
	 pane1.add(radfull);
	 
	 pane1.add(chkdelivery);
	 
	 pane1.add(rad3d);
	 
	 pane1.add(chk3d);
	 
	 bar.add(reset);
	 bar.add(exit);
	 bar.add(display);
	 
	 paneM.add("North",pane1);
	 paneM.add("Center",scroll);
	 paneM.add("South",bar);
	 
	 
	 	area.setFont(f);
	 	
	 	
	 	radhd.addActionListener(this);
	 	
	 	radfull.addActionListener(this);
	 	rad3d.addActionListener(this);
	 	reset.addActionListener(this);
	 	display.addActionListener(this);
	 	exit.addActionListener(this);
	tvcmb.addItemListener(this);	 	
	 	
	 	chkwarranty.addItemListener(this);
	 		chkdelivery.addItemListener(this);
	 			chk3d.addItemListener(this);
	 			
	 			setContentPane(paneM);
	 			
	 			

	 	
	 	
	 	
	 	
	 	
	 }
	public static void main(String[]args)
	{
TV aFrame= new TV();
aFrame.setSize(350,450);
aFrame.setVisible(true);
aFrame.setResizable(false);
		
		
		
		
		
}
public void actionPerfor med(ActionEvent e)
{
Object source = e.getSource();
int pos = tvcmb.getSelectedIndex();

quoteT.setText(""+num);

if(source==display)
{
double tot = Double.parseDouble(priceT.getText());
double finalp = tot+extrasp;
area.append("Quote No:\t"+quoteT.getText()+
"\nSize\t"+tvcmb.getSelectedItem()+"\nType"+type+"\nPrice:\t"+priceT.getText()+"\nExtras:\tR"+extrasp+"\nTotal\tR"+finalp);
	
	
	
	
}	

else if(source == tvcmb)
{
priceT.setText(""+price[pos]);
radhd.setSelected(true);
	
	
	
}
else if(source==radhd)
{
	type1= "HD Ready";
priceT.setText(""+price[pos]);
	
	
	
}
else if (source==radfull)
{
type1="Full HD";
tot = price[pos];
newp= tot+(tot*0.25);
priceT.setText(""+price[pos]);
	
	
	
	
}
else if(source==rad3d)
{
type1="3D HDTV";
tot=price[pos];
newp=tot+(tot*0.60);
priceT.setText(""+newp);
	
	
	
}
	
else if(source==exit)
{
	System.exit(0);
	
	
	
	
	}	
else if(source==reset)
{
quoteT.setText("");
tvcmb.setSelectedIndex(0);
priceT.setText("");
radhd.setSelected(true);
radfull.setSelected(false);
rad3d.setSelected(false);
	
chkwarranty.setSelected(false);
chkdelivery.setSelected(false);
chk3d.setSelected(false);
area.setText("");
quoteT.requestFocus();
	
	
}


}
	
public void itemStateChanged(ItemEvent ie)
{
Object item=ie.getItem();

int state= ie.getStateChange();

if(item==chkwarranty)
if(state==ItemEvent.SELECTED)
extrasp=extrasp+1000;
else
extrasp=extrasp-1000;

if(item==chkdelivery)
if(state==ItemEvent.SELECTED)
extrasp=extrasp+350;
else
extrasp=extrasp-350;

if(item==chk3d)
if(state==ItemEvent.SELECTED)
extrasp=extrasp+1650;
else
extrasp=extrasp-1650;


	
	
}	
	
	
	
	
}