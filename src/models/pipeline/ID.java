package models.pipeline;

import abstracts.Instructions;
import models.instruction.*;

public class ID {
    public Instructions decoding(String instr) {
        String[] instruction = instr.replaceAll("\\s*,\\s*", " ").split(" ");
        String opcode = instruction[0];
        int rs;
        int rt;

        if (isImmediate(opcode)) {
            int immediate;
            if (instruction[0].equals("lw") || instruction[0].equals("sw")) {
                String[] subInstruction = instruction[2].replaceAll("[()]", " ").split(" ");
                rs = convert(subInstruction[1], true);
                rt = convert(instruction[1], true);
                immediate = convert(subInstruction[0], false);
            } else if (instruction[0].equals("beq") || instruction[0].equals("bne")) {
                rs = convert(instruction[1], true);
                rt = convert(instruction[2], true);
                immediate = convert(instruction[3], false);
            } else {
                rs = convert(instruction[1], true);
                immediate = convert(instruction[2], false);
                rt = 0;
            }
            return new Immediate(opcode, rs, rt, immediate);
        } else if (isRegister(opcode)) {
            rs = convert(instruction[2], true);
            rt = convert(instruction[3], true);
            int rd = convert(instruction[1], true);
            return new Register(opcode, rs, rt, rd, 0b10000, 0b100000);
        } else if (isJump(opcode) || isGetTC(opcode)) {
            int target = convert(instruction[1], false);
            return isGetTC(opcode) ? new GetTC(opcode, target) : new Jump(opcode, target);
        }
        System.out.println(opcode);
        return null;
    }

    private boolean isImmediate(String instr) {
        return (instr.equals("bne") || instr.equals("beq") || instr.equals("lw") || instr.equals("sw")
                || instr.equals("bltz") || instr.equals("bgtz"));
    }

    private boolean isRegister(String instr) {
        return (instr.equals("add") || instr.equals("sub") || instr.equals("mult") || instr.equals("div")
                || instr.equals("jr"));
    }

    private boolean isJump(String instr) {
        return (instr.equals("j"));
    }

    private boolean isGetTC(String instr) {
        return (instr.equals("get_tc"));
    }

    private int convert(String register, boolean replace) {
        return Integer.parseInt((replace ? register.replace("$", "") : register));
    }
}
