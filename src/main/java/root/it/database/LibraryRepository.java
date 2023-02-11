package root.it.database;

import org.apache.commons.codec.digest.DigestUtils;
import root.it.model.Book;
import root.it.model.User;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {
    private List<Book> bookList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private static final LibraryRepository libraryRepository = new LibraryRepository();

    public LibraryRepository() {
        addBooks();
        addDefaultUsers();
    }

    private void addBooks() {
        bookList.add(new Book("The Master and Margarita", "Mikhail Bulgakov", 802130119, 7, Book.Category.NOVEL));
        bookList.add(new Book("Murder on the Orient Express", "Agatha Christie", 586326784, 3, Book.Category.CRIMENOVEL));
        bookList.add(new Book("The Catcher in the Rye", "J. D. Salinger", 673460924, 5, Book.Category.NOVEL));
        bookList.add(new Book("The Shining", "Stephen King", 128563593, 12, Book.Category.CRIMENOVEL));
        bookList.add(new Book("The Godfather", "Mario Puzo", 357234985, 9, Book.Category.CRIMENOVEL));
        bookList.add(new Book("The Snail and the Whale", "Julia Donaldson", 528502561, 3, Book.Category.CHILDREN));
        bookList.add(new Book("The Shadow of the Sun", "Ryszard Kapuściński", 526932750, 6, Book.Category.REPORTAGE));
    }

    private void addDefaultUsers() {
        userList.add(new User("Maja", DigestUtils.md5Hex("abc123")));
    }

    public boolean authenticate(String login, String pass) {
        for (User currentUser : userList) {
            if (currentUser.getLogin().equals(login)) {
                if (currentUser.getPassword().equals(DigestUtils.md5Hex(pass))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkLoginAvailability(){

    }


    public static LibraryRepository getInstance() {
        return libraryRepository;
    }
}
