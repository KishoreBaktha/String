package com.company;
import java.util.*;
public class LSDRadixsort {
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        String name[]=new String[n];
        String auxname[]=new String[n];
        for(int i=0;i<n;i++)
        {
            name[i]=scanner.nextLine();
        }
        int r=26;//number of sections
        for(int d=name[0].length()-1;d>=0;d--)
        {
            int [] count=new int[r+1];
            for (int i = 0; i < n; i++)
                count[name[i].charAt(d)-97+1]++;
            for (int i = 0; i < r; i++)
                count[i + 1] += count[i];
            for (int i = 0; i < r; i++)
                System.out.println(i+"- " + count[i]);
            for (int i = 0; i < n; i++) {
                auxname[count[name[i].charAt(d)-97]++] = name[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            name[i]=auxname[i];
            System.out.println("name- "+name[i]);
        }
    }
}
