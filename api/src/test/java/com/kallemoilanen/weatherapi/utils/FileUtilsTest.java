package com.kallemoilanen.weatherapi.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class FileUtilsTest {

    @Test
    public void ShouldReadFileContentAsString() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("TestFile.txt").getFile());
        String readText = "";
        try {
            readText = FileUtils.readFile(file.getPath(), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail("Error setting up the test. Sample XML-file could not be read!");
        }

        Assert.assertEquals("Sample text", readText);
    }
}
