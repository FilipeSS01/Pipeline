package models.pipeline;

import models.abstracts.Instructions;
import models.instruction.GetTC;
import models.instruction.Immediate;
import models.instruction.Jump;
import models.instruction.Register;
import models.utils.Utils;

public class WB {
    public void write(Instructions instruction) {
        if (instruction instanceof Immediate) {
            switch (instruction.getOpcode()) {
                case "lw":
                    Utils.setIndexRegister(instruction.getRt(), instruction.getResult());
                    break;
                case "sw":
                    Utils.setIndexMemory(instruction.getImmediate(), instruction.getResult());
                    break;
            }
        } else if (instruction instanceof Jump) {

        } else if (instruction instanceof Register) {
            switch (instruction.getOpcode()) {
                case "add":
                case "sub":
                    Utils.setIndexRegister(instruction.getRd(), instruction.getResult());
                    break;
                case "mult":
                    Utils.setIndexRegister(33, instruction.getResult());                    
                    Utils.setIndexRegister(32, instruction.getResult());
                    break;
                case "div":
                    Utils.setIndexRegister(33, instruction.getResult());                    
                    Utils.setIndexRegister(32, instruction.getResult2());
                    break;
                case "jr":
                    Utils.setPc(instruction.getRs());
                    break;
            }
        } else if (instruction instanceof GetTC) {
            
        }
    }
}
