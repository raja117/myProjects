package com.teksystems.directoryreader;

public class Utils {

    public static final String PROJECT_STRING_FORMAT = "%s Project: %s - URL: %s";

    public static final String DOCUMENT_STRING_FORMAT = "%s Document: %s - Extension: %s - URL: %s";

    public static Object extractExtension(ProjectItemDoc document) {
        return document.getName().substring(document.getName().lastIndexOf('.') + 1);
    }

    public static String extractNameOnly(ProjectItemDoc document) {
        return document.getName().substring(0, document.getName().lastIndexOf('.'));
    }

    /*
     * creates the printable string for the item type directory and gets the path of the item.
     */
    public static String createPrintableProjectString(ProjectItemDoc project) {
        int depth = project.getDepth();
        String s = "";
        while (depth-- > 0) s += " ";
        s += "-";
        String result = String.format(PROJECT_STRING_FORMAT, s, project.getName(), project.getUrl());
        return result;
    }

    /*
     * create the printable string for the item type document and gets the path and extension of the item.
     */
    public static String createPrintableDocString(ProjectItemDoc document) {
        int depth = document.getDepth();
        String s = "";
        while (depth-- > 0) s += " ";
        s += " -";
        String result = String.format(DOCUMENT_STRING_FORMAT, s, extractNameOnly(document), extractExtension(document), document.getUrl());
        return result;
    }
}
