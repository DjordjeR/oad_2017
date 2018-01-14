
package my.oadturk;

import java.util.HashMap;


public class LearningUnit 
{
    public static final int DISABLED = 0;
    public static final int TEXT = 1;
    public static final int IMAGE = 2;
    
    public static final int APPROVED = 1;
    public static final int NOT_APPROVED = 0;
    
    public String question;
    public String desc;
    public int desc_type;
    
    public String a1;
    public int a1_type;
    public boolean a1_correct;
    
    public String a2;
    public int a2_type;
    public boolean a2_correct;
    
    public String a3;
    public int a3_type;
    public boolean a3_correct;
    
    public String a4;
    public int a4_type;
    public boolean a4_correct;
    
    public int created_by;
    public int approved;
    
    public int cat_id;
    
    public HashMap<Integer, Evaluation> evaluations = new HashMap();
    
    public LearningUnit(String q, String d, int dt, String as1, int as1t,
               String as2, int as2t, String as3, int as3t, String as4, int as4t,
               int creator, int app, int cat, boolean a1c, boolean a2c,
               boolean a3c, boolean a4c)
    {
        question = q;
        desc = d;
        desc_type = dt;
        
        a1 = as1;
        a1_type = as1t;
        a1_correct = a1c;
        
        a2 = as2;
        a2_type = as2t;
        a2_correct = a2c;
        
        a3 = as3;
        a3_type = as3t;
        a3_correct = a3c;
        
        a4 = as4;
        a4_type = as4t;
        a4_correct = a4c;
        
        created_by = creator;
        approved = app;
        
        cat_id = cat;
    }
    
    public void editLearningUnit(String q, String d, int dt, String as1, int as1t,
               String as2, int as2t, String as3, int as3t, String as4, int as4t,
               int creator, int app, int cat, boolean a1c, boolean a2c,
               boolean a3c, boolean a4c)
    {
        question = q;
        desc = d;
        desc_type = dt;
        
        a1 = as1;
        a1_type = as1t;
        a1_correct = a1c;
        
        a2 = as2;
        a2_type = as2t;
        a2_correct = a2c;
        
        a3 = as3;
        a3_type = as3t;
        a3_correct = a3c;
        
        a4 = as4;
        a4_type = as4t;
        a4_correct = a4c;
        
        created_by = creator;
        approved = app;
        
        cat_id = cat;
    }  
}
