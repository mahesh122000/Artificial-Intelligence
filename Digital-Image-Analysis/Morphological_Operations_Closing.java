import java.io.*;
import java.util.*;

public class Solution {
    static int row[]={0,1,0,-1,-1,1,-1,1};
    static int col[]={1,0,-1,0,-1,1,1,-1};
    public static boolean safe2(int i,int j,int n,int m,int a[][])
    {
        if(i<0||j<0||i>=n||j>=m||a[i][j]==1)
        return false;
        return true;
    }
    public static void Dilation(int a[][],int i,int j)
    {
       for(int k=0;k<8;k++)
       {
           if(safe2(i+row[k],j+col[k],9,10,a))
           a[i+row[k]][j+col[k]]=2;
       }
    }
    public static boolean safe1(int i,int j,int n,int m,int a[][])
    {
        if(i<0||j<0||i>=n||j>=m||a[i][j]==0)
        return false;
        return true;
    }
    public static void Erosion(int a[][],int i,int j)
    {
        int count=0;
       for(int k=0;k<8;k++)
       {
           if(safe1(i+row[k],j+col[k],9,10,a))
           count++;
       }
       if(count==8)
       a[i][j]=1;
       else
       a[i][j]=2;

    }
    public static void main(String[] args) {
        int a[][]={{0,0,0,0,0,0,0,0,0,0},
                   {0,1,1,1,1,1,1,1,0,0},
                   {0,0,0,0,1,1,1,1,0,0},
                   {0,0,0,0,1,1,1,1,0,0},
                   {0,0,0,1,1,1,1,1,0,0},
                   {0,0,0,0,1,1,1,1,0,0},
                   {0,0,0,1,1,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0},
                   {0,0,0,0,0,0,0,0,0,0}};
        int count=0;
        for(int i=0;i<9;i++)
        {for(int j=0;j<10;j++)
        {if(a[i][j]==1)
        Dilation(a,i,j);}}
        for(int i=0;i<9;i++)
        {for(int j=0;j<10;j++)
        {if(a[i][j]==2)
        a[i][j]=1;}}
        for(int i=0;i<9;i++)
        {for(int j=0;j<10;j++)
        {if(a[i][j]==1)
        Erosion(a,i,j);}}
        for(int i=0;i<9;i++)
        {for(int j=0;j<10;j++)
        {if(a[i][j]==1)
        count++;}}
        System.out.println(count);
    }
}