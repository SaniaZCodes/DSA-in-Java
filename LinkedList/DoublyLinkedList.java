/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author Digital
 */


class DNode<T>
{
    T data;
    DNode<T> next;
    DNode<T> prev;
    
    DNode(T value)
    {
        this.data=value;
        this.next=null;
        this.prev=null;
    }
}
public class DoublyLinkedList<T>
{
    DNode<T> start=null;
    
    public void insertAtStart(T value)
    {
        DNode<T> n= new DNode<T>(value);
        
        // if start==null
        if(start==null)
        {
            start=n;
        }
        else
        {
            n.next=start;
            start.prev=n;
            n.prev=null;
            start=n;
        }
    }
    
    
    public void insertAtEnd(T value)
    {
        DNode<T> n= new DNode<T>(value);
        
        if (start==null)
        {
            start=n;
        }
        else
        {
            DNode<T> t1= start;
            while(t1.next!=null)
            {
                t1=t1.next;
            }
            t1.next=n;
            n.prev=t1;
            n.next=null;
        }
    }
    
    
    public T deleteAtStart()
    {
        if(start==null)
        {
            return null;
        }
        else if(start.next==null)
        {
            T value=start.data;
            start=null;
            return value;
        }
        else
        {
            T value=start.data;
            start=start.next;
            start.prev=null;
            return value;
        }
    }
 

    public T deleteAtEnd()
    {
        if(start==null)
        {
            return null;
        }
        else if(start.next==null)
        {
            T value=start.data;
            start=null;
            return value;
        }
        else
        {
            DNode<T> leader=start;
            
            while(leader.next!=null)
            {
                leader=leader.next;
            }
            T value=leader.data;
            leader.prev.next=null;          
            return value;
        }
    }
    
    
    public void traverse()
    {
        DNode<T> n=start;
        if(start==null)
        {
            System.out.println("List is empty.");
            return;
        }
        while(n!=null)
        {
            System.out.println(n.data+" -> ");
            n=n.next;
        }
        System.out.println("null");
    }
    
    
    public boolean search(T value)
    {
        DNode<T> n=start;
        while(n!=null)
        {
            if(n.data.equals(value))
            {
                return true;
            }
            n=n.next; 
        }
        return false;
    }
    
    
    public void reverseTraverse()
    {
        if(start==null)
        {
            System.out.println("List is empty. Nothing to reverse.");
            return ;
        }
        
        DNode<T> temp =start;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        System.out.print("Reverse: null");// no need to write null here
        while(temp!=null)
        {
            System.out.print(" -> "+temp.data);
            temp=temp.prev;
        }
        System.out.print(" null");
    }
}
