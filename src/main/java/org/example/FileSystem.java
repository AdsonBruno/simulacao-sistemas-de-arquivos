package org.example;

import java.util.*;

public class FileSystem {
    MemoryBlock[] memory;
    Map<String, MemoryBlock> directory;

    public FileSystem(int memorySize) {
        this.memory = new MemoryBlock[memorySize];
        this.directory = new HashMap<>();
    }

    public void createFile(String fileContent) {
        if (fileContent.length() > memory.length) {
            System.out.println("Memória insuficiente");
            return;
        }

        MemoryBlock previousBlock = null;

        for (int i = 0; i < fileContent.length(); i++) {
            int freeBlockIndex = findFreeMemoryBlock();

            if (freeBlockIndex == -1) {
                System.out.println("Memória insuficiente");
                return;
            }

            memory[freeBlockIndex] = new MemoryBlock(fileContent.charAt(i), null, freeBlockIndex);
            if (previousBlock != null) {
                previousBlock.nextBlock = memory[freeBlockIndex];
            }

            if (i == 0) {
                directory.put(fileContent, memory[freeBlockIndex]);
            }

            previousBlock = memory[freeBlockIndex];

        }
    }

    public void deleteFile(String fileName) {
        if (!directory.containsKey(fileName)) {
            System.out.println("Arquivo não encontrado: " + fileName);
            return;
        }

        MemoryBlock currentBlock = directory.get(fileName);

        while (currentBlock != null) {
            int blockIndex = findMemoryBlock(currentBlock);
            if (blockIndex != -1) {
                memory[blockIndex] = null;
            }
            currentBlock = currentBlock.nextBlock;
        }
        directory.remove(fileName);
    }

//    public void deleteFile(String fileName) {
//        MemoryBlock currentBlock = directory.get(fileName);
//        while (currentBlock != null) {
//            int blockIndex = findMemoryBlock(currentBlock);
//            if (blockIndex != -1) {
//                memory[blockIndex] = null;
//            }
//            currentBlock = currentBlock.nextBlock;
//        }
//        directory.remove(fileName);
//    }

    public void readFile(String fileName) {
        MemoryBlock currentBlock = directory.get(fileName);
        while (currentBlock != null) {
            System.out.print(currentBlock.fileData);
            currentBlock = currentBlock.nextBlock;
        }
        System.out.println();
    }

    private int findFreeMemoryBlock() {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private int findMemoryBlock(MemoryBlock block) {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == block) {
                return i;
            }
        }
        return -1;
    }

    public void showMemory() {

        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == null) {
                System.out.println("_");
            } else {
                System.out.print(memory[i].fileData + " \n");
            }
        }
    }
}
