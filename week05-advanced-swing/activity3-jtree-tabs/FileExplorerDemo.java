import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class FileExplorerDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("File Explorer Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);

            // JTree setup
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("My Computer");
            DefaultMutableTreeNode documents = new DefaultMutableTreeNode("Documents");
            documents.add(new DefaultMutableTreeNode("Resume.docx"));
            documents.add(new DefaultMutableTreeNode("CV.pdf"));
            documents.add(new DefaultMutableTreeNode("Notes.txt"));

            DefaultMutableTreeNode pictures = new DefaultMutableTreeNode("Pictures");
            pictures.add(new DefaultMutableTreeNode("Vacation.jpg"));
            pictures.add(new DefaultMutableTreeNode("Family.jpg"));

            DefaultMutableTreeNode projects = new DefaultMutableTreeNode("Projects");
            DefaultMutableTreeNode javaProject = new DefaultMutableTreeNode("JavaApp");
            javaProject.add(new DefaultMutableTreeNode("Main.java"));
            javaProject.add(new DefaultMutableTreeNode("Utils.java"));
            projects.add(javaProject);

            root.add(documents);
            root.add(pictures);
            root.add(projects);

            JTree tree = new JTree(new DefaultTreeModel(root));
            tree.setFont(new Font("Arial", Font.PLAIN, 14));
            tree.setRowHeight(25);

            JTextArea infoArea = new JTextArea(5, 30);
            infoArea.setEditable(false);
            infoArea.setFont(new Font("Arial", Font.PLAIN, 14));

            tree.addTreeSelectionListener(e -> {
                DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selected != null) {
                    infoArea.setText("You selected: " + selected.getUserObject() + "\nLevel: " + selected.getLevel());
                }
            });

            // JTabbedPane setup
            JTabbedPane tabs = new JTabbedPane();

            JPanel generalTab = new JPanel();
            generalTab.setLayout(new BoxLayout(generalTab, BoxLayout.Y_AXIS));
            generalTab.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            generalTab.add(new JLabel("General Settings"));
            generalTab.add(Box.createVerticalStrut(15));
            generalTab.add(new JCheckBox("Show hidden files"));
            generalTab.add(new JCheckBox("Auto-save every 5 minutes"));
            generalTab.add(new JCheckBox("Enable notifications"));

            JPanel appearanceTab = new JPanel();
            appearanceTab.setLayout(new BoxLayout(appearanceTab, BoxLayout.Y_AXIS));
            appearanceTab.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            appearanceTab.add(new JLabel("Theme:"));
            appearanceTab.add(Box.createVerticalStrut(10));
            ButtonGroup group = new ButtonGroup();
            JRadioButton light = new JRadioButton("Light theme", true);
            JRadioButton dark = new JRadioButton("Dark theme");
            JRadioButton sys = new JRadioButton("System default");
            group.add(light); group.add(dark); group.add(sys);
            appearanceTab.add(light); appearanceTab.add(dark); appearanceTab.add(sys);

            JPanel aboutTab = new JPanel(new BorderLayout());
            aboutTab.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            JTextArea aboutText = new JTextArea("File Explorer Demo v1.0\n\nBuilt with Java Swing as part of\nWeek 5 practical activities\n\nComponents used: JTree, JTabbedPane");
            aboutText.setEditable(false);
            aboutTab.add(new JScrollPane(aboutText), BorderLayout.CENTER);

            tabs.addTab("General", generalTab);
            tabs.addTab("Appearance", appearanceTab);
            tabs.addTab("About", aboutTab);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), tabs);
            splitPane.setDividerLocation(250);

            frame.add(splitPane, BorderLayout.CENTER);
            frame.add(new JScrollPane(infoArea), BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }
}
