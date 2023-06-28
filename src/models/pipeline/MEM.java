package models.pipeline;

import java.util.Scanner;

import models.abstracts.Instructions;
import models.instruction.GetTC;
import models.instruction.Immediate;
import models.instruction.Jump;
import models.instruction.Register;
import models.utils.Utils;

public class MEM {
    private Scanner in;

    public MEM() {
        setIn(new Scanner(System.in));
    }

    public Instructions accesses(Instructions instruction) {
        if (instruction instanceof Immediate) {
            switch (instruction.getOpcode()) {
                case "lw":
                    instruction.setAlu(Utils.getIndexMemory(instruction.getImmediate()));
                    break;
                case "sw":
                    Utils.setIndexMemory(instruction.getImmediate(), instruction.getValueRT());
                    break;
            }
            return instruction;
        } else if (instruction instanceof Jump) {
            return instruction;
        } else if (instruction instanceof Register) {
            return instruction;
        } else if (instruction instanceof GetTC) {
            Utils.setIndexMemory(instruction.getTarget(), getIn().nextInt());
            return instruction;
        }
        return null;
    }

    // Gets and Sets
    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }
}
