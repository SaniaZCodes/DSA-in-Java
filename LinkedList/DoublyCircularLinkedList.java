/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author Digital
 */

class DCNode<T>
{
    T data;
    DCNode<T> next;
    DCNode<T> prev;
    
    DCNode(T value)
    {
        this.data=value;
        this.next=null;
        this.prev=null;
    }
}

public class DoublyCircularLinkedList<T>
{
    DCNode<T> start=null;
    
    public void insertAtStart(T value)
    {
        DCNode<T> n= new DCNode<T>(value);
        
        if(start==null)
        {
            start=n;
            n.next=n;
            n.prev=n;
        }
        else
        {
            DCNode<T> tail=start.prev;
            
            n.next=start;
            n.prev=tail;
            
            tail.next=n;
            start.prev=n;
            start=n;
        }
    }
    
            
    public void insertAtEnd(T value)
    {
        DCNode<T> n= new DCNode<T>(value);
        
        if(start==null)
        {
            start=n;
            n.next=n;
            n.prev=n;
        }
        else
        {
            DCNode<T> tail=start.prev;
            
            n.next=start;
            n.prev=tail;
            
            tail.next=n;
            start.prev=n;
        }
    }
            
    public T deleteAtStart()
    {
        if(start==null)
        {
            return null;
        }
        else if(start.next==start)
        {
            T value=start.data;
            start=null;
            return value;
        }
        else
        {
            DCNode<T> tail=start.prev;
            
            T value=start.data;
            start=start.next;
            tail.next=start;
            start.prev=tail;
            return value;            
        }
    }
            
    public T deleteAtEnd()
    {
        if(start==null)
        {
            return null;
        }
        else if(start.next==start)
        {
            T value=start.data;
            start=null;
            return value;
        }
        else
        {
            T value=start.prev.data;
            
            DCNode<T> newtail= start.prev.prev;
            
            newtail.next=start;
            start.prev=newtail;
            
            return value;
        }
    }
            
    public boolean search(T value)
    {
        if(start==null)
        {
            return false;
        }
        else
        {
            DCNode<T> n=start;
            while(n.next!=start)
            {
                if(n.data.equals(value))
                {
                    return true;
                }
                n=n.next;
            }
            
            if(n.data.equals(value))
            {
                return true;
            }
            return false;
        }
    }
            
    public void traverse()
    {
        if(start==null)
        {
            System.out.print("List is empty.");           
        }
        else
        {
            DCNode<T> temp=start;
            while(temp.next!=start)
            {
                System.out.print(temp.data+" -> ");
                temp=temp.next;
            }
            System.out.print(temp.data+" -> Back to start");
        }    
    }
    
    
    public void traverseBackward() 
    {
        if (start == null) 
        {
            System.out.println("List is empty.");
            return;
        }
    
        DCNode<T> temp = start.prev; // Start at the tail
        System.out.print("Reverse: ");
    
        do
        {
            System.out.print(temp.data + " <- ");
            temp = temp.prev;
        }
        while (temp != start.prev) ;
        
        System.out.println(temp.data + " <- Back to Tail");
    }
}
