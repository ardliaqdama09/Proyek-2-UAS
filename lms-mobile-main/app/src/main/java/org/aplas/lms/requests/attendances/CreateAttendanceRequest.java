package org.aplas.lms.requests.attendances;

import com.google.gson.annotations.SerializedName;

public class CreateAttendanceRequest {
    @SerializedName("course_id")
    private Integer course_id;

    @SerializedName("status")
    private Integer status;

    @SerializedName("user_id")
    private Integer user_id;

    public CreateAttendanceRequest() {
    }

    public CreateAttendanceRequest(Integer course_id, Integer status, Integer user_id) {
        this.course_id = course_id;
        this.status = status;
        this.user_id = user_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
