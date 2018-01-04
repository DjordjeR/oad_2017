package my.oadturk;

import java.util.ArrayList;
import java.util.HashMap;

public class LearningApp 
{
    public int id;
    public String name;
    
    private int lu_id = 0;
    private int exam_id = 0;
    private int cat_id = 0;
    private int mat_id = 0;
    
    public HashMap<Integer, LearningUnit> lu = new HashMap<>();
    public HashMap<Integer, Exam> exam = new HashMap<>();
    public HashMap<Integer, String> categories = new HashMap<>();
    public HashMap<Integer, Material> materials = new HashMap();
    
    public LearningApp(int i, String s)
    {
        id = i;
        name = s;
    }
    
    public int addMaterial(Material mat)
    {
        materials.put(mat_id++, mat);
        
        return mat_id - 1;
    }
    
    public void deleteMaterial(int id)
    {
        materials.remove(id);
    }
    
    public int addLearningUnit(LearningUnit lunit)
    {
        lu.put(lu_id++, lunit);
        
        return lu_id - 1;
    }
    
    public void deleteLearningUnit(int i)
    {
        lu.remove(i);
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
    
    public int addCategory(String n)
    {
        categories.put(cat_id++, n);
        
        return cat_id - 1;
    }
    
    public void deleteCategory(int i)
    {
        categories.remove(i);
    }
    
    
}
