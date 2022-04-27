/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystem;

/**
 *
 * @author lenovo
 */
public class Account {
    private char acc_id;
    private double balance;
    private String type;
    private  Client c;

    public Account(char acc_id, float balance, String type, Client c) {
        this.acc_id = acc_id;
        this.balance = balance;
        this.type = type;
        this.c = c;
    }

    

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(char acc_id) {
        this.acc_id = acc_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    public void create(Client c, char acc_id)
    {
         c.setAccNo(acc_id);
    }
}
