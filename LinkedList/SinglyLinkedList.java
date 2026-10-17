package LinkedList;

class Node<T>
{
    T data;
    Node<T> next;
    
    Node(T value)
    {
        this.data=value;
        this.next=null;
    }
}

public class SinglyLinkedList<T>
{
    Node<T> start=null;
    
    public void insertAtStart(T value)
    {
        Node<T> newNode= new Node<T>(value);
        newNode.next=start;
        start=newNode;
    }
    
    
    public T deleteAtStart()
    {
        if(start==null)
        {
            return null;
        }
        else
        {
            T value = start.data;
            start=start.next;
            return value;
        }
    }
    
    
    public void insertAtEnd(T value)
    {
        Node<T> n = new Node<T>(value);
        
        if(start==null)
        {
            start=n;
        }
        else
        {
            Node<T> t1= start;
            while(t1.next!=null)
            {
                t1=t1.next;
            }
            t1.next=n;
        }
    }
    
    
    public T deleteAtEnd()
    {
        if (start==null)
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
            Node<T> leader=start;
            Node<T> follower=null;
            
            while(leader.next!=null)
            {
                follower=leader;
                leader=leader.next;
            }
            T value = leader.data;
            follower.next=null;
            return value;
        }
    }
    
    
    public void traverse()
    {
        Node<T> t1= start;
        while(t1!=null)
        {
            System.out.println(t1.data+" -> ");
            t1=t1.next;
        }
    }
    
    
    public boolean search(T value)
    {
        Node<T> n= start;
        while(n!=null)
        {
            if (n.data.equals(value))
            {
                return true;
            }
            n=n.next;
        }
        return false;
    }
}
