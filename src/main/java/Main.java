import implementations.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


        ArrayList<Student> studentList = new ArrayList<>();

        // Thêm sinh viên
        studentList.add(new Student("Van Thang", 20, "GCD210184", "111111111"));
        studentList.add(new Student("Hai Viet", 22, "GCD219012", "222222222"));

        // In ra số lượng sinh viên đang có
        System.out.println("Number of students: " + studentList.size());

        // In danh sách học sinh
        System.out.println("List of Students:");
        for (Student student : studentList) {
            System.out.println(student);
        }


        // Xóa một sinh viên khỏi danh sách
        studentList.remove(1);

        // In danh sách sinh viên cập nhật
        System.out.println("Updated List of Students:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

}


