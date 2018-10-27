package com.company;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TernaryTrieST<Value> {
    private Node root=new Node();
    public static class Node
    {
        private Object value;
        char c;
        Node left,right,mid;
    }
    public void put(String key,int value)
    {
        root=put(root,key,value,0);
    }
    public Node put(Node x, String key, int value, int d)
    {
        char c=key.charAt(d);
        if(x==null)
        {
            x=new Node();x.c=c;
        }
        if(c<x.c)x.left=put(x.left,key,value,d);
        else if(c>x.c)x.right=put(x.right,key,value,d);
        else if(d<key.length()-1)x.mid=put(x.mid,key,value,d+1);
        else x.value=value;
        return x;
    }
    public boolean contains(String key)
    {
        return get(key)!=null;
    }
    public  Value get(String key)
    {
        Node x=get(root,key,0);
        if(x==null)return null;
        return (Value)x.value;
    }
    public Node get(Node x, String key, int d)
    {
        if(x==null)return null;
        char c=key.charAt(d);
        if(c<x.c)return get(x.left,key,d);
        else if(c>x.c)return get(x.right,key,d);
        else if(d<key.length()-1)return get(x.mid,key,d+1);
        else return x;
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        TernaryTrieST<Integer> trieST=new TernaryTrieST<Integer>();
        trieST.put("kishore",3);
        trieST.put("baktha",5);
        System.out.println(trieST.get("kishore"));
    }
}
