package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentEditor {
    private List<String> documentElements;
    private String renderedDocument;

    public DocumentEditor() {
        documentElements = new ArrayList<String>();
        renderedDocument = "";
    }

    //Add text as plain string
    public void addText(String text) {
        documentElements.add(text);
    }

    //Adds an image represented by file path
    public void addImage(String imagePath){
        documentElements.add(imagePath);
    }

    //Renders the document by checking the type of each element at the runtime
    public String renderDocument() {
        if(renderedDocument.isEmpty()){
            StringBuilder result = new StringBuilder();
            documentElements.forEach(
                    element ->{
                        if(element.length() >=4 && (element.endsWith(".jpg")||element.endsWith(".png"))){
                            result.append("[Image: ").append(element).append("]\n");
                        }else{
                            result.append(element).append("\n");
                        }
                    }
            );
            renderedDocument = result.toString();
        }
        return renderedDocument;
    }

    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("Document saved to document.txt file");
        } catch (IOException e) {
            System.out.println("Unable to open the file for writing.");
        }
    }
}
