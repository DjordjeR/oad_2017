package my.oadturk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class DataManager 
{       
    public HashMap<Integer, UserInfo> users = new HashMap<>();
    public HashMap<Integer, LearningApp> la = new HashMap<>();
    public HashMap<Integer, Application> creator_applications = new HashMap();
    public HashMap<Integer, Feedback> feedbacks = new HashMap();
    
    public static Connection conn = null;
        
        
    public DataManager()
    {
        connect();
        loadUsers();
        loadLAs();
        loadCats();
        loadLUs();
        loadExams();
        loadMaterials();
        loadFeedbacks();
        loadCApplications();
     
        //loadFinishedExams();
        //loadRegisteredExams();
        //loadEvaluations();
        
    }
    
    public static void connect() {
        try {

            String url = "jdbc:sqlite:oadturk.db";
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean loadUsers()
    {
        String sql = "SELECT * FROM Users";
        
        try{
            
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String u = rs.getString("username");
                String fn = rs.getString("name");
                String sn = rs.getString("surname");
                String m = rs.getString("mail");
                String pw = rs.getString("password");
                int uid = rs.getInt("ID");
                int lvl = rs.getInt("level");
                String n = fn + " " + sn;
                
                UserInfo newUser = new UserInfo(u, n, fn, sn, m, pw, uid, lvl);
                newUser.admin_notes = rs.getString("admin_notes");
                newUser.creator_la = rs.getInt("creator_la");
                newUser.tutor_la = rs.getInt("tutor_la");
                newUser.tutor = rs.getInt("tutor") == 1;
                newUser.co_creator = rs.getInt("co_creator") == 1;
                
                users.put(uid, newUser);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
                
         // TODO: Load from database
         
        users.get(1).finished_exams.add(new ExamResults(1, 2, 3));
        users.get(1).registered_exams.add(new RegisteredExam(1, 3));
       
                  
        return true;
    }
    
    public boolean loadLAs()
    {
        String sql = "SELECT * FROM LearningApp";
        
        try{
            
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("ID");
                
                
                la.put(id, new LearningApp(id, name));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
                
        return true;
    }
    
    public boolean loadCats()
    {
        String sql = "SELECT * FROM Categories";
        
        try{
            
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("ID");
                int laid = rs.getInt("laid");
                
                la.get(laid).categories.put(id, name);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return true;
    }
    
    public boolean loadMaterials()
    {
        String sql = "SELECT * FROM Materials";
        
        try{
            
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String text = rs.getString("text");
                int id = rs.getInt("ID");
                int laid = rs.getInt("la_id");
                String type = rs.getString("type");
                int added_by = rs.getInt("added_by");                      
                
                la.get(laid).materials.put(id, new Material(added_by, type, text));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return true;
    }
    
    public boolean loadCApplications()
    {
        String sql = "SELECT * FROM Application";
        
        try{
            
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String text = rs.getString("text");
                int id = rs.getInt("ID");
                int uid = rs.getInt("uid");                   
                
                creator_applications.put(id, new Application(uid, text));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return true;
    }
    
    public boolean loadFeedbacks()
    {
        String sql = "SELECT * FROM Feedback";
        
        try{
            
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                String feedback = rs.getString("feedback");
                int id = rs.getInt("ID");
                int uid = rs.getInt("uid");
                int tutor_id = rs.getInt("tutor_id");
                int laid = rs.getInt("laid");
                int ex_id = rs.getInt("ex_id");
                
                feedbacks.put(id, new Feedback(uid, tutor_id, laid, ex_id, feedback));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return true;
    }
    
    private boolean loadLUs()
    {
                       
        String sql = "SELECT * FROM LearningUnit";
        
        try{
            
            Statement stmt  = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                int laid = rs.getInt("la_id");
                
                String q = rs.getString("question");
                String d = rs.getString("desc");
                int dt = rs.getInt("desc_type");
                
                int created_by = rs.getInt("created_by");
                int app = rs.getInt("approved");
                int cat_id = rs.getInt("cat_id");
                
                String a1 = rs.getString("a1");
                String a2 = rs.getString("a2");
                String a3 = rs.getString("a3");
                String a4 = rs.getString("a4");
                
                int a1t = rs.getInt("a1_type");
                int a2t = rs.getInt("a2_type");
                int a3t = rs.getInt("a3_type");
                int a4t = rs.getInt("a4_type");
                
                boolean a1c = rs.getInt("a1_correct") == 1;
                boolean a2c = rs.getInt("a2_correct") == 1;
                boolean a3c = rs.getInt("a3_correct") == 1;
                boolean a4c = rs.getInt("a4_correct") == 1;
                
                
                LearningUnit lunit = new LearningUnit(q, d, dt, a1, a1t, a2, a2t, 
                a3, a3t, a4, a4t, created_by, app, cat_id, a1c, a2c, a3c, a4c);
                la.get(laid).lu.put(id, lunit);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
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
        dat.set(2018, 9, 25, 23, 59, 00);
        
        unt = Calendar.getInstance();
        unt.set(2018, 9, 31, 23, 59, 00);
        
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
        int la_id = -1;        
        try {
        String generatedColumns[] = { "ID" };
        
        String sql = "INSERT INTO LearningApp (name)" +
                            "VALUES ('" + name + "');";
        
        PreparedStatement stmtInsert = conn.prepareStatement(sql, generatedColumns);
        stmtInsert.executeUpdate();
        
        ResultSet rs = stmtInsert.getGeneratedKeys();
        
        
        if (rs.next()) {
            la_id = (int) rs.getLong(1);
        }
        
        if(la_id == -1)
            return -1;
        
        LearningApp new_la = new LearningApp(la_id, name);
        la.put(la_id, new_la);
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return la_id;
    }
    
    public boolean deleteLA(int id)
    {
        try{
            
            String sql = "DELETE FROM LearningApp WHERE ID = '" + id + "';";
            
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate(sql);
            
            for(HashMap.Entry<Integer, UserInfo> entry : users.entrySet())
            {
                if(entry.getValue().creator_la == id)
                {
                    setCoCreator(entry.getKey(), -1);
                }
                
                if(entry.getValue().tutor_la == id)
                {
                    setTutor(entry.getKey(), -1);
                }
            }
            
            for(HashMap.Entry<Integer, LearningUnit> entry : la.get(id).lu.entrySet())
            {
                deleteLU(id, entry.getKey());
            }
            
             for(HashMap.Entry<Integer, String> entry : la.get(id).categories.entrySet())
            {
                deleteCat(id, entry.getKey());
            }
             
            for(HashMap.Entry<Integer, Material> entry : la.get(id).materials.entrySet())
            {
                removeMaterial(id, entry.getKey());
            }
            
            for(HashMap.Entry<Integer, Exam> entry : la.get(id).exam.entrySet())
            {
                deleteExam(id, entry.getKey());
            }
            
                
            la.remove(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
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
        try {
        
        int a1cor = 0;
        int a2cor = 0;
        int a3cor = 0;
        int a4cor = 0;
        
        if(a1c)
            a1cor = 1;
            
        if(a2c)
            a2cor = 1;
        
        if(a3c)
            a3cor = 1;
        
        if(a4c)
            a4cor = 1;
        
        String generatedColumns[] = { "ID" };
        
        String sql = "INSERT INTO LearningUnit (la_id, question, desc, desc_type, a1, a2, a3, a4, a1_type, a2_type, a3_type, a4_type, a1_correct, a2_correct, a3_correct, a4_correct, created_by, approved, cat_id)" +
                            "VALUES ('" + laid + "', '" + q + "', '" + d + "', '" + dt + "', '" + as1 + "', '" + as2 + "', '" + as3 + "', '" + as4 + "', '" + as1t + "', '" + as2t + "', '" + as3t + "', '" + as4t + "', '" + a1cor + "', '" + a2cor + "', '" + a3cor + "', '" + a4cor + "', '" + creator + "', '" + app + "', '" + cat + "');";
        
        PreparedStatement stmtInsert = conn.prepareStatement(sql, generatedColumns);
        stmtInsert.executeUpdate();
        
        ResultSet rs = stmtInsert.getGeneratedKeys();
        
        int luid = -1;
        if (rs.next()) {
            luid = (int) rs.getLong(1);
        }
        
        if(luid == -1)
            return false;
        
        LearningUnit lunit = new LearningUnit(q, d, dt, as1, as1t, as2, as2t, 
                as3, as3t, as4, as4t, creator, app, cat, a1c, a2c, a3c, a4c);
        la.get(laid).lu.put(luid, lunit);
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
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
        
        int a1cor = 0;
        int a2cor = 0;
        int a3cor = 0;
        int a4cor = 0;
        
        if(a1c)
            a1cor = 1;
        
        if(a2c)
            a2cor = 1;
        
        if(a3c)
            a3cor = 1;
        
        if(a4c)
            a4cor = 1;
        
        try {
            
            String sql = "UPDATE LearningUnit SET question = '" + q + "', desc = '" + d + "', desc_type = '" + dt +"', a1 = '" + as1 +
                                "', a1_type = '" + as1t + "', a2 = '" + as2 + "', a2_type = '" + as2t + "', a3 = '" + as3 + "', a3_type = '" + as3t +
                                "', a4 = '" + as4 + "', a4_type = '" + as4t + "', approved = '" + app + "', cat_id = '" + cat + "', a1_correct = '" + a1cor +
                                "', a2_correct = '" + a2cor + "', a3_correct = '" + a3cor+ "', a4_correct = '" + a4cor + "' WHERE ID = '" + luid + "' AND la_id = '" + laid + "';";
            
             PreparedStatement stmtInsert = conn.prepareStatement(sql);
             stmtInsert.executeUpdate();
             
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return true;
    }
    
    public boolean deleteLU(int laid, int luid)
    {
         try {
            
            String sql = "DELETE FROM LearningUnit WHERE ID = '" + luid + "' AND la_id = '" + laid + "';";
            
             PreparedStatement stmtInsert = conn.prepareStatement(sql);
             stmtInsert.executeUpdate();
             
           
            la.get(laid).lu.remove(luid);
            removeFromExams(laid, luid);
             
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return true;
    }
    
    public int insertCat(int laid, String name)
    {
        int cat_id = -1;        
        try {
        String generatedColumns[] = { "ID" };
        
        String sql = "INSERT INTO Categories (name, laid)" +
                            "VALUES ('" + name + "', '" + laid + "');";
        
        PreparedStatement stmtInsert = conn.prepareStatement(sql, generatedColumns);
        stmtInsert.executeUpdate();
        
        ResultSet rs = stmtInsert.getGeneratedKeys();
        
        if (rs.next()) {
            cat_id = (int) rs.getLong(1);
        }
        
        if(cat_id == -1)
            return -1;
        
        la.get(laid).categories.put(cat_id, name);
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return cat_id;
    }
    
    public boolean deleteCat(int laid, int id)
    {
         try{
            
            String sql = "DELETE FROM Categories WHERE ID = '" + id + "' AND laid = '" + laid + "';";
            
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate(sql);
            
           
            for(HashMap.Entry<Integer, LearningUnit> entry : la.get(laid).lu.entrySet())
            {
                if(entry.getValue().cat_id == id)
                {
                    entry.getValue().cat_id = -1;
                    
                    String sql2= "UPDATE LearningUnit SET cat_id = -1 WHERE ID = '" + entry.getKey() + "' AND laid = '" + laid + "';";
            
                    Statement stmt2  = conn.createStatement();
                    stmt2.executeUpdate(sql2);
                }
            }                      
                
            la.get(laid).categories.remove(id);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return true; 
    }
    
    public boolean saveCat(int laid, int catid, String cat)
    {
        
         try{
            
            String sql= "UPDATE Categories SET name = '" + cat + "' WHERE ID = '" + catid + "' AND laid = '" + laid + "';";
            
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate(sql);
            
           
            la.get(laid).categories.replace(catid, cat);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
                
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
        int ca_id = -1;
        
        try {
        String generatedColumns[] = { "ID" };
        
        String sql = "INSERT INTO Application (uid, text)" +
                            "VALUES ('" + uid + "', '" + reason + "');";
        
        PreparedStatement stmtInsert = conn.prepareStatement(sql, generatedColumns);
        stmtInsert.executeUpdate();
        
        ResultSet rs = stmtInsert.getGeneratedKeys();
        
        if (rs.next()) {
            ca_id = (int) rs.getLong(1);
        }
        
        if(ca_id == -1)
            return -1;
        
        creator_applications.put(ca_id, new Application(uid, reason));
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return ca_id;
    }
    
    public boolean deleteCreatorApplication(int uid)
    {
        
        for(HashMap.Entry<Integer, Application> entry : creator_applications.entrySet())
        {
            if(entry.getValue().uid == uid)
            {
                 creator_applications.remove(entry.getKey());
                 
                 try {

                String sql = "DELETE FROM Application WHERE uid = '" + uid + "');";

                PreparedStatement stmtInsert = conn.prepareStatement(sql);
                stmtInsert.executeUpdate();
                
                } catch ( Exception e ) {
                 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                 System.exit(0);
                }
                 
                 break;
            }
        }
       
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
        
        int tt = 0;
        int cr = 0;
        
        if(tutor)
            tt = 1;
        
        if(co_creator)
            cr = 1;
        
        try {
            
            String sql = "UPDATE Users SET username = '" + u + "', name = '" + fn + "', surname = '" + sn +"', mail = '" + m +
                                "', password = '" + pw + "', level = '" + lvl + "', creator_la = '" + creator_la + "', tutor_la = '" + tutor_la + "', admin_notes = '" + note +
                                "', tutor = '" + tt + "', co_creator = '" + cr + "' WHERE ID = '" + uid + "';";
            
             PreparedStatement stmtInsert = conn.prepareStatement(sql);
             stmtInsert.executeUpdate();
             
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return true;
    }
    
    public boolean registerUser(String u, String n, String fn, String sn, String m, String pw, int lvl)
    {
             
        try {
        String generatedColumns[] = { "ID" };
        
        String sql = "INSERT INTO Users (username, name, surname, mail, password, level)" +
                            "VALUES ('" + u + "', '" + fn + "', '" + sn + "', '" + m + "', '" + pw + "', '" + lvl + "');";
        
        PreparedStatement stmtInsert = conn.prepareStatement(sql, generatedColumns);
        stmtInsert.executeUpdate();
        
        ResultSet rs = stmtInsert.getGeneratedKeys();
        
        int uid = -1;
        if (rs.next()) {
            uid = (int) rs.getLong(1);
        }
        
        if(uid == -1)
            return false;
        
        UserInfo newUser = new UserInfo(u, n, fn, sn, m, pw, uid, lvl);
        users.put(uid, newUser);
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return true;
    }
    
    public boolean deleteUser(int uid)
    {
        users.remove(uid);
        
        try {
            
            String sql = "DELETE FROM Users WHERE ID = '" + uid + "';";
            
             PreparedStatement stmtInsert = conn.prepareStatement(sql);
             stmtInsert.executeUpdate();
             
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
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
        try {

        String sql = "UPDATE Users SET creator_la = '" + laid + "' WHERE ID = '" + uid + "';";
        
        PreparedStatement stmtInsert = conn.prepareStatement(sql);
        stmtInsert.executeUpdate();
        
        users.get(uid).creator_la = laid;
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return true;
    }
    
    public boolean setCoCreator(int uid, int laid)
    {      
        try {

            if(laid != -1)
           {
               String sql = "UPDATE Users SET creator_la = '" + laid + "', co_creator = '1' WHERE ID = '" + uid + "';";
        
                PreparedStatement stmtInsert = conn.prepareStatement(sql);
                stmtInsert.executeUpdate();
        
               users.get(uid).creator_la = laid;
               users.get(uid).co_creator = true;
           }
           else
           {
               String sql = "UPDATE Users SET creator_la = '" + laid + "', co_creator = 0 WHERE ID = '" + uid + "';";
        
                PreparedStatement stmtInsert = conn.prepareStatement(sql);
                stmtInsert.executeUpdate();
                
               users.get(uid).creator_la = laid;
               users.get(uid).co_creator = false;
           }
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
                   
        return true;
    }
    
    
    public boolean setTutor(int uid, int tut)
    {
        try {

            if(tut != -1)
           {
               String sql = "UPDATE Users SET tutor_la = '" + tut + "', tutor = 1 WHERE ID = '" + uid + "';";
        
                PreparedStatement stmtInsert = conn.prepareStatement(sql);
                stmtInsert.executeUpdate();
        
               users.get(uid).tutor_la = tut;
               users.get(uid).tutor = true;
           }
           else
           {
               String sql = "UPDATE Users SET tutor_la = '" + tut + "', tutor = 0 WHERE ID = '" + uid + "';";
        
                PreparedStatement stmtInsert = conn.prepareStatement(sql);
                stmtInsert.executeUpdate();
                
               users.get(uid).tutor_la = tut;
               users.get(uid).tutor = false;
           }
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return true;
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
        try {
        int feedback_id = -1;   
        String generatedColumns[] = { "ID" };
        
        String sql = "INSERT INTO Feedback (uid, tutor_id, laid, ex_id, feedback)" +
                            "VALUES ('" + uid + "', '" + tutor + "', '" + laid + "', '" + exid + "', '" + feedback + "');";
        
        PreparedStatement stmtInsert = conn.prepareStatement(sql, generatedColumns);
        stmtInsert.executeUpdate();
        
        ResultSet rs = stmtInsert.getGeneratedKeys();
        
        if (rs.next()) {
            feedback_id = (int) rs.getLong(1);
        }
        
        if(feedback_id == -1)
            return false;
        
        feedbacks.put(feedback_id, new Feedback(uid, tutor, laid, exid, feedback));
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
                
        return true;
    }
    
    
    public boolean deleteFeedback(int uid, int tutor, int laid, int exid)
    {
         for(HashMap.Entry<Integer, Feedback> entry : feedbacks.entrySet())
         {
             Feedback f = entry.getValue();
             
             if(f.uid == uid && f.ex_id == exid && f.laid == laid && f.tutor_id == tutor)
             {
                 feedbacks.remove(entry.getKey());
                 try {
                String sql = "DELETE FROM Feedback WHERE uid = '" + uid + "' AND tutor_id = '" + tutor + "' AND laid = '" + laid + "' AND ex_id = '" + exid + "';";

                PreparedStatement stmtInsert = conn.prepareStatement(sql);
                stmtInsert.executeUpdate();

                } catch ( Exception e ) {
                 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                 System.exit(0);
                }
                 break;
             }
                 
         }
        
         return true;
    }
    
    public int addNewMaterial(int laid, int name, String type, String text)
    {
        int mat_id = -1;        
        try {
        String generatedColumns[] = { "ID" };
        
        String sql = "INSERT INTO Materials (added_by, type, text, laid)" +
                            "VALUES ('" + name + "', '" + type + "', '" + text + "', '" + laid + "');";
        
        PreparedStatement stmtInsert = conn.prepareStatement(sql, generatedColumns);
        stmtInsert.executeUpdate();
        
        ResultSet rs = stmtInsert.getGeneratedKeys();
        
        
        if (rs.next()) {
            mat_id = (int) rs.getLong(1);
        }
        
        if(mat_id == -1)
            return -1;
        
        la.get(laid).materials.put(mat_id, new Material(name, type, text));
        
        } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
        }
        
        return mat_id;
    }
    
    public boolean removeMaterial(int laid, int id)
    {
        try {
            String sql = "DELETE FROM Materials WHERE laid = '" + laid + "' AND ID = '" + id + "';";

            PreparedStatement stmtInsert = conn.prepareStatement(sql);
            stmtInsert.executeUpdate();

            la.get(laid).materials.remove(id);
        
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
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
