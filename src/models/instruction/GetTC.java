package models.instruction;

import models.abstracts.Instructions;

public class GetTC extends Instructions{

    public GetTC(String opcode, int target) {
        super(opcode, target);
    }
    
}
