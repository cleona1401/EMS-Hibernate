import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
class AddFrame extends JFrame{
	Container c;
	String str="";
	private JButton btnSave,btnBack;
	private JLabel errorlabel,lblId,lblName,lblSal;
	private JTextField txtId,txtName,txtSal;
	AddFrame(){
		c=getContentPane();
		c.setLayout(new FlowLayout());
		lblId= new JLabel("EID");
		lblName = new JLabel("ENAME");
		lblSal = new JLabel("SALARY");
		txtId = new JTextField(20);
		txtName = new JTextField(20);
		txtSal = new JTextField(20);
		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		
		errorlabel = new JLabel("");
		c.add(errorlabel);
		
		c.add(lblId);
		c.add(txtId);
		c.add(lblName);
		c.add(txtName);
		c.add(lblSal);
		c.add(txtSal);
		c.add(btnSave);
		c.add(btnBack);
		
		
		setTitle("Add");
		setSize(300,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		errorlabel.setText(" ");
		btnBack.addActionListener(new ActionListener(){
														public void actionPerformed(ActionEvent ae){
															MainFrame m = new MainFrame();
															dispose();
														}
		});
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
															db.addStudent(id,NAME,sal);
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
															
}
}
		
		