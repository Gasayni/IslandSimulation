package com.company.Animals;

import com.company.Cell;
import com.company.ChangeableClass;
import com.company.Details;

/**
 * Травоядный хищник - это женщина на диете, днём жуёт морковку и сельдерей,
 * а по ночам совершает набеги на холодильник и точит колбаску, сосисочки и прочие вкусности.
 */
public abstract class Animal {
    ChangeableClass changeableClass = new ChangeableClass();
    Details details = new Details();
    Cell[][] cells = changeableClass.getCellMas();
    public static int locationLength;
    public static int locationWidth;
    // мы создали новую мапу, чтобы изменить ее и отправить измененную мапу взамен старой
    Cell cell = cells[locationLength][locationWidth];


    public void firstBorn(int locationLength, int locationWidth) {
        Animal.locationLength = locationLength;
        Animal.locationWidth = locationWidth;

        eat();
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

    // Кушает
    public abstract void eat();

    // Размножается
    public abstract void reproduction();

    // Двигается
    public void move(int locationLength, int locationWidth, int speed) {
        // телепортируемся
        die(locationLength, locationWidth);
        // мы берем текущее местоположение и двигаемся от него
        for (int i = 0; i < speed; i++) {
            if (details.randomMoveToCell().equals("up")) locationLength++;
            else if (details.randomMoveToCell().equals("down")) locationLength--;
            else if (details.randomMoveToCell().equals("left")) locationWidth--;
            else locationWidth++;
        }
        bornToMove(locationLength, locationWidth);
    }

    // Умирает
    public abstract void die(int locationLength, int locationWidth);
}
