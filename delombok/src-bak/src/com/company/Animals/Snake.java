package com.company.Animals;

import com.company.Details;

public class Snake extends Predator {
    // Змея

    // Вес
    private final double weight = 2;
    // мах кол-во животных на одной клетке
    private final int maxCountThisAnimalTypeToCell = 123;
    private final int kidMinCount = changeableClass.getSnakeKidMinCount();
    private final int kidMaxCount = changeableClass.getSnakeKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private final int speed = 1;
    // Мах уровень сытости/насыщения
    private final double maxSatiety = 0.3;
    private double satiety = maxSatiety;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private final int maxHungryTactBeforeDie = 15;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private int hungryTactBeforeDie = 0;

    @Override
    public void eat() {
        int countThisAnimalTypeToCell = currentCellMap.get("Змея");
        // сначала проверяем убит ли и заодно проверяем на перенаселение этим видом
        if (deadFlag || (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell)) {
            die(locationLength, locationWidth, "Змея");
            return;
        }

        // Это животное ищет добычу по убыванию вероятности съедания
        // Это животное если поймал кого-то, то съедает ее полностью
        // За один такт животное съедает только одну добычу


        // если волк еще голоден, то он ищет покушать
        if (satiety < maxSatiety) {
            // Смотрим, есть ли на этом участке чем поживиться
            // Сначала ищем хомяков и гусениц
            if ((currentCellMap.get("Хомяк") > 0)
                    || (currentCellMap.get("Гусеница") > 0)) {
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // ищем хомяков
                    if (currentCellMap.get("Хомяк") > 0) {
                        // Съедает хомяка - 90% вероятностью
                        Hamster hamster = new Hamster();
                        satiety += hamster.getWeight();
                        hamster.deadFlag = true;
                        eatFlag = true;
                    }
                } else {
                    // Ищем гусениц
                    if (currentCellMap.get("Гусеница") > 0) {
                        Larva larva = new Larva();
                        satiety += larva.getWeight();
                        larva.deadFlag = true;
                        eatFlag = true;
                    }
                }

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
        }
        else {
            // Если мы не поели, то сытость уменьшается
            if (satiety == 0){
                hungryTactBeforeDie ++;
                if (hungryTactBeforeDie == maxHungryTactBeforeDie) {
                    die(locationLength, locationWidth, "Змея");
                    return;
                }
            } else {
                satiety --;
            }
            // Если мы ничего не поели, то попробуем размножиться
            reproduction();
        }
    }

    @Override
    public void reproduction() {
        // было бы с кем спариться(Если есть еще такое же животное)
        if (currentCellMap.get("Змея") > 1) {
            // заодно проверяем на перенаселение этим видом
            // если уже перенаселен, то мы не будем размножаться
            int countThisAnimalTypeToCell = currentCellMap.get("Змея");
            if (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell) {
                // Ну если уж размножились, то мы не можем регулировать размер выводка
                // выбираем количество потомства(рандомно от мин до мах-го)
                for (int i = 0; i < details.randomizer(kidMinCount, kidMaxCount); i++) {
                    new Snake().firstBorn(locationLength, locationWidth);
                }
                return;
            }
        }

        // и еды нет и спариться не с кем, пойду отсюда...
        move(locationLength, locationWidth, speed, "Змея");
    }

    public double getWeight() {
        return weight;
    }
}
