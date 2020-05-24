import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();
        int r=0,s=0;
        int n=sc.nextInt();
        int m=sc.nextInt();
        double min=Double.MAX_VALUE;
        for(int i=0;i<n;i++)
        {String c=sc.next();
        for(int j=0;j<m;j++)
        {if(c.charAt(j)=='d')
        {double val=Math.sqrt((i-p)*(i-p)+(j-q)*(j-q));
         if(val<min)
        {r=i;
        s=j;
        min=val;}}}}
        if(p==r && q==s)
            System.out.println("CLEAN");
        else
        {if(p<r)
         System.out.println("DOWN");
        else if(p>r)
            System.out.println("UP");
        else if(q<s)
            System.out.println("RIGHT");
        else if(q>s)
            System.out.println("LEFT");}
    }
}