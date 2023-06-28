package models.instruction;

import models.abstracts.Instructions;

public class Register extends Instructions {
    public Register(String opcode, int rs, int valueRs, int rt, int valueRt, int rd) {
        super(opcode, rs, valueRs, rt, valueRt, rd, 0b10000, 0b100000);
    }

    @Override
    protected int generateBinary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateBinary'");
    }
}
