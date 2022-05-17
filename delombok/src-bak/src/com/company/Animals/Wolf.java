package com.company.Animals;

import com.company.Details;

public class Wolf extends Predator {
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
    private final double weight = 50;
    // мах кол-во животных на одной клетке
    private final int maxCountThisAnimalTypeToCell = 30;
    private final int kidMinCount = changeableClass.getWolfKidMinCount();
    private final int kidMaxCount = changeableClass.getWolfKidMaxCount();
    // Скорость перемещения. На сколько клеток можно передвинуться за один такт
    private final int speed = 3;
    // Мах уровень сытости/насыщения
    private final int maxSatiety = 8;
    private double satiety = maxSatiety;
    // (мах шкала выживаемости) Сколько ходов (тактов) животное может жить после падения шкалы сытости до нуля
    private final int maxHungryTactBeforeDie = 10;
    // текущая шкала выживаемости после падения шкалы сытости до нуля
    private int hungryTactBeforeDie = 0;


    @Override
    public void eat() {
        int countThisAnimalTypeToCell = currentCellMap.get("Волк");
        // сначала проверяем убит ли и заодно проверяем на перенаселение этим видом
        if (deadFlag || (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell)) {
            die(locationLength, locationWidth, "Волк");
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
            // Ищем уток
            if (currentCellMap.get("Утка") > 0) {
                Duck duck = new Duck();
                satiety += duck.getWeight();
                duck.deadFlag = true;
            }
            // Ищем: овцы и зайцы съедаются с одинаковой вероятностью 70%
            else if ((currentCellMap.get("Овца") > 0)
                    || (currentCellMap.get("Заяц") > 0)) {

                // У нас овцы и зайцы съедаются с одинаковой вероятностью
                // Поэтому включаем рандомайзер
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем овец
                    if (currentCellMap.get("Овца") > 0) {
                        Sheep sheep = new Sheep();
                        satiety += sheep.getWeight();
                        sheep.deadFlag = true;
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
            // Ищем коз
            else if (currentCellMap.get("Коза") > 0) {
                // Съедает козу - 60% вероятностью
                Goat goat = new Goat();
                satiety += goat.getWeight();
                goat.deadFlag = true;
                eatFlag = true;
            }
            // Ищем оленя
            else if (currentCellMap.get("Олень") > 0) {
                Deer deer = new Deer();
                satiety += deer.getWeight();
                deer.deadFlag = true;
                eatFlag = true;
            }
            // Ищем: лошади и коровы съедаются с одинаковой вероятностью 30%
            else if ((currentCellMap.get("Лошадь") > 0)
                    || (currentCellMap.get("Корова") > 0)) {
                // У нас лошади и коровы съедаются с одинаковой вероятностью
                // Поэтому включаем рандомайзер
                int random = new Details().randomizer(1, 2);
                if (random == 1) {
                    // Ищем Лошадей
                    if (currentCellMap.get("Лошадь") > 0) {
                        Horse horse = new Horse();
                        satiety += horse.getWeight();
                        horse.deadFlag = true;
                    }
                } else {
                    // Ищем Коров
                    if (currentCellMap.get("Корова") > 0) {
                        Cow cow = new Cow();
                        satiety += cow.getWeight();
                        cow.deadFlag = true;
                    }
                }
                eatFlag = true;
            }
            // Ищем Кенгуру
            else if (currentCellMap.get("Кенгуру") > 0) {
                Kangaroo kangaroo = new Kangaroo();
                satiety += kangaroo.getWeight();
                kangaroo.deadFlag = true;
                eatFlag = true;
            }
            // Ищем: змеи, лисы, орлы съедаются с одинаковой вероятностью 10%
            else if ((currentCellMap.get("Змея") > 0)
                    || (currentCellMap.get("Лиса") > 0)
                    || (currentCellMap.get("Орел") > 0)) {

                // У нас змеи, лисы и орлы съедаются с одинаковой вероятностью
                // Поэтому включаем рандомайзер
                int random = new Details().randomizer(1, 3);
                if (random == 1) {
                    if (currentCellMap.get("Змея") > 0) {
                        Snake snake = new Snake();
                        satiety += snake.getWeight();
                        snake.deadFlag = true;
                    }
                } else if (random == 2) {
                    if (currentCellMap.get("Лиса") > 0) {
                        Fox fox = new Fox();
                        satiety += fox.getWeight();
                        fox.deadFlag = true;
                    }
                } else {
                    if (currentCellMap.get("Орел") > 0) {
                        Eagle eagle = new Eagle();
                        eagle.die(locationLength, locationWidth, "Орел");
                        satiety += eagle.getWeight();
                        eagle.deadFlag = true;
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
        if (currentCellMap.get("Волк") > 1) {
            // заодно проверяем на перенаселение этим видом
            // если уже перенаселен, то мы не будем размножаться
            int countThisAnimalTypeToCell = currentCellMap.get("Волк");
            if (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell) {
                // Ну если уж размножились, то мы не можем регулировать размер выводка
                // выбираем количество потомства(рандомно от мин до мах-го)
                for (int i = 0; i < details.randomizer(kidMinCount, kidMaxCount); i++) {
                    new Wolf().firstBorn(locationLength, locationWidth);
                }
                return;
            }
        }

        // и еды нет и спариться не с кем, пойду отсюда...
        move(locationLength, locationWidth, speed, "Волк");
    }

    public double getWeight() {
        return weight;
    }
}
