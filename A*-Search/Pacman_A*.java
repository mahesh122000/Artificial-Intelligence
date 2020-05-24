import java.io.*;
import java.util.*;

public class Solution {
    static class Node {
        int r;
        int c;
        int d;
        int h;
        int val;
        Node ancestor;
        
        Node (int r, int c, int d,int h,int val,Node n) {
            this.r = r;
            this.c = c;
            this.d=d;
            this.h=h;
            this.val=val;
            this.ancestor = n;
        }
    }
    
    public static String convert(int i,int j)
    {String v=String.valueOf(i)+'$'+String.valueOf(j);
    return v;}
    
    static HashMap<String,Integer>hm;
    
    public static void A(String s[],int i,int j,int n,int m)
    {
        PriorityQueue<Node>q=new PriorityQueue<>((pp,qq)->pp.val-qq.val);
        Stack<Node> path = new Stack();
        int val=hm.get(convert(i,j));
        q.add(new Node(i,j,0,val,val,null));
        Node goal=null;
        int b[][]=new int[n][m];
        while(!q.isEmpty())
        {Node t=q.poll();
         b[t.r][t.c]=1;
        if(s[t.r].charAt(t.c)=='.')
        {goal=t;
        break;}
        if(t.r-1 >= 0 && b[t.r-1][t.c]==0 && s[t.r-1].charAt(t.c) != '%') {
                val=hm.get(convert(t.r-1,t.c));
                Node newNode = new Node(t.r-1, t.c,t.d+1,val,val+t.d+1,t);
                b[t.r-1][t.c] = 1;
                q.add(newNode);                
            }
         if(t.c-1 >= 0 && b[t.r][t.c-1]==0 && s[t.r].charAt(t.c-1) != '%') {
                val=hm.get(convert(t.r,t.c-1));
                Node newNode = new Node(t.r, t.c-1,t.d+1,val,val+t.d+1, t);
                b[t.r][t.c-1] = 1;
                q.add(newNode);                 
            }
          
        if(t.c+1 <m && b[t.r][t.c+1]==0 && s[t.r].charAt(t.c+1) != '%') {
                val=hm.get(convert(t.r,t.c+1));
                Node newNode = new Node(t.r, t.c+1,t.d+1,val,val+t.d+1, t);
                b[t.r][t.c+1] = 1;
                q.add(newNode);                  
            }
         if(t.r+1 <n && b[t.r+1][t.c]==0 && s[t.r+1].charAt(t.c) != '%') {
                val=hm.get(convert(t.r+1,t.c));
                Node newNode = new Node(t.r+1, t.c,t.d+1,val,val+t.d+1, t);
                b[t.r+1][t.c] = 1;
                q.add(newNode);                 
            }
        }
        Node t = goal;
        while(t != null) {
            path.push(t);
            t = t.ancestor;
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
        hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {for(int j=0;j<m;j++)
        {hm.put(convert(i,j),Math.abs(i-r)+Math.abs(j-s));
        }}
        String a[]=new String[n];
        for(int i=0;i<n;i++)
            a[i]=sc.next();
        A(a,p,q,n,m);
    }
}