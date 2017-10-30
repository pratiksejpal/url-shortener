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
public class EmailVerification implements Serializable {

    private static final long serialVersionUID = -1340723508226437801L;
    private BigInteger verificationId;
    private String verificationCode;
    private User userId;
    private Date codeGenerationDate;    

    public EmailVerification(String verificationCode, User userId, Date codeGenerationDate) throws ValidationFailedException {
        this.verificationCode = verificationCode;
        this.userId = userId;
        this.codeGenerationDate = codeGenerationDate;
        this.validateEmailVerification();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigInteger getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(BigInteger verificationId) {
        this.verificationId = verificationId;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
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

        EmailVerification that = (EmailVerification) o;

        if (!verificationId.equals(that.verificationId)) return false;
        if (!verificationCode.equals(that.verificationCode)) return false;
        return userId.equals(that.userId);

    }

    @Override
    public int hashCode() {
        int result = verificationId.hashCode();
        result = 31 * result + verificationCode.hashCode();
        result = 31 * result + userId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "EmailVerification{" +
                "verificationId=" + verificationId +
                ", verificationCode='" + verificationCode + '\'' +
                ", userId=" + userId +
                ", codeGenerationDate=" + codeGenerationDate +
                '}';
    }

    private void validateEmailVerification() throws ValidationFailedException {
        if (this.verificationCode == null) {
            throw new ValidationFailedException("Email Verification Code can't be Null");
        } else if (this.userId == null) {
            throw new ValidationFailedException("Email Verification Associated User can't be Null");
        } else if (this.codeGenerationDate == null) {
            throw new ValidationFailedException("Email Verification Date can't be Null");
        } else if (this.verificationCode.trim().length() == 0) {
            throw new ValidationFailedException("Email Verification Code can't be blank");
        }
    }
}
