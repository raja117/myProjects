package com.network.tree.subnetwork;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/network")
public class SubNetworkController {
    
    @Autowired
    private SubNetworkService subnetwork;
    
    @RequestMapping("/subnetworks")
    public List<SubNetwork> getAllSubNetwork() {
	return subnetwork.getSubNetworks();
    }
    
    @RequestMapping("/subnetworks/{snName}")
    public SubNetwork getSubNetwork(@PathVariable String snName) {
	return subnetwork.getSubNetwork(snName);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/subnetworks")
    public void addSubNetwork(@RequestBody SubNetwork sn) {
	subnetwork.addSubNetwork(sn);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/subnetworks/{snName}")
    public void updateSubNetwork(@RequestBody SubNetwork sn, @PathVariable String snName) {
	subnetwork.updateSubNetwork(sn, snName);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value="/subnetworks/{snName}")
    public void deleteSubNetwork(@PathVariable String snName) {
	subnetwork.deleteSubNetwork(snName);
    }
}
