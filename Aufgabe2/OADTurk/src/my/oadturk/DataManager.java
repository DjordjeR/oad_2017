package my.oadturk;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DataManager 
{
    private int la_id = 0;
    private int user_id = 0;
    private int feedback_id = 0;
    private int ca_id = 0;
        
    public HashMap<Integer, UserInfo> users = new HashMap<>();
    public HashMap<Integer, LearningApp> la = new HashMap<>();
    public HashMap<Integer, Application> creator_applications = new HashMap();
    public HashMap<Integer, Feedback> feedbacks = new HashMap();
    
    public DataManager()
    {
        loadUsers();
        loadLAs();
        loadCats();
        loadLUs();
        loadExams();
        
        //loadEvaluations();
        //loadMaterials();
        //loadFeedbacks();
        //loadCApplications();
        //loadFinishedExams();
        //loadRegisteredExams();
        
    }
    
    public boolean loadUsers()
    {
        registerUser("1", "User Userman", "User", "Userman", "user@oadturk.at", "1", 1);
        registerUser("tutor", "Tutor ElTutore", "Tutor", "ElTutore", "tutor@oadturk.at", "tutor", 1);
        registerUser("cocreator", "CoCreator CoCreatori", "CoCreator", "CoCreatori", "co-creator@oadturk.at", "cocreator", 2);
        registerUser("creator", "Creator Creatori", "Creator", "Creatori", "creator@oadturk.at", "creator", 2);
        registerUser("admin", "Admin Administratore", "Admin", "Administratore", "admin@oadturk.at", "admin", 3);
        setCreator(3, 0);
        setCoCreator(2,0);
        setTutor(1, 0);
        
        users.get(0).finished_exams.add(new ExamResults(0, 2, 3));
        users.get(0).registered_exams.add(new RegisteredExam(0, 0));
        
        // TODO: Load from database
        
        return true;
    }
    
    public boolean loadLAs()
    {
        insertLA("OAD");
        insertLA("SWP");
        
        // TODO: Load from database
        
        return true;
    }
    
    public boolean loadCats()
    {
        insertCat(getLAId("OAD"), "Category 1");
        insertCat(getLAId("OAD"), "Category 2");
        
        // TODO: Load from database
        
        
        return true;
    }
    
    private boolean loadLUs()
    {
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
                as4t, 1, 1, 0, a1c, a2c, a3c, a4c);
        
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
                as4t, 1, 1, 0, a1c, a2c, a3c, a4c);
        
        
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
                as4t, 1, 1, 0, a1c, a2c, a3c, a4c);
        
        
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
                as4t, 2, 1, 1, a1c, a2c, a3c, a4c);
        
           
        // TODO: Load from database
        
        return true;
    }
    
    
    private boolean loadExams()
    {
        Calendar dat = Calendar.getInstance();
        dat.set(2017, 10, 25, 23, 59, 00);
        
        Calendar unt = Calendar.getInstance();
        unt.set(2017, 11, 31, 23, 59, 00);
        
        int exid = insertExam(getLAId("OAD"), "Exam1", dat, unt, 1, 4, 1, 0);
        
        ArrayList<Integer> questions = new ArrayList<>();
        questions.add(0);
        questions.add(1);
        questions.add(2);
        questions.add(3);
    
        insertExamQuestions(getLAId("OAD"), exid, questions);
        
        
        dat = Calendar.getInstance();
        dat.set(2017, 11, 25, 23, 59, 00);
        
        unt = Calendar.getInstance();
        unt.set(2017, 11, 31, 23, 59, 00);
        
        exid = insertExam(getLAId("OAD"), "Exam2", dat, unt, 1, 4, 1, 0);
           
        insertExamQuestions(getLAId("OAD"), exid, questions);
        
        dat = Calendar.getInstance();
        dat.set(2017, 9, 25, 23, 59, 00);
        
        unt = Calendar.getInstance();
        unt.set(2017, 9, 31, 23, 59, 00);
        
        exid = insertExam(getLAId("OAD"), "Exam3", dat, unt, 1, 4, 1, 0);
           
        insertExamQuestions(getLAId("OAD"), exid, questions);
        
        
        dat = Calendar.getInstance();
        dat.set(2018, 9, 25, 23, 59, 00);
        
        unt = Calendar.getInstance();
        unt.set(2018, 9, 31, 23, 59, 00);
        
        exid = insertExam(getLAId("OAD"), "Exam4", dat, unt, 1, 4, 1, 0);
           
        insertExamQuestions(getLAId("OAD"), exid, questions);
        
        // TODO: Load from database
        
        return true;
    }
    
    public int insertLA(String name)
    {
        LearningApp new_la = new LearningApp(la_id, name);
        la.put(la_id, new_la);
        
        
        // TODO: Insert into database
        
        la_id++;
        return la_id - 1;
    }
    
    public boolean deleteLA(int id)
    {
        la.remove(id);
        
        // TODO: Remove user info
        
        
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
    
    public boolean editLU(int laid, int luid, String q, String d, int dt, String as1, 
                int as1t, String as2, int as2t, String as3, int as3t, 
                String as4, int as4t, int app, int cat,
                 boolean a1c, boolean a2c, boolean a3c, boolean a4c)
    {
        LearningApp lapp = la.get(laid);
        LearningUnit lunit = lapp.lu.get(luid);
        
        lunit.cat_id = cat;
        lunit.approved = app;
        
        lunit.question = q;
        lunit.desc = d;
        lunit.desc_type = dt;
        
        lunit.a1 = as1;
        lunit.a2 = as2;
        lunit.a3 = as3;
        lunit.a4 = as4;
        
        lunit.a1_type = as1t;
        lunit.a2_type = as2t;
        lunit.a3_type = as3t;
        lunit.a4_type = as4t;
        
        lunit.a1_correct = a1c;
        lunit.a2_correct = a2c;
        lunit.a3_correct = a3c;
        lunit.a4_correct = a4c;
        
        // TODO: Update in database
        
        return true;
    }
    
    public boolean deleteLU(int laid, int luid)
    {
        LearningApp lapp = la.get(laid);
        lapp.deleteLearningUnit(luid);
        
        removeFromExams(laid, luid);
        
        // TODO: Delete from database
        
        return true;
    }
    
    public int insertCat(int laid, String name)
    {
        LearningApp lapp = la.get(laid);
        
        
        // TODO: Insert into database
        
        return lapp.addCategory(name);
    }
    
    public boolean deleteCat(int laid, int id)
    {
        LearningApp lapp = la.get(laid);
        lapp.deleteCategory(id);
        
        
        // TODO: Delete from database
        
        return true; 
    }
    
    
    public int insertExam(int laid, String n, Calendar d, Calendar u, int t, int num, float pts, int cd)
    {
        LearningApp lapp = la.get(laid);
        Exam ex = new Exam(n, d, u, t, num, pts, cd);
        
        
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
    
    
    public boolean insertExamCategories(int laid, int exid, ArrayList<Integer> list)
    {
        LearningApp lapp = la.get(laid);
        for(int i = 0; i < list.size(); i++) 
        {
            lapp.exam.get(exid).insertExamCategory(list.get(i));
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
    
    public int addCreatorApplication(int uid, String reason)
    {
        creator_applications.put(ca_id++, new Application(uid, reason));
        
        // TODO: Insert in database
        
        return ca_id - 1;
    }
    
    public boolean deleteCreatorApplication(int uid)
    {
        
        for(HashMap.Entry<Integer, Application> entry : creator_applications.entrySet())
        {
            if(entry.getValue().uid == uid)
            {
                 creator_applications.remove(entry.getKey());
            }
        }
       
        
        // TODO: Delete from database
        
        return true;
    }
    
    public int applicationExists(int uid)
    {
        
        for(HashMap.Entry<Integer, Application> entry : creator_applications.entrySet())
        {
            if(entry.getValue().uid == uid)
            {
                 return entry.getKey();
            }
        }
        
        return -1;
    }
    
    
    public boolean updateUserSettings(int uid, String u, String n, String fn, String sn, String m, String pw, int lvl, boolean co_creator, boolean tutor, int creator_la, int tutor_la, String note)
    {
        UserInfo user = users.get(uid);
        
        user.user = u;
        user.name = n;
        user.first_name = fn;
        user.surname = sn;
        user.mail = m;
        user.password = pw;
        user.level = lvl;
        user.co_creator = co_creator;
        user.tutor = tutor;
        user.creator_la = creator_la;
        user.tutor_la = tutor_la;
        user.admin_notes = note;
        
        // TODO: Update in database!  
        
        return true;
    }
    
    public boolean registerUser(String u, String n, String fn, String sn, String m, String pw, int lvl)
    {
        UserInfo newUser = new UserInfo(u, n, fn, sn, m, pw, user_id, lvl);
        users.put(user_id++, newUser);
        
        // TODO: Insert in database
        
        return true;
    }
    
    public boolean deleteUser(int uid)
    {
        users.remove(uid);
        
        // TODO: Delete from database
        
        return true;
    }
    
    public boolean registerForExam(int uid, int laid, int exid)
    {
        users.get(uid).registered_exams.add(new RegisteredExam(laid, exid));
        
        // TODO: Insert in database
        
        return true;
    }
    
    public boolean addFinishedExam(int uid, int l, int e, float points)
    {
        users.get(uid).finished_exams.add(new ExamResults(l, e, points));
        
        // TODO: Insert in database
                
        return true;
    }
    
    public boolean loginUser(String name, String password)
    {
        
        for(HashMap.Entry<Integer, UserInfo> entry : users.entrySet())
        {
            UserInfo user = entry.getValue();
            
            if(user.user.equals(name) && user.password.equals(password))
                return true;
            
            if(user.user.equals(name) && !user.password.equals(password))
                return false;
        }
        
        return false;
    }
    
    
    public boolean userExists(String name)
    {
        for(HashMap.Entry<Integer, UserInfo> entry : users.entrySet())
        {
            UserInfo user = entry.getValue();
            
            if(user.user.equals(name))
                return true;
            
        }
        
        return false;
    }
    
    public int userExistsAdmin(String name)
    {
        for(HashMap.Entry<Integer, UserInfo> entry : users.entrySet())
        {
            UserInfo user = entry.getValue();
            
            if(user.user.equals(name))
                return entry.getKey();
            
        }
        
        return -1;
    }
    
    public boolean mailExists(String mail)
    {
        for(HashMap.Entry<Integer, UserInfo> entry : users.entrySet())
        {
            UserInfo user = entry.getValue();
            
            if(user.mail.equals(mail))
                return true;
            
        }
        
        return false;
    }
    
    public boolean deleteRegisteredExam(int uid, int laid, int exid)
    {
        UserInfo user = users.get(uid);
        
        for(int i = 0; i < user.registered_exams.size(); i++)
        {
            RegisteredExam er = user.registered_exams.get(i);
            
            if(er.exid == exid && er.laid == laid)
            {
                user.registered_exams.remove(i);
                break;
            }
        }
        
        // TODO: Remove from database
        
        
        return true;
    }
    
    
    public boolean examAlreadyFinished(int uid, int laid, int exid)
    {
        UserInfo user = users.get(uid);
        
        for(int i = 0; i < user.finished_exams.size(); i++)
        {
            ExamResults er = user.finished_exams.get(i);
            
            if(er.exam_id == exid && er.laid == laid)
                return true;
        }
        
        return false;
    }

    
    public boolean setCreator(int uid, int laid)
    {
        users.get(uid).creator_la = laid;
        
        
        // TODO: Save in database
        
        return true;
    }
    
    public boolean setCoCreator(int uid, int laid)
    {
        
        if(laid != -1)
        {
            users.get(uid).creator_la = laid;
            users.get(uid).co_creator = true;
        }
        else
        {
            users.get(uid).creator_la = laid;
            users.get(uid).co_creator = false;
        }
            
        
        // TODO: Save in database
        
        return true;
    }
    
    
    public boolean setTutor(int uid, int tut)
    {
         if(tut != -1)
        {
            users.get(uid).tutor_la = tut;
            users.get(uid).tutor = true;
        }
        else
        {
            users.get(uid).tutor_la = tut;
            users.get(uid).tutor = false;
        }
        
        // TODO: Save in database
        
        return true;
    }
    
    
    public boolean deleteCategory(int laid, int catid)
    {
        LearningApp lapp = la.get(laid);
        
        for(HashMap.Entry<Integer, LearningUnit> entry : lapp.lu.entrySet())
        {
            if(entry.getValue().cat_id == catid)
               entry.getValue().cat_id = -1; 
        }
        
        lapp.categories.remove(catid);
        
        // TODO: Delete from database
        
        return true;
    }
    
    public boolean saveCategory(int laid, int catid, String cat)
    {
        LearningApp lapp = la.get(laid);
        lapp.categories.replace(catid, cat);
        
        // TODO: Save in database
        
        return true;
    }
    
    public boolean categoryExists(int laid, String name)
    {
        LearningApp lapp = la.get(laid);
        
        if(lapp.categories.containsValue(name))
            return true;
        
        return false;
    }
    
    public int getCategoryID(int laid, String name)
    {
        int id = -1;
        LearningApp lapp = la.get(laid);
        
        for(HashMap.Entry<Integer, String> entry : lapp.categories.entrySet())
        {
            if(entry.getValue().equals(name))
                return entry.getKey();
        }
        
        return id;
    }
    
    public boolean removeFromExams(int laid, int luid)
    {
            
        LearningApp lapp = la.get(laid);
        
        for(HashMap.Entry<Integer, Exam> entry : lapp.exam.entrySet())
        {
            for(int i = 0; i < entry.getValue().lus.size(); i++)
            {
                if(entry.getValue().lus.get(i) == luid)
                {
                    entry.getValue().lus.remove(i);
                    break;
                }
            }
        }
        
       // TODO: Remove from database
        
        
        return true;
    }
    
    public boolean addFeedback(int uid, int tutor, int laid, int exid, String feedback)
    {
        feedbacks.put(feedback_id++, new Feedback(uid, tutor, laid, exid, feedback));
        
        // TODO: Add to database
        
        return true;
    }
    
    
    public boolean deleteFeedback(int uid, int tutor, int laid, int exid)
    {
         for(int i = 0; i < feedbacks.size(); i++)
         {
             Feedback f = feedbacks.get(i);
             
             if(f.uid == uid && f.ex_id == exid && f.laid == laid && f.tutor_id == tutor)
             {
                 feedbacks.remove(i);
                 // TODO: Delete from database
                 break;
             }
                 
         }
        
         return true;
    }
    
    public int addNewMaterial(int laid, int name, String type, String text)
    {
        
        int id = la.get(laid).addMaterial(new Material(name, type, text));
        
        // TODO: Add to database
        return id;
    }
    
    public boolean removeMaterial(int laid, int id)
    {
        
        la.get(laid).deleteMaterial(id);
        
        // TODO: Remove from database
        
        return true;
    }
    
    
    public int addNewEvaluation(int laid, int luid, int u, int he, int ha, int q, int a, int e)
    {
        
        int id = la.get(laid).lu.get(luid).addEvaluation(new Evaluation(u, he, ha, q, a, e));
        
        // TODO: Add to database
        return id;
    }
    
    public boolean removeEvaluation(int laid, int luid, int id)
    {
        
        la.get(laid).lu.get(luid).deleteEvaluationl(id);
        
        // TODO: Remove from database
        
        return true;
    }
    
    public boolean alreadyEvaluated(int laid, int luid, int uid)
    {
        for(HashMap.Entry<Integer, Evaluation> entry : la.get(laid).lu.get(luid).evaluations.entrySet())
        {
            if(entry.getValue().uid == uid)
                return true;
        }
        
        return false;
    }
}
