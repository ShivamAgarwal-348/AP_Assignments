import java.util.*;


public class quiz {
    
    private String question;
    private static int max_marks;
    private boolean close;
    private subm_quiz[] quiz_subs;

    Scanner sc = new Scanner(System.in);
    public quiz()
    {
       max_marks = 1;
       close = false;

       quiz_subs = new subm_quiz[3];
       quiz_subs[0] = new subm_quiz();
       quiz_subs[1] = new subm_quiz();
       quiz_subs[2] = new subm_quiz();
    }
    public String get_question()
    {
        return this.question;
    }
    
    public void add_ques()
    {
        System.out.print("Enter Question: ");
        this.question = sc.nextLine();
        
    }
    public void print_quiz(int j)
    {
        System.out.println("ID: "+ j + ", Question: " + this.question);   
    }
    public void close_quiz()
    {
        this.close = true;
    }
    public subm_quiz get_subquiz(int id)
    {
        return quiz_subs[id];
    }
    public boolean if_closed()
    {
        return close;
    }
}
