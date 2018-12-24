package com.baizhi.entity;

public class Permission {
    private String id;

    private String resourceName;

    private String resourceUrl;

    private String resourceTag;

    private String permissionTag;

    public Permission() {
    }

    public Permission(String id, String resourceName, String resourceUrl, String resourceTag, String permissionTag) {
        this.id = id;
        this.resourceName = resourceName;
        this.resourceUrl = resourceUrl;
        this.resourceTag = resourceTag;
        this.permissionTag = permissionTag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", resourceTag='" + resourceTag + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }
}
