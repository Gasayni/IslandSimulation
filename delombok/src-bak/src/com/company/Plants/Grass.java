package com.company.Plants;

public class Grass extends Plants {
    // Растение обычное

    // Вес
    private final double weight = 1;
    // мах кол-во на одной клетке
    private final int maxCountThisAnimalTypeToCell = 10000;
    private final int kidMinCount = changeableClass.getGrassMinKidCount();
    private final int kidMaxCount = changeableClass.getGrassMaxKidCount();
    // скорость перемещения спор при размножении
    private final int speed = 1;
    public boolean deadFlag = false;

    @Override
    public void reproduction() {
        int countThisAnimalTypeToCell = currentCellMap.get("Трава");
        // сначала проверяем убит ли и заодно проверяем на перенаселение этим видом
        if (deadFlag || (countThisAnimalTypeToCell < maxCountThisAnimalTypeToCell)) {
            die(locationLength, locationWidth, "Трава");
            return;
        }

        // Размножение у нас бесполое, поэтому нам не нужны другие растения.
        // Но мы смотрим на общее кол-во растений в ячейке
        // споры могут отлететь ни на близлежащие ячейки
        for (int i = 0; i < details.randomizer(kidMinCount, kidMaxCount); i++) {
            int relocationLength = locationLength;
            int relocationWidth = locationWidth;
            // Рандомно на 1 клетку улетают споры
            for (int j = 0; j < speed; j++) {
                switch (details.randomMoveToCell()) {
                    case "up" -> relocationLength = relocationLength + 1;
                    case "down" -> relocationLength = relocationLength - 1;
                    case "left" -> relocationWidth = relocationWidth - 1;
                    default -> relocationWidth = relocationWidth + 1;
                }
            }
            new Grass().bornToMove(relocationLength, relocationWidth, "Трава");
        }

    }

    public double getWeight() {
        return weight;
    }
}
