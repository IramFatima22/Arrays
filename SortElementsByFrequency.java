import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Elements{
	int val;
	int index;
	int count;
	public Elements(int val,int index){
		this.val=val;
		this.index=index;
		this.count=1;
	}
}
class ElementsComparator implements Comparator<Elements>{
	@Override
	public int compare(Elements o1, Elements o2) {
		return o1.val-o2.val;
	}	
}
class ElementsComparator2 implements Comparator<Elements>{

	@Override
	public int compare(Elements o1, Elements o2) {
		if(o1.count==o2.count)
			return o1.index-o2.index;
		return o2.count-o1.count;
	}
	
}
public class SortElementsByFrequency {

	public static void main(String[] args) {
		int arr[]={2,5,2,8,5,6,8,8};
		sort(arr);
	}
	private static void sort(int[] arr) {
		int n=arr.length;
		ArrayList<Elements> elem=new ArrayList<Elements>();
		for(int i=0;i<n;i++){
			elem.add(new Elements(arr[i], i));
		}
		Collections.sort(elem,new ElementsComparator());
		for(int i=1;i<n;i++){
			if(elem.get(i).val==elem.get(i-1).val){
				elem.get(i).count+=elem.get(i-1).count;
				elem.get(i).index=elem.get(i-1).index;
				elem.get(i-1).index=-1;
			}
		}
		Collections.sort(elem,new ElementsComparator2());
		for(int i=0;i<n;i++){
			if(elem.get(i).index!=-1)
				System.out.println(elem.get(i).val);
		}	
	
	}

}
