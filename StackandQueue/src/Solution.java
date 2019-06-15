import java.util.LinkedList;
public class Solution {
	//sort with 2 stacks
	public void sort1(LinkedList<Integer> s1) {
		if(s1==null||s1.size()<=1){
		      return;
		}
	    LinkedList<Integer> s2 = new LinkedList<Integer>();
	    sort1(s1,s2);
	}
	private void sort1(LinkedList<Integer>input,LinkedList<Integer> buffer){
		int preMin=Integer.MIN_VALUE;
		while(input.peekLast() > preMin){
			int curMin = Integer.MAX_VALUE;
			int count = 0;
			while(!input.isEmpty() && (input.peekLast() > preMin)){
				if(curMin > input.peekLast()){
				    curMin = input.peekLast();
				    count = 1;
				} else if(curMin == input.peekLast()){
				    count++;
				}
				buffer.offerLast(input.pollLast());
			}
			while(count > 0){
				input.offerLast(curMin);
				count--;
			}
			while(!buffer.isEmpty()){
				int tmp = buffer.pollLast();
				if(tmp != curMin){
				    input.offerLast(tmp);
				}
			}
			preMin = curMin;
		}
    }
	  //sort with 3 stacks
  public void sort(LinkedList<Integer> s1) {
	    LinkedList<Integer> s2 = new LinkedList<Integer>();
	    LinkedList<Integer> s3 = new LinkedList<Integer>();
	    if(s1==null || s1.size()<2){
	      return;
	    }
	    int actualSize=s1.size();
	    while(!(s3.size()==actualSize)){
		  int globalMin=Integer.MAX_VALUE;
		  int count=0;
		  while(!s1.isEmpty()){
		    if(s1.peekFirst()<globalMin){
		      globalMin=s1.peekFirst();
		      count=1;
		    }
		    else if(s1.peekFirst()==globalMin){
		      count++;
		    }
		    s2.offerFirst(s1.pollFirst());
		  }
		  while(count>0){
		    s3.offerFirst(globalMin);
		    count--;
		  }
		  while(!s2.isEmpty()){
		    int tmp=s2.pollFirst();
		    if(tmp!=globalMin){
		     s1.offerFirst(tmp);
		    }
		  }
	    }
		    while(!s3.isEmpty()) {
			s1.offerFirst(s3.pollFirst());
		    }
	 }

	public static void main(String[]args) {
		Solution solu=new Solution();
		LinkedList<Integer> list=new LinkedList<>();
		int[]data= {1,4,3,2,3,5,3,4};
		for(int i:data) {
			list.offerLast(i);
		}
		System.out.println(list);
		solu.sort(list);
		System.out.println(list);
	}
}
