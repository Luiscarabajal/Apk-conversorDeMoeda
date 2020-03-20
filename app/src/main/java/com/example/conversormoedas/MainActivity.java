package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder(); //usando o m para localizar rapido quando dou m. ponto
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_calculate){
            String value = this.mViewHolder.editValue.getText().toString();
            if("".equals(value)){
                //Mostrar mensagem para usuario
                Toast.makeText(this,this.getString( R.string.informe_valor),Toast.LENGTH_LONG).show();
            }else{
                Double real = Double.valueOf(value);//convertendo a String values
                this.mViewHolder.textDolar.setText(String.format("%.2f",(real/4))); //usando duas casas decimais
                this.mViewHolder.textEuro.setText(String.format("%.2f",(real/5))); //usando duas casas decimais

            }
        }
    }

    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    //privete quer dizer que apenas essa classe MainActivity tem acesso de fora não tem acesso
    // static para garantir que ViewHolder sera chamado só uma vez
    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
