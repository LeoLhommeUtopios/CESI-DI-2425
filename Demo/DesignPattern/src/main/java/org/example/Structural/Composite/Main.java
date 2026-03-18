package org.example.Structural.Composite;

public class Main
{
    public static void main(String[] args) {
        Component file1 = new File("Fichier 1");
        Component file2 = new File("Fichier 2");
        Component file3 = new File("Fichier 3");

        Folder folder1 = new Folder("Dossier 1");
        Folder folder2 = new Folder("Dossier 2");

        folder2.add(file3);
        folder2.add(file1);
        folder1.add(file1);
        folder1.add(file2);
        folder1.add(folder2);

        folder1.operation();
    }
}
