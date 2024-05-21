import java.util.List;
import java.util.Scanner;

public class BookSettings {
    private Library library;

    public BookSettings(Library library) {
        this.library = library;
    }

    public void addBook(Scanner scanner) {
        try {
            System.out.print("Введіть назву: ");
            String title = scanner.nextLine();
            System.out.print("Введіть автора: ");
            String author = scanner.nextLine();
            System.out.print("Введіть рік: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            library.addBook(title, author, year);
            System.out.println("Книгу додано успішно.");
        } catch (DuplicateBookException | InvalidYearException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public void removeBook(Scanner scanner) {
        try {
            System.out.print("Введіть автора: ");
            String author = scanner.nextLine();
            System.out.print("Введіть назву: ");
            String title = scanner.nextLine();

            library.removeBook(author, title);
            System.out.println("Книгу видалено успішно.");
        } catch (BookNotFoundException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public void findBooksByAuthor(Scanner scanner) {
        System.out.print("Введіть автора: ");
        String author = scanner.nextLine();

        List<Book> books = library.findBooksByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("Жодної книги цього автора не знайдено.");
        } else {
            System.out.println("Книги автора " + author + ": " + books);
        }
    }

    public void findBooksByYear(Scanner scanner) {
        System.out.print("Введіть рік: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        List<Book> books = library.findBooksByYear(year);
        if (books.isEmpty()) {
            System.out.println("Жодної книги, виданої у цей рік, не знайдено.");
        } else {
            System.out.println("Книги, видані у " + year + " році: " + books);
        }
    }

    public void listAllBooks() {
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("Бібліотека порожня.");
        } else {
            System.out.println("Усі книги у бібліотеці: " + books);
        }
    }
}
