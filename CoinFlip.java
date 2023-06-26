import java.util.Scanner;
/**
 * Makes a coin flip
 *
 * @author (Evergreen)
 * @version (6-26-2023)
 */
public class CoinFlip
{
    public CoinFlip()
    {

    }

    public void main(Player player)
    {
        Main m = new Main();
        
        Scanner in = new Scanner(System.in);

        System.out.println("Heads (h) or tails (t)?");
        String decision = in.nextLine();

        System.out.println("How much would you like to bet?");
        System.out.println("You currently have: " + player.money + "$.");
        Integer bet = Integer.parseInt(in.nextLine());

        System.out.println("");

        int result = (int) (Math.random() * 2);
        String finres;
        if (result == 0)
        {
            finres = "h";
            System.out.println("The coin shows heads.");
        }
        else
        {
            finres = "t";
            System.out.println("The coin shows tails.");
        }

        if (decision.equals(finres))
        {
            System.out.println("You chose correctly!");
            player.money += bet;
        }
        else
        {
            System.out.println("You chose incorrectly.");
            player.money -= bet;
        }
        System.out.println("You now have: " + player.money + "$.");

        System.out.println("*****");

        m.increaseHour(1);
        player.energy -= 2;

        System.out.println("");
        if (player.money > 0 && player.energy > 0)
        {
            System.out.println("Play again? (y/n)");
            if (player.energy < 10)
            {
                System.out.println("You seem to be tired, it is advisable to check for a hotel.");
            }
            String choice = in.nextLine();
            System.out.println("*****");
            if (choice.equals("y"))
            {
                main(player);
            }
        }
        m.menu();
    }
}
