/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tranbajofinalprogii.Logic;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class cuenta extends node {
    public String username;
    public String password;
    public boolean isAdmin;
    public list carrito;
    public list wishList;
    public list history;

    public cuenta(String username, String password) {
        this.username = username;
        this.password = password;
        carrito = new list();
        wishList = new list();
        history = new list();
    }

    public cuenta(JSONObject d) throws IOException {
        this.username = d.getString("username");
        this.password = d.getString("password");
        this.isAdmin = d.getBoolean("isAdmin");

        JSONArray carrito = d.getJSONArray("carrito");
        JSONArray wishList = d.getJSONArray("wishList");
        JSONArray history = d.getJSONArray("history");

        if (carrito.length() > 0) {
            for (int i = 0; i < carrito.length(); i++) {
                JSONObject x = carrito.getJSONObject(i);
                this.carrito.createnode(new Elemento(x));
            }
        } else {
            this.carrito = new list();
        }

        if (wishList.length() > 0) {
            for (int i = 0; i < wishList.length(); i++) {
                JSONObject x = wishList.getJSONObject(i);
                this.wishList.createnode(new Elemento(x));
            }
        } else {
            this.wishList = new list();
        }

        if (history.length() > 0) {
            for (int i = 0; i < history.length(); i++) {
                JSONObject x = history.getJSONObject(i);
                this.history.createnode(new Elemento(x));
            }
        } else {
            this.history = new list();
        }

    }

    @Override
    public JSONObject nodeToJson() {
        JSONObject d = new JSONObject();
        d.put("username", this.username);
        d.put("password", this.password);
        d.put("isAdmin", this.isAdmin);
        d.put("carrito", carrito.listToJson());
        d.put("wishList", wishList.listToJson());
        d.put("history", history.listToJson());
        return d;
    }

}
