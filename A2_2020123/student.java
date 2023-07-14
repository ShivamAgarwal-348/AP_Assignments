import java.util.*;

public class student implements lectures,assessments,Comments{
    
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

    public student()
    {

    }
    

    public String get_name()
    {
        return this.name;
    }
    public void set_name(String s)
    {
        this.name = s;
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

    public void student_menu()
    {
        System.out.println("------------------------------");
        System.out.println("Welcome " + this.name);
        System.out.println("Student Menu");
        System.out.println("1. View Lectures");
        System.out.println("2. View Assessments");
        System.out.println("3. Submit Assessments");
        System.out.println("4. View Grades");
        System.out.println("5. View Comments");
        System.out.println("6. Add Comments");
        System.out.println("7. Logout ");
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

    public void submit_assessments(int id)
    {
        System.out.println("Pending Assessments...");

        for(int i = 0;i<num_assignments;i++ )
        {
            if(this.assignments.get(i).if_closed() == false && this.assignments.get(i).get_sub_assm(id).get_submitted() == false)
            {
                this.assignments.get(i).print_assignment(i);
            }
        }
        for(int i = num_assignments;i<num_assignments+num_quizes;i++ )
        {
            if(this.quizes.get(i - num_assignments).if_closed() == false && this.quizes.get(i - num_assignments).get_subquiz(id).get_submitted() == false)
                this.quizes.get(i - num_assignments).print_quiz(i);
        }
        System.out.print("Enter Id of Assessment: ");
        int i = sc.nextInt();
        if(i >= num_assignments)
        {
            System.out.print(this.quizes.get(i - num_assignments).get_question() + ": ");
            this.quizes.get(i - num_assignments).get_subquiz(id).set_ans(sc.next(), this);
        }
        else
        {
            String s1;
            while(true)
            {
                System.out.print("Enter file name of assignment: ");
                s1 = sc.next();
                if(s1.length() > 4 && s1.substring(s1.length()-4).equals(".zip"))
                {
                    break;
                }
                else
                    System.out.println("Incorrect file, Enter Again..");
            }
            this.assignments.get(i).get_sub_assm(id).set_ans(s1, this);


        }
    }

    public void view_grades(int a)
    {
        System.out.println("Graded submissions: ");

        for(int i = 0;i<num_assignments;i++ )
        {
            if(this.assignments.get(i).get_sub_assm(a).get_graded() == true)
            {
                this.assignments.get(i).get_sub_assm(a).print_marks();
            }
        }
        for(int i = num_assignments;i<num_assignments+num_quizes;i++ )
        {
            if(this.quizes.get(i - num_assignments).get_subquiz(a).get_graded() == true)
            {
                this.quizes.get(i - num_assignments).get_subquiz(a).print_marks();
            }
        }

        System.out.println("\nUngraded submissions:");
        for(int i = 0;i<num_assignments;i++ )
        {
            if(this.assignments.get(i).get_sub_assm(a).get_submitted() == true)
            {
                System.out.println("Submission: " + this.assignments.get(i).get_sub_assm(a).get_file());
            }
        }
        for(int i = num_assignments;i<num_assignments+num_quizes;i++ )
        {
            if(this.quizes.get(i - num_assignments).get_subquiz(a).get_submitted() == true)
            {
                System.out.println("Submission: " + this.quizes.get(i - num_assignments).get_subquiz(a).get_file());
            }
        }
    }
}
