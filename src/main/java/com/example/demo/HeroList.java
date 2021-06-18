package com.example.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.ZonedDateTime;
import java.util.*;


@Component
public class HeroList {

    private Map<Integer, Hero> heroMap = new HashMap<>();
    public static long noOfGets = 0;
    public static long noOfUpdates = 0;
    public static ZonedDateTime lastGetTime ;
    public static ZonedDateTime lastUpdateTime ;

    @PostConstruct
    public void afterStartup() {
        heroMap.put(1, Hero.of("Saurabh", 1, 1));
        heroMap.put(2, Hero.of("Anirudh", 2, 2));
        heroMap.put(3, Hero.of("Kanha", 3, 3));
        heroMap.put(4, Hero.of("Rishi", 4, 4));
        heroMap.put(5, Hero.of("Yoyo", 5, 5));
        heroMap.put(6, Hero.of("BNB", 6, 6));
        heroMap.put(7, Hero.of("IIM-U", 7, 7));
        lastGetTime = ZonedDateTime.now();
        lastUpdateTime = ZonedDateTime.now();
    }

    public List<Hero> getList(){ noOfGets++; lastGetTime = ZonedDateTime.now(); return new ArrayList<>(heroMap.values()); }

    public Hero getHero(Integer id){ return this.heroMap.get(id); }

    public boolean updateHero(Hero hero){
        noOfUpdates++; lastUpdateTime = ZonedDateTime.now();
        this.heroMap.put(hero.getId(),hero);
        return true;
    }

    public boolean addHero(Hero hero){
        noOfUpdates++; lastUpdateTime = ZonedDateTime.now();
        int newId = this.heroMap.entrySet().isEmpty() ? 1 : this.heroMap.keySet().stream().max(Integer::compare).get() + 1;
        this.heroMap.put(newId,hero);
        return true;
    }
}
