package exception;

public class DaoException extends Exception{
//kad se desi greska da nam ostavi tacan trag
    public DaoException(String message){
        super("DAO problem: " +message);
    }
}
