package com.network.tree.networkelement;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface NetworkElementRepo extends CrudRepository<NetworkElement, String> {
    
    public List<NetworkElement> findBySubNetworkSnName(String snName);
}
