/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tranbajofinalprogii.Logic;

public class cuenta {
    String username;
    String password;
    Elemento carrito;
    Elemento wishList;
    Elemento history;
    cuenta next;
    cuenta prev;

    public cuenta(String username, String password) {
        this.username = username;
        this.password = password;
        next =null;
        prev = null;
    }
    
}
