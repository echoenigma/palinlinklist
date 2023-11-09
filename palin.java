package newtojava;

//{ Driver Code Starts
import java.util.*;

class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class Is_LinkedList_Palindrom
{
	 Node head;  
	 Node tail;
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
		{
			head = node;
			tail = node;
		} else 
		{
		    tail.next = node;
		    tail = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
			    tail.next = new Node(a);
			    tail = tail.next;
			}
			
			Solution g = new Solution();
			if(g.isPalindrome(head) == true)
			    System.out.println(1);
		    else
			    System.out.println(0);
			t--;
		}
		
	}
}




// } Driver Code Ends


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

class Solution
{
    Node reverse(Node head)
    {
        Node current=head;
        Node after=null;
        Node prev=null;
        while(current!=null)
        {
            after=current.next;
            current.next=prev;
            prev=current;
            current=after;
        }
        return prev;
    }
    boolean isPalindrome(Node head) 
    {
        Node s=head;
        Node f=head;
        while(f.next!=null&&f.next.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }
        Node temp=reverse(s.next);
        s.next=temp;
        Node p1=head;
        Node p2=s.next;
        while(p2!=null)
        {
            if(p1.data!=p2.data)
            {
                return false;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return true;
        
    }    
}

