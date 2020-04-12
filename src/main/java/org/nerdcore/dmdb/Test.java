package org.nerdcore.dmdb;

import org.apache.catalina.valves.CrawlerSessionManagerValve;
import org.nerdcore.dmdb.entity.GameEntities.Creature;

public class Test {

    public static void main(String[] args) {
        Creature c = new Creature();
        System.out.println(Creature.Alignment.LAWFUL);
    }
}
