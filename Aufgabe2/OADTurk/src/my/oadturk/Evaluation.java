package my.oadturk;

public class Evaluation {

    public int uid;
    
    public int eval_help;
    public int eval_hard;
    public int eval_quest;
    public int eval_answ;
    
    public int evaluation;
    
    public Evaluation(int u, int he, int ha, int q, int a, int e)
    {
        
        uid = u;
        
        eval_help = he;
        eval_hard = ha;
        eval_quest = q;
        eval_answ = a;
        
        evaluation = e;
    }
    
}
