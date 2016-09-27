package com.kpt.tunglv.lovecalculator.Result;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kpt.tunglv.lovecalculator.API.DataLogin;
import com.kpt.tunglv.lovecalculator.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Result extends Fragment {
    TextView txtfname;
    TextView txtsname;
    TextView txtpercentage;
    TextView txtresult;
    Button btnRetry;

    public Result() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Get du lieu
//        Bundle bundle = this.getArguments();
//        String dataInput = bundle.getString("ParseJSON", "defaultValue");
//        DataLogin dataLogin = bundle.getParcelable("KEY");

        txtfname = (TextView)view.findViewById(R.id.txtfnamers);
        txtfname.setText(getArguments().getString("KEY"));
//        txtfname.setText(DataLogin.fname);
        txtsname = (TextView)view.findViewById(R.id.txtSnamers);
        txtpercentage = (TextView)view.findViewById(R.id.txtPercentagers);
        txtresult = (TextView)view.findViewById(R.id.txtResult);
        btnRetry=(Button)view.findViewById(R.id.btnRetryrs);
    }

    public static Result newInstance( DataLogin dataLogin) {
        //Truyen du lieu tu fragment Login sang fragment Result
        Bundle args = new Bundle();
        args.putParcelable("KEY", dataLogin);
        Result fragment = new Result();
        fragment.setArguments(args);
        return fragment;
    }
}
