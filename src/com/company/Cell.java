package com.company;

import com.company.Animals.*;
import com.company.Plants.Grass;
import com.company.Plants.Plants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cell {
    // Что, если мы тут будем вести список всех животных в формате:
    // вид животного и уникальное имя класса, чтобы можно было обращаться к ним
    // это можно сделать либо несколькими списками, (список медведей, список волков...)
    // или мапами (имя класса -- тип животного)

    public List<Bear> bearsListToCell = new ArrayList<>();
    public List<Cow> cowsListToCell = new ArrayList<>();
    public List<Deer> deerListToCell = new ArrayList<>();
    public List<Duck> ducksListToCell = new ArrayList<>();
    public List<Eagle> eaglesListToCell = new ArrayList<>();
    public List<Fox> foxesListToCell = new ArrayList<>();
    public List<Goat> goatsListToCell = new ArrayList<>();
    public List<Hamster> hamstersListToCell = new ArrayList<>();
    public List<Hare> haresListToCell = new ArrayList<>();
    public List<Horse> horsesListToCell = new ArrayList<>();
    public List<Kangaroo> kangaroosListToCell = new ArrayList<>();
    public List<Larva> larvaListToCell = new ArrayList<>();
    public List<Grass> grassListToCell = new ArrayList<>();
    public List<Sheep> sheepListToCell = new ArrayList<>();
    public List<Snake> snakesListToCell = new ArrayList<>();
    public List<Wolf> wolfsListToCell = new ArrayList<>();

    public String maxAnimalsFromCellSearchMethod() {
        int maxAnimalCount = 0;
        String maxName = "";
        if (maxAnimalCount < bearsListToCell.size()) {
            maxAnimalCount = bearsListToCell.size();
            maxName = "Медведь";
        }
        if (maxAnimalCount < ducksListToCell.size()) {
            maxAnimalCount = ducksListToCell.size();
            maxName = "Утка";
        }
        if (maxAnimalCount < cowsListToCell.size()) {
            maxAnimalCount = cowsListToCell.size();
            maxName = "Корова";
        }
        if (maxAnimalCount < deerListToCell.size()) {
            maxAnimalCount = deerListToCell.size();
            maxName = "Олень";
        }
        if (maxAnimalCount < eaglesListToCell.size()) {
            maxAnimalCount = eaglesListToCell.size();
            maxName = "Орел";
        }
        if (maxAnimalCount < foxesListToCell.size()) {
            maxAnimalCount = foxesListToCell.size();
            maxName = "Лиса";
        }
        if (maxAnimalCount < goatsListToCell.size()) {
            maxAnimalCount = goatsListToCell.size();
            maxName = "Козел";
        }
        if (maxAnimalCount < hamstersListToCell.size()) {
            maxAnimalCount = hamstersListToCell.size();
            maxName = "Хомяк";
        }
        if (maxAnimalCount < haresListToCell.size()) {
            maxAnimalCount = haresListToCell.size();
            maxName = "Заяц";
        }
        if (maxAnimalCount < horsesListToCell.size()) {
            maxAnimalCount = horsesListToCell.size();
            maxName = "Лошадь";
        }
        if (maxAnimalCount < kangaroosListToCell.size()) {
            maxAnimalCount = kangaroosListToCell.size();
            maxName = "Кенгуру";
        }
        if (maxAnimalCount < larvaListToCell.size()) {
            maxAnimalCount = larvaListToCell.size();
            maxName = "Гусеница";
        }
        // не будем учитывать травку
        /*if (maxAnimalCount < grassListToCell.size()) {
            maxAnimalCount = grassListToCell.size();
            maxName = "Трава";
        }*/
        if (maxAnimalCount < sheepListToCell.size()) {
            maxAnimalCount = sheepListToCell.size();
            maxName = "Овца";
        }
        if (maxAnimalCount < snakesListToCell.size()) {
            maxAnimalCount = snakesListToCell.size();
            maxName = "Змея";
        }
        if (maxAnimalCount < wolfsListToCell.size()) {
            maxAnimalCount = wolfsListToCell.size();
            maxName = "Волк";
        }

        return maxName;
    }
}
