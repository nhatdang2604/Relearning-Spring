package org.example.concert;

public class DefaultEncoreable implements Encoreable{

    @Override
    public void performEncore() {
        System.out.println("DefaultEncoreable is performing");
    }
}
