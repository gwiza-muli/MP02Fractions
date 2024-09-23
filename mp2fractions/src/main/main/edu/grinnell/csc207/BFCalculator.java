// Sheilla Muligande
// Course: CSC207-01
// Instructor: Sam Rebelsky
// Date:9/14/2024
// File: Cipher.java

package edu.grinnell.csc207.util;


/**
* An implementation of a Big Fraction calculator.
*
* @author Sheilla Muligande
*/
public class BFCalculator {

 // +--------+-------------------------------------------------------

 // | Fields |

 // +--------+


 /** The numerator of the fraction. Can be positive, zero or negative. */

 BigFraction lastFraction;


 // +--------------+-------------------------------------------------

 // | Constructors |

 // +--------------+

 /**
  * initializes the first fraction to be 0, that way the other methods
  * start from 0.
  */

 public BFCalculator(){
   this.lastFraction = new BigFraction(0,1);
 }

  // +---------+------------------------------------------------------

 // | Methods |

 // +---------+

 /** 
  * gets the last computed value (returns 0 if there is no such value).
  */

 public BigFraction get() {
   return this.lastFraction;
 } //get

 public void add(BigFraction val){
   this.lastFraction = this.lastFraction.add(val);
 } //add


 public void subtract(BigFraction val){
   this.lastFraction = this.lastFraction.subtract(val);
 } //subtract

 public void multiply(BigFraction val){
   this.lastFraction = this.lastFraction.product(val);
 } //multiply


 public void divide(BigFraction val){
   this.lastFraction = this.lastFraction.divide(val);
 }

 public void clear(){
   this.lastFraction = new BigFraction(0,1);
 } //clear


} // Class BFCalculator

