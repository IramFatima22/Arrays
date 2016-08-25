import java.util.LinkedList;

public class MaxOfSubarrays {

	public static void main(String[] args) {
		int arr[]={1,2,3,1,4,5,2,3,6};
		int k=3;
		method1(arr,k);
		System.out.println();
		method2(arr,k);
	}
	//Using dequeue
	private static void method2(int[] arr, int k) {
		int n=arr.length;
		LinkedList<Integer> dq=new LinkedList<Integer>();
		dq.add(arr[0]);
		for(int i=1;i<k;i++){
			while(!dq.isEmpty() && arr[i]>dq.peekLast()){
				dq.removeLast();
			}
			dq.addLast(arr[i]);
		}
		System.out.print(dq.peekFirst()+" ");
		for(int i=k;i<n;i++){
			if(arr[i-k]==dq.peekFirst())
				dq.removeFirst();
			while(!dq.isEmpty() && arr[i]>dq.peekLast())
				dq.removeLast();
			dq.addLast(arr[i]);
			System.out.print(dq.peekFirst()+" ");
		}
		
	}
	//Using AVL BST
	private static void method1(int[] arr, int k) {
		int n=arr.length;
		Node node=null;
		for(int i=0;i<k;i++){
			node=AVLTree.insert(node, arr[i]);
		}
		int x=getMax(node);
		System.out.print(x+" ");
		for(int i=k;i<n;i++){
			node=AVLTree.delete(node,arr[i-k]);
			node=AVLTree.insert(node, arr[i]);
			x=getMax(node);
			System.out.print(x+" ");
		}
		
	}
	private static int getMax(Node node) {
		while(node.right!=null){
			node=node.right;
		}
		return node.data;
	}

}
