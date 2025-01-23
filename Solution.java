import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class Solution {
// array A has heights, ints.
    // if a student is taller than another, they should go stand in a 'row'
    // check for a non empty array
    // return an INT - the minimum number of rows created
    //For example, given A = [5, 4, 3, 6, 1], the function should return 2. --> creates one row for 5,4,3,1 and another one for 6
    //(bc it is bigger than 5)
    // use a for loop that goes until n-1, n being the length of the array
    // the first student will always create a new row
    // array integer go from 1 - 10k

    static int solution(Integer[] A) {
        int n = A.length;
        int NOR = 0;
        int[] Row = new int[A.length];
        Row[0] = A[0];
        //System.out.println(Arrays.toString(Row)); // this is good
        NOR++;
        // this automatically adds the first element into its own row
        int[] Row2 = new int[A.length];
        for (int i = 0; i < n - 1; i++) {
            // A[1] = 4 > 5 --> no
            // A[2] = 6 > 5 --> yes
            // System.out.println(A[i]); //6
            //System.out.println(A[i+1]);//7
            if (A[i + 1] >= Row[0]) { // is 7 bigger than 5? yes
                //System.out.println(A[i + 1]); //-->7
                // System.out.println(Arrays.toString(Row2)); // row 2 is just 6,0
                if (A[i + 1] > Row2[0] && Row2[0] != 0) { // this is the issue
                    Row2[0] = A[i + 1]; // this adds that element i into a new row
                    //System.out.println(Arrays.toString(Row2) + "YAY");
                    NOR++; // number of rows increases every time this function runs
                }

                do  {
                    if (A[i + 1] > Row2[0]) { // 6 is bigger than 0
                        Row2[0] = A[i+1]; // this adds that element i into a new row
                        //System.out.println(Arrays.toString(Row2) + "NAY");
                        NOR++;
                    }
                } while (Row2[0] == 0);
                /* if (Row2[0] == 0) {
                    Row[i+1] = A[i]; // this is adding to the original array
                    System.out.println(Arrays.toString(Row));
                    // if row2 is 0 then there's nothing there YET, so just add it back to the correct one */




            /*if (A[i+1] >= Row[0] && A[i+1] > Row2[0]) { // checking to see if bigger than the first number
                // if it is bigger than both, then create a new one
                Row2[0] = A[i]; // this adds that element i into a new row
                System.out.println(Arrays.toString(Row2));
                NOR++; // number of rows increases every time this function runs*/


            } else {
                Row[i + 1] = A[i + 1];
            }

        }
        return NOR;
    }

    public static void main(String[] args) {
        // Read from stdin, solve the problem, write answer to stdout.
        Scanner in = new Scanner(System.in);
        Integer[] A = getIntegerArray(in.next());

        System.out.print(solution(A));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}
