package com.network.tree.subnetwork;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubNetwork {
    
    @Id
    private String snName;
    private int snId;

    public SubNetwork() {
    }

    public SubNetwork(String snName, int snId) {
	this.snName = snName;
	this.snId = snId;
    }
        
    public String getSnName() {
        return snName;
    }
    public void setSnName(String snName) {
        this.snName = snName;
    }
    public int getSnId() {
        return snId;
    }
    public void setSnId(int snId) {
        this.snId = snId;
    }
}
