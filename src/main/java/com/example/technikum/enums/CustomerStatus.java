package com.example.technikum.enums;

public enum CustomerStatus {
    INTAKT("Intakt"),
    GEFAEHRDET("Gefaehrded"),
    NOTLEIDEND("Notleidend"),
    AUSGEFALLEN("Ausgefallen");

    public final String label;
    CustomerStatus(String label) {
        this.label = label;
    }

    public static CustomerStatus getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

}
