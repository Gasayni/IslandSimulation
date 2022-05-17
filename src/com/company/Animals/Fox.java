package com.company.Animals;

import com.company.Details;

public class Fox extends Animal {
    // Лиса

    // Вес
    public static final double weight = 4;
    // мах кол-во животных на одной клетке
    private static final int maxCountThisAnimalTypeToCell = 50;
    private final int kidMinCount = changeableClass.getFoxKidMinCount();
    private final int kidMaxCount = changeableClass.getFoxKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private static final int speed = 3;
    // Мах уровень сытости/насыщения
    private static final double maxSatiety = 1;
    private double satiety = maxSatiety / 2;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private static final int maxHungryTactBeforeDie = 8;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private int hungryTactBeforeDie = 0;
    public boolean eatFlag = false;
    int countThisAnimalTypeToCell = cell.foxesListToCell.size();

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


        // если волк еще голоден, то он ищет покушать
        if (satiety < maxSatiety) {
            // Смотрим, есть ли на этом участке чем поживиться
            // Сначала ищем хомяков
            if (!cell.hamstersListToCell.isEmpty()) {
                satiety += Hamster.weight;
                cell.hamstersListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            // Ищем уток
            else if (!cell.ducksListToCell.isEmpty()) {
                satiety += Duck.weight;
                cell.ducksListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            // Ищем зайцев
            else if (!cell.haresListToCell.isEmpty()) {
                satiety += Hare.weight;
                cell.haresListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            // Змеи, козы и овцы
            else if ((!cell.snakesListToCell.isEmpty())
                    || (!cell.goatsListToCell.isEmpty())
                    || (!cell.sheepListToCell.isEmpty())) {
                int random = new Details().randomizer(1, 3);
                if (random == 1) {
                    // Ищем Змей
                    if (!cell.snakesListToCell.isEmpty()) {
                        satiety += Snake.weight;
                        cell.snakesListToCell.get(0).die(locationLength, locationWidth);
                    }
                } else if (random == 2) {
                    // Ищем коз
                    if (!cell.goatsListToCell.isEmpty()) {
                        satiety += Goat.weight;
                        cell.goatsListToCell.get(0).die(locationLength, locationWidth);
                    }
                } else {
                    // Ищем овец
                    if (!cell.sheepListToCell.isEmpty()) {
                        satiety += Sheep.weight;
                        cell.sheepListToCell.get(0).die(locationLength, locationWidth);
                    }
                }
                eatFlag = true;
            }
            // Ищем орлов
            else if (!cell.eaglesListToCell.isEmpty()) {
                satiety += Eagle.weight;
                cell.eaglesListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            // Олень и кенгуру
            else if ((!cell.deerListToCell.isEmpty())
                    || (!cell.kangaroosListToCell.isEmpty())) {
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем оленей
                    if (!cell.deerListToCell.isEmpty()) {
                        satiety += Deer.weight;
                        cell.deerListToCell.get(0).die(locationLength, locationWidth);
                    }
                } else {
                    // Ищем Кенгуру
                    if (!cell.kangaroosListToCell.isEmpty()) {
                        satiety += Kangaroo.weight;
                        cell.kangaroosListToCell.get(0).die(locationLength, locationWidth);
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
            if (satiety < 0){
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
        cells[locationLength][locationWidth].foxesListToCell.add(new Fox());
    }

    @Override
    public void die(int locationLength, int locationWidth) {
        // то просто уменьшаем на 1
        cells[locationLength][locationWidth].foxesListToCell.remove(this);
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
