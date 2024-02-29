/**
 * Handles all users input
 *
 * @Author Holden Merkel & Hunter Schoch
 * @Since 2024.02.21
 * @Version 1.0
 */

import java.util.Scanner;

public class Input {
    public static Scanner sc = new Scanner(System.in);

    public static String getLine(String prompt) {
        String userInput;

        while(true) {
            System.out.println(prompt);
            userInput = Input.sc.nextLine().trim();

            if (userInput.isEmpty()) {
                System.out.println("Invalid! Please enter a value.");
            }
            else {
                return userInput;
            }
        }
    }

    public static int getInt(String prompt) {
        int userInput = 0;

        System.out.print(prompt);

        while (true) {
            if (Input.sc.hasNextInt()) // if the data in the buffer is a valid integer
                break;           // then break out of the validation loop

            System.out.printf("Invalid input! Please enter a number: ");
            Input.sc.next();  // clear the data in the input buffer

        } // end of while

        userInput = Input.sc.nextInt();
        Input.sc.nextLine(); // consume newline left-over

        return userInput;

    } // end of getInt

    public static int getIntRange(String prompt, int low, int high) {
        int userInput;

        System.out.print(prompt);

        while (true) {
            if (Input.sc.hasNextInt()) {         // if the data in the buffer is a valid integer
                userInput = Input.sc.nextInt();  // then store the integer in userInput

                // if the userInput is within the valid range
                // then break out of the validation loop
                if (userInput >= low && userInput <= high) {
                    break;
                } // end of if

            } else {
                Input.sc.next();  // clear the data in the input buffer
            } // end of if-else

            System.out.printf("Invalid input! Please enter a number between (%d - %d): ", low, high);

        } // end of while

        Input.sc.nextLine(); // consume newline left-over

        return userInput;

    } // end of getIntRange

} // end of Input class