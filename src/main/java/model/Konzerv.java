package model;

import exceptions.LejartElelmiszerKivetel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class Konzerv extends Elelmiszer {

    private String leiras;
    private String receptFajlNev; // lehet null

    // nélküle
    public Konzerv(String nev, String gyarto, LocalDate lejarat, String leiras) throws LejartElelmiszerKivetel {
        super(nev, gyarto, lejarat);
        this.leiras = leiras;
        this.receptFajlNev = null;
    }

    // vele
    public Konzerv(String nev, String gyarto, LocalDate lejarat, String leiras, String receptFajlNev)
            throws LejartElelmiszerKivetel {
        super(nev, gyarto, lejarat);
        this.leiras = leiras;
        this.receptFajlNev = receptFajlNev;
    }

    public void receptetMutat() {
        // csak létezés ellenőrzés
        if (receptFajlNev != null && Files.exists(Path.of(receptFajlNev))) {

        }
    }
}
