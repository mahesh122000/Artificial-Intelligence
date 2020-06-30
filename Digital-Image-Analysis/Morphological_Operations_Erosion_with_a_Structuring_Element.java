import java.io.*;
import java.util.*;

public class Solution {

    static int row[]={1,-1};
    
    public static boolean safe(int i,int j,int n,int m,int a[][])
    {
        if(i<0||j<0||i>=n||j>=m)
        return false;
        if(a[i][j]==0)
        return false;
        return true;
    }
    public static void Erosion(int a[][],int i,int j)
    {
        int count=0;
       for(int k=0;k<2;k++)
       {
           if(safe(i+row[k],j,4,5,a))
           count++;
       }
       if(count==2)
       a[i][j]=1;
       else
       a[i][j]=2;

    }
    public static void main(String[] args) {
        int a[][]={{0,0,1,1,0},
                   {0,0,1,1,0},
                   {0,0,1,1,0},
                   {1,1,1,1,1}};
        for(int i=0;i<4;i++)
        {for(int j=0;j<5;j++)
        {if(a[i][j]==1)
        Erosion(a,i,j);}}
        for(int i=0;i<4;i++)
        {for(int j=0;j<5;j++)
        {if(a[i][j]==2)
        a[i][j]=0;}}
        for(int i=0;i<4;i++)
        {for(int j=0;j<5;j++)
        {System.out.print(a[i][j]);}
        System.out.println();}
    }
}