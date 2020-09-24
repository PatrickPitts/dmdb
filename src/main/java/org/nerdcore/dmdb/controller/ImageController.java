package org.nerdcore.dmdb.controller;

import org.nerdcore.dmdb.entity.GameEntities.GameMapWithDescriptors;
import org.nerdcore.dmdb.repository.GameMapRepository;
import org.nerdcore.dmdb.services.GameMapService;
import org.nerdcore.dmdb.services.ImageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ImageController {

    @Autowired
    private GameMapRepository gmRepo;

    @Autowired
    private GameMapService gameMapService;

    @Autowired
    private ImageServices imageServices;


    @RequestMapping("/mapimage/{mapID}")
    public ResponseEntity<byte[]> getMapImagesResponseEntityByMapID(
            @PathVariable String mapID){
        try {
            HttpHeaders headers = new HttpHeaders();
            byte[] media = ImageServices.getImageByteArrayByMapID(mapID);
            headers.setCacheControl(CacheControl.noCache().getHeaderValue());
            return new ResponseEntity<>(media, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }

    @RequestMapping("/mapimage")
    public ResponseEntity<ArrayList<String>> initRepo(){

        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        List<String> gameMapNames = gameMapService.getAllMapFileNames();
        return new ResponseEntity<>(
                (ArrayList<String>)gameMapNames,
                headers,
                HttpStatus.OK);

    }

}
