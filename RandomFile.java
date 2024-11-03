import java.util.Random;

public class RandomFile
{
    public static void main(String[] args) {
        Random rand = new Random(); // declares and instantiates an instance of the random class

        int nodes = rand.nextInt(100) + 1; // generates a random integer between 1 and 100 for the amount of nodes in the array

        int numOfUnions = rand.nextInt(10) + 1; // generates the number of unions to be made

        System.out.println(nodes); // prints the number of nodes (ideally to a file via command line)

        for (int i = 0; i < 2*numOfUnions; i++)
        {
            /* loops for twice the amount of unions to be made (twice because each union needs to be between
            a pair of nodes) and generates the numbers to be used when calling union */

            int unions = rand.nextInt(nodes); //generates the nodes for union to be called with
            System.out.print(unions + " "); // prints the nodes for union to be called with (ideally to a file via command line)
            unions = rand.nextInt(nodes);
            System.out.println(unions); // prints again to have the pairs for unions on the same line in the txt file
        }
    }
}
