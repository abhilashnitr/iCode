package main.FAANG.LLD.Library;

import java.util.Date;
import java.util.List;

//The Catalog class will implement the Search interface to facilitate searching of books.
public interface Search {
    public List<Book> searchByTitle(String title);
    public List<Book> searchByAuthor(String author);
    public List<Book> searchBySubject(String subject);
    public List<Book> searchByPubDate(Date publishDate);
}
