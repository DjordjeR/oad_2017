/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.oadturk;

import java.util.ArrayList;
import java.util.HashMap;


public class SessionInfo {
    
    // DataManager
    
    DataManager manager;
    
    // User Info
    
    public int id;

    public SessionInfo()
    {
        manager = new DataManager();
        
    }
    
    public String getLevelText()
    {
        UserInfo user = manager.users.get(id);
        
        String text = "";
        if(user.level == 1)
            text = "User";
        else if(user.level == 2)
            text = "Creator";
        else if(user.level == 3)
            text = "Admin";
        
        if(user.tutor)
            text = "Tutor";
        
        if(user.co_creator)
            text = "Co-Creator";
                
        return text;
                   
    }
    
    public void loginUser(String name)
    {
        for(HashMap.Entry<Integer, UserInfo> entry : manager.users.entrySet())
        {
            UserInfo user = entry.getValue();
            
            if(user.user.equals(name))
            {
                id = user.id;
            }
        }
    }
    
}
