package com.winter_time_studio.coyote;

/**
 * Created by makotonishimoto on 2015/10/11.
 */
public class ProfileList {

    //TODO: API経由でjsonで取得する
    private String[] profileData = { "A", "B", "C", "D"};

    public String[] getProfileData(){
        return profileData;
    }

}
