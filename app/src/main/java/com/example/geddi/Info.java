package com.example.geddi;


class Info {
    private String name;
    private String ref;
    Info(String name, String ref)
    {
        this.name=name;
        this.ref=ref;
    }
    String getName()
    {
        return name;
    }
    String getRef()
    {
        return ref;
    }
}
