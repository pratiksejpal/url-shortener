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
import java.util.Date;

/**
 *
 *
 *
 * @author Saurabh Sejpal
 * @version 1.0
 */
public class ForgotPassword implements Serializable {

    private static final long serialVersionUID = -3804652094729204014L;
    private BigInteger forgotPasswordId;
    private String forgotPasswordCode;
    private User userId;
    private Date codeGenerationDate;    

    public ForgotPassword(String forgotPasswordCode, User userId, Date codeGenerationDate) throws ValidationFailedException {
        this.forgotPasswordCode = forgotPasswordCode;
        this.userId = userId;
        this.codeGenerationDate = codeGenerationDate;
        this.validateForgotPassword();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigInteger getForgotPasswordId() {
        return forgotPasswordId;
    }

    public void setForgotPasswordId(BigInteger forgotPasswordId) {
        this.forgotPasswordId = forgotPasswordId;
    }

    public String getForgotPasswordCode() {
        return forgotPasswordCode;
    }

    public void setForgotPasswordCode(String forgotPasswordCode) {
        this.forgotPasswordCode = forgotPasswordCode;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Date getCodeGenerationDate() {
        return codeGenerationDate;
    }

    public void setCodeGenerationDate(Date codeGenerationDate) {
        this.codeGenerationDate = codeGenerationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForgotPassword that = (ForgotPassword) o;

        if (!forgotPasswordId.equals(that.forgotPasswordId)) return false;
        if (!forgotPasswordCode.equals(that.forgotPasswordCode)) return false;
        if (!userId.equals(that.userId)) return false;
        return codeGenerationDate.equals(that.codeGenerationDate);

    }

    @Override
    public int hashCode() {
        int result = forgotPasswordId.hashCode();
        result = 31 * result + forgotPasswordCode.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + codeGenerationDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ForgotPassword{" +
                "forgotPasswordId=" + forgotPasswordId +
                ", forgotPasswordCode='" + forgotPasswordCode + '\'' +
                ", userId=" + userId +
                ", codeGenerationDate=" + codeGenerationDate +
                '}';
    }

    private void validateForgotPassword() throws ValidationFailedException {
        if (this.forgotPasswordCode == null) {
            throw new ValidationFailedException("Forgot Password Code can't be Null");
        } else if (this.userId == null) {
            throw new ValidationFailedException("Forgot Password Associated User can't be Null");
        } else if (this.codeGenerationDate == null) {
            throw new ValidationFailedException("Forgot Password Date can't be Null");
        } else if (this.forgotPasswordCode.trim().length() == 0) {
            throw new ValidationFailedException("Forgot Password Code can't be blank");
        }
    }
}
