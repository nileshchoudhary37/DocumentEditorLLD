package org.example;

public class DocumentEditorClient {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello World");
        editor.addImage("images/logo.png");
        editor.addImage("picture.jpg");

        System.out.println(editor.renderDocument());
        editor.saveToFile();
    }
}