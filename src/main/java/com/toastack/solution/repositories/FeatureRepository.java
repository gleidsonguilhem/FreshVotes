package com.toastack.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toastack.solution.model.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {

}
