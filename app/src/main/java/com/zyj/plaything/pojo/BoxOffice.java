package com.zyj.plaything.pojo;

/**
 * 票房
 * Created by Jing on 2016/5/24.
 */
public class BoxOffice {
    private String rid;

    private String name;

    private String wk;

    private String wboxoffice;

    private String tboxoffice;

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRid() {
        return this.rid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setWk(String wk) {
        this.wk = wk;
    }

    public String getWk() {
        return this.wk;
    }

    public void setWboxoffice(String wboxoffice) {
        this.wboxoffice = wboxoffice;
    }

    public String getWboxoffice() {
        return this.wboxoffice;
    }

    public void setTboxoffice(String tboxoffice) {
        this.tboxoffice = tboxoffice;
    }

    public String getTboxoffice() {
        return this.tboxoffice;
    }
}
