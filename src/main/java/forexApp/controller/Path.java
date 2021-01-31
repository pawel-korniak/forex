package forexApp.controller;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
public class Path{
    private String path;
    private List<String> paths;

    public Path() {
        setPaths();
    }

    public void setPaths() {
        File file = new File("data/");
        paths = Arrays.asList(file.list());
        paths = paths.stream().sorted(Comparator.comparing(x -> new File(x).lastModified())).collect(Collectors.toList());
        //for some reason lastModified() returns 0 for every file. I don't know where is problem
        paths.forEach(x -> log.info("last modified : " + new File(x).getName() + "    " + new File(x).lastModified()));
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}