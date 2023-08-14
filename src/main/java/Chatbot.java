import implementations.Queue;
import implementations.Stack;

import java.util.Scanner;

public class Chatbot {
    private Queue<String> messageQueue = new Queue<>();
    private Stack<String> messageStack = new Stack<>();

    public static void main(String[] args) {
        Chatbot chatbot = new Chatbot();
        chatbot.startChat();
    }

    public void startChat() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Send Message");
            System.out.println("2. Display queue");
            System.out.println("3. ProcessStack");
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
        }
    }

    public String inputMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Message: ");
        String text = scanner.nextLine();
        return text;
    }

    public void sendMessage(String message) {
        Scanner scanner = new Scanner(System.in);

        while (message.trim().isEmpty() || message.length() > 255) {
            if (message.trim().isEmpty()) {
                System.out.println("Invalid input: Message is empty. Please enter a valid message.");
            } else {
                System.out.println("Invalid input: Message length exceeds 255 characters. Please enter a shorter message.");
            }

            System.out.print("Input Message: ");
            message = scanner.nextLine();
        }

        String[] result = message.split("\\.");
        for (String part : result) {
            if (part.trim().length() > 0) {
                messageQueue.offer(part);
            }
        }
        System.out.println("Messages added to the queue.");
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
        while (!messageQueue.isEmpty()) {
            String message = messageQueue.poll();
            messageStack.push(message);
        }
        System.out.println("Messages processed and moved to the stack.");
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
