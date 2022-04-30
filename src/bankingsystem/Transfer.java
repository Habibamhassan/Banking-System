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
public class Transfer extends Transactions {
    private Account helperClient;
    
    public void setHelperClient(Account HelperClient) {
        this.helperClient = HelperClient;
    }
    public Account geHelperClient() {
        return helperClient;
    }
    public Transfer(Account HelperClient){
        this.helperClient = HelperClient;
    }
    public void transferAmount(double amount){
        Withdraw w = new Withdraw(mainClient);
        Deposit d = new Deposit(helperClient);
        w.withdrawAmount(amount);
        d.depositAmount(amount);
    } 
    
}