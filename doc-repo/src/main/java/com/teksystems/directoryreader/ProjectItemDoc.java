package com.teksystems.directoryreader;

import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * This class creates the Project item object based on the given object type(file or directory) holding the file or directory name and 
 * type.
 */
public class ProjectItemDoc implements Iterable<ProjectItemDoc>, Comparable<ProjectItemDoc> {

    public static final SortedSet<ProjectItemDoc> EMPTY_PROJECT_ITEM_DOC_SORTED_SET = Collections.emptySortedSet();

    protected ProjectItemDoc parent;

    protected String name = "";

    private int depth = 0;

    private SortedSet<ProjectItemDoc> items = EMPTY_PROJECT_ITEM_DOC_SORTED_SET;

    private ItemType type;

    public ProjectItemDoc() {
        this(null, "");
    }

    public ProjectItemDoc(ProjectItemDoc parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public ProjectItemDoc createDocument(final String name) {
        final ProjectItemDoc document = new ProjectItemDoc(this, name);
        document.setDepth(getDepth() + 1);
        document.setType(ItemType.DOCUMENT);
        return document;
    }

    public ProjectItemDoc createChildProject(final String name) {
        final ProjectItemDoc project = new ProjectItemDoc(this, name);
        project.setDepth(getDepth() + 1);
        project.setType(ItemType.PROJECT);
        return project;
    }

    //====================================================
    // Getters and Setters
    //====================================================
    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public ProjectItemDoc getParent() {
        return parent;
    }

    public String getUrl() {
        return getParent() != null ? getParent().getUrl() + "/" + getName() : getName();
    }

    public String getName() {
        return name;
    }

    public void setParent(ProjectItemDoc parent) {
        this.parent = parent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortedSet<ProjectItemDoc> getItems() {
        return items;
    }

    public void add(ProjectItemDoc document) {
        if (items == EMPTY_PROJECT_ITEM_DOC_SORTED_SET) {
            items = new TreeSet<>();
        }
        items.add(document);
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    @Override
    public Iterator<ProjectItemDoc> iterator() {
        return items.iterator();
    }

    @Override
    public int compareTo(ProjectItemDoc o2) {
        ProjectItemDoc o1 = this;
        String name1 = getName();
        String name2 = o2.getName();
        if (o1.getType() == ItemType.DOCUMENT) {
            name1 = Utils.extractExtension(o1) + "." + Utils.extractNameOnly(o1);
        }
        if (o2.getType() == ItemType.DOCUMENT) {
            name2 = Utils.extractExtension(o2) + "." + Utils.extractNameOnly(o2);
        }
        return name1.compareTo(name2);
    }
}
