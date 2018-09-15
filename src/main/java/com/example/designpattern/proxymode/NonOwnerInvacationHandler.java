package com.example.designpattern.proxymode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NonOwnerInvacationHandler implements InvocationHandler {

    private PersonBean personBean;

    public NonOwnerInvacationHandler(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("setHotOrNotRating".equals(method.getName())) {
            return method.invoke(personBean, args);
        } else if (method.getName().startsWith("get")) {
            return method.invoke(personBean, args);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
