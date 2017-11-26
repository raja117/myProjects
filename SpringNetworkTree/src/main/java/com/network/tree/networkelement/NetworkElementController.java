package com.network.tree.networkelement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.network.tree.subnetwork.SubNetwork;

@RestController
@RequestMapping("/network")
public class NetworkElementController {
    
    @Autowired
    private NetworkElementService networkElement;
    
    @RequestMapping("/subnetwork/{snName}/networkelement")
    public List<NetworkElement> getAllNetworkElements(@PathVariable String snName){
	return networkElement.getAllNetworkElements(snName);
    }
    
    @RequestMapping("/subnetwork/{snName}/networkelement/{neName}")
    public NetworkElement getNetworkElement(@PathVariable String neName) {
	return networkElement.getNetworkElements(neName);
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/subnetwork/{snName}/networkelement")
    public void addNetworkElement(@RequestBody NetworkElement ne, @PathVariable String snName) {
	ne.setSn(new SubNetwork(snName, -1));
	networkElement.addNetworkElement(ne);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value="/subnetwork/{snName}/networkelement/{neName}")
    public void updateNetworkElemetn(@RequestBody NetworkElement ne, @PathVariable String neName, @PathVariable String snName) {
	ne.setSn(new SubNetwork(snName, -1));
	networkElement.updateNetworkElement(ne, neName);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value="/subnetwork/{snName}/networkelement/{neName}")
    public void deleteNetworkElement(@PathVariable String neName) {
	networkElement.deleteNetworkElement(neName);
    }
}