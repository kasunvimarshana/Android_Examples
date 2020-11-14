package com.example.kasun.orm_tool;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by KASUN on 8/27/2016.
 */
@DatabaseTable(tableName="customer")// database eke model 1kata adala table 1e nama mema annotation 1kata damiya youthuya
public class Customer {

    @DatabaseField(generatedId=true)//primary key 1ka(meya db 1n auto increment we emanisa generated Id yodai[meya model in gannawanam @DatabaseField(id=true) lesa yodai])
    private int id;
    @DatabaseField//database collume 1ka
    private String name;
    @DatabaseField
    private String address;
    @DatabaseField
    private String tp;
    @DatabaseField
    private String mobile;
    @DatabaseField
    private String email;
    @DatabaseField
    private String birthDay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString(){
        return name + " - " + mobile;
    }

}
