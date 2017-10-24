package com.teksystems.directoryreader;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public class DocumentRepoBuilder implements FileConsumer {

    private File baseDir;
    private final ProjectItemDoc root;

    private HashMap<String, ProjectItemDoc> registeredProjects = new HashMap<>();


    public DocumentRepoBuilder(final File baseDir) {
        this.baseDir = baseDir;
        root = new ProjectItemDoc();
        root.setName(baseDir.getName());
        root.setType(ItemType.PROJECT);
        initialize(baseDir);
    }

    /*
     * Intializes building the project repo from the root directory
     */
    private void initialize(File baseDir) {
        registerNewProject(baseDir, root);
        if (baseDir.getParent() != null) {
        }
    }
    /*
     * Starts building the tree structure from the root directory until
     * the end of the file structure 
     */
    public ProjectItemDoc startBuildingTreeStructure() {
        traverse(baseDir);
        return root;
    }

    /*
     * Process the each file object based on the object type (file or directory)
     * and fetches the child objects for the parent object by creating the project item object.
     */
    @Override
    public void processFile(File file) {
        boolean directory = file.isDirectory();
        ProjectItemDoc parent = findRegisteredProject(file);
        ProjectItemDoc child;
        if (directory) {
            child = parent.createChildProject(file.getName());
            registerNewProject(file, child);
        } else {
            child = parent.createDocument(file.getName());
        }
        parent.add(child);

    }

    private void registerNewProject(File file, ProjectItemDoc child) {
        registeredProjects.put(file.getAbsolutePath(), child);
    }

    private ProjectItemDoc findRegisteredProject(File file) {
        final File parentFile = file.getParentFile();
        final String absolutePath = parentFile.getAbsolutePath();
        final boolean containsKey = registeredProjects.containsKey(absolutePath);
        if (containsKey) {
            return registeredProjects.get(absolutePath);
        } else {
            return null;
        }
    }

    /*
     * traverses through the given file object and occurs recursively for the document 
     * type folder and processes it if it is the file.
     */
    public void traverse(File file) {
        if (file.isDirectory()) {
            final File[] files = file.listFiles();
            Arrays.sort(files, DocumentRepoBuilder::compareFiles);
            for (File eachFile : files) {
                processFile(eachFile);
                if (eachFile.isDirectory()) {
                    traverse(eachFile);
                }
            }
        } else {
            processFile(file);
        }
    }

    public static int compareFiles(File file1, File file2) {
        final String name1 = file1.getName();
        final int dotIndex1 = name1.lastIndexOf('.');
        final String extension1 = dotIndex1 != -1 ? name1.substring(dotIndex1 + 1) : "";
        final String fileNameOnly1 = dotIndex1 != -1 ? name1.substring(0, dotIndex1) : name1;
        final String[] parts3 = {fileNameOnly1, extension1};
        final String name = file2.getName();
        final int dotIndex2 = name.lastIndexOf('.');
        final String extension = dotIndex2 != -1 ? name.substring(dotIndex2 + 1) : "";
        final String fileNameOnly = dotIndex2 != -1 ? name.substring(0, dotIndex2) : name;
        final String[] parts = {fileNameOnly, extension};
        return (parts3[1].toLowerCase() + '.' + parts3[0]).compareTo(parts[1].toLowerCase() + '.' + parts[0]);
    }

}
