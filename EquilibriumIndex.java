

public class EquilibriumIndex {

	public static void main(String[] args) {
		int arr[]={1,-3,2,5,-7};
		findEquibliumIndex(arr);
	}

	private static void findEquibliumIndex(int[] arr) {
		int n=arr.length;
		int tot=0;
		for(int i=0;i<n;i++)
			tot+=arr[i];
		int left=0;
		int right=tot;
		for(int i=0;i<n;i++){
			right-=arr[i];
			if(right==left)
				System.out.println("Eqb Index :"+i);
			left+=arr[i];
		}
	}

}
