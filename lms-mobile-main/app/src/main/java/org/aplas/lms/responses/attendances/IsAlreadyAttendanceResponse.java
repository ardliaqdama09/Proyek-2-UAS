package org.aplas.lms.responses.attendances;

import com.google.gson.annotations.SerializedName;

import org.aplas.lms.datas.AuthData;
import org.aplas.lms.models.UserModel;

public class IsAlreadyAttendanceResponse {
    @SerializedName("status")
    private Boolean status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private String[] data;

    public IsAlreadyAttendanceResponse() {
    }

    public IsAlreadyAttendanceResponse(Boolean status, String message, String[] data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }
}
