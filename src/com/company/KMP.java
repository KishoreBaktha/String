package com.company;
import java.util.*;
import java.lang.*;
public class KMP {
    static String str;
    String pat;
    int M;
    int [][] dfa;
    public KMP(String s,String patt)
    {
        str=s;
        pat=patt;
        M=pat.length();
        dfa=new int[3][M];
        dfa[pat.charAt(0)-97][0]=1;
        for(int x=0,j=1;j<M;j++)
        {
            for(int c=0;c<3;c++)
                dfa[c][j]=dfa[c][x];
            dfa[pat.charAt(j)-97][j]=j+1;
            x=dfa[pat.charAt(j)-97][x];
        }
    }
    public static void main(String[] args)
    {
        KMP kmp=new KMP("ababb","abb");
        System.out.println(kmp.search());
    }
    public int search()
    {
        int i,j,N=str.length();
        for (i=0,j=0;i<N&&j<M;i++)
        {
            j=dfa[str.charAt(i)-97][j];
        }
        if(j==M) return i-M;
        else
            return -1;
    }
}
