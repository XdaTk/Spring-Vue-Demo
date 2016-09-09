package io.xdatk.vue;


public class Todo {
    private String str;
    private boolean vaild;

    public Todo() {
    }

    public Todo(String str, boolean vaild) {
        this.str = str;
        this.vaild = vaild;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public boolean isVaild() {
        return vaild;
    }

    public void setVaild(boolean vaild) {
        this.vaild = vaild;
    }
}
