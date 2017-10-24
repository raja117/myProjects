package com.teksystems.directoryreader;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        File baseDir = new File(args[0]);
        final DocumentRepoBuilder repoBuilder = new DocumentRepoBuilder(baseDir);
        ProjectItemDoc root = repoBuilder.startBuildingTreeStructure();
        traverse(root);
    }

    /*
     * Prints the crested printable string by checking the item type.
     */
    public static void traverse(ProjectItemDoc projectItemDoc) {
        switch (projectItemDoc.getType()) {
            case DOCUMENT:
                final String formattedString = Utils.createPrintableDocString(projectItemDoc);
                System.out.println(formattedString);
                break;
            case PROJECT:
                ProjectItemDoc project = projectItemDoc;
                final String string = Utils.createPrintableProjectString(project);
                System.out.println(string);
                for (ProjectItemDoc item : project) {
                    traverse(item);
                }
                break;
        }
    }

}
