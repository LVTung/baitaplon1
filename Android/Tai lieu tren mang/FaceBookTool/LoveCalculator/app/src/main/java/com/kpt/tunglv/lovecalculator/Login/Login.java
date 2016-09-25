package com.kpt.tunglv.lovecalculator.Login;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kpt.tunglv.lovecalculator.API.NetworkUtil;
import com.kpt.tunglv.lovecalculator.DebugLog.DebugLog;
import com.kpt.tunglv.lovecalculator.R;
import com.kpt.tunglv.lovecalculator.Result.Result;
import com.kpt.tunglv.lovecalculator.Result.Result2;
import com.kpt.tunglv.lovecalculator.Result.Result3;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {
    Button btnCalculate;
    EditText edtYourName;
    EditText edtLovesName;

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
        edtLovesName = (EditText) view.findViewById(R.id.etdFYourlovename);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strYourName = edtYourName.getText().toString();
                String strLovesName = edtLovesName.getText().toString();
                requestInput(strYourName, strLovesName);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Result result = new Result();
                Result2 result2 = new Result2();
                Result3 result3 = new Result3();
                fragmentTransaction.replace(R.id.fragment_place, result);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    private void requestInput(final String yourname, final String lovesname) {
        String url = "https://love-calculator.p.mashape.com/getPercentage";
        StringRequest InputRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        DebugLog.i(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        DebugLog.i(error.toString());
                    }
                }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("fname", yourname);
                params.put("sname", lovesname);
                return params;
            }
        };
        NetworkUtil.getsInstance(getActivity().getApplicationContext()).addToRequestQueue(InputRequest);
    }

    public static String TOKEN = "";

    public void onResponse(String response) {
        DebugLog.i(response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            TOKEN = jsonObject.getString("token");
            DebugLog.i("TOKEN" + TOKEN);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    ;
}
