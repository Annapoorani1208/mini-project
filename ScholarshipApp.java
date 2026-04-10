import java.util.*;

class Student {
    int id;
    String name;
    double gpa;
    double income;
    boolean extracurricular;

    Student(int id, String name, double gpa, double income, boolean extracurricular) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.income = income;
        this.extracurricular = extracurricular;
    }
}

class ScholarshipCriteria {
    double minGpa;
    double maxIncome;
    boolean requireExtracurricular;

    ScholarshipCriteria(double minGpa, double maxIncome, boolean requireExtracurricular) {
        this.minGpa = minGpa;
        this.maxIncome = maxIncome;
        this.requireExtracurricular = requireExtracurricular;
    }

    boolean isEligible(Student s) {
        if (s.gpa < minGpa) return false;
        if (s.income > maxIncome) return false;
        if (requireExtracurricular && !s.extracurricular) return false;
        return true;
    }
}

class ScholarshipSystem {
    List<Student> students = new ArrayList<>();
    ScholarshipCriteria criteria;

    ScholarshipSystem(ScholarshipCriteria criteria) {
        this.criteria = criteria;
    }

    void addStudent(Student s) {
        students.add(s);
    }

    List<Student> shortlistStudents() {
        List<Student> eligible = new ArrayList<>();
        for (Student s : students) {
            if (criteria.isEligible(s)) {
                eligible.add(s);
            }
        }
        return eligible;
    }

    void showEligibleStudents() {
        List<Student> eligible = shortlistStudents();
        System.out.println("=== Eligible Students ===");
        for (Student s : eligible) {
            System.out.println(s.id + " - " + s.name + " (GPA: " + s.gpa + ", Income: ₹" + s.income + ")");
        }
    }
}

public class ScholarshipApp {
    public static void main(String[] args) {
        ScholarshipCriteria criteria = new ScholarshipCriteria(7.5, 300000, true);
        ScholarshipSystem system = new ScholarshipSystem(criteria);

        system.addStudent(new Student(101, "ravi", 8.2, 250000, true));
        system.addStudent(new Student(102, "Arun", 7.0, 200000, true));
        system.addStudent(new Student(103, "Meena", 9.0, 400000, false));

        system.showEligibleStudents();
    }
}