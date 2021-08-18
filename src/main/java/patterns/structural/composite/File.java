package patterns.structural.composite;

import lombok.Data;

/*
The component base class for composite pattern
defines operations applicable both leaf & composite
*/
@Data
public abstract class File {

  private String name;

  public File(String name) {
    this.name = name;
  }

  public abstract void ls();

  public abstract void addFile(File file);

  public abstract File[] getFiles();

  public abstract boolean removeFile(File file);
}
