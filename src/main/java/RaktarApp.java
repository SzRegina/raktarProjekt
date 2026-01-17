
import exceptions.LejartElelmiszerKivetel;
import model.Elelmiszer;
import model.Konzerv;
import model.Raktar;

import java.io.*;
import java.time.LocalDate;

public class RaktarApp {

    public static void main(String[] args) {

        // Konzerv Raktár
        Raktar raktar = new Raktar();

        try {
            raktar.elelmiszerFelvesz(new Konzerv(
                    "Bab konzerv",
                    "Bonduelle",
                    LocalDate.now().plusDays(10),
                    "Paradicsom + bab"
            ));

            raktar.elelmiszerFelvesz(new Konzerv(
                    "Kukorica konzerv",
                    "Globus",
                    LocalDate.now().plusDays(30),
                    "Csemegekukorica",
                    "recept.txt"
            ));
            raktar.elelmiszerFelvesz(new Konzerv(
                    "Sült bab paradicsommártásban",
                    "Marks & Spencer",
                    LocalDate.now().plusDays(13),
                    "Kifli.hu-ról lopva"
            ));
            raktar.elelmiszerFelvesz(new Konzerv(
                    "Zöldséges lencseragu",
                    "PolczFood",
                    LocalDate.now().plusDays(8),
                    "polczfood.hu-ról",
                    "recept2.txt"

            ));
            raktar.elelmiszerFelvesz(new Konzerv(
                    "Marhapörkölt tarhonyával",
                    "Házias ízek",
                    LocalDate.now().plusDays(2),
                    "Ivóvíz, 22% pácolt marhahús és marha- szív keveréke (41,5 marhahús, 41,5 marha- szív, ivóvíz, étkezési só, stabilizátorok: trifoszfátok, difoszfátok, sűrítőanyag: E 407a), 10% tarhonya [durumdara (glutén), víz], Natúr lecsó (ivóvíz, étkezési paprika, sűrített paradicsom, cukor, étkezési só), Napraforgó étolaj, Sűrített paradicsom, Fűszerek, Étkezési só, Vöröshagyma dara, Ételízesítő, Csípős őrölt paprika\n" +
                            "A termék szóját is feldolgozó üzemben készült."
            ));
            raktar.elelmiszerFelvesz(new Konzerv(
                    "Valamilyen konzerv megint",
                    "miért kínai",
                    LocalDate.now().plusDays(8),
                    "utf-8 helló????"
            ));



        } catch (LejartElelmiszerKivetel e) {

            System.out.println(e.getMessage());
        }
        //be
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("raktar.bin"))) {

            oos.writeObject(raktar);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //vissza
        Raktar betoltottRaktar = null;


        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("raktar.bin"))) {

            betoltottRaktar = (Raktar) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        //bjútiful
        if (betoltottRaktar != null) {
            for (Elelmiszer e : betoltottRaktar) {
                System.out.println(e.getNev() + " - " + e.getGyarto() + " - " + e.getLejarat());
            }
        }
}}
