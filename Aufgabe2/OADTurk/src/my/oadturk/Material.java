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
public class Material {
    
    public int added_by;
    public String type;
    public String text;
    
    public Material(int n, String t, String tt)
    {
        added_by = n;
        type = t;
        text = tt;
    }
    
}
