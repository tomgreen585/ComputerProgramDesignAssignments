// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102/112 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2022T1, Assignment 2
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/**
 * Key:
 * Core:       Method must report whether the key is valid, or
 *             report that it is invalid and give one reason why it is invalid.
 *             To be valid, the key must
 *             - be at least 8 characters and at most 16 characters long,
 *             - not end with the special characters '#' or '$',
 *             - not have a hyphen ('-') character anywhere
 *            
 * Completion: Method should either report that the key is valid, or
 *             report that it is invalid and list ALL the reasons that it is invalid.
 *             To be valid, the key must
 *             - satisfy all of the conditions above AND
 *             - have at least one Upper case character and at least one Lower case character,
 *             - not start with the same character as the first character of the user's name
 *             - contain either a '#' or a '$', but not both.
 * Challenge:  Same as completion, except that to be valid, the key must
 *             - satisfy all of the conditions above AND
 *             - have a mix of numbers and letters
 *             - not contain the user's name spelled backwards, case insensitive.
 *               (eg if name is Peter, it does not contain "ReTEp", or "RETEP" or "retep", or...)
 *
 * Hint.  Look at the documentation in the String class.
 * You will definitely find the length(), endsWith(...), and contains(...) methods to be helpful
 */

public class KeyValidator {

    /**
     * Asks user for key word and then checks if it is a valid key word.
     */
    public void doCore(){
        UI.clearText();
        String key = UI.askString("Key:   ");
        UI.println();
        this.validateKeyCore(key);
    }

    /** CORE
     * Report "Valid" or "Invalid: ...reason...."
     */
    public void validateKeyCore(String key){
        /*# YOUR CODE HERE */
        
        int length = key.length();
        
        if(length>7 && length<17 && !key.endsWith("$") && !key.endsWith("#") && !key.contains("-")) {
                        UI.println("Valid");
} else {
     UI.println("Invalid: Did not reach length requirements(length<8 and lenth>16)");
}
}
     /**
     * Asks user for key word and the name and then checks if it is a valid key word.
     */
    public void doCompletion(){
        UI.clearText();
        String key = UI.askString("Key:   ");
        String name = UI.askString("Your name:   ");
        UI.println();
        this.validateKeyCompletion(key, name);
    }

    /** COMPLETION
     * Report that the key is valid or report ALL the rules that the key failed.
     */
    public void validateKeyCompletion(String key, String name){
        /*# YOUR CODE HERE */
        int characterNumber = key.length();
   boolean hasUppercase;
   boolean hasLowercase;
   hasUppercase = !key.equals(key.toLowerCase());
   hasLowercase = !key.equals(key.toUpperCase());
   String specialChars = "(.*[#$].*)";
   
   if(characterNumber < 8 || characterNumber > 16){
    UI.println("Invalid - Key length can't be smaller than 8 or larger than 16");
   }
   else if (key.endsWith ("#") || (key.endsWith ("$"))){
    UI.println("Invalid - Key cannot end with # or $");
   } 
   else if (key.contains("-")){
    UI.println("Invalid - Key cannot contain -");
   }
   else if(!hasUppercase)
   {
    UI.println("Invalid - Key must have uppercase char");
   }
   else if(!hasLowercase)
   {
    UI.println("Invalid - Key must have lowercase char");
   }
   else if(!key.startsWith(name)){
    UI.println("Invalid - Key cannot contain first letter of name");
   }
   else if(key.indexOf('#') > -1 && key.indexOf('$') > -1){
    UI.println("Invalid -  Key must contain # or $ but not both");
   } 
   else {
    UI.println("Valid");
   }

}

/** 
 * Asks user for key word and the name and then checks if it is a valid key word.
 */
public void doChallenge() {
    UI.clearText();
    String key = UI.askString("Key:   ");
    String name = UI.askString("Your name:   ");
    UI.println();
    this.validateKeyChallenge(key, name);
}

/**Challenge
 * key have mix of numbers and letters
 * not contain user name spelled backwards
 */
public void validateKeyChallenge(String key, String name) {
    int characterNumber = key.length();
   boolean hasUppercase;
   boolean hasLowercase;
   boolean hasNumbers;
   hasUppercase = !key.equals(key.toLowerCase());
   hasLowercase = !key.equals(key.toUpperCase());
   hasNumbers = !key.equals(key.toUpperCase());
   hasNumbers = !key.equals(key.toLowerCase());
   String specialChars = "(.*[#$].*)";
   if (characterNumber < 8 || characterNumber > 16){
    UI.println("INVALID - Key length can't be smaller than 8 or larger than 16");
   }
   else if (key.endsWith ("#") || (key.endsWith ("$"))){
    UI.println("Invalid - Key cannot end with # or $");
   } 
   else if (key.contains("-")){
    UI.println("Invalid - Key cannot contain -");
   }
   else if(!hasUppercase)
   {
    UI.println("Invalid - Key must have uppercase char");
   }
   else if(!hasLowercase)
   {
    UI.println("Invalid - Key must have lowercase char");
   }
   else if(key.startsWith("name")){
    UI.println("Invalid - Key cannot contain first letter of name");
   }
   else if(key.indexOf('#') > -1 && key.indexOf('$') > -1){
    UI.println("Invalid -  Key must contain # or $ but not both");
   } 
   else if(!hasNumbers)
   {
    UI.println("Invalid - Key must have number");
   }
   else {
    UI.println("Valid");
   }  
   }
       
    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Validate Key Core", this::doCore );
        UI.addButton("Validate Key Completion", this::doCompletion );
        UI.addButton("Validate Key Challenge", this::doChallenge );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);       // Expand the text area
    }

    public static void main(String[] args){
        KeyValidator kv = new KeyValidator();
        kv.setupGUI();
    }
}
