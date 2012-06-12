/**
 * Copyright 2011 multibit.org
 *
 * Licensed under the MIT license (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://opensource.org/licenses/mit-license.php
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.multibit.viewsystem.swing.view;

import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.multibit.controller.MultiBitController;
import org.multibit.utils.ImageLoader;
import org.multibit.viewsystem.View;
import org.multibit.viewsystem.swing.ColorAndFontConstants;
import org.multibit.viewsystem.swing.MultiBitFrame;
import org.multibit.viewsystem.swing.view.components.MultiBitLabel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The messages view
 */
public class MessagesPanel extends JPanel implements View {

    private static final Logger log = LoggerFactory.getLogger(MessagesPanel.class);

    private static final long serialVersionUID = 191346512399957705L;

    private static final String SPLASH_ICON_FILE = "/images/splash.jpg";

    private static final String MULTIBIT_URL = "http://multibit.org";
    
    private MultiBitController controller;

  /**
     * Creates a new {@link HelpAboutPanel}.
     */
    public MessagesPanel(MultiBitController controller, MultiBitFrame mainFrame) {        
         setBackground(ColorAndFontConstants.VERY_LIGHT_BACKGROUND_COLOR);
        this.controller = controller;

        String versionNumber = controller.getLocaliser().getVersionNumber();

        String versionText = controller.getLocaliser().getString("helpAboutAction.versionText",
                new Object[] { versionNumber });

        GridBagConstraints constraints = new GridBagConstraints();
        setLayout(new GridBagLayout());
        
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.CENTER;
        JPanel fillerPanel1 = new JPanel();
        fillerPanel1.setOpaque(false);
        add(fillerPanel1, constraints);

        ImageIcon imageIcon = ImageLoader.createImageIcon(SPLASH_ICON_FILE);
        JLabel splashLabel = new JLabel();
        splashLabel.setIcon(imageIcon);
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.4;
        constraints.anchor = GridBagConstraints.CENTER;
        add(splashLabel, constraints);

        MultiBitLabel titleLabel = new MultiBitLabel("");
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        titleLabel.setText(controller.getLocaliser().getString("helpAboutAction.messageBoxTitle"));

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.CENTER;
        add(titleLabel, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.CENTER;
        MultiBitLabel urlLabel = new MultiBitLabel(MULTIBIT_URL);
        add(urlLabel, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.1;
        constraints.anchor = GridBagConstraints.CENTER;
        MultiBitLabel versionLabel = new MultiBitLabel(versionText);
        add(versionLabel, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.weightx = 1;
        constraints.weighty = 0.2;
        constraints.anchor = GridBagConstraints.CENTER;
        JPanel fillerPanel2 = new JPanel();
        fillerPanel2.setOpaque(false);
        add(fillerPanel2, constraints);

        applyComponentOrientation(ComponentOrientation.getOrientation(controller.getLocaliser().getLocale()));
    }

    @Override
    public void navigateAwayFromView() {
    }

    @Override
    public void displayView() {        
    }
       
    @Override
    public Icon getViewIcon() {
        return ImageLoader.createImageIcon(ImageLoader.MESSAGES_ICON_FILE);
    }

    @Override
    public String getViewTitle() {
        return controller.getLocaliser().getString("messagesPanel.text");
    }
    
    @Override
    public String getViewTooltip() {
        return controller.getLocaliser().getString("messagesPanel.tooltip");
    }

    @Override
    public int getViewId() {
        return View.MESSAGES_VIEW;
    }
}