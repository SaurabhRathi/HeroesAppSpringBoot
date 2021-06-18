package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    HeroList heroList;

    @RequestMapping(value="/env",method = RequestMethod.GET)
    public ResponseEntity<Map> getEnv(){
        Map<String,Object> m = new HashMap<>();
        m.put("noOfGets",HeroList.noOfGets);
        m.put("noOfUpdates",HeroList.noOfUpdates);
        m.put("lastGetTime",HeroList.lastGetTime);
        m.put("lastUpdateTime",HeroList.lastUpdateTime);
        return ResponseEntity.ok(m);
    }


    @RequestMapping(value="/heroes", method = RequestMethod.GET)
    public ResponseEntity< List<Hero>> getHeroes(){
        return ResponseEntity.ok(heroList.getList());
    }

    @RequestMapping(value="/heroes", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateHero(@RequestBody Hero hero){ return ResponseEntity.ok(heroList.updateHero(hero)); }

    @RequestMapping(value="/heroes", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addHero(@RequestBody Hero hero){
        return ResponseEntity.ok(heroList.addHero(hero));
    }

}
