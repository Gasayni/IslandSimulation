package com.company;

import java.io.IOException;
import java.util.Map;

public class Main {
    ChangeableClass changeableClass = new ChangeableClass();

    int lengthIsland = changeableClass.getLengthIsland();
    int widthIsland = changeableClass.getWidthIsland();
    public String[][] smilesMass = new String[lengthIsland][widthIsland];
    // Создадим двумерный массив с рисунками наиболее многочисленными животными в ячейке
    // т.е. Если в ячейке больше всего зайцев, то ячейка примет рисунок зайца, если там ничего нет, то "-"

    public static void main(String[] args) throws IOException, InterruptedException {
        new FirstAdd();
        new CallPull();
    }

    public String smileGenerate(String s) {
        // Тут мы будем проверять на совпадение животного с мах-ой популяцией
//        System.out.println(s);
        return switch (s) {
            case "Волк" -> "\uD83D\uDC3A";
            case "Медведь" -> "\uD83D\uDC3B";
            case "Змея" -> "\uD83D\uDC0D";
            case "Лиса" -> "\uD83E\uDD8A";
            case "Орел" -> "\uD83E\uDD85";
            case "Лошадь" -> "\uD83D\uDC0E";
            case "Олень" -> "\uD83E\uDD8C";
            case "Заяц" -> "\uD83D\uDC07";
            case "Хомяк" -> "\uD83D\uDC39";
            case "Коза" -> "\uD83D\uDC10";
            case "Овца" -> "\uD83D\uDC11";
            case "Кенгуру" -> "\uD83E\uDD98";
            case "Корова" -> "\uD83D\uDC2E";
            case "Утка" -> "\uD83E\uDD86";
            case "Гусеница" -> "\uD83D\uDC1B";
            case "Трава" -> "\uD83C\uDF3F";
            default -> "-";
        };
    }

    public void print(int step, Map<String, Integer> oldAnimalCountMap, Map<String, Integer> animalCountMap) {
        // Псевдографика

        System.out.println("Шаг: " + step);
        System.out.print("Медведей(было/стало): " + oldAnimalCountMap.get("Медведь")
                + "/" + animalCountMap.get("Медведь") + "\t\t");
        System.out.print("Волков(было/стало): " + oldAnimalCountMap.get("Волк")
                + "/" + animalCountMap.get("Волк") + "\t\t");
        System.out.print("Хомяков(было/стало): " + oldAnimalCountMap.get("Хомяк")
                + "/" + animalCountMap.get("Хомяк") + "\t");
        System.out.println("Трава(было/стало): " + oldAnimalCountMap.get("Трава")
                + "/" + animalCountMap.get("Трава"));
        // теперь выводим непосредственно двумерный массив из смайликов
        for (int i = 0; i < lengthIsland-1; i++) {
            for (int j = 0; j < widthIsland-1; j++) {
                System.out.print(smilesMass[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n");

        // Нужно очистить поле
    }
}
