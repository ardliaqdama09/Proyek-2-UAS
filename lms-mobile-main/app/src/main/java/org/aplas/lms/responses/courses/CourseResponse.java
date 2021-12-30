package org.aplas.lms.responses.courses;

import com.google.gson.annotations.SerializedName;

import org.aplas.lms.models.UserLectureModel;

import java.util.Date;

public class CourseResponse {
    @SerializedName("id")
    private Integer id;

    @SerializedName("user")
    private UserLectureModel user;

    @SerializedName("name")
    private String name;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("updated_at")
    private Date updated_at;

    public CourseResponse() {
    }

    public CourseResponse(Integer id, UserLectureModel user, String name, Date created_at, Date updated_at) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserLectureModel getUser() {
        return user;
    }

    public void setUser(UserLectureModel user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
