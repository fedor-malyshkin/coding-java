package patterns.creational.simplefactory;

import java.time.LocalDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a news post.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NewsPost extends Post {

  private String headline;

  private LocalDate newsTime;

}
