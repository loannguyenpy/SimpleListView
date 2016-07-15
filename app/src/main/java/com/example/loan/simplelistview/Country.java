package com.example.loan.simplelistview;

import java.io.PrintStream;
import java.io.Serializable;

/**
 * Created by LOAN on 7/12/2016.
 */
public class Country implements Serializable {
    private String name;
    private String type;
    public Country(String n, String t)
    {
        this.name=n;
        this.type=t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
