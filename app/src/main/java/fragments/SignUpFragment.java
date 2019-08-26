package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agilegroupfrontend.BLL.SignupBLL;
import com.example.agilegroupfrontend.R;
import com.example.agilegroupfrontend.StrictMode.StrictMode;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {


    private EditText etFirstname, etLastname, etRegUsername, etRegPassword, etRegRePassword;
    private Button btnRegRegister;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        etFirstname = view.findViewById(R.id.etFirstname);
        etLastname = view.findViewById(R.id.etLastname);
        etRegUsername = view.findViewById(R.id.etRegUsername);
        etRegPassword = view.findViewById(R.id.etRegPassword);
        btnRegRegister = view.findViewById(R.id.btnRegRegister);
        etRegRePassword= view.findViewById(R.id.etRegRePassword);

        btnRegRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });


        return view;

    }

    private void Save() {
        if (validate()){
            final SignupBLL bll = new SignupBLL(etFirstname.getText().toString(),etLastname.getText().toString(),etRegUsername.getText().toString(),etRegPassword.getText().toString());
            StrictMode.StrictMode();
            if(bll.checkRegister()){
                Toast.makeText(getContext(),"User Added Successfully",Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getActivity(),"username already exist",Toast.LENGTH_LONG).show();
            }

//            String firstName = etFirstname.getText().toString();
//            String lastName = etLastname.getText().toString();
//            String regUsername = etRegUsername.getText().toString();
//            String regPassword = etRegPassword.getText().toString();
////            String reregPassword = etRegRePassword.getText().toString();
//
//            Users users = new Users(firstName,lastName,regUsername,regPassword);
//
//            AuctionSystemAPI auctionSystemAPI = Url.getInstance().create(AuctionSystemAPI.class);
//            Call<LoginSignupResponse> usercall = auctionSystemAPI.addUser(users);
//
//            usercall.enqueue(new Callback<LoginSignupResponse>() {
//                @Override
//                public void onResponse(Call<LoginSignupResponse> call, Response<LoginSignupResponse> response) {
//                    if(!response.isSuccessful()){
//
//                        Toast.makeText(getContext(),"User already exists",Toast.LENGTH_SHORT).show();
//                        return;
//                }
//                    Toast.makeText(getContext(),"User Added Successfully Slide Right for Login",Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onFailure(Call<LoginSignupResponse> call, Throwable t) {
//                    Toast.makeText(getContext(),"Error:" +t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
////
//                }
//            });

//            usercall.enqueue(new Callback<Void>() {
//                @Override
//                public void onResponse(Call<Void> call, Response<Void> response) {
//                    if(!response.isSuccessful()){
//
//
//                        Toast.makeText(getContext(),"User already exists",Toast.LENGTH_SHORT).show();
//                        return;
//                    }
//                    Toast.makeText(getContext(),"User Added Successfully",Toast.LENGTH_SHORT).show();
//
//                }
//
//                @Override
//                public void onFailure(Call<Void> call, Throwable t) {
//                    Toast.makeText(getContext(),"Error:" +t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
//
//                }
//            });

        }
    }




    private boolean validate() {
        boolean flag = true;
        if(TextUtils.isEmpty(etFirstname.getText().toString())){
            etFirstname.setError("Enter First Name");
            etFirstname.requestFocus();
            flag= false;
        }
        else if(TextUtils.isEmpty(etLastname.getText().toString())){
            etLastname.setError("Enter Last Name");
            etLastname.requestFocus();
            flag= false;
        }
        else if(TextUtils.isEmpty(etRegUsername.getText().toString())){
            etRegUsername.setError("Enter Username");
            etRegUsername.requestFocus();
            flag= false;
        }
        else if(TextUtils.isEmpty(etRegPassword.getText().toString())){
            etRegPassword.setError("Enter Your Password");
            etRegPassword.requestFocus();
            flag= false;
        }
        else if(TextUtils.isEmpty(etRegRePassword.getText().toString())){
            etRegRePassword.setError("Enter Your Re-Password");
            etRegRePassword.requestFocus();
            flag= false;
        }



        return  flag;
    }


}
