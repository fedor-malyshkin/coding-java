package patterns.creational.simplefactory;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * Abstract post class. Represents a generic post on a web site.
 */
@Data
public abstract class Post {

  private Long id;

  private String title;

  private String content;

  private LocalDateTime createdOn;

  private LocalDateTime publishedOn;


}
