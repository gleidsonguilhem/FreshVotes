package com.toastack.solution.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
  @EmbeddedId
  private CommentId pk;
  private String text;
  
  public CommentId getPk() {
    return pk;
  }
  public void setPk(CommentId pk) {
    this.pk = pk;
  }
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }
  
  
}
