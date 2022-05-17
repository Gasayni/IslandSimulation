package com.company.Animals;

import com.company.Plants.Grass;

public class Hare extends Animal {
    // Заяц

    // Вес
    public static final double weight = 3;
    // мах кол-во животных на одной клетке
    private static final int maxCountThisAnimalTypeToCell = 750;
    private final int kidMinCount = changeableClass.getHareKidMinCount();
    private final int kidMaxCount = changeableClass.getHareKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private static final int speed = 3;
    // Мах уровень сытости/насыщения
    private static final double maxSatiety = 0.45;
    private double satiety = maxSatiety / 2;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private static final int maxHungryTactBeforeDie = 7;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private int hungryTactBeforeDie = 0;
    private final int countThisAnimalTypeToCell = cell.haresListToCell.size();
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
            // Ищем Растения
            if (!cell.grassListToCell.isEmpty()) {
                satiety += Grass.weight;
                cell.grassListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            else break;
        }

        if (satiety > 0) {
            // если мы поели, то обнуляем смерть от голода
            if (hungryTactBeforeDie != 0) {
                hungryTactBeforeDie = 0;
            }
            // насыщение не может быть больше мах
            if (satiety > maxSatiety) satiety = maxSatiety;

            // в сытость уменьшается в любом случае в конце такта
            satiety--;
        } else {
            // Если мы не поели, то голод увеличивается
            hungryTactBeforeDie++;
            if (hungryTactBeforeDie == maxHungryTactBeforeDie) {
                die(locationLength, locationWidth);
                return;
            }
        }

        if (!eatFlag) {
            // Если мы ничего не поели, то попробуем размножиться
            reproduction();
        }
    }

    @Override
    public void born(int locationLength, int locationWidth) {
        // должен родиться в заданном месте на острове
        cells[locationLength][locationWidth].haresListToCell.add(new Hare());
    }

    @Override
    public void die(int locationLength, int locationWidth) {
        // то просто уменьшаем на 1
        cells[locationLength][locationWidth].haresListToCell.remove(this);
    }


    @Override
    public void reproduction() {
        // Если животное не голодно(если сытость меньше половины)
        if (satiety > maxSatiety / 2) {
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
