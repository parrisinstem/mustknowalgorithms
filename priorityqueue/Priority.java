import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Priority {
    private PriorityQueue<Student> queue;

    public Priority() {
        // Initialize a priority queue using the custom student comparator
        queue = new PriorityQueue<>(new Student.StudentComparator());
    }

    // Method to add a new student to the priority queue
    public void listStudent(int id, String name, double cpga) {
        Student student = new Student(id, name, cpga);
        queue.add(student);
    }

    // Method to get a list of student IDs from the priority queue
    public List<Integer> getStudents() {
        List<Integer> studentsIds = new ArrayList<>();
        for (Student student : queue) {
            studentsIds.add(student.getId());
        }
        return studentsIds;
    }

    // Method to process a list of string events and return the list of student IDs after processing
    public List<Integer> listStringEvents(String[] events) {
        List<Integer> studentsIds = new ArrayList<>();
        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("enter")) {
                // If the event is an "enter" event, extract the student's details and add the student to the queue
                int id = Integer.parseInt(parts[1]);
                String name = parts[2];
                double cpga = Double.parseDouble(parts[3]);
                listStudent(id, name, cpga);
            } else if (parts[0].equals("served")) {
                // If the event is a "served" event, remove the highest priority (top) student from the queue
                queue.poll();
            }
        }
        // Get the list of student IDs from the queue after processing all events
        return getStudents();
    }

    public static void main(String[] args) {
        // Create a Priority object
        Priority priority = new Priority();

        // Define a list of string events
        String[] events = {
            "enter 1 Mickey 4.00",
            "enter 2 Tom 3.85",
            "enter 3 Jerry 4.00",
            "served",
            "served",
            "enter 4 John 3.65",
            "enter 5 Joe 3.85",
            "served"
        };

        // Process the events and get the list of student IDs
        List<Integer> result = priority.listStringEvents(events);

        // Print the result (list of student IDs) to the console
        System.out.println(result); // Output: [2, 4]
    }
}
