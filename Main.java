import java.util.Scanner;
/**
 * Starts program and creates player.
 *
 * @author (Evergreen)
 * @version (8/6/2023)
 */
public class Main
{
    int day = 0;
    public static int hour = 0;
    public Player player;
    Scanner in = new Scanner(System.in);
    
    public Main()
    {
        System.out.println("Welcome to CasinoMaster!");
        System.out.println("What is your name?");
        System.out.println("");
        
        String name = in.nextLine();
        player = new Player(name);
        
        System.out.println("-----");
        menu();
    }
    
    public void menu()
    {
        if (hour >= 24)
        {
            increaseDay();
        }
        if (player.money <= 0)
        {
            gameOver();
        }
        System.out.println("Choose what you wish to do by typing in the lettered");
        System.out.println("command corresponding to each option.");
        System.out.println("");
        
        System.out.println("Quit game ('x')");
        System.out.println("See stats ('z')");
        System.out.println("");
        
        String option = in.nextLine();
        if (option.equals("x"))
        {
            System.out.println("You have voluntarily quit this game.");
            gameOver();
        }
        if (option.equals("z"))
        {
            System.out.println("-----");
            System.out.println("NAME: " + player.name);
            System.out.println("MONEY: " + player.money);
            System.out.println("ENERGY: " + player.energy);
            System.out.println("-----");
            menu();
        }
    }
    
    public void increaseDay()
    {
        hour -= 24;
        day ++;
        
        System.out.println("It is currently day " + day + ".");
        System.out.println("You currently have " + player.money + "$.");
        System.out.println("You currently have " + player.energy + " energy.");
        System.out.println("");
        
        System.out.println("The time is " + hour + ":00 on day" + day + ".");
        
        System.out.println("-----");
        menu();
    }
    
    public void gameOver()
    {
        System.out.println("You have no money and therefore lose.");
        System.out.println("You have survived until day " + day + ".");
        System.out.println("Thanks for playing!");
        
        System.out.println("-----");
    }
}
