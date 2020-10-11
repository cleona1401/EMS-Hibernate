import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ViewFrame extends JFrame{
Container c;
TextArea ta;
JButton btnback;
ViewFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());

ta=new TextArea(5,30);
btnback=new JButton("BACK");

DbHandler db=new DbHandler();
ta.setText(db.getStudent());

btnback.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
MainFrame a= new MainFrame();
dispose();
}});
c.add(ta);
c.add(btnback);
setTitle("VIEW");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}