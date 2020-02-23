/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.model.auction.dao;

import java.util.List;
import org.solent.com504.project.model.auction.dto.Flower;
import org.solent.com504.project.model.auction.dto.Lot;

/**
 *
 * @author anton
 */
public interface LotDAO {
    public Lot findById(Long id);
    public List<Lot> findAll();
    
    public Lot save(Lot lot);
    public void deleteById(Long id);
    public void delete(Lot lot);
    
    public List<Lot> findByFlower(String sciName);
    
}
