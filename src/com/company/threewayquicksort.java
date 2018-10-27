package com.company;

import static com.company.MSDRadixsort.charAt;

public class threewayquicksort {
    public static void main(String[] args)
    {
        String str[]={"hello","bcd","fgh"};
        sort(str);
        for(int i=0;i<3;i++)
            System.out.println(str[i]);
    }
    public static void sort(String[] a)
    {
        sort(a,0,a.length-1,0);
    }
    private static void sort(String[] a,int lo,int hi,int d)
    {
        if(hi<=lo)return;
        int lt=lo,gt=hi;
        int v=charAt(a[lo],d);
        //recursive at dth character
        int i=lo+1;
        while(i<=gt)
        {
            int t=charAt(a[i],d);
            if(t<v)a=exch(a,lt++,i++);
            else if(t>v)a=exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1,d);
        if(v>=0)sort(a,lt,gt,d+1);
        sort(a,gt+1,hi,d);
    }

    private static String[] exch(String[] a, int i, int i1) {
        String temp=a[i];
        a[i]=a[i1];
        a[i1]=temp;
        return a;
    }
}
