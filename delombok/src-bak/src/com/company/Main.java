package com.company;

import com.company.Animals.*;
import com.company.Plants.Grass;

import java.io.IOException;

public class Main {
    public ChangeableClass changeableClass = new ChangeableClass();
    int lengthIsland = changeableClass.getLengthIsland();
    int widthIsland = changeableClass.getWidthIsland();
    public String[][] smilesMass = new String[lengthIsland][widthIsland];
    // Создадим двумерный массив с рисунками наиболее многочисленными животными в ячейке
    // т.е. Если в ячейке больше всего зайцев, то ячейка примет рисунок зайца, если там ничего нет, то "-"

    public static void main(String[] args) {
        new CallPull();
//        new Main().print();
    }

    public String smileGenerate(String s) {
        // Тут мы будем проверять на совпадение животного с мах-ой популяцией
//        System.out.println(s);
        if (s.equals("Волк")) return "\uD83D\uDC3A";
        else if (s.equals("Медведь")) return "\uD83D\uDC3B";
        else if (s.equals("Змея")) return "\uD83D\uDC0D";
        else if (s.equals("Лиса")) return "\uD83E\uDD8A";
        else if (s.equals("Орел")) return "\uD83E\uDD85";
        else if (s.equals("Лошадь")) return "\uD83D\uDC0E";
        else if (s.equals("Олень")) return "\uD83E\uDD8C";
        else if (s.equals("Заяц")) return "\uD83D\uDC07";
        else if (s.equals("Хомяк")) return "\uD83D\uDC39";
        else if (s.equals("Коза")) return "\uD83D\uDC10";
        else if (s.equals("Овца")) return "\uD83D\uDC11";
        else if (s.equals("Кенгуру")) return "\uD83E\uDD98";
        else if (s.equals("Корова")) return "\uD83D\uDC2E";
        else if (s.equals("Утка")) return "\uD83E\uDD86";
        else if (s.equals("Гусеница")) return "\uD83D\uDC1B";
        else if (s.equals("Трава")) return "\uD83C\uDF3F";
        else return "-";
    }

    public void print() {
        // Псевдографика

        System.out.println("\n\n");
        for (int i = 0; i < lengthIsland - 1; i++) {
            for (int j = 0; j < widthIsland; j++) {
                System.out.print(smilesMass[i][j]);
            }
            System.out.println();
        }



    }
}
