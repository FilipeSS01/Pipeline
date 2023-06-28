package models.utils;

public class Utils {
    private static int[] memory = new int[1001];
    private static int[] register = new int[34];
    private static int pc = 0;


    public static void setIndexMemory(int index, int value){
        memory[index] = value;
    }

    public static int getIndexMemory(int index){
        return memory[index];
    }

    public static int[] getAllMemory() {
        return memory;
    }
    
    public static void setIndexRegister(int index, int value) {
        Utils.register[index] = value;
    }

    public static int getIndexRegister(int index) {
        return Utils.register[index];
    }

    public static int[] getAllRegister() {
        return Utils.register;
    }

    public static int addPC() {
        return Utils.pc++;
    }

    public static void addToPc(int value){
        Utils.pc += value;
    }

    public static int getPc() {
        return Utils.pc;
    }

    public static void setPc(int pc) {
        Utils.pc = pc;
    }
}
