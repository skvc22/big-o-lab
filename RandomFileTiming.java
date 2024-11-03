import java.util.Random;

public class RandomFileTiming
{
    public static void main(String[] args) {

        /*
        I ran QuickFind once with 500,000 and got 145.056071499, then ran it again with 1,000,000 and got 578.704054001.
        578.704054001 / 145.056071499 = 3.98951969415, which rounds up to 4.
        Therefore, QuickFind has a big O of O(n^2).
         */

        int nodes = 500000; // generates a random integer between 1 and 100 for the amount of nodes in the array

        int numOfUnions = 500000; // generates the number of unions to be made

        System.out.println(nodes); // prints the number of nodes (ideally to a file via command line)

        for (int i = 0; i < 2*numOfUnions; i++) // uses 2*numOfUnions rather than twice the specified value to allow for faster editing/testing
        {
            /* loops for twice the amount of unions to be made (twice because each union needs to be between
            a pair of nodes) and generates the numbers to be used when calling union */

            int unions = (int)(Math.random()*nodes); //generates the nodes for union to be called with
            System.out.print(unions + " "); // prints the nodes for union to be called with (ideally to a file via command line)
            unions = (int)(Math.random()*nodes);
            System.out.println(unions); // prints again to have the pairs for unions on the same line in the txt file
        }
    }
}
