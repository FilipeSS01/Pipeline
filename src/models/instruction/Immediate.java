package models.instruction;

import abstracts.Instructions;

public class Immediate extends Instructions {

    public Immediate(String opcode, int rs, int rt, int immediate) {
        super(opcode, rs, rt, immediate);
    }
}
