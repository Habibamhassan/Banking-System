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
    private float TransferAmount;
    private Client HelperClient;
    public void setHelperClient(Client HelperClient) {
        this.HelperClient = HelperClient;
    }
    public Client geHelperClient() {
        return HelperClient;
    }
    public void setTransferAmount(float TransferAmount) {
        this.TransferAmount = TransferAmount;
    }
    public float getTransferAmount() {
        return TransferAmount;
    }
    public Transfer(Client MainClient , Client HelperClient , float TransferAmount){
        this.MainClient = MainClient;
        this.HelperClient = HelperClient;
        this.TransferAmount = TransferAmount;   
    }
    
}
