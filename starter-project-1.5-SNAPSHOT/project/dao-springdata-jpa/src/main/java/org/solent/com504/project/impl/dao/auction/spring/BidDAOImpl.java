/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.auction.spring;

import java.util.List;
import org.solent.com504.project.impl.dao.auction.springdata.BidRepository;
import org.solent.com504.project.model.auction.dao.BidDAO;
import org.solent.com504.project.model.auction.dto.Bid;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Kevin
 */
public class BidDAOImpl implements BidDAO {
    
    @Autowired
    private BidRepository bidRepository = null;
    
    @Override
    public Bid findById(Long id) {
        return bidRepository.getOne(id);
    }

    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    @Override
    public Bid save(Bid bid) {
        return bidRepository.save(bid);
    }

    @Override
    public void deleteById(Long id) {
        bidRepository.deleteById(id);
    }

    @Override
    public void delete(Bid bid) {
       bidRepository.delete(bid);
    }
    
}
