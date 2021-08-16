package patterns.creational.simplefactory;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Represents a product information post.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductPost extends Post {

  private String imageUrl;

  private String name;

}
