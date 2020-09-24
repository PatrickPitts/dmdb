package org.nerdcore.dmdb.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public class StorageService {

    @Value("${imgsrc.uri}")
    private String path;
}
