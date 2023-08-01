package implementations;

public class Student {
    private String name;
    private int age;
    private String studentCode;
    private String phoneNumber;

    // Constructor
    public Student(String name, int age, String studentCode, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.studentCode = studentCode;
        this.phoneNumber = phoneNumber;
    }


    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentCode='" + studentCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

