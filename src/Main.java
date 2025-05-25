import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Добро пожаловать в ToDo приложение!");
        System.out.println("Команды: add, list, remove, exit");

        while (true) {
            System.out.print("\nВведите команду: ");
            command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("add")) {
                System.out.print("Введите задачу: ");
                String task = scanner.nextLine().trim();
                tasks.add(task);
                System.out.println("Задача добавлена.");

            } else if (command.equalsIgnoreCase("list")) {
                if (tasks.isEmpty()) {
                    System.out.println("Список задач пуст.");
                } else {
                    System.out.println("Ваши задачи:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.printf("%d. %s%n", i + 1, tasks.get(i));
                    }
                }

            } else if (command.equalsIgnoreCase("remove")) {
                System.out.print("Введите номер задачи для удаления: ");
                try {
                    int index = Integer.parseInt(scanner.nextLine());
                    if (index > 0 && index <= tasks.size()) {
                        String removed = tasks.remove(index - 1);
                        System.out.println("Удалено: " + removed);
                    } else {
                        System.out.println("Неверный номер.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введите число.");
                }

            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Пока!");
                break;

            } else {
                System.out.println("Неизвестная команда.");
            }
        }

        scanner.close();
    }
}