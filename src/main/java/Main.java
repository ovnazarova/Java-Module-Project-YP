import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("На скольких человек разделить счёт? ");
        int count;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                count = scanner.nextInt();
                if (count > 1) {
                    break;
                } else if (count == 1) {
                    System.out.print("Ошибка. Выполнение не имеет смысла. Введите корректное количество человек: ");
                } else {
                    System.out.print("Ошибка. Некорректное значение для просчета. Введите корректное количество человек: ");
                }
            } catch (Exception e) {
                System.out.print("Ошибка. Количество человек должно быть целым числом. Введите корректное количество человек: ");
            }
        }
        Division.divCheck(count);
    }
}
