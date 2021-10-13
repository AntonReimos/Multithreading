package ru.skillbox;
public class Elevator {

    private static int currentFloor = 1;
    private static int minFloor = 0;
    private static int maxFloor = 0;

    public Elevator(int minFlor, int maxFloor) {
        Elevator.minFloor = minFlor;
        Elevator.maxFloor = maxFloor;

    }

    public static int getCurrentFloor() {
        return currentFloor;
    }

    public static int moveUp(int floor) {
        for (Elevator.getCurrentFloor(); currentFloor < floor; currentFloor++) {
            System.out.println(currentFloor);
        }
        return floor;
    }

    public static int moveDown(int floor) {
        for (Elevator.getCurrentFloor(); currentFloor > floor; currentFloor--) {
            System.out.println(currentFloor);
        }
        return floor;
    }

    public int move(int floor) {
        while (currentFloor >= minFloor && currentFloor <= maxFloor && floor >= minFloor && floor <= maxFloor) {
            int current = floor > getCurrentFloor() ? moveUp(floor) : moveDown(floor);
            return current;
        }
        System.out.println("Введен неверный этаж");
        return floor;
    }

}
