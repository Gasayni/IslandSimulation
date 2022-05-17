package com.company.Animals;

import com.company.*;

public class Bear extends Predator {
    // Медведь

    // Вес
    private final double weight = 250;
    // мах кол-во животных на одной клетке
    private final int maxCountThisAnimalTypeToCell = 7;
    private final int kidMinCount = changeableClass.getBearKidMinCount();
    private final int kidMaxCount = changeableClass.getBearKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private final int speed = 2;
    // Мах уровень сытости/насыщения
    private final int maxSatiety = 38;
    private double satiety = maxSatiety;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private final int maxHungryTactBeforeDie = 15;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private int hungryTactBeforeDie = 0;


    @Override
    public void eat() {
        int countThisAnimalTypeToCell = cells[locationLength][locationWidth].getCellMap().get("Медведь");
        // сначала проверяем убит ли и заодно проверяем на перенаселение этим видом
        if (deadFlag || (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell)) {
            die(locationLength, locationWidth, "Медведь");
            return;
        }

        // Это животное ищет добычу по убыванию вероятности съедания
        // Это животное если поймал кого-то, то съедает ее полностью
        // За один такт животное съедает только одну добычу


        // если волк еще голоден, то он ищет покушать
        if (satiety < maxSatiety) {
            // Смотрим, есть ли на этом участке чем поживиться
            // Сначала ищем хомяков
            if (currentCellMap.get("Хомяк") > 0) {
                // Съедает хомяка - 90% вероятностью
                Hamster hamster = new Hamster();
                satiety += hamster.getWeight();
                hamster.deadFlag = true;
                eatFlag = true;
            }
            // Утка, олень, заяц - 80%
            else if ((currentCellMap.get("Утка") > 0)
                    || (currentCellMap.get("Олень") > 0)
                    || (currentCellMap.get("Заяц") > 0)) {
                int random = new Details().randomizer(1, 3);
                if (random == 1) {
                    // Ищем Уток
                    if (currentCellMap.get("Утка") > 0) {
                        Duck duck = new Duck();
                        satiety += duck.getWeight();
                        duck.deadFlag = true;
                    }
                } else if (random == 2) {
                    // Ищем оленей
                    if (currentCellMap.get("Олень") > 0) {
                        Deer deer = new Deer();
                        satiety += deer.getWeight();
                        deer.deadFlag = true;
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
            // Ищем Коров
            if (currentCellMap.get("Корова") > 0) {
                Cow cow = new Cow();
                satiety += cow.getWeight();
                cow.deadFlag = true;
            }
            // лошадь, коза, овца
            else if ((currentCellMap.get("Утка") > 0)
                    || (currentCellMap.get("Олень") > 0)
                    || (currentCellMap.get("Заяц") > 0)) {
                int random = new Details().randomizer(1, 3);
                if (random == 1) {
                    // Ищем Лошадей
                    if (currentCellMap.get("Лошадь") > 0) {
                        Horse horse = new Horse();
                        satiety += horse.getWeight();
                        horse.deadFlag = true;
                    }
                } else if (random == 2) {
                    // Ищем коз
                    if (currentCellMap.get("Коза") > 0) {
                        // Съедает козу - 60% вероятностью
                        Goat goat = new Goat();
                        satiety += goat.getWeight();
                        goat.deadFlag = true;
                        eatFlag = true;
                    }
                } else {
                    // Ищем овец
                    if (currentCellMap.get("Овца") > 0) {
                        Sheep sheep = new Sheep();
                        satiety += sheep.getWeight();
                        sheep.deadFlag = true;
                    }
                }
            }
            // Ищем Кенгуру
            else if (currentCellMap.get("Кенгуру") > 0) {
                Kangaroo kangaroo = new Kangaroo();
                satiety += kangaroo.getWeight();
                kangaroo.deadFlag = true;
                eatFlag = true;
            }
            // змея, орел
            else if ((currentCellMap.get("Змея") > 0)
                    || (currentCellMap.get("Орел") > 0)) {

                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем Змей
                    if (currentCellMap.get("Змея") > 0) {
                        Snake snake = new Snake();
                        satiety += snake.getWeight();
                        snake.deadFlag = true;
                    }
                } else {
                    // Ищем орлов
                    if (currentCellMap.get("Орел") > 0) {
                        Eagle eagle = new Eagle();
                        eagle.die(locationLength, locationWidth, "Орел");
                        satiety += eagle.getWeight();
                        eagle.deadFlag = true;
                    }
                }
                eatFlag = true;
            }
            // волк, лиса
            else if ((currentCellMap.get("Волк") > 0)
                    || (currentCellMap.get("Лиса") > 0)) {

                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем Волков
                    if (currentCellMap.get("Волк") > 0) {
                        Wolf wolf = new Wolf();
                        satiety += wolf.getWeight();
                        wolf.deadFlag = true;
                    }
                } else {
                    // Ищем Лис
                    if (currentCellMap.get("Лиса") > 0) {
                        Fox fox = new Fox();
                        satiety += fox.getWeight();
                        fox.deadFlag = true;
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
        } else {
            // Если мы не поели, то сытость уменьшается
            if (satiety == 0) {
                hungryTactBeforeDie++;
                if (hungryTactBeforeDie == maxHungryTactBeforeDie) {
                    die(locationLength, locationWidth, "Волк");
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
        if (currentCellMap.get("Медведь") > 1) {
            // заодно проверяем на перенаселение этим видом
            // если уже перенаселен, то мы не будем размножаться
            int countThisAnimalTypeToCell = currentCellMap.get("Медведь");
            if (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell) {
                // Ну если уж размножились, то мы не можем регулировать размер выводка
                // выбираем количество потомства(рандомно от мин до мах-ма)
                for (int i = 0; i < details.randomizer(kidMinCount, kidMaxCount); i++) {
                    new Bear().firstBorn(locationLength, locationWidth);
                }
                return;
            }
        }

        // и еды нет и спариться не с кем, пойду отсюда...
        move(locationLength, locationWidth, speed, "Медведь");
    }


    public double getWeight() {
        return weight;
    }
}
