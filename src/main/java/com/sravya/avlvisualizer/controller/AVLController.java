package com.sravya.avlvisualizer.controller;

import com.sravya.avlvisualizer.dto.DeleteRequest;
import com.sravya.avlvisualizer.dto.InsertRequest;
import com.sravya.avlvisualizer.service.AVLTree;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AVLController {

    private final AVLTree avlTree;

    public AVLController(AVLTree avlTree) {
        this.avlTree = avlTree;
    }
    @PostMapping("/insert")
    public String insert(@RequestBody InsertRequest request) {

        avlTree.insert(request.getValue());

        return "Inserted " + request.getValue();
    }
    @GetMapping("/tree")
    public Object getTree() {
        return avlTree.getRoot();
    }
    @PostMapping("/delete")
    public String delete(@RequestBody DeleteRequest request) {

        avlTree.delete(request.getValue());

        return "Deleted " + request.getValue();
    }

}