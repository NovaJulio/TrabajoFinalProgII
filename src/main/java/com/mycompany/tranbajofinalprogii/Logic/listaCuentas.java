package com.mycompany.tranbajofinalprogii.Logic;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class listaCuentas {

    cuenta cab;

    public listaCuentas() {
        cab = null;
    }

    boolean isEmpty() {
        return cab == null;
    }

    public cuenta searchUser(String User) {
        if (isEmpty()) {
            return null;
        } else {
            cuenta j = cab;
            do {
                if (j.username.equalsIgnoreCase(User)) {
                    return j;
                } else {
                    j = j.next;
                }
            } while (j != cab);
            return null;
        }
    }
    void createCuenta(TextField user, PasswordField pass){
        
    }
}
