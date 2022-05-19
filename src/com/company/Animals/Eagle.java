package com.company.Animals;

import com.company.Details;

public class Eagle extends Animal {
    // Орел

    // Вес
    public static final double weight = 25;
    // мах кол-во животных на одной клетке
    private static final int maxCountThisAnimalTypeToCell = 166;
    private final int kidMinCount = changeableClass.getEagleKidMinCount();
    private final int kidMaxCount = changeableClass.getEagleKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private static final int speed = 8;
    // Мах уровень сытости/насыщения
    private static final double maxSatiety = 10;
    private double satiety = maxSatiety / 2;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private static final int maxHungryTactBeforeDie = 5;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private int hungryTactBeforeDie = 0;
    private boolean eatFlag = false;

    @Override
    public void eat() {
        // сначала проверяем убит ли и заодно проверяем на перенаселение этим видом
        if (countThisAnimalTypeToCell > maxCountThisAnimalTypeToCell) {
            die(locationLength, locationWidth);
            return;
        }

        // Ест пока не насытится
        while (satiety < maxSatiety) {

            // Хомяки и зайцы
            if ((!cell.hamstersListToCell.isEmpty())
                    || (!cell.haresListToCell.isEmpty())) {
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем Хомяков
                    if (!cell.hamstersListToCell.isEmpty()) {
                        satiety += Hamster.weight;
                        cell.hamstersListToCell.get(0).die(locationLength, locationWidth);
                    }
                } else {
                    // Ищем зайцев
                    if (!cell.haresListToCell.isEmpty()) {
                        satiety += Hare.weight;
                        cell.haresListToCell.get(0).die(locationLength, locationWidth);
                    }
                }
                eatFlag = true;
            }
            // Ищем Уток
            else if (!cell.ducksListToCell.isEmpty()) {
                satiety += Duck.weight;
                cell.ducksListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            // Ищем Змей
            else if (!cell.snakesListToCell.isEmpty()) {
                satiety += Snake.weight;
                cell.snakesListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            // Ищем гусениц
            else if (!cell.larvaListToCell.isEmpty()) {
                satiety += Larva.weight;
                cell.larvaListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            else break;
        }
        // если мы поели хоть что-то
        if (eatFlag) {
            // если мы еще не голодны
            if (satiety > 0 && hungryTactBeforeDie > 0) {
                // обнуляем голод
                hungryTactBeforeDie = 0;
            }
            // сытость не может быть больше мах
            if (satiety > maxSatiety) {
                satiety = maxSatiety;
            }
        }
        // если мы еще не голодны (если сытость больше 0)
        if (satiety > 0) {
            // сытость уменьшается
            satiety = satiety - maxSatiety / 2;
        }
        // Если сытость опустилась до 0 или ниже
        else {
            // отрицательный уровень сытости поддерживается, но голод увеличивается
            if (satiety < -(maxSatiety / 2)) {
                satiety = -(maxSatiety / 2);
            }
            // голод увеличивается
            hungryTactBeforeDie++;
            // если голод очень долго (голод не меньше max)
            if (hungryTactBeforeDie == maxHungryTactBeforeDie) {
                // то умираем
                die(locationLength, locationWidth);
                return;
            }
        }
        // Мало живности. (если сытость меньше половины)
        if (satiety < maxSatiety / 2) {
            move(locationLength, locationWidth, speed);
            return;
        }
        // попробуем размножиться, все равно их мало
        reproduction();
    }

    @Override
    public void born(int locationLength, int locationWidth) {
        // должен родиться в заданном месте на острове
        cell = cells[locationLength][locationWidth];
        cell.eaglesListToCell.add(this);
    }

    @Override
    public void die(int locationLength, int locationWidth) {
        // то просто уменьшаем на 1
        cell = cells[locationLength][locationWidth];
        cell.eaglesListToCell.remove(this);
    }


    @Override
    public void reproduction() {
        // Если животное не голодно
        if (hungryTactBeforeDie == 0) {
            // было бы с кем спариться(Если есть еще такое же животное)
            if (countThisAnimalTypeToCell > 1) {
                // заодно проверяем на перенаселение этим видом
                // если уже перенаселен, то мы не будем размножаться
                if (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell) {
                    // Ну если уж размножились, то мы не можем регулировать размер выводка
                    // выбираем количество потомства(рандомно от мин до мах-го)
                    int rand = details.randomizer(kidMinCount, kidMaxCount);
                    for (int i = 0; i < rand; i++) {
                        born(locationLength, locationWidth);
                    }
                    return;
                }
            }
        }

        // и еды нет и спариться не с кем, пойду отсюда...
        move(locationLength, locationWidth, speed);
    }

    public double getWeight() {
        return weight;
    }
}
