package activities;

	/* Write a program to check if the sum of all the 10's in the array is exactly 30 */

public class Activity2 {

	public static void main(String[] args) {
		//Create an object for the class
		Activity2 actObj = new Activity2();
		
		//Initialize the array
		int[] inputArr = {10, 77, 10, 54, -11, 10};
		//Initialize the search number and expected num
		int searchNum = 10;
		int finalSum = 30;
		
		//Call the calculation function
		System.out.println("Is the Sum equals to 30? : " +actObj.result(inputArr, searchNum, finalSum));
		
	}
	
	public boolean result(int[] nums, int searchNum, int fixedSum)	{
		int tempSum = 0;
		
		for(int num : nums)	{
			if(num == searchNum)	{
				tempSum += searchNum;
			}
			if(tempSum > fixedSum)	{
				break;
			}
		}
		
		return tempSum == fixedSum;
	}

}
