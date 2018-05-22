package com.konovalov.menu;


public class App 
{
    private static MenuUtil util= new MenuUtil();
    public static void main( String[] args )    {

        util.add();
        util.addFast(new Menu("kalbasaOne", 50, 200, 0));
        util.addFast(new Menu("kalbasaTho", 650, 200, 0));
        util.addFast(new Menu("kalbasaThree", 100, 200, 15));
        util.addFast(new Menu("kalbasaFour", 100, 200, 10));
        util.addFast(new Menu("kalbasaFive", 100, 200, 0));

        util.wiewCountFromTo();
        util.wiewDiscount();

        util.wiewWeight();
        util.close();
    }
}
