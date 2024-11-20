
public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] inputArray = {12, 13, 0, 1, 6};

		int largest = Integer.MIN_VALUE;
		int secondlargest = Integer.MIN_VALUE;;

		for (int input : inputArray)
		{
		  if (input> largest)
		  {
		  secondlargest = largest;
		  largest = input;
		  }
		  else if (input > secondlargest && input != largest)
		  {
		  
		  secondlargest = input;
		  }
		}

		if (secondlargest ==Integer.MIN_VALUE)
		{
		 System.out.println("this is not 2nd largest number");
		 
		}
		else{
		System.out.println("this is the 2nd largest number="+secondlargest);

		}
	}

}
