import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Question {
    String question;
    ArrayList<String> options;
    int correctOption;

    Question(String question, ArrayList<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

public class QuizApplication {

    static ArrayList<Question> questions = new ArrayList<>();
    static HashMap<Integer, String> results = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadQuestions();

        System.out.println("==============================");
        System.out.println("       JAVA QUIZ APP");
        System.out.println("==============================");
        System.out.print("Enter your name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            name = "Student";
        }

        System.out.println("\nHello " + name + "! The quiz will now begin.");
        System.out.println("There are " + questions.size() + " questions.");
        System.out.println("Each correct answer gives 1 point.");
        System.out.println("------------------------------\n");

        int score = 0;

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.question);

            for (int j = 0; j < q.options.size(); j++) {
                System.out.println("  " + (j + 1) + ". " + q.options.get(j));
            }

            int ans = getInt("Your answer (1-" + q.options.size() + "): ");

            while (ans < 1 || ans > q.options.size()) {
                System.out.println("Please enter a valid option.");
                ans = getInt("Your answer (1-" + q.options.size() + "): ");
            }

            if (ans == q.correctOption) {
                System.out.println("Correct!\n");
                score++;
                results.put(i + 1, "Correct");
            } else {
                System.out.println("Wrong! Correct answer was: " + q.options.get(q.correctOption - 1) + "\n");
                results.put(i + 1, "Wrong");
            }
        }

        showResult(name, score);
        sc.close();
    }

    static void loadQuestions() {
        ArrayList<String> ops1 = new ArrayList<>();
        ops1.add("Python");
        ops1.add("Java");
        ops1.add("C++");
        ops1.add("Ruby");
        questions.add(new Question("Which language is known as 'Write Once Run Anywhere'?", ops1, 2));

        ArrayList<String> ops2 = new ArrayList<>();
        ops2.add("compile()");
        ops2.add("start()");
        ops2.add("main()");
        ops2.add("run()");
        questions.add(new Question("Which method is the entry point of a Java program?", ops2, 3));

        ArrayList<String> ops3 = new ArrayList<>();
        ops3.add("ArrayList");
        ops3.add("LinkedList");
        ops3.add("HashMap");
        ops3.add("Array");
        questions.add(new Question("Which collection stores data as key-value pairs?", ops3, 3));

        ArrayList<String> ops4 = new ArrayList<>();
        ops4.add("int");
        ops4.add("String");
        ops4.add("char");
        ops4.add("boolean");
        questions.add(new Question("Which data type is used to store true or false in Java?", ops4, 4));

        ArrayList<String> ops5 = new ArrayList<>();
        ops5.add("extends");
        ops5.add("implements");
        ops5.add("inherits");
        ops5.add("uses");
        questions.add(new Question("Which keyword is used for inheritance in Java?", ops5, 1));

        ArrayList<String> ops6 = new ArrayList<>();
        ops6.add("for loop");
        ops6.add("while loop");
        ops6.add("do-while loop");
        ops6.add("if-else");
        questions.add(new Question("Which loop always runs at least once?", ops6, 3));

        ArrayList<String> ops7 = new ArrayList<>();
        ops7.add("Encapsulation");
        ops7.add("Abstraction");
        ops7.add("Polymorphism");
        ops7.add("Inheritance");
        questions.add(new Question("Hiding data using private variables is called?", ops7, 1));

        ArrayList<String> ops8 = new ArrayList<>();
        ops8.add("System.out.print()");
        ops8.add("System.out.println()");
        ops8.add("Console.print()");
        ops8.add("print()");
        questions.add(new Question("Which method prints output with a new line in Java?", ops8, 2));

        ArrayList<String> ops9 = new ArrayList<>();
        ops9.add("int[]");
        ops9.add("Array()");
        ops9.add("new Array");
        ops9.add("array[]");
        questions.add(new Question("How do you declare an integer array in Java?", ops9, 1));

        ArrayList<String> ops10 = new ArrayList<>();
        ops10.add("try-catch");
        ops10.add("if-else");
        ops10.add("throw-catch");
        ops10.add("error-handle");
        questions.add(new Question("Which block is used to handle exceptions in Java?", ops10, 1));
    }

    static void showResult(String name, int score) {
        System.out.println("==============================");
        System.out.println("         QUIZ RESULTS");
        System.out.println("==============================");
        System.out.println("Name  : " + name);
        System.out.println("Score : " + score + " / " + questions.size());

        System.out.println("\nQuestion Summary:");
        for (int i = 1; i <= results.size(); i++) {
            System.out.println("Q" + i + ": " + results.get(i));
        }

        System.out.println();

        double percent = ((double) score / questions.size()) * 100;

        if (percent == 100) {
            System.out.println("Grade: A+ -- Perfect score! Outstanding!");
        } else if (percent >= 80) {
            System.out.println("Grade: A -- Great job!");
        } else if (percent >= 70) {
            System.out.println("Grade: B -- Good work!");
        } else if (percent >= 60) {
            System.out.println("Grade: C -- Not bad, keep practicing.");
        } else if (percent >= 50) {
            System.out.println("Grade: D -- You passed but need more practice.");
        } else {
            System.out.println("Grade: F -- Better luck next time. Keep studying!");
        }

        System.out.println("==============================");
    }

    static int getInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
