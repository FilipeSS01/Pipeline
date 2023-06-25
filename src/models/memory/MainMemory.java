package models.memory;

public class MainMemory {
    private static int[] memory = new int[1001];

    public static void setIndexMemory(int index, int value){
        memory[index] = value;
    }

    public static int getIndexMemory(int index){
        return memory[index];
    }

    public static int[] getAllMemory() {
        return memory;
    }
}
