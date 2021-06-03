package com.toastack.solution.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toastack.solution.model.Feature;
import com.toastack.solution.service.FeatureService;

@Controller
@RequestMapping("/products/{productId}/features")
public class FeatureController {

	@Autowired
	private FeatureService featureService;
	
	@PostMapping("")
	public String createFeature(@PathVariable Long productId) {
		Feature feature = featureService.createFeature(productId);
		return "redirect:/products/"+productId+"/features/"+feature.getId();
	}
	
	@GetMapping("{featureId}")
	public String getFeature(@PathVariable Long productId, @PathVariable Long featureId, ModelMap model) {
		Optional<Feature> featureOpt = featureService.findById(featureId);
		
		if(featureOpt.isPresent()) {
			model.put("feature", featureOpt.get());
		}
		//TODO: handle situation where we can't find a feature by featureID
		return "feature";
	}
	
	@PostMapping("{featureId}")
	public String updateFeature(Feature feature, @PathVariable Long productId, @PathVariable Long featureId) {
		feature = featureService.save(feature);
		return "redirect:/products/"+productId+"/features/"+feature.getId();
	}
	

}
