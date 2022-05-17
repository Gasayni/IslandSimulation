package com.company;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CallPull {
    Main main = new Main();
    ChangeableClass changeableClass = new ChangeableClass();
    int lengthIsland = changeableClass.getLengthIsland();
    int widthIsland = changeableClass.getWidthIsland();
    Cell[][] cellMas = changeableClass.getCellMas();
    Details details = new Details();
    // Создадим двумерный массив для вывода смайликов

    public CallPull() throws IOException, InterruptedException {
        // создаем фиксированное кол-во потоков, равное количеству ячеек острова
//         ExecutorService executorService = Executors.newFixedThreadPool(countCellIsland);
//         ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        int step = 0;
        while (step < changeableClass.getMaxStep()) {
            step++;
            for (int i = 0; i < lengthIsland; i++) {
                for (int j = 0; j < widthIsland; j++) {
                    executorService.execute(new Task(i, j));

                    // в каждой ячейке ищем животного с мах-ой популяцией(для смайлика)
                    String maxPopulationAnimalName = cellMas[i][j].maxAnimalsFromCellSearchMethod();
                    main.smilesMass[i][j] = main.smileGenerate(maxPopulationAnimalName);

                    // кладем кол-во животных в метод(нужно для вывода)
                    details.addAnimalCountMethod(cellMas[i][j]);
                }
            }
            // Здесь мы задаем длительность такта симуляции (в секундах)
            // Каждый поток, после выполнения всей работы замрет длительность такта
            try {
                TimeUnit.SECONDS.sleep(changeableClass.getLongTactSimulation());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Посмотрим сколько животных осталось всего.
            // Выводим массив из смайликов после каждого такта
            main.print(step, Details.oldAnimalCountMap, Details.animalCountMap);
            details.cleanInitializeMethod();
        }
        executorService.shutdown();
    }
}
