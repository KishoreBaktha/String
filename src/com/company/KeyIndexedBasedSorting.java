package com.company;
import java.util.*;
public class KeyIndexedBasedSorting {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        String name[]=new String[n];
        int[] section=new int[n];
        int auxsection[]=new int[n];
        String auxname[]=new String[n];
        for(int i=0;i<n;i++)
        {
            name[i]=scanner.nextLine();
            section[i]=scanner.nextInt();
            scanner.nextLine();
        }
        int r=10;//number of sections
        int [] count=new int[r+1];
        for(int i=0;i<n;i++)
          count[section[i]]++;//1 to 10
        for(int i=0;i<r;i++)
            count[i+1]+=count[i];
        for(int i=0;i<r;i++)
            System.out.println("i-"+count[i]);
        for(int i=0;i<n;i++)
        {
            auxsection[count[section[i]]-1]=section[i];
            auxname[count[section[i]]-1]=auxname[i];
            count[section[i]]++;
        }
        for(int i=0;i<n;i++)
        {
            section[i]=auxsection[i];
            name[i]=auxname[i];
            System.out.println("name- "+auxname+ " "+"Section- "+auxsection[i]);
        }
    }
}
