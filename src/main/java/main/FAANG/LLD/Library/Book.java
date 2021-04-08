package main.FAANG.LLD.Library;

import java.util.Date;
import java.util.List;

public abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;

}

class BookItem extends Book {
    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private consts.BookFormat format;
    private consts.BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;

    public String getBarcode() {
        return barcode;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(consts.BookStatus status) {
        this.status = status;
    }

    public boolean checkout(String memberId) {
        if(this.isReferenceOnly) {
            System.out.println("This book is Reference only and can't be issued");
            return false;
        }
        if(!BookLending.lendBook(this.getBarcode(), memberId)){
            return false;
        }
        this.setStatus(consts.BookStatus.LOANED);
        return true;
    }
}

