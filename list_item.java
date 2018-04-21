package com.example.shivanimathur.hospital;

import java.sql.Blob;

/**
 * Created by shivanimathur on 15/04/18.
 */

public class list_item {
    private String name;

    public list_item(String name){
        setName(name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
