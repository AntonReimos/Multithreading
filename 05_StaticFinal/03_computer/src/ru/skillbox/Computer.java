package ru.skillbox;

public class Computer {
    public final String vendor;
    public final String name;
    public double totalWeight;

    CPU cpu;
    RAM ram;
    PZU pzu;
    Monitor monitor;
    Keyboard keyboard;

    public CPU getCpu() {
        return cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public PZU getPzu() {
        return pzu;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setPzu(PZU pzu) {
        this.pzu = pzu;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Computer(String vendor, String name,
                    CPU ComputerCPU,
                    RAM ComputerRAM,
                    PZU ComputerPZU,
                    Monitor ComputerMonotir,
                    Keyboard ComputerKeyboard) {
        this.vendor = vendor;
        this.name = name;
        this.cpu = ComputerCPU;
        this.ram = ComputerRAM;
        this.pzu = ComputerPZU;
        this.monitor = ComputerMonotir;
        this.keyboard = ComputerKeyboard;
    }

        public double getTotalWeight(){
        return totalWeight = cpu.getCpuWeight() +
                pzu.getPzuWeight() +
                ram.getRamWeight() +
                monitor.getWeight() +
                keyboard.getWeight();
    }

    public String toString(){
        return "Заказ" + "\n" +
                "Vendor: " + vendor + "\n" +
                "Name: " + name + "\n" +
                "CPU: " + cpu + "\n" +
                "RAM: " + ram + "\n" +
                "PZU: " + pzu + "\n" +
                "Monitor: " + monitor + "\n" +
                "Keyboarb: " + keyboard + "\n" +
                "Общий вес: " + totalWeight;
    }


}
