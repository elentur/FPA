package de.bht.fpa.mail.s822248.main;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

  public void createInitialLayout(IPageLayout layout) {
    final float widthTree = 0.3f;
    final float widthTabel = 0.4f;
    layout.addView("de.bht.fpa.mail.s822248.fsnavigation.view1", IPageLayout.LEFT, widthTree, layout.getEditorArea());
    layout.addView("de.bht.fpa.mail.s822248.imapnavigation.view1", IPageLayout.LEFT, widthTree, layout.getEditorArea());
    layout.addView("de.bht.fpa.mail.s822248.maillist.view1", IPageLayout.TOP, widthTabel, layout.getEditorArea());
    layout.addView("de.bht.fpa.mail.s000000.common.messageview", IPageLayout.BOTTOM, widthTabel, layout.getEditorArea());
    
    layout.setEditorAreaVisible(false);
  }
}
