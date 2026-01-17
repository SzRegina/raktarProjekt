package model;

import exceptions.LejartElelmiszerKivetel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public abstract class Elelmiszer implements Serializable, Comparable<Elelmiszer> {

    private String nev;
    private String gyarto;
    private LocalDate lejarat;


    public Elelmiszer(String nev, String gyarto, LocalDate lejarat) throws LejartElelmiszerKivetel {
        if (lejarat == null) {
            lejarat = LocalDate.now().plusYears(1);
        }


        if (!lejarat.isAfter(LocalDate.now())) {
            throw new LejartElelmiszerKivetel();
        }

        this.nev = nev;
        this.gyarto = gyarto;
        this.lejarat = lejarat;
    }

    public Elelmiszer(String nev, String gyarto) throws LejartElelmiszerKivetel {
        this(nev, gyarto, LocalDate.now().plusYears(1));
    }


    @Override
    public int compareTo(Elelmiszer other) {
        return this.nev.compareToIgnoreCase(other.nev);
    }


    public static final Comparator<Elelmiszer> gyartoSzerint =
            (a, b) -> a.gyarto.compareToIgnoreCase(b.gyarto);


    public String getNev() { return nev; }
    public String getGyarto() { return gyarto; }
    public LocalDate getLejarat() { return lejarat; }
}
