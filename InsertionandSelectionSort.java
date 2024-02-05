import java.util.Arrays;

public class InsertionandSelectionSort {
	public static void main(String[] args) {
		int[]arr= {5,3,4,1,2};
		System.out.println(Arrays.toString(arr));
		System.out.println("after insertion sort:");
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));

	
	//sort in partially
	// put element at correct index at left hand side
	//5 3 4 1 2 i=0,j=1;
	//3 5 4 1 2 i=1 j=2;
	//3 4 5 1 2 i=2 j=3;
	//1 3 4 5 2 i=3 j=4;
	//1 2 3 4 5 i=4 j=5 Break loop sorted. j out of bound then don't take i=4.
		
		
		System.out.println("");
		int[]arr2= {4,5,1,2,3};
		System.out.println(Arrays.toString(arr2));
		System.out.println("after selection sort:");
        SelectionSort(arr2);
        System.out.println(Arrays.toString(arr2));
	//choose a num than put it in a correct position.
	// 4 5 1 2 3 choose 5.
	// 4 3 1 2 5 put in right position.Now go until arr.length-1-1;
	// 2 3 1 4 5
	// 2 1 3 4 5
	// 1 2 3 4 5
	//in here ı choose the max index and put it in on right position.It can be doing in minimum index too
	}
	public static void insertionSort(int[]arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j>0; j--) {
				if(arr[j]<arr[j-1]) {
					swap(arr,j,j-1);
				}
				else {
					break;
				}
			}
		}
		
	}
	public static void SelectionSort(int[]arr) {
		for(int i=0; i<arr.length; i++) {
			//find the max item at remaining array and swap with it correct index.
			int last=arr.length-i-1;
			int maxIndex=getmax(arr,0,last);
			swap(arr,maxIndex,last);
		}
		
	}
	public static int getmax(int[]arr,int start,int end) {
		int max=start;
		for(int i=start; i<=end; i++) {
		  if(arr[i]>arr[max]) {
			  max=i;
		  }
		}
		return max;
		
	}
	
	public static void swap(int[]arr,int first,int second) {
		int temp=arr[first];
		arr[first]=arr[second];
		arr[second]=temp;
	}
	
}