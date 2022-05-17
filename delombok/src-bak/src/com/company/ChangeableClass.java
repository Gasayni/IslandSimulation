package com.company;

import java.util.List;

public class ChangeableClass {
    // 1 такт(временной) - 1 месяц

    // Размер острова
    private final int lengthIsland = 20;
    private final int widthIsland = 80;

    private Cell[][] cellMas = new Cell[lengthIsland][widthIsland];

    public Cell[][] getCellMas() {
        return cellMas;
    }

    public void setCellMas(Cell[][] cellMas) {
        this.cellMas = cellMas;
    }

    // Длительность такта симуляции (в секундах)
    private final int longTactSimulation = 1;

    // количество животных каждого вида на старте симуляции
    // 2.5 * на возможное кол-во в клетке
    private final int wolfCountStart = 75;
    private final int snakeCountStart = 300;
    private final int foxCountStart = 125;
    private final int bearCountStart = 18;
    private final int eagleCountStart = 400;
    private final int horseCountStart = 60;
    private final int deerCountStart = 65;
    private final int hareCountStart = 2000;
    private final int hamsterCountStart = 25000;
    private final int goatCountStart = 270;
    private final int sheepCountStart = 400;
    private final int kangarooCountStart = 380;
    private final int cowCountStart = 50;
    private final int duckCountStart = 1500;
    private final int larvaCountStart = 25000;
    private final int grassCountStart = 25000;

    /*private String[] nameTypeAnimal = {"Волк", "Змея", "Лиса", "Медведь", "Орел", "Лошадь",
            "Олень", "Заяц", "Хомяк", "Коза", "Овца", "Кенгуру", "Корова", "Утка", "Гусеница", "Трава"};*/
    
    public int countAnimals() {
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
    private final int wolfKidMinCount = 7;
    private final int wolfKidMaxCount = 12;
    // Змеи за 30 тактов становятся половозрелыми
    private final int snakeKidMinCount = 10;
    private final int snakeKidMaxCount = 100;
    // Лисицы за 20 тактов становятся половозрелыми
    private final int foxKidMinCount = 4;
    private final int foxKidMaxCount = 10;
    // Медвежата за 100 тактов становятся половозрелыми
    private final int bearKidMinCount = 1;
    private final int bearKidMaxCount = 3;
    // Медвежата за 50 тактов становятся половозрелыми
    private final int eagleKidMinCount = 1;
    private final int eagleKidMaxCount = 2;
    // Лошади за 30 тактов становятся половозрелыми
    private final int horseKidMinCount = 1;
    private final int horseKidMaxCount = 3;
    // Олени за 15 тактов становятся половозрелыми
    private final int deerKidMinCount = 1;
    private final int deerKidMaxCount = 3;
    // Зайцы за 3 такта становятся половозрелыми
    private final int hareKidMinCount = 2;
    private final int hareKidMaxCount = 15;
    // Хомяки за 1 такта становятся половозрелыми
    private final int hamsterKidMinCount = 1;
    private final int hamsterKidMaxCount = 18;
    // Коза за 4 такта становятся половозрелыми
    private final int goatKidMinCount = 1;
    private final int goatKidMaxCount = 3;
    // Овца за 6 такта становятся половозрелыми
    private final int sheepKidMinCount = 1;
    private final int sheepKidMaxCount = 3;
    // Кенгуру за 20 такта становятся половозрелыми
    private final int kangarooKidMinCount = 1;
    private final int kangarooKidMaxCount = 2;
    // Корова за 8 такта становятся половозрелыми
    private final int cowKidMinCount = 1;
    private final int cowKidMaxCount = 2;
    // Утка за 20 такта становятся половозрелым
    private final int duckKidMinCount = 5;
    private final int duckKidMaxCount = 20;
    // Гусеница за 1 такт становятся половозрелым
    private final int larvaKidMinCount = 2;
    private final int larvaKidMaxCount = 5;
    // Растение всегда половозрелое...
    private final int grassMinKidCount = 100;
    private final int grassMaxKidCount = 300;



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
