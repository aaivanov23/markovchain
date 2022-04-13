package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.StreamTokenizer;
import java.util.*;

public class Chain {
    static final int NPREF = 2;
    static final String NONWORD = "\n";
    Map<Prefix, List<String>> statetab = new HashMap<>();
    Prefix prefix = new Prefix(NPREF, NONWORD);
    Random random = new Random();

    public void build(InputStream in) throws IOException {
        StreamTokenizer st = new StreamTokenizer(in);

        st.resetSyntax();
        st.wordChars(0, Character.MAX_VALUE);
        st.whitespaceChars(0, ' ');
        while (st.nextToken() != StreamTokenizer.TT_EOF) {
            add(st.sval);
        }
        add(NONWORD);
    }

    public void add(String word) {
        List<String> suf = statetab.get(prefix);
        if (suf == null) {
            suf = new ArrayList<>();
            statetab.put(new Prefix(prefix), suf);
        }
        suf.add(word);
        prefix.pref.remove(0);
        prefix.pref.add(word);
    }

    public void generate(int nwords) {
        prefix = new Prefix(NPREF, NONWORD);
        for (int i = 0; i < nwords; i++) {
            List<String> s = statetab.get(prefix);
            int r = Math.abs(random.nextInt()) % s.size();
            String suf = s.get(r);
            if (suf.equals(NONWORD)) {
                break;
            }
            System.out.print(suf + " ");
            prefix.pref.remove(0);
            prefix.pref.add(suf);
        }
    }

}
