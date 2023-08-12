package implementations;
import java.util.Scanner;
public class Message {
    Queue2<String> MessageQueue = new Queue2<>();
    Stack2<String> MessageStack = new Stack2<>();
    public String inputMess(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Message: ");
        String text = scanner.nextLine();
        return text;
    }
    public String sendMess(String a) throws IllegalArgumentException {
        String[] result = a.split("\\.");
        for (int i = 0; i < result.length; i++) {
            if (result[i].length() > 255 || result[i].length() == 0) {
                throw new IllegalArgumentException("Invalid input");
            } else {
                MessageQueue.offer(result[i]);
            }
        }
        System.out.println("The masdasd " + result.length + " gi gi do");
        return "";
    }
    public String stackProcess(){
        String dest;
        while(!MessageQueue.isEmpty()){
            dest = MessageQueue.peek();
            MessageStack.push(dest);
            MessageQueue.poll();
        }
        return " ";
    }

    public String messageStack(){
        System.out.println("The received ma");
        while (!MessageStack.isEmpty()){
            System.out.println(MessageStack.pop()+ " " + " ");
        }
        return " ";
    }

}
