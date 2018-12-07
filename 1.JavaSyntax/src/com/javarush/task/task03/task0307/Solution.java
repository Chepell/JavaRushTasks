package com.javarush.task.task03.task0307;

/* 
Привет Starcraft!
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Zerg zerg01 = new Zerg();
        zerg01.name = "z01";
        Zerg zerg02 = new Zerg();
        zerg02.name = "z02";
        Zerg zerg03 = new Zerg();
        zerg03.name = "z03";
        Zerg zerg04 = new Zerg();
        zerg04.name = "z04";
        Zerg zerg05 = new Zerg();
        zerg05.name = "z05";

        Protoss prot01 = new Protoss();
        prot01.name = "p01";
        Protoss prot02 = new Protoss();
        prot02.name = "p02";
        Protoss prot03 = new Protoss();
        prot03.name = "p03";

        Terran terr01 = new Terran();
        terr01.name = "t01";
        Terran terr02 = new Terran();
        terr02.name = "t02";
        Terran terr03 = new Terran();
        terr03.name = "t03";
        Terran terr04 = new Terran();
        terr04.name = "t04";
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
