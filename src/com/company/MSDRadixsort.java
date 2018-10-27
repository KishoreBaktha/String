package com.company;

import java.util.Scanner;

public class MSDRadixsort
{
    public static int R=6;//highest alphabet is f
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        String name[]=new String[n];
        for(int i=0;i<n;i++)
        {
            name[i]=scanner.nextLine();
        }
        sort(name);
        for(int i=0;i<n;i++)
            System.out.println(name[i]);
    }
    public static int charAt(String s,int d)
    {
        if(d<s.length())return s.charAt(d)-97;
        else
            return -1;
    }
    public static void sort(String[] a)
    {
        String auxname[]=new String[a.length];
        sort(a,auxname,0,a.length-1,0);
    }
    public static void sort(String[] a,String[] aux,int lo,int hi,int d)
    {
        if(hi<=lo)return;
        int [] count=new int[R+2];//to include -1 ,+2
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i],d)+2]++;
        for (int i = 0; i < R+1; i++)
            count[i + 1] += count[i];
        for (int i = lo; i <=hi; i++)
            aux[count[charAt(a[i],d)+1]++] = a[i];
        for (int i = lo; i <=hi; i++)
            a[i]=aux[i-lo];
        for(int r=0;r<R;r++)
        {
            sort(a,aux,lo+count[r],lo+count[r+1]-1,d+1);
        }
        }
}
