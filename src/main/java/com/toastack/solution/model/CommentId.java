package com.toastack.solution.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CommentId implements Serializable {
   
  private static final long serialVersionUID = 5791205864337358868L;
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
