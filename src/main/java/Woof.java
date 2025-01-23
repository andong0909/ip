import java.util.Scanner;

public class Woof {
    public static void main(String[] args) {
        // Greeting
        System.out.println("""
                Woof! Woof! I am your paw-sonsal chatbot!
                What can Woof do for you?
                """);

        // Echo
        Scanner sc = new Scanner(System.in);

        while (true) {
            String input = sc.nextLine();

            if (input.equals("bye")) {
                System.out.println("Aww byebye. Don't forget to come back soon");
                break;
            } else {
                System.out.println(input);
            }
        }

        sc.close();
    }
}
