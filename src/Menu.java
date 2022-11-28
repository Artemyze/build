import Buildings.Building;

import java.util.Arrays;
import java.util.function.Function;

public class Menu {


    public enum MenuItems{
        ADD_NEW_ELEMENT("Добавить новый элемент"),
        DELETE_ELEMENT("Удалить элемент"),
        PRINT_ALL_ELEMENTS("Вывести на экран все элементы"),
        EQUALS("Сравнить два элемента"),
        EXIT("Выйти");
        private final String description;

        MenuItems(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    };

    public Menu() {}

    public static void execute() {
        printMenu();
    }

    private static void printMenu() {
        int i = 0;

    }
}
