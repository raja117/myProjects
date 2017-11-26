package com.network.tree.networkelement;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.network.tree.subnetwork.SubNetwork;

@Entity
public class NetworkElement {
    
    @Id
    private String neName;
    private int neId;
    private String neLocation;
    
    @ManyToOne
    private SubNetwork subNetwork;
    
    public NetworkElement() {
    }
    
    public NetworkElement(String neName, int neId, String neLocation, String snName) {
	this.neName = neName;
	this.neId = neId;
	this.neLocation = neLocation;
	this.subNetwork = new SubNetwork(snName,-1);
    }
    
    public SubNetwork getSn() {
        return subNetwork;
    }

    public void setSn(SubNetwork sn) {
        this.subNetwork = sn;
    }

    public String getNeName() {
        return neName;
    }
    public void setNeName(String neName) {
	this.neName = neName;
    }
    public int getNeId() {
        return neId;
    }
    public void setNeId(int neId) {
        this.neId = neId;
    }
    public String getNeLocation() {
        return neLocation;
    }
    public void setNeLocation(String neLocation) {
        this.neLocation = neLocation;
    }
}
