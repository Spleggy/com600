/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.auction.spring;

import java.util.List;
import org.solent.com504.project.impl.dao.auction.springdata.AuctionRepository;
import org.solent.com504.project.model.auction.dao.AuctionDAO;
import org.solent.com504.project.model.auction.dto.Auction;
import org.solent.com504.project.model.auction.dto.Bid;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Kevin
 */
public class AuctionDAOImpl implements AuctionDAO {
    
    @Autowired
    private AuctionRepository auctionRepository = null;
    
    @Override
    public Auction findById(Long id) {
        return auctionRepository.getOne(id);
    }

    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction save(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public void deleteById(Long id) {
        auctionRepository.deleteById(id);
    }

    @Override
    public void delete(Auction auction) {
       auctionRepository.delete(auction);
    }
    
}
