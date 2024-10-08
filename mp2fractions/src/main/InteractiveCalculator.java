package edu.grinnell.csc207;


// Sheilla Muligande
// Course: CSC207-01
// Instructor: Sam Rebelsky
// Date:9/14/2024
// File: Cipher.java

package edu.grinnell.csc207.main;

import java.io.PrintWriter;

import java.util.Scanner;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;

// import edu.grinnell.csc207.util.CipherUtils;


/**
* An implementation of an interactive Calculator.
*
* @author Sheilla Muligande
*/

public class InteractiveCalculator {
 public static void main(String[] args) {
   PrintWriter pen = new PrintWriter(System.out, true);
   Scanner eyes = new Scanner(System.in);
   BFCalculator newCalculator = new BFCalculator();
   BFRegisterSet newRegister = new BFRegisterSet();
   pen.print("Enter an expression to evaluate, STORE, or QUIT:");


   for (;;) {
     pen.flush();
     String input = eyes.nextLine();
     if (input.equals("QUIT")) {
       break;
     } // if

     if (input.startsWith("STORE ")) {
       String[] splitInput = input.split(" ");
       char register = 0;

       for (int i = 1; i < splitInput.length; i++) {
         if (splitInput[i].length() == 1) {
           register = splitInput[i].charAt(0);
           break;
         } // if
       } // for

       if (register != 0) {
         newRegister.store(register, newCalculator.get());
       }

       else {
         pen.printf("Error: invalid register.");
       }
       continue;
     }

     String[] splitInput = input.split(" ");
     BigFraction result = new BigFraction(0, 1);
     String function = null;

     for (String inputPiece : splitInput) {
       if (inputPiece.equals("+") || inputPiece.equals("-") || inputPiece.equals("/")
           || inputPiece.equals("*")) {
         function = inputPiece;
       } // if

       else {
         BigFraction val;
         if (Character.isLetter(inputPiece.charAt(0))) {
           val = newRegister.get(inputPiece.charAt(0));
         } // if

         else {
           val = new BigFraction(inputPiece);
         }
         if (function == null) {
           result = val;
         } // if
         else if (function.equals("+")) {
           result = result.add(val);
         } else if (function.equals("*")) {
           result = result.product(val);
         } else if (function.equals("-")) {
           result = result.subtract(val);
         } else if (function.equals("/")) {
           result = result.divide(val);
         }



       }

     }

     newCalculator.add(result);
     pen.printf("%s", result);

   }
   



 } // main(String[])

} // class Interact

