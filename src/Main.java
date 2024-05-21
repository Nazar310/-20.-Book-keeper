import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        BookSettings bookSettings = new BookSettings(library);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Додати книгу");
            System.out.println("2. Видалити книгу");
            System.out.println("3. Знайти книги за автором");
            System.out.println("4. Знайти книги за роком видання");
            System.out.println("5. Показати всі книги");
            System.out.println("6. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookSettings.addBook(scanner);
                    break;

                case 2:
                    bookSettings.removeBook(scanner);
                    break;

                case 3:
                    bookSettings.findBooksByAuthor(scanner);
                    break;

                case 4:
                    bookSettings.findBooksByYear(scanner);
                    break;

                case 5:
                    bookSettings.listAllBooks();
                    break;

                case 6:
                    System.out.println("Вихід...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}
