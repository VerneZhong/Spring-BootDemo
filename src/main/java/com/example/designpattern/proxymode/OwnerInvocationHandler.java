package com.example.designpattern.proxymode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {

    private PersonBean personBean;

    public OwnerInvocationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("setHotOrNotRating".equals(method.getName())) {
            throw new IllegalArgumentException();
        } else {
            return method.invoke(personBean, args);
        }
    }
}
