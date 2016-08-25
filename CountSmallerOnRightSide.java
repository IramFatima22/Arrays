class Node1{
	int data,height;
	Node1 left;
	Node1 right;
	public Node1(int data){
		this.data=data;
		left=right=null;
		height=1;
	}
}
public class CountSmallerOnRightSide {
	static int result=0;
	public static void main(String[] args) {
		int arr[]={12,1,2,3,0,11,4};
		int n=arr.length;
		int res[]=new int[n];
		Node1 node=null;
		for(int i=n-1;i>=0;i--){
			result=0;
			node=insert(node,arr[i]);
			res[i]=result;
		}
		for(int i=0;i<n;i++)
			System.out.print(res[i]+" ");

	}
	private static Node1 insert(Node1 node, int val) {
		if(node==null)
			return new Node1(val);
		if(val<node.data)
			node.left=insert(node.left, val);
		if(val>node.data){
			node.right=insert(node.right, val);
			result+=getSize(node.left)+1;
		}
		node.height=Math.max(getHeight(node.left), getHeight(node.right))+1;
		int bal=getHeight(node.left)-getHeight(node.right);
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

	private static int getSize(Node1 node) {
		if(node==null)
			return 0;
		return getSize(node.left)+getSize(node.right)+1;
	}
	private static Node1 leftRotate(Node1 node) {
		Node1 right=node.right;
		Node1 rightLeft=right.left;
		right.left=node;
		node.right=rightLeft;
		node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
		right.height=Math.max(getHeight(right.left), getHeight(right.right))+1;
		return right;
	}

	private static Node1 rightRotate(Node1 node) {
		Node1 left=node.left;
		Node1 leftRight=left.right;
		left.right=node;
		node.left=leftRight;
		node.height=Math.max(getHeight(node.left),getHeight(node.right))+1;
		left.height=Math.max(getHeight(left.left), getHeight(left.right))+1;
		return left;
	}
	private static int getHeight(Node1 node) {
		if(node==null)
			return 0;
		return Math.max(getHeight(node.left), getHeight(node.right))+1;
	}

}
