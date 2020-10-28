package classroom;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public List<Student> students;
    public int capacity;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() < this.capacity) {
            for (Student student1 : this.students) {
                if (student1.getFirstName().equals(student.getFirstName()) && student1.getLastName().equals(student.getLastName())) {
                    return "Student is already in the classroom";
                }
            }
            this.students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
        return "No seats in the classroom";
    }

    public String dismissStudent(Student student) {
        Student studentToRemove=null;
        for (Student student1 : this.students) {
            if (student1.getFirstName().equals(student.getFirstName()) && student.getLastName().equals(student1.getLastName())) {
                studentToRemove=student1;
            }
        }
        if (studentToRemove!=null) {
            this.students.remove(studentToRemove);
            return String.format("Removed student %s %s", studentToRemove.getFirstName(), studentToRemove.getLastName());
        }

        return "Student not found";
    }

    public String getSubjectInfo(String subject) {
        boolean flag=false;
        StringBuilder sb = new StringBuilder();
        sb.append("Subject: " + subject).append(System.lineSeparator());
        sb.append("Students:").append(System.lineSeparator());
        for (Student student : this.students) {
            if (student.getBestSubject().equals(subject)) {
                sb.append(student.getFirstName() + " " + student.getLastName()).append(System.lineSeparator());
                flag=true;
            }
        }
        if (!flag) {
            return "No students enrolled for the subject";
        }
        return sb.toString().trim();
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : this.students) {
            if (student.getFirstName().equals(firstName)&&student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb=new StringBuilder();
        sb.append("Classroom size: "+this.students.size()).append(System.lineSeparator());
        for (Student student : this.students) {
            sb.append("=="+student).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
