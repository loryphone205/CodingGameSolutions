import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        String binaryMessage = "";
        String binaryResult = "";

        //I need to convert the message into binary first
        //The idea is to use the method toBinaryString on a casted char, like this:
        //toBinaryString( (int) char to convert );
        for (int i = 0; i < MESSAGE.length(); i++) {
            String temp = Integer.toBinaryString(MESSAGE.charAt(i));

            //this loop checks if temp is actually 7 bits, because:
            //in test case 03, the conversion has two 0 missing at the end of the binary string
            while (temp.length() < 7) {
                temp = "0" + temp;
            }

            //only after we add it to the binaryMessage, which is our converted string
            binaryMessage += temp;

        }

        //this loop is basically the core of the program:
        //we start out index i at 0
        int i = 0;
        //then, we iterate for all the binary digits
        while (i < binaryMessage.length()) {
            //if we find a 0 in position i using the method charAt(i)...
            if(binaryMessage.charAt(i) == '0') {
                //... we add "00 " at our result.
                binaryResult += "00 ";
                //then, we keep iterating until we have 0s and i < binaryMessage.length()
                while (binaryMessage.charAt(i) == '0' && i < binaryMessage.length()) {
                    //we add 0 for every 0 we find, increase i,
                    //and check that we are not over the length of our binaryMessage
                    binaryResult += "0";
                    i++;
                    if (i >= binaryMessage.length())
                        break;
                }
                binaryResult += " ";
                //same thing here, but with 1s
            } else if(binaryMessage.charAt(i) == '1') {
                binaryResult += "0 ";
                while (binaryMessage.charAt(i) == '1' && i < binaryMessage.length()) {
                    binaryResult += "0";
                    i++;
                    if (i >= binaryMessage.length())
                        break;
                }
                binaryResult += " ";
            }
        }

        //removing the starting and ending spaces
        binaryResult = binaryResult.trim();

        //output
        System.out.println(binaryResult);
    }
}