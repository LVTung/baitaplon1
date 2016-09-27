package com.kpt.tunglv.lovecalculator.Login;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kpt.tunglv.lovecalculator.API.DataLogin;
import com.kpt.tunglv.lovecalculator.API.NetworkUtil;
import com.kpt.tunglv.lovecalculator.DebugLog.DebugLog;
import com.kpt.tunglv.lovecalculator.R;
import com.kpt.tunglv.lovecalculator.Result.Result;
import com.kpt.tunglv.lovecalculator.Result.Result2;
import com.kpt.tunglv.lovecalculator.Result.Result3;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {
    Button btnCalculate;
    EditText edtYourName;
    EditText edtLovesName;
    ImageView imvYourname;
    Button btnYourname;
    ImageView imvLovename;
    Button btnLovename;
    int REQUES_CODE = 99;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnCalculate = (Button) view.findViewById(R.id.btnFCalculate);
        edtYourName = (EditText) view.findViewById(R.id.edtFLoginYourName);
        edtYourName.setText(edtYourName.getText().toString());
        edtLovesName = (EditText) view.findViewById(R.id.etdFYourlovename);
        edtLovesName.setText(edtLovesName.getText().toString());
//        final DataLogin dataLogin = new DataLogin();
        //Phan anh 2016/09/06
        imvYourname = (ImageView) view.findViewById(R.id.imvYourname);
        btnYourname = (Button) view.findViewById(R.id.btnYourname);
        btnYourname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select File"), REQUES_CODE);
            }
        });


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Truyen du lieu
                Fragment fragment = new Fragment();
                Bundle bundle = new Bundle();
                bundle.putString("ParseJSON", "ParseJSON()");
                fragment.setArguments(bundle);

                String strYourName = edtYourName.getText().toString();
                String strLovesName = edtLovesName.getText().toString();
                requestInput(strYourName, strLovesName);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Result result = Result.newInstance(dataLogin);
                Result2 result2 = new Result2();
                Result3 result3 = new Result3();
//                if (dataLogin.percentage != null) {
                if ((dataLogin.percentage) > 50) {
                    Toast.makeText(getActivity().getApplicationContext(), "msg " + dataLogin.percentage, Toast.LENGTH_SHORT).show();
                    fragmentTransaction.replace(R.id.fragment_place, result);
                }
                if ((dataLogin.percentage) == 50) {
                    fragmentTransaction.replace(R.id.fragment_place, result2);
                } else
                    fragmentTransaction.replace(R.id.fragment_place, result3);
//                }
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    //Get Anh va camera 2016/09/06
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == Activity.RESULT_OK) {
            Bitmap bitmap = null;
            if (data != null) {
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getActivity().getApplicationContext().getContentResolver(), data.getData());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            imvYourname.setImageBitmap(bitmap);
        }
    }

    //Bai cu
    private void requestInput(final String yourname, final String lovesname) {
        //khi phuong thuc la get thi tham so phai dua vao URL
        String url = "https://love-calculator.p.mashape.com/getPercentage" + "?" + "fname=" + yourname + "&sname=" + lovesname;
        StringRequest InputRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        DebugLog.i(response);
                        //Khi thanh cong thi goi lop parseJson
                        ParseJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        DebugLog.i(error.toString());
                    }
                }) {
            //Neu phuong thuc la POST thi getparams
            protected Map<String, String> getHeader() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("X-Mashape-Key", "Oqerzbaug0mshP2BCCyQfFBRRgG1p1tcwAejsnxrqMiQkSP70Y");
                params.put("Accept", "application/json");
                return params;
            }
        };
        NetworkUtil.getsInstance(getActivity().getApplicationContext()).addToRequestQueue(InputRequest);
    }

    DataLogin dataLogin = new DataLogin();

    public void ParseJSON(String response) {
        DebugLog.i(response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            dataLogin.fname = jsonObject.getString("fname");
            DebugLog.i("fname" + dataLogin.fname);
            dataLogin.sname = jsonObject.getString("sname");
            DebugLog.i("sname" + dataLogin.sname);
            dataLogin.percentage = jsonObject.getInt("percentage");
            DebugLog.i("percentage" + dataLogin.percentage);
            dataLogin.result = jsonObject.getString("result");
            DebugLog.i("result" + dataLogin.result);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    ;
}
