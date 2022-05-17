package com.company.Animals;

import com.company.Plants.Grass;

public class Horse extends Animal {
    // Лошадь

    // Вес
    public static final double weight = 300;
    // мах кол-во животных на одной клетке
    private static final int maxCountThisAnimalTypeToCell = 23;
    private final int kidMinCount = changeableClass.getHorseKidMinCount();
    private final int kidMaxCount = changeableClass.getHorseKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private static final int speed = 3;
    // Мах уровень сытости/насыщения
    private final double maxSatiety = 45;
    private double satiety = maxSatiety / 2;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private static final int maxHungryTactBeforeDie = 5;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private static int hungryTactBeforeDie = 0;
    private boolean eatFlag = false;
    private final int countThisAnimalTypeToCell = cell.horsesListToCell.size();

    @Override
    public void eat() {
        // сначала проверяем убит ли и заодно проверяем на перенаселение этим видом
        if (countThisAnimalTypeToCell > maxCountThisAnimalTypeToCell) {
            die(locationLength, locationWidth);
            return;
        }

        // Это животное ищет добычу по убыванию вероятности съедания
        // Это животное если поймал кого-то, то съедает ее полностью
        // За один такт животное съедает только одну добычу

        // если еще голоден, то он ищет покушать
        if (satiety < maxSatiety) {
            // Ищем Растения
            if (!cell.grassListToCell.isEmpty()) {
                satiety += Grass.weight;
                cell.grassListToCell.get(0).die(locationLength, locationWidth);
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
        } else {
            // Если мы не поели, то сытость уменьшается
            if (satiety < 0) {
                hungryTactBeforeDie++;
                if (hungryTactBeforeDie == maxHungryTactBeforeDie) {
                    die(locationLength, locationWidth);
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
    public void born(int locationLength, int locationWidth) {
        // должен родиться в заданном месте на острове
        cells[locationLength][locationWidth].horsesListToCell.add(new Horse());
    }

    @Override
    public void die(int locationLength, int locationWidth) {
        // то просто уменьшаем на 1
        cells[locationLength][locationWidth].horsesListToCell.remove(this);
    }


    @Override
    public void reproduction() {
        // Если животное не голодно(если сытость меньше половины)
        if (satiety < maxSatiety / 2) {
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
