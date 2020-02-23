/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.model.auction.dao;

import java.util.List;
import org.solent.com504.project.model.auction.dto.Auction;

/**
 *
 * @author Kevin
 */
public interface AuctionDAO {
    public Auction findById(Long id);
    public List<Auction> findAll();
    
    public Auction save(Auction auction);
    public void deleteById(Long id);
    public void delete(Auction auction);
    
}
