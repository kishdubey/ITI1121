public class Q3_ArrayInsertionDemo{

	public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert)
	{
		int newArray[] = new int[beforeArray.length+1];
		int index = 0;
		for(int i=0; i<beforeArray.length; i++, index++)
		{
			if(i==indexToInsert)
			{
				index++;
			}
			newArray[index] = beforeArray[i];
		}
		newArray[indexToInsert] = valueToInsert;
		System.out.println("Array after insertion of "+valueToInsert+" at position "+indexToInsert+": ");
		return newArray;
	}

	public static void main(String[] args)
	{
		int bA[] = {1,5,4,7,9,6};
		System.out.println("Array before insertion:");
		for(int i=0; i<bA.length; i++)
		{
			System.out.println(bA[i]);
		}

		int a[] = new int[bA.length+1];
	
		a = insertIntoArray(bA, 3, 15);

		for(int j=0; j<a.length; j++)
		{
			System.out.println(a[j]);
		}
	}
}