package com.network.tree.subnetwork;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SubNetworkService {
    
    @Autowired
    private SubNetworkRepo subnetworkRepo;
    
    public List<SubNetwork> getSubNetworks(){
	List<SubNetwork> subNetworks = new ArrayList<SubNetwork>();
	subnetworkRepo.findAll().forEach(subNetworks::add);
	return subNetworks;
    }
    
    public SubNetwork getSubNetwork(String snName) {
	return subnetworkRepo.findOne(snName);
    }

    public void addSubNetwork(SubNetwork sn) {
	subnetworkRepo.save(sn);
    }

    public void updateSubNetwork(SubNetwork sn, String snName) {
	subnetworkRepo.save(sn);
    }

    public void deleteSubNetwork(String snName) {
	subnetworkRepo.delete(snName);
    }
}