package my.oadturk;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DataManager 
{
    private int la_id = 0;
        
    public HashMap<Integer, LearningApp> la = new HashMap<>();
    
    public DataManager()
    {
        // START: Loading dummy data
        
        // Learning APPS
        insertLA("OAD");
        insertLA("SWP");
        
        // Categories
        
        insertCat(getLAId("OAD"), "Category 1");
        insertCat(getLAId("OAD"), "Category 2");
        
        // Learning UNITS
        
        String q = "Which of the following instantiations corresponds to the UML model?";
        String d = "images/desc1.png";
        int dt = 2;
        
        String as1 = "images/a1-1.png";
        int as1t = 2;
        boolean a1c = false;
        
        String as2 = "images/a1-2.png";
        int as2t = 2;
        boolean a2c = true;  
        
        String as3 = "images/a1-3.png";
        int as3t = 2;
        boolean a3c = false;  
        
        String as4 = "";
        int as4t = 0;
        boolean a4c = false;  
        
        insertLU(getLAId("OAD"), q, d, dt, as1, as1t, as2, as2t, as3, as3t, as4, 
                as4t, 3, 1, 0, a1c, a2c, a3c, a4c);
        
        q = "Which of the following texts describes the UML model?";
        d = "images/desc2.png";
        dt = 2;
        
        as1 = "Each project has at least two assigned employees.";
        as1t = 1;
        a1c = false;
        
        as2 = "The maximum number of projects that can be assigned to an employee is 2,\n" +
              "the minimum is 1. Each project has an assigned employee.";
        as2t = 1;
        a2c = true;  
        
        as3 = "";
        as3t = 0;
        a3c = false;  
        
        as4 = "";
        as4t = 0;
        a4c = false;  
        
        insertLU(getLAId("OAD"), q, d, dt, as1, as1t, as2, as2t, as3, as3t, as4, 
                as4t, 3, 1, 0, a1c, a2c, a3c, a4c);
        
        
        q = "Which of the following UML models reflects the domain description?";
        d = "Each project has exactly two assigned employees, each employee works for exactly one project.";
        dt = 1;
        
        as1 = "images/a3-1.png";
        as1t = 2;
        a1c = false;
        
        as2 = "images/a3-2.png";
        as2t = 2;
        a2c = false;  
        
        as3 = "images/a3-3.png";
        as3t = 2;
        a3c = true;  
        
        as4 = "";
        as4t = 0;
        a4c = false;  
        
        insertLU(getLAId("OAD"), q, d, dt, as1, as1t, as2, as2t, as3, as3t, as4, 
                as4t, 3, 1, 0, a1c, a2c, a3c, a4c);
        
        
        q = "What is a „conceptual class diagram“?";
        d = "";
        dt = 0;
        
        as1 = "UML class diagram used in the context of the analysis phase of a project.";
        as1t = 1;
        a1c = true;
        
        as2 = "A diagram that describes the software system‘s component structure?";
        as2t = 1;
        a2c = false;  
        
        as3 = "";
        as3t = 0;
        a3c = false;  
        
        as4 = "";
        as4t = 0;
        a4c = false;  
        
        insertLU(getLAId("OAD"), q, d, dt, as1, as1t, as2, as2t, as3, as3t, as4, 
                as4t, 3, 1, 1, a1c, a2c, a3c, a4c);
        
        // Exams
        Calendar dat = Calendar.getInstance();
        dat.set(2017, 11, 26, 19, 20, 0);
        
        int exid = insertExam(getLAId("OAD"), dat, 1, 4, 1);
        
        ArrayList<Integer> questions = new ArrayList<>();
        questions.add(0);
        questions.add(1);
        questions.add(2);
        questions.add(3);
    
        insertExamQuestions(getLAId("OAD"), exid, questions);
        
        
        // END: Loading dummy data
        
        // TODO: Load from database
    }
    
    public boolean insertLA(String name)
    {
        LearningApp new_la = new LearningApp(la_id, name);
        la.put(la_id, new_la);
        
        
        // TODO: Insert into database
        
        la_id++;
        return true;
    }
    
    public boolean deleteLA(int id)
    {
        la.remove(id);
        
        
        // TODO: Delete from database
        
        return true; 
    }
    
    public int getLAId(String name)
    {
        for(HashMap.Entry<Integer, LearningApp> entry : la.entrySet())
        {
            if(entry.getValue().name.equals(name))
                return entry.getKey();
        }
        
        return -1;
    }
    
    public int getCatId(int laid, String name)
    {
        LearningApp lapp = la.get(laid);
        for(HashMap.Entry<Integer, String> entry : lapp.categories.entrySet())
        {
            if(entry.getValue().equals(name))
                return entry.getKey();
        }
        
        return -1;
    }
    
    public boolean insertLU(int laid, String q, String d, int dt, String as1, 
                int as1t, String as2, int as2t, String as3, int as3t, 
                String as4, int as4t, int creator, int app, int cat,
                 boolean a1c, boolean a2c, boolean a3c, boolean a4c)
    {
        LearningUnit lunit = new LearningUnit(q, d, dt, as1, as1t, as2, as2t, 
                as3, as3t, as4, as4t, creator, app, cat, a1c, a2c, a3c, a4c);
        
        LearningApp lapp = la.get(laid);
        lapp.addLearningUnit(lunit);
        
        // TODO: Insert into database
        
        return true;
    }
    
    public boolean editLU(int laid, int luid, String q, String d, int dt,  
                int as1t, String as2, int as2t, String as3, int as3t, 
                String as1, String as4, int as4t, int creator, int app, int cat,
                boolean a1c, boolean a2c, boolean a3c, boolean a4c)
    {
        LearningApp lapp = la.get(laid);
        LearningUnit lunit = lapp.lu.get(luid);
        
        lunit.editLearningUnit(q, d, dt, as1, as1t, as2, as2t, 
                as3, as3t, as4, as4t, creator, app, cat, a1c, a2c, a3c, a4c);
        
        // TODO: Update in database
        
        return true;
    }
    
    public boolean deleteLU(int laid, int luid)
    {
        LearningApp lapp = la.get(laid);
        lapp.deleteLearningUnit(luid);
        
        // TODO: Delete from database
        
        return true;
    }
    
    public boolean insertCat(int laid, String name)
    {
        LearningApp lapp = la.get(laid);
        lapp.addCategory(name);
        
        
        // TODO: Insert into database
        
        return true;
    }
    
    public boolean deleteCat(int laid, int id)
    {
        LearningApp lapp = la.get(laid);
        lapp.deleteCategory(id);
        
        
        // TODO: Delete from database
        
        return true; 
    }
    
    
    public int insertExam(int laid, Calendar d, int t, int num, int pts)
    {
        LearningApp lapp = la.get(laid);
        Exam ex = new Exam(d, t, num, pts);
        
        
        // TODO: Insert into database
        
        return lapp.addExam(ex);
    }
    
    public boolean insertExamQuestions(int laid, int exid, ArrayList<Integer> list)
    {
        LearningApp lapp = la.get(laid);
        for(Integer temp : list) 
        {
            lapp.exam.get(exid).insertExamQuestion(temp);
	}
        
        
        // TODO: Insert in database
        
        
        return true;
    }
    
    
    public boolean insertExamCategories(int laid, int exid, HashMap<Integer, Integer> list)
    {
        LearningApp lapp = la.get(laid);
        for(HashMap.Entry<Integer, Integer> entry : list.entrySet()) 
        {
            lapp.exam.get(exid).insertExamCategory(entry.getKey(), entry.getValue());
	}
        
        
        // TODO: Insert in database
        
        
        return true;
    }
    
    public boolean deleteExam(int laid, int id)
    {
        LearningApp lapp = la.get(laid);
        lapp.deleteExam(id);
        
        
        // TODO: Delete from database
        
        return true; 
    }
    
}
