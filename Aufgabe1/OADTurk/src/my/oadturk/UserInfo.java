/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.oadturk;

import java.util.ArrayList;
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
    
    public ArrayList<RegisteredExam> registered_exams = new ArrayList<>();
    public ArrayList<ExamResults> finished_exams = new ArrayList<>();
    
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
