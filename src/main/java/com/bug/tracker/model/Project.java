package com.bug.tracker.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "PROJECT")
public class Project extends AbstractEntity {

    @NotEmpty
    @Column(name = "NAME_PROJECT", nullable = false)
    private String nameProject;

    @NotEmpty
    @Column(name = "URL", nullable = false)
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_MANAGER_ID", referencedColumnName="ID", nullable = false)
    private User manager;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_TYPE_PROJECT_ID", referencedColumnName="ID", nullable = false)
    private TypeProject typeProject;

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

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public TypeProject getTypeProject() {
        return typeProject;
    }

    public void setTypeProject(TypeProject typeProject) {
        this.typeProject = typeProject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Project project = (Project) o;

        if (!nameProject.equals(project.nameProject)) return false;
        if (!url.equals(project.url)) return false;
        if (!manager.equals(project.manager)) return false;
        return typeProject.equals(project.typeProject);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + nameProject.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + manager.hashCode();
        result = 31 * result + typeProject.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", nameProject='" + nameProject + '\'' +
                ", url='" + url + '\'' +
                ", manager=" + manager +
                ", typeProject=" + typeProject +
                '}';
    }
}
