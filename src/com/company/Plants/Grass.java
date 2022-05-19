package com.company.Plants;

import com.company.Cell;

public class Grass extends Plants {
    // Растение обычное
    Cell cell = cells[locationLength][locationWidth];

    // Вес
    public static final double weight = 1;
    // мах кол-во на одной клетке
    private static final int maxCountThisAnimalTypeToCell = 10000;
    private final int kidMinCount = changeableClass.getGrassMinKidCount();
    private final int kidMaxCount = changeableClass.getGrassMaxKidCount();
    // скорость перемещения спор при размножении
    private static final int speed = 1;

    @Override
    public void reproduction() {
        // сначала проверяем на перенаселение этим видом
        if (countThisAnimalTypeToCell >= maxCountThisAnimalTypeToCell) {
            die(locationLength, locationWidth);
            return;
        }

        // Размножение у нас бесполое, поэтому нам не нужны другие растения.
        // Но мы смотрим на общее кол-во растений в ячейке
        // споры могут отлететь ни на близлежащие ячейки
        int rand = details.randomizer(kidMinCount, kidMaxCount);
        for (int i = 0; i < rand; i++) {
            // треть спор остаются в этой локации
            if (i < rand/3) {
                born(locationLength, locationWidth);
            } else {
                // две трети спор улетают в близлежащие
                int relocationLength = locationLength;
                int relocationWidth = locationWidth;
                for (int j = 0; j < speed; j++) {
                    switch (details.randomMoveToCell()) {
                        case "up" -> relocationLength = relocationLength + 1;
                        case "down" -> relocationLength = relocationLength - 1;
                        case "left" -> relocationWidth = relocationWidth - 1;
                        case "right" -> relocationWidth = relocationWidth + 1;
                    }
                }
                bornToMove(relocationLength, relocationWidth); // Рандомно на 1 клетку улетают споры
            }
        }
    }

    @Override
    public void born(int locationLength, int locationWidth) {
        // То увеличиваем на 1
        cell = cells[locationLength][locationWidth];
        cell.grassListToCell.add(this);
    }

    @Override
    public void die(int locationLength, int locationWidth) {
        // то просто уменьшаем на 1
        cell = cells[locationLength][locationWidth];
        cell.grassListToCell.remove(this);
    }

    public double getWeight() {
        return weight;
    }
}
