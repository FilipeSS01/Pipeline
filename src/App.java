
import models.memory.RegisterMemory;
import models.pipeline.EX;
import models.pipeline.ID;
import models.pipeline.IF;
import models.pipeline.MEM;
import models.pipeline.WB;

public class App {
    public static void main(String[] args) throws Exception {
        String path = IF.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        // Pipeline

        IF stage1 = new IF(path);
        ID stage2 = new ID();
        EX stage3 = new EX();
        MEM stage4 = new MEM();
        WB stage5 = new WB();

        while (stage1.getPc() != stage1.getInstructions().size()) {
            stage5.write(stage4.accesses(stage3.execute(stage2.decoding(stage1.search()))));
        }

        System.out.println(RegisterMemory.getIndexRegister(3));
        System.out.println(RegisterMemory.getIndexRegister(4));

        // for (String inst : instructions) {
        // String[] instruction = inst.replaceAll("\\s*,\\s*", " ").split(" ");
        // String value = "";
        // switch (instruction[0]) {
        // case "get_tc":
        // value = instruction[0] + " " + instruction[1];
        // break;
        // case "lw":
        // value = instruction[0] + " " + instruction[1] + " " + instruction[2];
        // break;
        // case "sub":
        // value = instruction[0] + " " + instruction[1] + " " + instruction[2];
        // break;
        // case "beq":
        // value = instruction[0] + " " + instruction[1] + " " + instruction[2];
        // break;
        // case "bne":
        // value = instruction[0] + " " + instruction[1] + " " + instruction[2];
        // break;
        // case "sw":
        // value = instruction[0] + " " + instruction[1] + " " + instruction[2];
        // break;
        // case "noop":
        // value = instruction[0] + " ";
        // break;
        // }
        // System.out.println(value);
        // }
    }
}
