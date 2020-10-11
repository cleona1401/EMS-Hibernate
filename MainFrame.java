import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
class MainFrame extends JFrame{
Container c;
JButton btnadd,btnview,btnupdate,btndelete;
MainFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());
btnadd=new JButton("ADD");
btnview=new JButton("VIEW");
btnupdate=new JButton("UPDATE");
btndelete=new JButton("DELETE");
c.add(btnadd);
c.add(btnview);
c.add(btnupdate);
c.add(btndelete);
btnadd.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
AddFrame a= new AddFrame();
dispose();
}});
btnview.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
ViewFrame a= new ViewFrame();
dispose();
}});
btnupdate.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
UpdateFrame a= new UpdateFrame();
dispose();
}});
btndelete.addActionListener(new ActionListener()
{
public void actionPerformed(ActionEvent ae)
{
DeleteFrame a= new DeleteFrame();
dispose();
}});
setTitle("E.M.S");
setSize(300,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String args[]){
MainFrame mf=new MainFrame();
}
}
class DbHandler{
public void addStudent(int id,String name,int salary){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=sfact.openSession();
Transaction t=null;
try{
System.out.println("begin");
t=session.beginTransaction();
Student s=new Student();
s.setId(id);
s.setName(name);
s.setSalary(salary);
session.save(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(),"record inserted. ");
System.out.println("end");
}
catch(Exception e){
t.rollback();
JOptionPane.showMessageDialog(new JDialog(),e);
}
finally{
session.close();
}
}
public String getStudent(){
StringBuffer sb=new StringBuffer();
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=sfact.openSession();
try{
System.out.println("begin");
java.util.List<Student> st=new ArrayList<>();
st=session.createQuery("from Student").list();
for(Student su: st)
sb.append("EID: " +su.getId()+ " ENAME: " +su.getName()+ " ESALARY: "+su.getSalary()+"\n");
System.out.println("end");
}
catch(Exception e){
System.out.println("issue "+e);
}
finally{
session.close();
}
return sb.toString();
}
public void UpdateStudent(int id,String name,int salary){
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=sfact.openSession();
Transaction t=null;
try{
System.out.println("begin");
t=session.beginTransaction();
Student s=(Student)session.get(Student.class,id);
if(s!=null){
s.setName(name);
s.setSalary(salary);
session.save(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(),"record updated. ");
}
else{
JOptionPane.showMessageDialog(new JDialog(),"record does not exist ");
}
System.out.println("end");
}
catch(Exception e){
t.rollback();
System.out.println(e);
}
finally{
session.close();
}
}
public void deleteStudent(int id)
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact=cfg.buildSessionFactory();
Session session=sfact.openSession();
Transaction t=null;
try{
System.out.println("begin");
t=session.beginTransaction();
Student s=(Student)session.get(Student.class,id);
if(s!=null){
session.delete(s);
t.commit();
JOptionPane.showMessageDialog(new JDialog(),"record Deleted. ");
}
else{
JOptionPane.showMessageDialog(new JDialog(),"record does not exist ");
}
System.out.println("end");
}
catch(Exception e){
t.rollback();
System.out.println(e);
}
finally{
session.close();
}
}
}