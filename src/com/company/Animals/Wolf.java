package com.company.Animals;

import com.company.Details;

public class Wolf extends Animal {
    // Волк

    // Хорошо бы:
    // Волк сначала смотрит все варианты (пойдешь налево - смерть найдешь, направо - покушать будет...)
    // 1. Продумать стайность (от 1 по 9 волков в стае, 1 слабый, 2 сильные, 3 самки, 2 сильные, 1 вожак).
    // Одиночного волка могут принять(при условии самка или сытый более половины) или убить при приближении к стае.
    // Стаи уживаются друг с другом, но не приходят в одну клетку
    // Волку нужно остерегаться Медведя и стаи(при условии, что его могут убить(условия он понимает))
    // пол волка важен


    // Нужно сделать:
    // Волк сначала смотрит все варианты (пойдешь налево - смерть найдешь, направо - покушать будет...)
    // Волку нужно остерегаться Медведя
    // У волка в приоритете: убегать от Медведя -> покушать -> размножится -> идти дальше -> стоять на месте
    // Волк идет туда, где нет опасности, иначе сидит на месте. Волк не пойдет туда, где Медведь
    // Волк, также, не пойдет плавать, он же утонет.
    // Стаи не убивают другие стаи если находятся на одной клетке. Просто стаи стараются уйти(приоритет выше)
    // Если одиночные волки встретятся, то они будут двигаться вместе, до образования стаи. Стая начинается с 7 до 12
    // Если более 12 волков в стае, то взрослые(наиболее сытые) уходят в одиночный поход.
    // Рождается одновременно от 3 до 13 волчат. Растут в 3 такта. Первыми умирают от голода.
    //

    // Вес
    public static final double weight = 50;
    // мах кол-во животных на одной клетке
    private static final int maxCountThisAnimalTypeToCell = 30;
    private final int kidMinCount = changeableClass.getWolfKidMinCount();
    private final int kidMaxCount = changeableClass.getWolfKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private static final int speed = 3;
    // Мах уровень сытости/насыщения
    private static final double maxSatiety = 20;
    private double satiety = maxSatiety / 2;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private static final int maxHungryTactBeforeDie = 10;
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
            // Ищем: овцы и зайцы съедаются с одинаковой вероятностью 70%
            else if ((!cell.sheepListToCell.isEmpty())
                    || (!cell.haresListToCell.isEmpty())) {
                // У нас овцы и зайцы съедаются с одинаковой вероятностью
                // Поэтому включаем рандомайзер
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем овец
                    if (!cell.sheepListToCell.isEmpty()) {
                        satiety += Sheep.weight;
                        cell.sheepListToCell.get(0).die(locationLength, locationWidth);
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
            // Ищем коз
            else if (!cell.goatsListToCell.isEmpty()) {
                satiety += Goat.weight;
                cell.goatsListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            // Ищем оленя
            else if (!cell.deerListToCell.isEmpty()) {
                satiety += Deer.weight;
                cell.deerListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            // Ищем: лошади и коровы съедаются с одинаковой вероятностью 30%
            else if ((!cell.horsesListToCell.isEmpty())
                    || (!cell.cowsListToCell.isEmpty())) {
                // У нас лошади и коровы съедаются с одинаковой вероятностью
                // Поэтому включаем рандомайзер
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем Лошадей
                    if (!cell.horsesListToCell.isEmpty()) {
                        satiety += Horse.weight;
                        cell.horsesListToCell.get(0).die(locationLength, locationWidth);
                    }
                } else {
                    // Ищем Коров
                    if (!cell.cowsListToCell.isEmpty()) {
                        satiety += Cow.weight;
                        cell.cowsListToCell.get(0).die(locationLength, locationWidth);
                    }
                }
                eatFlag = true;
            }
            // Ищем Кенгуру
            else if (!cell.kangaroosListToCell.isEmpty()) {
                satiety += Kangaroo.weight;
                cell.kangaroosListToCell.get(0).die(locationLength, locationWidth);
                eatFlag = true;
            }
            // Ищем: змеи, лисы, орлы съедаются с одинаковой вероятностью 10%
            else if ((!cell.snakesListToCell.isEmpty())
                    || (!cell.foxesListToCell.isEmpty())
                    || (!cell.eaglesListToCell.isEmpty())) {
                // У нас змеи, лисы и орлы съедаются с одинаковой вероятностью
                // Поэтому включаем рандомайзер
                int random = new Details().randomizer(1, 3);
                if (random == 1) {
                    // ищем змею
                    if (!cell.snakesListToCell.isEmpty()) {
                        satiety += Snake.weight;
                        cell.snakesListToCell.get(0).die(locationLength, locationWidth);
                    }
                } else if (random == 2) {
                    // ищем лису
                    if (!cell.foxesListToCell.isEmpty()) {
                        satiety += Fox.weight;
                        cell.foxesListToCell.get(0).die(locationLength, locationWidth);
                    }
                } else {
                    // ищем орла
                    if (!cell.eaglesListToCell.isEmpty()) {
                        satiety += Eagle.weight;
                        cell.eaglesListToCell.get(0).die(locationLength, locationWidth);
                    }
                }
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
        cell.wolfsListToCell.add(this);
    }

    @Override
    public void die(int locationLength, int locationWidth) {
        // то просто уменьшаем на 1
        cell = cells[locationLength][locationWidth];
        cell.wolfsListToCell.remove(this);
    }


    @Override
    public void reproduction() {
        // Если животное не голодно
        if (hungryTactBeforeDie == 0) {
            // было бы с кем спариться (Если есть еще такое же животное)
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
