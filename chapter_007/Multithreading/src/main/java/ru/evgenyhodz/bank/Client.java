package ru.evgenyhodz.bank;

import java.time.LocalDateTime;

/**
 * Bank's client.
 *
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 06.05.2017
 */
public class Client {
    /**
     * Hour and minute of visit to bank.
     * Hour and minute of leaving.
     * Congestion - the number of intervals of which this interval is a part,
     * this means that the client was at the bank in the most busy time (that
     * parameter is the degree of congestion).
     */
    private LocalDateTime in, out;
    private int congestion;

    public Client(LocalDateTime in, LocalDateTime out, int congestion) {
        this.in = in;
        this.out = out;
        this.congestion = congestion;
    }

    public int getHourIn() {
        return in.getHour();
    }

    public int getHourOut() {
        return out.getHour();
    }

    public int getMinuteIn() {
        return in.getMinute();
    }

    public int getMinuteOut() {
        return out.getMinute();
    }

    public int getSecondIn() {
        return in.getSecond();
    }

    public int getSecondOut() {
        return out.getSecond();
    }

    public int getCongestion() {
        return congestion;
    }

    public void setCongestion(int congestion) {
        this.congestion = congestion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (congestion != client.congestion) return false;
        if (!in.equals(client.in)) return false;
        return out.equals(client.out);

    }

    @Override
    public int hashCode() {
        int result = in.hashCode();
        result = 31 * result + out.hashCode();
        result = 31 * result + congestion;
        return result;
    }
}
