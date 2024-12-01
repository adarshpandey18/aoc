import java.util.*;
import java.io.*;

public class Day1_2 {
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
    for(int i = 0; i < list1.size(); i++) {
      long num = list1.get(i);
      long occurence = getOccurence(list2, num);
      answer += (num * occurence);
    }

    System.out.println(answer);
     
  }

  public static int getOccurence(List<Long> list, long num) {
    int occurence = 0;
    for(int i = 0; i < list.size(); i++) {
      if(list.get(i) == num) {
        occurence++;
      }
    }

    return occurence;
  }
}

