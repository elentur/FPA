package de.bht.fpa.mail.s822248.fsnavigation.handlers;

import java.util.Observable;

/**
 * A Singleton of a File Observable
 * 
 * @author marcu_000
 *
 */
public final class FileObservable extends Observable {
  private String path;
  private static final FileObservable FILE_OBSERVABLE = new FileObservable();

  private FileObservable() {

  }

  public static FileObservable getInstance() {
    return FILE_OBSERVABLE;
  }

  public void setPath(String path) {
    setChanged();
    notifyObservers(path);
    this.path = path;
  }

  public String getPath() {
    return path;
  }

}
