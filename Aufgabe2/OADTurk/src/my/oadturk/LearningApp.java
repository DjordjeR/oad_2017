package my.oadturk;

import java.util.HashMap;

public class LearningApp 
{
    public int id;
    public String name;
    
    private int exam_id = 1;    
    
    public HashMap<Integer, LearningUnit> lu = new HashMap<>();
    public HashMap<Integer, Exam> exam = new HashMap<>();
    public HashMap<Integer, String> categories = new HashMap<>();
    public HashMap<Integer, Material> materials = new HashMap();
    
    
    public LearningApp(int i, String s)
    {
        id = i;
        name = s;
    }
               
    public int addExam(Exam ex)
    {
        exam.put(exam_id++, ex);
        
        return exam_id - 1;
    }
    
    public void deleteExam(int i)
    {
        exam.remove(i);
    }
        
}
