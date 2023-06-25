package models.pipeline;

import java.util.ArrayList;

import utils.FileManager;

public class IF {

    private int pc;
    private ArrayList<String> instructions;

    public IF(String path) {
        setPc(0);
        setInstructions(FileManager.stringReader(path + "data/exemplo.txt"));
    }

    public String search() {
        return getInstructions().get(pc++);
    }

    // Gets and Sets
    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public ArrayList<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<String> instructions) {
        this.instructions = instructions;
    }
}
