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
    protected char AccNo;
    protected Account clientAccount;
    protected int TransferredMoney;
    protected float PrevTrans;
    public Client(String N,int Age,int Id,String A,int P,char Acc, Account C){
        // Database Code to get account info
        Name=N;
        this.Age=Age;
        this.Id=Id;
        Address = A;
        PhNo =P;
        AccNo=Acc;
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

    public void setAccNo(char AccNo) {
        this.AccNo = AccNo;
    }

    public void setPrevTrans(int PrevTrans) {
        this.PrevTrans = PrevTrans;
    }
    
    public String getAddress() {
        return Address;
    }

    public int getPhNo() {
        return PhNo;
    }

    public char getAccNo() {
        return AccNo;
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
}
