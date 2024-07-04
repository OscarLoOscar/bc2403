package exercise;

// Class cannot extend multiple Parent Class
// but interface can extend multiple interfaces
public interface Exercise extends Run, Walk {
  void swim();
}
