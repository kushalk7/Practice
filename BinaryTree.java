import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.lang.model.type.MirroredTypeException;

public class BinaryTree {
	Node root;
	
	
	public void addNode(int data) {
		Node currNode = root;
		Node newNode = new Node(data); 
		if (root == null) {
			root = newNode;
			return;
		}
		else {
			currNode = root;
			
			while(true) {
				if(data < currNode.data) {
					if (currNode.left == null){
						currNode.left = newNode;
						return;
					}
					else {
						currNode = currNode.left;
					}
				}
				else {
					if (currNode.right == null){
						currNode.right = newNode;
						return;
					}else {
						currNode = currNode.right;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		int[] set = {23,5,64,66,36,69,6,62,21,67,56,27,87,35,77};
		for (int i : set){
			t.addNode(i);
		}
//		t.inorder(t.root);
		t.inorderIterative();
//		t.preorder(t.root);
//		t.preorderIterative();
//		t.postorder(t.root);
//		t.postorderIterative();
//		System.out.println("\nSuccessor: "+t.inorderSuccessor(66).data);
//		System.out.println("\nSuccessor: "+t.postorderSuccessor(5).data);
//		t.mirrorBinaryTree();
		System.out.println(t.kthLargest(3));
		TreeGUI gui = new TreeGUI(t);
	}
	
	public void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		}
	}
	
	public void inorderIterative() {
		Stack<Node> s = new Stack<>();
		if(root == null)
			return;
		Node node = root;
//		s.push(root);
		while(node != null) {
			s.push(node);
			node = node.left;
		}
		while(!s.isEmpty()) {
			Node n = s.pop();
			System.out.print(n.data+" ");
			if(n.right != null){
				n = n.right;
				while(n != null) {
					s.push(n);
					n = n.left;
				}
			}
		}
	}
	
	public void preorder(Node node) {
		if(node == null)
			return;
		
		System.out.print(node.data+" ");
		preorder(node.left);
		preorder(node.right);
	}
	
	public void preorderIterative() {
		if(root == null)
			return;
		Node node = root;
		Stack<Node> S = new Stack<>();
		S.push(node);
		while(!S.isEmpty()) {
			Node n = S.pop();
			System.out.print(n.data+" ");
			if(n.right != null) {
				S.push(n.right);
			}
			if(n.left != null) {
				S.push(n.left);
			}			
		}
		
	}
	
	public void postorder(Node node) {
		if(node == null)
			return;
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.data+" ");
	}
	
	public void postorderIterative() {
		if(root == null)
			return;
		
		Node curr = root;
		Stack<Node> S = new Stack<>();
		S.push(curr);

		Node prev = null;
		while(!S.isEmpty()) {
			curr = S.peek();
			if(prev == null|| prev.left == curr || prev.right == curr) { // curr is prev child
				if(curr.left != null) { //has left child then go down
					S.push(curr.left);
				}else if (curr.right != null) { // has right child then go down
					S.push(curr.right);
				}else { // It is leaf node 
					System.out.print(S.pop().data+" ");
				}					
			}else if(prev == curr.left){ // curr is parent of prev
				if(curr.right != null) { // has right child
					S.push(curr.right);
				}else { // is leaf node
					System.out.print(S.pop().data+" ");
				}
			}else if(prev == curr.right){ // Done with left and right children's , pop parent
				System.out.print(S.pop().data+" ");
			}
			prev = curr;
		}
	}

	public int getheight(Node node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(getheight(node.left), getheight(node.right));
					
	}
	
	public class TestBinaryTree
	{
	    // Root of the Binary Tree
	    Node root;
	 
	    // To keep tract of previous node in Inorder Traversal
	    Node prev;
	 
	    boolean isBST()  {
	        prev = null;
	        return isBST(root);
	    }
	 
	    /* Returns true if given search tree is binary
	       search tree (efficient version) */
	    boolean isBST(Node node)
	    {
	        // traverse the tree in inorder fashion and
	        // keep a track of previous node
	        if (node != null)
	        {
	            if (!isBST(node.left))
	                return false;
	 
	            // allows only distinct values node
	            if (prev != null && node.data <= prev.data )
	                return false;
	            prev = node;
	            return isBST(node.right);
	        }
	        return true;
	    }
	}
	
	public Node inorderSuccessor(int k) {
		Node node = root;
		Node next = null;
		while(node!=null && node.data!=k){
			if(node.data > k){
				next = node;
				node = node.left;				
			}else
				node = node.right;
		}
		if(node==null)
			return null;
		if(node.right == null)
			return next;
		else if(node.right!= null){
			node = node.right;
			while(node.left != null){
				node = node.left;
			}
			return node;
		}
		return null;
	}
	
	public Node postorderSuccessor(int k) {
		Node node = root;
		Node parent = null;
		while(node!=null && node.data != k){
//			parent = node;
			if(node.data > k){
				parent = node;
				node = node.left;
			}else{
				parent = node;
				node = node.right;
			}	
		}
		if(node == null)
			return null;
		if(parent.left == node){ // little incorrect
			if(parent.right == null)
				return parent;
			Node n = parent.right;
			while(n != null){
				if( n.left != null){
					while(n.left!= null){
						n = n.left;
					}
					return n;
				}else if(n.right != null){
					n = n.right;
				}
				
			}
			return n;
		}else if(parent.right == node){
			return parent;
		}
		return null;
	}
	
	public void BFS(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		if (root == null)
			return;
		q.add(root);
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			System.out.print(" " + n.data);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
	}
	
	public void mirrorBinaryTree() {
		Node node = root;
		if (node == null)
			return;
		Stack<Node> S = new Stack<>();
		S.push(node);
		Node temp;
		while(!S.isEmpty()) {
			node = S.pop();
			
			temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			if(node.right != null){
				S.push(node.right);
			}
			if(node.left!= null)
				S.push(node.left);
		}
	}
	
	public int kthLargest(int k){
		Node node = root;
		int count = 0;
		if(node == null){
			return -1;
		}
		System.out.println();
		Stack<Node> S = new Stack<>();
		while(node!= null){
			S.push(node);
			node = node.right;
		}
		while(!S.isEmpty()){
			node = S.pop();
			count++;
			if(count == k)
				return node.data;
			System.out.print(node.data+" ");
			if(node.left != null){
				node = node.left;
//				S.push(node);
				while(node != null){
					S.push(node);
					node = node.right;
				}
			}
		}
		return -1;
	}
}
	
