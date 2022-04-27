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
    
    public void setHelperClient(Account helperClient) {
        this.helperClient = helperClient;
    }
    public Account geHelperClient() {
        return helperClient;
    }
    public Transfer(Account HelperClient){
        this.helperClient = helperClient;
    }
    
}
