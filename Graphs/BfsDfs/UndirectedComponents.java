package Graphs.BfsDfs;


//To find how many undirected graphs can be constructed out of a given n number of vertices.
public class UndirectedComponents {
    static long count(int n) {
        // code here
        return (long) Math.pow(2,(n*(n-1))/2);
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(count(n));
    }
}
