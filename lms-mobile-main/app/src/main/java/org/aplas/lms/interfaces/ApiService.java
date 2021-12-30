package org.aplas.lms.interfaces;

import org.aplas.lms.configs.Constants;
import org.aplas.lms.requests.attendances.CreateAttendanceRequest;
import org.aplas.lms.requests.attendances.IsAlreadyAttendanceRequest;
import org.aplas.lms.requests.auths.LoginRequest;
import org.aplas.lms.requests.auths.LogoutRequest;
import org.aplas.lms.requests.auths.RegisterRequest;
import org.aplas.lms.requests.courses.AddCourseRequest;
import org.aplas.lms.responses.attendances.CreateAttendanceResponse;
import org.aplas.lms.responses.attendances.IsAlreadyAttendanceResponse;
import org.aplas.lms.responses.auths.LoginResponse;
import org.aplas.lms.responses.auths.LogoutResponse;
import org.aplas.lms.responses.auths.RegisterResponse;
import org.aplas.lms.responses.courses.CourseResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    // Auth

    @Headers("Accept: application/json")
    @POST(Constants.LOGIN_URL)
    Call<LoginResponse> login(@Body LoginRequest request);

    @Headers("Accept: application/json")
    @POST(Constants.LOGOUT_URL)
    Call<LogoutResponse> logout(@Body LogoutRequest request);

    @Headers("Accept: application/json")
    @POST(Constants.REGISTER_URL)
    Call<RegisterResponse> register(@Body RegisterRequest request);

    // Course

    @Headers("Accept: application/json")
    @POST(Constants.CREATE_COURSE_URL)
    Call<CourseResponse> create_course(@Body AddCourseRequest request);

    @Headers("Accept: application/json")
    @GET(Constants.GET_ALL_COURSE_URL)
    Call<ArrayList<CourseResponse>> get_all_course();

    @Headers("Accept: application/json")
    @GET(Constants.GET_COURSE_BY_ID_USER_URL)
    Call<ArrayList<CourseResponse>> get_course_by_id_user();

    // Attendance

    @Headers("Accept: application/json")
    @POST(Constants.IS_ALREADY_ATTENDANCE_URL)
    Call<IsAlreadyAttendanceResponse> is_already_attendance(@Body IsAlreadyAttendanceRequest request);

    @Headers("Accept: application/json")
    @POST(Constants.CREATE_ATTENDANCE_URL)
    Call<CreateAttendanceResponse> create_attendance(@Body CreateAttendanceRequest request);

//
//
//    // Attendances
//
//    @POST(Constants.CREATE_PRODUCT)
//    Call<AddProductResponse> create_product(@Body AddProductRequest request);
//
//    @GET(Constants.GET_PRODUCT_BY_SHOP_ID)
//    Call<List<GetProductByShopIdResponse>> get_product_by_shop_id();
//
//    @POST(Constants.UPDATE_PRODUCT)
//    Call<UpdateProductResponse> update_product(@Body UpdateProductRequest request);

}
