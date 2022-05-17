package com.company.Plants;

import com.company.Cell;
import com.company.ChangeableClass;
import com.company.Details;
import com.company.FirstAdd;

import java.util.Map;

public abstract class Plants {

    ChangeableClass changeableClass = new ChangeableClass();
    Details details = new Details();
    public int locationLength;
    public int locationWidth;
    public boolean deadFlag = false;
    public boolean eatFlag = false;
    // мы создали новую мапу, чтобы изменить ее и отправить измененную мапу взамен старой
    FirstAdd firstAdd = new FirstAdd();
    Cell[][] cells = firstAdd.cellMas;
    Map<String, Integer> currentCellMap = cells[locationLength][locationWidth].getCellMap();

    public void firstBorn(int locationLength, int locationWidth) {
        this.locationLength = locationLength;
        this.locationWidth = locationWidth;
        born(locationLength, locationWidth, this.getClass().getName());
    }


    // Будет содержать поведение, общее для всех животных
    // Рождается
    public void born(int locationLength, int locationWidth, String nameAnimalClass) {
        // должен родиться в заданном месте на острове
        // мы создали новую мапу, чтобы изменить ее и отправить измененную мапу взамен старой
        cells[locationLength][locationWidth].increment(cells[locationLength][locationWidth].getCellMap(), nameAnimalClass);

        // должен родиться в заданном месте на острове
        /*cells[locationLength][locationWidth].getCellMap().put(nameAnimalClass,
                cells[locationLength][locationWidth].getCellMap().get(nameAnimalClass) + 1);
        changeableClass.setCellMas(cells);*/
    }

    // Проверка выход из острова
    public void bornToMove(int locationLength, int locationWidth, String nameAnimalClass) {
        // если животное ушло за границы острова, то оно умирает
        if (locationLength < 0 || locationLength > changeableClass.getLengthIsland() - 1
                || locationWidth < 0 || locationWidth > changeableClass.getWidthIsland() - 1) {
            die(locationLength, locationWidth, nameAnimalClass);
        } else born(locationLength, locationWidth, nameAnimalClass);
    }

    // Размножается
    public abstract void reproduction();

    // Умирает
//    public abstract void die();
    public void die(int locationLength, int locationWidth, String nameAnimalClass) {
        // то просто уменьшаем на 1
        cells[locationLength][locationWidth].decrement(cells[locationLength][locationWidth].getCellMap(), nameAnimalClass);

        /*cells[locationLength][locationWidth].getCellMap().put(nameAnimalClass,
                cells[locationLength][locationWidth].getCellMap().get(nameAnimalClass) - 1);
        changeableClass.setCellMas(cells);*/
    }
}
