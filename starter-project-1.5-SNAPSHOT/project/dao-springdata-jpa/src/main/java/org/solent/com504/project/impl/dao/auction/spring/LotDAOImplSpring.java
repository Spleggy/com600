/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.auction.spring;

import java.util.List;
import org.solent.com504.project.impl.dao.auction.springdata.LotRepository;

import org.solent.com504.project.model.auction.dao.LotDAO;
import org.solent.com504.project.model.auction.dto.Flower;
import org.solent.com504.project.model.auction.dto.Lot;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author anton
 */
public class LotDAOImplSpring implements LotDAO {
    
    @Autowired
    private LotRepository lotRepository = null;
    
    @Override
    public Lot findById(Long id) {
        return lotRepository.getOne(id);
    }

    @Override
    public List<Lot> findAll() {
        return lotRepository.findAll();
    }

    @Override
    public Lot save(Lot lot) {
        return lotRepository.save(lot);
    }

    @Override
    public void deleteById(Long id) {
        lotRepository.deleteById(id);
    }

    @Override
    public void delete(Lot lot) {
       lotRepository.delete(lot);
    }

    @Override
    public List<Lot> findByFlower(String sciName) {
        return lotRepository.findByFlower(sciName);
    }
    
}
