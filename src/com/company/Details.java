package com.company;

import java.util.HashMap;
import java.util.Map;

public class Details {
    static Map<String, Integer> animalCountMap = new HashMap<>();
    static Map<String, Integer> oldAnimalCountMap = new HashMap<>();

    public String randomMoveToCell() {
        int n = (int) (Math.random() * 4) + 1;
        if (n == 1) return "left";
        else if (n == 2) return "right";
        else if (n == 3) return "up";
        else return "down";
    }

    public int randomizer(int fromNum, int untilNum) {
        return (int) (Math.random() * untilNum) + fromNum;
    }

    public void addAnimalCountMethod(Cell cell) {
        if (animalCountMap.isEmpty()) {
            cleanInitializeMethod();
            oldAnimalCountMap.putAll(animalCountMap);
        }

        animalCountMap.put("Медведь", animalCountMap.get("Медведь") + cell.bearsListToCell.size());
        animalCountMap.put("Волк", animalCountMap.get("Волк") + cell.wolfsListToCell.size());
        animalCountMap.put("Лиса", animalCountMap.get("Лиса") + cell.foxesListToCell.size());
        animalCountMap.put("Змея", animalCountMap.get("Змея") + cell.snakesListToCell.size());
        animalCountMap.put("Орел", animalCountMap.get("Орел") + cell.eaglesListToCell.size());
        animalCountMap.put("Гусеница", animalCountMap.get("Гусеница") + cell.larvaListToCell.size());
        animalCountMap.put("Утка", animalCountMap.get("Утка") + cell.ducksListToCell.size());
        animalCountMap.put("Баран", animalCountMap.get("Баран") + cell.sheepListToCell.size());
        animalCountMap.put("Козел", animalCountMap.get("Козел") + cell.goatsListToCell.size());
        animalCountMap.put("Заяц", animalCountMap.get("Заяц") + cell.haresListToCell.size());
        animalCountMap.put("Лошадь", animalCountMap.get("Лошадь") + cell.horsesListToCell.size());
        animalCountMap.put("Олень", animalCountMap.get("Олень") + cell.deerListToCell.size());
        animalCountMap.put("Кенгуру", animalCountMap.get("Кенгуру") + cell.kangaroosListToCell.size());
        animalCountMap.put("Хомяк", animalCountMap.get("Хомяк") + cell.hamstersListToCell.size());
        animalCountMap.put("Корова", animalCountMap.get("Корова") + cell.cowsListToCell.size());
        animalCountMap.put("Трава", animalCountMap.get("Трава") + cell.grassListToCell.size());
    }

    public void cleanInitializeMethod() {
        if (!animalCountMap.isEmpty()) {
            oldAnimalCountMap.clear();
            oldAnimalCountMap.putAll(animalCountMap);
        }
        animalCountMap.put("Медведь", 0);
        animalCountMap.put("Волк", 0);
        animalCountMap.put("Лиса", 0);
        animalCountMap.put("Змея", 0);
        animalCountMap.put("Орел", 0);
        animalCountMap.put("Гусеница", 0);
        animalCountMap.put("Утка", 0);
        animalCountMap.put("Баран", 0);
        animalCountMap.put("Козел", 0);
        animalCountMap.put("Заяц", 0);
        animalCountMap.put("Лошадь", 0);
        animalCountMap.put("Олень", 0);
        animalCountMap.put("Кенгуру", 0);
        animalCountMap.put("Хомяк", 0);
        animalCountMap.put("Корова", 0);
        animalCountMap.put("Трава", 0);
    }
}
