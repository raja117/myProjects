package com.network.tree.networkelement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class NetworkElementService {
    
    @Autowired
    private NetworkElementRepo neRepo;
    
    public List<NetworkElement> getAllNetworkElements(String snName){
	List<NetworkElement> nes = new ArrayList<NetworkElement>();
	neRepo.findBySubNetworkSnName(snName).forEach(nes::add);
	return nes;
    }
    
    public NetworkElement getNetworkElements(String neName) {
	return neRepo.findOne(neName);
    }
    
    public void addNetworkElement(NetworkElement ne) {
	neRepo.save(ne);
    }

    public void updateNetworkElement(NetworkElement ne, String neName) {
	neRepo.save(ne);
    }

    public void deleteNetworkElement(String neName) {
	neRepo.delete(neName);
    }

}
