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
public class URLAnalytics implements Serializable {

    private static final long serialVersionUID = 5693517955902577981L;
    private BigInteger analyticalId;
    private URL urlId;
    private String IP;
    private Browser browserId;
    private OperatingSystem operatingSystemId;    

    public URLAnalytics(URL urlId, String IP, Browser browserId, OperatingSystem operatingSystemId) throws ValidationFailedException {
        this.urlId = urlId;
        this.IP = IP;
        this.browserId = browserId;
        this.operatingSystemId = operatingSystemId;
        this.validateURLAnalytics();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigInteger getAnalyticalId() {
        return analyticalId;
    }

    public void setAnalyticalId(BigInteger analyticalId) {
        this.analyticalId = analyticalId;
    }

    public URL getUrlId() {
        return urlId;
    }

    public void setUrlId(URL urlId) {
        this.urlId = urlId;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public Browser getBrowserId() {
        return browserId;
    }

    public void setBrowserId(Browser browserId) {
        this.browserId = browserId;
    }

    public OperatingSystem getOperatingSystemId() {
        return operatingSystemId;
    }

    public void setOperatingSystemId(OperatingSystem operatingSystemId) {
        this.operatingSystemId = operatingSystemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        URLAnalytics that = (URLAnalytics) o;

        if (!analyticalId.equals(that.analyticalId)) return false;
        if (!urlId.equals(that.urlId)) return false;
        if (!IP.equals(that.IP)) return false;
        if (!browserId.equals(that.browserId)) return false;
        return operatingSystemId.equals(that.operatingSystemId);

    }

    @Override
    public int hashCode() {
        int result = analyticalId.hashCode();
        result = 31 * result + urlId.hashCode();
        result = 31 * result + IP.hashCode();
        result = 31 * result + browserId.hashCode();
        result = 31 * result + operatingSystemId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "URLAnalytics{" +
                "analyticalId=" + analyticalId +
                ", urlId=" + urlId +
                ", IP='" + IP + '\'' +
                ", browserId=" + browserId +
                ", operatingSystemId=" + operatingSystemId +
                '}';
    }

    private void validateURLAnalytics() throws ValidationFailedException {
        if (urlId == null) {
            throw new ValidationFailedException("URL Analytics Associated URL can't be Null");
        } else if (IP == null) {
            throw new ValidationFailedException("IP can't be Null");
        }
        else if (browserId == null) {
            throw new ValidationFailedException("URL Analytics Associated Browser can't be Null");
        }
        else if (operatingSystemId == null) {
            throw new ValidationFailedException("URL Analytics  Associated OperatingSystem can't be Null");
        }
        else if (this.IP.trim().length() == 0) {
            throw new ValidationFailedException("IP can't be blank");
        }
    }
}
