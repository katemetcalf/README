import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		Random randNum = new Random();
		int max = 20;
		int arrayBound1 = randNum.nextInt(max);
		int arrayBound2 = randNum.nextInt(max);

		OrderedArray arr1, arr2;
		arr1 = new OrderedArray(arrayBound1);
		arr2 = new OrderedArray(arrayBound2);

		for (int i = 0; i < arrayBound1; i++) {
			arr1.insert(randNum.nextInt(20));
		}

		for (int i = 0; i < arrayBound2; i++) {
			arr2.insert(randNum.nextInt(20));
		}

		arr1.display();
		System.out.println("\n");
		arr2.display();
		System.out.println("\n");
		
		merge(arr1, arr2);
	}

	public static OrderedArray merge(OrderedArray src1, OrderedArray src2) {

		int firstArrayIndex = 0;
		int secondArrayIndex = 0;
		int arraySize = src1.size() + src2.size();
		OrderedArray mergedArr = new OrderedArray(arraySize);

		for (int i = 0; i < arraySize; i++) {
			if (firstArrayIndex >= src1.size() && secondArrayIndex >= src2.size()) {
				break;
			} else if (firstArrayIndex >= src1.size()) {
				mergedArr.array[i] = src2.array[secondArrayIndex];
				mergedArr.numElements++;
				secondArrayIndex++;
				continue;
			} else if (secondArrayIndex >= src2.size()) {
				mergedArr.array[i] = src1.array[firstArrayIndex];
				mergedArr.numElements++;
				firstArrayIndex++;
				continue;
			}

			if (src1.array[firstArrayIndex] < src2.array[secondArrayIndex]) {
				mergedArr.array[i] = src1.array[firstArrayIndex];
				mergedArr.numElements++;
				firstArrayIndex++;

			} else if (src2.array[secondArrayIndex] < src1.array[firstArrayIndex]) {
				mergedArr.array[i] = src2.array[secondArrayIndex];
				mergedArr.numElements++;
				secondArrayIndex++;
				// src1[i] = src1[i-1];
			} else if (src1.array[firstArrayIndex] == src2.array[secondArrayIndex]) {
				mergedArr.array[i] = src1.array[firstArrayIndex];
				mergedArr.numElements++;
				firstArrayIndex++;
			}
		}

		mergedArr.display();
		return mergedArr;

	}

}
