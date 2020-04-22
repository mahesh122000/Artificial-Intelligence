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

    public static void bfs(String s[],int i,int j,int n,int m)
    {
        Queue<Node>q=new LinkedList<>();
        ArrayList<Node>explored=new ArrayList<>();
        Stack<Node> path = new Stack();
        q.add(new Node(i,j,null));
        Node goal=null;
        int b[][]=new int[n][m];
        while(!q.isEmpty())
        {Node t=q.poll();
         explored.add(t);
         b[t.r][t.c]=1;
        if(s[t.r].charAt(t.c)=='.')
        {goal=t;
        break;}
        if(t.r-1 >= 0 && b[t.r-1][t.c]==0 && s[t.r-1].charAt(t.c) != '%') {
                Node newNode = new Node(t.r-1, t.c, t);
                b[t.r-1][t.c] = 1;
                q.add(newNode);                
            }
         if(t.c-1 >= 0 && b[t.r][t.c-1]==0 && s[t.r].charAt(t.c-1) != '%') {
                Node newNode = new Node(t.r, t.c-1, t);
                b[t.r][t.c-1] = 1;
                q.add(newNode);                 
            }
          
        if(t.c+1 <m && b[t.r][t.c+1]==0 && s[t.r].charAt(t.c+1) != '%') {
                Node newNode = new Node(t.r, t.c+1, t);
                b[t.r][t.c+1] = 1;
                q.add(newNode);                  
            }
         if(t.r+1 <n && b[t.r+1][t.c]==0 && s[t.r+1].charAt(t.c) != '%') {
                Node newNode = new Node(t.r+1, t.c, t);
                b[t.r+1][t.c] = 1;
                q.add(newNode);                 
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
            a[i]=sc.next();
        bfs(a,p,q,n,m);
    }
}