package abstracts;

public abstract class Instructions {
    protected String opcode;
    protected int target;
    protected int immediate;
    protected int rs;
    protected int rt;
    protected int rd;
    protected int shamt;
    protected int funct;
    protected int encoding;
    protected int result;

    // Construction for Instruction Immediate
    protected Instructions(String opcode, int rs, int rt, int immediate) {
        setOpcode(opcode);
        setRs(rs);
        setRt(rt);
        setImmediate(immediate);
    }

    // Construction for Instruction Jump
    protected Instructions(String opcode, int target) {
        setOpcode(opcode);
        setTarget(target);
    }

    // Construction for Instruction Register
    protected Instructions(String opcode, int rs, int rt, int rd, int shamt, int funct) {
        setOpcode(opcode);
        setRs(rs);
        setRt(rt);
        setRd(rd);
        setShamt(shamt);
        setFunct(funct);
    }

    // Create instruction binary
    protected int generateBinary(String instruction) {
        return 0;
    }

    // Gets and Sets
    public String getOpcode() {
        return opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getImmediate() {
        return immediate;
    }

    public void setImmediate(int immediate) {
        this.immediate = immediate;
    }

    public int getRs() {
        return rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public int getRd() {
        return rd;
    }

    public void setRd(int rd) {
        this.rd = rd;
    }

    public int getShamt() {
        return shamt;
    }

    public void setShamt(int shamt) {
        this.shamt = shamt;
    }

    public int getFunct() {
        return funct;
    }

    public void setFunct(int funct) {
        this.funct = funct;
    }

    public int getEncoding() {
        return encoding;
    }

    public void setEncoding(int encoding) {
        this.encoding = encoding;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
