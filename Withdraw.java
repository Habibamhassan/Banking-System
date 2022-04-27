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
    private float WithdrawAmount;
    public void setWithdrawAmount(float WithdrawAmount) {
        this.WithdrawAmount = WithdrawAmount;
    }
    public float getWithdrawAmount() {
        return WithdrawAmount;
    }
    public Withdraw(Client MainClient , float WithdrawAmount){
        this.MainClient = MainClient;
        this.WithdrawAmount = WithdrawAmount;
    }
    
}
