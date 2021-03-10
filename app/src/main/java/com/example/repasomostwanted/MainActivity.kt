package com.example.repasomostwanted

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mp = MediaPlayer.create(this, R.raw.heroes)
        mp.start()

        contribuciones.setOnClickListener {
            var url = "https://mpago.la/1PMQdWc"
            val i_contribuciones = Intent(Intent.ACTION_VIEW)
            i_contribuciones.setData(Uri.parse(url))
            startActivity(i_contribuciones)
        }

        contribucion_cartel.setOnClickListener {
            var url = "https://mpago.la/1PMQdWc"
            val i_contribuciones = Intent(Intent.ACTION_VIEW)
            i_contribuciones.setData(Uri.parse(url))
            startActivity(i_contribuciones)
        }

       compilado.setOnClickListener {
            var url = "https://drive.google.com/file/d/1PQTt-RfTx9c6Gp4sFdbHx4QWMqwM0Pmh/view?usp=sharing"
            val i_contribuciones = Intent(Intent.ACTION_VIEW)
            i_contribuciones.setData(Uri.parse(url))
            startActivity(i_contribuciones)
        }

        cursos.setOnClickListener {
            var url = "https://sites.google.com/view/bohemcapacitaciones/"
            val i_contribuciones = Intent(Intent.ACTION_VIEW)
            i_contribuciones.setData(Uri.parse(url))
            startActivity(i_contribuciones)
        }






        listener(intro)
        listener(celula)
        listener(infrep)
        listener(hemo)
        listener(genetica)
        listener(inmuno)
        listener(neo)
        listener(infecciosas)
        listener(ambnut)
        listener(lacinfancia)
        listener(vasos)
        listener(cora)
        listener(leuco)
        listener(eritro)
        listener(pulmon)
        listener(cabcue)
        listener(diges)
        listener(higado)
        listener(pancreas)
        listener(riñon)
        listener(masculino)
        listener(femenino)
        listener(mama)
        listener(endocrino)
        listener(piel)
        listener(huesos)
        listener(nervios)
        listener(snc)
        listener(ojo)
        listener(repasofinal)


    }

    fun listener(id: Button) {
        id.setOnClickListener {

            val intento = Intent(this, Preguntas::class.java)
            intento.putExtra("tema_seleccionado", id.hint.toString())

            startActivity(intento)


        }
    }


    override fun onPause() {
        mp.stop()
        super.onPause()
    }
//
//    override fun onStop() {
//        super.onStop()
//    }
//    override fun onRestart() {
//        super.onRestart()
//    }
//    override fun onDestroy() {
//        super.onDestroy()
//    }
}