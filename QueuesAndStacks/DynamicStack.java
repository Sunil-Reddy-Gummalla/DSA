package QueuesAndStacks;

public class DynamicStack extends CustomStack {

    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    public boolean push(int item) {
        if(this.isFull()) {
            //double the size of the Array
            int[] temp = new int[data.length * 2];
            for(int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

}
