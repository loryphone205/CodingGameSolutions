import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Player batman = new Player();
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        //It's a binary search, so you can't really go wrong:
        //there are two formulas to use:
        //Y0 - (maxY0 - minY0) / 2 for moving towards 0
        //Y0 + (maxY0 - minY0) / 2 for moving towards H
        //the same goes for x
        //I've set minY0 and minX0 to -1 beacuse Testcase 06, "Evasive", wouldn't work with
        //both set to 0, probably because of integer division.
        //int middle could be deleted, but it's just easier to read the code like this

        int minY0 = -1;
        int maxY0 = H;
        int minX0 = -1;
        int maxX0 = W;
        int middle = 0;


        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            switch(bombDir) {

                case "U":
                    maxY0 = Y0;
                    middle = Y0 - (maxY0 - minY0) / 2;
                    Y0 = middle;
                    break;

                case "D":
                    minY0 = Y0;
                    middle = Y0 + (maxY0 - minY0) / 2;
                    Y0 = middle;
                    break;

                case "L":
                    maxX0 = X0;
                    middle = X0 - (maxX0 - minX0) / 2;
                    X0 = middle;
                    break;

                case "R":
                    minX0 = X0;
                    middle = X0 + (maxX0 - minX0) / 2;
                    X0 = middle;
                    break;

                case "UR":
                    minX0 = X0;
                    maxY0 = Y0;
                    middle = X0 + (maxX0 - minX0) / 2;
                    X0 = middle;
                    middle = Y0 - (maxY0 - minY0) / 2;
                    Y0 = middle;
                    break;

                case "DR":
                    minY0 = Y0;
                    minX0 = X0;
                    middle = Y0 + (maxY0 - minY0) / 2;
                    Y0 = middle;
                    middle = X0 + (maxX0 - minX0) / 2;
                    X0 = middle;
                    break;

                case "UL":
                    maxY0 = Y0;
                    maxX0 = X0;
                    middle = Y0 - (maxY0 - minY0) / 2;
                    Y0 = middle;
                    middle = X0 - (maxX0 - minX0) / 2;
                    X0 = middle;
                    break;

                case "DL":
                    minY0 = Y0;
                    maxX0 = X0;
                    middle = Y0 + (maxY0 - minY0) / 2;
                    Y0 = middle;
                    middle = X0 - (maxX0 - minX0) / 2;
                    X0 = middle;
                    break;

                default:
                    System.out.println("");
                    break;
            }


            // the location of the next window Batman should jump to.
            System.out.println(X0 + " " + Y0);
        }
    }
}