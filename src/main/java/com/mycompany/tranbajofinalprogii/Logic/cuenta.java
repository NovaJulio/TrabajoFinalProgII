/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tranbajofinalprogii.Logic;

import java.io.IOException;

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
    }

    public cuenta(JSONObject d) throws IOException {
        this.username = d.getString("username");
        this.password = d.getString("password");
        this.isAdmin = d.getBoolean("isAdmin");
        if (d.has("carrito")) {
            this.carrito.importList(System.getProperty("user.dir") + "\\src\\main\\resources\\Data\\AccountList.txt",
                    username, "carrito");
        }
        if (d.has("wishList")) {
            this.wishList.importList(System.getProperty("user.dir") + "\\src\\main\\resources\\Data\\AccountList.txt",
                    username, "wishList");
        }
        if (d.has("history")) {
            this.history.importList(System.getProperty("user.dir") + "\\src\\main\\resources\\Data\\AccountList.txt",
                    username, "history");
        }
    }

    @Override
    public JSONObject nodeToJson() {
        JSONObject d = new JSONObject();
        d.put("username", this.username);
        d.put("password", this.password);
        d.put("isAdmin", this.isAdmin);
        if (carrito != null) {
            d.put("carrito", carrito.listToJson());
        }
        if (wishList != null) {
            d.put("wishList", wishList.listToJson());
        }
        if (history != null) {
            d.put("history", history.listToJson());
        }
        return d;
    }

}
