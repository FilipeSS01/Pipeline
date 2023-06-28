package models.pipeline;

import java.util.ArrayList;

import fileManagers.FileManager;
import models.utils.Utils;

public class IF {

    private ArrayList<String> instructions;

    public IF(String path) {
        setInstructions(FileManager.stringReader(path + "data\\exemplo.txt"));
    }

    public String search() {
        return getInstructions().get(Utils.addPC());
    }

    // Gets and Sets
    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }
}
