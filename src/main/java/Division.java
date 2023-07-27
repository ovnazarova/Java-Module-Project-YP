import java.util.ArrayList;
import java.util.Scanner;

public class Division {
    public static String rur (double sum) {
        if (sum % 10 == 1 && sum % 100 != 11) {
            return "рубль";
        } else if ((sum % 10 == 2 || sum % 10 == 3 || sum % 10 == 4)&&
                sum % 100 != 12 && sum % 100 != 13 && sum % 100 != 14) {
            return "рубля";
        } else {return "рублей";}
    }

    public static void divCheck (int count) {
        int i = 0;
        String name;
        double price;
        double sum = 0;
        ArrayList<Good> arrayOfGoods = new ArrayList<>();
        while (true) {
            i++;
            while(true) {
                try{
                    System.out.printf("Введите наименование товара%d: ", i);
                    Scanner scanner = new Scanner(System.in);
                    name = scanner.next();
                    break;
                } catch(Exception e) {
                    System.out.print("Ошибка ввода. Возможно введены спецсимволы. ");
                }
            }
            while(true) {
                try{
                    System.out.printf("Введите стоимость товара%d: ", i);
                    Scanner scanner = new Scanner(System.in);
                    price = scanner.nextDouble();
                    if (price > 0) {
                        break;
                    } else {System.out.print("Ошибка ввода. Цена не может быть отрицательной или нулевой. ");}
                } catch(Exception e) {
                    System.out.print("Ошибка ввода. Введено не число. ");
                }
            }
            arrayOfGoods.add(new Good(name, price));
            sum += price;
            System.out.print("Товар успешно добавлен в корзину. Желаете продолжить? ");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("завершить")) {break;}
        }
        System.out.println("Итого добавленные товары");
        System.out.println("-".repeat(48));
        System.out.println("|" + " ".repeat(8) + "Наименование товара" +
                " ".repeat(8) +"|" + " Стоимость|");
        System.out.println("|" + "-".repeat(35) + "|" + "-".repeat(10) + "|");
        for (i = 0; i < arrayOfGoods.size(); i++) {
            System.out.println("|" + String.format("%-35s", arrayOfGoods.get(i).name) + "|" +
                    String.format("%-10.2f", arrayOfGoods.get(i).price) + "|");
        }
        System.out.println("-".repeat(48));
        System.out.printf("Итого сумма по счету: %.2f %s\t\n", sum, rur(sum));
        System.out.printf("Количество человек: %d\t\t\n", count);
        System.out.printf("Итого на человека: %.2f %s\t\t\n", sum / count, rur(sum / count));
    }
}

class Good {
    String name;
    double price;

    Good (String name, double price) {
        this.name = name;
        this.price = price;
    }
}