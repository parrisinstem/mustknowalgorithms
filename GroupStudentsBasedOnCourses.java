import java.util.*;

public class GroupStudentsBasedOnCourses {
    public static void main(String[] args) {
        // Sample input
        Map<String, List<String>> studentCourses = new HashMap<>();
        studentCourses.put("Student A", Arrays.asList("Math", "Science"));
        studentCourses.put("Student B", Arrays.asList("Science", "History"));
        studentCourses.put("Student C", Arrays.asList("Math", "History"));
        studentCourses.put("Student D", Arrays.asList("English"));

        // Group students based on shared courses using nested lambda expressions
        List<List<String>> groupedStudents = new ArrayList<>();

        studentCourses.forEach((student1, courses1) -> {
            // Check if the student is already grouped with others
            boolean isGrouped = groupedStudents.stream().anyMatch(group -> group.contains(student1));

            // If not grouped, find students sharing courses with this student
            if (!isGrouped) {
                List<String> group = new ArrayList<>();
                group.add(student1);

                studentCourses.forEach((student2, courses2) -> {
                    if (!student1.equals(student2) && courses1.stream().anyMatch(courses2::contains)) {
                        group.add(student2);
                    }
                });

                groupedStudents.add(group);
            }
        });

        // Output the result
        int groupNumber = 1;
        for (List<String> group : groupedStudents) {
            System.out.println("Group " + groupNumber + ": " + group);
            groupNumber++;
        }
    }
}
