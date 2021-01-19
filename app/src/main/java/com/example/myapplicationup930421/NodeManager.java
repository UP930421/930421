package com.example.myapplicationup930421;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import static java.lang.Integer.valueOf;

public class NodeManager {

    DecisionNode head;
    DecisionNode tail;

    public static DecisionNode buildNode(String[] stringArray){
        DecisionNode n = new DecisionNode();
        n.setNodeID(valueOf(Integer.parseInt(stringArray[0])));
        n.setLeftID(valueOf(Integer.parseInt(stringArray[1])));
        n.setRightID(valueOf(Integer.parseInt(stringArray[2])));
        n.setDescription(stringArray[3]);
        n.setLeftText(stringArray[4]);
        n.setRightText(stringArray[5]);
        n.setImage(stringArray[6]);

        return n;
    }

    public NodeManager( BufferedReader reader ) {
        this.buildUnorderedList(reader);
        this.buildOrderedMap();
    }
    private void append(DecisionNode newNode) {
        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.tail.setLinkedNode((DecisionNode)null);
            Log.d("game", "append");
        } else {
            this.tail.setLinkedNode(newNode);
            this.tail = newNode;
        }
    }
    public void buildUnorderedList(BufferedReader reader) {
        String line = "";
        DecisionNode n;

        try {
            while ((line = reader.readLine()) != null) {
                String[] stringArray = line.split(",");
                n = this.buildNode(stringArray);
                this.append(n);
            }
        } catch (IOException e) {
            throw new CustomException("list cant be built");
        }
    }

    private void buildOrderedMap() {
        if (this.head != null) {
            for(DecisionNode nodeLinker = this.head; nodeLinker != null; nodeLinker = nodeLinker.getLinkedNode()) {
                int yesID = nodeLinker.getLeftID();
                int noID = nodeLinker.getRightID();
                DecisionNode yesNode = this.nodeFetch(yesID);
                DecisionNode noNode = this.nodeFetch(noID);
                nodeLinker.setLeftNode(yesNode);
                nodeLinker.setRightNode(noNode);
            }
            this.cleanup();
        }


    }

    private void cleanup() {
        if (this.head != null) {
            DecisionNode currentNode = this.head;

            for(DecisionNode nextNode = this.head.getLinkedNode(); nextNode != null; nextNode = nextNode.getLinkedNode()) {
                currentNode.setLinkedNode((DecisionNode)null);
                currentNode = nextNode;
            }

        }
    }
    public DecisionNode entryPoint() {
        DecisionNode n = nodeFetch(54);
        return n;
    }

    private DecisionNode nodeFetch(int nodeID) {
        DecisionNode nodeLinker;
        for(nodeLinker = this.head; nodeLinker != null && nodeLinker.getNodeID() != nodeID; nodeLinker = nodeLinker.getLinkedNode()) {
        }

        return nodeLinker;
    }

    private boolean isEmpty() {
        return this.head == null;
    }

}
