package models.instruction;

import models.abstracts.Instructions;

public class Jump extends Instructions {
    public Jump(String opcode, int target) {
        super(opcode, target);
    }
}
