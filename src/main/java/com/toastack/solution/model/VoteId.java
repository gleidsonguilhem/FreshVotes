package com.toastack.solution.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class VoteId implements Serializable{

  private static final long serialVersionUID = -7821549234424563502L;
  @ManyToOne
  private User user;
  @ManyToOne
  private Feature feature;
  
  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }
  public Feature getFeature() {
    return feature;
  }
  public void setFeature(Feature feature) {
    this.feature = feature;
  }
  
}
