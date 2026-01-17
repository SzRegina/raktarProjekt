package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Raktar implements Serializable, Iterable<Elelmiszer> {

    private List<Elelmiszer> elelmiszerek = new ArrayList<>();

    public void elelmiszerFelvesz(Elelmiszer e) {
        elelmiszerek.add(e);
    }

    public List<Elelmiszer> getElelmiszerek() {
        return Collections.unmodifiableList(elelmiszerek);
    }

    @Override
    public Iterator<Elelmiszer> iterator() {
        return elelmiszerek.iterator();
    }
}
