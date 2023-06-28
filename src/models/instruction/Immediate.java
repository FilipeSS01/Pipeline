package models.instruction;
import models.abstracts.Instructions;

public class Immediate extends Instructions {
    public Immediate(String opcode, int rs, int rt, int offset) {
        super(opcode, rs, rt, offset);
    }

    @Override
    protected int generateBinary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateBinary'");
    }
}
