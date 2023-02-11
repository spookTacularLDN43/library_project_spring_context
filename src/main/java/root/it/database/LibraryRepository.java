package root.it.database;

import org.apache.commons.codec.digest.DigestUtils;
import root.it.model.Book;
import root.it.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryRepository {
    private List<Book> bookList = new ArrayList<>();
    private List<User> userList = new ArrayList<>();
    private List<Book> usersBooks = new ArrayList<>();
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
        userList.add(new User("123", DigestUtils.md5Hex("123")));
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

    public boolean checkLoginAvailability(String login) {
        for (User currentUser : userList) {
            if (currentUser.getLogin().equals(login)) {
                return false;
            }
        }
        return true;
    }

    public void addNewUser(String login, String password) {
        this.userList.add(new User(login, DigestUtils.md5Hex(password)));
    }

    public List<Book> showAllBooks() {
        return this.bookList;
    }

    public boolean borrowBook(String title, int pieces) {
        for (Book currentBook : bookList) {
            if (currentBook.getTitle().equalsIgnoreCase(title) && currentBook.getNumberOfPieces() >= pieces) {
                currentBook.setNumberOfPieces(currentBook.getNumberOfPieces() - pieces);
                usersBooks.add(new Book(currentBook.getTitle(), currentBook.getAuthor(), currentBook.getISBN(), pieces, currentBook.getCategory()));
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String title, int pieces) {
        for (Book currentBook : usersBooks) {
            if (currentBook.getTitle().equals(title) && currentBook.getNumberOfPieces() >= pieces) {
                currentBook.setNumberOfPieces(currentBook.getNumberOfPieces() - pieces);
                addPieces(title, pieces);
                if (currentBook.getNumberOfPieces()== 0){
                    usersBooks.remove(currentBook);
                }
                return true;
            }
        }
        return false;
    }

    public void addPieces(String title, int pieces) {
        for (Book currBook : bookList) {
            if (currBook.getTitle().equals(title)) {
                currBook.setNumberOfPieces(currBook.getNumberOfPieces() + pieces);
            }
        }
    }

    public List<Book> showUsersBooks() {
        return this.usersBooks;
    }

    public static LibraryRepository getInstance() {
        return libraryRepository;
    }
}

