package com.company;

import com.company.Animals.*;
import com.company.Plants.Grass;

import java.util.Map;
import java.util.stream.Collectors;

public class FirstAdd {
    ChangeableClass changeableClass = new ChangeableClass();
    Details details = new Details();
    public Cell[][] cellMas = changeableClass.getCellMas();
    int lengthRandomIndex;
    int widthRandomIndex;
    Main main = new Main();


    public FirstAdd() {
        // создаем каждую ячейку
        for (int i = 0; i < changeableClass.getLengthIsland(); i++) {
            for (int j = 0; j < changeableClass.getWidthIsland(); j++) {
                Cell cell = new Cell();
                cellMas[i][j] = cell;
                cellMas[i][j].inicialized();
            }
        }


        // Тут впервые разбрасываем всех животных по ячейкам
        for (int i = 0; i < changeableClass.countAnimals(); i++) {
            // Пока не достигло мах количества этого животного на старте симуляции.
            // Добавляем Волков.
            if (i < changeableClass.getWolfCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Волк");
            }
            // Добавляем Змей
            if (i < changeableClass.getSnakeCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Змея");
            }
            // Добавляем Лис
            if (i < changeableClass.getFoxCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Лиса");
            }
            // Добавляем Медведей
            if (i < changeableClass.getBearCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Медведь");
            }
            // Добавляем Орлов
            if (i < changeableClass.getEagleCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Орел");
            }
            // Добавляем Лошадей
            if (i < changeableClass.getHorseCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Лошадь");
            }
            // Добавляем Оленей
            if (i < changeableClass.getDeerCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Олень");
            }
            // Добавляем Зайцев
            if (i < changeableClass.getHareCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Заяц");
            }
            // Добавляем Хомяков
            if (i < changeableClass.getHamsterCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Хомяк");
            }
            // Добавляем Коз
            if (i < changeableClass.getGoatCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Коза");
            }
            // Добавляем Овец
            if (i < changeableClass.getSheepCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Овца");
            }
            // Добавляем Коров
            if (i < changeableClass.getCowCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Корова");
            }
            // Добавляем Уток
            if (i < changeableClass.getDuckCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Утка");
            }
            // Добавляем Гусениц
            if (i < changeableClass.getLarvaCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Гусеница");
            }
            // Добавляем Растения
            if (i < changeableClass.getGrassCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Трава");
            }
            // Добавляем Кенгуру
            if (i < changeableClass.getKangarooCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                Map<String, Integer> mapCell = cellMas[lengthRandomIndex][widthRandomIndex].getCellMap();
                cellMas[lengthRandomIndex][widthRandomIndex].increment(mapCell, "Кенгуру");
            }
        }

//        // Предварительный вывод
//        System.out.println("Предварительный вывод");
//        for (int i = 0; i < changeableClass.getLengthIsland(); i++) {
//            for (int j = 0; j < changeableClass.getWidthIsland(); j++) {
//                // заодно в каждой ячейке ищем животного с мах-ой популяцией(для смайлика)
//                String maxPopulationAnimalName = cellMas[i][j].getCellMap()
//                        .entrySet()
//                        .stream()
//                        .max(Map.Entry.comparingByValue())
//                        .map(Map.Entry::getKey)
//                        .stream().collect(Collectors.joining());
//                // заполняем массив смайликами
//                main.smilesMass[i][j] = main.smileGenerate(maxPopulationAnimalName);
//            }
//        }
//        main.print();

    }
}
