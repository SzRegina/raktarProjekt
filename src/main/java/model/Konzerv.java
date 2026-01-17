package model;

import exceptions.LejartElelmiszerKivetel;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class Konzerv extends Elelmiszer {

    private String leiras;
    private String receptFajlNev; // lehet null

    // no recept
    public Konzerv(String nev, String gyarto, LocalDate lejarat, String leiras) throws LejartElelmiszerKivetel {
        super(nev, gyarto, lejarat);
        this.leiras = leiras;
        this.receptFajlNev = null;
    }

    // recepttel
    public Konzerv(String nev, String gyarto, LocalDate lejarat, String leiras, String receptFajlNev)
            throws LejartElelmiszerKivetel {
        super(nev, gyarto, lejarat);
        this.leiras = leiras;
        this.receptFajlNev = receptFajlNev;
    }

    public void receptetMutat() {
        if (receptFajlNev != null && Files.exists(Path.of(receptFajlNev))) {

        }
    }
}
