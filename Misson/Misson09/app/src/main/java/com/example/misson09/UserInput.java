package com.example.misson09;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UserInput extends Fragment {

    TextView name;
    TextView age;
    Button day;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 mm월 yy일");
    Date selectedDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_userinput, container, false);

        name = rootView.findViewById(R.id.editName);
        age = rootView.findViewById(R.id.editAge);
        day = rootView.findViewById(R.id.editDate);

        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDate();
            }
        });

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = "이름 : " + name.getText().toString();
                String strAge = "나이 : " + age.getText().toString();
                String strDay = "생년월일 : " + day.getText().toString();
                String str = strName + "\n" + strAge + "\n" + strDay;

                Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
            }
        });


        Date curDate = new Date();

        Log.e("123", curDate + "  d");
        setSelectedDate(curDate);

        return rootView;
    }


    public void showDate() {
        String birthDateStr = day.getText().toString();

        Calendar calendar = Calendar.getInstance();
        Date curBirthDate = new Date();
        try {
            curBirthDate = dateFormat.parse(birthDateStr);
            Log.e("1234", birthDateStr + "11535");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        calendar.setTime(curBirthDate);

        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH);
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getContext(), birthDateSetListener, curYear, curMonth, curDay);
        dialog.show();
    }


    private DatePickerDialog.OnDateSetListener birthDateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar selectedCalendar = Calendar.getInstance();
            selectedCalendar.set(Calendar.YEAR, year);
            selectedCalendar.set(Calendar.MONTH, monthOfYear);
            selectedCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            Date curDate = selectedCalendar.getTime();
            Log.e("123", curDate + "  df");
            setSelectedDate(curDate);
        }
    };

    private void setSelectedDate(Date curDate) {
        selectedDate = curDate;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);

        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH) + 1;
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);

        String selectedDateStr = dateFormat.format(curDate);
        day.setText(curYear + "년 " + curMonth + "월" + curDay + "일");
    }

}