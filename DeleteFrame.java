import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DeleteFrame extends JFrame{
Container c;
JLabel lbleid;
JTextField txteid;
JButton btnback;
JButton btnsave;
DeleteFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());

lbleid=new JLabel("EID");
txteid=new JTextField(20);
btnback=new JButton("BACK");
btnsave=new JButton("SAVE");
btnback.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
MainFrame a= new MainFrame();
dispose();
}});
btnsave.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
int id=0;
try{
id=Integer.parseInt(txteid.getText());
if(id<0)
{
txteid.setEditable(false);
JOptionPane.showMessageDialog(new JDialog(),"employee id should consist of only numbers. ");
txteid.setEditable(true);
txteid.setText("");
}
else
{
DbHandler db=new DbHandler();
db.deleteStudent(id);
}
}
catch(NumberFormatException nfe)
{
txteid.setEditable(false);
JOptionPane.showMessageDialog(new JDialog(),"PLEASE ENTER ONLY POSITIVE INTEGERS ");
txteid.setEditable(true);
txteid.setText("");
}
}
});
c.add(lbleid);
c.add(txteid);
c.add(btnsave);
c.add(btnback);
setTitle("DELETE");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}