import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Assignment 4 Part 1: Static Code Analysis <br />
 * The buggy {@code CodingHorror} source code
 */
public class CodingHorror {

    public static void main(String args[]) {
        // TODO: Assignment 4 Part 1 -- run FindBugs on the code

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = "";
        try {
            input = br.readLine();                  // e.g., peel
        } catch (IOException ioex) {
            System.err.println(ioex.getMessage());
        }
        if(!"".equals(input))
        input=input.replace('e', 'o');
        if ("".equals(input)||input.equals("pool"))  {
            System.out.println("User entered peel.");
        } else {
            System.out.println("User entered something else.");
        }
    }
}


/**Bug 1 : Method ignores return value 
Cause:     This is happening because return value of replace (char,char) is ignored in main method.
           Here the .replace() function will return the new value which is being ignored.
Solution:  It can be resolved  
           input = input.replace('e', 'o');



Bug 2 :    Possible Null pointer dereference in method on exception path
Cause:     Here reference value of input (i-e String input=null;) which is null is dereference in try and catch block. This may lead to a NullPointerException.
Solution:  Changing it to 
           String input="";



Bug 3:     Comparison of String objects using == or !=
Cause:     On if (input == "pool") we are using == operator for reference equality this is coming as bug because both strings are neither constant in a source file 
           nor interned using the String.intern() method.
Solution:  It can be resolved by using equals(Object) method i-e
           if ("".equals(input)||input.equals("pool")) 



Bug 4 :    Dereference of the result of readLine() without nullcheck  
Cause:     Because readLine() can return null when there are no more lines of text to read, so we will put the null check and when readline() is not null then move forward into the program.
Solution:  if(!"".equals(input)) before input=input.replace('e', 'o');
*/