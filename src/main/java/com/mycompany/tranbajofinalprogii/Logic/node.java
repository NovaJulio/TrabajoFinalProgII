package com.mycompany.tranbajofinalprogii.Logic;

import org.json.JSONObject;

public abstract class node {
    public node next;
    public node prev;

    public abstract JSONObject nodeToJson();
}
