import java.io.*;
import java.util.*;

public class Solution {
    static int r[]={1,0,-1,0};
    static int c[]={0,-1,0,1};
    static String mov[]={"DOWN","LEFT","UP","RIGHT"};
    static int a[][];
    static int n;
    static HashSet<String>hs;
    static String ans="012345678";
    static class node
    {
        String s;
        String path;
        node ancestor;
        node(String s,String path,node ancestor)
        {
            this.s=s;
            this.ancestor=ancestor;
            this.path=path;
        }
    }
    static void find()
    {
        String str="";
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                str+=Integer.toString(a[i][j]);
        }
        node goal=null;
        Queue<node>q=new LinkedList<>();
        int count=0;
        q.add(new node(str,"",null));
        hs.add(str);
        one:while(!q.isEmpty())
        {
            int s=q.size();
            while(s-->0)
            {
                node no=q.poll();
                if(no.s.equals(ans))
                {
                    goal=no;
                    break one;
                }
                int ind=no.s.indexOf("0");
                int x=ind/3;
                int y=ind%3;
                for(int k=0;k<4;k++)
                {
                    int nx=x+r[k];
                    int ny=y+c[k];
                    if(nx>=0 && nx<3 && ny>=0 && ny<3)
                    {
                        char arr[]=no.s.toCharArray();
                        int index=nx*3+ny;
                        arr[ind]=arr[index];
                        arr[index]='0';
                        String temp=new String(arr);
                        if(!hs.contains(temp))
                        {
                            //System.out.println(temp);
                            q.add(new node(temp,mov[k],no));
                            hs.add(temp);
                        }
                    }
                }
            }
            count++;
        }
        Stack<String>st=new Stack<>();
        while(goal!=null)
        {
            st.add(goal.path);
            goal=goal.ancestor;
        }
        System.out.println(count);
        st.pop();
        while(!st.isEmpty())
        {
            System.out.println(st.peek());
            st.pop();
        }
        
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        a=new int[n][n];
        hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                a[i][j]=s.nextInt();
        }
        find();
    }
}


