package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    //Лист, где хранятся лошади
    private List<Horse> horses;

    //Конструктор, принимает на вход готовый лист с лошадьми
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Тайна Грейс", 3d, 0d));
        horses.add(new Horse("Плотва", 3d, 0d));
        horses.add(new Horse("Буцефал", 3d, 0d));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }

    /*
    Сам забег. Длится "100 раз". Т.е. 100 раз двинуть лощадей вперед (изменить дистанию)
    и нарисовать изменения - вывести новую строку с обновленным кол-вом точек, которые
    отражают пройденную дистанци. После: ждать 300мс для адекватного вывода.
    */
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(300);
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        /*for (int i = 0; i < 10; i++) {
            System.out.println();
        }*/
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    /*
    Метод перебором сравнивает пройденную дистанцию всех лошадей и
    возвращает лошадь-победителя с самой большой пройденной дистанцией
    */
    public Horse getWinner() {
        Horse winner = null;
        for (Horse horse : horses) {
            if (winner == null) winner = horse;
            if (winner.getDistance() < horse.getDistance()) winner = horse;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
