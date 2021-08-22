package patterns.behavioral.visitor;

import lombok.Data;

@Data
class PerformanceRating {

  private final int id;

  private final int personalRating;

  private int teamAverageRating;

  private int finalRating;

}
