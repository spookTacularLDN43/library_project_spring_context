package root.it.database;

import root.it.model.Book;

import java.util.List;

public interface ILibraryRepository {
    boolean authenticate(String login, String pass);
    boolean checkLoginAvailability(String login);
    void addNewUser(String login, String password);
    List<Book> showAllBooks();
    boolean borrowBook(String title, int pieces);
    boolean returnBook(String title, int pieces);
    void addPieces(String title, int pieces);
    List<Book> showUsersBooks();

}
