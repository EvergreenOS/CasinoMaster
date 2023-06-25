/**
 * Sets up player through a constructor
 *
 * @author Evergreen
 * @version 6-25-2023
 */
public class Player
{
    String name;
    public static int money = 1000;
    public static int energy = 50;
    
    public Player()
    {
        name = "Player";
    }
    
    public Player(String name)
    {
        this.name = name;
    }
    
    public void print()
    {
        System.out.println("Name: " + name);
        System.out.println("Money: " + money + "$");
        System.out.println("Energy: " + energy);
    }
}
