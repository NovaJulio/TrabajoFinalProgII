package com.mycompany.tranbajofinalprogii.Logic;

import org.json.JSONObject;

public class Elemento extends node {
    public String elementName;
    public String imgDir;
    public String tag;
    public float price;

    public Elemento(String elementName, String imgDir, String tag, float price) {
        this.elementName = elementName;
        this.imgDir = imgDir;
        this.tag = tag;
        this.price = price;
    }

    public Elemento(JSONObject d) {
        this.elementName = d.getString("elementName");
        this.imgDir = d.getString("imgDir");
        this.tag = d.getString("tag");
        this.price = d.getFloat("price");
    }

    @Override
    public JSONObject nodeToJson() {
        JSONObject d = new JSONObject();
        d.put("elementName", this.elementName);
        d.put("imgDir", this.imgDir);
        d.put("tag", this.tag);
        d.put("price", this.price);
        return d;
    }

}
