/*
 *
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Saurabh Sejpal
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package com.pratiksejpal.util;


import java.math.BigInteger;
import java.util.Map;
import java.util.regex.Pattern;

import com.pratiksejpal.model.EmailType;
import org.apache.velocity.app.VelocityEngine;
import org.mindrot.BCrypt;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 *
 *
 * @author Saurabh Sejpal
 * @version 1.0
 */
public class CommonUtil {

    private static final String ALPHABET = "23456789bcdfghjkmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";
    private static final BigInteger BASE =   new BigInteger(String.valueOf(ALPHABET.length()));
    private static final int RANDOM_STRING_COUNT = 50;
    private static final String GMAIL_REGEX =   "^[a-z0-9](\\.|\\+?[a-z0-9]){5,}@g(oogle)?mail\\.com$";
    private static final Pattern GMAIL_PATTERN = Pattern.compile(GMAIL_REGEX);
    private static final String ENCODING = "UTF-8";
    private static final VelocityEngine VELOCITY_ENGINE = getVelocityEngine();
    
    private static VelocityEngine getVelocityEngine() {
    	return new VelocityEngine();
    }

    public static String encodeURL(BigInteger id) {
        StringBuilder str = new StringBuilder();
        BigInteger primaryKey   =   new BigInteger(String.valueOf(id));
        while (primaryKey.compareTo(BigInteger.ZERO) == 1) {
            str.insert(0, ALPHABET.charAt(primaryKey.mod(BASE).intValue()));
            primaryKey  =   primaryKey.divide(BASE);
        }
        return str.toString();
    }

    public static BigInteger decodeURL(String str) {
        BigInteger  primaryKey  =   BigInteger.ZERO;
        for (int i = 0; i < str.length(); i++) {
            primaryKey  =   primaryKey.multiply(BASE).add(new BigInteger(String.valueOf(ALPHABET.indexOf(str.charAt(i)))));
        }
        return primaryKey;
    }

    public static String generateRandomString() {
        return generateRandomString(RANDOM_STRING_COUNT);
    }

    private static String generateRandomString(int randomStringCharCount) {
        StringBuilder randomStringBuilder = new StringBuilder();
        while (randomStringCharCount-- != 0) {
            randomStringBuilder.append(ALPHABET.charAt((int)(Math.random()*ALPHABET.length())));
        }
        return randomStringBuilder.toString();
    }

    public static boolean validateEmailAddressUsingRegEx(String email) {
        return GMAIL_PATTERN.matcher(email).matches();
    }
    
    public static String encrypt(String input) {
    	String encryptedInput = null;
    	if (input != null) {
    		encryptedInput = BCrypt.hashpw(input, BCrypt.gensalt(12));
		}
    	return encryptedInput;
    }
    
    public static boolean compareEncryption(String input, String encryptedInput) {
    	return BCrypt.checkpw(input, encryptedInput);
    }
    
    public static String generateEmailTemplate(EmailType emailType, Map<String, Object> model) {
    	String email = null;
    	switch (emailType)
        {
    		case VERIFICATION :
    			email = VelocityEngineUtils.mergeTemplateIntoString(VELOCITY_ENGINE, "", ENCODING, model);
    			break;
    			
    		case WELCOME :
    			email = VelocityEngineUtils.mergeTemplateIntoString(VELOCITY_ENGINE, "", ENCODING, model);
    			break;
    			
    		case FORGOT :
    			email = VelocityEngineUtils.mergeTemplateIntoString(VELOCITY_ENGINE, "", ENCODING, model);
    			break;
        }
    	return email;
    }

}
