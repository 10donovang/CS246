package com.company;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by darkwarriordono on 5/5/17.
 */
public class User {
    String name;
    @SerializedName("followers_count")
    int followers;


    public String getName(){return name;}

    public void setName(String n){name = n;}

    public int getFollowers(){return followers;}

    public void setFollowers(int f){followers = f;}


}
