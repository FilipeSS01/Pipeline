package models.instruction;

import models.abstracts.Instructions;

public class Register extends Instructions {

    public Register(String opcode, int rs, int rt, int rd, int shamt, int funct) {
        super(opcode, rs, rt, rd, shamt, funct);
    }

}
