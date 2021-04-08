package main.FAANG.LLD.Library;

import java.util.Date;

public class BookReservation {
    private Date creationDate;
    private consts.ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    public void setStatus(consts.ReservationStatus status) {
        this.status = status;
    }

    public static BookReservation fetchReservationDetails(String barcode) {
        return null;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void sendBookAvailableNotification() {
    }
}

