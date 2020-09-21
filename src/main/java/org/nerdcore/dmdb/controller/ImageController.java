package org.nerdcore.dmdb.controller;

import org.nerdcore.dmdb.services.ImageServices;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@RestController
public class ImageController {

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

}
