package fedulova.polina303.perekluchateli_and_dialogovie_okna;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import fedulova.polina303.perekluchateli_and_dialogovie_okna.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null; //инициализируем объект привязки C Sharp в файле build.gradleModule

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());//создание объекта привязки
        //setContentView(R.layout.activity_main); было
        setContentView(binding.getRoot()); //стало

        metodOtslejivaniaNajatia();//метод в код добавляем слушатели на кнопки
    }

    private void metodOtslejivaniaNajatia() {
        binding.buttonCalculate.setOnClickListener(new View.OnClickListener() /*установить слушатель нажатий на buttonCalculate*/ {
            @Override
            public void onClick(View view) {
                Double result= 0.0;
                String cheque = "Чек\n";

                if (binding.checkBoxApple.isChecked() &&
                        !binding.editTextKolvoApple.getText().toString().isEmpty() &&
                        !binding.editTextPriceApple.getText().toString().isEmpty()) {
                    Double kolvo = Double.parseDouble(binding.editTextKolvoApple.getText().toString());
                    Double price = Double.parseDouble(binding.editTextPriceApple.getText().toString());
                    result += kolvo * price;
                    cheque += "Apple: " + kolvo.toString() + " * " + price.toString() + " = " + kolvo * price + " руб." + "\n";
                }
                if (binding.checkBoxStrawberry.isChecked() &&
                        !binding.editTextKolvoStrawberry.getText().toString().isEmpty() &&
                        !binding.editTextPriceStrawberry.getText().toString().isEmpty()) {
                    Double kolvo = Double.parseDouble(binding.editTextKolvoStrawberry.getText().toString());
                    Double price = Double.parseDouble(binding.editTextPriceStrawberry.getText().toString());
                    result += kolvo * price;
                    cheque += "Strawberry: " + kolvo.toString() + " * " + price.toString() + " = " + kolvo * price + " руб." + "\n";
                }
                if (binding.checkBoxBlueberry.isChecked() &&
                        !binding.editTextKolvoBlueberry.getText().toString().isEmpty() &&
                        !binding.editTextPriceBlueberry.getText().toString().isEmpty()) {
                    Double kolvo = Double.parseDouble(binding.editTextKolvoBlueberry.getText().toString());
                    Double price = Double.parseDouble(binding.editTextPriceBlueberry.getText().toString());
                    result += kolvo * price;
                    cheque += "Blueberry: " + kolvo.toString() + " * " + price.toString() + " = " + kolvo * price + " руб." + "\n";
                }
                if (binding.checkBoxPotatoes.isChecked() &&
                        !binding.editTextKolvoPotatoes.getText().toString().isEmpty() &&
                        !binding.editTextPricePotatoes.getText().toString().isEmpty()) {
                    Double kolvo = Double.parseDouble(binding.editTextKolvoPotatoes.getText().toString());
                    Double price = Double.parseDouble(binding.editTextPricePotatoes.getText().toString());
                    result += kolvo * price;
                    cheque += "Potatoes: " + kolvo.toString() + " * " + price.toString() + " = " + kolvo * price + " руб." + "\n";
                }
                cheque += "НДС(13%): " + result * 0.13 + "\n";
                cheque += "Итого: " + result + " руб." + "\n";

                if(binding.radioButtonVivodTextView.isChecked()) /*вывод текста в TextView*/{
                    binding.textViewItog.setText(cheque);

                }

                if(binding.radioButtonVivodDialogWindow.isChecked()) /*вывод текста в DialogWindow*/{
                    AlertDialog dialog = createDialog(cheque);
                    dialog.show();
                }

                if(binding.radioButtonVivodToast.isChecked()) /*вывод текста в Toast*/{
                    Toast.makeText(getApplicationContext(), cheque, Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.checkBoxApple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() /*установить слушатель на checkBoxApple*/{
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) /*если cheked == true*/{
                    binding.editTextKolvoApple.setEnabled(true);
                    binding.editTextPriceApple.setEnabled(true);
                }
                else {
                    binding.editTextKolvoApple.setEnabled(false);
                    binding.editTextPriceApple.setEnabled(false);
                }
            }
        });

        binding.checkBoxStrawberry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() /*установить слушатель на checkBoxStrawberry*/{
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    binding.editTextKolvoStrawberry.setEnabled(true);
                    binding.editTextPriceStrawberry.setEnabled(true);
                }
                else {
                    binding.editTextKolvoStrawberry.setEnabled(false);
                    binding.editTextPriceStrawberry.setEnabled(false);
                }
            }
        });

        binding.checkBoxBlueberry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() /*установить слушатель на checkBoxBlueberry*/ {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    binding.editTextKolvoBlueberry.setEnabled(true);
                    binding.editTextPriceBlueberry.setEnabled(true);
                }
                else {
                    binding.editTextKolvoBlueberry.setEnabled(false);
                    binding.editTextPriceBlueberry.setEnabled(false);
                }
            }
        });

        binding.checkBoxPotatoes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() /*установить слушатель на checkBoxPotatoes*/ {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    binding.editTextKolvoPotatoes.setEnabled(true);
                    binding.editTextPricePotatoes.setEnabled(true);
                }
                else {
                    binding.editTextKolvoPotatoes.setEnabled(false);
                    binding.editTextPricePotatoes.setEnabled(false);
                }
            }
        });

        binding.radioButtonVivodTextView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()  /*установить слушатель на radioButtonVivodTextView*/{
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
                    binding.textViewItog.setVisibility(View.VISIBLE);
                }
                else{
                    binding.textViewItog.setVisibility(View.GONE);//не видно текствью
                }
            }
        });

    }

    //Метод для вывода DialogVindow
    @NonNull
    public AlertDialog createDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Чек")
                .setMessage(message)
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Закрываем диалоговое окно
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}