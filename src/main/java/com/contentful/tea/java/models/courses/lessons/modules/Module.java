package com.contentful.tea.java.models.courses.lessons.modules;

import com.contentful.tea.java.models.mappable.MappableType;

import java.util.Objects;

public class Module extends MappableType {
  private String title;

  public String getTitle() {
    return title;
  }

  public <T extends Module> T setTitle(String title) {
    this.title = title;
    return (T) this;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Module)) return false;
    final Module module = (Module) o;
    return Objects.equals(getTitle(), module.getTitle());
  }

  @Override public int hashCode() {
    return Objects.hash(getTitle());
  }

  /**
   * @return a human readable string, representing the object.
   */
  @Override public String toString() {
    return "Module { " + super.toString() + " "
        + "title = " + getTitle() + " "
        + "}";
  }
}
