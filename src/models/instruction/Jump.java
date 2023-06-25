package models.instruction;

import abstracts.Instructions;

public class Jump extends Instructions {

    public Jump(String opcode, int target) {
        super(opcode, target);
    }

}
