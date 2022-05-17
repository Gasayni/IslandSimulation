package com.company.Animals;

import com.company.Details;

public class Eagle extends Predator {
    // Орел

    // Вес
    private final double weight = 6;
    // мах кол-во животных на одной клетке
    private final int maxCountThisAnimalTypeToCell = 166;
    private final int kidMinCount = changeableClass.getEagleKidMinCount();
    private final int kidMaxCount = changeableClass.getEagleKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private final int speed = 4;
    // Мах уровень сытости/насыщения
    private final double maxSatiety = 1;
    private double satiety = maxSatiety;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private final int maxHungryTactBeforeDie = 5;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private int hungryTactBeforeDie = 0;

    @Override
    public void eat() {
        int countThisAnimalTypeToCell = currentCellMap.get("Орел");
        // сначала проверяем убит ли и заодно проверяем на перенаселение этим видом
        if (deadFlag || (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell)) {
            die(locationLength, locationWidth, "Орел");
            return;
        }

        // Это животное ищет добычу по убыванию вероятности съедания
        // Это животное если поймал кого-то, то съедает ее полностью
        // За один такт животное съедает только одну добычу


        // если волк еще голоден, то он ищет покушать
        if (satiety < maxSatiety) {
            // Хомяки и зайцы
            if ((currentCellMap.get("Хомяк") > 0)
                    || (currentCellMap.get("Заяц") > 0)) {
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем Хомяков
                    if (currentCellMap.get("Хомяк") > 0) {
                        Hamster hamster = new Hamster();
                        satiety += hamster.getWeight();
                        hamster.deadFlag = true;
                    }
                } else {
                    // Ищем зайцев
                    if (currentCellMap.get("Заяц") > 0) {
                        Hare hare = new Hare();
                        satiety += hare.getWeight();
                        hare.deadFlag = true;
                    }
                }
                eatFlag = true;
            }
            // Ищем Уток
            if (currentCellMap.get("Утка") > 0) {
                Duck duck = new Duck();
                satiety += duck.getWeight();
                duck.deadFlag = true;
            }
            // Ищем Змей
            if (currentCellMap.get("Змея") > 0) {
                Snake snake = new Snake();
                satiety += snake.getWeight();
                snake.deadFlag = true;
            }
            // Ищем гусениц
            if (currentCellMap.get("Гусеница") > 0) {
                Larva larva = new Larva();
                satiety += larva.getWeight();
                larva.deadFlag = true;
                eatFlag = true;
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
                    die(locationLength, locationWidth, "Орел");
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
        if (currentCellMap.get("Орел") > 1) {
            // заодно проверяем на перенаселение этим видом
            // если уже перенаселен, то мы не будем размножаться
            int countThisAnimalTypeToCell = currentCellMap.get("Орел");
            if (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell) {
                // Ну если уж размножились, то мы не можем регулировать размер выводка
                // выбираем количество потомства(рандомно от мин до мах-го)
                for (int i = 0; i < details.randomizer(kidMinCount, kidMaxCount); i++) {
                    new Eagle().firstBorn(locationLength, locationWidth);
                }
                return;
            }
        }

        // и еды нет и спариться не с кем, пойду отсюда...
        move(locationLength, locationWidth, speed, "Орел");
    }

    public double getWeight() {
        return weight;
    }
}
