package com.company;

import java.util.ArrayList;
import java.util.List;

public class Prefix {
    static final int MULTIPLIER = 31;
    public List<String> pref;

    public Prefix(Prefix p) {
        pref = new ArrayList<>(p.pref);
    }

    public Prefix(int n, String str) {
        pref = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pref.add(str);
        }
    }

    public int hashCode() {
        int h = 0;
        for (String s : pref) {
            h = MULTIPLIER * h + s.hashCode();
        }
        return h;
    }

    public boolean equals(Object o) {
        Prefix p = (Prefix) o;
        for (int i = 0; i < pref.size(); i++) {
            if (!pref.get(i).equals(p.pref.get(i))) {
                return false;
            }
        }
        return true;
    }
}
