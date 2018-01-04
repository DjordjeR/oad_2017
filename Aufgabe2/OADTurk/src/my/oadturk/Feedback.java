/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.oadturk;

/**
 *
 * @author am1704
 */
public class Feedback {
    
    public int uid;
    public int tutor_id;
    public int laid;
    public int ex_id;
    public String feedback;
    
    public Feedback(int u, int t, int l, int e, String f)
    {
        uid = u;
        tutor_id = t;
        laid = l;
        ex_id = e;
        feedback = f;
    }
}
