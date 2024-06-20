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
    }

    public cuenta(JSONObject d) throws IOException {
        this.username = d.getString("username");
        this.password = d.getString("password");
        this.isAdmin = d.getBoolean("isAdmin");
        this.carrito = d.getJSONArray("carrito");
        this.wishList = d.getJSONArray("wishList");
        this.history = d.getJSONArray("history");
    }

    @Override
    public JSONObject nodeToJson() {
        JSONObject d = new JSONObject();
        JSONArray carrito = new JSONArray(this.carrito);
        JSONArray wishList = new JSONArray(this.wishList);
        JSONArray history = new JSONArray(this.history);
        d.put("username", this.username);
        d.put("password", this.password);
        d.put("isAdmin", this.isAdmin);
        d.put("carrito", carrito);
        d.put("wishList", wishList);
        d.put("history", history);

        return d;
    }

}
