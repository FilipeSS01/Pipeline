package models.pipeline;

import models.abstracts.Instructions;
import models.instruction.*;
import models.utils.Utils;

public class EX {

    public Instructions execute(Instructions instruction) {
        if (instruction instanceof Immediate) {
            switch (instruction.getOpcode()) {
                case "beq":
                    if (instruction.getValueRS() == instruction.getValueRT())
                        Utils.setPc(instruction.getOffset());
                    break;
                case "bne":
                    if (instruction.getValueRS() != instruction.getValueRT())
                        Utils.setPc(instruction.getOffset());
                    break;
                case "bltz":
                    if (instruction.getValueRS() < instruction.getValueRT())
                        Utils.setPc(instruction.getOffset());
                    break;
                case "bgtz":
                    if (instruction.getValueRS() > instruction.getValueRT())
                        Utils.setPc(instruction.getOffset());
                    break;
            }
            return instruction;
        } else if (instruction instanceof Jump) {
            Utils.addToPc(instruction.getTarget());
            return instruction;
        } else if (instruction instanceof Register) {
            switch (instruction.getOpcode()) {
                case "add":
                    instruction.setAlu(instruction.getValueRS() + instruction.getValueRT());
                    break;
                case "sub":
                    instruction.setAlu(instruction.getValueRS() - instruction.getValueRT());
                    break;
                case "mult":
                    instruction.setLo(instruction.getValueRS() * instruction.getValueRT());
                    instruction.setHi(instruction.getValueRS() * instruction.getValueRT());
                    break;
                case "div":
                    instruction.setHi(instruction.getValueRS() / instruction.getValueRT());
                    instruction.setLo(instruction.getValueRS() % instruction.getValueRT());
                    break;
                case "jr":
                    Utils.setPc(instruction.getValueRS());
                    break;
            }
            return instruction;
        } else if (instruction instanceof GetTC) {
            return instruction;
        }
        return null;
    }
}
