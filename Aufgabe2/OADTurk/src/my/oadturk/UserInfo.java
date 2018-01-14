/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.oadturk;

import java.util.HashMap;

/**
 *
 * @author am1704
 */
public class UserInfo {
    
    public String user;
    public String name;
    public String first_name;
    public String surname;
    public String mail;
    public String password;
    public int id;
    public int level;
    public int creator_la = -1;
    public int tutor_la = -1;
    public boolean co_creator = false;
    public boolean tutor = false;
    public String admin_notes;
    
    public HashMap<Integer, RegisteredExam> registered_exams = new HashMap<>();
    public HashMap<Integer, ExamResults> finished_exams = new HashMap<>();
    
    public UserInfo(String u, String n, String fn, String sn, String m, String pw, int i, int lvl)
    {
        user = u;
        name = n;
        first_name = fn;
        surname = sn;
        mail = m;
        password = pw;
        id = i;
        level = lvl;  
    }
    
}
