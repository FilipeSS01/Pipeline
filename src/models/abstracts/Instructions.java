package models.abstracts;

public abstract class Instructions {
    protected String opcode;
    protected int target;
    protected int immediate;
    protected int offset;
    protected int rs;
    protected int valueRS;
    protected int rt;
    protected int valueRT;
    protected int rd;
    protected int shamt;
    protected int funct;
    protected int encoding;
    protected int alu;
    protected int hi;
    protected int lo;

    // Construction for Instruction Immediate
    protected Instructions(String opcode, int rs, int valueRS, int rt, int valueRT, int offset, int immediate) {
        setOpcode(opcode);
        setRs(rs);
        setValueRS(valueRS);
        setRt(rt);
        setValueRT(valueRT);
        setOffset(offset);
        setImmediate(immediate);
    }
    
    protected Instructions(String opcode, int rs, int valueRS, int rt, int valueRT, int offset) {
        setOpcode(opcode);
        setRs(rs);
        setValueRS(valueRS);
        setRt(rt);
        setValueRT(valueRT);
        setOffset(offset);
    }


    // Construction for Instruction Jump and GetTc
    protected Instructions(String opcode, int target) {
        setOpcode(opcode);
        setTarget(target);
    }

    // Construction for Instruction Register
    protected Instructions(String opcode, int rs, int valueRs, int rt, int valueRt, int rd, int shamt, int funct) {
        setOpcode(opcode);
        setRs(rs);
        setValueRS(valueRs);
        setRt(rt);
        setValueRT(valueRt);
        setRd(rd);
        setShamt(shamt);
        setFunct(funct);
    }

    // Create instruction binary
    protected abstract int generateBinary();

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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getRs() {
        return rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public int getValueRS() {
        return valueRS;
    }

    public void setValueRS(int valueRS) {
        this.valueRS = valueRS;
    }

    public int getRt() {
        return rt;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public int getValueRT() {
        return valueRT;
    }

    public void setValueRT(int valueRT) {
        this.valueRT = valueRT;
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

    public int getAlu() {
        return alu;
    }

    public void setAlu(int alu) {
        this.alu = alu;
    }

    public int getHi() {
        return hi;
    }

    public void setHi(int hi) {
        this.hi = hi;
    }

    public int getLo() {
        return lo;
    }

    public void setLo(int lo) {
        this.lo = lo;
    }

}
