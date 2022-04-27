/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystem;

/**
 *
 * @author engah
 */
public class Withdraw extends Transactions {
    
    public Withdraw(Account mainClient){
        this.mainClient = mainClient;
    }
         
    
    public void withdrawAmount(double amount){
        double currentBalance = this.mainClient.getBalance();
        this.mainClient.setBalance(currentBalance - amount);
    }
    
}