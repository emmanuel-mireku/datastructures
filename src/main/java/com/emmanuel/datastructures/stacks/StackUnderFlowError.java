package com.emmanuel.datastructures.stacks;

public class StackUnderFlowError extends VirtualMachineError {
    public StackUnderFlowError() {
        super("There are no element to pop from the stack");
    }
}
