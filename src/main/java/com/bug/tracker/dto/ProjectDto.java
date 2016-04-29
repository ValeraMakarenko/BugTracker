package com.bug.tracker.dto;

public class ProjectDto extends AbstractDto {

    private String nameProject;
    private String url;
    private int managerId;
    private int typeProjectId;

    public ProjectDto(int id, String nameProject, String url, int managerId, int typeProjectId) {
        super(id);
        this.nameProject = nameProject;
        this.url = url;
        this.managerId = managerId;
        this.typeProjectId = typeProjectId;
    }

    public ProjectDto() {

    }

    public String getNameProject() {
        return nameProject;
    }

    public void setNameProject(String nameProject) {
        this.nameProject = nameProject;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getTypeProjectId() {
        return typeProjectId;
    }

    public void setTypeProjectId(int typeProjectId) {
        this.typeProjectId = typeProjectId;
    }
}
