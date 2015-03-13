package ch.heigvd.res.lab01.impl;

import java.util.logging.Logger;

/**
 *
 * @author Olivier Liechti
 */
public class Utils {

  private static final Logger LOG = Logger.getLogger(Utils.class.getName());

  /**
   * This method looks for the next new line separators (\r, \n, \r\n) to extract
   * the next line in the string passed in arguments. 
   * 
   * @param lines a string that may contain 0, 1 or more lines
   * @return an array with 2 elements; the first element is the next line with
   * the line separator, the second element is the remaining text. If the argument does not
   * contain any line separator, then the first element is an empty string.
   */
  public static String[] getNextLine(String lines) { //this is so ugly, to refactor !
    String[] result = new String[2];
    int indexOfFirstSeparator = lines.indexOf("\r");
    if(indexOfFirstSeparator == -1){
        indexOfFirstSeparator = lines.indexOf("\n");
        if(indexOfFirstSeparator == -1){ // no separator
            result[0] = "";
            result[1] = lines;
            return result;
        }else{// there is \n           
            result[0] = lines.substring(0,(indexOfFirstSeparator + 1));
            result[1] = lines.substring(indexOfFirstSeparator+1);
            return result;
        }
    }else{ // there is a \r check if \r\n
        if(indexOfFirstSeparator != lines.length()-1){
            if(lines.charAt(indexOfFirstSeparator+1) == '\n'){ // \r\n
                result[0] = lines.substring(0,(indexOfFirstSeparator + +2));
                result[1] = lines.substring(indexOfFirstSeparator+2);
                return result;
            }else{ // only \r
                result[0] = lines.substring(0,(indexOfFirstSeparator + 1));
                result[1] = lines.substring(indexOfFirstSeparator+1);
                return result;
            }
        }else{
            result[0] = lines.substring(0,(indexOfFirstSeparator + 1));
            result[1] = lines.substring(indexOfFirstSeparator+1);
            return result;
        }    
    }
  }
}
