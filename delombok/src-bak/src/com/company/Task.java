package com.company;

import com.company.Animals.*;
import com.company.Plants.Grass;

import java.util.Map;

public class Task implements Runnable {
    private final int lengthIslandIndex;
    private final int widthIslandIndex;
    ChangeableClass changeableClass = new ChangeableClass();
    FirstAdd firstAdd = new FirstAdd();
    Cell[][] cells = firstAdd.cellMas;
    //    Cell[][] cells = changeableClass.getCellMas();

    public Task(int lengthIslandIndex, int widthIslandIndex) {
        this.lengthIslandIndex = lengthIslandIndex;
        this.widthIslandIndex = widthIslandIndex;
    }

    // Создавая новый поток, мы должны передать туда номер ячейки

    // Здесь у меня будет логика для каждого потока
    @Override
    public void run() {
        // 1. Получаем последние данные от этой ячейки
        Map<String, Integer> currentCellMap = cells[lengthIslandIndex][widthIslandIndex].getCellMap();

        // 2. Поочередно запускаем работу каждого животного. Начиная с Медведя
        // Медведи проснулись
        if (currentCellMap.containsKey("Медведь")) {
            for (int i = 0; i < currentCellMap.get("Медведь"); i++) {
                new Bear().firstBorn(lengthIslandIndex, widthIslandIndex);
            }
        }
        // Волки проснулись
        if (currentCellMap.containsKey("Волк")) {
            for (int i = 0; i < currentCellMap.get("Волк"); i++) {
                new Wolf().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Лисы проснулись
        if (currentCellMap.containsKey("Лиса")) {
            for (int i = 0; i < currentCellMap.get("Лиса"); i++) {
                new Fox().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Орлы проснулись
        if (currentCellMap.containsKey("Орел")) {
            for (int i = 0; i < currentCellMap.get("Орел"); i++) {
                new Eagle().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Змеи проснулись
        if (currentCellMap.containsKey("Змея")) {
            for (int i = 0; i < currentCellMap.get("Змея"); i++) {
                new Snake().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Утки проснулись
        if (currentCellMap.containsKey("Утка")) {
            for (int i = 0; i < currentCellMap.get("Утка"); i++) {
                new Duck().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Кенгуру проснулись
        if (currentCellMap.containsKey("Кенгуру")) {
            for (int i = 0; i < currentCellMap.get("Кенгуру"); i++) {
                new Kangaroo().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Лошади проснулись
        if (currentCellMap.containsKey("Лошадь")) {
            for (int i = 0; i < currentCellMap.get("Лошадь"); i++) {
                new Horse().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Олени проснулись
        if (currentCellMap.containsKey("Олень")) {
            for (int i = 0; i < currentCellMap.get("Олень"); i++) {
                new Deer().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Коровы проснулись
        if (currentCellMap.containsKey("Корова")) {
            for (int i = 0; i < currentCellMap.get("Корова"); i++) {
                new Cow().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Козы проснулись
        if (currentCellMap.containsKey("Коза")) {
            for (int i = 0; i < currentCellMap.get("Коза"); i++) {
                new Goat().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Овцы проснулись
        if (currentCellMap.containsKey("Овца")) {
            for (int i = 0; i < currentCellMap.get("Овца"); i++) {
                new Sheep().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Хомяки проснулись
        if (currentCellMap.containsKey("Хомяк")) {
            for (int i = 0; i < currentCellMap.get("Хомяк"); i++) {
                new Hamster().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Гусеницы проснулись
        if (currentCellMap.containsKey("Гусеница")) {
            for (int i = 0; i < currentCellMap.get("Гусеница"); i++) {
                new Larva().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }
        // Травка зашелестела
        if (currentCellMap.containsKey("Трава")) {
            for (int i = 0; i < currentCellMap.get("Трава"); i++) {
                new Grass().firstBorn(lengthIslandIndex, widthIslandIndex);
            }

        }

        // 3. Выводим в консоль полученные данные с каждой ячейки

        // мы что-то можем делать с этими данными



        // Здесь мы задаем длительность такта симуляции (в секундах)
        // Каждый поток, после выполнения всей работы замрет длительность такта
        try {
            Thread.sleep(changeableClass.getLongTactSimulation() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
