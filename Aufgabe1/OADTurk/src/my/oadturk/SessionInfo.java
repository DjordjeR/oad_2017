/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.oadturk;

/**
 *
 * @author gaja
 */
public class SessionInfo {
    
    public String user;
    public String name;
    public int id;
    public int level;
    
    public SessionInfo()
    {
        
    }
    
    public String getLevelText()
    {
        String text = "";
        if(level == 1)
            text = "User";
        else if(level == 2)
            text = "Creator";
        else if(level == 3)
            text = "Admin";
                
        return text;
                   
    }
}
