package com.company.Animals;

import com.company.Plants.Grass;

public class Goat extends Herbivore {
    // Коза

    // Вес
    private final double weight = 65;
    // мах кол-во животных на одной клетке
    private final int maxCountThisAnimalTypeToCell = 107;
    private final int kidMinCount = changeableClass.getGoatKidMinCount();
    private final int kidMaxCount = changeableClass.getGoatKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private final int speed = 1;
    // Мах уровень сытости/насыщения
    private final double maxSatiety = 10;
    private double satiety = maxSatiety;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private final int maxHungryTactBeforeDie = 5;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private int hungryTactBeforeDie = 0;

    @Override
    public void eat() {
        int countThisAnimalTypeToCell = currentCellMap.get("Коза");
        // сначала проверяем убит ли и заодно проверяем на перенаселение этим видом
        if (deadFlag || (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell)) {
            die(locationLength, locationWidth, "Коза");
            return;
        }

        // Это животное ищет добычу по убыванию вероятности съедания
        // Это животное если поймал кого-то, то съедает ее полностью
        // За один такт животное съедает только одну добычу

        // если еще голоден, то он ищет покушать
        if (satiety < maxSatiety) {
            // Ищем Растения
            if (currentCellMap.get("Трава") > 0) {
                Grass grass = new Grass();
                satiety += grass.getWeight();
                grass.deadFlag = true;
            }
        }

        if (eatFlag) {
            // если мы поели, то обнуляем смерть от голода
            if (hungryTactBeforeDie != 0) {
                hungryTactBeforeDie = 0;
            }
            // насыщение не может быть больше мах
            if (satiety > maxSatiety) satiety = maxSatiety;
            // снова обнуляем флаг еды, для следующей проверки трапезы
            eatFlag = false;
        } else {
            // Если мы не поели, то сытость уменьшается
            if (satiety == 0) {
                hungryTactBeforeDie++;
                if (hungryTactBeforeDie == maxHungryTactBeforeDie) {
                    die(locationLength, locationWidth, "Коза");
                    return;
                }
            } else {
                satiety--;
            }
            // Если мы ничего не поели, то попробуем размножиться
            reproduction();
        }
    }

    @Override
    public void reproduction() {
        // было бы с кем спариться(Если есть еще такое же животное)
        if (currentCellMap.get("Коза") > 1) {
            // заодно проверяем на перенаселение этим видом
            // если уже перенаселен, то мы не будем размножаться
            int countThisAnimalTypeToCell = currentCellMap.get("Коза");
            if (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell) {
                // Ну если уж размножились, то мы не можем регулировать размер выводка
                // выбираем количество потомства(рандомно от мин до мах-го)
                for (int i = 0; i < details.randomizer(kidMinCount, kidMaxCount); i++) {
                    new Goat().firstBorn(locationLength, locationWidth);
                }
                return;
            }
        }

        // и еды нет и спариться не с кем, пойду отсюда...
        move(locationLength, locationWidth, speed, "Коза");
    }

    public double getWeight() {
        return weight;
    }
}
