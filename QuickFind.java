import java.util.Scanner;

public class QuickFind implements UnionFinder {

    int[] id; // declares the array of nodes

    public QuickFind(int n) {

        // initializes and populates the array

        id = new int[n];

        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    @Override
    public void union(int a, int b) {

        // connects the two specified nodes

        if (find(a, b))
            return; // prevents the program from looping through the array if the nodes are already connected
        else
        {
            for (int i = 0; i < id.length; i++)
                id[a] = id[b]; // loops through the array and sets all nodes with the value a to b
        }
    }
    
    @Override
    public boolean find(int a, int b) {

        return id[a] == id[b]; // returns true if the nodes have the same value in the array
    }
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // declares and initializes a scanner
        System.out.println(scan.nextInt());
        QuickFind test = new QuickFind(scan.nextInt()); /* declares and initializes an instance of QuickFind with an array
                                                         of n nodes, n being the first number in the file the scanner read in */

        long startTime = System.nanoTime(); // starts a timer just before the program begins running in full capacity.

        while (scan.hasNext())
            test.union(scan.nextInt(), scan.nextInt()); // calls union on each pair of nodes in the file the scanner read in

        long stopTime = System.nanoTime(); // ends the timer
        double totalTime = ((double) stopTime - (double)startTime)/1000000000; // finds the total time and converts it from nanoseconds to seconds
        System.out.println(totalTime); // prints the total time in seconds for which the program was running
    }
}