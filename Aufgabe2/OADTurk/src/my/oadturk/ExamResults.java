package my.oadturk;

public class ExamResults 
{
    public int exam_id;
    public float points;
    public int laid;
    
    public ExamResults(int lid, int eid, float pts)
    {
        laid = lid;
        exam_id = eid;
        points = pts;
    }
}
