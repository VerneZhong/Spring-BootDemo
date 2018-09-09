package com.example.designpattern.combinationmode;

import java.util.Iterator;
import java.util.Stack;

/**
 * 迭代器类
 */
public class CompositeIterator implements Iterator<MenuCompent> {

    private Stack<Iterator> stack = new Stack<>();


    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            Iterator iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public MenuCompent next() {
        if (hasNext()) {
            Iterator iterator = stack.peek();
            MenuCompent menuCompent = (MenuCompent) iterator.next();
            if (menuCompent instanceof Menu) {
                stack.push(menuCompent.createIterator());
            }
            return menuCompent;
        }
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
