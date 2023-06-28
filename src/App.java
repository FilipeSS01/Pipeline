import models.pipeline.EX;
import models.pipeline.ID;
import models.pipeline.IF;
import models.pipeline.MEM;
import models.pipeline.WB;
import models.utils.Utils;

public class App {
    public static void main(String[] args) throws Exception {
        String path = IF.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        // Pipeline

        IF stage1 = new IF(path);
        ID stage2 = new ID();
        EX stage3 = new EX();
        MEM stage4 = new MEM();
        WB stage5 = new WB();

        while (Utils.getPc() < stage1.getInstructions().size()) {
            stage5.write(stage4.accesses(stage3.execute(stage2.decoding(stage1.search()))));
        }

        System.out.println(Utils.getIndexRegister(3));
        System.out.println(Utils.getIndexRegister(4));
    }
}
