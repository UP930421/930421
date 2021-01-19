package com.example.myapplicationup930421;


public class DecisionNode {

    int nodeID;
    int leftID;
    int rightID;
    String description;
    String leftText;
    String rightText;
    String image;
    DecisionNode leftNode;
    DecisionNode rightNode;

    DecisionNode linkedNode;

    public DecisionNode() {}

    public DecisionNode getLinkedNode() {
        if(linkedNode == null){
            throw new CustomException("no linked node, node id " + nodeID);
        }return linkedNode;}
    public void setLinkedNode(DecisionNode linkedNode) {this.linkedNode = linkedNode;}

    public int getNodeID() {return nodeID;}
    public void setNodeID(int nodeID) {this.nodeID = nodeID;}
    public int getLeftID() {return leftID;}
    public void setLeftID(int leftID) {this.leftID = leftID; }
    public int getRightID() {return rightID;}
    public void setRightID(int rightID) {this.rightID = rightID;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description; }
    public String getLeftText() {return leftText;}
    public void setLeftText(String leftText) {this.leftText = leftText;}
    public String getRightText() {return rightText;}
    public void setRightText(String rightText) {this.rightText = rightText;}
    public DecisionNode getLeftNode() {
        if(leftNode == null){
            throw new CustomException("no left node, node id " + nodeID);
        }
        return leftNode;}
    public void setLeftNode(DecisionNode leftNode) {this.leftNode = leftNode;}
    public DecisionNode getRightNode() {
        if(rightNode == null){
            throw new CustomException("no right node, node id " + nodeID);
        }
        return rightNode;}
    public void setRightNode(DecisionNode rightNode) {this.rightNode = rightNode;}
    public String getImage() {return image;}
    public void setImage(String image) {this.image = image; }
}

