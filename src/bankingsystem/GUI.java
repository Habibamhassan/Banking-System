package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    JFrame login;
    JLabel l_username, l_password, l_loginError;
    JTextField tf_username, tf_password;
    JButton login_btn;
 
    JFrame account;
    
    //profile tab 
    JLabel l_name, l_dob, l_nationality, l_gender, l_address, l_account_no, l_account_type, l_mobile_no;
    JTextField tf_name, tf_dob, tf_nationality, tf_gender, tf_address, tf_account_no, tf_account_type, tf_mobile_no;
    JButton profile_edit_btn, profile_save_btn ;
    
    //Deposit tab
    JLabel l_user_deposit, l_name_deposit, l_credit_account_deposit, l_available_balance_deposit, l_amount_deposit;
    JTextField tf_user_deposit, tf_name_deposit, tf_credit_account_deposit, tf_available_balance_deposit, tf_amount_deposit;
    JButton deposit_btn;
    
    //Transfer tab
    JLabel l_user_transfer, l_name_transfer, l_debit_account_transfer, l_available_balance_transfer, l_amount_transfer,
            l_credit_account_transfer;
    JTextField tf_user_transfer, tf_name_transfer, tf_debit_account_transfer, tf_available_balance_transfer, 
            tf_amount_transfer, tf_credit_account_transfer;
    JButton transfer_btn;
    //Withdraw tab
    
    public GUI() {
        
//---------------------------------(LOGIN FRAME)-----------------------------//        
        login = new JFrame();
        login.setTitle("LOGIN PAGE");
        login.setSize(900, 400);
        login.setLocation(300, 250);

//----------------------------------( Panel )----------------------------------|
        JPanel P0 = new JPanel(new GridLayout(4,1)) ;
        JPanel Pusername = new JPanel();
        JPanel Ppassword = new JPanel();
        JPanel Ploginbtn = new JPanel();
        JPanel PloginError = new JPanel();
        
        P0.add(Pusername);
        P0.add(Ppassword);
        P0.add(Ploginbtn);
        P0.add(PloginError);

        login.add(P0);

//--------------------------------( Component )--------------------------------|
        l_username = new JLabel("Username");
        l_password = new JLabel(" Password ");
        l_loginError = new JLabel("");
        tf_username = new JTextField(20);
        tf_username.setText("");
        tf_password = new JTextField(20);
        tf_password.setText("");
        login_btn = new JButton("login");
        login_btn.setPreferredSize(new Dimension(100, 50));
        login_btn.addActionListener(this);
        
        Pusername.add(l_username);
        Pusername.add(tf_username);
        Ppassword.add(l_password);
        Ppassword.add(tf_password);
        Ploginbtn.add(login_btn);
        PloginError.add(l_loginError); 
        
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//-------------------------------(ACCOUNT(SECOND)FRAME)--------------------------------//
        account = new JFrame();
        account.setTitle("MY ACCOUNT");
        account.setSize(900, 400);
        account.setLocation(300, 250);
        account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tabs = new JTabbedPane();
//        tabs.setBounds(40,20,300,300);
        
        JPanel Pprofile = new JPanel(new GridLayout(2,1));
        JPanel Pprofile1 = new JPanel(new GridLayout(4,4));
        JPanel Pprofile2 = new JPanel();
        JPanel Pp1 = new JPanel();
        JPanel Pp2 = new JPanel();
        JPanel Pp3 = new JPanel();
        JPanel Pp4 = new JPanel();
        JPanel Pp5 = new JPanel();
        JPanel Pp6 = new JPanel();
        JPanel Pp7 = new JPanel();
        JPanel Pp8 = new JPanel();
        JPanel Pp9 = new JPanel();
        JPanel Pp10 = new JPanel();
        JPanel Pp11 = new JPanel();
        JPanel Pp12 = new JPanel();
        JPanel Pp13 = new JPanel();
        JPanel Pp14 = new JPanel();
        JPanel Pp15 = new JPanel();
        JPanel Pp16 = new JPanel();
        
        Pprofile.add(Pprofile1);
        Pprofile.add(Pprofile2);
        Pprofile1.add(Pp1);
        Pprofile1.add(Pp2);
        Pprofile1.add(Pp3);
        Pprofile1.add(Pp4);
        Pprofile1.add(Pp5);
        Pprofile1.add(Pp6);
        Pprofile1.add(Pp7);
        Pprofile1.add(Pp8);
        Pprofile1.add(Pp9);
        Pprofile1.add(Pp10);
        Pprofile1.add(Pp11);
        Pprofile1.add(Pp12);
        Pprofile1.add(Pp13);
        Pprofile1.add(Pp14);
        Pprofile1.add(Pp15);
        Pprofile1.add(Pp16);
        
        
        
        
        
        JPanel Pdeposit = new JPanel(new GridLayout(2,1));
        JPanel Pdeposit1 = new JPanel(new GridLayout(5,2));
        JPanel Pdeposit2 = new JPanel();
        JPanel Pd1 = new JPanel();
        JPanel Pd2 = new JPanel();
        JPanel Pd3 = new JPanel();
        JPanel Pd4 = new JPanel();
        JPanel Pd5 = new JPanel();
        JPanel Pd6 = new JPanel();
        JPanel Pd7 = new JPanel();
        JPanel Pd8 = new JPanel();
        JPanel Pd9 = new JPanel();
        JPanel Pd10 = new JPanel();

        Pdeposit.add(Pdeposit1);
        Pdeposit.add(Pdeposit2);
        Pdeposit1.add(Pd1);
        Pdeposit1.add(Pd2);
        Pdeposit1.add(Pd3);
        Pdeposit1.add(Pd4);
        Pdeposit1.add(Pd5);
        Pdeposit1.add(Pd6);
        Pdeposit1.add(Pd7);
        Pdeposit1.add(Pd8);
        Pdeposit1.add(Pd9);
        Pdeposit1.add(Pd10);
        

        
        JPanel Ptransfer = new JPanel(new GridLayout(2,1));
        JPanel Ptransfer1 = new JPanel(new GridLayout(6,2));
        JPanel Ptransfer2 = new JPanel();
        JPanel Pt1 = new JPanel();
        JPanel Pt2 = new JPanel();
        JPanel Pt3 = new JPanel();
        JPanel Pt4 = new JPanel();
        JPanel Pt5 = new JPanel();
        JPanel Pt6 = new JPanel();
        JPanel Pt7 = new JPanel();
        JPanel Pt8 = new JPanel();
        JPanel Pt9 = new JPanel();
        JPanel Pt10 = new JPanel();
        JPanel Pt11 = new JPanel();
        JPanel Pt12 = new JPanel();

        Ptransfer.add(Ptransfer1);
        Ptransfer.add(Ptransfer2);
        Ptransfer1.add(Pt1);
        Ptransfer1.add(Pt2);
        Ptransfer1.add(Pt3);
        Ptransfer1.add(Pt4);
        Ptransfer1.add(Pt5);
        Ptransfer1.add(Pt6);
        Ptransfer1.add(Pt7);
        Ptransfer1.add(Pt8);
        Ptransfer1.add(Pt9);
        Ptransfer1.add(Pt10);
        Ptransfer1.add(Pt11);
        Ptransfer1.add(Pt12);
        
        
        
        
        
        JPanel Ptransactions = new JPanel(new GridLayout(5,3));
        JPanel Pwithdraw = new JPanel(new GridLayout(5,3));
        JPanel Pview_balance = new JPanel(new GridLayout(5,3));
        
        tabs.add("Profile", Pprofile);
        tabs.add("Deposit", Pdeposit);
        tabs.add("Transfer", Ptransfer);
        tabs.add("Withdraw", Pwithdraw);
        tabs.add("Transactions", Ptransactions);
        tabs.add("View Balance", Pview_balance);
        
        account.add(tabs);
        
//-------------------------------------Profile tab----------------------------------//        

        l_name = new JLabel("Name");
        l_dob = new JLabel("Date Of Birth");
        l_nationality = new JLabel("Nationality");
        l_gender = new JLabel("Gender");
        l_address = new JLabel("Address");
        l_account_no = new JLabel("Account No.");
        l_account_type = new JLabel("Account Type");
        l_mobile_no = new JLabel("Mobile No.");
        
        tf_name = new JTextField(20);
        tf_name.setText("");
        tf_dob = new JTextField(20);
        tf_dob.setText("");
        tf_nationality = new JTextField(20);
        tf_nationality.setText("");
        tf_gender = new JTextField(20);
        tf_gender.setText("");
        tf_address = new JTextField(20);
        tf_address.setText("");
        tf_account_no = new JTextField(20);
        tf_account_no.setText("");
        tf_account_type = new JTextField(20);
        tf_account_type.setText("");
        tf_mobile_no = new JTextField(20);
        tf_mobile_no.setText("");
        
            tf_name.setEditable(false);
            tf_dob.setEditable(false); 
            tf_nationality.setEditable(false);
            tf_gender.setEditable(false);
            tf_address.setEditable(false);
            tf_account_no.setEditable(false);
            tf_account_type.setEditable(false);
            tf_mobile_no.setEditable(false);
        
        profile_edit_btn = new JButton("Edit");
        profile_edit_btn.addActionListener(this);
        profile_save_btn = new JButton("Save");
        profile_save_btn.addActionListener(this);

        Pp1.add(l_name);
        Pp2.add(tf_name);
        Pp3.add(l_dob);
        Pp4.add(tf_dob);
        Pp5.add(l_nationality);
        Pp6.add(tf_nationality);
        Pp7.add(l_gender);
        Pp8.add(tf_gender);
        Pp9.add(l_address);
        Pp10.add(tf_address);
        Pp11.add(l_account_no);
        Pp12.add(tf_account_no);
        Pp13.add(l_account_type);
        Pp14.add(tf_account_type);
        Pp15.add(l_mobile_no);
        Pp16.add(tf_mobile_no);
        Pprofile2.add(profile_edit_btn);
        Pprofile2.add(profile_save_btn);

//----------------------------------Deposit tap------------------------------------//
        l_user_deposit = new JLabel("User");
        l_name_deposit = new JLabel("Name"); 
        l_credit_account_deposit = new JLabel("Credit Account"); 
        l_available_balance_deposit = new JLabel("Available Balance");
        l_amount_deposit = new JLabel("Amount");
        
        tf_user_deposit = new JTextField(20);
        tf_user_deposit.setText("");
        tf_name_deposit = new JTextField(20);
        tf_name_deposit.setText("");
        tf_name_deposit.setEditable(false);
        tf_credit_account_deposit = new JTextField(20);
        tf_credit_account_deposit.setText("");
        tf_credit_account_deposit.setEditable(false);
        tf_available_balance_deposit = new JTextField(20);
        tf_available_balance_deposit.setText("");
        tf_amount_deposit = new JTextField(20);
        tf_amount_deposit.setText("");

        deposit_btn = new JButton("Deposit");
        deposit_btn.addActionListener(this);
        
        
        Pd1.add(l_user_deposit);
        Pd2.add(tf_user_deposit);
        Pd3.add(l_name_deposit);
        Pd4.add(tf_name_deposit);
        Pd5.add(l_credit_account_deposit);
        Pd6.add(tf_credit_account_deposit);
        Pd7.add(l_available_balance_deposit);
        Pd8.add(tf_available_balance_deposit);
        Pd9.add(l_amount_deposit);
        Pd10.add(tf_amount_deposit);
        Pdeposit2.add(deposit_btn);
  
 
//------------------------------Transfer Tab------------------------------------//

        l_user_transfer = new JLabel("User");
        l_name_transfer = new JLabel("Name"); 
        l_debit_account_transfer = new JLabel("Debit Account"); 
        l_available_balance_transfer = new JLabel("Available Balance");
        l_amount_transfer = new JLabel("Amount");
        l_credit_account_transfer = new JLabel("Credit Account"); 
        
        tf_user_transfer = new JTextField(20);
        tf_user_transfer.setText("");
        tf_name_transfer = new JTextField(20);
        tf_name_transfer.setText("");
        tf_name_transfer.setEditable(false);
        tf_debit_account_transfer = new JTextField(20);
        tf_debit_account_transfer.setText("");
        tf_debit_account_transfer.setEditable(false);
        tf_available_balance_transfer = new JTextField(20);
        tf_available_balance_transfer.setText("");
        tf_amount_transfer = new JTextField(20);
        tf_amount_transfer.setText("");
        tf_credit_account_transfer = new JTextField(20);
        tf_credit_account_transfer.setText("");
        
        transfer_btn = new JButton("Transfer");
        transfer_btn.addActionListener(this);
        
        Pt1.add(l_user_transfer);
        Pt2.add(tf_user_transfer);
        Pt3.add(l_name_transfer);
        Pt4.add(tf_name_transfer);
        Pt5.add(l_debit_account_transfer);
        Pt6.add(tf_debit_account_transfer);
        Pt7.add(l_available_balance_transfer);
        Pt8.add(tf_available_balance_transfer);
        Pt9.add(l_amount_transfer);
        Pt10.add(tf_amount_transfer);
        Pt11.add(l_credit_account_transfer);
        Pt12.add(tf_credit_account_transfer);
        Ptransfer2.add(transfer_btn);
 
    }

    public static void main(String[] args) {

        GUI example = new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == login_btn) {
            if(tf_username.getText().isEmpty() == false && tf_password.getText().isEmpty() == false) {
               login.setVisible(false);
               account.setVisible(true);
               login.dispose();
            } 
            else if (tf_username.getText().isEmpty() == true && tf_password.getText().isEmpty() == true) {
                l_loginError.setText(" Please Enter the Username and Password ");
            } 
            else if (tf_username.getText().isEmpty() == true && tf_password.getText().isEmpty() == false) {
                l_loginError.setText(" Please Enter the Username");
            }
            else if (tf_username.getText().isEmpty() == false && tf_password.getText().isEmpty() == true) {
                l_loginError.setText(" Please Enter the Password");
            }

        }
        if (e.getSource() == profile_edit_btn)
        {
            tf_name.setEditable(true);
            tf_dob.setEditable(true); 
            tf_nationality.setEditable(true);
            tf_gender.setEditable(true);
            tf_address.setEditable(true);
            tf_account_no.setEditable(true);
            tf_account_type.setEditable(true);
            tf_mobile_no.setEditable(true);
        }
        if (e.getSource() == profile_save_btn)
        {
            //................................
            tf_name.setEditable(false);
            tf_dob.setEditable(false); 
            tf_nationality.setEditable(false);
            tf_gender.setEditable(false);
            tf_address.setEditable(false);
            tf_account_no.setEditable(false);
            tf_account_type.setEditable(false);
            tf_mobile_no.setEditable(false);
        }
        if (e.getSource() == deposit_btn)
        {
            
        }
        if (e.getSource() == transfer_btn)
        {
            
        }
    }

}
