/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Habiba
 */
public class Client extends User {
    protected int Balance;
    protected String Address;
    protected int PhNo;
    protected char AccNo;
    protected int TransferredMoney;
    protected int PrevTrans;
    public Client(String N,int Age,int Id,int B,String A,int P,char Acc){
        Name=N;
        this.Age=Age;
        this.Id=Id;
        Balance = B;
        Address = A;
        PhNo =P;
        AccNo=Acc;
    }
    public void setBalance(int Balance) {
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

    public int getTransferredMoney() {
        return TransferredMoney;
    }
    
   
    public void DepositeMoney(int Money){
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
    public int CheckBalance(){
        return Balance;
    }
    public void TransferMoney(int Money){
        TransferredMoney =Money;
    }
    public int getPrevTrans() {
        if(PrevTrans>0)
            return PrevTrans;
        else if(PrevTrans<0)
            return 0;
        return 0;
    }
    
}
