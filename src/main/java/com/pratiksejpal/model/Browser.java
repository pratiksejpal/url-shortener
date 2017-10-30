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

package com.pratiksejpal.model;

import com.pratiksejpal.exception.ValidationFailedException;

import java.io.Serializable;

/**
 *
 *
 *
 * @author Saurabh Sejpal
 * @version 1.0
 */
public class Browser implements Serializable {

    private static final long serialVersionUID = 3772396073875352711L;
    private int browserId;
    private String browserName;
    private String browserVersion;

	public Browser(String browserName, String browserVersion) throws ValidationFailedException {
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.validateBrowser();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getBrowserId() {
        return browserId;
    }

    public void setBrowserId(int browserId) {
        this.browserId = browserId;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Browser browser = (Browser) o;

        if (browserId != browser.browserId) return false;
        if (!browserName.equals(browser.browserName)) return false;
        return browserVersion.equals(browser.browserVersion);

    }

    @Override
    public int hashCode() {
        int result = browserId;
        result = 31 * result + browserName.hashCode();
        result = 31 * result + browserVersion.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Browser{" +
                "browserId=" + browserId +
                ", browserName='" + browserName + '\'' +
                ", browserVersion='" + browserVersion + '\'' +
                '}';
    }

    private void validateBrowser() throws ValidationFailedException {
        if (this.browserName == null) {
            throw new ValidationFailedException("Browser Name can't be Null");
        } else if (this.browserVersion == null) {
            throw new ValidationFailedException("Browser Version can't be blank");
        } else if (this.browserName.trim().length() == 0) {
            throw new ValidationFailedException("Browser Name can't be blank");
        } else if (this.browserVersion.trim().length() == 0) {
            throw new ValidationFailedException("Browser Version can't be blank");
        }
    }
}
