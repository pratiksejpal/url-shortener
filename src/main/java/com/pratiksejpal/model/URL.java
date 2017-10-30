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
import java.math.BigInteger;

/**
 *
 *
 *
 * @author Saurabh Sejpal
 * @version 1.0
 */
public class URL implements Serializable {

    private static final long serialVersionUID = -5783369501033223295L;
    private BigInteger urlId;
    private String url;
    private String shortURL;
    private long totalClicks;
    private User userId;    

    public URL(String url, String shortURL, long totalClicks, User userId) throws ValidationFailedException {
        this.url = url;
        this.shortURL = shortURL;
        this.totalClicks = totalClicks;
        this.userId = userId;
        this.validateURL();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigInteger getUrlId() {
        return urlId;
    }

    public void setUrlId(BigInteger urlId) {
        this.urlId = urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public long getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(long totalClicks) {
        this.totalClicks = totalClicks;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        URL url1 = (URL) o;

        if (totalClicks != url1.totalClicks) return false;
        if (!urlId.equals(url1.urlId)) return false;
        if (!url.equals(url1.url)) return false;
        if (!shortURL.equals(url1.shortURL)) return false;
        return userId.equals(url1.userId);

    }

    @Override
    public int hashCode() {
        int result = urlId.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + shortURL.hashCode();
        result = 31 * result + (int) (totalClicks ^ (totalClicks >>> 32));
        result = 31 * result + userId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "URL{" +
                "urlId=" + urlId +
                ", url='" + url + '\'' +
                ", shortURL='" + shortURL + '\'' +
                ", totalClicks=" + totalClicks +
                ", userId=" + userId +
                '}';
    }

    private void validateURL() throws ValidationFailedException {
        if (this.url == null) {
            throw new ValidationFailedException("URL can't be Null");
        } else if (this.shortURL == null) {
            throw new ValidationFailedException("Short URL can't be Null");
        } else if (this.userId == null) {
            throw new ValidationFailedException("URL Associated User can't be Null");
        } else if (this.url.trim().length() == 0) {
            throw new ValidationFailedException("URL can't be blank");
        } else if (this.shortURL.trim().length() == 0) {
            throw new ValidationFailedException("Short URL can't be blank");
        }
    }
}
