package models.pipeline;

import models.abstracts.Instructions;
import models.instruction.*;
import models.utils.Utils;

public class EX {

    public Instructions execute(Instructions instruction) {
        if (instruction instanceof Immediate) {
            switch (instruction.getOpcode()) {
                case "lw":
                case "sw":
                    instruction.setImmediate(instruction.getRs() + instruction.getOffset());
                    break;
                case "beq":
                    if (instruction.getRs() == instruction.getRt())
                        Utils.setPc(instruction.getOffset());
                    break;
                case "bne":
                    if (instruction.getRs() != instruction.getRt())
                        Utils.setPc(instruction.getOffset());
                    break;
                case "bltz":
                    if (instruction.getRs() < instruction.getRt())
                        Utils.setPc(instruction.getOffset());
                    break;
                case "bgtz":
                    if (instruction.getRs() > instruction.getRt())
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
                    instruction.setResult(instruction.getRs() + instruction.getRt());
                    break;
                case "sub":
                    instruction.setResult(instruction.getRs() + instruction.getRt());
                    break;
                case "mult":
                    instruction.setResult(instruction.getRs() * instruction.getRt());
                    break;
                case "div":
                    instruction.setResult(instruction.getRs() * instruction.getRt());
                    instruction.setResult2(instruction.getRs() % instruction.getRt());
                    break;
                case "jr":
                    Utils.setPc(instruction.getRs());
                    break;
            }
        } else if (instruction instanceof GetTC) {
            return instruction;
        }
        return null;
    }
}
