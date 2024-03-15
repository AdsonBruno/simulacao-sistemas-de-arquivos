package org.example;

public class MemoryBlock {
    char fileData;
    MemoryBlock nextBlock;
    int position;

    public MemoryBlock(char fileData, MemoryBlock nextBlock, int position) {
        this.fileData = fileData;
        this.nextBlock = nextBlock;
        this.position = position;
    }
}
