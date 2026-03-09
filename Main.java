import java.util.Scanner;

public class Main {
    private static DoublyLinkedList<Integer> list;
    private static Scanner scanner;

    public static void main(String[] args) {
        list = new DoublyLinkedList<>();
        scanner = new Scanner(System.in);
        int option;
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Selecciona una opción: ");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1: insertAtBeginning(); break;
                    case 2: insertAtEnd(); break;
                    case 3: insertAtPosition(); break;
                    case 4: list.traverseForward(); break;
                    case 5: list.traverseBackward(); break;
                    case 6: showSize(); break;
                    case 7: showIfEmpty(); break;
                    case 8: searchByValue(); break;
                    case 9: searchByIndex(); break;
                    case 10: deleteMenu(); break;
                    case 11: displayArray(); break;
                    case 12: list.clear(); break;
                    case 0: running = false; System.out.println("\n¡Hasta luego!"); break;
                    default: System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error: Debes ingresar un número válido.");
                scanner.nextLine();
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("  LISTA DOBLEMENTE ENLAZADA - MENÚ");
        System.out.println("========================================");
        System.out.println("  1. Insertar al inicio");
        System.out.println("  2. Insertar al final");
        System.out.println("  3. Insertar en posición específica");
        System.out.println("  4. Recorrer hacia adelante");
        System.out.println("  5. Recorrer hacia atrás");
        System.out.println("  6. Mostrar tamaño de la lista");
        System.out.println("  7. Mostrar si la lista está vacía");
        System.out.println("  8. Buscar elemento por valor");
        System.out.println("  9. Buscar elemento por índice");
        System.out.println(" 10. Menú de eliminación");
        System.out.println(" 11. Mostrar lista como array");
        System.out.println(" 12. Limpiar la lista");
        System.out.println("  0. Salir");
        System.out.println("========================================");
    }

    private static void deleteMenu() {
        System.out.println("\n--- MENÚ DE ELIMINACIÓN ---");
        System.out.println("1. Eliminar del inicio");
        System.out.println("2. Eliminar del final");
        System.out.println("3. Eliminar de posición específica");
        System.out.println("4. Eliminar por valor");
        System.out.print("Selecciona una opción: ");
        try {
            int option = scanner.nextInt();
            switch (option) {
                case 1: list.deleteFromBeginning(); break;
                case 2: list.deleteFromEnd(); break;
                case 3: deleteFromPosition(); break;
                case 4: deleteByValue(); break;
                default: System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.nextLine();
        }
    }

    private static void insertAtBeginning() {
        System.out.print("Ingresa el valor a insertar: ");
        try {
            int value = scanner.nextInt();
            list.insertAtBeginning(value);
            System.out.println("✓ Elemento " + value + " insertado al inicio.");
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.nextLine();
        }
    }

    private static void insertAtEnd() {
        System.out.print("Ingresa el valor a insertar: ");
        try {
            int value = scanner.nextInt();
            list.insertAtEnd(value);
            System.out.println("✓ Elemento " + value + " insertado al final.");
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.nextLine();
        }
    }

    private static void insertAtPosition() {
        System.out.print("Ingresa el valor a insertar: ");
        try {
            int value = scanner.nextInt();
            System.out.print("Ingresa la posición (0-" + list.getSize() + "): ");
            int position = scanner.nextInt();
            list.insertAtPosition(value, position);
            System.out.println("✓ Elemento " + value + " insertado en posición " + position + ".");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar valores válidos.");
            scanner.nextLine();
        }
    }

    private static void showSize() {
        System.out.println("Tamaño de la lista: " + list.getSize() + " elemento(s)");
    }

    private static void showIfEmpty() {
        if (list.isEmpty()) {
            System.out.println("✓ La lista está VACÍA.");
        } else {
            System.out.println("✗ La lista NO está vacía. Contiene " + list.getSize() + " elemento(s).");
        }
    }

    private static void searchByValue() {
        System.out.print("Ingresa el valor a buscar: ");
        try {
            int value = scanner.nextInt();
            list.searchByValue(value);
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.nextLine();
        }
    }

    private static void searchByIndex() {
        System.out.print("Ingresa el índice (0-indexado): ");
        try {
            int index = scanner.nextInt();
            list.searchByIndex(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.nextLine();
        }
    }

    private static void deleteFromPosition() {
        System.out.print("Ingresa la posición a eliminar (0-" + (list.getSize() - 1) + "): ");
        try {
            int position = scanner.nextInt();
            list.deleteFromPosition(position);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.nextLine();
        }
    }

    private static void deleteByValue() {
        System.out.print("Ingresa el valor a eliminar: ");
        try {
            int value = scanner.nextInt();
            list.deleteByValue(value);
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número válido.");
            scanner.nextLine();
        }
    }

    private static void displayArray() {
        if (list.isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }
        Object[] array = list.toArray();
        System.out.print("Lista como array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
