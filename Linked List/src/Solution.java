public class Solution {
	public ListNode reorder(ListNode head) {
		// Write your solution here
		if(head==null||head.next==null){
		return head;
	}
	ListNode mid=midNode(head);
	ListNode one=head;
	ListNode two=mid.next;
	mid.next=null;
	return merge(one,reverse(two));   
	}
	
	public ListNode midNode(ListNode head) {
		ListNode fast=head;
		ListNode slow=head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}

	private ListNode reverse(ListNode head) {
		ListNode prev=null;
		while(head!=null) {
			ListNode next=head.next; //no need for new object, this is just a reference
			head.next=prev;
			prev=head;
			head=next;
		}
		return prev;
	}

	private ListNode merge(ListNode first,ListNode second) {
		ListNode dummyHead=new ListNode(0);
		ListNode cur=dummyHead;
		while(first!=null && second!=null) {
			cur.next=first;
			first=first.next;
			cur.next.next=second;
			second=second.next;
			cur=cur.next.next;
		}
		if(first!=null) {
			cur.next=first;
		}else {
			cur.next=second;
		}
		return dummyHead.next;
	}
	
	
	
	//Check if the linked list is a loop
	boolean hasCycle(ListNode head) {
		if(head==null||head.next==null){
  			return false;
		}
		ListNode slow=head;
		ListNode fast=head;
		while(fast.next!=null && fast.next.next!=null){
		  slow=slow.next;
		  fast=fast.next.next;
		  if(slow==fast){
		      return true;
		  }
		}
		return false;
	}

	
	public ListNode partition(ListNode head, int target) {
	    if(head==null)return null;
	    ListNode dummySmall=new ListNode(0);
	    ListNode dummyBig=new ListNode(0);
	    ListNode smallTail=dummySmall;
	    ListNode bigTail=dummyBig;
	    while(head!=null){
	        if(head.value< target){
	            smallTail.next=head;
	            smallTail=smallTail.next;
	        }
	        else{
	            bigTail.next=head;
	            bigTail=bigTail.next;
	        }
	        head=head.next;
	    }
	    smallTail.next=dummyBig.next;
	    bigTail.next=null;
	    return dummySmall.next;
	}
	
	public ListNode mergeTwoSortedLinkedList(ListNode one, ListNode two) {
	    // Write your solution here
	    ListNode dummy=new ListNode(0);
	    ListNode curr=dummy;
	    while(one!=null&&two!=null){
	      if(one.value<=two.value){
	        curr.next=one;
	        one=one.next;
	      }
	      else{
	        curr.next=two;
	        two=two.next;
	      }
	      curr=curr.next;
	    }
	    if(one!=null){
	      curr.next=one;
	    }
	    if(two!=null){
	      curr.next=two;
	    }
	    return dummy.next;
	}
	
	
	
	public boolean isPalindrome(ListNode head) {
	    // Write your solution here
	    if(head==null||head.next==null){
	        return true;
	    }
	    ListNode mid=midNode(head);
	    ListNode one=head;
	    ListNode two=mid.next;
	    mid.next=null;
	    return isPalindrome(one,reverse(two));
	  }
  private boolean isPalindrome(ListNode one,ListNode two){
      while(one!=null&&two!=null){
          if(one.value!=two.value){
              return false;
          }
          one=one.next;
          two=two.next;
      }
      return true;
  }
  
  //mergeSort LinkedList
	public ListNode mergeSort(ListNode head) {
		// Write your solution here
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = midNode(head);
		ListNode rightHalf = mid.next;
		mid.next = null;
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(rightHalf);
		return mergeTwoLinkedList(left, right);
	}
  private ListNode mergeTwoLinkedList(ListNode one,ListNode two){
      ListNode dummy=new ListNode(0);
      ListNode curr=dummy;
      while(one!=null&&two!=null){
          if(one.value<two.value){
              curr.next=one;
              one=one.next;
          }
          else{
              curr.next=two;
              two=two.next;
          }
          curr=curr.next;
      }
      if(one!=null){
          curr.next=one;
      }
      if(two!=null){
          curr.next=two;
      }
      return dummy.next;
  }
	  
	  
}

