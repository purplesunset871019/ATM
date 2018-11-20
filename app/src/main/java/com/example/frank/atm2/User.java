package com.example.frank.atm2;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    private Context context;
    String id;
    String nickname;
    int age;
    String gender;
    String address;
    SharedPreferences settings;
    boolean valid = false;

    public User(Context context) {
        this.context = context;
        settings = context.getSharedPreferences("user", Context.MODE_PRIVATE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        if (nickname == null) {
            nickname = settings.getString("NICKNAME", null);
        }
        return nickname;
    }

    public void setNickname(String nickname) {
        settings.edit()
                .putString("NICKNAME", nickname).apply();
        this.nickname = nickname;
    }

    public int getAge() {
        if (age == 0) {
            age = settings.getInt("AGE", 0);
        }
        return age;
    }

    public void setAge(int age) {
        settings.edit()
                .putInt("AGE", age).apply();
        this.age = age;
    }

    public String getGender() {
        if (gender == null) {
            gender = settings.getString("GENDER", null);
        }
        return gender;
    }

    public void setGender(String gender) {
        settings.edit()
                .putString("GENDER", gender).apply();
        this.gender = gender;
    }

    public boolean isValid() {
        valid = getNickname() != null && age != 0 && gender !=null;
        return valid;
    }

    public String getAddress() {
        address = "dummy address";
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
