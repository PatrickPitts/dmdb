package org.nerdcore.dmdb.services;

import org.nerdcore.dmdb.entity.GameEntities.GameMapWithDescriptors;
import org.nerdcore.dmdb.repository.GameMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameMapService implements IGameMapService {

    @Autowired
    private GameMapRepository repo;


    private final String imgPath;

    public GameMapService(@Value("${imgsrc.uri}") String imgPath){
        this.imgPath = imgPath;
    }

    @Override
    public List<GameMapWithDescriptors> findAll(){
        return (List<GameMapWithDescriptors>) repo.findAll();
    }

    @Override
    public GameMapWithDescriptors findOneByMapID(Long mapID){
        Optional res = repo.findById(mapID);
        if(res.isPresent()){
            return (GameMapWithDescriptors) res.get();
        }
        return new GameMapWithDescriptors();
    }

    @Override
    public List<String> getAllMapFileNames(){
        List<String> ret = new ArrayList<>();
        File[] imageFiles = (new File(imgPath)).listFiles();
        if(imageFiles != null){
            for(File f : imageFiles){
                ret.add(f.getName());
            }
        }
        return ret;
    }
}
