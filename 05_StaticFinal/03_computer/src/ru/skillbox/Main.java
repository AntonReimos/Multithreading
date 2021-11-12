package ru.skillbox;

import java.security.Key;

public class Main {

    public static void main(String[] args) {
        CPU cpu = new CPU(cpuVendor.AMD, 2.6, 6, 45);
        RAM ram = new RAM(ramType.DDR3, 16, 35);
        PZU pzu = new PZU(pzuType.SSD, 512, 360);
        Monitor monitor = new Monitor(matrixType.IPS, 17.6, 830);
        Keyboard keyboard = new Keyboard(keyboardType.MECHANICAL, keyboardBacklightType.YES, 520);
        Keyboard keyboard1 = new Keyboard(keyboardType.MEMBRANE, keyboardBacklightType.YES, 500);
        Computer computer = new Computer("Asus", "MyComputer",
                cpu,
                ram,
                pzu,
                monitor,
                keyboard);


        System.out.println(computer.getTotalWeight());
        System.out.println(computer.toString());
    }
}
