package models.pipeline;

import models.abstracts.Instructions;
import models.instruction.*;
import models.utils.Utils;

public class ID {
    public Instructions decoding(String instr) {
        String[] instruction = instr.replaceAll("\\s*,\\s*", " ").split(" ");
        String opcode = instruction[0];
        int rs;
        int rt;

        if (isImmediate(opcode)) {
            int offset;
            if (instruction[0].equals("lw") || instruction[0].equals("sw")) {
                String[] subInstruction = instruction[2].replaceAll("[()]", " ").split(" ");
                rs = Utils.getIndexRegister(convert(subInstruction[1], true)); // Value of base register -> rs = register[ rs ]
                if(instruction[1].equals("$lo") || instruction[1].equals("$hi"))
                    rt = instruction[1].equals("$lo") ? 33 : 32; // rt = index of register lo or hi (index register destination)
                else
                    rt = convert(instruction[1], true); // rt = index of register in the instruction (lw = index register destination; sw = index memory destination)
                offset = convert(subInstruction[0], false); // offset

                // Return rs = Value of base register; rt = immediate(rs + offset); 
            } else if (instruction[0].equals("beq") || instruction[0].equals("bne")) {
                rs = Utils.getIndexRegister(convert(instruction[1], true)); // rs = Value of register[ at the instruction ]
                rt = Utils.getIndexRegister(convert(instruction[2], true)); // rt = Value of register[ at the instruction ]
                offset = convert(instruction[3], false); // line to jump instruction (pc = offset(immediate))
            } else {
                rs = Utils.getIndexRegister(convert(instruction[1], true)); // rs = Value of register[ at the instruction ]
                offset = convert(instruction[2], false); // line to jump instruction (pc = offset(immediate))
                rt = 0;
            }
            return new Immediate(opcode, rs, rt, offset);
        } else if (isRegister(opcode)) {
            rs = Utils.getIndexRegister(convert(instruction[2], true)); // Value of register
            rt = Utils.getIndexRegister(convert(instruction[3], true)); // Value of register
            int rd = convert(instruction[1], true); // index of register destination
            return new Register(opcode, rs, rt, rd, 0b10000, 0b100000);
        } else if (isJump(opcode) || isGetTC(opcode)) {
            int target = convert(instruction[1], false); // Line to add PC
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
