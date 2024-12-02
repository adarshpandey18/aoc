import java.util.*;
import java.io.*;

public class Day2_2 {
  public static void main(String[] args) {
    
    try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
      String line;
      int count = 0;

      while ((line = br.readLine()) != null) {
       String[] levels = line.split("\\s+");
        Boolean isIncreasing = null;
        boolean isSafe = checkSequence(levels);

        if(!isSafe) {
          isSafe = checkAfterRemoving(levels);
        }

        if(isSafe) {
          count++;
        }
        
      }
      System.out.println(count);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  private static boolean checkSequence(String[] levels) {
    Boolean isIncreasing = null;
    for(int i = 1; i < levels.length; i++) {
      int first = Integer.parseInt(levels[i-1]);
      int second = Integer.parseInt(levels[i]);
      int diff = second - first;

      if(isIncreasing == null) {
        isIncreasing = diff > 0;
      } 

      if(isIncreasing && (diff > 3 || diff < 1)) {
        return false;
      }

      if(!isIncreasing && (diff > -1 || diff < -3)) {
        return false;
      }
    }

    return true;
  }
  private static boolean checkAfterRemoving(String[] levels) {

    for(int i = 0; i < levels.length; i++) {
      String[] newLevels = new String[levels.length -1];
      int index = 0;
      for(int j = 0 ; j < levels.length; j++) {
        if(i!=j) {
          newLevels[index++] = levels[j];
        }
      }

      if(checkSequence(newLevels)) {
        return true;
      }
    }

    return false;
  }
}
