package tw.edu.ntut.csie.app01_105590025;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtGrade;
        private Button mBtnOK;
        private TextView mTxtR;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mEdtGrade = (EditText) findViewById(R.id.edtGrade);
            mBtnOK = (Button) findViewById(R.id.btnOK);
            mTxtR = (TextView) findViewById(R.id.txtR);

        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    protected String LetterGrade(int score){
        String strSug = "";
        if (score > 100) {
            strSug +="grade = X";
        } else if (score >= 90) {
            strSug += "grade = A";
        } else if (score >=80){
            strSug += "grade = B";
        } else if (score >= 70) {
            strSug += "grade = C";
        } else if (score >= 60) {
            strSug += "grade = D";
        } else if (score >= 0) {
            strSug += "grade = F";
        } else  {
            strSug += "grade = X";
        }
        return  strSug;
    }


    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int iGrade = Integer.parseInt(mEdtGrade.getText().toString());

            String strSug = "";
            strSug += LetterGrade(iGrade);
            if(Objects.equals(strSug, "grade = X"))
                strSug = "輸入分數應介於[0..100]";

            mTxtR.setText(strSug);
        }
    };

}
