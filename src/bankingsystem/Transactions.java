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
public abstract class Transactions {
    protected Account mainClient;
    protected int transactionId;
    
    public void setMainClient(Account main) {
        this.mainClient = main;
    }
    public Account getMainClient() {
        return mainClient;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }
}
