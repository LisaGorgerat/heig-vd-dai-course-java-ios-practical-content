package ch.heigvd.dai.ios.text;

import ch.heigvd.dai.ios.Writable;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A class that writes text files. This implementation write the file byte per byte. It manages the
 * file writer properly with a try-catch-finally block.
 */
public class TextFileWriter implements Writable {

  @Override
  public void write(String filename, int sizeInBytes) {

    // class Writer is a buffer to write in a file
    Writer writeBuffer = null;

    try {
      writeBuffer = new FileWriter(filename, StandardCharsets.UTF_8);
      for (int i = 0; i < sizeInBytes; i++) {
        writeBuffer.write('A');
      }
    } catch (IOException e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      if (writeBuffer != null) {
        try {
          writeBuffer.close();
        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
      }
    }
  }
}
