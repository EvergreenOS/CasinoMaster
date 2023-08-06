/**
 * Keeps track of player stats and information.
 *
 * @author (Evergreen)
 * @version (8/6/2023)
 */
public class Player
{
    public static String name;
    public static int money;
    public static int energy;
    
    public Player(String name)
    {
        this.name = name;
        money = 100;
        energy = 50;
    }
    
    public Player()
    {
        this.name = "Player";
        money = 100;
        energy = 50;
    }
}
