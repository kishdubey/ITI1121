public class Q3_SquareArray
{	
	public static int[] createArray(int size) 
	{
		int arr[] = new int[size];
		for(int i=0; i<size;i++)
		{
			arr[i]=i*i;
		}

		return arr;
	}

	public static void main(String[] args)
	{
		int arr[] = createArray(13);
		for(int i=0; i<arr.length; i++)
		{
			System.out.println("The square of "+i+ " is: "+arr[i]);
		}
	}
}