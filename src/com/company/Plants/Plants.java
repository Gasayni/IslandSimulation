package com.company.Plants;

import com.company.Cell;
import com.company.ChangeableClass;
import com.company.Details;

public abstract class Plants {

    ChangeableClass changeableClass = new ChangeableClass();
    Details details = new Details();
    public static int locationLength;
    public static int locationWidth;
//    public boolean deadFlag = false;
    // мы создали новую мапу, чтобы изменить ее и отправить измененную мапу взамен старой
    Cell[][] cells = changeableClass.getCellMas();

    public void firstBorn(int locationLength, int locationWidth) {
        Plants.locationLength = locationLength;
        Plants.locationWidth = locationWidth;

        reproduction();
    }


    // Будет содержать поведение, общее для всех животных
    // Рождается
    public abstract void born(int locationLength, int locationWidth);

    // Проверка выход из острова
    public void bornToMove(int locationLength, int locationWidth) {
        // если животное ушло за границы острова, то оно умирает
        if (!(locationLength < 0 || locationLength > changeableClass.getLengthIsland() - 1
                || locationWidth < 0 || locationWidth > changeableClass.getWidthIsland() - 1)) {
            born(locationLength, locationWidth);
        }
    }

    // Размножается
    public abstract void reproduction();

    // Умирает
//    public abstract void die();
    public abstract void die(int locationLength, int locationWidth);
}
