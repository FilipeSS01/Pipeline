package models.pipeline;

import java.util.Scanner;

import models.abstracts.Instructions;
import models.instruction.GetTC;
import models.instruction.Immediate;
import models.instruction.Jump;
import models.instruction.Register;
import models.utils.Utils;

public class WB {

    private Scanner in;

    public WB() {
        setIn(new Scanner(System.in));
    }

    public void write(Instructions instruction) {
        if (instruction instanceof Immediate) {
            System.out.println(instruction.getOpcode());
            System.out.println(instruction.getRs());
            System.out.println(instruction.getRt());
            System.out.println(instruction.getImmediate());
        } else if (instruction instanceof Jump) {
            System.out.println(instruction.getOpcode());
            System.out.println(instruction.getTarget());
        } else if (instruction instanceof Register) {
            System.out.println(instruction.getOpcode());
            System.out.println(instruction.getRs());
            System.out.println(instruction.getRt());
            System.out.println(instruction.getRd());
            System.out.println(instruction.getShamt());
            System.out.println(instruction.getFunct());
        } else if (instruction instanceof GetTC) {
            Utils.setIndexRegister(instruction.getTarget(), getIn().nextInt());
        }
    }

    // Gets and Sets
    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }
}
