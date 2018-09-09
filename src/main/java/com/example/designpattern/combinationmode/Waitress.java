package com.example.designpattern.combinationmode;

import java.util.Iterator;

public class Waitress {

    private MenuCompent allMenuCompent;

    public Waitress(MenuCompent allMenuCompent) {
        this.allMenuCompent = allMenuCompent;
    }

    public void printMenu() {
        allMenuCompent.print();
    }

    public void printVegetarianMenu() {
        Iterator iterator = allMenuCompent.createIterator();
        while (iterator.hasNext()) {
            MenuCompent menuCompent = (MenuCompent) iterator.next();
            try {
                if (menuCompent.isVegetarian()) {
                    menuCompent.print();
                }
            } catch (UnsupportedOperationException e) {
            }
        }
    }
}
