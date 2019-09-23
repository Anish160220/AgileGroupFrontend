package fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.LoginBLL;
import com.example.agilegroupfrontend.R;
import com.example.agilegroupfrontend.StrictMode.StrictMode;
import com.example.agilegroupfrontend.UserDashboardActivity;

import url.Global;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInFragment extends Fragment implements View.OnClickListener {

    private AppCompatButton btnlogin;
    private EditText etUsername, etPassword;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log_in, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword  =   view.findViewById(R.id.etPassword);
        btnlogin = view.findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        final LoginBLL bll = new LoginBLL(etUsername.getText().toString(),etPassword.getText().toString());
        StrictMode.StrictMode();

        if(bll.checkUser()){
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("User", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putInt("user_id", Global.userId);
            editor.putString("token", Global.Token);

            editor.commit();
            Intent intent = new Intent(getActivity(), UserDashboardActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getActivity(),"Either username or password is incorrect",Toast.LENGTH_LONG).show();
        }


//        String username = etUsername.getText().toString();
//        String password = etPassword.getText().toString();
//
//        Users users = new Users(username,password);
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Url.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        AuctionSystemAPI auctionSystemAPI = retrofit.create(AuctionSystemAPI.class);
//
//        Call<LoginSignupResponse> usersCall = auctionSystemAPI.checkUser(users);
//        usersCall.enqueue(new Callback<LoginSignupResponse>() {
//            @Override
//            public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
//                if(!response.isSuccessful()){
//                    Toast.makeText(getActivity(),"Either username or paswprd is incorrect",Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                Url.userId = response.body().getUserId();
//                Url.Token = response.body().getToken();
//
//                      Intent intent = new Intent(getActivity(),UserDashboardActivity.class);
//                      startActivity(intent);
//                      getActivity().finish();
//
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<LoginSignupResponse> call, Throwable t) {
//                Toast.makeText(getActivity(),"Error : " + t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
//
//            }
//        });

    }
}

