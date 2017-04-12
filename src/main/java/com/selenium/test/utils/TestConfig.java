package com.selenium.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Aleksandr on 04.04.2017.
 */
public final class TestConfig {

    public String getSystemUnderTestBaseUrl() {
        String relativeFileLocation = "config.properties";
        Properties property = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(relativeFileLocation)) {
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String systemUnderTestBaseUrl =
                property.getProperty("systemUnderTestBaseUrl");

        return systemUnderTestBaseUrl;

    }


    public String getLdapUser() {
        String relativeFileLocation = "config.properties";
        Properties property = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(relativeFileLocation)) {
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String user =
                property.getProperty("LDAP");

        return user;
    }

    public String getLdapPass() {
        String relativeFileLocation = "config.properties";
        Properties property = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(relativeFileLocation)) {
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String password =
                property.getProperty("PASSWORD");

        return password;
    }

    public String getLocalPort() {
        String relativeFileLocation = "config.properties";
        Properties property = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(relativeFileLocation)) {
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String localPort =
                property.getProperty("local.port");

        return localPort;
    }

    public String getCurrentAuthorizedUser() {
        String relativeFileLocation = "config.properties";
        Properties property = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(relativeFileLocation)) {
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String currentUser =
                property.getProperty("current.user");

        return currentUser;

    }

    public String getRequestDirectory() {
        String relativeFileLocation = "config.properties";
        Properties property = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream(relativeFileLocation)) {
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String requestDirectory =
                property.getProperty("request.directory ");

        return requestDirectory;

    }
}
