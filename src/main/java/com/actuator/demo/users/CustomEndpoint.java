package com.actuator.demo.users;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Endpoint(id = "release-notes")
public class CustomEndpoint {

    Map<String, List<String>> releaseNotesMap = new HashMap<>();

    @PostConstruct
    public void initNotes(){
        releaseNotesMap.put("version-1.0", Arrays.asList("adding rest Api","adding Security"));
        releaseNotesMap.put("version-1.1", Arrays.asList("testing rest Api","testing Security"));
    }

    @ReadOperation
    public Map<String, List<String>> getReleaseNotesMap(){
        return releaseNotesMap;
    }

    @ReadOperation
    public List<String> getReleaseNotesByVersion(@Selector String version){
        return releaseNotesMap.get(version);
    }

    @WriteOperation
    public void addReleaseNotes(@Selector String version,String releaseNotes){
        releaseNotesMap.put(version,
                Arrays.stream(releaseNotes.split(",")).
                        collect(Collectors.toList()));
    }

    @DeleteOperation
    public void deleteNotes(@Selector String version) {
        releaseNotesMap.remove(version);
    }
}
