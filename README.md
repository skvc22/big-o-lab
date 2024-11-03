[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=5606473&assignment_repo_type=AssignmentRepo)
# BigO Lab

In this lab you will investigate the running time of two separate algorithms
which solve the same problem: Dynamic Connectivity.

[Documentation](https://friendsbaltcs.github.io/docs/ACS/BigOLab/UnionFinder.html)

## Dynamic Connectivity

The dynamic connectivity problem begins with a set of _n_ nodes all initially
unconnected. Those nodes can be joined by a connection so that we can pass from
one node to another if there is a connection between them. Given a system of
nodes--some connected and others not--we want to know if any two are connected
either by a direct connection, or by following a path of other nodes which are
directly connected.

## Solution

A type of algorithm called "Union-Find" will be used to solve this problem.
Although there are multiple versions of this algorithm (we'll see two or
three), any implementation will have the two methods specified in the attached
interface `UnionFinder.java`. The two methods are:

1. `void union(a,b)` which connects two nodes and
2. `boolean find(a,b)` which checks to see if a path of connections between two
nodes exists.

We will discuss three versions of this algorithm: Quick Find, Quick Union and
Weighted Quick Union and test the running times for each.

## Overview of Algorithms
We will cover each of tese in class, but here's a brief description of each of
the algorithms. All of these algorithms rely on the idea of a _connected_
_component_. Simply put, a connected component is a group of nodes which are
connected to each other (directly or indirectly through another node). A given
system of nodes may have many components or only a few. With more connections,
the system approaches one big connected component.

### Quick Find (slow)
Quick find uses an array to hold an id for each note. That id represents the
connected component that that node is in. It doesn't matter what the id value
is, but if two nodes have the same id, then they are in the same component and
are therefore connected. The outline of the code looks a bit like this
```java
public class QuickFind implements UnionFinder {

    public void union(int a, int b) {
    
        //Add the connected component of a to the connected component
        //of b. The id of a (and everything connected to a) should be
        // changed to the id of b.
    
    }
    
    public boolean find(int a, int b) {
        
        //Check if a and b have the same id.
    
    }
} 
```

This is called "Quick Find" because the `find()` operation is only one step. The
`union()` process is much more difficult since you must look for everything
connected to one node and change it to match the id of another.

### Quick Union

Quick Union uses a different data structure called a _tree_ to manage the
connections in a system. Instead of considering the connected nodes as a
connected component only, we assign a node to be a parent of any node connected
to it. So whenever we call

```java
union(a,b)
```
We make `b` a parent of `a` (by convention we make the first parameter a
_child_ of the second). We can store this in a simple id array just as before,
but this time `id[i]` will store the index of its _parent_. If a node is its
own parent, then it is the _root_ or top of the tree. The code looks something 
like this:

```java
public class QuickUnion implements UnionFinder {

    public void union(int a, int b) {
        
        //Identify node c, the root of the tree containing a
        //make b the parent of node c.
    
    }
    
    public void find(int a, int b) {
        
        //Check if the root of node a is the same as the root of b.
    
    }
}
```

### Weighted Quick Union

Quick Union has the disadvantage of not actually being any faster than Quick
Find. They're both O(n<sup>2</sup>). The problem is that, in the worst case,
we could end up with one long tree so that identifying its root takes time
proportional to _n_.

To solve this problem, we can create a separate array measuring the size, that
is, how many total nodes, of any tree rooted at _i_. Whenever we connect two
nodes, _a_ and _b_, we first find the roots _c_ and _d_, then compare the sizes
of the two roots and make the root of the smaller tree the child of the root of
the larger.

### Path Compression

You may have noted that you have to walk through nodes to their roots several
times throughout this algorithm. We can take advantage of this fact through
_path compression_. Ideally we would just place every node under the root after
walking through a tree. This turns out to be difficult. Instead, we can place
each root under its _grandparent_ as it progresses through the tree.

This has no impact on the Big-O runtime of the algorithm, but it does make it
somewhat faster in practice.

## Assignment

You will write three separate classes for this assignment:

1. An implementation of Quick Find
2. An implementation of Weighted Quick Union
3. A Randomizer class that generates a random set of unions for a system of
n nodes.

Using the Randomizer class, test the classes for Quick Find and Quick Union
with larger and large sets of unions. How do the runtimes compare when
computing larger and larger data sets. Do the runtimes seem to be consistent
with what was stated in class.

You do not need to include path compression in your weighted quick union, but
for two extra points, add it in!