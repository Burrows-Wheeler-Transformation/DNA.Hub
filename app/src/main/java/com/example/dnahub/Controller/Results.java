package com.example.dnahub.Controller;

public class Results {

    String sequence;

    public Results(String seq) {
        this.sequence = seq.toUpperCase();
    }

    public double calculateGC() {
        int g = 0;
        int c = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'C') {
                c++;
            }
            if (sequence.charAt(i) == 'G') {
                g++;
            }
        }
        double res = Math.round((g + c) / sequence.length());
        return res;
    }

    public StringBuilder createComp() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sequence.length(); i++) {
            char current = sequence.charAt(i);
            switch (current) {
                case 'A':
                    res.append('T');
                    break;
                case 'T':
                    res.append('A');
                    break;
                case 'C':
                    res.append('G');
                    break;
                case 'G':
                    res.append('C');
                    break;
                default:
                    System.out.println("Not a valid character... Skipped");
                    break;
            }
        }
        return res;
    }
    public String reversedComp () {
        return createComp().reverse().toString();
    }
}