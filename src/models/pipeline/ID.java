package models.pipeline;

import models.abstracts.Instructions;
import models.instruction.*;
import models.utils.Utils;

public class ID {
    public Instructions decoding(String instr) {
        String[] instruction = instr.replaceAll("[,(|)$]", " ").split("\s+");
        String opcode = instruction[0];
        int rs;
        int valueRs;
        int rt;
        int valueRt;

        if (isImmediate(opcode)) {
            int offset;
            if (instruction[0].equals("lw") || instruction[0].equals("sw")) {
                rt = instruction[0].equals("$lo") ? 33: instruction[0].equals("$hi") ? 32 : Integer.parseInt(instruction[1]);
                valueRt = Utils.getIndexRegister(rt);
                
                offset = Integer.parseInt(instruction[2]);

                rs = Integer.parseInt(instruction[3]);
                valueRs = Utils.getIndexRegister(rs);

                int i = offset + rs;

                return new Immediate(opcode, rs, valueRs, rt, valueRt, offset, i);
            } else if (instruction[0].equals("beq") || instruction[0].equals("bne")) {
                rs = Integer.parseInt(instruction[1]);
                valueRs = Utils.getIndexRegister(rs);

                rt = Integer.parseInt(instruction[2]);
                valueRt = Utils.getIndexRegister(rt);

                offset = Integer.parseInt(instruction[3]);
            } else {
                rs = Integer.parseInt(instruction[1]);
                valueRs = Utils.getIndexRegister(rs);
                offset = Integer.parseInt(instruction[3]);
                rt = 0;
                valueRt = 0;
            }
            return new Immediate(opcode, rs, valueRs, rt, valueRt, offset);
        } else if (isRegister(opcode)) {
            int rd = Integer.parseInt(instruction[1]);

            rs = Integer.parseInt(instruction[2]);
            valueRs = Utils.getIndexRegister(rs);

            rt = Integer.parseInt(instruction[3]);
            valueRt = Utils.getIndexRegister(rt);

            return new Register(opcode, rs, valueRs, rt, valueRt, rd);
        } else if (isJump(opcode) || isGetTC(opcode)) {
            int target = Integer.parseInt(instruction[1]);
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
}
