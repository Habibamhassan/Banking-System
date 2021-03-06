package bankingsystem;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI implements ActionListener {

    JFrame login;
    JLabel l_username, l_password, l_loginError;
    JTextField tf_username; //tf_password;
    JPasswordField password;
    JButton login_btn;
    
    Client c = null;
    DbManager db = null;
 //-----------------------------------client frame-------------------------------------------
    JFrame client_account;
    
    //profile tab 
    JLabel l_name, l_dob, l_nationality, l_gender, l_address, l_account_no, l_account_type, l_mobile_no;
    JTextField tf_name, tf_dob, tf_nationality, tf_gender, tf_address, tf_account_no, tf_account_type, tf_mobile_no;
    JButton profile_edit_btn, profile_save_btn ;
    JLabel try_name;
    
    //Deposit tab
    JLabel l_response_deposit, l_user_deposit, l_name_deposit, l_credit_account_deposit, l_available_balance_deposit, l_amount_deposit;
    JTextField tf_user_deposit, tf_name_deposit, tf_credit_account_deposit, tf_available_balance_deposit, tf_amount_deposit;
    JButton deposit_btn;
    
    //Transfer tab
    JLabel l_response_transfer, l_user_transfer, l_name_transfer, l_debit_account_transfer, l_available_balance_transfer, l_amount_transfer,
            l_target_acc_id;
    JTextField tf_user_transfer, tf_name_transfer, tf_debit_account_transfer, tf_available_balance_transfer, 
            tf_amount_transfer, tf_target_acc_id;
    JButton transfer_btn;
    
    //Withdraw tab
    JLabel l_response_withdraw, l_user_withdraw, l_name_withdraw, l_debit_account_withdraw, l_available_balance_withdraw, l_amount_withdraw;
    JTextField tf_user_withdraw, tf_name_withdraw, tf_debit_account_withdraw, tf_available_balance_withdraw, tf_amount_withdraw;
    JButton withdraw_btn;
    
    //Transactions tab
    JTable transactions;
    JButton update;
    DefaultTableModel model;
    
    //view balance tab
    JLabel l_user_view, l_name_view, l_account_no_view, l_micr_no_view, l_roi_view, l_available_balance_view, l_mod_balance_view;
    JTextField tf_user_view, tf_name_view, tf_account_no_view, tf_micr_no_view, tf_roi_view, tf_available_balance_view,
            tf_mod_balance_view;
    JLabel try_available_balance;
    JButton refresh;
    
 //-----------------------------------admin frame-------------------------------------------   
    JFrame admin_account;
    
    //profile tab 
    JLabel l_name_ad, l_dob_ad, l_nationality_ad, l_gender_ad, l_address_ad, l_account_no_ad,
            l_account_type_ad, l_mobile_no_ad;
    JTextField tf_name_ad, tf_dob_ad, tf_nationality_ad, tf_gender_ad, tf_address_ad, tf_account_no_ad, 
            tf_account_type_ad, tf_mobile_no_ad;
    JButton profile_edit_btn_ad, profile_save_btn_ad ,search_profile;
    
    //Deposit tab
    JLabel l_response_deposit_ad, l_user_deposit_ad, l_name_deposit_ad, l_account_no_deposit_ad, l_available_balance_deposit_ad, l_amount_deposit_ad;
    JTextField tf_user_deposit_ad, tf_name_deposit_ad, tf_account_no_deposit_ad, tf_available_balance_deposit_ad,
            tf_amount_deposit_ad;
    JButton deposit_btn_ad;
    
    //Transfer tab
    JLabel l_response_transfer_ad, l_user_transfer_ad, l_name_transfer_ad, l_account_no_transfer_ad, l_available_balance_transfer_ad, l_amount_transfer_ad,
            l_target_acc_id_ad;
    JTextField tf_user_transfer_ad, tf_name_transfer_ad, tf_account_no_transfer_ad, tf_available_balance_transfer_ad, 
            tf_amount_transfer_ad, tf_target_acc_id_ad;
    JButton transfer_btn_ad;
    
    //Withdraw tab
    JLabel l_response_withdraw_ad, l_user_withdraw_ad, l_name_withdraw_ad, l_account_no_withdraw_ad, l_available_balance_withdraw_ad, l_amount_withdraw_ad;
    JTextField tf_user_withdraw_ad, tf_name_withdraw_ad, tf_account_no_withdraw_ad, tf_available_balance_withdraw_ad,
            tf_amount_withdraw_ad;
    JButton withdraw_btn_ad;
    
    //Transactions tab
    JTable transactions_ad;
    JButton update_ad;
    DefaultTableModel model_ad;
    
    //view balance tab
    JLabel l_user_view_ad, l_name_view_ad, l_account_no_view_ad, l_micr_no_view_ad, l_roi_view_ad, l_available_balance_view_ad,
            l_mod_balance_view_ad;
    JTextField tf_user_view_ad, tf_name_view_ad, tf_account_no_view_ad, tf_micr_no_view_ad, tf_roi_view_ad, 
            tf_available_balance_view_ad, tf_mod_balance_view_ad;
    JButton search_view_ad, refresh_ad;
    
    //register new client tab
    JLabel l_response_register, l_reg_name, l_reg_dob, l_reg_nationality, l_reg_gender, l_reg_address, l_age_register, l_reg_account_type,
            l_reg_mobile_no, l_balance_register, l_password_register;
    JTextField tf_reg_name, tf_reg_dob, tf_reg_nationality, tf_reg_gender, tf_reg_address, tf_age_register, tf_reg_account_type,
            tf_reg_mobile_no, tf_balance_register, tf_password_register;
    JButton  register_done_btn ;
    
//    JLabel l_password_register;
//    JPasswordField password_register;
    
    //delete client tab
    JLabel l_response_delete, l_delete_username, l_delete_password, l_delete_Error;
    JTextField tf_delete_username; //tf_password;
    JPasswordField delete_password;
    JButton delete_btn;
    
    
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
        password = new JPasswordField(20);
        password.setText("");
        login_btn = new JButton("login");
        login_btn.setPreferredSize(new Dimension(100, 50));
        login_btn.addActionListener(this);
        
        Pusername.add(l_username);
        Pusername.add(tf_username);
        Ppassword.add(l_password);
        Ppassword.add(password);
        Ploginbtn.add(login_btn);
        PloginError.add(l_loginError); 
        
        login.setVisible(true);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        
//-------------------------------(CLIENT ACCOUNT(SECOND)FRAME)--------------------------------//
        client_account = new JFrame();
        client_account.setTitle("MY ACCOUNT");
        client_account.setSize(900, 400);
        client_account.setLocation(300, 250);
        client_account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane client_tabs = new JTabbedPane();
//        tabs.setBounds(40,20,300,300);
        
//----------------------------------profile panels----------------------------------//
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
       
 
//----------------------------------Deposit panels----------------------------------//    

        JPanel Pdeposit = new JPanel(new GridLayout(3,1));
        JPanel Pdeposit1 = new JPanel(new GridLayout(1,2));
        JPanel Pdeposit2 = new JPanel();
        JPanel Pdeposit3 = new JPanel();
        JPanel Pd1 = new JPanel();
        JPanel Pd2 = new JPanel();
//        JPanel Pd3 = new JPanel();
//        JPanel Pd4 = new JPanel();
//        JPanel Pd5 = new JPanel();
//        JPanel Pd6 = new JPanel();
//        JPanel Pd7 = new JPanel();
//        JPanel Pd8 = new JPanel();
//        JPanel Pd9 = new JPanel();
//        JPanel Pd10 = new JPanel();
        //JPanel Pd11 = new JPanel();

        Pdeposit.add(Pdeposit1);
        Pdeposit.add(Pdeposit2);
        Pdeposit.add(Pdeposit3);
        Pdeposit1.add(Pd1);
        Pdeposit1.add(Pd2);
//        Pdeposit1.add(Pd3);
//        Pdeposit1.add(Pd4);
//        Pdeposit1.add(Pd5);
//        Pdeposit1.add(Pd6);
//        Pdeposit1.add(Pd7);
//        Pdeposit1.add(Pd8);
//        Pdeposit1.add(Pd9);
//        Pdeposit1.add(Pd10);
        //Pdeposit1.add(Pd11);
        

//----------------------------------Transfer panels----------------------------------//

        JPanel Ptransfer = new JPanel(new GridLayout(3,1));
        JPanel Ptransfer1 = new JPanel(new GridLayout(2,2));
        JPanel Ptransfer2 = new JPanel();
        JPanel Ptransfer3 = new JPanel();
        JPanel Pt1 = new JPanel();
        JPanel Pt2 = new JPanel();
        JPanel Pt3 = new JPanel();
        JPanel Pt4 = new JPanel();
//        JPanel Pt5 = new JPanel();
//        JPanel Pt6 = new JPanel();
//        JPanel Pt7 = new JPanel();
//        JPanel Pt8 = new JPanel();
//        JPanel Pt9 = new JPanel();
//        JPanel Pt10 = new JPanel();
//        JPanel Pt11 = new JPanel();
//        JPanel Pt12 = new JPanel();
//        JPanel Pt13 = new JPanel();

        Ptransfer.add(Ptransfer1);
        Ptransfer.add(Ptransfer2);
        Ptransfer.add(Ptransfer3);
        Ptransfer1.add(Pt1);
        Ptransfer1.add(Pt2);
        Ptransfer1.add(Pt3);
        Ptransfer1.add(Pt4);
//        Ptransfer1.add(Pt5);
//        Ptransfer1.add(Pt6);
//        Ptransfer1.add(Pt7);
//        Ptransfer1.add(Pt8);
//        Ptransfer1.add(Pt9);
//        Ptransfer1.add(Pt10);
//        Ptransfer1.add(Pt11);
//        Ptransfer1.add(Pt12);
//        Ptransfer1.add(Pt13);
             
//----------------------------------Withdraw panels----------------------------------//    

        JPanel Pwithdraw = new JPanel(new GridLayout(3,1));
        JPanel Pwithdraw1 = new JPanel(new GridLayout(1,2));
        JPanel Pwithdraw2 = new JPanel();
        JPanel Pwithdraw3 = new JPanel();
        JPanel Pw1 = new JPanel();
        JPanel Pw2 = new JPanel();
//        JPanel Pw3 = new JPanel();
//        JPanel Pw4 = new JPanel();
//        JPanel Pw5 = new JPanel();
//        JPanel Pw6 = new JPanel();
//        JPanel Pw7 = new JPanel();
//        JPanel Pw8 = new JPanel();
//        JPanel Pw9 = new JPanel();
//        JPanel Pw10 = new JPanel();
        //JPanel Pw11 = new JPanel();

        Pwithdraw.add(Pwithdraw1);
        Pwithdraw.add(Pwithdraw2);
        Pwithdraw.add(Pwithdraw3);
        Pwithdraw1.add(Pw1);
        Pwithdraw1.add(Pw2);
//        Pwithdraw1.add(Pw3);
//        Pwithdraw1.add(Pw4);
//        Pwithdraw1.add(Pw5);
//        Pwithdraw1.add(Pw6);
//        Pwithdraw1.add(Pw7);
//        Pwithdraw1.add(Pw8);
//        Pwithdraw1.add(Pw9);
//        Pwithdraw1.add(Pw10);
        //Pwithdraw1.add(Pw11);
        
//----------------------------------Transactions panels----------------------------------// 

        JPanel Ptransactions = new JPanel(new GridLayout(2,1));
        JPanel Ptransactions1 = new JPanel(new GridLayout(1,1));
        JPanel Ptransactions2 = new JPanel();
        
        Ptransactions.add(Ptransactions1);
        Ptransactions.add(Ptransactions2);
//----------------------------------view balance panels----------------------------------//

        JPanel Pview_balance = new JPanel(new GridLayout(2,1));
        JPanel Pview_balance1 = new JPanel(new GridLayout(7,2));
        JPanel Pview_balance2 = new JPanel();
        JPanel Pv1 = new JPanel();
        JPanel Pv2 = new JPanel();
        JPanel Pv3 = new JPanel();
        JPanel Pv4 = new JPanel();
        JPanel Pv5 = new JPanel();
        JPanel Pv6 = new JPanel();
        JPanel Pv7 = new JPanel();
        JPanel Pv8 = new JPanel();
        JPanel Pv9 = new JPanel();
        JPanel Pv10 = new JPanel();
        JPanel Pv11 = new JPanel();
        JPanel Pv12 = new JPanel();
        JPanel Pv13 = new JPanel();
        JPanel Pv14 = new JPanel();
        
        Pview_balance.add(Pview_balance1);
        Pview_balance.add(Pview_balance2);
        Pview_balance1.add(Pv1);
        Pview_balance1.add(Pv2);
        Pview_balance1.add(Pv3);
        Pview_balance1.add(Pv4);
        Pview_balance1.add(Pv5);
        Pview_balance1.add(Pv6);
        Pview_balance1.add(Pv7);
        Pview_balance1.add(Pv8);
        Pview_balance1.add(Pv9);
        Pview_balance1.add(Pv10);
        Pview_balance1.add(Pv11);
        Pview_balance1.add(Pv12);
        Pview_balance1.add(Pv13);
        Pview_balance1.add(Pv14);
  
        
        client_tabs.add("Profile", Pprofile);
        client_tabs.add("Deposit", Pdeposit);
        client_tabs.add("Transfer", Ptransfer);
        client_tabs.add("Withdraw", Pwithdraw);
        client_tabs.add("Transactions", Ptransactions);
        client_tabs.add("View Balance", Pview_balance);
        
        client_account.add(client_tabs);
        
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

//----------------------------------Deposit tap------------------------------------//
//        l_user_deposit = new JLabel("User");
//        l_name_deposit = new JLabel("Name"); 
//        l_credit_account_deposit = new JLabel("Credit Account"); 
//        l_available_balance_deposit = new JLabel("Available Balance");
        l_amount_deposit = new JLabel("Amount");
        l_response_deposit = new JLabel("");
        
//        tf_user_deposit = new JTextField(20);
//        tf_user_deposit.setText("");
//        
//        tf_name_deposit = new JTextField(20);
//        tf_name_deposit.setText("");
//        tf_name_deposit.setEditable(false);
//        
//        tf_credit_account_deposit = new JTextField(20);
//        tf_credit_account_deposit.setText("");
//        tf_credit_account_deposit.setEditable(false);
//        
//        tf_available_balance_deposit = new JTextField(20);
//        tf_available_balance_deposit.setText("");
        
        tf_amount_deposit = new JTextField(20);
        tf_amount_deposit.setText("");

        deposit_btn = new JButton("Deposit");
        deposit_btn.addActionListener(this);
        
        
//        Pd1.add(l_user_deposit);
//        Pd2.add(tf_user_deposit);
//        Pd3.add(l_name_deposit);
//        Pd4.add(tf_name_deposit);
//        Pd5.add(l_credit_account_deposit);
//        Pd6.add(tf_credit_account_deposit);
//        Pd7.add(l_available_balance_deposit);
//        Pd8.add(tf_available_balance_deposit);
        Pd1.add(l_amount_deposit);
        Pd2.add(tf_amount_deposit);
        Pdeposit2.add(deposit_btn);
        Pdeposit3.add(l_response_deposit);
  
 
//------------------------------Transfer Tab------------------------------------//

//        l_user_transfer = new JLabel("User");
//        l_name_transfer = new JLabel("Name"); 
//        l_debit_account_transfer = new JLabel("Debit Account"); 
//        l_available_balance_transfer = new JLabel("Available Balance");
        l_amount_transfer = new JLabel("Amount");
        l_target_acc_id = new JLabel("Target Account ID"); 
        l_response_transfer = new JLabel("");
        
//        tf_user_transfer = new JTextField(20);
//        tf_user_transfer.setText("");
//        
//        tf_name_transfer = new JTextField(20);
//        tf_name_transfer.setText("");
//        tf_name_transfer.setEditable(false);
//        
//        tf_debit_account_transfer = new JTextField(20);
//        tf_debit_account_transfer.setText("");
//        tf_debit_account_transfer.setEditable(false);
//        
//        tf_available_balance_transfer = new JTextField(20);
//        tf_available_balance_transfer.setText("");
        
        tf_amount_transfer = new JTextField(20);
        tf_amount_transfer.setText("");
        
        tf_target_acc_id = new JTextField(20);
        tf_target_acc_id.setText("");
        
        transfer_btn = new JButton("Transfer");
        transfer_btn.addActionListener(this);
        
//        Pt1.add(l_user_transfer);
//        Pt2.add(tf_user_transfer);
//        Pt3.add(l_name_transfer);
//        Pt4.add(tf_name_transfer);
//        Pt5.add(l_debit_account_transfer);
//        Pt6.add(tf_debit_account_transfer);
//        Pt7.add(l_available_balance_transfer);
//        Pt8.add(tf_available_balance_transfer);
        Pt1.add(l_amount_transfer);
        Pt2.add(tf_amount_transfer);
        Pt3.add(l_target_acc_id);
        Pt4.add(tf_target_acc_id);
        Ptransfer2.add(transfer_btn);
        Ptransfer3.add(l_response_transfer);
        
 //---------------------------------------Withdraw Tap-------------------------------------//
       
//        l_user_withdraw = new JLabel("User");
//        l_name_withdraw = new JLabel("Name"); 
//        l_debit_account_withdraw = new JLabel("Debit Account");
//        l_available_balance_withdraw = new JLabel("Available Balance");
        l_amount_withdraw = new JLabel("Amount");
        l_response_withdraw = new JLabel("");
        
//        tf_user_withdraw = new JTextField(20);
//        tf_user_withdraw.setText("");
//        
//        tf_name_withdraw = new JTextField(20);
//        tf_name_withdraw.setText("");
//        tf_name_withdraw.setEditable(false);
        
//        tf_debit_account_withdraw = new JTextField(20);
//        tf_debit_account_withdraw.setText("");
//        tf_debit_account_withdraw.setEditable(false);
        
//        tf_available_balance_withdraw = new JTextField(20);
//        tf_available_balance_withdraw.setText("");

        tf_amount_withdraw = new JTextField(20);
        tf_amount_withdraw.setText("");

        withdraw_btn = new JButton("Withdraw");
        withdraw_btn.addActionListener(this);
        
        
//        Pw1.add(l_user_withdraw);
//        Pw2.add(tf_user_withdraw);
//        Pw3.add(l_name_withdraw);
//        Pw4.add(tf_name_withdraw);
//        Pw5.add(l_debit_account_withdraw);
//        Pw6.add(tf_debit_account_withdraw);
//        Pw7.add(l_available_balance_withdraw);
//        Pw8.add(tf_available_balance_withdraw);
        Pw1.add(l_amount_withdraw);
        Pw2.add(tf_amount_withdraw);
        Pwithdraw2.add(withdraw_btn);
        Pwithdraw3.add(l_response_withdraw);
        
//--------------------------------------Transactions Tab---------------------------------//

//        String[][] data = {
//            { "1", "a", "1", "1" },
//            { "2", "b", "2", "2" }
//        };
        // Column Names
        String[] columnNames = { "Account No.", "Amount", "Type", "Transaction ID", "Target Account ID" };
        model = new DefaultTableModel(columnNames, 0);
        // Initializing the JTable
        transactions = new JTable(model);
        transactions.setBounds(30, 40, 200, 300);
        
        update = new JButton("Update");
        update.addActionListener(this);
        
        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(transactions);
        Ptransactions1.add(sp);
        Ptransactions2.add(update);
        
 
//----------------------------------View Balance Tab--------------------------------//

        //l_user_view = new JLabel("User");
        l_name_view = new JLabel("Name"); 
        l_account_no_view = new JLabel("Account No."); 
        //l_micr_no_view = new JLabel("MICR No."); 
        //l_roi_view = new JLabel("Rate of Interest (%)");
        l_available_balance_view = new JLabel("Available Balance");
        //l_mod_balance_view = new JLabel("MOD Balance");
        
//        tf_user_view = new JTextField(20);
//        tf_user_view.setText("");
//        
        tf_name_view = new JTextField(20);
        tf_name_view.setText("");
        tf_name_view.setEditable(false);
        
        tf_account_no_view = new JTextField(20);
        tf_account_no_view.setText("");
        tf_account_no_view.setEditable(false);
        
//        tf_micr_no_view = new JTextField(20);
//        tf_micr_no_view.setText("");
//        tf_micr_no_view.setEditable(false);
        
//        tf_roi_view = new JTextField(20);
//        tf_roi_view.setText("");
//        tf_roi_view.setEditable(false);
        
        
//        try_available_balance = new JLabel("");
        
        tf_available_balance_view = new JTextField(20);
        tf_available_balance_view.setText("");
        tf_available_balance_view.setEditable(false);
        
//        tf_mod_balance_view = new JTextField(20);
//        tf_mod_balance_view.setText("");
//        tf_mod_balance_view.setEditable(false);
        

        refresh = new JButton("Refresh");
        refresh.addActionListener(this);
        
        //Pv1.add(l_user_view);
        //Pv2.add(tf_user_view);
        Pv3.add(l_name_view);
        Pv4.add(tf_name_view);
        Pv5.add(l_account_no_view);
        Pv6.add(tf_account_no_view);
//        Pv7.add(l_micr_no_view);
//        Pv8.add(tf_micr_no_view);
//        Pv7.add(l_roi_view);
//        Pv8.add(tf_roi_view);
        Pv7.add(l_available_balance_view);
        //Pv12.add(try_available_balance);
        Pv8.add(tf_available_balance_view);
        Pview_balance2.add(refresh);
//        Pv13.add(l_mod_balance_view);
//        Pv14.add(tf_mod_balance_view);
        
        
 //-------------------------------(ADMIN ACCOUNT(THIRD)FRAME)--------------------------------//       
       
        admin_account = new JFrame();
        admin_account.setTitle("MY ACCOUNT");
        admin_account.setSize(900, 400);
        admin_account.setLocation(300, 250);
        admin_account.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane admin_tabs = new JTabbedPane();
        
        //----------------------------------profile panels----------------------------------//
        JPanel Pprofile_ad = new JPanel(new GridLayout(2,1));
        JPanel Pprofile1_ad = new JPanel(new GridLayout(4,4));
        JPanel Pprofile2_ad = new JPanel();
        JPanel Pp1_ad = new JPanel();
        JPanel Pp2_ad = new JPanel();
        JPanel Pp3_ad = new JPanel();
        JPanel Pp4_ad = new JPanel();
        JPanel Pp5_ad = new JPanel();
        JPanel Pp6_ad = new JPanel();
        JPanel Pp7_ad = new JPanel();
        JPanel Pp8_ad = new JPanel();
        JPanel Pp9_ad = new JPanel();
        JPanel Pp10_ad = new JPanel();
        JPanel Pp11_ad = new JPanel();
        JPanel Pp12_ad = new JPanel();
        JPanel Pp13_ad = new JPanel();
        JPanel Pp14_ad = new JPanel();
        JPanel Pp15_ad = new JPanel();
        JPanel Pp16_ad = new JPanel();
        
        Pprofile_ad.add(Pprofile1_ad);
        Pprofile_ad.add(Pprofile2_ad);
        Pprofile1_ad.add(Pp1_ad);
        Pprofile1_ad.add(Pp2_ad);
        Pprofile1_ad.add(Pp3_ad);
        Pprofile1_ad.add(Pp4_ad);
        Pprofile1_ad.add(Pp5_ad);
        Pprofile1_ad.add(Pp6_ad);
        Pprofile1_ad.add(Pp7_ad);
        Pprofile1_ad.add(Pp8_ad);
        Pprofile1_ad.add(Pp9_ad);
        Pprofile1_ad.add(Pp10_ad);
        Pprofile1_ad.add(Pp11_ad);
        Pprofile1_ad.add(Pp12_ad);
        Pprofile1_ad.add(Pp13_ad);
        Pprofile1_ad.add(Pp14_ad);
        Pprofile1_ad.add(Pp15_ad);
        Pprofile1_ad.add(Pp16_ad);
       
 
//----------------------------------Deposit panels----------------------------------//    

        JPanel Pdeposit_ad = new JPanel(new GridLayout(3,1));
        JPanel Pdeposit1_ad = new JPanel(new GridLayout(5,2));
        JPanel Pdeposit2_ad = new JPanel();
        JPanel Pdeposit3_ad = new JPanel();
        JPanel Pd1_ad = new JPanel();
        JPanel Pd2_ad = new JPanel();
        JPanel Pd3_ad = new JPanel();
        JPanel Pd4_ad = new JPanel();
        JPanel Pd5_ad = new JPanel();
        JPanel Pd6_ad = new JPanel();
        JPanel Pd7_ad = new JPanel();
        JPanel Pd8_ad = new JPanel();
        JPanel Pd9_ad = new JPanel();
        JPanel Pd10_ad = new JPanel();
        //JPanel Pd11_ad = new JPanel();

        Pdeposit_ad.add(Pdeposit1_ad);
        Pdeposit_ad.add(Pdeposit2_ad);
        Pdeposit_ad.add(Pdeposit3_ad);
        Pdeposit1_ad.add(Pd1_ad);
        Pdeposit1_ad.add(Pd2_ad);
        Pdeposit1_ad.add(Pd3_ad);
        Pdeposit1_ad.add(Pd4_ad);
        Pdeposit1_ad.add(Pd5_ad);
        Pdeposit1_ad.add(Pd6_ad);
        Pdeposit1_ad.add(Pd7_ad);
        Pdeposit1_ad.add(Pd8_ad);
        Pdeposit1_ad.add(Pd9_ad);
        Pdeposit1_ad.add(Pd10_ad);
        //Pdeposit1_ad.add(Pd11_ad);
        

//----------------------------------Transfer panels----------------------------------//

        JPanel Ptransfer_ad = new JPanel(new GridLayout(3,1));
        JPanel Ptransfer1_ad = new JPanel(new GridLayout(6,2));
        JPanel Ptransfer2_ad = new JPanel();
        JPanel Ptransfer3_ad = new JPanel();
        JPanel Pt1_ad = new JPanel();
        JPanel Pt2_ad = new JPanel();
        JPanel Pt3_ad = new JPanel();
        JPanel Pt4_ad = new JPanel();
        JPanel Pt5_ad = new JPanel();
        JPanel Pt6_ad = new JPanel();
        JPanel Pt7_ad = new JPanel();
        JPanel Pt8_ad = new JPanel();
        JPanel Pt9_ad = new JPanel();
        JPanel Pt10_ad = new JPanel();
        JPanel Pt11_ad = new JPanel();
        JPanel Pt12_ad = new JPanel();
        //JPanel Pt13_ad = new JPanel();

        Ptransfer_ad.add(Ptransfer1_ad);
        Ptransfer_ad.add(Ptransfer2_ad);
        Ptransfer_ad.add(Ptransfer3_ad);
        Ptransfer1_ad.add(Pt1_ad);
        Ptransfer1_ad.add(Pt2_ad);
        Ptransfer1_ad.add(Pt3_ad);
        Ptransfer1_ad.add(Pt4_ad);
        Ptransfer1_ad.add(Pt5_ad);
        Ptransfer1_ad.add(Pt6_ad);
        Ptransfer1_ad.add(Pt7_ad);
        Ptransfer1_ad.add(Pt8_ad);
        Ptransfer1_ad.add(Pt9_ad);
        Ptransfer1_ad.add(Pt10_ad);
        Ptransfer1_ad.add(Pt11_ad);
        Ptransfer1_ad.add(Pt12_ad);
        //Ptransfer1_ad.add(Pt13_ad);
             
//----------------------------------Withdraw panels----------------------------------//    

        JPanel Pwithdraw_ad = new JPanel(new GridLayout(3,1));
        JPanel Pwithdraw1_ad = new JPanel(new GridLayout(5,2));
        JPanel Pwithdraw2_ad = new JPanel();
        JPanel Pwithdraw3_ad = new JPanel();
        JPanel Pw1_ad = new JPanel();
        JPanel Pw2_ad = new JPanel();
        JPanel Pw3_ad = new JPanel();
        JPanel Pw4_ad = new JPanel();
        JPanel Pw5_ad = new JPanel();
        JPanel Pw6_ad = new JPanel();
        JPanel Pw7_ad = new JPanel();
        JPanel Pw8_ad = new JPanel();
        JPanel Pw9_ad = new JPanel();
        JPanel Pw10_ad = new JPanel();
        //JPanel Pw11_ad = new JPanel();

        Pwithdraw_ad.add(Pwithdraw1_ad);
        Pwithdraw_ad.add(Pwithdraw2_ad);
        Pwithdraw_ad.add(Pwithdraw3_ad);
        Pwithdraw1_ad.add(Pw1_ad);
        Pwithdraw1_ad.add(Pw2_ad);
        Pwithdraw1_ad.add(Pw3_ad);
        Pwithdraw1_ad.add(Pw4_ad);
        Pwithdraw1_ad.add(Pw5_ad);
        Pwithdraw1_ad.add(Pw6_ad);
        Pwithdraw1_ad.add(Pw7_ad);
        Pwithdraw1_ad.add(Pw8_ad);
        Pwithdraw1_ad.add(Pw9_ad);
        Pwithdraw1_ad.add(Pw10_ad);
        //Pwithdraw1_ad.add(Pw11_ad);
        
//----------------------------------Transactions panels----------------------------------// 

        JPanel Ptransactions_ad = new JPanel(new GridLayout(2,1));
        JPanel Ptransactions1_ad = new JPanel(new GridLayout(1,1));
        JPanel Ptransactions2_ad = new JPanel();
        
        Ptransactions_ad.add(Ptransactions1_ad);
        Ptransactions_ad.add(Ptransactions2_ad);
//----------------------------------view balance panels----------------------------------//

        JPanel Pview_balance_ad = new JPanel(new GridLayout(2,1));
        JPanel Pview_balance1_ad = new JPanel(new GridLayout(7,2));
        JPanel Pview_balance2_ad = new JPanel();
        JPanel Pv1_ad = new JPanel();
        JPanel Pv2_ad = new JPanel();
        JPanel Pv3_ad = new JPanel();
        JPanel Pv4_ad = new JPanel();
        JPanel Pv5_ad = new JPanel();
        JPanel Pv6_ad = new JPanel();
        JPanel Pv7_ad = new JPanel();
        JPanel Pv8_ad = new JPanel();
        JPanel Pv9_ad = new JPanel();
        JPanel Pv10_ad = new JPanel();
        JPanel Pv11_ad = new JPanel();
        JPanel Pv12_ad = new JPanel();
        JPanel Pv13_ad = new JPanel();
        JPanel Pv14_ad = new JPanel();
        
        Pview_balance_ad.add(Pview_balance1_ad);
        Pview_balance_ad.add(Pview_balance2_ad);
        Pview_balance1_ad.add(Pv1_ad);
        Pview_balance1_ad.add(Pv2_ad);
        Pview_balance1_ad.add(Pv3_ad);
        Pview_balance1_ad.add(Pv4_ad);
        Pview_balance1_ad.add(Pv5_ad);
        Pview_balance1_ad.add(Pv6_ad);
        Pview_balance1_ad.add(Pv7_ad);
        Pview_balance1_ad.add(Pv8_ad);
        Pview_balance1_ad.add(Pv9_ad);
        Pview_balance1_ad.add(Pv10_ad);
        Pview_balance1_ad.add(Pv11_ad);
        Pview_balance1_ad.add(Pv12_ad);
        Pview_balance1_ad.add(Pv13_ad);
        Pview_balance1_ad.add(Pv14_ad);
  
//----------------------------------Register new client panels----------------------------------//

        JPanel Pregister_ad = new JPanel(new GridLayout(3,1));
        JPanel Pregister1_ad = new JPanel(new GridLayout(5,4));
        JPanel Pregister2_ad = new JPanel();
        JPanel Pregister3_ad = new JPanel();
        JPanel Pr1_ad = new JPanel();
        JPanel Pr2_ad = new JPanel();
        JPanel Pr3_ad = new JPanel();
        JPanel Pr4_ad = new JPanel();
        JPanel Pr5_ad = new JPanel();
        JPanel Pr6_ad = new JPanel();
        JPanel Pr7_ad = new JPanel();
        JPanel Pr8_ad = new JPanel();
        JPanel Pr9_ad = new JPanel();
        JPanel Pr10_ad = new JPanel();
        JPanel Pr11_ad = new JPanel();
        JPanel Pr12_ad = new JPanel();
        JPanel Pr13_ad = new JPanel();
        JPanel Pr14_ad = new JPanel();
        JPanel Pr15_ad = new JPanel();
        JPanel Pr16_ad = new JPanel();
        JPanel Pr17_ad = new JPanel();
        JPanel Pr18_ad = new JPanel();
        JPanel Pr19_ad = new JPanel();
        JPanel Pr20_ad = new JPanel();
        
        
        Pregister_ad.add(Pregister1_ad);
        Pregister_ad.add(Pregister2_ad);
        Pregister_ad.add(Pregister3_ad);
        Pregister1_ad.add(Pr1_ad);
        Pregister1_ad.add(Pr2_ad);
        Pregister1_ad.add(Pr3_ad);
        Pregister1_ad.add(Pr4_ad);
        Pregister1_ad.add(Pr5_ad);
        Pregister1_ad.add(Pr6_ad);
        Pregister1_ad.add(Pr7_ad);
        Pregister1_ad.add(Pr8_ad);
        Pregister1_ad.add(Pr9_ad);
        Pregister1_ad.add(Pr10_ad);
        Pregister1_ad.add(Pr11_ad);
        Pregister1_ad.add(Pr12_ad);
        Pregister1_ad.add(Pr13_ad);
        Pregister1_ad.add(Pr14_ad);
        Pregister1_ad.add(Pr15_ad);
        Pregister1_ad.add(Pr16_ad);
        Pregister1_ad.add(Pr17_ad);
        Pregister1_ad.add(Pr18_ad);
        Pregister1_ad.add(Pr19_ad);
        Pregister1_ad.add(Pr20_ad);
//----------------------------------Delete clients panels----------------------------------//

        JPanel Pdelete_ad = new JPanel(new GridLayout(4,1)) ;
        JPanel P_delete_username = new JPanel();
        JPanel P_delete_password = new JPanel();
        JPanel P_delete_btn = new JPanel();
        JPanel P_delete_Error = new JPanel();
        
        Pdelete_ad.add(P_delete_username);
        Pdelete_ad.add(P_delete_password);
        Pdelete_ad.add(P_delete_btn);
        Pdelete_ad.add(P_delete_Error);



        admin_tabs.add("Edit Client Info", Pprofile_ad);
        admin_tabs.add("Deposit", Pdeposit_ad);
        admin_tabs.add("Transfer", Ptransfer_ad);
        admin_tabs.add("Withdraw", Pwithdraw_ad);
        admin_tabs.add("Transactions", Ptransactions_ad);
        admin_tabs.add("View Balance", Pview_balance_ad);
        admin_tabs.add("Register new client", Pregister_ad);
        admin_tabs.add("Delete client", Pdelete_ad);
        
        admin_account.add(admin_tabs);
        
//-------------------------------------Profile tab----------------------------------//        

        l_name_ad = new JLabel("Username");
        l_dob_ad = new JLabel("Date Of Birth");
        l_nationality_ad = new JLabel("Nationality");
        l_gender_ad = new JLabel("Gender");
        l_address_ad = new JLabel("Address");
        l_account_no_ad = new JLabel("Account No.");
        l_account_type_ad = new JLabel("Account Type");
        l_mobile_no_ad = new JLabel("Mobile No.");
        
        tf_name_ad = new JTextField(20);
        tf_name_ad.setText("");
        tf_dob_ad = new JTextField(20);
        tf_dob_ad.setText("");
        tf_nationality_ad = new JTextField(20);
        tf_nationality_ad.setText("");
        tf_gender_ad = new JTextField(20);
        tf_gender_ad.setText("");
        tf_address_ad = new JTextField(20);
        tf_address_ad.setText("");
        tf_account_no_ad = new JTextField(20);
        tf_account_no_ad.setText("");
        tf_account_type_ad = new JTextField(20);
        tf_account_type_ad.setText("");
        tf_mobile_no_ad = new JTextField(20);
        tf_mobile_no_ad.setText("");
        
        //tf_name_ad.setEditable(false);
        tf_dob_ad.setEditable(false); 
        tf_nationality_ad.setEditable(false);
        tf_gender_ad.setEditable(false);
        tf_address_ad.setEditable(false);
        tf_account_no_ad.setEditable(false);
        tf_account_type_ad.setEditable(false);
        tf_mobile_no_ad.setEditable(false);

        profile_edit_btn_ad = new JButton("Edit");
        profile_edit_btn_ad.addActionListener(this);
        profile_save_btn_ad = new JButton("Save");
        profile_save_btn_ad.addActionListener(this);
        
        search_profile = new JButton("Search");
        search_profile.addActionListener(this);

        Pp1_ad.add(l_name_ad);
        Pp2_ad.add(tf_name_ad);
        Pp3_ad.add(l_dob_ad);
        Pp4_ad.add(tf_dob_ad);
        Pp5_ad.add(l_nationality_ad);
        Pp6_ad.add(tf_nationality_ad);
        Pp7_ad.add(l_gender_ad);
        Pp8_ad.add(tf_gender_ad);
        Pp9_ad.add(l_address_ad);
        Pp10_ad.add(tf_address_ad);
        Pp11_ad.add(l_account_no_ad);
        Pp12_ad.add(tf_account_no_ad);
        Pp13_ad.add(l_account_type_ad);
        Pp14_ad.add(tf_account_type_ad);
        Pp15_ad.add(l_mobile_no_ad);
        Pp16_ad.add(tf_mobile_no_ad);
        Pprofile2_ad.add(profile_edit_btn_ad);
        Pprofile2_ad.add(profile_save_btn_ad);
        Pprofile2_ad.add(search_profile);

//----------------------------------Deposit tap------------------------------------//
        //l_user_deposit_ad = new JLabel("User");
        l_name_deposit_ad = new JLabel("Username"); 
//        l_account_no_deposit_ad = new JLabel("Account No."); 
//        l_available_balance_deposit_ad = new JLabel("Available Balance");
        l_amount_deposit_ad = new JLabel("Amount");
        l_response_deposit_ad = new JLabel("");
        
//        tf_user_deposit_ad = new JTextField(20);
//        tf_user_deposit_ad.setText("");
        
        tf_name_deposit_ad = new JTextField(20);
        tf_name_deposit_ad.setText("");
        //tf_name_deposit_ad.setEditable(false);
        
//        tf_account_no_deposit_ad = new JTextField(20);
//        tf_account_no_deposit_ad.setText("");
//        tf_account_no_deposit_ad.setEditable(false);
//        
//        tf_available_balance_deposit_ad = new JTextField(20);
//        tf_available_balance_deposit_ad.setText("");
//        tf_available_balance_deposit_ad.setEditable(false);
        
        tf_amount_deposit_ad = new JTextField(20);
        tf_amount_deposit_ad.setText("");

        deposit_btn_ad = new JButton("Deposit");
        deposit_btn_ad.addActionListener(this);
  
        
//        Pd1_ad.add(l_user_deposit_ad);
//        Pd2_ad.add(tf_user_deposit_ad);
        Pd3_ad.add(l_name_deposit_ad);
        Pd4_ad.add(tf_name_deposit_ad);
//        Pd5_ad.add(l_account_no_deposit_ad);
//        Pd6_ad.add(tf_account_no_deposit_ad);
//        Pd7_ad.add(l_available_balance_deposit_ad);
//        Pd8_ad.add(tf_available_balance_deposit_ad);
        Pd9_ad.add(l_amount_deposit_ad);
        Pd10_ad.add(tf_amount_deposit_ad);
        //Pd11_ad.add(l_response_deposit_ad);
        Pdeposit2_ad.add(deposit_btn_ad);
        Pdeposit3_ad.add(l_response_deposit_ad);
 
//------------------------------Transfer Tab------------------------------------//

        //l_user_transfer_ad = new JLabel("User");
        l_name_transfer_ad = new JLabel("Username"); 
//        l_account_no_transfer_ad = new JLabel("Account No."); 
//        l_available_balance_transfer_ad = new JLabel("Available Balance");
        l_amount_transfer_ad = new JLabel("Amount");
        l_target_acc_id_ad = new JLabel("Target Account ID"); 
        l_response_transfer_ad = new JLabel("");
        
//        tf_user_transfer_ad = new JTextField(20);
//        tf_user_transfer_ad.setText("");
//        
        tf_name_transfer_ad = new JTextField(20);
        tf_name_transfer_ad.setText("");
       // tf_name_transfer_ad.setEditable(false);
        
//        tf_account_no_transfer_ad = new JTextField(20);
//        tf_account_no_transfer_ad.setText("");
//        tf_account_no_transfer_ad.setEditable(false);
//        
//        tf_available_balance_transfer_ad = new JTextField(20);
//        tf_available_balance_transfer_ad.setText("");
//        tf_available_balance_transfer_ad.setEditable(false);
        
        tf_amount_transfer_ad = new JTextField(20);
        tf_amount_transfer_ad.setText("");
        
        tf_target_acc_id_ad = new JTextField(20);
        tf_target_acc_id_ad.setText("");
        
        transfer_btn_ad = new JButton("Transfer");
        transfer_btn_ad.addActionListener(this);
        
//        Pt1_ad.add(l_user_transfer_ad);
//        Pt2_ad.add(tf_user_transfer_ad);
        Pt3_ad.add(l_name_transfer_ad);
        Pt4_ad.add(tf_name_transfer_ad);
//        Pt5_ad.add(l_account_no_transfer_ad);
//        Pt6_ad.add(tf_account_no_transfer_ad);
//        Pt7_ad.add(l_available_balance_transfer_ad);
//        Pt8_ad.add(tf_available_balance_transfer_ad);
        Pt9_ad.add(l_amount_transfer_ad);
        Pt10_ad.add(tf_amount_transfer_ad);
        Pt11_ad.add(l_target_acc_id_ad);
        Pt12_ad.add(tf_target_acc_id_ad);
        //Pt13_ad.add(l_response_transfer_ad);
        Ptransfer2_ad.add(transfer_btn_ad);
        Ptransfer3_ad.add(l_response_transfer_ad);
        
 //---------------------------------------Withdraw Tap-------------------------------------//
       
        //l_user_withdraw_ad = new JLabel("User");
        l_name_withdraw_ad = new JLabel("Username"); 
//        l_account_no_withdraw_ad = new JLabel("Account No."); 
//        l_available_balance_withdraw_ad = new JLabel("Available Balance");
        l_amount_withdraw_ad = new JLabel("Amount");
        l_response_withdraw_ad = new JLabel("");
        
//        tf_user_withdraw_ad = new JTextField(20);
//        tf_user_withdraw_ad.setText("");
        
        tf_name_withdraw_ad = new JTextField(20);
        tf_name_withdraw_ad.setText("");
        //tf_name_withdraw_ad.setEditable(false);
        
//        tf_account_no_withdraw_ad = new JTextField(20);
//        tf_account_no_withdraw_ad.setText("");
//        tf_account_no_withdraw_ad.setEditable(false);
//        
//        tf_available_balance_withdraw_ad = new JTextField(20);
//        tf_available_balance_withdraw_ad.setText("");
//        tf_available_balance_withdraw_ad.setEditable(false);
         
        tf_amount_withdraw_ad = new JTextField(20);
        tf_amount_withdraw_ad.setText("");

        withdraw_btn_ad = new JButton("Withdraw");
        withdraw_btn_ad.addActionListener(this);
        
        //Pw1_ad.add(l_user_withdraw_ad);
        //Pw2_ad.add(tf_user_withdraw_ad);
        Pw3_ad.add(l_name_withdraw_ad);
        Pw4_ad.add(tf_name_withdraw_ad);
//        Pw5_ad.add(l_account_no_withdraw_ad);
//        Pw6_ad.add(tf_account_no_withdraw_ad);
//        Pw7_ad.add(l_available_balance_withdraw_ad);
//        Pw8_ad.add(tf_available_balance_withdraw_ad);
        Pw9_ad.add(l_amount_withdraw_ad);
        Pw10_ad.add(tf_amount_withdraw_ad);
        //Pw11_ad.add(l_response_withdraw_ad);
        Pwithdraw2_ad.add(withdraw_btn_ad);
        Pwithdraw3_ad.add(l_response_withdraw_ad);
        
//--------------------------------------Transactions Tab---------------------------------//


//        String[][] data = {
//          { "1", "a", "1", "1" },
//          { "2", "b", "2", "2" }
//        };
        // Column Names
        String[] columnNames_ad = { "Account No.", "Amount", "Type", "Transaction ID", "Target Account ID" };
        model_ad = new DefaultTableModel(columnNames, 0);
        
        // Initializing the JTable
        transactions_ad = new JTable(model_ad);
        transactions_ad.setBounds(30, 40, 200, 300);
        
        update_ad = new JButton("Update");
        update_ad.addActionListener(this);
        
        // adding it to JScrollPane
        JScrollPane sp_ad = new JScrollPane(transactions_ad);
        Ptransactions1_ad.add(sp_ad);
        Ptransactions2_ad.add(update_ad);
 
//----------------------------------View Balance Tab--------------------------------//

        //l_user_view_ad = new JLabel("User");
        l_name_view_ad = new JLabel("Username"); 
        l_account_no_view_ad = new JLabel("Account No."); 
        //l_micr_no_view_ad = new JLabel("MICR No."); 
       // l_roi_view_ad = new JLabel("Rate of Interest (%)");
        l_available_balance_view_ad = new JLabel("Available Balance");
        //l_mod_balance_view_ad = new JLabel("MOD Balance");
        
       // tf_user_view_ad = new JTextField(20);
        //tf_user_view_ad.setText("");
        
        tf_name_view_ad = new JTextField(20);
        tf_name_view_ad.setText("");
        //tf_name_view_ad.setEditable(false);
        
        tf_account_no_view_ad = new JTextField(20);
        tf_account_no_view_ad.setText("");
        tf_account_no_view_ad.setEditable(false);
        
//        tf_micr_no_view_ad = new JTextField(20);
//        tf_micr_no_view_ad.setText("");
//        tf_micr_no_view_ad.setEditable(false);
        
//        tf_roi_view_ad = new JTextField(20);
//        tf_roi_view_ad.setText("");
//        tf_roi_view_ad.setEditable(false);
        
        tf_available_balance_view_ad = new JTextField(20);
        tf_available_balance_view_ad.setText("");
        tf_available_balance_view_ad.setEditable(false);
        
//        tf_mod_balance_view_ad = new JTextField(20);
//        tf_mod_balance_view_ad.setText("");
//        tf_mod_balance_view_ad.setEditable(false);

        search_view_ad = new JButton("Search");
        search_view_ad.addActionListener(this);
        
        refresh_ad = new JButton("Refresh");
        refresh_ad.addActionListener(this);
        
        //Pv1_ad.add(l_user_view_ad);
       // Pv2_ad.add(tf_user_view_ad);
        Pv3_ad.add(l_name_view_ad);
        Pv4_ad.add(tf_name_view_ad);
        Pv5_ad.add(l_account_no_view_ad);
        Pv6_ad.add(tf_account_no_view_ad);
//        Pv7_ad.add(l_micr_no_view_ad);
//        Pv8_ad.add(tf_micr_no_view_ad);
//        Pv7_ad.add(l_roi_view_ad);
//        Pv8_ad.add(tf_roi_view_ad);
        Pv7_ad.add(l_available_balance_view_ad);
        Pv8_ad.add(tf_available_balance_view_ad);
        Pview_balance2_ad.add(search_view_ad);
        Pview_balance2_ad.add(refresh_ad);
        
//        Pv13_ad.add(l_mod_balance_view_ad);
//        Pv14_ad.add(tf_mod_balance_view_ad);
        
        
//----------------------------------Register new client panels----------------------------------//

        l_reg_name = new JLabel("Name");
        l_reg_dob = new JLabel("Date Of Birth");
        l_reg_nationality = new JLabel("Nationality");
        l_reg_gender = new JLabel("Gender");
        l_reg_address = new JLabel("Address");
        l_age_register = new JLabel("Age");
        l_reg_account_type = new JLabel("Account Type");
        l_reg_mobile_no = new JLabel("Mobile No.");
        l_response_register = new JLabel("");
        l_balance_register = new JLabel("Balance");
        l_password_register = new JLabel("Password");
        
        tf_reg_name = new JTextField(20);
        tf_reg_name.setText("");
        tf_reg_dob = new JTextField(20);
        tf_reg_dob.setText("");
        tf_reg_nationality = new JTextField(20);
        tf_reg_nationality.setText("");
        tf_reg_gender = new JTextField(20);
        tf_reg_gender.setText("");
        tf_reg_address = new JTextField(20);
        tf_reg_address.setText("");
        tf_age_register = new JTextField(20);
        tf_age_register.setText("");
        tf_reg_account_type = new JTextField(20);
        tf_reg_account_type.setText("");
        tf_reg_mobile_no = new JTextField(20);
        tf_reg_mobile_no.setText("");
        tf_balance_register = new JTextField(20);
        tf_balance_register.setText("");
        tf_password_register = new JTextField(20);
        tf_password_register.setText("");
        
        tf_reg_name.setEditable(true);
        tf_reg_dob.setEditable(true); 
        tf_reg_nationality.setEditable(true);
        tf_reg_gender.setEditable(true);
        tf_reg_address.setEditable(true);
        tf_age_register.setEditable(true);
        tf_reg_account_type.setEditable(true);
        tf_reg_mobile_no.setEditable(true);
        tf_balance_register.setEditable(true);
        
        register_done_btn = new JButton("Done");
        register_done_btn.addActionListener(this);
        

        Pr1_ad.add(l_reg_name);
        Pr2_ad.add(tf_reg_name);
        Pr3_ad.add(l_reg_dob);
        Pr4_ad.add(tf_reg_dob);
        Pr5_ad.add(l_reg_nationality);
        Pr6_ad.add(tf_reg_nationality);
        Pr7_ad.add(l_reg_gender);
        Pr8_ad.add(tf_reg_gender);
        Pr9_ad.add(l_reg_address);
        Pr10_ad.add(tf_reg_address);
        Pr11_ad.add(l_age_register);
        Pr12_ad.add(tf_age_register);
        Pr13_ad.add(l_reg_account_type);
        Pr14_ad.add(tf_reg_account_type);
        Pr15_ad.add(l_reg_mobile_no);
        Pr16_ad.add(tf_reg_mobile_no);
        Pr17_ad.add(l_balance_register);
        Pr18_ad.add(tf_balance_register);
        Pr19_ad.add(l_password_register);
        Pr20_ad.add(tf_password_register);
        Pregister2_ad.add(register_done_btn);
        Pregister3_ad.add(l_response_register);        
        
    
//----------------------------------Delete clients panels----------------------------------//

        l_delete_username = new JLabel("Username");
        l_delete_password = new JLabel(" Password ");
        l_delete_Error = new JLabel("");
        
        tf_delete_username = new JTextField(20);
        tf_delete_username.setText("");
        delete_password = new JPasswordField(20);
        delete_password.setText("");
        delete_btn = new JButton("Delete");
        delete_btn.setPreferredSize(new Dimension(100, 50));
        delete_btn.addActionListener(this);
        
        P_delete_username.add(l_delete_username);
        P_delete_username.add(tf_delete_username);
        P_delete_password.add(l_delete_password);
        P_delete_password.add(delete_password);
        P_delete_btn.add(delete_btn);
        P_delete_Error.add(l_delete_Error); 




    }

    public static void main(String[] args) {

        GUI example = new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == login_btn) {
            if("admin".equals(tf_username.getText()) && "admin".equals(password.getText())) { 
               login.setVisible(false);
               admin_account.setVisible(true);
               login.dispose();
            } 
            else if (tf_username.getText().isEmpty() == true && password.getText().isEmpty() == true) {
                l_loginError.setText(" Please Enter the Username and Password ");
            } 
            else if (tf_username.getText().isEmpty() == true && password.getText().isEmpty() == false) {
                l_loginError.setText(" Please Enter the Username");
            }
            else if (tf_username.getText().isEmpty() == false && password.getText().isEmpty() == true) {
                l_loginError.setText(" Please Enter the Password");
            }
            else {
                
                db = DbManager.getInstance();
                String response = db.validateUser(tf_username.getText(), password.getText());
                if(response == "Incorrect username"){
                    l_loginError.setText("User not found");
                }else if(response == "Incorrect password"){
                    l_loginError.setText("Incorrect password");
                }else if(response == "Login Successfully"){
                    c = db.getClient(tf_username.getText());
                    //try_name.setText(c.getName());
                   tf_name.setText(c.getName());
                    String n = c.getName();
                    tf_dob.setText(c.getDob());
                    tf_gender.setText(c.getGender());
                    tf_address.setText(c.getAddress());
                    tf_nationality.setText(c.getNationality());
                    tf_account_no.setText(Integer.toString(c.getAccNo()));
                    
                    tf_name_view.setText(c.getName());
                    tf_mobile_no.setText(Integer.toString(c.getPhNo()));
                    tf_account_no_view.setText(Integer.toString(c.getAccNo()));
                    Account a = c.getClientAccount();
                    tf_account_type.setText(a.getType());
                    
                    tf_available_balance_view.setText(Double.toString(a.getBalance()));
                    //try_available_balance.setText(Double.toString(a.getBalance()));
                  
                    login.setVisible(false);
                    client_account.setVisible(true);
                    login.dispose();
                }
                
                 
            }
        }
        else if (e.getSource() == profile_edit_btn_ad)
        {
            tf_name_ad.setEditable(true);
            tf_dob_ad.setEditable(true); 
            tf_nationality_ad.setEditable(true);
            tf_gender_ad.setEditable(true);
            tf_address_ad.setEditable(true);
            tf_account_no_ad.setEditable(true);
            tf_account_type_ad.setEditable(true);
            tf_mobile_no_ad.setEditable(true);
        }
        else if (e.getSource() == profile_save_btn_ad)
        {
            //................................
            db = db.getInstance();
            tf_name_ad.setEditable(false);
            tf_dob_ad.setEditable(false); 
            tf_nationality_ad.setEditable(false);
            tf_gender_ad.setEditable(false);
            tf_address_ad.setEditable(false);
            tf_account_no_ad.setEditable(false);
            tf_account_type_ad.setEditable(false);
            tf_mobile_no_ad.setEditable(false);
            c = db.getClient(tf_name_ad.getText());
            Account a = c.getClientAccount();
            String pass = c.get_password();
            c.setName(tf_name_ad.getText());
            c.setDob(tf_dob_ad.getText());
            c.setNationality(tf_nationality_ad.getText());
            c.setGender(tf_gender_ad.getText());
            c.setAddress(tf_address_ad.getText());
            c.setAccNo(Integer.parseInt(tf_account_no_ad.getText()));
            a.setType(tf_account_type_ad.getText());
            c.setClientAccount(a);
            c.setPhNo(Integer.parseInt(tf_mobile_no_ad.getText()));
            db.updateClient(tf_name_ad.getText(), c);
        }
        
        else if (e.getSource() == deposit_btn)
        {
            db = DbManager.getInstance();
            double amount = Double.parseDouble(tf_amount_deposit.getText());
            l_response_deposit.setText("Transaction Done Successfully");
            Deposit d = new Deposit(c.getClientAccount());
            d.depositAmount(amount);
            db.updateClient(tf_username.getText(), c);
            db.recordTransaction(c.getId(), amount, "deposit");
        }
        
       else if (e.getSource() == transfer_btn)
        {
            double amount = Double.parseDouble(tf_amount_transfer.getText());
            int targetid = Integer.parseInt(tf_target_acc_id.getText());
            String response = db.validateBalance(c.getName(), amount);
            if(response == "Insufficient Balance"){
                l_response_transfer.setText("Insufficient Funds");
            }else if(response == "Sufficient Balance"){
                l_response_transfer.setText("Transaction Done Successfully");
                    Client target =db.getClient(targetid);
                Transfer t = new Transfer(c.getClientAccount(),target.getClientAccount());
                t.transferAmount(amount);
                db.updateClient(tf_username.getText(), c);
                db.updateClient(targetid, target);
                db.recordTransaction(c.getId(), amount, "transfer",targetid);
            }  
        }
       else if (e.getSource() == withdraw_btn)
        {
           double amount = Double.parseDouble(tf_amount_withdraw.getText());
            String response = db.validateBalance(c.getName(), amount);
            if(response == "Insufficient Balance"){
                l_response_withdraw.setText("Insufficient Funds");
            }else if(response == "Sufficient Balance"){
                l_response_withdraw.setText("Transaction Done Successfully");
                Withdraw w = new Withdraw(c.getClientAccount());
                w.withdrawAmount(amount);
                db.updateClient(tf_username.getText(), c);
                db.recordTransaction(c.getId(), amount, "withdraw");
            } 
        }
        
        if (e.getSource() == register_done_btn)
        {  
            db = db.getInstance();
            String type =tf_reg_account_type.getText();
            
            Account a = new Account(0,Integer.parseInt(tf_balance_register.getText()),type);
    db.createClient(new Client(tf_reg_name.getText(),0, tf_reg_address.getText(), Integer.parseInt(tf_reg_mobile_no.getText()),0, a, tf_reg_gender.getText(), tf_reg_nationality.getText(), tf_reg_dob.getText(),tf_password_register.getText(),Integer.parseInt(tf_age_register.getText()))); 
        }
        if (e.getSource() == delete_btn)
        {
            db = db.getInstance();
            String userName = tf_delete_username.getText();
            String response = db.deleteClient(userName);
            if(response == "username not found"){
                l_delete_Error.setText("User not found");
            }else if(response == "deleted successfully"){
               l_delete_Error.setText("Account Deleted"); 
            }
            
        }
        
        else if (e.getSource() == update)
        {
            DefaultTableModel tableModel = (DefaultTableModel) transactions.getModel();
                  Connection connection = null;
             try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Omar1801246");
           
            //System.out.println("Successully Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
           
            Statement st = connection.createStatement();
            ResultSet rs=st.executeQuery("select * from transaction where clientID = "+c.getId());
            while(rs.next()){
                int id =rs.getInt("transID");
                double amount = rs.getDouble("amount");
                int clientID = rs.getInt("clientID");
                 int targetID = rs.getInt("targetID");
                String type = rs.getString("type");
        
               
                tableModel.addRow(new Object[]{clientID,amount,type,id,targetID});
            }
            
        st.close();
        connection.close();
         }catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         else if (e.getSource() == update_ad)
        {
           
              DefaultTableModel tableModel = (DefaultTableModel) transactions_ad.getModel();
                  Connection connection = null;
             try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Omar1801246");
           
            //System.out.println("Successully Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
           
            Statement st = connection.createStatement();
            ResultSet rs=st.executeQuery("select * from transaction");
            while(rs.next()){
                int id =rs.getInt("transID");
                double amount = rs.getDouble("amount");
                int clientID = rs.getInt("clientID");
                 int targetID = rs.getInt("targetID");
                String type = rs.getString("type");
        
               
                tableModel.addRow(new Object[]{clientID,amount,type,id,targetID});
            }
            
        st.close();
        connection.close();
         }catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
          else if (e.getSource() == refresh)
        {
            Account acc=c.getClientAccount();
           tf_available_balance_view.setText(Double.toString(acc.getBalance()));
        }
           else if (e.getSource() == refresh_ad)
        {
          db = db.getInstance();  
          c =db.getClient(tf_name_view_ad.getText());
          Account acc = c.getClientAccount();
          tf_available_balance_view_ad.setText(Double.toString(acc.getBalance()));
          
        }
        else if (e.getSource() == deposit_btn_ad)
        {
            db = db.getInstance();
            c =db.getClient(tf_name_deposit_ad.getText());
            Account a= c.getClientAccount();
            Deposit d = new Deposit(a);
            d.depositAmount(Double.parseDouble(tf_amount_deposit_ad.getText()));
            db.updateClient(tf_name_deposit_ad.getText(), c);
        }
        else if (e.getSource() == transfer_btn_ad)
        {
            db = db.getInstance();
            int targetID =Integer.parseInt(tf_target_acc_id_ad.getText());
             c =db.getClient(tf_name_transfer_ad.getText());
            Account a= c.getClientAccount();
            Client TargetClient = db.getClient(targetID);
            Account TargetAcc = TargetClient.getClientAccount();
            Transfer t = new Transfer(a,TargetAcc);
            t.transferAmount(Double.parseDouble(tf_amount_transfer_ad.getText()));
            db.updateClient(tf_name_withdraw_ad.getText(), c);
            db.updateClient(targetID, TargetClient);
        }
        else if (e.getSource() == withdraw_btn_ad)
        {
            db = db.getInstance();
            c =db.getClient(tf_name_withdraw_ad.getText());
            Account a= c.getClientAccount();
            Withdraw w = new Withdraw(a);
            w.withdrawAmount(Double.parseDouble(tf_amount_withdraw_ad.getText()));
            db.updateClient(tf_name_withdraw_ad.getText(), c);
            
        }
        
        else if (e.getSource() == search_view_ad)
        {
            db = db.getInstance();
            tf_name_view_ad.getText();
            c = db.getClient(tf_name_view_ad.getText());
            tf_account_no_view_ad.setText(Integer.toString(c.getAccNo()));
            Account a = c.getClientAccount();
            tf_available_balance_view_ad.setText(Double.toString(a.getBalance()));
        }
        else if (e.getSource() == search_profile)
        {
            
            db =db.getInstance();
            c=db.getClient(tf_name_ad.getText());
             tf_dob_ad.setText(c.getDob());
            tf_nationality_ad.setText(c.getNationality()); 
            tf_gender_ad.setText(c.getGender());
            tf_address_ad.setText(c.getAddress());
            tf_account_no_ad.setText(Integer.toString(c.getAccNo()));
            Account a = c.getClientAccount();
            tf_account_type_ad.setText(a.getType());
            tf_mobile_no_ad.setText(Integer.toString(c.getPhNo()));
            
        }
   
        
    }
  

}