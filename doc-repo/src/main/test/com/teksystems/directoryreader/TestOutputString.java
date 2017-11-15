package com.teksystems.directoryreader;


import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;

public class TestOutputString {

    private static ProjectItemDoc rootProject;

    @BeforeClass
    public static void setup() {
        final File root = new File("testdirectory/Main Project");
        DocumentRepoBuilder documentRepoBuilder = new DocumentRepoBuilder(root);
        rootProject = documentRepoBuilder.startBuildingTreeStructure();
    }

    @Test
    public void testProjectOutputString() {
        final String actual = Utils.createPrintableProjectString(rootProject);
        final String expected = "- Project: Main Project - URL: Main Project";
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testDocumentOutputString() {
        SortedSet<ProjectItemDoc> items = rootProject.getItems().first().getItems();
        List<ProjectItemDoc> collect = items.stream().filter(item -> item.getType() == ItemType.DOCUMENT).collect(Collectors.toList());
        final String actual = Utils.createPrintableDocString(collect.get(0));
        final String expected = "   - Document: WordFile1 - Extension: docx - URL: Main Project/Project 1/WordFile1.docx";
        Assert.assertEquals(expected, actual);

    }

}
