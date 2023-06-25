import java.util.Scanner;
/**
 * Acts as the main menu and hub for the flow of the overall game.
 */
public class Main
{
    public static int day;
    public static int hour;
    public static Player player;
    boolean game = true;
    Scanner in = new Scanner(System.in);

    public Main()
    {
        day = 1;
        hour = 0;
        game = true;
        System.out.println("Hello! Welcome to Casino Master.");
        System.out.println("Please enter your name here: ");
        String name = in.nextLine();
        player = new Player(name);
        System.out.println("*****");
        menu();
    }

    public void menu()
    {
        // User interface
        System.out.println("Type the word in the parentheses in order to access the respective section.");
        System.out.println("Check Stats || (stat)");
        System.out.println("Coin Flip || (coin)");
        System.out.println("*****");
        String decision = in.nextLine();

        //Hub
        if (decision.equals("stat"))
        {
            print();
        }
        if (decision.equals("coin"))
        {
            CoinFlip game = new CoinFlip();
            game.main();
        }
        if (decision.equals("dev"))
        {
            dev();
        }
    }

    public void dev()
    {
        System.out.println("Type the word in the parentheses in order to access the respective section.");
        System.out.println("Increase Time || (t!)");
        System.out.println("Set Money || (m!)");
        System.out.println("Set Energy || (e!)");
        System.out.println("Return to Main Menu || (return)");
        System.out.println("*****");
        String decision = in.nextLine();

        if (decision.equals("t!"))
        {
            hour = 0;
            increaseDay();
            if (game == true)
            {
                dev();
            }
        }
        if (decision.equals("m!"))
        {
            System.out.println("Set money amount: ");
            Integer set = Integer.parseInt(in.nextLine());
            player.money = set;
            System.out.println("*****");
            dev();
        }
        if (decision.equals("e!"))
        {
            System.out.println("Set energy amount: ");
            Integer set = Integer.parseInt(in.nextLine());
            player.energy = set;
            System.out.println("*****");
            dev();
        }
        if (decision.equals("return"))
        {
            menu();
        }
    }

    public void print()
    {
        player.print();
        System.out.println("*****");
        menu();
    }

    public void increaseHour(int hours)
    {
        hour += hours;
        checkEnergy();
        if (hour >= 24)
        {
            hour -= 24;
            day ++;
            increaseDay();
        }
    }

    public void increaseDay()
    {
        checkEnergy();
        checkMoney();
        if (game)
        {
            day++;
            System.out.println("You are now on Day " + day + ".");
            System.out.println("*****");
        }
    }

    public void checkEnergy()
    {
        if (player.energy <= 0)
        {
            System.out.println("You ran out of energy!");
            System.out.println("You collapsed on the floor and someone robbed you.");
            System.out.println("*****");
            player.money = (int)((double)(player.money / 10) * 5 * Math.random());
        }
    }

    public void checkMoney()
    {
        if (player.money <= 0)
        {
            gameOver();
        }
    }

    public void gameOver()
    {
        System.out.println("GAME OVER");
        System.out.println("You came out with " + player.money + "$.");
        System.out.println("You survived until day " + day + ".");
        System.out.println("*****");
        game = false;
    }
}
