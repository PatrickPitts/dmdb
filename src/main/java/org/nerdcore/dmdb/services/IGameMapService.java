package org.nerdcore.dmdb.services;


import org.nerdcore.dmdb.entity.GameEntities.GameMapWithDescriptors;

import java.util.List;

public interface IGameMapService {

    List<GameMapWithDescriptors> findAll();
    GameMapWithDescriptors findOneByMapID(Long mapID);
    List<String> getAllMapFileNames();
}
