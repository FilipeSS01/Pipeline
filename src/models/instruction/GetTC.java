package models.instruction;

import abstracts.Instructions;

public class GetTC extends Instructions{

    public GetTC(String opcode, int target) {
        super(opcode, target);
    }
    
}
