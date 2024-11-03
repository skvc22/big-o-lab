/*
* Friends School adaptation of a lab by Robert Sedgewick described at
* https://introcs.cs.princeton.edu/java/24percolation/
*
*
* (c) 2021 Joel Hammer, Friends School of Baltimore.
*/

/**
* Specifies the methods necessary for a solution to the dynamic
* connectivity problem (without the possiblity of removal of connections).
* The interface assumes a graph of initially completely disconnected nodes
* which may be successively conected.
*
* <p>The pricipal purpose of such a class is to determine if any two nodes are
* connected either <i>directly</i> or <i>indirectly</i> through connections.
* to intermediate nodes.
* 
* <p>The method {@code union(a,b)} <i> directly </i> connects two nodes, but
* any two nodes are said to be connected if a series of direct connections
* exist. For example, if node a is connected to node b directly and node b
* is directly connected to node c, then node a is connected to node c <i>
* indirectly </i>.
*
* <p>The {@code find(a,b)} method determines nodes a and be are connected
* either directly or indirectly.
*
* For the mathematically inclined, we say that {@code find(a,b)} is a kind
* of <i>equivalance relation </i> with the properties that 
* <ol type="1">
*   <li> {@code find(a,b)} is equivalent to {@code find(b,a)} 
*        <b>(Symmetry)</b> </li>
*   <li> {@code find(a,a)} returns {@code true} <b>(Reflexifity)</b> </li>
*   <li> If {@code find(a,b)} and {@code find(b,c)} both return {@code true},
*        then {@code find(a,c)} also returns {@code true}.
*        <b>(Transitivity)</b> </li>
*   </ol>
*/
public interface UnionFinder {
	
	/**
    * Connects two given nodes. Importantly, this method should first checked
    * if the two nodes are already connected by calling {@code find(a,b)}.
    * In the case that they are already connected, nothing further should be
    * done.
    *
    * @param a the first node to be connected.
    * @param b the second node to be connected.
    */
    public void union(int a, int b);
	
	/**
    * Determines if a connection between node a and node b exists.
    * @param a the first node to be checked.
    * @param b the second node to be checked.
    *
    * @return {@code true} if {@code a} and {@code b} are connected
    * by some path (directly or indirectly).
    */
    public boolean find(int a, int b);
}