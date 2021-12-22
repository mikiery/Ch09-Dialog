package tw.tcnr05.m0901;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class M0901 extends AppCompatActivity implements View.OnClickListener {

    private Button b001;
    private Button b002;
    private TextView t001;
    private int monthOfYear;
    private String u_time="";
    private String u_date="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0901);
        setupViewConpmont();

    }

    private void setupViewConpmont() {

        b001=(Button)findViewById(R.id.m0901_b001);
        b002=(Button)findViewById(R.id.m0901_b002);
        t001=(TextView)findViewById(R.id.m0901_t001);
        b001.setOnClickListener(this);
        b002.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        t001.setText("");
        Calendar now= Calendar.getInstance();



        switch (v.getId()){

            case R.id.m0901_b001:
                DatePickerDialog datePicDig=new DatePickerDialog(
                        this,
                        datePicDlgOnDateSelLis,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)

                        );
                datePicDig.setTitle(getString(R.string.m0901_datetitle));
                datePicDig.setMessage(getString(R.string.m0901_datemessage));
                datePicDig.setCancelable(false);
                datePicDig.show();

                break;


            case R.id.m0901_b002:
              TimePickerDialog timePicDig=new TimePickerDialog(

                      this,
                      TimePicDlgOnDateSelLis,
                      now.get(Calendar.HOUR_OF_DAY),
                      now.get(Calendar.MINUTE),
                   false


                      );
                timePicDig.setTitle(getString(R.string.m0901_timetitle));
                timePicDig.setMessage(getString(R.string.m0901_timemessage));
                timePicDig.setCancelable(false);
                timePicDig.show();


                break;






        }
    }

    private DatePickerDialog.OnDateSetListener datePicDlgOnDateSelLis=new DatePickerDialog.OnDateSetListener() {


        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {



            u_date = Integer.toString(year) + getString(R.string.n_yy) +
                    Integer.toString(month+ 1) + getString(R.string.n_mm) +
                    Integer.toString(dayOfMonth) + getString(R.string.n_dd);
            t001.setText(getString(R.string.m0901_datetitle) +
                    u_date + "\n " + u_time);

        }
    };

    private TimePickerDialog.OnTimeSetListener TimePicDlgOnDateSelLis= new TimePickerDialog.OnTimeSetListener() {


        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            u_time = getString(R.string.m0901_timetitle) +
                    Integer.toString(hourOfDay) + getString(R.string.d_hh) +
                    Integer.toString(minute) + getString(R.string.d_mm);
            t001.setText(getString(R.string.m0901_datetitle) +
                    u_date + "\n" + u_time);
        }
    };


}