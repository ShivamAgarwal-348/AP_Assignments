import java.util.*;

public class portal {

    private instructor[] inst ;
    private student[] stu;
    private ArrayList<lecture_slide> slides ;
    private ArrayList<lecture_video> videos ;
    private ArrayList<Assignment> assignments ;
    private ArrayList<quiz > quizes ;
    private ArrayList<comment > comments ;
    

    private int num_slides;
    private int num_videos;
    private int num_assignments;
    private int num_quizes;
    private int num_comments;
    
    portal()
    {
        inst = new instructor[2];
        stu = new student[3];
        slides = new ArrayList<>();
        videos = new ArrayList<>();
        assignments = new ArrayList<>();
        quizes = new ArrayList<>();
        comments = new ArrayList<>();
        
        num_slides = 0;
        num_videos = 0;
        num_assignments = 0;
        num_quizes = 0;
        num_comments = 0;

        for(int i=0;i<2;i++)
        {
            inst[i] = new instructor();
            inst[i].set_name("I" + i);   
            inst[i].set_slides(slides); 
            inst[i].set_videos(videos); 
            inst[i].set_assignments(assignments); 
            inst[i].set_quizes(quizes); 
            inst[i].set_comments(comments); 
            inst[i].set_num_slides(num_slides);
            inst[i].set_num_videos(num_videos);
            inst[i].set_num_assignments(num_assignments);
            inst[i].set_num_quizes(num_quizes);
            inst[i].set_num_comments(num_comments);

        }
        for(int i=0;i<3;i++)
        {
            stu[i] = new student();
            stu[i].set_name("S" + i);
            stu[i].set_slides(slides); 
            stu[i].set_videos(videos); 
            stu[i].set_assignments(assignments); 
            stu[i].set_quizes(quizes); 
            stu[i].set_comments(comments); 

            stu[i].set_num_slides(num_slides);
            stu[i].set_num_videos(num_videos);
            stu[i].set_num_assignments(num_assignments);
            stu[i].set_num_quizes(num_quizes);
            stu[i].set_num_comments(num_comments);

        }


    }

    public void backpack()
    {
        System.out.println("------------------------------");
        System.out.println("Welcome to Backpack");
        System.out.println("1. Enter as Instructor");
        System.out.println("2. Enter as Student");
        System.out.println("3. Exit");

    }
    public void inst_login()
    {
        for(int i=0;i<2;i++)
        {
            System.out.println(i + " - " + inst[i].get_name());
        }
    }
    public void stu_login()
    {
        for(int i=0;i<3;i++)
        {
            System.out.println(i + " - " + stu[i].get_name());
        }
    }
    
    public void viewlectures(lectures l)
    {
        l.view_lectures();
    }
    public void viewassessments(assessments a)
    {
        a.view_assessments();
    }
    public void view_comment(Comments c)
    {
        c.view_com();
    }
    public void add_comment(Comments c)
    {
        c.add_com();
    }
    
    public void run()
    {
        System.out.println();
        Scanner sc = new Scanner(System.in);
        int n = 1;
        //initailize();

        while(n != 3)
        {
            backpack();
            n = sc.nextInt();
            if(n == 1)
            {
                inst_login();
                System.out.print("Choose ID: ");
                int id = sc.nextInt();
                
                int n1 = 1;
                while(n1 != 11)
                {
                    inst[id].instructor_menu();
                    n1 = sc.nextInt();
                    if(n1 == 1)
                    {
                        slides.add(num_slides, new lecture_slide());
                        slides.get(num_slides).add_slide(inst[id]);
                        num_slides++;
                        inst[0].set_num_slides(num_slides);
                        stu[0].set_num_slides(num_slides);
            
            
                    }

                    else if(n1 == 2)
                    {
                        videos.add(num_videos, new lecture_video());
                        System.out.print("Enter Topic of video: ");
                        String s1 = sc.next();
                        String s2;
                        while(true)
                        {
                            System.out.print("Enter filename of the video: ");
                            s2 = sc.next();
                            if(s2.length() > 4 && s2.substring(s2.length()-4).equals(".mp4"))
                            {
                                break;
                            }
                            else
                                System.out.println("Incorrect file, Enter Again..");
                        }
                        videos.get(num_videos).add_video(inst[id],s1,s2);
                        num_videos++;
                        inst[0].set_num_videos(num_videos);
                        stu[0].set_num_videos(num_videos);
            
            
                    }
                    else if(n1 == 3)
                    {
                        assignments.add(num_assignments, new Assignment());
                        assignments.get(num_assignments).add_assignment();
                        num_assignments++;
                        inst[0].set_num_assignments(num_assignments);
                        stu[0].set_num_assignments(num_assignments);
            
            
                    }
                    else if(n1 == 4)
                    {
                        quizes.add(num_quizes, new quiz());
                        quizes.get(num_quizes).add_ques();
                        num_quizes++;
                        inst[0].set_num_quizes(num_quizes);
                        stu[0].set_num_quizes(num_quizes);
            
            
                    }
                    else if(n1 == 5)
                    {
                        viewlectures(inst[id]);
                    }
                    else if(n1 == 6)
                    {
                        viewassessments(inst[id]);
                    }
                    else if(n1 == 7)
                    {
                        viewassessments(inst[id]);
                        System.out.print("Enter Id of assessment to view submissions: ");
                        int i1 = sc.nextInt();
                        inst[id].gradeit(i1);
                    }
                    else if(n1 == 8)
                    {
                        inst[id].close_assessment();
                    }
                    else if(n1 == 9)
                    {
                        view_comment(inst[id]);
                    }
                    else if(n1 == 10)
                    {
                        comments.add(num_comments, new comment());
                        add_comment(inst[id]);
                        num_comments++;
                        inst[0].set_num_comments(num_comments);
                        stu[0].set_num_comments(num_comments);
                    }
                    else if(n1 == 11)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Incorrect Input, Enter Again...");
                    }
                }
                


            }
            else if(n == 2)
            {
                stu_login();
                System.out.print("Choose ID: ");
                int id = sc.nextInt();
                int n1 = 1;
                while(n1 != 7)
                {
                    stu[id].student_menu();
                    n1 = sc.nextInt();

                    if(n1 == 1)
                    {
                        viewlectures(stu[id]);
                    }
                    else if(n1 == 2)
                    {
                        viewassessments(stu[id]);
                    }
                    else if(n1 ==3)
                    {
                        stu[id].submit_assessments(id);
                    }
                    else if(n1 == 4)
                    {
                        stu[id].view_grades(id);
                    }
                    else if(n1 == 5)
                    {
                        view_comment(stu[id]);
                    }
                    else if(n1 == 6)
                    {
                        comments.add(num_comments, new comment());
                        add_comment(stu[id]);
                        num_comments++;
                        inst[0].set_num_comments(num_comments);
                        stu[0].set_num_comments(num_comments);
                    }
                    else if(n1 == 7)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Incorrect Input, Enter Again...");
                    }

                }
            }
            else if(n == 3)
            {
                break;
            }
            else
            {
                System.out.println("Incorrect Input, Enter Again...");
            }
        
        }

    }
}
