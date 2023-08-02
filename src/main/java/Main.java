import implementations.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


        Queue<Teacher> teacherQueue = new Queue<>();

        // Thêm giáo viên vào hàng đợi
        teacherQueue.offer(new Teacher("Van Thang", 35, "Toan"));
        teacherQueue.offer(new Teacher("Hai Viet", 42, "Sinh Hoc"));

        // In ra số lượng giáo viên đang có trong hàng đợi
        System.out.println("Number of teachers: " + teacherQueue.size());

        // In danh sách giáo viên
        System.out.println("List of Teachers:");
        for (Teacher teacher : teacherQueue) {
            System.out.println(teacher);
        }

        // Kiểm tra giáo viên ở đầu hàng đợi
        if (!teacherQueue.isEmpty()) {
            Teacher firstTeacher = teacherQueue.peek();
            System.out.println("First Teacher: " + firstTeacher);
        } else {
            System.out.println("Queue is empty.");
        }

        // Xóa giáo viên ở đầu hàng đợi
        if (!teacherQueue.isEmpty()) {
            Teacher removedTeacher = teacherQueue.poll();
            System.out.println("Removed Teacher: " + removedTeacher);
        } else {
            System.out.println("Queue is empty.");
        }

        // In danh sách giáo viên sau khi xóa
        System.out.println("Updated List of Teachers:");
        for (Teacher teacher : teacherQueue) {
            System.out.println(teacher);
        }

        // Kiểm tra kích thước của hàng đợi sau khi xóa
        System.out.println("Size of the Queue: " + teacherQueue.size());
    }

}


