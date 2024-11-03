import java.util.Scanner;

public class WeightedQuickUnion implements UnionFinder {

    int[] id; // declares the array of nodes

    public WeightedQuickUnion(int n) {

        // initializes and populates the array

        id = new int[n];

        for (int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }
    
    @Override
    public void union(int a, int b) {

        // connects the two specified nodes

        int aSize = 0;
        int bSize = 0; // declares and initializes two variables to be used to determine the longer tree

        if (find(a, b))
            return;
        else
        {
            while (a != id[a])
            {
                // navigates through the various parents of a until it reaches the main parent of the tree
                a = id[a]; // sets the value of a to its parent
                aSize++;
            }
            while (b != id[b])
            {
                // navigates through the various parents of b until it reaches the main parent of the tree
                b = id[b]; // sets the value of b to its parent
                bSize++;
            }
            if (aSize > bSize)
                id[b] = id[a]; // sets the parent of b to a if a is the longer tree
            else
                id[a] = id[b]; // sets the parent of a to b if b is the longer tree
        }
    }
    
    @Override
    public boolean find(int a, int b) {

        while (a != id[a])
        {
            // navigates through the various parents of a until it reaches the main parent of the tree
            a = id[a]; // sets the value of a to its parent
        }
        while (b != id[b])
        {
            // navigates through the various parents of b until it reaches the main parent of the tree
            b = id[b]; // sets the value of b to its parent
        }
        return id[a] == id[b]; // returns true if the nodes have the same parent in the array
    }
    
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); // declares and initializes a scanner
        WeightedQuickUnion test = new WeightedQuickUnion(scan.nextInt());  /* declares and initializes an instance of QuickFind with an array
                                                                            of n nodes, n being the first number in the file the scanner read in */
        while (scan.hasNext())
            test.union(scan.nextInt(), scan.nextInt()); // calls union on each pair of nodes in the file the scanner read in
    }
}