import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();
        int r=0,s=0;
        for(int i=0;i<5;i++)
        {String c=sc.next();
        for(int j=0;j<5;j++)
        {if(c.charAt(j)=='d')
        {r=i;
        s=j;}}}
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