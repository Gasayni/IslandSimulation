package com.company;

import com.company.Animals.*;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CallPull {
    Main main = new Main();
    ChangeableClass changeableClass = new ChangeableClass();
    int lengthIsland = changeableClass.getLengthIsland();
    int widthIsland = changeableClass.getWidthIsland();
    int countCellIsland = lengthIsland * widthIsland;
    FirstAdd firstAdd = new FirstAdd();
    Cell[][] cells = firstAdd.cellMas;
    // Создадим двумерный массив для вывода смайликов

    public CallPull() {
        // создаем фиксированное кол-во потоков, равное количеству ячеек острова
        ExecutorService executorService = Executors.newFixedThreadPool(countCellIsland);
        // симуляция живет пока... мы не нажмем на интер
        boolean exitFlag = true;
        while (exitFlag) {
            int wolfAbsentFlag = 0;
            for (int i = 0; i < lengthIsland; i++) {
                for (int j = 0; j < widthIsland; j++) {
                    executorService.execute(new Task(i, j));
                    // если после очередного такта симуляции в ячейке нет волков,
                    // то говорим, что еще в одной ячейке не найдены волки(условие остановки симуляции)
                    if (cells[i][j].getCellMap().get("Волк") == 0) {
                        wolfAbsentFlag++;
                    }


                    // заодно в каждой ячейке ищем животного с мах-ой популяцией(для смайлика)
                    String maxPopulationAnimalName = cells[i][j].getCellMap()
                            .entrySet()
                            .stream()
                            .max(Map.Entry.comparingByValue())
                            .map(Map.Entry::getKey)
                            .stream().collect(Collectors.joining());
                    // заполняем массив смайликами
                    main.smilesMass[i][j] = main.smileGenerate(maxPopulationAnimalName);
                }
            }
            // Выводим смайлики после каждого такта
            main.print();

            // если, допустим, волков не останется вообще, то завершаем симуляцию
            if (wolfAbsentFlag == countCellIsland) {
                exitFlag = false;
            }
        }
        executorService.shutdown();
    }
}
