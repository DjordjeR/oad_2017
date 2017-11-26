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
    
    
    // DataManager
    
    DataManager manager;
    
    // User Info
    
    public String user;
    public String name;
    public String first_name;
    public String surname;
    public String mail;
    public String password;
    public int id;
    public int level;
    
    // Exam Info
    
    // LU Info
        
    public SessionInfo()
    {
        manager = new DataManager();
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
    
    public void updateUserSettings(String u, String n, String fn, String sn, String m, String pw, int i, int lvl)
    {
        user = u;
        name = n;
        first_name = fn;
        surname = sn;
        mail = m;
        password = pw;
        id = i;
        level = lvl;
        
        // Update in database!  
    }
    
    public void registerUser(String u, String n, String fn, String sn, String m, String pw, int i, int lvl)
    {
        updateUserSettings(u, n, fn, sn, m, pw, i, lvl);
        
        // Insert in database
    }
}
