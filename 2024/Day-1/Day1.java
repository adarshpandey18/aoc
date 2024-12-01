import java.util.*;
import java.io.*;

public class Day1 {
  public static void main(String[] args) {
    List<Long> list1 = new ArrayList<>();
    List<Long> list2 = new ArrayList<>();
    // Using buffer reader to read from "input.txt" line by line
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
      String line;
      while((line = bufferedReader.readLine()) != null) {
        // Splitting the number by whitesapces
        String[] numbers = line.split("\\s+");
        if(numbers.length == 2) {
          list1.add(Long.parseLong(numbers[0]));
          list2.add(Long.parseLong(numbers[1]));
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    Collections.sort(list1);
    Collections.sort(list2);

    long answer = 0;

    for(int i = 0;  i < list1.size(); i++) {
      answer += Math.abs(list1.get(i) - list2.get(i));
    }

    System.out.println(answer);

  }
}
