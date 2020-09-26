
public class Driver {

	public static void main(String[] args) {

		int maxSize = 100; // array size
		SortableArray arr; // reference to array
		arr = new SortableArray(maxSize); // create the array

		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.median();



		
		
		
		arr.display(); // display items

		// sort the items
		long startTime = System.nanoTime();
		//arr.bubbleSort();     
		//arr.insertionSort(); 
		//arr.selectionSort(); 
		arr.oddEvenSort();
		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		
		arr.display(); // display them again

		System.out.println("Time: " + duration);
	}

}
