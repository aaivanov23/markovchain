package com.company;

import java.io.FileInputStream;
import java.io.IOException;

public class Markov {

    static final int MAXGEN = 1000;
    public static void main(String[] args) throws IOException {
        Chain chain = new Chain();
        int nwords = MAXGEN;
        chain.build(new FileInputStream("/Users/alexei/IdeaProjects/Java/Markov chain/src/com/company/data.txt"));
        chain.generate(nwords);
    }
}