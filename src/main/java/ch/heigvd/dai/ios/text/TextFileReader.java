package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Readable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that reads text files. This implementation reads the file byte per byte. It manages the
 * file reader properly with a try-catch-finally block.
 */
public class TextFileReader implements Readable {

  @Override
  public void read(String filename) {
    //buffer to read a file
    Reader readerBuffer = null;

    try {
      readerBuffer = new FileReader(filename, StandardCharsets.UTF_8);

      int b;
      while ((b = readerBuffer.read()) != -1) {}

    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      if (readerBuffer != null) {
        try {
          readerBuffer.close();
        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
      }
    }
  }
}
