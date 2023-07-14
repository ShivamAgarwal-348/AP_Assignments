import java.util.*;
public class instructor implements lectures,assessments,Comments{
    
    private String name;

    private ArrayList<lecture_slide> slides;
    private ArrayList<lecture_video> videos;
    private ArrayList<Assignment> assignments;
    private ArrayList<quiz > quizes;
    private ArrayList<comment > comments;

    private static int num_slides;
    private static int num_videos;
    private static int num_assignments;
    private static int num_quizes;
    private static int num_comments;
    
    Scanner sc = new Scanner(System.in);

    public instructor()
    {

    }

    

    public String get_name()
    {
        return this.name;
    }
    public void set_slides(ArrayList<lecture_slide > s)
    {
        this.slides = s;
    }
    public void set_videos(ArrayList<lecture_video > s)
    {
        this.videos = s;
    }public void set_assignments(ArrayList<Assignment > s)
    {
        this.assignments = s;
    }
    public void set_quizes(ArrayList<quiz > s)
    {
        this.quizes = s;
    }
    public void set_comments(ArrayList<comment > s)
    {
        this.comments = s;
    }
    
    public void set_name(String s)
    {
        this.name = s;
    }
    public void set_num_slides(int s)
    {
        this.num_slides = s;
    }
    public void set_num_videos(int s)
    {
        this.num_videos = s;
    }
    public void set_num_assignments(int s)
    {
        this.num_assignments = s;
    }
    public void set_num_quizes(int s)
    {
        this.num_quizes = s;
    }
    public void set_num_comments(int s)
    {
        this.num_comments = s;
    }

    public void instructor_menu()
    {
        System.out.println("------------------------------");
        System.out.println("Welcome " + this.name);
        System.out.println("Instructor Menu");
        System.out.println("1. Add Lectue Slide");
        System.out.println("2. Add Lecture Video");
        System.out.println("3. Add Assignment");
        System.out.println("4. Add Quiz");
        System.out.println("5. View Lectures");
        System.out.println("6. View Assessments");
        System.out.println("7. Grade Assessments");
        System.out.println("8. Close Assessments");
        System.out.println("9. View Comments");
        System.out.println("10. Add Comments");
        System.out.println("11. Logout");
    }
    @Override
    public void view_lectures()
    {
        for(int i = 0;i<num_slides;i++ )
        {
            this.slides.get(i).print_slides();
        }
        for(int i = 0;i<num_videos;i++ )
        {
            this.videos.get(i).print_video();
        }
    }
    @Override
    public void view_assessments()
    {
        for(int i = 0;i<num_assignments;i++ )
        {
            this.assignments.get(i).print_assignment(i);
        }
        for(int i = num_assignments;i<num_assignments+num_quizes;i++ )
        {
            this.quizes.get(i - num_assignments).print_quiz(i);
        }
    }
    @Override
    public void view_com()
    {
        for(int i = 0;i<num_comments;i++ )
        {
            this.comments.get(i).print_comments();
        }
    }
    @Override
    public void add_com()
    {
        this.comments.get(num_comments).add_comment(this.name);
    }

    public void close_assessment()
    {
        System.out.println("List of Open Assignments");

        for(int i = 0;i<num_assignments;i++ )
        {
            if(this.assignments.get(i).if_closed() == false)
            {
                this.assignments.get(i).print_assignment(i);
            }
        }
        for(int i = num_assignments;i<num_assignments+num_quizes;i++ )
        {   
            if(this.quizes.get(i - num_assignments).if_closed() == false)
            {
                this.quizes.get(i - num_assignments).print_quiz(i);
                
            }
        }
        System.out.print("Enter Id of Assignment to close: ");
        int i = sc.nextInt();
        if(i >= num_assignments)
        {
            this.quizes.get(i - num_assignments).close_quiz();
        }
        else
        this.assignments.get(i).close_assignment();
    }

    public void gradeit(int i1)
    {
        boolean flag = false;
        System.out.println(" Choose Id from these ungraded submissions: ");
        
        if(i1 >= num_assignments)
        {
            for(int i = 0;i<3 ;i++)
            {        
                if(this.quizes.get(i1 - num_assignments).get_subquiz(i).get_graded() == false)
                {
                    if(this.quizes.get(i1 - num_assignments).get_subquiz(i).get_submitted() == true)
                    {
                        System.out.println(i + ". " + this.quizes.get(i1 - num_assignments).get_subquiz(i).get_stu().get_name());
                        flag = true;
                    }
                }
            }
            if(flag == true)
            {   int i = sc.nextInt();
                System.out.println("Submission: " + this.quizes.get(i1 - num_assignments).get_subquiz(i).get_file());
                System.out.println("Max marks: "+ 1);
                System.out.print("marks scored: ");
                int m = sc.nextInt();
                this.quizes.get(i1 - num_assignments).get_subquiz(i).grade(this, m);
            }
            else if(flag == false)
            {
                System.out.println("No submissions");
            }
        }
        else
        {
            for(int i = 0;i<3 ;i++)
            {        
                if(this.assignments.get(i1).get_sub_assm(i).get_graded() == false)
                {
                    if(this.assignments.get(i1).get_sub_assm(i).get_submitted() == true)
                    {   System.out.println(i + ". " + this.assignments.get(i1).get_sub_assm(i).get_stu().get_name());
                        flag = true;
                    }   
                }
            }
            if(flag == true)
            {
                int i = sc.nextInt();
            System.out.println("Submission: " + this.assignments.get(i1).get_sub_assm(i).get_file());
            System.out.println("Max marks: "+ this.assignments.get(i1).get_maxmarks());
            System.out.print("marks scored: ");
            int m = sc.nextInt();
            this.assignments.get(i1).get_sub_assm(i).grade(this, m);
            }
            else if (flag == false)
            System.out.println("No submissions");
        }
    }

    

}
