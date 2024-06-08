package com.mycompany.tranbajofinalprogii.Logic;
public class Elemento {
    String elementName;
    String imgDir;
    String tag;
    float price;
    Elemento next;
    public Elemento(String elementName, String imgDir, String tag, float price) {
        this.elementName = elementName;
        this.imgDir = imgDir;
        this.tag = tag;
        this.price = price;
    }
    
}
