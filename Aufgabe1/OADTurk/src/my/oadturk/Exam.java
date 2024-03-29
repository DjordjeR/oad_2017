package my.oadturk;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Exam 
{
    
    public static final int MANUAL_EXAM = 1;
    public static final int AUTOMATIC_EXAM = 0;
    
    public Calendar date;
    public int code;
    public int type;
    public int num_of_questions;
    public int points_per_question;
    
    // Saves ID - Number of questions for category
    public HashMap<Integer, Integer> categories = new HashMap<>();
    // Saves LU Ids
    public ArrayList<Integer> lus = new ArrayList<>();
    
    public Exam(Calendar d, int t, int num, int pts)
    {
        date = d;
        type = t;
        num_of_questions = num;
        points_per_question = pts;
    }
    
    public void insertExamCategory(int cat, int num)
    {
        categories.put(cat, num);
    }
    
    public void insertExamQuestion(int q)
    {
        lus.add(q);
    }
    
    public void deleteExamCategory(int cat)
    {
        categories.remove(cat);
    }
    
    public void deleteExamQuestion(int q)
    {
        lus.remove(lus.indexOf(q));
    }
    
    public void editExam(Calendar d, int t, int num, int pts)
    {
        date = d;
        type = t;
        num_of_questions = num;
        points_per_question = pts;
    }
}
