import java.awt.Color ;
import java.awt.Dimension ;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;
import java.beans.Visibility;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import static java.lang.System.out;


// login content 
class Myframe extends JFrame implements ActionListener {

Container c ; 


JLabel label1 ,label2 ;
JTextField user ;
JPasswordField pass ;
JButton btn ;
JButton btn2 ;

 public void actionPerformed(ActionEvent e) {

    if(e.getSource()==btn2){
        visibilityOff();
        RegistrationForm both = new RegistrationForm() ;
    }else if(e.getSource()==btn){

       if((user.getText()).equals("")||(pass.getText()).equals(""))
       JOptionPane.showMessageDialog(null,"Fields are empty ");
        else{
            Validation v = new Validation();
            v.val(user.getText(), pass.getText());
        }
         
            
         
         
         

    }
  

    }




public void visibilityOnn(){
    setVisible(true);
}

public   void visibilityOff(){
    setVisible(false);
}

Myframe(){//40,40,380,600

setTitle("Login Form");

setSize(380,600);
setResizable(false);
setLocation(100 ,100);
setDefaultCloseOperation(EXIT_ON_CLOSE);

getContentPane().setBackground(new Color(135,175,175));
c=getContentPane();
c.setLayout(null);

label1 = new JLabel("USERNAME");
label2 = new JLabel("PASSWORD");	

label1.setBounds(30,80,100,20);
label2.setBounds(30,150,100,20);

label1.setForeground(Color.black);


label2.setForeground(Color.black);
c.add(label1);
c.add(label2);


user = new JTextField();
user.setForeground(Color.red);
//user.setFont(new Font("Times New Roman" ,Font.BOLD ,15));
user.setBackground(new Color(255,239,213));
user.setBounds(180,80,120,20);
c.add(user);

pass = new JPasswordField();
pass.setForeground(Color.red);
//pass.setFont(new Font("Times New Roman" ,Font.BOLD ,20));
pass.setBackground(new Color(255,239,213));
pass.setBounds(180,130,120,20);

c.add(pass);

btn = new JButton("Login");
btn.setBounds(250,220,80,25);
btn.setForeground(Color.black);
//btn.setFont(new Font("Times New Roman" ,Font.BOLD ,15));

btn.setBackground(new Color(132,86,60));
btn.addActionListener(this);
c.add(btn);


btn2 = new JButton("signup");
btn2.setBounds(120,220,80,25);
btn2.setForeground(Color.black);
btn2.setFont(new Font("Times New Roman" ,Font.BOLD ,15));

btn2.setBackground(new Color(132,86,60));
btn2.addActionListener(this);
c.add(btn2);



setVisible(true);




}
 



}

class Validation extends JFrame{
    JFrame  frame=new JFrame();
   

    public void val(String username ,String password ){

    try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Fact_hatch@123");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from e1");
   
            

int flag =0 ;
             while(rs.next()){
       if(username.equals(rs.getString(7))){
                flag = 1 ;
               break ;
       }

             }
   

             if(flag ==0)
             JOptionPane.showMessageDialog(null,"No such user found  ! ");
   else  if( flag ==1 && (!password.equals(rs.getString(4)))){
        JOptionPane.showMessageDialog(null,"entered Password is wrong ! ");
    } else  if( flag ==1 && password.equals(rs.getString(4))){
        
        Myframe fr = new Myframe();
        fr.visibilityOff();
       
         ChatClient.start(); 
        
         //chat.main();
         
    }

}catch(Exception e){

}

     }
}




class RegistrationForm implements ActionListener {
    JFrame  frame=new JFrame();
    String[] gender={"Male","Female"};
    JLabel nameLabel=new JLabel("NAME");
    JLabel genderLabel=new JLabel("GENDER");
    JLabel fatherNameLabel=new JLabel("FATHER NAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
    JLabel cityLabel=new JLabel("CITY");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JTextField fatherTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField cityTextField=new JTextField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");

    public void visibilityOff(){
        
    }
 
 
    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
   
    public void createWindow()
    {
       
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);
        genderLabel.setBounds(20,70,80,70);
        fatherNameLabel.setBounds(20,120,100,70);
        passwordLabel.setBounds(20,170,100,70);
        confirmPasswordLabel.setBounds(20,220,140,70);
        cityLabel.setBounds(20,270,100,70);
        emailLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
        genderComboBox.setBounds(180,93,165,23);
        fatherTextField.setBounds(180,143,165,23);
        passwordField.setBounds(180,193,165,23);
        confirmPasswordField.setBounds(180,243,165,23);
        cityTextField.setBounds(180,293,165,23);
        emailTextField.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(genderLabel);
        frame.add(fatherNameLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(cityLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(genderComboBox);
        frame.add(fatherTextField);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(cityTextField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==registerButton)
        {
            try {
                //Creating Connection Object
                  Class.forName("com.mysql.jdbc.Driver");  
                  Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","Fact_hatch@123");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into  E1 values(?,?,?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,genderComboBox.getSelectedItem().toString());
                Pstatement.setString(3,fatherTextField.getText());
                Pstatement.setString(4,passwordField.getText());
                Pstatement.setString(5,confirmPasswordField.getText());
                Pstatement.setString(6,cityTextField.getText());
                Pstatement.setString(7,emailTextField.getText());
                //Checking for the Password match


                if((nameTextField.getText()).equals("")||(fatherTextField.getText()).equals("")||(passwordField.getText()).equals("")||(confirmPasswordField.getText()).equals("")||(cityTextField.getText()).equals("")){
                    JOptionPane.showMessageDialog(null,"please enter all the Fields ");
                }

                else if(!(emailTextField.getText()).contains("@")){

                    JOptionPane.showMessageDialog(null,"please enter a valid email ");
                }
               else  if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText()))
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    Myframe fr = new Myframe();
                    fr.visibilityOnn();
                    //frame.setVisible(false);
                    frame.dispose();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                      
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }
 
            } catch (Exception e1) {
                e1.printStackTrace();
            }
 
 
        }
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            nameTextField.setText("");
            genderComboBox.setSelectedItem("Male");
            fatherTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            cityTextField.setText("");
            emailTextField.setText("");
        }
 
    }

    
}

public class Loginpage{
public static void main(String args[]){
         Myframe f = new Myframe();
    }


}




class  ChatClient extends JFrame implements ActionListener {
    String uname;
    PrintWriter pw;
    BufferedReader br;
    JTextArea  taMessages;
    JTextField tfInput;
    JButton btnSend,btnExit;
    Socket client;
    
    public ChatClient(String uname,String servername) throws Exception {
        super(uname);  // set title for frame
        this.uname = uname;
        client  = new Socket(servername,1010);
        br = new BufferedReader( new InputStreamReader( client.getInputStream()) ) ;
        pw = new PrintWriter(client.getOutputStream(),true);
        pw.println(uname);  // send name to server
        buildInterface();
        new MessagesThread().start();  // create thread to listen for messages
    }
    
    public void buildInterface() {
        btnSend = new JButton("Send");
        btnExit = new JButton("Exit");
        taMessages = new JTextArea();
        taMessages.setRows(25);
        taMessages.setColumns(20);
        taMessages.setEditable(false);
        tfInput  = new JTextField(20);
        JScrollPane sp = new JScrollPane(taMessages, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sp,"Center");
        JPanel bp = new JPanel( new FlowLayout());
        bp.add(tfInput);
        bp.add(btnSend);
        bp.add(btnExit);
        add(bp,"South");
        btnSend.addActionListener(this);
        btnExit.addActionListener(this);
        bp.setSize(300,500);
       taMessages.setBackground(Color.ORANGE);
        taMessages.setForeground(Color.BLACK);
        Font font = new Font("segeo Script" ,Font.BOLD ,15);
        bp.setAutoscrolls(false);
        taMessages.setFont(font);
        setVisible(true);
        pack();
    }
    
    public void actionPerformed(ActionEvent evt) {
        if ( evt.getSource() == btnExit ) {
            pw.println("end");  // send end to server so that server knows about the termination
            System.exit(0);
        } else {
            // send message to server
            pw.println(tfInput.getText());
        }
    }
    
    public static void start() {
    
        // take username from user
        String name = JOptionPane.showInputDialog(null,"Enter your name :", "Username",
             JOptionPane.PLAIN_MESSAGE);
        String servername = "localhost";  
        try {
            new ChatClient( name ,servername);
        } catch(Exception ex) {
            out.println( "Error --> " + ex.getMessage());
        }
        
    } // end of main
    
    // inner class for Messages Thread
    class  MessagesThread extends Thread {
        public void run() {
            String line;
            try {
                while(true) {
                    line = br.readLine();
                    taMessages.append(line + "\n");
                } // end of while
            } catch(Exception ex) {}
        }
    }
} //  end of client