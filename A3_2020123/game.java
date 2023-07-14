import java.util.*;

public class game
{

    Scanner sc = new Scanner(System.in);

    private ArrayList<normal> n_floors;  
    private ArrayList<ladder> l_floors; 
    private ArrayList<elevator> e_floors; 
    private ArrayList<snake> s_floors;  
    private ArrayList<cobra> c_floors;  
    private Player p;
    private dice d;

    private int n = 0;
    private int l = 0;
    private int e = 0;
    private int s = 0;
    private int c = 0;

    private int t;
    private int[][] t_floors ;

    public game()
    {
        n_floors = new ArrayList<>(); 
        l_floors = new ArrayList<>();
        e_floors = new ArrayList<>();
        s_floors = new ArrayList<>();  
        c_floors = new ArrayList<>();

        p = new Player();
        d = new dice();

        p.set_dice(d);

        




    }

    public void board()
    {
        System.out.println("Welcome To Snakes & Ladders...");
        System.out.print("Enter the number of Floors you want to have : ");
        t = sc.nextInt();
        t_floors = new int [2][t];
        System.out.println("----------------------------------------------");
        System.out.println("Now choose the type of floors");
        System.out.println("----------------------------------------------");
        int choice;

        for(int i = 0;i<t;i++)
        {
            System.out.println("For Floor - " +i);
            System.out.println("Choose among the following :");
            System.out.println("0. Empty Floor");
            System.out.println("1. Ladder Floor");
            System.out.println("2. Elevator Floor");
            System.out.println("3. Snake Floor");
            System.out.println("4. King Cobra Floor");
            choice = sc.nextInt();
            if(choice == 0)
            {
                n_floors.add(n,new normal(i));
                n_floors.get(n).set_next_floor(i+1);
                t_floors[0][i] = choice;
                t_floors[1][i] = n;
                n++;
            }
            else if(choice == 1)
            {
                int a;
                l_floors.add(l,new ladder(i));
                while(true)
                {
                    System.out.print("Enter destination of this ladder: ");
                    a = sc.nextInt();
                    if(t > a && a > i)
                    {
                        l_floors.get(l).set_next_floor(a);
                        break;
                    }
                    else
                    {
                        System.out.println("Incorrect destination , Enter Again...");
                    }
                }
                t_floors[0][i] = choice;
                t_floors[1][i] = l;
                l++;
            }
            else if(choice == 2)
            {
                int a;
                e_floors.add(e,new elevator(i));
                while(true)
                {
                    System.out.print("Enter destination of this Elevator: ");
                    a = sc.nextInt();
                    if(t>a && a > i)
                    {
                        e_floors.get(e).set_next_floor(a);
                        break;
                    }
                    else
                    {
                        System.out.println("Incorrect destination , Enter Again...");
                    }
                }
                t_floors[0][i] = choice;
                t_floors[1][i] = e;
                e++;
            }
            else if(choice == 3)
            {
                int a;
                s_floors.add(s,new snake(i));
                while(true)
                {
                    System.out.print("Enter destination of this Snake: ");
                    a = sc.nextInt();
                    if(-1< a && a < i)
                    {
                        s_floors.get(s).set_next_floor(a);
                        break;
                    }
                    else
                    {
                        System.out.println("Incorrect destination , Enter Again...");
                    }
                }
                t_floors[0][i] = choice;
                t_floors[1][i] = s;
                s++;
            }
            else if(choice == 4)
            {
                int a;
                c_floors.add(c,new cobra(i));
                while(true)
                {
                    System.out.print("Enter destination of this King cobra: ");
                    a = sc.nextInt();
                    if(-1< a && a < i)
                    {
                        c_floors.get(c).set_next_floor(a);
                        break;
                    }
                    else
                    {
                        System.out.println("Incorrect destination , Enter Again...");
                    }
                }
                t_floors[0][i] = choice;
                t_floors[1][i] = c;
                c++;
            }
            else
            {
                System.out.println("Incorrect input, Enter Again...");
                i--;
            }

        }

    }
    public void next_turn()
    {
        while(true)
        {
            
            if(p.get_position() == -1)
            {
                if(d.get_value() == 1)
                {
                    p.set_position(get_floor(0));
                    System.out.println("Player position: Floor - " + p.get_position());
                    System.out.println(p.get_name() + " has reached " + p.get_floor().get_name_floor());
                    System.out.println("Total Points: " + p.get_points());
                    if(p.get_floor().floor_value == 1)
                    break;
                }
                else
                {
                    System.out.println("Game cannot start till you get 1");
                    break;
                }
            }
            else if(p.get_position() + d.get_value() >= t)
            {
                System.out.println("Player cannot move");
                break;
            }
            else
            {
                if(p.get_floor().floor_value != 1)
                {
                    p.set_position(get_floor(p.get_floor().get_next_floor()));
                    System.out.println("Player position: Floor - " + p.get_position());
                    System.out.println(p.get_name() + " has reached " + p.get_floor().get_name_floor());
                    System.out.println("Total Points: " + p.get_points());
                    if(p.get_floor().floor_value == 1)
                    break;
                }
                
                else
                {
                    p.set_position(get_floor(p.get_position() + d.get_value()));
                    System.out.println("Player position: Floor - " + p.get_position());
                    System.out.println(p.get_name() + " has reached " + p.get_floor().get_name_floor());
                    System.out.println("Total Points: " + p.get_points());
                    if(p.get_floor().floor_value == 1)
                    break;
                }
            }
        }
    }

    public floor get_floor(int x)
    {
        
        if(t_floors[0][x] == 0)
        {
            return (floor)n_floors.get(t_floors[1][x]);
        }
        else if(t_floors[0][x] == 1)
        {
            return (floor)l_floors.get(t_floors[1][x]);
        }
        else if(t_floors[0][x] == 2)
        {
            return (floor)e_floors.get(t_floors[1][x]);
        }
        else if(t_floors[0][x] == 3)
        {
            return (floor)s_floors.get(t_floors[1][x]);
        }
        else
        {
            return (floor)c_floors.get(t_floors[1][x]);
        }
        
    }


    public void run()
    {
        
        System.out.println("Enter the name of the player and hit enter: ");
        p.set_name(sc.nextLine());
        board();
        System.out.println("-------------------------------");
        System.out.println("the Game setup is ready");
        boolean a = false;
        while(p.get_position() != t-1)
        {
            System.out.println("-------------------------------");
            System.out.println("Hit Enter to roll the dice");
            sc.nextLine();
            if(a == false)
            {
                sc.nextLine();
                a = true;
            }
            System.out.println("-------------------------------");
             
            p.roll_dice();
            System.out.println("Dice gave " +d.get_value());      
            next_turn();    
        }
        System.out.println("---Game Over---");
        System.out.println(p.get_name() + " accumulated " + p.get_points() + " points");
        System.out.println("-------------------------------");

    }
}