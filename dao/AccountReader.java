package by.epam.money.dao;

import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AccountReader implements Closeable {
    private static final String DATA_FILE_PATH = "data.file.path";
    ResourceBundle bundle;
    private Scanner scanner;

    public AccountReader() throws IOException {
        this.scanner = new Scanner(new FileReader("accounts.txt"));
    }

    public String readNote(){
        return scanner.nextLine();
    }

    public boolean hasNextNote(){
        return scanner.hasNextLine();
    }

    @Override
    public void close() throws IOException {
        scanner.close();
    }
}
