package com.example.designpattern.combinationmode;

public class Main {

    public static void main(String[] args) {

        // 煎饼屋菜单
        MenuCompent pancakeHouseMenu = new Menu("煎饼屋菜单", "很多早餐煎饼");
        // 晚餐菜单
        MenuCompent dinerMenu = new Menu("晚餐菜单", "各式的川菜");
        // 咖啡菜单
        MenuCompent cafeMenu = new Menu("咖啡菜单", "很多咖啡种类");
        // 甜点菜单
        MenuCompent dessertMenu = new Menu("甜点菜单", "很多美味甜点");

        MenuCompent all = new Menu("所有菜品", "菜单，所有的菜式");
        all.add(pancakeHouseMenu);
        all.add(dinerMenu);
        all.add(cafeMenu);

        dinerMenu.add(new MenuItem("油焖大虾", "正宗潜江油焖大虾", 198.0, false));
        dinerMenu.add(new MenuItem("香辣蟹", "美味香辣蟹", 218.0, false));
        dinerMenu.add(new MenuItem("鱼香肉丝", "美味的鱼香肉丝", 28.0, false));
        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("西米露", "椰汁西米露", 15.0, false));
        dessertMenu.add(new MenuItem("珍珠奶茶", "珍珠奶茶", 12.0, false));
        dessertMenu.add(new MenuItem("芒果奶昔", "芒果奶昔", 18.0, false));

        pancakeHouseMenu.add(new MenuItem("煎饼果子", "正宗煎饼果子", 8.0, true));
        pancakeHouseMenu.add(new MenuItem("手抓饼", "正宗台湾手抓饼", 10.0, false));
        pancakeHouseMenu.add(new MenuItem("烤冷面", "正宗朝鲜烤冷面", 8.0, true));

        cafeMenu.add(new MenuItem("卡布奇诺", "卡布奇诺咖啡", 28.0, false));
        cafeMenu.add(new MenuItem("拿铁", "拿铁咖啡", 22.0, false));
        cafeMenu.add(new MenuItem("摩卡", "摩卡咖啡", 24.0, false));

        Waitress waitress = new Waitress(all);

        waitress.printMenu();
    }
}
