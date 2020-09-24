package org.nerdcore.dmdb.controller;

import org.nerdcore.dmdb.entity.GameEntities.GameMapWithDescriptors;
import org.nerdcore.dmdb.repository.GameMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.ReactiveSortHandlerMethodArgumentResolver;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GameMapController {

    @Autowired
    GameMapRepository gmr;

    @RequestMapping("/gamemap/{mapname}")
    public ResponseEntity<GameMapWithDescriptors> getGameMap(@PathVariable String mapname) {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            GameMapWithDescriptors g = gmr.findDistinctByMapName(mapname);
            return new ResponseEntity<>(g, headers, HttpStatus.OK);
           // return ResponseEntity.ok(g);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
//http://localhost:8080/gamemap/toh_5e_cropped.jpg