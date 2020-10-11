import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class UpdateFrame extends JFrame{
Container c;
JLabel lbleid,lblename,lblsalary;
JTextField txtId,txtName,txtSal;
JButton btnSave,btnBack;
UpdateFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());
lbleid=new JLabel("EID ");
txtId=new JTextField(20);
lblename=new JLabel("ENAME ");
txtName=new JTextField(20);
lblsalary=new JLabel("SALARY  ");
txtSal=new JTextField(20);
btnSave=new JButton("SAVE");
btnBack=new JButton("BACK");
btnBack.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
MainFrame a= new MainFrame();
dispose();
}});
btnSave.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent ae){
									String ID = txtId.getText().toString();
								    String NAME = txtName.getText().toString();
									String SAL = txtSal.getText().toString();
							try{
									if(ID.equals("")){
												JOptionPane.showMessageDialog(null,"Id Cant be Empty!!");
										}
									else if(NAME.equals("")){
										JOptionPane.showMessageDialog(null,"Name Cant be Empty!!");
										}
									else if(SAL.equals("")){
									JOptionPane.showMessageDialog(null,"Salary Cant be Empty!!");
									}
										else if(Integer.valueOf(ID) < 0){
											JOptionPane.showMessageDialog(null,"Employee ID cant be negative");
											txtId.setText("");
											txtId.requestFocus();
											}
										else if(NAME.length() <2){
											JOptionPane.showMessageDialog(null,"Enter a Valid Employee Name");
											txtName.setText("");
											txtName.requestFocus();
											}
										else if(Integer.valueOf(SAL) <8000){
											JOptionPane.showMessageDialog(null,"Salary should be greater than 8000");
											txtSal.setText("");
											txtSal.requestFocus();
											}
									else{
										if(ID.matches("^[0-9]{1,12}$") && NAME.matches("^[a-zA-Z]*$") && SAL.matches("[0-9]{1,12}$"))
										{
										                    			DbHandler db = new DbHandler();
															int id = Integer.parseInt(ID);
															int sal =Integer.parseInt(SAL);
															db.UpdateStudent(id,NAME,sal);
															txtId.setText("");
															txtId.requestFocus();
															txtName.setText("");
															txtSal.setText("");
		
										
										}
										else if(!(ID.matches("^[0-9]{1,12}$"))){
											JOptionPane.showMessageDialog(null,"please enter only integers");
											txtId.setText("");
											txtId.requestFocus();
											}
										else if(!(NAME.matches("^[a-zA-Z]*$"))){
											JOptionPane.showMessageDialog(null,"please enter only characters");
											txtName.setText("");
											txtName.requestFocus();
										}
										else if(!(SAL.matches("[0-9]{1,12}$"))){
										JOptionPane.showMessageDialog(null,"Salary should be greater than 8000");
											txtSal.setText("");
											txtSal.requestFocus();
										}
								}
							}
							catch(Exception e){
							JOptionPane.showMessageDialog(null,e);
							}
															
				}
		});
						
c.add(lbleid);
c.add(txtId);
c.add(lblename);
c.add(txtName);
c.add(lblsalary);
c.add(txtSal);
c.add(btnSave);
c.add(btnBack);
setTitle("UPDATE");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}
 