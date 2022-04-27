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
    private float DepositAmount;
    public void setDepositAmount(float DepositAmount) {
        this.DepositAmount = DepositAmount;
    }
    public float getDepositAmount() {
        return DepositAmount;
    }
    public Deposit(Client MainClient , float DepositAmount){
        this.MainClient = MainClient;
        this.DepositAmount = DepositAmount;
    }
}
