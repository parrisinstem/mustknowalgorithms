package hashmap;

import java.util.HashMap;

public class StudentScores {
    public static String findStudentWithHighestAverage(String[][] studentAverages) {
        // Create a HashMap to store student names as keys and average scores as values.
        HashMap<String, Double> averagesMap = new HashMap<>();
        
        // Keep track of the highest average score.
        double  highestAverage = 0;
        String highestAverageStudent = null;
        
        // Iterate through the array of key-value pairs.
        for (String[] pair : studentAverages) {
            // Extract the student name and average score from the pair.
            String studentName = pair[0];
            double averageScore = Double.parseDouble(pair[1]);
            
            // Calculate the average score as an integer by flooring the decimal value.
            int floorAverage = (int) Math.floor(averageScore);
            
            // Update the HashMap with the student name and its corresponding average score.
            averagesMap.put(studentName, (double) floorAverage);
            
            // Keep track of the student with the highest average score.
            //highestAverage = Math.max(highestAverage, floorAverage);
        
            // Keep track of the student with the highest average score.
            if (averageScore > highestAverage) {
                highestAverage = averageScore;
                highestAverageStudent = studentName;
            }
        }
    
    
        // Return a formatted string with the name of the student with the highest average score and their average.
        return "Student with the highest average score is " + highestAverageStudent +
               " with an average of " + (int) Math.floor(highestAverage);
    }

        
    //     // Return the highest average score.
    //     return highestAverage;
    // }

    

    // Example usage:
    public static void main(String[] args) {
        String[][] studentAverages = {
            {"John", "87.66"},
            {"Alice", "82.33"},
            {"Bob", "86.00"}
        };
        //int initially 
        String highestAverage = findStudentWithHighestAverage(studentAverages);
        System.out.println("Highest average score: " + highestAverage); // Output: 87
    }
}
