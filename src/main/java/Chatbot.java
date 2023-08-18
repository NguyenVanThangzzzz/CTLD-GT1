import implementations.Queue;
import implementations.Stack;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Chatbot {
    private Queue<String> messageQueue = new Queue<>();
    private Stack<String> messageStack = new Stack<>();

    public static void main(String[] args) throws IOException {


        Chatbot chatbot = new Chatbot();
        chatbot.Menu();

    }

    public void Menu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            try {
                System.out.println("1. Send Message");
                System.out.println("2. Display queue");
                System.out.println("3. Process Stack");
                System.out.println("4. Display Stack");
                System.out.println("5. Remove Latest Message");
                System.out.println("6. Exit");
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        String message = inputMessage();
                        sendMessage(message);
                        break;
                    case 2:
                        displayQueue();
                        break;
                    case 3:
                        processStack();
                        break;
                    case 4:
                        displayStack();
                        break;
                    case 5:
                        removeLatestMessage();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }


    public String inputMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Message: ");
        String text = scanner.nextLine();
        return text;
    }

    public void sendMessage(String message) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (message.trim().isEmpty()) {
                System.out.println("Invalid input: Message is empty. Please enter a valid message.");
            } else if (message.length() > 255) {
                System.out.println("Invalid input: Message length exceeds 255 characters. Please enter a shorter message.");
            } else {
                String[] result = message.split("\\.");
                for (String part : result) {
                    if (part.trim().length() > 0) {
                        messageQueue.offer(part);
                    }
                }
                System.out.println("Messages added to the queue.");
                return; // Thoát khỏi phương thức khi không có lỗi
            }

            System.out.print("Input Message: ");
            message = scanner.nextLine();
        }
    }

    public void displayQueue() {
        try {
            System.out.println("Display Queue: ");
            System.out.println(messageQueue);
        } catch (NullPointerException e) {
            System.out.println("Queue is empty. No message to display.");
        }
    }

    public void processStack() {
        if (messageQueue.isEmpty()) {
            System.out.println("Message queue is empty. Please send messages to the queue first.");
            return;
        }

        long startProcessingTime = System.currentTimeMillis();

        while (!messageQueue.isEmpty()) {
            String message = messageQueue.poll();
            messageStack.push(message);

            try {
                Thread.sleep(100); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endProcessingTime = System.currentTimeMillis();
        long processingTime = endProcessingTime - startProcessingTime;
        System.out.println("Messages processed and moved to the stack.");
        System.out.printf("Processing Time: %d ms%n", processingTime);
    }





    public void displayStack() {
        try {
            System.out.println("Display Stack: ");
            System.out.println(messageStack);
        } catch (NullPointerException e) {
            System.out.println("Stack is empty. No message to display.");
        }
    }

    public void removeLatestMessage() {
        if (!messageStack.isEmpty()) {
            String removedMessage = messageStack.pop();
            System.out.println("Removed latest message: " + removedMessage + " from the stack.");
        } else {
            System.out.println("Stack is empty. No message to remove.");
        }
    }
}
