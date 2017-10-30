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
public class OperatingSystem implements Serializable {

    private static final long serialVersionUID = 6061331152846025525L;
    private int osId;
    private String osName;
    private String osVersion;    

    public OperatingSystem(String osName, String osVersion) throws ValidationFailedException {
        this.osName = osName;
        this.osVersion = osVersion;
        this.validateOperatingSystem();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getOsId() {
        return osId;
    }

    public void setOsId(int osId) {
        this.osId = osId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperatingSystem that = (OperatingSystem) o;

        if (osId != that.osId) return false;
        if (!osName.equals(that.osName)) return false;
        return osVersion.equals(that.osVersion);

    }

    @Override
    public int hashCode() {
        int result = osId;
        result = 31 * result + osName.hashCode();
        result = 31 * result + osVersion.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OperatingSystem{" +
                "osId=" + osId +
                ", osName='" + osName + '\'' +
                ", osVersion='" + osVersion + '\'' +
                '}';
    }

    private void validateOperatingSystem() throws ValidationFailedException {
        if (this.osName == null) {
            throw new ValidationFailedException("Operating System Name can't be Null");
        } else if (this.osVersion == null) {
            throw new ValidationFailedException("Operating System Version can't be Null");
        } else if (this.osName.trim().length() == 0) {
            throw new ValidationFailedException("Operating System Name can't be blank");
        } else if (this.osVersion.trim().length() == 0) {
            throw new ValidationFailedException("Operating System Version can't be blank");
        }
    }
}
