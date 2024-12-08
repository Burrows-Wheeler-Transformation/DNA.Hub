package com.example.dnahub.Controller;

public class SequenceValidator {
    public boolean validate (String sequence) {
        String seq = sequence.toUpperCase();
        for (int i = 0; i < seq.length(); i++) {
            if(seq.charAt(i) != 'A' && seq.charAt(i) != 'C' && seq.charAt(i) != 'G' && seq.charAt(i) != 'T') {
                return false;
            }
        }
        return true;
    }
}
