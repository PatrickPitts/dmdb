package org.nerdcore.dmdb.controller;

import org.nerdcore.dmdb.entity.GameEntities.Creature;
import org.nerdcore.dmdb.entity.GameEntities.CreatureAbility;
import org.nerdcore.dmdb.entity.GameEntities.GameEntity;
import org.nerdcore.dmdb.entity.GameEntities.Item;
import org.nerdcore.dmdb.repository.AbilityRepository;
import org.nerdcore.dmdb.repository.GameEntityRepository;
import org.nerdcore.dmdb.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    AbilityRepository abilityRepository;

    @Autowired
    GameEntityRepository gameEntityRepository;

    @GetMapping(value = "/" )
    public ResponseEntity<Creature> getTest(){

        Item item = new Item();
        item.setDescription("A sword");
        item.setItemName("Longsword");
        item.setRarity("Common");
        item.setItemType("Weapon");
        item.setSourceBook("Player's Handbook");
        item.setSourceBookPage(100);


        Creature creature = new Creature();
        creature.setChallengeRating(0.5);
        creature.setCreatureName("Goblin");
        creature.addAbility(new CreatureAbility("Stab", "Stab a guy", CreatureAbility.AbilityType.ACTION, creature));

        Creature c = gameEntityRepository.findAllCreatures().get(0);

        return ResponseEntity.ok(c);
    }
}
