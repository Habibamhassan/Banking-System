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
    protected Client MainClient;
    public void setMainClient(Client MainClient) {
        this.MainClient = MainClient;
    }
    public Client getMainClient() {
        return MainClient;
    }
    
}
