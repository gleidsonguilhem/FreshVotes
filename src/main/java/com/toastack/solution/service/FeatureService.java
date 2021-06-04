package com.toastack.solution.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toastack.solution.model.Feature;
import com.toastack.solution.model.Product;
import com.toastack.solution.model.User;
import com.toastack.solution.repositories.FeatureRepository;
import com.toastack.solution.repositories.ProductRepository;

@Service
public class FeatureService {
		
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private FeatureRepository featureRepository;
	
	public Feature createFeature(User user, Long productId) {
		Feature feature = new Feature();
		
		Optional<Product> productOpt = productRepository.findById(productId);
		
		if(productOpt.isPresent()) {
			Product product = productOpt.get();
			
			feature.setProduct(product);
			product.getFeatures().add(feature);
			
			feature.setUser(user);
			user.getFeatures().add(feature);
			
			feature.setStatus("Pending review");
			
			
			return featureRepository.save(feature);
		}
		return feature;		
	}
	
	public Feature save(User user, Feature feature) {
		
		return featureRepository.save(feature);
	}

	public Optional<Feature> findById(Long featureId) {
		return featureRepository.findById(featureId);
	}
	
	
}
