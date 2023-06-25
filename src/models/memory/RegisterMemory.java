package models.memory;

public class RegisterMemory {
    private static int[] register = new int[34];

    public static void setIndexRegister(int index, int value){
        register[index] = value;
    }

    public static int getIndexRegister(int index){
        return register[index];
    }

    public static int[] getAllRegister() {
        return register;
    }
}
