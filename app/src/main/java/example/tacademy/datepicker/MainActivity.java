package example.tacademy.datepicker;



import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView et_startdate;
    private int iYear, iMonth, iDay;
    static final int DATE_DIALOG_ID = 0;
    View tempv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO Auto-generated method stub
        setContentView(R.layout.activity_main);

        Init();
        et_startdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tempv = v;
                showDialog(DATE_DIALOG_ID);
            }
        });

    }

    public void Init() {
        et_startdate = (TextView) findViewById(R.id.ET_StartDate);


        final Calendar objTime = Calendar.getInstance();
        iYear = objTime.get(Calendar.YEAR);
        iMonth = objTime.get(Calendar.MONTH);
        iDay = objTime.get(Calendar.DAY_OF_MONTH);
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener,
                        iYear, iMonth, iDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    // TODO Auto-generated method stub
                    iYear = year;
                    iMonth = monthOfYear;
                    iDay = dayOfMonth;
                    if (tempv.getId() == R.id.ET_StartDate) {
                        et_startdate.setText(""+iYear+"-"+(iMonth+1)+"-"+iDay);
                    }
                }
            };
}