/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.model.auction.dao;

import java.util.List;
import org.solent.com504.project.model.auction.dto.Bid;
import org.solent.com504.project.model.auction.dto.Lot;

/**
 *
 * @author Kevin
 */
public interface BidDAO {
    public Bid findById(Long id);
    public List<Bid> findAll();
    
    public Bid save(Bid bid);
    public void deleteById(Long id);
    public void delete(Bid bid);
    
}
