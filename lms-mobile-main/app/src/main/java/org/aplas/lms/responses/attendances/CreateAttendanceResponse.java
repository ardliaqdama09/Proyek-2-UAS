package org.aplas.lms.responses.attendances;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class CreateAttendanceResponse {
    @SerializedName("id")
    private Integer id;

    @SerializedName("course_id")
    private Integer course_id;

    @SerializedName("status")
    private String status;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("updated_at")
    private Date updated_at;

    public CreateAttendanceResponse() {
    }

    public CreateAttendanceResponse(Integer id, Integer course_id, String status, Date created_at, Date updated_at) {
        this.id = id;
        this.course_id = course_id;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
