package com.company.Animals;

import com.company.Cell;
import com.company.ChangeableClass;
import com.company.Details;
import com.company.FirstAdd;

import java.util.Map;

/**
 * Травоядный хищник - это женщина на диете, днём жуёт морковку и сельдерей,
 * а по ночам совершает набеги на холодильник и точит колбаску, сосисочки и прочие вкусности.
 */
public abstract class Animal {
    ChangeableClass changeableClass = new ChangeableClass();
    Details details = new Details();
    FirstAdd firstAdd = new FirstAdd();
    Cell[][] cells = firstAdd.cellMas;
    public int locationLength;
    public int locationWidth;
    public boolean deadFlag = false;
    public boolean eatFlag = false;
    // мы создали новую мапу, чтобы изменить ее и отправить измененную мапу взамен старой
    Map<String, Integer> currentCellMap = cells[locationLength][locationWidth].getCellMap();

    public void firstBorn(int locationLength, int locationWidth) {
        this.locationLength = locationLength;
        this.locationWidth = locationWidth;

        eat();
    }


    // Будет содержать поведение, общее для всех животных
    // Рождается
    public void born(int locationLength, int locationWidth, String nameAnimalClass) {
        // должен родиться в заданном месте на острове
//        cells[locationLength][locationWidth].increment(cells[locationLength][locationWidth].getCellMap(), nameAnimalClass);

        cells[locationLength][locationWidth].getCellMap().put(nameAnimalClass,
                cells[locationLength][locationWidth].getCellMap().get(nameAnimalClass) + 1);
        changeableClass.setCellMas(cells);
    }

    // Проверка выход из острова
    public void bornToMove(int locationLength, int locationWidth, String nameAnimalClass) {
        // если животное ушло за границы острова, то оно умирает
        if (locationLength < 0 || locationLength > changeableClass.getLengthIsland() - 1
                || locationWidth < 0 || locationWidth > changeableClass.getWidthIsland() - 1) {
            die(locationLength, locationWidth, nameAnimalClass);
        } else born(locationLength, locationWidth, nameAnimalClass);
    }

    // Кушает
    public abstract void eat();

    // Размножается
    public abstract void reproduction();

    // Двигается
    public void move(int locationLength, int locationWidth, int speed, String nameAnimalClass) {
        // телепортируемся
        die(locationLength, locationWidth, nameAnimalClass);
        // мы берем текущее местоположение и двигаемся от него
        for (int i = 0; i < speed; i++) {
            if (details.randomMoveToCell().equals("up")) locationLength++;
            else if (details.randomMoveToCell().equals("down")) locationLength--;
            else if (details.randomMoveToCell().equals("left")) locationWidth--;
            else locationWidth++;
        }
        bornToMove(locationLength, locationWidth, nameAnimalClass);
    }

    // Умирает
//    public abstract void die();
    public void die(int locationLength, int locationWidth, String nameAnimalClass) {
        // то просто уменьшаем на 1
//        cells[locationLength][locationWidth].decrement(cells[locationLength][locationWidth].getCellMap(), nameAnimalClass);

        cells[locationLength][locationWidth].getCellMap().put(nameAnimalClass,
                cells[locationLength][locationWidth].getCellMap().get(nameAnimalClass) - 1);
        changeableClass.setCellMas(cells);
    }
}
