package root.it.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
