package com.example.turistguide.model;

public class UpdateAttractionRequest {

    private String originalName;
    private String newName;
    private String newDescription;

    @Override
    public String toString() {
        return "UpdateAttractionRequest{" +
                "originalName='" + originalName + '\'' +
                ", newName='" + newName + '\'' +
                ", newDescription='" + newDescription + '\'' +
                '}';
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }
}
