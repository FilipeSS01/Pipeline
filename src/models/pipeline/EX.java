package models.pipeline;

import abstracts.Instructions;
import models.instruction.*;

public class EX {

    public Instructions execute(Instructions instruction) {
        if (instruction instanceof Immediate) {
            System.out.println(instruction.getOpcode());
            System.out.println(instruction.getRs());
            System.out.println(instruction.getRt());
            System.out.println(instruction.getImmediate());
        } else if (instruction instanceof Jump) {
            System.out.println(instruction.getOpcode());
            System.out.println(instruction.getTarget());
        } else if (instruction instanceof Register) {
            System.out.println(instruction.getOpcode());
            System.out.println(instruction.getRs());
            System.out.println(instruction.getRt());
            System.out.println(instruction.getRd());
            System.out.println(instruction.getShamt());
            System.out.println(instruction.getFunct());
        } else if (instruction instanceof GetTC) {
            return instruction;
        }
        return null;
    }
}
