import java.io.*;
import java.util.*;



public class Solution {
    static class Node {
        int r;
        int c;
        Node ancestor;
        
        Node (int r, int c, Node n) {
            this.r = r;
            this.c = c;
            this.ancestor = n;
        }
    }
    static void dfs(int i,int j,int n,int m,String s[])
    {
        int b[][]=new int[n][m];
        Stack<Node> st = new Stack();
        Stack<Node> path = new Stack();
        ArrayList<Node> explored = new ArrayList<Node>();
        Node goal = null;
        Node init = new Node(i,j, null);
        st.push(init);   
        while(!st.isEmpty())
        {Node t=st.pop();
         b[t.r][t.c]=1;
         explored.add(t);
         if(s[t.r].charAt(t.c)=='.')
         {goal=t;
         break;}
         if(t.r-1 >= 0 && b[t.r-1][t.c]==0 && s[t.r-1].charAt(t.c) != '%') {
                Node newNode = new Node(t.r-1, t.c, t);
                b[t.r-1][t.c] = 1;
                st.push(newNode);                
            }
         if(t.c-1 >= 0 && b[t.r][t.c-1]==0 && s[t.r].charAt(t.c-1) != '%') {
                Node newNode = new Node(t.r, t.c-1, t);
                b[t.r][t.c-1] = 1;
                st.push(newNode);                
            }
          
        if(t.c+1 <m && b[t.r][t.c+1]==0 && s[t.r].charAt(t.c+1) != '%') {
                Node newNode = new Node(t.r, t.c+1, t);
                b[t.r][t.c+1] = 1;
                st.push(newNode);                
            }
         if(t.r+1 <n && b[t.r+1][t.c]==0 && s[t.r+1].charAt(t.c) != '%') {
                Node newNode = new Node(t.r+1, t.c, t);
                b[t.r+1][t.c] = 1;
                st.push(newNode);                
            }
        }
        Node t = goal;
        while(t != null) {
            path.push(t);
            t = t.ancestor;
        }
        
        System.out.println(explored.size());
        for(Node node : explored) {
            System.out.println(node.r + " " + node.c);
        }
        System.out.println(path.size() - 1);
        while(!path.isEmpty()) {
            t = path.pop();
            System.out.println(t.r + " " + t.c);
        }
    }

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();
        int r=sc.nextInt();
        int s=sc.nextInt();
        int n=sc.nextInt();
        int m=sc.nextInt();
        String a[]=new String[n];
            for(int i=0;i<n;i++)
            {a[i]=sc.next();}
        dfs(p,q,n,m,a);
    }
}







    