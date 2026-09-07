import java.util.Stack;

public class TreatmentStack {

    private Stack<TreatmentRecord> stack;

    public TreatmentStack() {
        stack = new Stack<>();
    }

    public void push(TreatmentRecord record) {
        stack.push(record);
        System.out.println("Treatment record added.");
    }

    public TreatmentRecord pop() {

        if (stack.isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return null;
        }

        return stack.pop();
    }

    public void displayStack() {

        if (stack.isEmpty()) {
            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("\n--- Treatment History ---");

        for (int i = stack.size() - 1; i >= 0; i--) {

            System.out.println(stack.get(i));
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}