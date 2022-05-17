package com.company;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private final int lengthIslandIndex;
    private final int widthIslandIndex;
    ChangeableClass changeableClass = new ChangeableClass();
    Cell[][] cells = changeableClass.getCellMas();
    Cell cell;

    public Task(int lengthIslandIndex, int widthIslandIndex) {
        this.lengthIslandIndex = lengthIslandIndex;
        this.widthIslandIndex = widthIslandIndex;
        cell = cells[lengthIslandIndex][widthIslandIndex];
    }

    // Создавая новый поток, мы должны передать туда номер ячейки

    // Здесь у меня будет логика для каждого потока
    @Override
    public void run() {
//        System.out.println("changeableClass.getCellMas()[" + lengthIslandIndex + "][" + lengthIslandIndex + "]\n"
//                +  changeableClass.getCellMas()[lengthIslandIndex][lengthIslandIndex].getCellMap());
        // Поочередно запускаем работу каждого животного. Начиная с Медведя

        // Медведи проснулись
        int bearCount = cell.bearsListToCell.size();
        for (int i = 0; i < bearCount; i++) {
            cell.bearsListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Волки проснулись
        int wolfCount = cell.wolfsListToCell.size();
        for (int i = 0; i < wolfCount; i++) {
            cell.wolfsListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Лисы проснулись
        int foxCount = cell.foxesListToCell.size();
        for (int i = 0; i < foxCount; i++) {
            cell.foxesListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Орлы проснулись
        int eagleCount = cell.eaglesListToCell.size();
        for (int i = 0; i < eagleCount; i++) {
            cell.eaglesListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Змеи проснулись
        int snakeCount = cell.snakesListToCell.size();
        for (int i = 0; i < snakeCount; i++) {
            cell.snakesListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Утки проснулись
        int duckCount = cell.ducksListToCell.size();
        for (int i = 0; i < duckCount; i++) {
            cell.ducksListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Кенгуру проснулись
        int kangarooCount = cell.kangaroosListToCell.size();
        for (int i = 0; i < kangarooCount; i++) {
            cell.kangaroosListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Лошади проснулись
        int horseCount = cell.horsesListToCell.size();
        for (int i = 0; i < horseCount; i++) {
            cell.horsesListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Олени проснулись
        int deerCount = cell.deerListToCell.size();
        for (int i = 0; i < deerCount; i++) {
            cell.deerListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Коровы проснулись
        int cowCount = cell.cowsListToCell.size();
        for (int i = 0; i < cowCount; i++) {
            cell.cowsListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Козы проснулись
        int goatCount = cell.goatsListToCell.size();
        for (int i = 0; i < goatCount; i++) {
            cell.goatsListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Овцы проснулись
        int sheepCount = cell.sheepListToCell.size();
        for (int i = 0; i < sheepCount; i++) {
            cell.sheepListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Хомяки проснулись
        int hamsterCount = cell.hamstersListToCell.size();
        for (int i = 0; i < hamsterCount; i++) {
            cell.hamstersListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Гусеницы проснулись
        int larvaCount = cell.larvaListToCell.size();
        for (int i = 0; i < larvaCount; i++) {
            cell.larvaListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }
        // Травка зашелестела
        int grassCount = cell.grassListToCell.size();
        for (int i = 0; i < grassCount; i++) {
                cell.grassListToCell.get(i).firstBorn(lengthIslandIndex, widthIslandIndex);
        }


        // 3. Выводим в консоль полученные данные с каждой ячейки

        // мы что-то можем делать с этими данными
    }
}
