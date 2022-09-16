import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

//this class will use a binary search of 20 random numbers contained in an array range[1-100]
//to learn if it contains a number the user entered and will display its position in the array
//Author: Milan Labus
//Date: 8/Nov/2021


 class BinarySearchTest {
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random Rgenerator = new Random();


         int[] intArray = new int[MAX_SIZE];             //creating an array with a fixed size

         for(int i =0;i<MAX_SIZE;i++){
             intArray[i] = Rgenerator.nextInt(100);      //looping 20 times and setting random numbers with bound 100
         }

         //sorting the array
         Arrays.sort(intArray);


         //displaying the array
         System.out.println(Arrays.toString(intArray));


         //getting user input with -1 termination the program
         //after the input it will perform a binary search by calling the method
         int number=0;
         do {
             System.out.println("Please enter a number between 0-100");
             number = in.nextInt();
             System.out.println( binarySearch(intArray, number));
         }
         while(number!=-1 ); {                                       //while the input isn't -1

         }
     }


//this method takes an array and a search key as its parameter
//and performs a Binary search
 private static int binarySearch(int[] data, int searchKey)
 {

     int left = 0;
     int right = data.length - 1;
     while (left <= right) {                     //while loop until left is smaller or equal to right
         int mid = left + (right - left) / 2;      //setting the intial mid point


         if (data[mid] == searchKey)            //checking if the search key is in the middle
             return mid;                        //returning that position


         if (data[mid] < searchKey)             //if the search key is greater its right of the mid
             left = mid + 1;                    //moving the left up to one above the mid because the search key is to the right


         else                                   //if the search key is smaller then its to the left of the mid
             right = mid - 1;                   //moving the right down because we know its not right
     }


     return -1;                                 //finished going through and the element was not present so we reached here

 }

     //the maximum size of the static array
     private static final int MAX_SIZE = 20; 
}
