package ch.heigvd.res.lab01.impl.filters;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

/**
 * This class transforms the streams of character sent to the decorated writer.
 * When filter encounters a line separator, it sends it to the decorated writer.
 * It then sends the line number and a tab character, before resuming the write
 * process.
 *
 * Hello\n\World -> 1\Hello\n2\tWorld
 *
 * @author Olivier Liechti
 */
public class FileNumberingFilterWriter extends FilterWriter {

  private static final Logger LOG = Logger.getLogger(FileNumberingFilterWriter.class.getName());
  private  int numberLine;
  boolean firstTime; 
  public FileNumberingFilterWriter(Writer out) {
    super(out);
    numberLine = 1;
    firstTime = true;
  }

  @Override
  public void write(String str, int off, int len) throws IOException {
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");      
      String remainingText = str.substring(off, off+len);
      
      
      String ret = "";
      if(firstTime){
          ret = numberLine+"\t";
          firstTime = false;
      }
      int indexOfBackspace;      
      while(remainingText.contains("\n")){
          numberLine++;
          indexOfBackspace = remainingText.indexOf("\n");
          //add the line with its number to ret          
          ret += (remainingText.substring(0, indexOfBackspace+1) + numberLine+"\t");                
          remainingText = remainingText.substring(indexOfBackspace+1);  
      }
//      if(remainingText.equals("")){
//          ret += (numberLine+1)+"\t";
//      }else{
          ret += remainingText;
//      }
      out.write(ret);
  }

  @Override
  public void write(char[] cbuf, int off, int len) throws IOException {
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

  @Override
  public void write(int c) throws IOException {
    //throw new UnsupportedOperationException("The student has not implemented this method yet.");
  }

}
