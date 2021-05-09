

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell 3567 7i3
 */
import java.util.Scanner;
public class linkedList_position 
{
   static Node head;
    static class Node
    {
        int data;
        Node next;
        
        public Node(int data) //constractor
        {
            this.data=data;
            this.next=null;
        }
    }
    public static linkedList_position  add(linkedList_position  list,int data)
    {
        Node newnode=new Node(data);
        newnode.next=null;
        if(list.head==null)
        {
            list.head=newnode;
        }
        else
        {
            Node last=list.head;
            while(last.next!=null)
            {
                last=last.next;
            }
            last.next=newnode;
        }
        return list;
    }
    public static linkedList_position  insert(linkedList_position  list, int posi,int insrt)
    {
        Node newnode=new Node(insrt);
        newnode.next=null;
        /*Node cout=list.head;
          int c=0;
            while(cout.next!=null){ // count no of nodes in linked list
              c++;
              cout=cout.next;
         }*/
        if(list.head==null)
        {
           list.head=newnode;
        }
        else if(posi==0)
        {
            newnode.next=list.head;
            list.head=newnode;
        }
        else
        {
          Node pre=list.head;
          Node last=list.head;
          int c=1;
          while(c<=posi)
          {
             pre=last;
             last=last.next; 
             c++;
          }
          pre.next=newnode;
          newnode.next=last;
        }
    return list;
}
    public static linkedList_position  insertFirstPosi(linkedList_position  list,int insrtfirst)
    {
        Node newnode=new Node(insrtfirst);
        newnode.next=null;
        if(list.head==null)
        {
          list.head=newnode;
        }
        else
        {
        newnode.next=head;
        head=newnode;
        }
        return list;
    }
    public static linkedList_position  delete(linkedList_position  list, int posi)
    {
          Node pre=list.head;
          Node last=list.head;
          Node cout=list.head;
          int c=1;
            while(cout.next!=null){ // count no of nodes in linked list
              c++;
              cout=cout.next;
            }
            if(posi==0)      // first element delete
            {
              head=pre.next;
              pre=null;
            }
          else if(c>=posi){
            int c1=1;
          while(c1<=posi)
          {                
            pre=last;
            last=last.next; 
            c1++;
          }
          pre.next=last.next;
          last=null;
          }
        else
          {
            System.out.println("This position element not exist to delete");
          }
          return list;
    }
    public static void display(linkedList_position  list)
    {
        if(list.head==null)
        {
            System.out.println("list is empty");
        }
        else
        {
            Node cur=list.head;
            while(cur!=null)
            {
                System.out.print(cur.data+"\t");
                cur=cur.next;
            }
            System.out.println();
        }
    }
    public static linkedList_position  sorted(linkedList_position  list)
    {
        if(list.head==null)
        {
            System.out.println("list is empty");
        }
        else
        {
            Node count=list.head;
            while(count!=null)
            {
                Node pre=list.head;
                Node last=list.head;
                while(last.next!=null){
              if(pre.data>pre.next.data)
              {
                int temp=pre.data;
                pre.data=pre.next.data;
                pre.next.data=temp;
              }
              pre=pre.next;
              last=last.next;
            }
           count=count.next;
        }
    }
        return list;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        linkedList_position  list=new linkedList_position();
        while(true){
        System.out.println("1.Create LinkedList\n2.Insert element\n3.first position insert element\n4.which element delete\n5.Sorted element\n6.Display\n7.Exit");
        System.out.println("Enter your choice");
        int choice=sc.nextInt();
        switch(choice)
        {
          case 1:
            {
              System.out.println("Enter the size of linkedlist:");
              int s=sc.nextInt();
              int i=0;
              System.out.println("Enter the element:");
              while(i<s)
              {
                 int a=sc.nextInt();
                 add(list,a);
                 s--;
              }
              break;
            }
            case 2:
            {
             System.out.println("which position element to insert");
             int po=sc.nextInt();
             System.out.println("which element to insert in linkedlist:");
             int ele=sc.nextInt();
             insert(list,po,ele);
             break;
            }
            case 3:
            {
             System.out.println("Enter the element:");
             int dt=sc.nextInt();
             insertFirstPosi(list,dt);  
             break;
            }
            case 4:
            {
             System.out.println("which position element to delete from linkedlist:");
             int po=sc.nextInt();  
             delete(list,po);
             break;
            }
            case 5:
            {
               sorted(list);
                break;
            }
            case 6:
            {
                display(list);
                break;
            }
            case 7:
            {
                System.exit(0);
            }
            default:
            {
                System.out.println("incorrect choice");
                break;
            }   
        }
        }
    }    
}
