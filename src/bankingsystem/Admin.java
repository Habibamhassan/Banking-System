/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author lenovo
 */
public class Admin extends User {
    public Admin(String N,int Age,int Id){
        Name=N;
        this.Age=Age;
        this.Id=Id;
  
    }
    public void RegisterClient(String N,int Age,int Id,String A,int P,int Acc,Account c, String g, String n, String d, String pass, int age){
        Client C = new Client(N, Id, A, P, Acc, c, g, n, d, pass, age);
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
}