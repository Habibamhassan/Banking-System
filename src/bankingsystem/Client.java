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
    protected float Balance;
    protected String Address;
    protected int PhNo;
    protected char AccNo;
    protected int TransferredMoney;
    protected float PrevTrans;
    public Client(String N,int Age,int Id,float B,String A,int P,char Acc){
        Name=N;
        this.Age=Age;
        this.Id=Id;
        Balance = B;
        Address = A;
        PhNo =P;
        AccNo=Acc;
    }
    public void setBalance(float Balance) {
        this.Balance = Balance;
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
        if(amount <= Balance )
        {
                    System.out.println("loan is accepted");
                    Balance= Balance + amount;
        }
                    
        else
                    System.out.println("loan is rejected");


    }
    public int getTransferredMoney() {
        return TransferredMoney;
    }
    
   
    public void DepositeMoney(float Money){
        if(Money!=0){
            Balance+=Money;
            PrevTrans=Money;
        }
    }
    public void WithdrawMoney(int Money){
        if(Money!=0){
            Balance-=Money;
            PrevTrans=Money;
        } 
    }
    public float CheckBalance(){
        return Balance;
    }
    public void TransferMoney(int Money){
        TransferredMoney =Money;
    }
    public float getPrevTrans() {
        if(PrevTrans>0)
            return PrevTrans;
        else if(PrevTrans<0)
            return 0;
        return 0;
    }
    
}
