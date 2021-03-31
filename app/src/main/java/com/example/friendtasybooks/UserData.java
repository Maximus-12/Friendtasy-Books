package com.example.friendtasybooks;

import com.google.firebase.database.IgnoreExtraProperties;

// [START rtdb_user_class]
@IgnoreExtraProperties
public class UserData {
    public int headshot;
    public String username;
    //public int gender;
    public String gender;
    public String city;
    //public String email;

    public UserData() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    //public UserData(String username, String email) {
    //public UserData(int headshot, String username, int gender, String city) {
    public UserData(int headshot, String username, String gender, String city) {
        this.headshot = headshot;
        this.username = username;
        this.gender = gender;
        this.city = city;
    //    this.email = email;
    }

}
// [END rtdb_user_class]