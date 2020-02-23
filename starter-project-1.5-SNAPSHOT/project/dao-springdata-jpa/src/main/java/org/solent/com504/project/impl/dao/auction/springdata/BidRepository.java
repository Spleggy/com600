/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.auction.springdata;

import java.util.List;
import org.solent.com504.project.model.auction.dto.Lot;
import org.solent.com504.project.model.auction.dto.Bid;
import org.solent.com504.project.model.party.dto.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Kevin
 */
public interface BidRepository extends JpaRepository<Bid, Long> {
    
    
    @Query("select b from Bid b LEFT JOIN FETCH b.bids where b.party = :party")
    public List<Bid> findByParty(@Param("party") Party party);
    
    @Query("select b from Bid b LEFT JOIN FETCH b.bids")
    public List<Bid> findAll();
    
}