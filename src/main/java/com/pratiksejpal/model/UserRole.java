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
public class UserRole implements Serializable {

    private static final long serialVersionUID = 8859673074484586370L;
    private int roleId;
    private String roleName;
    private boolean isAdminRole;    

    public UserRole(String roleName, boolean isAdminRole) throws ValidationFailedException {
        this.roleName = roleName;
        this.isAdminRole = isAdminRole;
        this.validateUserRole();
    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public boolean isAdminRole() {
        return isAdminRole;
    }

    public void setAdminRole(boolean adminRole) {
        isAdminRole = adminRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (roleId != userRole.roleId) return false;
        if (isAdminRole != userRole.isAdminRole) return false;
        return roleName.equals(userRole.roleName);

    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + roleName.hashCode();
        result = 31 * result + (isAdminRole ? 1 : 0);
        return result;
    }

    @Override
    public java.lang.String toString() {
        return "UserRole{" +
                "roleId=" + roleId +
                ", roleName=" + roleName +
                ", isAdminRole=" + isAdminRole +
                '}';
    }

    public void validateUserRole() throws ValidationFailedException {
        if (this.roleName == null) {
            throw new ValidationFailedException("Role Name can't be Null");
        } else if (this.roleName.length() == 0) {
            throw new ValidationFailedException("Role Name can't be blank");
        }
    }
}
