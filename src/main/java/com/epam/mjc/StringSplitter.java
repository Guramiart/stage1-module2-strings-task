package com.epam.mjc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> splitList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(String el : delimiters) {
            stringBuilder.append(el);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(source, stringBuilder.toString());
        while (stringTokenizer.hasMoreTokens()) {
            splitList.add(stringTokenizer.nextToken());
        }
        return splitList;
    }
}
