package org.example;

public class Main {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem(32);
        fs.createFile("Pernambuco");
        fs.createFile("São Paulo");
        fs.createFile("Alagoas");
        fs.showMemory();

        System.out.println();
        System.out.println("Excluindo");
        System.out.println();
        fs.deleteFile("São Paulo");
        fs.showMemory();

        System.out.println("ADICIONANDO");
        fs.createFile("Santa Catarina");
        fs.createFile("Rio de Janeiro");
        fs.showMemory();
    }
}