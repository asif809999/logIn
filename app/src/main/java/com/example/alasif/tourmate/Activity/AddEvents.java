package com.example.alasif.tourmate.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.example.alasif.tourmate.R;
import java.util.Calendar;

public class AddEvents extends AppCompatActivity {

    EditText startDateEditText, endDateEditText;
    int from_year, from_month, from_day,to_year,to_month,to_day;
    static final int DIALOG_ID_FOR_START_DATE = 0;
    static final int DIALOG_ID_FOR_END_DATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        //initialize to current date/month/year
        final Calendar calendar = Calendar.getInstance();
        from_day = calendar.get(Calendar.DAY_OF_MONTH);
        from_month = calendar.get(Calendar.MONTH);
        from_year = calendar.get(Calendar.YEAR);

        //assume two day trip
        to_day = calendar.get(Calendar.DAY_OF_MONTH) + 2;
        to_month = calendar.get(Calendar.MONTH);
        to_year = calendar.get(Calendar.YEAR);

        showDialogForStartDate();
        showDialogForEndDate();
    }
    // show the date dialog box for the start date
    public void showDialogForStartDate(){
        startDateEditText = (EditText) findViewById(R.id.eventStartDate);
        startDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID_FOR_START_DATE);
            }
        });

    }
    // show the date dialog box for the end date
    private void showDialogForEndDate() {
        endDateEditText = (EditText) findViewById(R.id.eventEndDate);
        endDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID_FOR_END_DATE);
            }
        });
    }
    /**
     * pass DIALOG_ID and get specified result
     * @param id
     * @return the date
     */
    @Override
    protected Dialog onCreateDialog(int id){

        switch(id){
            case DIALOG_ID_FOR_START_DATE:
                return new DatePickerDialog(this, datePickerListenerForStartDate, from_year, from_month, from_day);
            case DIALOG_ID_FOR_END_DATE:
                return new DatePickerDialog(this, datePickerListenerForEndDate, to_year, to_month, to_day);
        }
        return null;
    }
    // set the starting date into the EditText
    private DatePickerDialog.OnDateSetListener datePickerListenerForStartDate
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            from_year = year;
            from_month = month;
            from_day = dayOfMonth;
            Toast.makeText(getApplicationContext(), from_day +"/"+ from_month +"/"+ from_year,Toast.LENGTH_SHORT).show();
            String date = from_day + "/" + (from_month + 1) + "/" + from_year;
            startDateEditText.setText(date);
        }
    };
    // set the ending date into the EditText
    private DatePickerDialog.OnDateSetListener datePickerListenerForEndDate
            = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            to_year = year;
            to_month = month;
            to_day = dayOfMonth;
            Toast.makeText(getApplicationContext(), to_day +"/"+ to_month +"/"+ to_year,Toast.LENGTH_SHORT).show();
            String date = to_day + "/" + (to_month + 1) + "/" + to_year;
            endDateEditText.setText(date);
        }
    };
}
