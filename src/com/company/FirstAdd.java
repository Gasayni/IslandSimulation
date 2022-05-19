package com.company;

import com.company.Animals.*;
import com.company.Plants.Grass;

public class FirstAdd {
    ChangeableClass changeableClass = new ChangeableClass();
    Details details = new Details();
    public Cell[][] cellMas = changeableClass.getCellMas();
    int lengthRandomIndex;
    int widthRandomIndex;

    public FirstAdd() {
        // создаем каждую ячейку
        for (int i = 0; i < changeableClass.getLengthIsland(); i++) {
            for (int j = 0; j < changeableClass.getWidthIsland(); j++) {
                Cell cell = new Cell();
                cellMas[i][j] = cell;
            }
        }
//        cellMas[0][0].bearsListToCell.add(new Bear());
//        cellMas[0][0].bearsListToCell.add(new Bear());

        // Тут впервые разбрасываем всех животных по ячейкам
        for (int i = 0; i < ChangeableClass.countAnimalsMethod(); i++) {
            // Добавляем Волков.
            if (i < changeableClass.getWolfCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                // Здесь мы создаем объекты впервые, чтобы в дальнейшем обращаться к ним
                cellMas[lengthRandomIndex][widthRandomIndex].wolfsListToCell.add(new Wolf());
            }
            // Добавляем Змей
            if (i < changeableClass.getSnakeCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].snakesListToCell.add(new Snake());
            }
            // Добавляем Лис
            if (i < changeableClass.getFoxCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].foxesListToCell.add(new Fox());
            }
            // Добавляем Медведей
            if (i < changeableClass.getBearCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].bearsListToCell.add(new Bear());
            }
            // Добавляем Орлов
            if (i < changeableClass.getEagleCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].eaglesListToCell.add(new Eagle());
            }
            // Добавляем Лошадей
            if (i < changeableClass.getHorseCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].horsesListToCell.add(new Horse());
            }
            // Добавляем Оленей
            if (i < changeableClass.getDeerCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].deerListToCell.add(new Deer());
            }
            // Добавляем Зайцев
            if (i < changeableClass.getHareCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].haresListToCell.add(new Hare());
            }
            // Добавляем Хомяков
            if (i < changeableClass.getHamsterCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].hamstersListToCell.add(new Hamster());
            }
            // Добавляем Коз
            if (i < changeableClass.getGoatCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].goatsListToCell.add(new Goat());
            }
            // Добавляем Овец
            if (i < changeableClass.getSheepCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].sheepListToCell.add(new Sheep());
            }
            // Добавляем Коров
            if (i < changeableClass.getCowCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].cowsListToCell.add(new Cow());
            }
            // Добавляем Уток
            if (i < changeableClass.getDuckCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].ducksListToCell.add(new Duck());
            }
            // Добавляем Гусениц
            if (i < changeableClass.getLarvaCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].larvaListToCell.add(new Larva());
            }
            // Добавляем Растения
            if (i < changeableClass.getGrassCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].grassListToCell.add(new Grass());
            }
            // Добавляем Кенгуру
            if (i < changeableClass.getKangarooCountStart()) {
                // рандомно выбираем ячейку на острове
                lengthRandomIndex = details.randomizer(0, changeableClass.getLengthIsland() - 1);
                widthRandomIndex = details.randomizer(0, changeableClass.getWidthIsland() - 1);
                cellMas[lengthRandomIndex][widthRandomIndex].kangaroosListToCell.add(new Kangaroo());
            }
        }

        // Предварительный вывод
        /*Main main = new Main();
        for (int i = 0; i < changeableClass.getLengthIsland(); i++) {
            for (int j = 0; j < changeableClass.getWidthIsland(); j++) {
                // кладем кол-во животных в метод(нужно для вывода)
                details.addAnimalCountMethod(cellMas[i][j]);

                // в каждой ячейке ищем животного с мах-ой популяцией(для смайлика)
                String maxPopulationAnimalName = cellMas[i][j].maxAnimalsFromCellSearchMethod();
                main.smilesMass[i][j] = main.smileGenerate(maxPopulationAnimalName);
            }
        }
        main.print(0, Details.oldAnimalCountMap, Details.animalCountMap);
        details.cleanInitializeMethod();*/
    }
}
