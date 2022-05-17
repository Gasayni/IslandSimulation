package com.company.Animals;

import com.company.Details;

public class Snake extends Animal {
    // Змея

    // Вес
    public static final double weight = 2;
    // мах кол-во животных на одной клетке
    private static final int maxCountThisAnimalTypeToCell = 123;
    private final int kidMinCount = changeableClass.getSnakeKidMinCount();
    private final int kidMaxCount = changeableClass.getSnakeKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private static final int speed = 1;
    // Мах уровень сытости/насыщения
    private static final double maxSatiety = 0.3;
    private double satiety = maxSatiety / 2;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private static final int maxHungryTactBeforeDie = 15;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private int hungryTactBeforeDie = 0;
    public boolean eatFlag = false;
    int countThisAnimalTypeToCell = cell.snakesListToCell.size();

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
            // Смотрим, есть ли на этом участке чем поживиться
            // Сначала ищем хомяков и гусениц
            if ((!cell.hamstersListToCell.isEmpty())
                    || (!cell.larvaListToCell.isEmpty())) {
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // ищем хомяков
                    if (!cell.hamstersListToCell.isEmpty()) {
                        satiety += Hamster.weight;
                        cell.hamstersListToCell.get(0).die(locationLength, locationWidth);
                    }
                } else {
                    // Ищем гусениц
                    if (!cell.larvaListToCell.isEmpty()) {
                        satiety += Larva.weight;
                        cell.larvaListToCell.get(0).die(locationLength, locationWidth);
                    }
                }
                eatFlag = true;
            }
            // Ищем зайцев и уток
            else if ((!cell.haresListToCell.isEmpty())
                    || (!cell.ducksListToCell.isEmpty())) {
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем зайцев
                    if (!cell.haresListToCell.isEmpty()) {
                        satiety += Hare.weight;
                        cell.haresListToCell.get(0).die(locationLength, locationWidth);
                    }
                } else {
                    // Ищем Уток
                    if (!cell.ducksListToCell.isEmpty()) {
                        satiety += Duck.weight;
                        cell.ducksListToCell.get(0).die(locationLength, locationWidth);
                    }
                }
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
                    die(locationLength, locationWidth);
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
    public void born(int locationLength, int locationWidth) {
        // должен родиться в заданном месте на острове
        cells[locationLength][locationWidth].snakesListToCell.add(new Snake());
    }

    @Override
    public void die(int locationLength, int locationWidth) {
        // то просто уменьшаем на 1
        cells[locationLength][locationWidth].snakesListToCell.remove(this);
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
