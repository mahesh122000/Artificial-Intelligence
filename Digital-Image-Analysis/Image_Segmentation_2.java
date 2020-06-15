import java.io.*;
import java.util.*;

public class Solution {
    static int row[]={0,1,0,-1,-1,1,-1,1};
    static int col[]={1,0,-1,0,-1,1,1,-1};
    public static void main(String[] args) {
       int a[][]={{0,0,0,1,1,0,0,0,1,0,1,0},
                  {1,1,1,0,1,1,1,1,0,0,0,1},
                  {1,1,1,0,1,0,0,1,0,0,1,0},
                  {1,0,0,0,0,0,0,0,0,1,0,0}};
        int n=a.length;
        int m=a[0].length;
        int count=0;
        for(int i=0;i<n;i++)
        {for(int j=0;j<m;j++)
        {if(a[i][j]==1)
        {find(a,i,j,n,m);
        count++;}}}
        System.out.println(count);
    }
    public static void find(int a[][],int i,int j,int n,int m)
    {
        a[i][j]=0;
        for(int k=0;k<8;k++)
        {if(safe(i+row[k],j+col[k],n,m,a))
        find(a,i+row[k],j+col[k],n,m);
        }
    }
    public static boolean safe(int i,int j,int n,int m,int a[][])
    {
        if(i<0||j<0||i>=n||j>=m||a[i][j]==0)
        return false;
        return true;
    }
}
