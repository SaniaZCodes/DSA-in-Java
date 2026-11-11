/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author Digital
 */

class CNode<T>
{
    T data;
    CNode<T> next;
    
    CNode(T value)
    {
        this.data=value;
        this.next=null;
    }
}
public class SinglyCircularLinkedList<T>
{
    CNode<T> start=null;
    
    public void insertAtStart(T value)
    {
        CNode<T> n= new CNode<T>(value);
        
        if(start==null)
        {
            start=n;
            n.next=n;
        }
        else 
        {
            CNode<T> temp=start;
            
            while(temp.next!=start)
            {
                temp=temp.next;
            }
            n.next=start;
            temp.next=n;
            start=n;   // this is extra because at insert at start we change start         
        }
    }
    
    
    public void insertAtEnd(T value)
    {
        CNode<T> n= new CNode<T>(value);
        
        if(start==null)
        {
            start=n;
            n.next=n;
        }
        else
        {
            CNode<T> temp=start;
            while(temp.next!=start)
            {
                temp=temp.next;
            }
            n.next=start;
            temp.next=n;
            // start=n; no need of this bcz in insertatend we donot change start
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
           CNode<T> temp=start;
           
           while(temp.next!=start)
           {
               temp=temp.next;
           }
           T value=start.data;
           start=start.next;
           temp.next=start;
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
            CNode<T> leader=start;
            CNode<T> follower=null;
            
            while(leader.next!=start)
            {
                follower=leader;
                leader=leader.next;
            }
            T value=leader.data;
            follower.next=leader.next;
            leader=null;
            return value;
        }
    }
    
    
    public void traverse()
    {
        if(start==null)
        {
            System.out.print("List is empty.");
            return;
        }
        
        CNode<T> temp=start;
        
        do
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        while(temp!=start);
        
        System.out.println("Back to Start (" + start.data + ")");
    }

    
    public boolean search(T value)
    {
        if(start==null)
        {
            return false;
        }
        CNode<T> temp=start;
        
        while(temp.next!=start)
        {
            if(temp.data.equals(value))
            {
                return true;
            }
            temp=temp.next;
        }
        
        if(temp.data.equals(value))
        {
            return true;
        }
        
        return false;
    }   
}