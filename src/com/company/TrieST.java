package com.company;
import java.util.*;
public class TrieST<Value> {

    private static final int R=26;
    private Node root=new Node();
    public static class Node
    {
        private Object value;
        private Node[] next=new Node[R];
    }
    public void put(String key,int value)
    {
        root=put(root,key,value,0);
    }
    public Node put(Node x,String key,int value,int d)
    {
        if(x==null)x=new Node();
        if(d==key.length())
        {
            x.value=value;
            return x;
        }
        char c=key.charAt(d);
        x.next[c-97]=put(x.next[c-97],key,value,d+1);
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
      public Node get(Node x,String key,int d)
      {
          if(x==null)return null;
          if(d==key.length())
          {
              return x;
          }
          char c=key.charAt(d);
          return get(x.next[c-97],key,d+1);
      }
    public Iterable<String> keys()
    {
        Queue<String> queue=new PriorityQueue<String>();
        collect(root,"",queue);
        return queue;
    }
    public void collect(Node x,String prefix,Queue queue)
    {
        if(x==null)return;
        if(x.value!=null)queue.add(prefix);
        for(char c=0;c<26;c++)
        {
            int num=c+97;
            char ch=(char)num;
            collect(x.next[c],prefix+ch,queue);
        }
    }
    public Iterable<String> keyswithprefix(String prefix)
    {
        Queue<String> queue=new PriorityQueue<String>();
        Node x=get(root,prefix,0);
        collect(x,prefix,queue);
        return queue;
    }
    public String longestPrefix(String query)
    {
        int length=search(root,query,0,0);
        return query.substring(0,length);
    }
    public int search(Node x,String query,int d,int length)
    {
        if(x==null)return length;
        if(x.value!=null)length=d;
        if(d==query.length())return length;
        char c=query.charAt(d);
        return search(x.next[c-97],query,d+1,length);
    }
      public static void main(String[] args)
      {
          Scanner scanner=new Scanner(System.in);
          TrieST<Integer> trieST=new TrieST<Integer>();
          trieST.put("kishore",3);
          trieST.put("baktha",5);
          //System.out.println(trieST.get("kishore"));
          //System.out.println(trieST.keys());
         // System.out.println(trieST.keyswithprefix("bak"));
          System.out.println(trieST.longestPrefix("bakthas"));
      }
}
