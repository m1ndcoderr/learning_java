package ru.evgenyhodz.lite.bank;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 22.03.2017
 */
public class Account {

    private double value;
    private Integer requisites;

    public Account(double value, Integer requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public Integer getRequisites() {
        return requisites;
    }

    public double getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) return false;
        return requisites != null ? requisites.equals(account.requisites) : account.requisites == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (requisites != null ? requisites.hashCode() : 0);
        return result;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
