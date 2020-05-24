import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int p=s.nextInt();
        int q=s.nextInt();
        int g=0;
        int h=0;
        for(int i=0;i<n;i++)
        {String c=s.next();
        for(int j=0;j<n;j++)
        {if(c.charAt(j)=='m')
        {p=i;q=j;}
        else if(c.charAt(j)=='p')
        {
        g=i;
        h=j;}}}
        if(p<g)
        {System.out.println("DOWN");
        p++;}
        else if(p>g)
        {System.out.println("UP");
        p--;}
        else if(q<h)
        {System.out.println("RIGHT");
        q++;}
        else if(q>h)
        {System.out.println("LEFT");
        q--;}
    }
}