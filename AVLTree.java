
class Node{
	int data,height;
	Node left;
	Node right;
	public Node(int data){
		this.data=data;
		left=right=null;
		height=1;
	}
}
public class AVLTree {

	public static void main(String[] args) {
		int arr[]={4,11,0,3,2,1,12};
		Node node=null;
		for(int i=0;i<arr.length;i++){
			node=insert(node,arr[i]);
		}
		inOrderTraversal(node);

	}

	private static void inOrderTraversal(Node node) {
		if(node==null)
			return;
		inOrderTraversal(node.left);
		System.out.print(node.data+" ");
		inOrderTraversal(node.right);	
	}
	private static int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
	public static Node delete(Node node, int val) {
		if(node==null)
			return null;
		if(node.data<val)
			node.right=delete(node.right, val);
		else if(node.data>val)
			node.left=delete(node.left,val);
		else{
			if(node.left==null || node.right==null){
				node=node.left==null?node.right:node.left;
			}
			else{
				int min=getMin(node.right);
				node.data=min;
				node.right=delete(node.right,min);
			}		
		}
		if(node==null)
			return node;
		node.height=getHeight(node.left)+getHeight(node.right)+1;
		int bal=getBalance(node);
		if(bal>1 && getBalance(node.left)>=0)
			node=rightRotate(node);
		else if(bal>1 && getBalance(node.right)<0){
			node.right=leftRotate(node.right);
			node=rightRotate(node);
		}
		else if(bal<-1 && getBalance(node.right)<=0)
			node=leftRotate(node);
		else if(bal<1 && getBalance(node.left)>0){
			node.left=rightRotate(node.left);
			node=leftRotate(node);
		}
		return node;
	}
	private static int getMin(Node node) {
		while(node.left!=null){
			node=node.left;
		}
		return node.data;
	}

	public static Node insert(Node node, int val) {
		if(node==null)
			return new Node(val);
		if(val<node.data)
			node.left=insert(node.left, val);
		if(val>node.data)
			node.right=insert(node.right, val);
		node.height=Math.max(getHeight(node.left), getHeight(node.right))+1;
		int bal=getBalance(node);
		if(bal>1){
			if(val<node.left.data)
				node= rightRotate(node);
			else{
				node.left=leftRotate(node.left);
				node= rightRotate(node);
			}
		}
		else if(bal<-1){
			if(val>node.right.data)
				node= leftRotate(node);
			else{
				node.right=rightRotate(node.right);
				node= leftRotate(node);
			}
		}
		return node;
	}

	private static Node leftRotate(Node node) {
		Node right=node.right;
		Node rightLeft=right.left;
		right.left=node;
		node.right=rightLeft;
		node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
		right.height=Math.max(getHeight(right.left), getHeight(right.right))+1;
		return right;
	}

	private static Node rightRotate(Node node) {
		Node left=node.left;
		Node leftRight=left.right;
		left.right=node;
		node.left=leftRight;
		node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
		left.height=Math.max(getHeight(left.left), getHeight(left.right))+1;
		return left;
	}
	private static int getHeight(Node node) {
		if(node==null)
			return 0;
		return Math.max(getHeight(node.left), getHeight(node.right))+1;
	}

}
