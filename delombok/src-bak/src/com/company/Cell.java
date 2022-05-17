package com.company;

import com.company.Animals.*;
import com.company.Plants.Grass;

import java.util.HashMap;
import java.util.Map;

public class Cell {
    private Map<String, Integer> cellMap = new HashMap<>();

    public void inicialized() {
        cellMap.put("Медведь", 0);
        cellMap.put("Корова", 0);
        cellMap.put("Олень", 0);
        cellMap.put("Утка", 0);
        cellMap.put("Орел", 0);
        cellMap.put("Лиса", 0);
        cellMap.put("Коза", 0);
        cellMap.put("Хомяк", 0);
        cellMap.put("Заяц", 0);
        cellMap.put("Лошадь", 0);
        cellMap.put("Кенгуру", 0);
        cellMap.put("Гусеница", 0);
        cellMap.put("Трава", 0);
        cellMap.put("Овца", 0);
        cellMap.put("Змея", 0);
        cellMap.put("Волк", 0);
    }



    public Map<String, Integer> getCellMap() {
        return cellMap;
    }
//    public void setCellMap(Map<String, Integer> cellMap) {
//        this.cellMap = cellMap;
//    }

    public void increment(Map<String, Integer> map, String key) {
//        map.put(key, map.get(key) + 1);

        cellMap.put(key, cellMap.get(key) + 1);
    }

    public void decrement(Map<String, Integer> map, String key) {
//        map.put(key, map.get(key) - 1);

        cellMap.put(key, cellMap.get(key) - 1);
    }
}
