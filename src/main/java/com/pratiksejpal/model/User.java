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
public class User implements Serializable {

    private static final long serialVersionUID = 6049046794185000393L;
    private long userId;
    private String userName;
    private String password;
    private boolean isVerifiedUser;
    private UserRole roleId;
    private int loginAttempts;    

    public User(String userName, String password, boolean isVerifiedUser, UserRole roleId, int loginAttempts) throws ValidationFailedException {
        this.userName = userName;
        this.password = password;
        this.isVerifiedUser = isVerifiedUser;
        this.roleId = roleId;
        this.loginAttempts = loginAttempts;
        this.validateUser();
    }
    
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isVerifiedUser() {
		return isVerifiedUser;
	}

	public void setVerifiedUser(boolean isVerifiedUser) {
		this.isVerifiedUser = isVerifiedUser;
	}

	public UserRole getRoleId() {
		return roleId;
	}

	public void setRoleId(UserRole roleId) {
		this.roleId = roleId;
	}

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (userId != user.userId) return false;
		if (isVerifiedUser != user.isVerifiedUser) return false;
		if (loginAttempts != user.loginAttempts) return false;
		if (!userName.equals(user.userName)) return false;
		if (!password.equals(user.password)) return false;
		return roleId.equals(user.roleId);

	}

	@Override
	public int hashCode() {
		int result = (int) (userId ^ (userId >>> 32));
		result = 31 * result + userName.hashCode();
		result = 31 * result + password.hashCode();
		result = 31 * result + (isVerifiedUser ? 1 : 0);
		result = 31 * result + roleId.hashCode();
		result = 31 * result + loginAttempts;
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", isVerifiedUser=" + isVerifiedUser +
				", roleId=" + roleId +
				", loginAttempts=" + loginAttempts +
				'}';
	}

	private void validateUser() throws ValidationFailedException {
		if (this.userName == null) {
			throw new ValidationFailedException("User Name can't be Null");
		} else if (this.password == null) {
			throw new ValidationFailedException("Password can't be Null");
		} else if (this.roleId == null) {
			throw new ValidationFailedException("User Associated Role can't be Null");
		} else if (this.userName.trim().length() == 0) {
			throw new ValidationFailedException("User Name can't be blank");
		} else if (this.password.trim().length() == 0) {
			throw new ValidationFailedException("Password can't be blank");
		}
	}
	
	
}
