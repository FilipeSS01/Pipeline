package models.instruction;

import models.abstracts.Instructions;

public class Jump extends Instructions {
    public Jump(String opcode, int target) {
        super(opcode, target);
    }

    @Override
    protected int generateBinary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateBinary'");
    }
}
