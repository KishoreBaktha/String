package com.company;
import java.util.*;
public class longestrepeatedsubstring {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int n=str.length();
        String[] suffixes=new String[n];
        for(int i=0;i<n;i++)
            suffixes[i]=str.substring(i,n);
        Arrays.sort(suffixes);
        String lrs="";
        for(int i=0;i<n-1;i++)
        {
            int len=lcp(suffixes[i],suffixes[i+1]);
            if(len>lrs.length())
                lrs=suffixes[i].substring(0,len);
        }
        System.out.println(lrs);
    }
    public static int lcp(String a,String b)
    {
        int min=Math.min(a.length(),b.length());
        int length=0;
        for(int i=0;i<min;i++)
        {
            if(a.charAt(i)!=b.charAt(i))
                break;
            length++;
        }
        return length;
    }
}

