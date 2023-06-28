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
                    Utils.setIndexRegister(instruction.getRt(), instruction.getAlu());
                    break;
                case "sw":
                    Utils.setIndexMemory(instruction.getImmediate(), instruction.getAlu());
                    break;
            }
        } else if (instruction instanceof Jump) {

        } else if (instruction instanceof Register) {
            switch (instruction.getOpcode()) {
                case "add":
                case "sub":
                    Utils.setIndexRegister(instruction.getRd(), instruction.getAlu());
                    break;
                case "mult":
                    Utils.setIndexRegister(33, instruction.getLo());                    
                    Utils.setIndexRegister(32, instruction.getHi());
                    break;
                case "div":
                    Utils.setIndexRegister(33, instruction.getLo());                    
                    Utils.setIndexRegister(32, instruction.getHi());
                    break;
                case "jr":
                    Utils.setPc(instruction.getRs());
                    break;
            }
        } else if (instruction instanceof GetTC) {
            
        }
    }
}
