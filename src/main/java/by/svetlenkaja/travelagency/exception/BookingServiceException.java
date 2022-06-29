package by.svetlenkaja.travelagency.exception;

public class BookingServiceException extends RuntimeException{
    public BookingServiceException() {
        super();
    }

    public BookingServiceException(String message) {
        super(message);
    }
}
