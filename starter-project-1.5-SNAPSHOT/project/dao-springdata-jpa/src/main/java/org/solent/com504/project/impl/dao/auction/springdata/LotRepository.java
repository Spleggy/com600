/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.auction.springdata;

import java.util.List;
import org.solent.com504.project.model.auction.dto.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anton
 */
@Repository
public interface LotRepository extends JpaRepository<Lot, Long> {
    
    
    @Query("select l from Lot l LEFT JOIN FETCH l.bids where l.sciName = :sciName")
    public List<Lot> findByFlower(@Param("sciName") String sciName);
    
}