package edu.grinnell.csc207;


// Sheilla Muligande
// Course: CSC207-01
// Instructor: Sam Rebelsky
// Date:9/14/2024
// File: Cipher.java

package edu.grinnell.csc207.main;
import edu.grinnell.csc207.util.BFCalculator;
import edu.grinnell.csc207.util.BFRegisterSet;
import edu.grinnell.csc207.util.BigFraction;

//import edu.grinnell.csc207.util.CipherUtils;

/**
* An implementation of the Caesar and Vigenere Ciphers.
*
* @author Sheilla Muligande
*/
public class QuickCalculator {

 public static void main (String[] args){
 BFCalculator newCalculator = new BFCalculator();
 BFRegisterSet newRegister = new BFRegisterSet();

 for (String arg : args){

   String[] splitInput = arg.split(" ");
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
   System.out.printf("%s", result);

 }
 

 }
} // QuickCalculator

