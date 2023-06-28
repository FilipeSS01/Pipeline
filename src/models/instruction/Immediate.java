package models.instruction;

import models.abstracts.Instructions;

public class Immediate extends Instructions {
    public Immediate(String opcode, int rs, int valueRS, int rt, int valueRT, int offset, int immediate) {
        super(opcode, rs, valueRS, rt, valueRT, offset, immediate);
    }
    public Immediate(String opcode, int rs, int valueRS, int rt, int valueRT, int offset) {
        super(opcode, rs, valueRS, rt, valueRT, offset);
    }

    @Override
    protected int generateBinary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateBinary'");
    }
}
