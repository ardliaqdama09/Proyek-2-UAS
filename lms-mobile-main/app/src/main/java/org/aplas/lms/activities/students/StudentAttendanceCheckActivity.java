package org.aplas.lms.activities.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.aplas.lms.R;
import org.aplas.lms.activities.MainActivity;
import org.aplas.lms.configs.ApiUtils;
import org.aplas.lms.configs.SessionManager;
import org.aplas.lms.interfaces.ApiService;
import org.aplas.lms.requests.attendances.CreateAttendanceRequest;
import org.aplas.lms.requests.attendances.IsAlreadyAttendanceRequest;
import org.aplas.lms.requests.auths.LogoutRequest;
import org.aplas.lms.responses.attendances.CreateAttendanceResponse;
import org.aplas.lms.responses.attendances.IsAlreadyAttendanceResponse;
import org.aplas.lms.responses.auths.LogoutResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentAttendanceCheckActivity extends AppCompatActivity {
    RadioGroup rg_status;
    RadioButton radioButton;
    ProgressBar pb_loading;
    Button btn_absen;
    TextView tv_satu, tv_dua;
    Integer _id, user_id;
    String iTitle, iLecture;
    private SessionManager sessionManager;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance_check);

        rg_status = findViewById(R.id.rg_status);
        pb_loading = findViewById(R.id.pb_loading);
        btn_absen = findViewById(R.id.btn_absen);

        tv_satu = findViewById(R.id.textView);
        tv_dua = findViewById(R.id.textView4);

        apiService = ApiUtils.getApiService(this);
        sessionManager = new SessionManager(this);

        final Bundle bundle = getIntent().getExtras();

        _id = bundle.getInt("_id");
        iTitle = bundle.getString("iTitle");
        iLecture   = bundle.getString("iLecture");

        user_id = Integer.valueOf(sessionManager.fetchUserId());

        btn_absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rg_status.getCheckedRadioButtonId();

                radioButton = (RadioButton) findViewById(selectedId);
                int statusInt = 0;

                String status = String.valueOf(radioButton.getText());
                switch (status){
                    case "Hadir":
                        statusInt = 1;
                        break;
                    case "Alpha":
                        statusInt = 2;
                        break;
                    case "Izin":
                        statusInt = 3;
                        break;
                    case "Sakit":
                        statusInt = 4;
                        break;
                }
                Call<CreateAttendanceResponse> call = apiService.create_attendance(new CreateAttendanceRequest(_id, statusInt, user_id));
                call.enqueue(new Callback<CreateAttendanceResponse>() {
                    @Override
                    public void onResponse(Call<CreateAttendanceResponse> call, Response<CreateAttendanceResponse> response) {
                        if(response.code() == 201){
                            Toast.makeText(StudentAttendanceCheckActivity.this, "Absen berhasil!", Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(StudentAttendanceCheckActivity.this, "Absen gagal!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<CreateAttendanceResponse> call, Throwable t) {
                        Toast.makeText(StudentAttendanceCheckActivity.this, "Absen gagal!", Toast.LENGTH_SHORT).show();
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        pb_loading.setVisibility(View.VISIBLE);
        tv_satu.setVisibility(View.GONE);
        tv_dua.setVisibility(View.GONE);
        rg_status.setVisibility(View.GONE);
        btn_absen.setVisibility(View.GONE);

        Call<IsAlreadyAttendanceResponse> call = apiService.is_already_attendance(new IsAlreadyAttendanceRequest(_id, "1", user_id));
        call.enqueue(new Callback<IsAlreadyAttendanceResponse>() {
            @Override
            public void onResponse(Call<IsAlreadyAttendanceResponse> call, Response<IsAlreadyAttendanceResponse> response) {
                IsAlreadyAttendanceResponse isAlreadyAttendanceResponse = response.body();
                if(response.code() == 422){
                    Toast.makeText(StudentAttendanceCheckActivity.this, "Silahkan absen!", Toast.LENGTH_SHORT).show();
                    pb_loading.setVisibility(View.GONE);
                    tv_satu.setVisibility(View.VISIBLE);
                    tv_dua.setVisibility(View.VISIBLE);
                    rg_status.setVisibility(View.VISIBLE);
                    btn_absen.setVisibility(View.VISIBLE);
                }else{
                    finish();
                    Toast.makeText(StudentAttendanceCheckActivity.this, "Anda sudah absen!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<IsAlreadyAttendanceResponse> call, Throwable t) {
                Toast.makeText(StudentAttendanceCheckActivity.this, "get attendance fail!", Toast.LENGTH_SHORT).show();
                finish();
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
}