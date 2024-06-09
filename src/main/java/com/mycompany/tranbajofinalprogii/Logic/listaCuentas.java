package com.mycompany.tranbajofinalprogii.Logic;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class listaCuentas {

    cuenta cab;

    public listaCuentas() {
        cab = null;
    }

    // Returna el ultimo elemento
    public cuenta getEnd() {
        cuenta j = cab;
        if (isEmpty()) {
            return null;
        } else {
            j = cab.prev;
            return j;
        }
    }

    // Comprueba si la lista esta vacia
    boolean isEmpty() {
        return cab == null;
    }

    // Busca una cuenta que tenga el nombre de usuario dado, si no la encuentra,
    // returna null
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

    // Crea la cuenta y la añade al final de la lista
    void createCuenta(TextField user, PasswordField pass) {
        if (searchUser(user.getText()) == null) {
            cuenta info = new cuenta(user.getText(), pass.getText());
            cuenta ult = getEnd();
            if (cab == null) {
                cab = info;
                cab.next = cab;
                cab.prev = cab;
            } else if (ult == cab) {
                cab.next = info;
                cab.prev = info;
                info.next = cab;
                info.prev = cab;
            } else {
                ult.next = info;
                info.prev = ult;
                info.next = cab;
                cab.prev = info;
            }
        } else {
            System.out.println("Usuario existente");
        }
    }

    //
}
