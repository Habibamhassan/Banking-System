/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 *
 * @author Habiba
 */
public class Client extends User {
    //protected float Balance;
    protected String Address;
    protected int PhNo;
    protected int accountId;
    protected String password;
    protected Account clientAccount;
    
//    protected int TransferredMoney;
//    protected float PrevTrans;
    public Client(String N, int Id,String A,int P,int Acc, Account C, String g, String n, String d){
        // Database Code to get account info
        Name=N;
        this.Id=Id;
        Address = A;
        PhNo =P;
        accountId=Acc;
        gender = g;
        nationality = n;
        dob = d;
        clientAccount = C;
    }
    
    public Account getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(Account clientAccount) {
        this.clientAccount = clientAccount;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhNo(int PhNo) {
        this.PhNo = PhNo;
    }

    public void setAccNo(int AccNo) {
        this.accountId = AccNo;
    }
    
    public String getAddress() {
        return Address;
    }

    public int getPhNo() {
        return PhNo;
    }

    public int getAccNo() {
        return accountId;
    }
    
    public void get_loan(float amount)
    {
        if(amount <= clientAccount.balance )
        {
                    System.out.println("loan is accepted");
                    clientAccount.balance = clientAccount.balance + amount;
        }
                    
        else
                    System.out.println("loan is rejected");


    }  

    public String get_password() {
        return password;
    }

    public void set_password(String password) {
        this.password = password;
    }
    
}