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
public class Deposit extends Transactions {
    
   
    public void depositAmount(double amount){
        double currentBalance = this.mainClient.getBalance();
        this.mainClient.setBalance(currentBalance + amount);
    }
}
