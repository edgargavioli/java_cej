package db;

public class DbIntegrityExeption extends RuntimeException{
    private static final long serialVersionUID = 1l;

    public DbIntegrityExeption(String mensage){
        super(mensage);
    }
}
