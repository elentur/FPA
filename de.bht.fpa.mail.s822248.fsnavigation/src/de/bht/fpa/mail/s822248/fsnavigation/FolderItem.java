package de.bht.fpa.mail.s822248.fsnavigation;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXB;
import java.util.ArrayList;
import org.eclipse.swt.graphics.Image;
import de.bht.fpa.mail.s000000.common.mail.model.IMessageTreeItem;
import de.bht.fpa.mail.s000000.common.mail.model.Message;

/**
 * Represents a Folder item in a File-Folder-Tree
 * 
 * @author marcu_000
 *
 */
public class FolderItem extends FileTreeItem {

  public FolderItem(File file) {
    super(file);
  }

  @Override
  public Image getImage() {
    return Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/folder.png").createImage();
  }

  @Override
  public boolean hasChildren() {
    if (file.list() == null) {
      return false;
    }
    // return file.list().length != 0;

    for (File item : file.listFiles()) {
      if (item.isDirectory()) {

        return true;
      }
    }

    return false;

  }

  @Override
  public List<IMessageTreeItem> getChildren() {
    ArrayList<IMessageTreeItem> children = new ArrayList<>();
    if (file.listFiles() != null) {
      for (File item : file.listFiles()) {
        if (item.isDirectory()) {
          children.add(new FolderItem(item));

        } /*
           * else{ children.add(new FileItem(item)); }
           */
      }
    }

    return children;
  }

  @Override
  public List<Message> getMessages() {
    List<Message> msgs = new ArrayList<>();
    if (file.listFiles() != null) {
      for (File item : file.listFiles()) {
        try {
          Message msg = JAXB.unmarshal(item, Message.class);
          if (msg.getId() != 0) {
            msgs.add(msg);
          }
        } catch (Exception e) {
        }
      }
    }
    return msgs;

  }

}
