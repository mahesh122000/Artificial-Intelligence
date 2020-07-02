import java.io.*;
import java.util.*;

public class Solution {
    static int row[]={0,-1};
    static int col[]={1,0};
    public static boolean safe(int i,int j,int n,int m,int a[][])
    {
        if(i<0||j<0||i>=n||j>=m||a[i][j]==1)
        return false;
        return true;
    }
    public static void find(int a[][],int i,int j)
    {
       for(int k=0;k<2;k++)
       {
           if(safe(i+row[k],j+col[k],3,4,a))
           a[i+row[k]][j+col[k]]=2;
       }
    }
    public static void main(String[] args) {
        int a[][]={{0,0,0,0},
                   {0,1,1,0},
                   {0,0,0,0}};
        int count=0;
        for(int i=0;i<3;i++)
        {for(int j=0;j<4;j++)
        {if(a[i][j]==1)
        find(a,i,j);}}
        for(int i=0;i<3;i++)
        {for(int j=0;j<4;j++)
        {if(a[i][j]!=0)
        System.out.print("1");
        else
        System.out.print("0");}
        System.out.println();
        }
    }
}