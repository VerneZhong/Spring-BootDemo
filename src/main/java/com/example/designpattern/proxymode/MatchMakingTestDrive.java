package com.example.designpattern.proxymode;

import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {

    public static void main(String[] args) {

        MatchMakingTestDrive drive = new MatchMakingTestDrive();
        drive.drive();

    }

    private void drive() {
        PersonBean joe = getPersonFromData("joe");
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("姓名： " + ownerProxy.getName());
        ownerProxy.setInterests("打游戏");
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("不能修改喜爱度");
        }
        System.out.println("喜爱度：" + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("姓名： " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setGender("男");
            nonOwnerProxy.setInterests("足球");
        } catch (Exception e) {
            System.out.println("无法修改其他人信息");
        }
        nonOwnerProxy.setHotOrNotRating(8);
        System.out.println("喜爱度：" + nonOwnerProxy.getHotOrNotRating());

    }

    private PersonBean getOwnerProxy(PersonBean joe) {
        return (PersonBean) Proxy.newProxyInstance(joe.getClass().getClassLoader(), joe.getClass().getInterfaces(), new OwnerInvocationHandler(joe));
    }

    private PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new NonOwnerInvacationHandler(personBean));
    }

    private PersonBean getPersonFromData(String joe) {
        PersonBean personBean = new PersonBeanImpl();
        personBean.setName(joe);
        return personBean;
    }
}
