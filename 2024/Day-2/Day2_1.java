import java.io.BufferedReader;
import java.io.FileReader;

public class Day2_1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            int count = 0;

            while ((line = br.readLine()) != null) {
                String[] levels = line.split("\\s+");
                Boolean isIncreasing = null; // Null means undetermined direction
                boolean isSafe = true;

                for (int i = 1; i < levels.length; i++) {
                    int first = Integer.parseInt(levels[i - 1]);
                    int second = Integer.parseInt(levels[i]);
                    int diff = second - first;

                    // Determine the direction of the sequence
                    if (isIncreasing == null) {
                        isIncreasing = diff > 0; // Set the direction (increasing or decreasing)
                    } 

                    // Check if the sequence follows the rules for increasing
                    if (isIncreasing && (diff < 1 || diff > 3)) {
                        isSafe = false;
                        break; // Break if the difference is out of bounds for increasing
                    }

                    // Check if the sequence follows the rules for decreasing
                    if (!isIncreasing && (diff > -1 || diff < -3)) {
                        isSafe = false;
                        break; // Break if the difference is out of bounds for decreasing
                    }

                    // If the direction changes, it's not safe
                    if (isIncreasing && diff < 0 || !isIncreasing && diff > 0) {
                        isSafe = false;
                        break;
                    }
                }

                // If the sequence is safe, increment the count
                if (isSafe) {
                    count++;
                }
            }

            // Output the count of safe reports
            System.out.println(count);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

