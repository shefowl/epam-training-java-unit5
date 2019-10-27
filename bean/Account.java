package by.epam.money.bean;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Account implements Serializable,Comparator<Account>, Comparable<Account> {
    private static final long serialVersionUID = 1L;
    private int id;
    private float balance;

    public Account() {
    }

    public Account(float balance) {
        this.balance = balance;
    }

    public Account(int id, float balance) {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if(o == null){
            return false;
        }

        if(this.getClass() != o.getClass()){
            return false;
        }

        Account account = (Account) o;
        return getId() == account.getId() &&
                Float.compare(account.getBalance(), getBalance()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBalance());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }

    @Override
    public int compareTo(Account o) {
        if(id < o.getId()){
            return -1;
        }
        else if(id == o.getId()){
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public int compare(Account o1, Account o2) {
        float balance1 = o1.getBalance();
        float balance2 = o2.getBalance();
        if(balance1 < balance2){
            return -1;
        }
        else if(balance1 == balance2){
            return 0;
        }
        else{
            return 1;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
