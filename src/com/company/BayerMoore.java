package com.company;

public class BayerMoore {
    int[] right=new int[26];
    static String text,patt;
    public BayerMoore(String text,String pat)
    {
        this.text=text;
        patt=pat;
        for(int c=0;c<26;c++)
            right[c]=-1;
        for(int i=0;i<pat.length();i++)
            right[pat.charAt(i)-97]=i;
    }
    public int position()
    {
        int skip;
        for(int i=0;i<text.length()-patt.length();i+=skip)
        {
            skip=0;
            for(int j=patt.length()-1;j>=0;j--)
            {
                if(patt.charAt(j)!=text.charAt(i+j))
                {
                    skip=Math.max(1,j-right[text.charAt(i+j)-97]);
                    break;
                }
            }
            if(skip==0)return i;
        }
        return -1;
    }
    public static void main(String[] args)
    {
        BayerMoore bayerMoore=new BayerMoore("ababb","bab");
        System.out.println(bayerMoore.position());
    }
}
