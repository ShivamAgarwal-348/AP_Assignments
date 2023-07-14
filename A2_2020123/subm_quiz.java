public class subm_quiz {
    
    private student st;
    private instructor it;
    private boolean submitted ;
    private boolean graded ; 
    private int marks;
    private String ans;

    public subm_quiz()
    {
        submitted = false;
        graded = false;
    }

    public void set_ans(String s,student s1)
    {
        ans = s;
        submitted = true;
        st = s1;
    }
    public void grade(instructor i,int m)
    {
        it = i;
        marks = m;
        graded = true;
    }
    public boolean get_submitted()
    {
        return submitted;
    }
    public boolean get_graded()
    {
        return graded;
    }
    public void print_marks()
    {
        System.out.println("Answer given: " + ans);
        System.out.println("Marks Scored: " + marks);
        System.out.println("Graded by: " + it.get_name());
    }
    public student get_stu()
    {
        return st;
    }
    public String get_file()
    {
        return this.ans;
    }

}
