/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Habiba
 */
public abstract class User {
    String Name;
    int Age;
    int Id;

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }
    

    public String getName() {
        return Name;
    }
    
    public int getAge() {
        return Age;
    }

   
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    
    
}
