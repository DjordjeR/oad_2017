package my.oadturk;

import java.util.ArrayList;
import java.util.Calendar;

public class Exam 
{
    
    public static final int MANUAL_EXAM = 1;
    public static final int AUTOMATIC_EXAM = 0;
    
    public String name;
    public Calendar date;
    public Calendar until;
    public int code;
    public int type;
    public int num_of_questions;
    public float points_per_question;
    
    // Saves ID - Number of questions for category
    public ArrayList<Integer> categories = new ArrayList<>();
    // Saves LU Ids
    public ArrayList<Integer> lus = new ArrayList<>();
    
    public Exam(String n, Calendar d, Calendar u, int t, int num, float pts, int cd)
    {
        name = n;
        date = d;
        until = u;
        type = t;
        num_of_questions = num;
        points_per_question = pts;
        code = cd;
    }
    
    public void insertExamCategory(int cat)
    {
        categories.add(cat);
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
    
    public void editExam(String n, Calendar d, Calendar u, int t, int num, float pts, int cd)
    {
        name = n;
        date = d;
        until = u;
        type = t;
        num_of_questions = num;
        points_per_question = pts;
        code = cd;
    }
}
