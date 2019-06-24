import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	 public static List<Integer> preOrder(TreeNode root) {
	    // Write your solution here
	    if(root==null){
	    	return new ArrayList<Integer>();
	    }
	    Deque <TreeNode> stack= new LinkedList<TreeNode>();
	    ArrayList<Integer> result=new ArrayList<>();
	    stack.offerFirst(root);
	    while(!stack.isEmpty()){
	      TreeNode cur=stack.pollFirst();
	      result.add(cur.key);
	      if(cur.right!=null){
	        stack.offerFirst(cur.right);
	      }
	      if(cur.left!=null){
	        stack.offerFirst(cur.left);
	      }
	    }
	    return result;
	 }
	 
	 //postOrder Traversal 
	  public List<Integer> postOrder(TreeNode root) {
	    ArrayList<Integer> result=new ArrayList<>();
	    if(root==null){
	      return result;
	    }
	    Deque<TreeNode>stack=new LinkedList <>();
	    TreeNode prev=null;
	    stack.offerFirst(root);
	    while(!stack.isEmpty()){
	      TreeNode curr=stack.peekFirst();
	      if(prev==null||curr==prev.left||curr==prev.right){
	        if(curr.left!=null){
	          stack.offerFirst(curr.left);
	        }else if (curr.right!=null){
	          stack.offerFirst(curr.right);
	        }else{
	          result.add(curr.key);
	          stack.pollFirst();
	        }
	      }
	      else if(prev==curr.left){
	        if(curr.right!=null){
	          stack.offerFirst(curr.right);
	        }else{
	          result.add(curr.key);
	          stack.pollFirst();
	        }
	      }else{
	        result.add(curr.key);
	        stack.pollFirst();
	      }
	      prev=curr;
	    }
	    return result;
	  }
	  
	  //in-Order Traversal
	  public List<Integer> inOrder(TreeNode root) {
	    ArrayList<Integer> result=new ArrayList<>();
	    if(root==null){
	      return result;
	    }
	    Deque<TreeNode> stack= new LinkedList<TreeNode>();
	    TreeNode helper=root;
	    while(helper!=null || !stack.isEmpty()){
	      if(helper!=null){
	        stack.offerFirst(helper);
	        helper=helper.left;
	      }else{
	        helper=stack.pollFirst();
	        result.add(helper.key);
	        helper=helper.right;
	      }
	    }
	    return result;
	    
	 }
	  
	  
	 public boolean isSymmetric(TreeNode root) {
		    // Write your solution here
		    if(root==null)return true;
		    return isSymmetric(root.left,root.right);
		  }
	 private boolean isSymmetric(TreeNode left,TreeNode right){
	    if(left==null&&right==null){
	      return true;
	    }else if(left==null || right ==null){
	      return false;
	    }
	    else if(left.key!=right.key){
	      return false;
	    }
	    return isSymmetric(left.left,right.left)&&isSymmetric(left.right,right.right);
	 }
	 
	 //if a tree is Binary Search Tree
	 public boolean isBST(TreeNode root) {
		    // Write your solution here
	    if(root==null){
	      return true;
	    }
	    Integer min=Integer.MIN_VALUE;
	    Integer max=Integer.MAX_VALUE;
	    return isBSThelper(root,min,max);
	  }
	  private boolean isBSThelper(TreeNode root,Integer min,Integer max){
	    if(root==null)return true;
	    if(root.key<=min||root.key>=max)return false;
	    return isBSThelper(root.left,min,root.key)&&isBSThelper(root.right,root.key,max);
	  }
	  
	 //mirror is also considered identical in this case 
	 public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
	    // Write your solution here
	    if(one==null && two==null){
	      return true;
	    }
	    if(one==null || two==null){
	      return false;
	    }
	    if(one.key!=two.key){
	      return false;
	    }

	    return isTweakedIdentical(one.left,two.left)&& isTweakedIdentical(one.right, two.right) || isTweakedIdentical(one.left,two.right)&&isTweakedIdentical(one.right,two.left);
	 }
	 
	 //find everything within the given range in a BST
	 public List<Integer> getRange(TreeNode root, int min, int max) {
	    // Write your solution here
	    if(root==null)return new ArrayList<Integer>();
	    ArrayList<Integer> result=new ArrayList<>();
	    return getRangeHelper(root,min,max,result);
	 }
	 private List<Integer> getRangeHelper(TreeNode root,int min,int max,List<Integer> result){
	    if(root==null)return new ArrayList<Integer>();
	    if(root.key>min){
	         getRangeHelper(root.left,min,max,result);
	    }
	    if(root.key>=min && root.key<=max){
	      result.add(root.key);
	    }
	    if(root.key<max){
	      getRangeHelper(root.right,min,max,result);
	    }
	    return result;
	 }
		  
	 public static void main(String[]args) {
			Solution solution=new Solution();
			TreeNode node1=new TreeNode(5);
			TreeNode node2=new TreeNode(3);
			TreeNode node3=new TreeNode(3);
			node2.left=new TreeNode(1);
			node2.right=new TreeNode(4);
			node3.left=new TreeNode(1);
			node3.right=new TreeNode(4);
			node1.left=node2;
			node1.right=node3;
			solution.isSymmetric(node1);
	}
}
