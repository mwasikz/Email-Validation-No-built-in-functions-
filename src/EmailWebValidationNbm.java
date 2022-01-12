/*
Task: User will be asked to input strings. The program will find out whether the input is a email or a web address. No built in method/regex can be used in this task.

Author: Md. Wasikuzzaman Azad Sajol
ID: 172-021-042
Dept. of CSE
 */

import java.util.Scanner;

public class EmailWebValidationNbm {
    public static void main(String[] args) {
        System.out.println("Enter number of strings: ");
        Scanner scan = new Scanner(System.in);
        int num_of_strings = scan.nextInt();

        String[] output = new String[num_of_strings];

        for(int i=0; i<num_of_strings; i++) {
            System.out.println("Enter Email or Web address: ");
            String input = scan.next();

            if(isEmail(input)) {
                output[i] = "Email";
            }

            else if(isWeb(input)) {
                output[i] = "Web";
            }

            else {
                output[i] = "Invalid Input";
            }
        }

        scan.close();

        for(int i=0; i<num_of_strings; i++) {
            System.out.println(output[i] + ", " + (i+1));
        }
    }

    public static boolean isEmail(String email)
    {

        String[] splits = email.split("@");

        if(splits.length != 2) {
            return false;
        }

        if(splits[0].length() == 0 || splits[1].length() < 3) {
            return false;
        }

        if(!splits[1].contains(".")) {
            return false;
        }

        if(!Character.isLetter(email.charAt(0))) {
            return false;
        }

        for(int ch = 0; ch < email.length(); ch++) {
            if(!Character.isLetter(email.charAt(ch)) && !Character.isDigit(email.charAt(ch)) && email.charAt(ch) != '_' && email.charAt(ch) != '-' && email.charAt(ch) != '.' && email.charAt(ch) != '@') {
                return false;
            }
        }

        if(email.contains("..") || email.contains("-@") || email.contains("@-") || email.contains("@_") || email.contains("_@") || email.contains("@.") || email.contains(".@") || email.contains("-.") || email.contains(".-") || email.contains("_.") || email.contains("._") || email.contains("--") || email.contains("__")) {
            return false;
        }

        if(!Character.isLetter(email.charAt(email.length()-1))) {
            return false;
        }

        return true;
    }


    public static boolean isWeb(String web) {

        String[] splits = web.split("\\.");

        if(splits.length < 3) {
            return false;
        }

        if(!splits[0].equals("www")) {
            return false;
        }

        for(int ch = 0; ch < web.length(); ch++) {
            if(!Character.isLetter(web.charAt(ch)) && !Character.isDigit(web.charAt(ch)) && web.charAt(ch) != '-' && web.charAt(ch) != '.') {
                return false;
            }
        }


        for(int i=0; i<splits.length; i++) {
            boolean letter = false;

            for(int j=0; j<splits[i].length(); j++) {
                if(Character.isLetter(splits[i].charAt(j))) {
                    letter = true;
                    break;
                }
            }

            if(!letter) {
                return false;
            }
        }

        if(web.contains("..") || web.contains("-.") || web.contains(".-") || web.contains("--")) {
            return false;
        }

        if(!Character.isLetter(web.charAt(web.length()-1))) {
            return false;
        }

        return true;

    }

}

