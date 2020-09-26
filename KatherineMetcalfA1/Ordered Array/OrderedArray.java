class OrderedArray{

	long[] array, arr1, arr2; // reference to array of data
	int numElements; // number of data items

	public OrderedArray(int capacity) // constructor
	{
		array = new long[capacity]; // create array
		numElements = 0;
	}
	
	public int size() {
		return numElements; // return the number of elements in the array
	}

	// search for "searchKey" in the array using Binary Search
	// return the index if found; otherwise, return the number of elements in the
	// array.
	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = numElements - 1;
		int currentIndex;

		while (true) {
			currentIndex = (lowerBound + upperBound) / 2;
			if (array[currentIndex] == searchKey)
				return currentIndex; // found it
			else if (lowerBound > upperBound)
				return numElements; // can't find it
			else // divide range
			{
				if (array[currentIndex] < searchKey)
					lowerBound = currentIndex + 1; // it's in upper half
				else
					upperBound = currentIndex - 1; // it's in lower half
			} // end else divide range
		} // end while
	} // end find()

	public void insert(long value) // put element into array
	{
		int j;
		for (j = 0; j < numElements; j++) // find where it goes
			if (array[j] > value) // (linear search)
				break;

		// j is now the index of where the new value should be inserted

		for (int k = numElements; k > j; k--) // move bigger ones up
			array[k] = array[k - 1];

		array[j] = value; // insert it
		numElements++; // increment size
	} // end insert()

	// delete a value in the array
	// if the value is in the array, delete it and return true; otherwise, return
	// false
	public boolean delete(long value) {
		int j = find(value);
		if (j == numElements) // can't find it
			return false;
		else // found it
		{
			for (int k = j; k < numElements; k++) // move bigger ones down
				array[k] = array[k + 1];
			numElements--; // decrement size
			return true;
		}
	} // end delete()

	public void display() // displays array contents
	{
		for (int j = 0; j < numElements; j++) // for each element,
			System.out.print(array[j] + " "); // display it
		System.out.println("");
	}

}