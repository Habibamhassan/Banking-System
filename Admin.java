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
public class Admin extends User {
    public Admin(String N,int Age,int Id){
        Name=N;
        this.Age=Age;
        this.Id=Id;
  
    }
    public void RegisterClient(String N,int Age,int Id,int B,String A,int P,char Acc){
        Client C = new Client(N,Age,Id,B,A,P,Acc);
    }
    public void DeleteClient(Client c){
        c=null;
    }
    public void EditName(Client c,String N){
        c.setName(N);
    }
    public void EditAge(Client c,int A){
        c.setAge(A);
    }
    public void EditId(Client c,int I){
        c.setId(I);
    }
    public void EditAddress(Client c,String A){
        c.setAddress(A);
    }
    public void EditPhNo(Client c,int P){
        c.setPhNo(P);
    }
    public void EditAccNo(Client c,char A){
        c.setAccNo(A);
    }
    public int ShowTransHistory(Client c){
        return c.PrevTrans;
    }
    public int CheckBalance(Client c){
        return c.Balance;
    }
    public void TransferMoney(Client c,int Money){
        c.TransferMoney(Money);
    }
    public void DepositeMoney(Client c,int Money){
        if(Money!=0){
            c.setBalance(c.Balance+Money);
            c.setPrevTrans(Money);
        }
    }
    public void WithdrawMoney(Client c,int Money){
        if(Money!=0){
            c.setBalance(c.Balance-Money);
            c.setPrevTrans(Money);
        }
    }
}
