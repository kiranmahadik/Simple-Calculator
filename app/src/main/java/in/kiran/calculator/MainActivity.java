package in.kiran.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnZero,mBtnOne,mBtnTwo,mBtnThree,mBtnFour,mBtnFive,mBtnSix,mBtnSeven,mBtnEight,mBtnNine;
    private Button mBtnAdd,mBtnSubtract,mBtnMultiply,mBtnDivide,mBtnClear,mBtnEqual;
    private TextView mTvOperation;
    private TextView mTvResult;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = 0;

    private double number1 = Double.NaN;
    private double number2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnZero = findViewById(R.id.btnZero);
        mBtnOne = findViewById(R.id.btnOne);
        mBtnTwo = findViewById(R.id.btnTwo);
        mBtnThree = findViewById(R.id.btnThree);
        mBtnFour = findViewById(R.id.btnFour);
        mBtnFive = findViewById(R.id.btnFive);
        mBtnSix = findViewById(R.id.btnSix);
        mBtnSeven = findViewById(R.id.btnSeven);
        mBtnEight = findViewById(R.id.btnEight);
        mBtnNine = findViewById(R.id.btnNine);

        mBtnAdd = findViewById(R.id.btnAdd);
        mBtnSubtract = findViewById(R.id.btnSubtract);
        mBtnMultiply = findViewById(R.id.btnMultiply);
        mBtnDivide = findViewById(R.id.btnDivide);
        mBtnClear = findViewById(R.id.btnClear);
        mBtnEqual = findViewById(R.id.btnEqual);

        mTvOperation = findViewById(R.id.tvOperation);
        mTvResult = findViewById(R.id.tvResult);

        mBtnZero.setOnClickListener(this);
        mBtnOne.setOnClickListener(this);
        mBtnTwo.setOnClickListener(this);
        mBtnThree.setOnClickListener(this);
        mBtnFour.setOnClickListener(this);
        mBtnFive.setOnClickListener(this);
        mBtnSix.setOnClickListener(this);
        mBtnSeven.setOnClickListener(this);
        mBtnEight.setOnClickListener(this);
        mBtnNine.setOnClickListener(this);

        mBtnAdd.setOnClickListener(this);
        mBtnSubtract.setOnClickListener(this);
        mBtnMultiply.setOnClickListener(this);
        mBtnDivide.setOnClickListener(this);
        mBtnEqual.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.btnZero):
                mTvOperation.setText(mTvOperation.getText().toString()+ "0");
                break;

            case (R.id.btnOne):
                mTvOperation.setText(mTvOperation.getText().toString()+ "1");
                break;

            case (R.id.btnTwo):
                mTvOperation.setText(mTvOperation.getText().toString()+ "2");
                break;

            case (R.id.btnThree):
                mTvOperation.setText(mTvOperation.getText().toString()+ "3");
                break;

            case (R.id.btnFour):
                mTvOperation.setText(mTvOperation.getText().toString()+ "4");
                break;

            case (R.id.btnFive):
                mTvOperation.setText(mTvOperation.getText().toString()+ "5");
                break;

            case (R.id.btnSix):
                mTvOperation.setText(mTvOperation.getText().toString()+ "6");
                break;

            case (R.id.btnSeven):
                mTvOperation.setText(mTvOperation.getText().toString()+ "7");
                break;

            case (R.id.btnEight):
                mTvOperation.setText(mTvOperation.getText().toString()+ "8");
                break;

            case (R.id.btnNine):
                mTvOperation.setText(mTvOperation.getText().toString()+ "9");
                break;

            case (R.id.btnAdd):
                compute();
                ACTION = ADDITION;
                mTvResult.setText(String.valueOf(number1) + "+");
                mTvOperation.setText(null);
                break;

            case (R.id.btnSubtract):
                compute();
                ACTION = SUBTRACTION;
                mTvResult.setText(String.valueOf(number1) + "-");
                mTvOperation.setText(null);
                break;

            case (R.id.btnMultiply):
                compute();
                ACTION = MULTIPLICATION;
                mTvResult.setText(String.valueOf(number1) + "*");
                mTvOperation.setText(null);
                break;

            case (R.id.btnDivide):
                compute();
                ACTION = DIVISION;
                mTvResult.setText(String.valueOf(number1) + "/");
                mTvOperation.setText(null);
                break;

            case (R.id.btnEqual):
                compute();
                ACTION = EQUAL;
                mTvResult.setText(mTvResult.getText().toString() + String.valueOf(number2) + "=" + String.valueOf(number1));
                mTvOperation.setText(null);
                break;

            case (R.id.btnClear):
                if(mTvOperation.getText().length() > 0 ){
                    CharSequence name = mTvOperation.getText().toString();
                    mTvOperation.setText(name.subSequence(0,name.length()-1));
                }else {
                    number1 = Double.NaN;
                    number2 = Double.NaN;
                    mTvOperation.setText(null);
                    mTvResult.setText(null);
                }
                break;
        }
    }

    private void compute(){
        if(!Double.isNaN(number1)){
            number2 = Double.parseDouble(mTvOperation.getText().toString());

            switch(ACTION){
                case ADDITION:
                    number1 = number1 + number2;
                    break;

                case SUBTRACTION:
                    number1 = number1 - number2;
                    break;

                case DIVISION:
                    number1 = number1 / number2;
                    break;

                case MULTIPLICATION:
                    number1 = number1 * number2;
                    break;

                case EQUAL :
                    break;

            }
        }else {
            number1 = Double.parseDouble(mTvOperation.getText().toString());
        }

    }
}
