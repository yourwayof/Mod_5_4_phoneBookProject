import java.util.*;

public class Main {

    private static TreeMap <String, String> phoneBook = new TreeMap<>();

    private static TreeMap <String, String> checkNumber(String string)
    {
        if (phoneBook.containsKey(string)){
            System.out.println("Контакт по номеру найден!");
            System.out.println("Имя: " + phoneBook.get(string) + " => Телефонный номер: " + string);
        }
        else {
            System.out.println("Контакт по номеру не найден. Будет создан новый контакт. Введите имя:");
            //String contactName = scanner.nextLine().replaceAll("[^0-9]","");
            String contactName = scanner.nextLine().trim();
            phoneBook.put(string, contactName);
        }
        return phoneBook;
    }

    private static TreeMap <String, String> checkName(String string)
    {
        if (phoneBook.containsValue(string)){
            System.out.println("Контакт по имени найден!");
            for (Map.Entry<String, String> e : phoneBook.entrySet()) {
            String key = e.getValue();
            String value = e.getKey();
            if (key.equals(string)){
            System.out.println("Телефонный номер: " + key + " => Имя: " + value);}
            }
        }
        else
        {
            System.out.println("Контакт по имени не найден! Будет создан новый контакт. Введите номер телефона.");
            String contactNumber = scanner.nextLine().trim().replaceAll("[^0-9]", "");
            phoneBook.put(contactNumber, string);
        }
        return phoneBook;
    }

    private static void printPhoneBook (TreeMap<String, String> map){
        ArrayList contactList = new ArrayList();

        for (Map.Entry<String, String> e : map.entrySet()){
                contactList.add("Контакт: " + e.getValue() + " => Номер: " + e.getKey());
            }
        Collections.sort(contactList);
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println(contactList.get(i));
        }
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        final String REGEX_NAME = "\\D+";
        final String REGEX_NUMBER = "[0-9]+";
        final String REGEX_PLUS_NUMBER = "\\A[+][0-9]+";
        final String REGEX_LIST = "LIST$";

        System.out.println("ДЗ 5.4.");
        System.out.println("Написать программу, которая будет работать как телефонная книга: если пишем новое имя, просит ввести номер телефона и запоминает его, если новый номер телефона — просит ввести имя и тоже запоминает. \nЕсли вводим существующее имя или номер телефона, программа должна выводить всю информацию о контакте. При вводе команды LIST программа должна печатать в консоль список всех абонентов в алфавитном порядке с номерами. ");
        System.out.println("Для начала работы со списком телефонов введите Имя или номер телефона. Для выхода введите команду STOP:");

        Scanner scanner = new Scanner(System.in);
        while (true){
            String inputLine = scanner.nextLine().trim();
            if (inputLine.equals("STOP")){
                break;
            }
            else if (inputLine.matches(REGEX_LIST)){
                printPhoneBook(phoneBook);
                System.out.println("Введите Имя или номер телефона. Для вывода списка введите LIST. Для выхода введите команду STOP:");
            }
            else if (inputLine.matches(REGEX_NUMBER)){
                checkNumber(inputLine);
                System.out.println("Введите Имя или номер телефона. Для вывода списка введите LIST. Для выхода введите команду STOP:");
            }
            else if (inputLine.matches(REGEX_NAME)){
                checkName(inputLine);
                System.out.println("Введите Имя или номер телефона. Для вывода списка введите LIST. Для выхода введите команду STOP:");
            }
            else {
                    System.out.println("Ошибка введения команды. Введите имя контакта, номер телефона или команду  LIST. Для выхода введите команду STOP.");
            }
        }
    }
}
