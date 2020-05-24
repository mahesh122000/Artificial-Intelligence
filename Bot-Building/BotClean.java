import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();
        int r=-1,s=-1;
        double min=Double.MAX_VALUE;
        for(int i=0;i<5;i++)
        {String c=sc.next();
        for(int j=0;j<5;j++)
        {if(c.charAt(j)=='d')
        {double val=Math.sqrt((p-i)*(p-i)+(q-j)*(q-j));
        if(val<min)
        {min=val;
        r=i;
        s=j;}}}}
        if(p==r && q==s)
        {System.out.println("CLEAN");}
        else
        {if(q<s)
        {System.out.println("RIGHT");
        q++;}
        else if(q>s)
        {System.out.println("LEFT");
        q--;}
        else if(p<r)
        {System.out.println("DOWN");
        p++;}
        else if(p>r)
        {System.out.println("UP");
        p--;}}
    }
}