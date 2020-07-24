package interview.pinterest.FlattenNestedListIterator;

import interview.NestedInteger;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        if(nestedList != null) {
            for(int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if(stack.size() == 0)
            return false;

        if(stack.peek().isInteger()) {
            return true;
        } else {
            while(stack.size() > 0 && !stack.peek().isInteger()) {
                List<NestedInteger> list = stack.pop().getList();
                for(int i = list.size() - 1; i >= 0; i--)
                    stack.push(list.get(i));
            }

            return stack.size() > 0;
        }
    }
}