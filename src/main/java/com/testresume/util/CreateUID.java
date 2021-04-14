package com.testresume.util;

import com.testresume.entity.Resume;
import org.apache.commons.lang3.text.WordUtils;

import java.util.Random;

public class CreateUID {

    private static final String UID_DELIMETER = "-";
    private static final String ALPHABET = "1234567890";
    private static final int LETTER_COUNT = 1;

    public static String normalizeName(String name) {
        return name.trim().toLowerCase();
    }

    public static String capitalizeName(String name) {
        return WordUtils.capitalize(normalizeName(name));
    }

    public static String generateProfileUid(Resume resume) {
        return normalizeName(resume.getFirstName()) + UID_DELIMETER + normalizeName(resume.getLastName()) + UID_DELIMETER + normalizeName(resume.getMiddleName());
    }

    public static String regenerateUidWithRandomSuffix(String baseUid) {
        return baseUid + UID_DELIMETER + generateRandomSuffix(LETTER_COUNT);
    }

    public static String generateRandomSuffix(int letterCount) {
        Random r = new Random();
        StringBuilder uid = new StringBuilder();
        for (int i = 0; i < letterCount; i++) {
            uid.append(ALPHABET.charAt(r.nextInt(ALPHABET.length())));
        }
        return uid.toString();
    }

}
