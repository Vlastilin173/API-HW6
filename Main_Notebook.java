import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Main_Notebook {
    private static NB filtrNotebook = new NB(null, 0, 0, "null", "null");

    public static void main(String[] args) {
        NB notebook1 = new NB("Dexp", 4, 1000, "Windows 10", "black");
        NB notebook2 = new NB("Acer Aspire E1", 8, 50000, "Windows 8.1", "Silver");
        NB notebook3 = new NB("MSI Titan 18 HX", 192, 120000, "Windows 11", "Blue");
        NB notebook4 = new NB("Thunderobot 911", 16, 500000, "no OS", "Grey");
        NB notebook5 = new NB("MacBook Pro", 16, 320000, "Mac OS", "White");
        NB notebook6 = new NB("Huawei 16S", 32, 250000, "Windows 11", "black");
        NB notebook7 = new NB("Asus", 32, 8000, "Windows 10", "red");

        Set<NB> notebooks = new HashSet<>(
                Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5, notebook6, notebook7));

        filter(notebooks);
    }

    public static void filter(Set<NB> notebooks) {
        information();
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        boolean endOfFiltr = true;
        while (endOfFiltr == true) {
            switch (command) {
                case ("1"):
                    System.out.println(
                            "Введите примерный объем Оперативной памяти");
                    int findRamInGB = Integer.valueOf(sc.nextLine());
                    filtrNotebook.setRamInGB(findRamInGB);
                    System.out.println(filtrNotebook);
                    System.out.println("Выберите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("2"):
                    System.out.println(
                            "Введите примерный объем HDD");
                    int findValueHDD = Integer.valueOf(sc.nextLine());
                    filtrNotebook.setValueHDD(findValueHDD);
                    System.out.println(filtrNotebook);
                    System.out.println("Выберите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("3"):
                    System.out.println("Введите наименование ОС");
                    String findOperatingSystem = sc.nextLine();
                    filtrNotebook.setOperatingSystem(findOperatingSystem);
                    System.out.println(filtrNotebook);
                    System.out.println("Выберите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("4"):
                    System.out.println("Введите цвет");
                    String findColor = sc.nextLine();
                    filtrNotebook.setColor(findColor);
                    System.out.println(filtrNotebook);
                    System.out.println("Выберите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("5"):
                    printAllNotebook(notebooks);
                    System.out.println("Выберите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("0"):
                    endOfFiltr = false;
                    break;
                default:
                    System.out.println("Вы неверно ввели команду");
                    command = sc.nextLine();
                    break;
            }

        }
        sc.close();
        System.out.println(filtrNotebook);
        findNotebooksWithFiltr(notebooks);
    }

    public static void findNotebooksWithFiltr(Set<NB> notebooks) {

        Set<NB> result = new HashSet<>();
        for (NB note : notebooks) {
            if (filtrNotebook.getRamInGB() <= note.getRamInGB() || filtrNotebook.getRamInGB() == 0) {
                if (filtrNotebook.getValueHDD() <= note.getValueHDD() || filtrNotebook.getValueHDD() == 0) {
                    if (filtrNotebook.getOperatingSystem().equals(note.getOperatingSystem())
                            || filtrNotebook.getOperatingSystem().equals("null")) {
                        if (filtrNotebook.getColor().equals(note.getColor())
                                || filtrNotebook.getColor().equals("null")) {
                            result.add(note);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Вам подойдут следующие ноутбуки:");
            printAllNotebook(result);
        }

        System.out.println("Завершено");
    }

    public static void printAllNotebook(Set<NB> notebooks) {
        System.out.println("В наличии следующие ноутбуки:");
        System.out.println();

        for (NB note : notebooks) {
            System.out.println(note);
        }
        System.out.println();
    }

    public static void information() {
        System.out.println(
                "Выберите цифру для уточнения характеристик:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем HDD");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет ");
        System.out.println("5 - Просмотр всех ноутбуков");
        System.out.println("0 - Результат подбора");
    }
}