package com.example.repasomostwanted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_historia.*
import kotlinx.android.synthetic.main.activity_preguntas.*
class Historia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historia)


    }

    }
/*
        when {
    arbuenas.count() == 0 -> {
        //tv1.text = "Todavia no tenes puntos"
        tv3.text = "No hay preguntas contestadas bien"

    }
    arbuenas.count() == 1 -> {
       // tv1.text = "Tenés 1 punto"
        tv3.text = "Numero de la pregunta contestada bien\n" + arbuenas.toString()


    }
    arbuenas.count() >= 2 -> {
       // tv1.text = "Tenés " + arbuenas.count().toString() + " puntos"
        tv3.text = "Numeros de las preguntas contestadas bien\n" + arbuenas.sorted().toString()

    }
}
        when{
    armalas.count()==0->{tv2.text="No hay preguntas contestadas mal"}
    armalas.count()==1->{tv2.text = "Numero de la pregunta contestada mal\n" + armalas.sorted().toString()}
    armalas.count()>=2->{ tv2.text = "Numeros de las preguntas contestadas mal\n" + armalas.sorted().toString()}
}

        btn_conteo.setOnClickListener {

            arbuenas.clear()
            armalas.clear()
           // tv1.text="Todavía no tenes puntos"
            tv3.text="No hay preguntas contestadas bien"
            tv2.text="No hay preguntas contestadas mal"
            //s1=1
            s2=1
            haymalas=false
        }


            /*btn1.setOnClickListener {
            if(armalas.count()>=1) {
                var intento = Intent(this, Preguntas::class.java)
                haymalas=true
                startActivity(intento)

            }
            else{
                    Toast.makeText(this, "No hay malas!", Toast.LENGTH_SHORT).show()

                }

        }
*/
        btn2.setOnClickListener {
            arbuenas.clear()
            armalas.clear()
            // tv1.text="Todavía no tenes puntos"
            tv3.text="No hay preguntas contestadas bien"
            tv2.text="No hay preguntas contestadas mal"
            //s1=1
            s2=1
            haymalas=false
            var intento= Intent(this, MainActivity::class.java)
            startActivity(intento)

        }

    }
}*/