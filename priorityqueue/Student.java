import java.util.Comparator;

public class Student {
    private int id;
    private String name;
    private double cpga;

    public Student(int id, String name, double cpga) {
        this.id = id;
        this.name = name;
        this.cpga = cpga;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCpga() {
        return cpga;
    }

    // Custom comparator as a separate class that extends Comparator
    public static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            int cpgaComparison = Double.compare(student2.getCpga(), student1.getCpga());
            if (cpgaComparison != 0) {
                return cpgaComparison;
            }

            int nameComparison = student1.getName().compareTo(student2.getName());
            if (nameComparison != 0) {
                return nameComparison;
            }

            return Integer.compare(student1.getId(), student2.getId());
        }
    }
}
