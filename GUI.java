/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author DELL
 */
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
        login.setSize(600, 400);
        login.setLocation(600, 250);

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
        account.setSize(600, 400);
        account.setLocation(600, 250);
        account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(40,20,300,300);
        
        JPanel Pprofile = new JPanel(new GridLayout(5,3));
        
        JPanel Pdeposit = new JPanel();
        Pdeposit.setLayout(new GridBagLayout());
        GridBagConstraints cdeposit = new GridBagConstraints();
        
        JPanel Ptransfer = new JPanel();
        Ptransfer.setLayout(new GridBagLayout());
        GridBagConstraints ctransfer = new GridBagConstraints();
        
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

        Pprofile.add(l_name);
        Pprofile.add(tf_name);
        Pprofile.add(l_dob);
        Pprofile.add(tf_dob);
        Pprofile.add(l_nationality);
        Pprofile.add(tf_nationality);
        Pprofile.add(l_gender);
        Pprofile.add(tf_gender);
        Pprofile.add(l_address);
        Pprofile.add(tf_address);
        Pprofile.add(l_account_no);
        Pprofile.add(tf_account_no);
        Pprofile.add(l_account_type);
        Pprofile.add(tf_account_type);
        Pprofile.add(l_mobile_no);
        Pprofile.add(tf_mobile_no);

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
        
        cdeposit.gridx = 0;
        cdeposit.gridy = 0;
        Pdeposit.add(l_user_deposit, cdeposit);
        
        cdeposit.gridx = 1;
        cdeposit.gridy = 0;
        Pdeposit.add(tf_user_deposit, cdeposit);
        
        cdeposit.gridx = 0;
        cdeposit.gridy = 1;
        Pdeposit.add(l_name_deposit, cdeposit);
        
        cdeposit.gridx = 1;
        cdeposit.gridy = 1;
        Pdeposit.add(tf_name_deposit, cdeposit);
        
        cdeposit.gridx = 0;
        cdeposit.gridy = 2;
        Pdeposit.add(l_credit_account_deposit,cdeposit);
        
        cdeposit.gridx = 1;
        cdeposit.gridy = 2;
        Pdeposit.add(tf_credit_account_deposit,cdeposit);
        
        cdeposit.gridx = 0;
        cdeposit.gridy = 3;
        Pdeposit.add(l_available_balance_deposit,cdeposit);
        
        cdeposit.gridx = 1;
        cdeposit.gridy = 3;
        Pdeposit.add(tf_available_balance_deposit,cdeposit);
        
        cdeposit.gridx = 0;
        cdeposit.gridy = 4;
        Pdeposit.add(l_amount_deposit,cdeposit);
        
        cdeposit.gridx = 1;
        cdeposit.gridy = 4;
        Pdeposit.add(tf_amount_deposit,cdeposit);
        
        cdeposit.gridx = 6;
        cdeposit.gridy = 6;
        Pdeposit.add(deposit_btn,cdeposit);
 
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
        
        ctransfer.gridx = 0;
        ctransfer.gridy = 0;
        Ptransfer.add(l_user_transfer, ctransfer);
        
        ctransfer.gridx = 1;
        ctransfer.gridy = 0;
        Ptransfer.add(tf_user_transfer, ctransfer);
        
        ctransfer.gridx = 0;
        ctransfer.gridy = 1;
        Ptransfer.add(l_name_transfer, ctransfer);
        
        ctransfer.gridx = 1;
        ctransfer.gridy = 1;
        Ptransfer.add(tf_name_transfer, ctransfer);
        
        ctransfer.gridx = 0;
        ctransfer.gridy = 2;
        Ptransfer.add(l_debit_account_transfer,ctransfer);
        
        ctransfer.gridx = 1;
        ctransfer.gridy = 2;
        Ptransfer.add(tf_debit_account_transfer,ctransfer);
        
        ctransfer.gridx = 0;
        ctransfer.gridy = 3;
        Ptransfer.add(l_available_balance_transfer,ctransfer);
        
        ctransfer.gridx = 1;
        ctransfer.gridy = 3;
        Ptransfer.add(tf_available_balance_transfer,ctransfer);
        
        ctransfer.gridx = 0;
        ctransfer.gridy = 4;
        Ptransfer.add(l_amount_transfer,ctransfer);
        
        ctransfer.gridx = 1;
        ctransfer.gridy = 4;
        Ptransfer.add(tf_amount_transfer,ctransfer);

        ctransfer.gridx = 0;
        ctransfer.gridy = 5;
        Ptransfer.add(l_credit_account_transfer,ctransfer);
        
        ctransfer.gridx = 1;
        ctransfer.gridy = 5;
        Ptransfer.add(tf_credit_account_transfer,ctransfer);
      
        ctransfer.gridx = 6;
        ctransfer.gridy = 6;
        Ptransfer.add(transfer_btn,ctransfer);
 
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
        if (e.getSource() == deposit_btn)
        {
            
        }
        if (e.getSource() == transfer_btn)
        {
            
        }
    }

}
