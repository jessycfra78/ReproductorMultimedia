package com.example.reproductormultimedia;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Musica extends AppCompatActivity {

    Button play_pause, btn_repetir;
    ImageView imgView;
    int repetir = 2, posicion = 0;

    MediaPlayer arrayMusica[] = new MediaPlayer [4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        imgView = (ImageView)findViewById(R.id.imageView);

        arrayMusica[0] = MediaPlayer.create(this, R.raw.segundomovimiento);
        arrayMusica[1] = MediaPlayer.create(this, R.raw.sound);
        arrayMusica[2] = MediaPlayer.create(this, R.raw.tea);
        arrayMusica[3] = MediaPlayer.create(this,R.raw.race);
    }

    //Método para el botón PlayPause
    public void PlayPause(View view){
        if(arrayMusica[posicion].isPlaying()){
            arrayMusica[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            arrayMusica[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para el botón Stop
    public void Stop(View view){
        if(arrayMusica[posicion] != null){
            arrayMusica[posicion].stop();

            arrayMusica[0] = MediaPlayer.create(this, R.raw.segundomovimiento);
            arrayMusica[1] = MediaPlayer.create(this, R.raw.sound);
            arrayMusica[2] = MediaPlayer.create(this, R.raw.tea);
            arrayMusica[3] = MediaPlayer.create(this,R.raw.race);
            posicion = 0;
            play_pause.setBackgroundResource(R.drawable.reproducir);
            imgView.setImageResource(R.drawable.portada1);
            Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        }
    }

    //Método repetir una pista
    public void Repetir(View view){
        if(repetir == 1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            arrayMusica[posicion].setLooping(false);
            repetir = 2;
            Toast.makeText(this, "Modo repeticion desactivado", Toast.LENGTH_SHORT).show();
        } else {
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            arrayMusica[posicion].setLooping(true);
            repetir = 1;
            Toast.makeText(this, "Modo repeticion activado", Toast.LENGTH_SHORT).show();
        }

    }

    //Método para saltar a la siguiente canción.
    public void Siguiente(View view){
        if(posicion < arrayMusica.length -1){

            if(arrayMusica[posicion].isPlaying()){
                arrayMusica[posicion].stop();
                posicion++;
                arrayMusica[posicion].start();

                if(posicion == 0){
                    imgView.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    imgView.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    imgView.setImageResource(R.drawable.portada3);
                }

            } else {
                posicion++;

                if(posicion == 0){
                    imgView.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    imgView.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    imgView.setImageResource(R.drawable.portada3);
                }
            }

        } else {
            Toast.makeText(this, "No quedan más canciones", Toast.LENGTH_SHORT).show();
        }
    }


    //Método para regresar a la canción anterior
    public void Anterior(View view){
        if(posicion >= 1){

            if(arrayMusica[posicion].isPlaying()){
                arrayMusica[posicion].stop();
                arrayMusica[0] = MediaPlayer.create(this, R.raw.segundomovimiento);
                arrayMusica[1] = MediaPlayer.create(this, R.raw.sound);
                arrayMusica[2] = MediaPlayer.create(this, R.raw.tea);
                arrayMusica[3] = MediaPlayer.create(this,R.raw.race);
                posicion--;

                if(posicion == 0){
                    imgView.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    imgView.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    imgView.setImageResource(R.drawable.portada3);
                }

                arrayMusica[posicion].start();

            } else {
                posicion--;

                if(posicion == 0){
                    imgView.setImageResource(R.drawable.portada1);
                } else if(posicion == 1){
                    imgView.setImageResource(R.drawable.portada2);
                }else if(posicion == 2){
                    imgView.setImageResource(R.drawable.portada3);
                }
            }

        } else {
            Toast.makeText(this, "No quedan más canciones", Toast.LENGTH_SHORT).show();
        }
    }
}

