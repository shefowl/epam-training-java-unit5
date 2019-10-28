package by.epam.money.dao.impl;

import by.epam.money.bean.Account;
import by.epam.money.dao.AccountDAO;
import by.epam.money.dao.AccountReader;
import by.epam.money.dao.DAOException;

import java.io.*;
import java.util.Scanner;

public class FileAccountDAO implements AccountDAO {
    private AccountReader reader;
    private final char space = ' ';

//    public FileAccountDAO() {
//        try {
//            reader = new AccountReader();
//        }catch (IOException e){
//            //throw new DAOException(e);
//        }
//    }

    @Override
    public void createAccount(Account account) throws DAOException {
        try {
            FileWriter fileWriter = new FileWriter("accounts.txt", true);
            String data = account.getId() + " " + account.getBalance() + "\n";
            fileWriter.write(data);
        }
        catch (IOException e){
            throw new DAOException(e);
        }
        finally{
            fileWritter.close();
        }
    }

    @Override
    public Account readAccount(int id) throws DAOException {
        try {
            reader = new AccountReader();
            while (reader.hasNextNote()) {
                String line = reader.readNote();
                if(id == Integer.parseInt(line.substring(0, line.indexOf(space)))){
                    reader.close();
                   return new Account(id, Float.parseFloat(line.substring(line.indexOf(space) + 1)));
                }
            }
            return null;
        }
        catch (IOException e){
            throw new DAOException(e);
        }
        finally{
            reader.close();
            fileWritter.close();
        }
    }

    @Override
    public void updateAccount(Account account) throws DAOException {
        try {
            File temp = File.createTempFile("temp", "");
            FileWriter fileWriter = new FileWriter(temp);
            reader = new AccountReader();
            String line;

            while (reader.hasNextNote()) {
                line = reader.readNote();
                if(account.getId() == Integer.parseInt(line.substring(0, line.indexOf(space)))) {
                    String data = account.getId() + " " + account.getBalance() + "\n";
                    fileWriter.write(data);
                    continue;
                }
                fileWriter.write(line + "\n");
            }

            File oldFile = new File("accounts.txt");
            if (oldFile.delete()) {
                temp.renameTo(oldFile);
            }
        }catch (IOException e){
            throw new DAOException(e);
        }
        finally{
            reader.close();
            fileWritter.close();
        }
    }

    @Override
    public void deleteAccount(int id) throws DAOException {
        try {
            File temp = File.createTempFile("temp", "");
            FileWriter fileWriter = new FileWriter(temp);
            String line;
            reader = new AccountReader();

            while (reader.hasNextNote()) {
                line = reader.readNote();
                if(id == Integer.parseInt(line.substring(0, line.indexOf(space)))) {
                    continue;
                }
                fileWriter.write(line + "\n");
            }

            File oldFile = new File("accounts.txt");
            if (oldFile.delete()) {
                temp.renameTo(oldFile);
            }
        }catch (IOException e){
            throw new DAOException(e);
        }
        finally{
            reader.close();
            fileWritter.close();
        }
    }

    @Override
    public int getLastId() throws DAOException {
        try {
            FileReader fileReader = new FileReader("accounts.txt");
            Scanner scanner = new Scanner(fileReader);
            String line = scanner.nextLine();
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
            }
            int id = Integer.parseInt(line.substring(0, line.indexOf(space)));
            fileReader.close();
            return id;
        }
        catch (IOException e){
            throw new DAOException(e);
        }
    }
}
