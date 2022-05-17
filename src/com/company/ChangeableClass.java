package com.company;

import java.util.List;

public class ChangeableClass {
    // 1 такт(временной) - 1 месяц

    // Размер острова
    private static final int lengthIsland = 20;
    private static final int widthIsland = 80;

    private static Cell[][] cellMas = new Cell[lengthIsland][widthIsland];

    public Cell[][] getCellMas() {
        return cellMas;
    }

    public void setCellMas(Cell[][] cellMas) {
        ChangeableClass.cellMas = cellMas;
    }

    //                              Условия остановки симуляции
    // Длительность такта симуляции (в секундах)
    private static final int longTactSimulation = 2;
    // Максимальное кол-во тактов
    private static final int maxStep = 10;

    // количество животных каждого вида на старте симуляции
    // 2.5 * на возможное кол-во в клетке
    private static final int wolfCountStart = 75;
    private static final int snakeCountStart = 300;
    private static final int foxCountStart = 125;
    private static final int bearCountStart = 18;
    private static final int eagleCountStart = 400;
    private static final int horseCountStart = 60;
    private static final int deerCountStart = 65;
    private static final int hareCountStart = 2000;
    private static final int hamsterCountStart = 25000;
    private static final int goatCountStart = 270;
    private static final int sheepCountStart = 400;
    private static final int kangarooCountStart = 380;
    private static final int cowCountStart = 50;
    private static final int duckCountStart = 1500;
    private static final int larvaCountStart = 25000;
    private static final int grassCountStart = 25000;

    /*private String[] nameTypeAnimal = {"Волк", "Змея", "Лиса", "Медведь", "Орел", "Лошадь",
            "Олень", "Заяц", "Хомяк", "Коза", "Овца", "Кенгуру", "Корова", "Утка", "Гусеница", "Трава"};*/

    public static int countAnimals() {
        List<Integer> countAnimalList = List.of(wolfCountStart, snakeCountStart, foxCountStart, bearCountStart,
                eagleCountStart, horseCountStart, deerCountStart, hareCountStart, hamsterCountStart, goatCountStart,
                sheepCountStart, kangarooCountStart, cowCountStart, duckCountStart, larvaCountStart, grassCountStart);
        int maxAnimalCount = countAnimalList.get(0);
        for (Integer integer : countAnimalList) {
            if (maxAnimalCount < integer) maxAnimalCount = integer;
        }
        return maxAnimalCount;
    }


    // Условие остановки симуляции
    // 1. когда все хищники вымрут
    // 2. когда все растения вымрут
    // 3. когда вымрут волки

    // 4. Не останавливать симуляцию


    //количество детенышей у каждого вида животных
    // Волчата за 30 тактов становятся половозрелыми
    private static final int wolfKidMinCount = 7;
    private static final int wolfKidMaxCount = 12;
    // Змеи за 30 тактов становятся половозрелыми
    private static final int snakeKidMinCount = 10;
    private static final int snakeKidMaxCount = 100;
    // Лисицы за 20 тактов становятся половозрелыми
    private static final int foxKidMinCount = 4;
    private static final int foxKidMaxCount = 10;
    // Медвежата за 100 тактов становятся половозрелыми
    private static final int bearKidMinCount = 1;
    private static final int bearKidMaxCount = 3;
    // Медвежата за 50 тактов становятся половозрелыми
    private static final int eagleKidMinCount = 1;
    private static final int eagleKidMaxCount = 2;
    // Лошади за 30 тактов становятся половозрелыми
    private static final int horseKidMinCount = 1;
    private static final int horseKidMaxCount = 3;
    // Олени за 15 тактов становятся половозрелыми
    private static final int deerKidMinCount = 1;
    private static final int deerKidMaxCount = 3;
    // Зайцы за 3 такта становятся половозрелыми
    private static final int hareKidMinCount = 2;
    private static final int hareKidMaxCount = 15;
    // Хомяки за 1 такта становятся половозрелыми
    private static final int hamsterKidMinCount = 1;
    private static final int hamsterKidMaxCount = 18;
    // Коза за 4 такта становятся половозрелыми
    private static final int goatKidMinCount = 1;
    private static final int goatKidMaxCount = 3;
    // Овца за 6 такта становятся половозрелыми
    private static final int sheepKidMinCount = 1;
    private static final int sheepKidMaxCount = 3;
    // Кенгуру за 20 такта становятся половозрелыми
    private static final int kangarooKidMinCount = 1;
    private static final int kangarooKidMaxCount = 2;
    // Корова за 8 такта становятся половозрелыми
    private static final int cowKidMinCount = 1;
    private static final int cowKidMaxCount = 2;
    // Утка за 20 такта становятся половозрелым
    private static final int duckKidMinCount = 5;
    private static final int duckKidMaxCount = 20;
    // Гусеница за 1 такт становятся половозрелым
    private static final int larvaKidMinCount = 2;
    private static final int larvaKidMaxCount = 5;
    // Растение всегда половозрелое...
    private static final int grassMinKidCount = 3;
    private static final int grassMaxKidCount = 10;



    /*public String[] getNameTypeAnimal() {
        return nameTypeAnimal;
    }

    public void setNameTypeAnimal(String[] nameTypeAnimal) {
        this.nameTypeAnimal = nameTypeAnimal;
    }*/

    public int getGrassMinKidCount() {
        return grassMinKidCount;
    }

    public int getGrassMaxKidCount() {
        return grassMaxKidCount;
    }

    public int getLengthIsland() {
        return lengthIsland;
    }

    public int getWidthIsland() {
        return widthIsland;
    }

    public int getLongTactSimulation() {
        return longTactSimulation;
    }

    public int getMaxStep() {
        return maxStep;
    }

    public int getWolfCountStart() {
        return wolfCountStart;
    }

    public int getSnakeCountStart() {
        return snakeCountStart;
    }

    public int getFoxCountStart() {
        return foxCountStart;
    }

    public int getBearCountStart() {
        return bearCountStart;
    }

    public int getEagleCountStart() {
        return eagleCountStart;
    }

    public int getHorseCountStart() {
        return horseCountStart;
    }

    public int getDeerCountStart() {
        return deerCountStart;
    }

    public int getHareCountStart() {
        return hareCountStart;
    }

    public int getHamsterCountStart() {
        return hamsterCountStart;
    }

    public int getGoatCountStart() {
        return goatCountStart;
    }

    public int getSheepCountStart() {
        return sheepCountStart;
    }

    public int getKangarooCountStart() {
        return kangarooCountStart;
    }

    public int getCowCountStart() {
        return cowCountStart;
    }

    public int getDuckCountStart() {
        return duckCountStart;
    }

    public int getLarvaCountStart() {
        return larvaCountStart;
    }

    public int getGrassCountStart() {
        return grassCountStart;
    }

    public int getWolfKidMinCount() {
        return wolfKidMinCount;
    }

    public int getWolfKidMaxCount() {
        return wolfKidMaxCount;
    }

    public int getSnakeKidMinCount() {
        return snakeKidMinCount;
    }

    public int getSnakeKidMaxCount() {
        return snakeKidMaxCount;
    }

    public int getFoxKidMinCount() {
        return foxKidMinCount;
    }

    public int getFoxKidMaxCount() {
        return foxKidMaxCount;
    }

    public int getBearKidMinCount() {
        return bearKidMinCount;
    }

    public int getBearKidMaxCount() {
        return bearKidMaxCount;
    }

    public int getEagleKidMinCount() {
        return eagleKidMinCount;
    }

    public int getEagleKidMaxCount() {
        return eagleKidMaxCount;
    }

    public int getHorseKidMinCount() {
        return horseKidMinCount;
    }

    public int getHorseKidMaxCount() {
        return horseKidMaxCount;
    }

    public int getDeerKidMinCount() {
        return deerKidMinCount;
    }

    public int getDeerKidMaxCount() {
        return deerKidMaxCount;
    }

    public int getHareKidMinCount() {
        return hareKidMinCount;
    }

    public int getHareKidMaxCount() {
        return hareKidMaxCount;
    }

    public int getHamsterKidMinCount() {
        return hamsterKidMinCount;
    }

    public int getHamsterKidMaxCount() {
        return hamsterKidMaxCount;
    }

    public int getGoatKidMinCount() {
        return goatKidMinCount;
    }

    public int getGoatKidMaxCount() {
        return goatKidMaxCount;
    }

    public int getSheepKidMinCount() {
        return sheepKidMinCount;
    }

    public int getSheepKidMaxCount() {
        return sheepKidMaxCount;
    }

    public int getKangarooKidMinCount() {
        return kangarooKidMinCount;
    }

    public int getKangarooKidMaxCount() {
        return kangarooKidMaxCount;
    }

    public int getCowKidMinCount() {
        return cowKidMinCount;
    }

    public int getCowKidMaxCount() {
        return cowKidMaxCount;
    }

    public int getDuckKidMinCount() {
        return duckKidMinCount;
    }

    public int getDuckKidMaxCount() {
        return duckKidMaxCount;
    }

    public int getLarvaKidMinCount() {
        return larvaKidMinCount;
    }

    public int getLarvaKidMaxCount() {
        return larvaKidMaxCount;
    }
}
